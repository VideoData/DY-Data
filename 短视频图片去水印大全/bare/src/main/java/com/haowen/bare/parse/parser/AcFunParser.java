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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AcFun解析器
 * ==============================================================
 * User-Agent PC
 * 1. 分享链接获取html内容
 * 2. 获取html里的数据json（正则）
 * 3. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> title
 * 封面 -> coverUrl
 * 视频 -> currentVideoInfo -> ksPlayJson(JSON String) -> adaptationSet[0] -> representation(Array) =>
 * (url, qualityLabel, width, height)
 * ==============================================================
 */
@Component
public class AcFunParser implements BareParser {

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取html内容
        String html = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getPC())
                .ignoreContentType(true)
                .execute()
                .body();

        // 获取json数据
        String jsonStr = regexJson(html);
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);

        // 标题、封面
        result.setTitle(jsonObject.getStr("title"))
                .setCover(new BareResult.Image(jsonObject.getStr("coverUrl")));

        String playJson = jsonObject
                .getJSONObject("currentVideoInfo")
                .getStr("ksPlayJson");
        JSONArray videoInfoList = JSONUtil.parseObj(playJson)
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
     * 方法描述: 正则获取数据json
     *
     * @param html 网页内容
     */
    public static String regexJson(String html) {
        // 匹配网址
        String regex = "window.videoInfo\\s=\\s(.*?);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("window.videoInfo = ", "")
                    .replace(";", "");
        }
        return "";
    }
}
