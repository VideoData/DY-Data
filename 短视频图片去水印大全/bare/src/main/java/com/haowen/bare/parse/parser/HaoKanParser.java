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
 * 好看解析器
 */
@Component
public class HaoKanParser implements BareParser {

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
        JSONObject videoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("curVideoMeta");

        // 标题、封面
        result.setTitle(videoObject.getStr("title"))
                .setCover(new BareResult.Image(videoObject.getStr("poster")));

        JSONArray videoInfoList = videoObject.getJSONArray("clarityUrl");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            String vodVideoHW = item.getStr("vodVideoHW");
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    item.getStr("title"),
                    Integer.parseInt(vodVideoHW.split("\\$\\$")[0]),
                    Integer.parseInt(vodVideoHW.split("\\$\\$")[1])
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
        String regex = "window.__PRELOADED_STATE__\\s=\\s\\{(.*?)\\};";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("window.__PRELOADED_STATE__ = ", "")
                    .replace(";", "");
        }
        return "";
    }
}
