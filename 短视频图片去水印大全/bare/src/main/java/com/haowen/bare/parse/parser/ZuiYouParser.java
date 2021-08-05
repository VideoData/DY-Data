package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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

/**
 * 最右解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 分享链接获取html内容
 * 2. 获取html里的数据json（正则）
 * 3. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> sharePost -> postDetail -> post -> content
 * 封面 -> sharePost -> postDetail -> post -> imgs[0] -> urls -> originWebp => (urls[0], w, h)
 * 视频 -> sharePost -> postDetail -> post -> videos -> thumb(Var) -> url
 * ==============================================================
 */
@Component
public class ZuiYouParser implements BareParser {

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

        Document document = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getOne())
                .get();

        Element element = document.getElementById("appState");

        String filter = element.html()
                .replace("window.APP_INITIAL_STATE=", "")
                .replace("new Date(", "")
                .replace(")", "");

        JSONObject postObject = JSONUtil.parseObj(filter)
                .getJSONObject("sharePost")
                .getJSONObject("postDetail")
                .getJSONObject("post");

        JSONObject videosObject = postObject.getJSONObject("videos");

        String thumb = "";
        for (String key : videosObject.keySet()) {
            thumb = key;
        }
        JSONObject thumbObject = videosObject.getJSONObject(thumb);

        JSONObject coverObject = postObject.getJSONArray("imgs")
                .getJSONObject(0)
                .getJSONObject("urls")
                .getJSONObject("originWebp");

        // 标题、封面
        result.setTitle(postObject.getStr("content"))
                .setCover(new BareResult.Image(
                        coverObject.getJSONArray("urls").getStr(0),
                        coverObject.getInt("w"),
                        coverObject.getInt("h")
                ));

        // 视频
        String videoUrl = thumbObject.getStr("url");

        videos.add(new BareResult.Video(videoUrl, null, null, null));

        return result;
    }
}
