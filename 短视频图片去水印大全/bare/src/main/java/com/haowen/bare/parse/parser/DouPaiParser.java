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
import java.util.List;
import java.util.Map;

/**
 * 逗拍解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取分享链接ID（参数形式）
 * 2. 请求接口获取数据json
 * 3. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> name
 * 封面 -> data -> imageUrl
 * 视频 -> data => (videoUrl, null, width, height)
 * ==============================================================
 */
@Component
public class DouPaiParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://v2.doupai.cc/v3/template/topic/";

    /**
     * 方法描述:短视频解析
     *
     * @param url 链接地址
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        Map<String, List<String>> queryParams = StringUtil.getQueryParams(url);

        String jsonStr = Jsoup
                .connect(API + queryParams.get("id").get(0))
                .referrer("https://p.doupai.cc/")
                .userAgent(UserAgentUtil.getOne())
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject data = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data");

        // 标题、封面
        result.setTitle(data.getStr("name"))
                .setCover(new BareResult.Image(data.getStr("imageUrl")));

        // 视频信息
        videos.add(new BareResult.Video(
                data.getStr("videoUrl"),
                null,
                data.getInt("width"),
                data.getInt("height")
        ));

        return result;
    }
}
