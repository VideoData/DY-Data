package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UrlUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 新片场解析
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（参数形式）
 * 3. 请求接口获取数据json
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> title
 * 封面 -> data -> cover
 * 视频 -> data -> cover -> video -> content -> progressive(Array) => (url, profile, width, height)
 * ==============================================================
 */
@Component
public class XinPianChangParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://app.xinpianchang.com/article/";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        String userAgent = UserAgentUtil.getOne();
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + getItemId(UrlUtil.getRealUrl(userAgent, url)))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject dataObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data");

        // 标题、封面
        result.setTitle(dataObject.getStr("title"))
                .setCover(new BareResult.Image(dataObject.getStr("cover")));

        JSONArray videoInfoList = dataObject.getJSONObject("video")
                .getJSONObject("content")
                .getJSONArray("progressive");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    item.getStr("profile"),
                    item.getInt("width"),
                    item.getInt("height")
            ));
        }

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getItemId(String url) {
        return StringUtil.getQueryParams(url).get("id").get(0);
    }
}
