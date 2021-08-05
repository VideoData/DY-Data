package com.haowen.bare.parse.parser;

import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONArray;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 度小视解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取分享链接ID（参数形式）
 * 2. 请求接口获取数据json
 * 3. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> meta -> title
 * 封面 -> data -> meta -> image
 * 视频 -> data -> meta -> video_info -> clarityUrl(Array) => (url, title, width, height)
 * ==============================================================
 */
@Component
public class DuXiaoShiParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://xspshare.baidu.com/wise/growth/api/sv/immerse?";

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

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("source", queryParams.get("source").get(0));
        paramMap.put("pd", queryParams.get("pd").get(0));
        paramMap.put("vid", queryParams.get("vid").get(0));
        paramMap.put("shareTime", queryParams.get("shareTime").get(0));
        paramMap.put("shareid", queryParams.get("shareid").get(0));
        paramMap.put("shared_cuid", queryParams.get("shared_cuid").get(0));
        paramMap.put("shared_uid", queryParams.get("shared_uid").get(0));
        paramMap.put("_format", "json");
        String paramStr = URLUtil.buildQuery(paramMap, StandardCharsets.UTF_8).toString();

        String jsonStr = Jsoup
                .connect(API + paramStr)
                .userAgent(UserAgentUtil.getOne())
                .referrer(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject metaObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("meta");

        // 标题、封面
        result.setTitle(metaObject.getStr("title"))
                .setCover(new BareResult.Image(metaObject.getStr("image")));

        JSONArray videoInfoList = metaObject.getJSONObject("video_info")
                .getJSONArray("clarityUrl");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    item.getStr("title"),
                    item.getInt("width"),
                    item.getInt("height")
            ));
        }

        return result;
    }
}
