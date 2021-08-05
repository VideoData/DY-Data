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
 * 绿洲解析器
 */
@Component
public class LvZhouParser implements BareParser {

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取网页信息
        Document document = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getOne())
                .get();

        // 标题
        String title = document.getElementsByClass("content btn-status").get(0).getElementsByClass("title").get(0).text();

        Element videoContainerElement = document.getElementsByClass("video-container").get(0);

        // 封面
        String cover = regexCoverUrl(videoContainerElement.getElementsByClass("finish-wrap").get(0).attr("style"));

        // 视频标签
        Element videoElement = videoContainerElement.getElementsByTag("video").get(0);

        // 视频
        String videoUrl = videoElement.attr("src").replace("&amp;", "");

        // 标题、封面
        result.setTitle(title)
                .setCover(new BareResult.Image(cover));

        // 视频
        videos.add(new BareResult.Video(videoUrl));

        return result;
    }

    /**
     * 方法描述: 正则获取封面图
     *
     * @param style 网页内容
     */
    public static String regexCoverUrl(String style) {
        // 匹配网址
        String regex = "background-image:url\\((.*?)\\)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(style);
        if (m.find()) {
            return style.substring(m.start(), m.end())
                    .replace("background-image:url(", "")
                    .replace(")", "");
        }
        return "";
    }
}
