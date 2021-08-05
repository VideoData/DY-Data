package com.haowen.bare.parse.parser;

import cn.hutool.core.util.URLUtil;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微博解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（路劲形式）
 * 3. 请求接口获取数据json
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> null
 * 封面 -> data -> object -> image => (url, width, height)
 * 视频 -> data -> object -> stream => (url, null, width, height)
 * ==============================================================
 */
@Component
public class WeiBoParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://video.h5.weibo.cn/s/video/object";

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

        String realUrl = UrlUtil.getRealUrl(userAgent, url);

        String[] split = realUrl.split("/");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("object_id", split[split.length - 2]);
        paramMap.put("mid", split[split.length - 1]);
        String paramStr = URLUtil.buildQuery(paramMap, StandardCharsets.UTF_8);


        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + "?" + paramStr)
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject object = JSONUtil
                .parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("object");

        JSONObject streamObject = object.getJSONObject("stream");

        // 标题、封面
        result.setTitle(object.getStr("summary"))
                .setCover(new BareResult.Image(
                        object.getJSONObject("image").getStr("url"),
                        object.getJSONObject("image").getInt("width"),
                        object.getJSONObject("image").getInt("height")
                ));

        videos.add(new BareResult.Video(
                streamObject.getStr("url"),
                null,
                streamObject.getInt("width"),
                streamObject.getInt("height")));

        return result;
    }
}
