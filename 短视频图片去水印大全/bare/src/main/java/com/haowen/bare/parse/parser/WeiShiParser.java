package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微视解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取分享链接ID（参数形式）
 * 2. 请求接口获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> feeds[0] -> feed_desc
 * 封面 -> data -> feeds[0] -> video_cover -> static_cover => (url, width, height)
 * 视频 -> data -> feeds[0] -> video_url
 * ==============================================================
 */
@Component
public class WeiShiParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://h5.weishi.qq.com/webapp/json/weishi/WSH5GetPlayPage";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        String feedId = StringUtil.getQueryParams(url).get("id").get(0);

        Map<String, Object> map = new HashMap<>();
        map.put("feedid", feedId);
        map.put("recommendtype", 0);
        map.put("datalvl", "all");
        map.put("_weishi_mapExt", new Object());

        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API)
                .method(Connection.Method.POST)
                .userAgent(UserAgentUtil.getOne())
                .referrer("https://isee.weishi.qq.com/")
                .header("Content-Type", "application/json")
                .requestBody(JSONUtil.toJsonStr(map))
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject feedObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONArray("feeds")
                .getJSONObject(0);

        JSONObject coverObject = feedObject.getJSONObject("video_cover")
                .getJSONObject("static_cover");

        // 标题、封面
        result.setTitle(feedObject.getStr("feed_desc"))
                .setCover(new BareResult.Image(
                        coverObject.getStr("url"),
                        coverObject.getInt("width"),
                        coverObject.getInt("height")));

        videos.add(new BareResult.Video(feedObject.getStr("video_url"), null, null, null));

        return result;
    }
}
