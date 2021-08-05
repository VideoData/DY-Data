package com.haowen.bare.parse.parser;

import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 快手解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取html内容
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> null
 * 封面 -> data -> item_info -> cover
 * 视频 -> data -> item_info -> url
 * ==============================================================
 */
@Component
public class KuaiShouParser implements BareParser {

    /**
     * 方法描述:短视频解析
     *
     * @param url 链接地址
     */
    @Override
    public BareResult parse(String url) throws IOException {
        Document document = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getOne())
                .get();

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 封面
        String cover = regexCoverUrl(document.getElementsByClass("poster-content").attr("style"));

        Element videoElement = document.getElementsByTag("video").get(0);
        // 标题
        String title = videoElement.attr("alt");

        // 视频
        String videoUrl = videoElement.attr("src");

        result.setTitle(title)
                .setCover(new BareResult.Image(cover))
                .getVideos().add(new BareResult.Video(videoUrl, null, null, null));

        return result;
    }

    /**
     * 方法描述: 正则获取封面图
     *
     * @param style 网页内容
     */
    public static String regexCoverUrl(String style) {
        // 匹配网址
        String regex = "background-image:url\\((.*?)\\);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(style);
        if (m.find()) {
            return style.substring(m.start(), m.end())
                    .replace("background-image:url(", "")
                    .replace(");", "");
        }
        return "";
    }
}
