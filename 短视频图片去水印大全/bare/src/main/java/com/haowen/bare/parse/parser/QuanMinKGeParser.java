package com.haowen.bare.parse.parser;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 全民K歌解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取html内容
 * 2. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> detail -> content
 * 封面 -> detail -> cover
 * 视频 -> detail => (playurl_video, null, null, null)
 * ==============================================================
 */
@Component
public class QuanMinKGeParser implements BareParser {

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取分享资源信息
        String html = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getPC())
                .ignoreContentType(true)
                .execute()
                .body();

        String jsonStr = filter(html);

        JSONObject detailObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("detail");

        // 标题、封面
        result.setTitle(detailObject.getStr("content"))
                .setCover(new BareResult.Image(detailObject.getStr("cover")));

        videos.add(new BareResult.Video(
                detailObject.getStr("playurl_video"),
                null,
                null,
                null
        ));

        return result;
    }

    /**
     * 方法描述: 过滤网页内容的视频信息
     *
     * @param html 网页内容
     */
    public static String filter(String html) {
        // 匹配网址
        String regex = "window.__DATA__\\s=\\s\\{(.*?)\\};";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("window.__DATA__ = ", "")
                    .replace(";", "");
        }
        return "";
    }
}
