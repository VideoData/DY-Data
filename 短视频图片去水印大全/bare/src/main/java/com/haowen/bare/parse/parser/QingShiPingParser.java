package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 轻视频解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取分享链接ID（参数形式）
 * 2. 请求接口获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> title
 * 封面 -> data => (cover_url, cover_width, cover_height)
 * 视频 -> data -> play -> file_info(Array) => (url, null, null, null)
 * ==============================================================
 */
@Component
public class QingShiPingParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://bbq.bilibili.com/bbq/app-bbq/sv/detail?svid=";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        Map<String, List<String>> queryParams = StringUtil.getQueryParams(url);

        String userAgent = UserAgentUtil.getOne();
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + queryParams.get("id").get(0))
                .header("User-Agent", userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject dataObject = JSONUtil
                .parseObj(jsonStr)
                .getJSONObject("data");

        // 标题、封面
        result.setTitle(dataObject.getStr("title"))
                .setCover(new BareResult.Image(
                        dataObject.getStr("cover_url"),
                        dataObject.getInt("cover_width"),
                        dataObject.getInt("cover_height")));

        JSONArray videoInfoList = dataObject
                .getJSONObject("play")
                .getJSONArray("file_info");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    null,
                    null,
                    null
            ));
        }

        return result;
    }
}
