package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Before避风解析器
 * ==============================================================
 * User-Agent PC
 * 1. 获取分享链接ID（路径形式）
 * 2. 请求接口获取数据json
 * 3. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> title
 * 封面 -> data -> cover[0](Object) -> (url, width, height)
 * 视频 -> data -> mediaInfoList[0] -> videoInfo -> manifest(Json String) -> adaptationSet[0] ->
 * representation(Array) => (url, qualityLabel, width, height)
 * ==============================================================
 */
@Component
public class BeforeParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://hlg.xiatou.com/h5/feed/detail?id=";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取视频信息
        String jsonStr = Jsoup
                .connect(API + getItemId(url))
                .userAgent(UserAgentUtil.getPC())
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject data = JSONUtil.parseObj(jsonStr)
                .getJSONArray("data")
                .getJSONObject(0);

        JSONObject coverInfo = data.getJSONArray("cover").getJSONObject(0);
        // 标题、封面
        result.setTitle(data.getStr("title"))
                .setCover(new BareResult.Image(
                        coverInfo.getStr("url"),
                        coverInfo.getInt("width"),
                        coverInfo.getInt("height")
                ));

        String videoInfo = data
                .getJSONArray("mediaInfoList")
                .getJSONObject(0)
                .getJSONObject("videoInfo")
                .getStr("manifest");

        JSONArray videoInfoList = JSONUtil.parseObj(videoInfo)
                .getJSONArray("adaptationSet")
                .getJSONObject(0)
                .getJSONArray("representation");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    item.getStr("qualityLabel"),
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
        int start = url.indexOf("/detail/") + "/detail/".length();
        int end = url.lastIndexOf("?");
        return url.substring(start, end);
    }
}
