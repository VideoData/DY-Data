package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 绿洲解析器
 */
@Component
public class MoMoParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://m.immomo.com/inc/microvideo/share/profiles";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取Json
        String jsonStr = Jsoup
                .connect(API)
                .method(Connection.Method.POST)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .data("feedids", getId(url))
                .userAgent(UserAgentUtil.getOne())
                .referrer(url.split("\\?")[0])
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject dataObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONArray("list")
                .getJSONObject(0);

        // 标题、封面
        result.setTitle(dataObject.getStr("content"))
                .setCover(new BareResult.Image(dataObject.getJSONObject("video").getStr("cover_play")));

        // 视频
        videos.add(new BareResult.Video(dataObject.getJSONObject("video").getStr("video_url")));

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getId(String url) {
        int start = url.indexOf("/new-share-v2/") + "/new-share-v2/".length();
        int end = url.lastIndexOf("?");
        return url.substring(start, end).replace(".html", "");
    }
}
