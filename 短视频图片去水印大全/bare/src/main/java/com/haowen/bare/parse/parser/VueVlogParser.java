package com.haowen.bare.parse.parser;

import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 微博解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取html内容
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> header -> meta(tag) -> property=og:title _> content
 * 封面 -> header -> meta(tag) -> property=og:image _> content
 * 视频 -> header -> meta(tag) => (property=og:video:url _> content, null, property=og:video:width _> content,
 * property=og:video:height _> content)
 * ==============================================================
 */
@Component
public class VueVlogParser implements BareParser {

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
        Document document = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getPC())
                .ignoreContentType(true)
                .get();

        // 标题、封面
        result.setTitle(document.getElementsByAttributeValue("property", "og:title").get(0).attr("content"))
                .setCover(new BareResult.Image(document.getElementsByAttributeValue("property", "og:image").get(0).attr("content")));

        videos.add(new BareResult.Video(
                document.getElementsByAttributeValue("property", "og:video:url").get(0).attr("content"),
                null,
                Integer.parseInt(document.getElementsByAttributeValue("property", "og:video:width").get(0).attr("content")),
                Integer.parseInt(document.getElementsByAttributeValue("property", "og:video:height").get(0).attr("content"))));

        return result;
    }
}
