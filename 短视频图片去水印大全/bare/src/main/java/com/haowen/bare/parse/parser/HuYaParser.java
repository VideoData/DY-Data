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

/**
 * 虎牙解析器
 */
@Component
public class HuYaParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://liveapi.huya.com/moment/getMomentContent?videoId=";

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

        // 获取jsonStr
        String jsonStr = Jsoup
                .connect(API + getId(url))
                .userAgent(UserAgentUtil.getOne())
                .referrer("https://v.huya.com/")
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject videoInfoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("moment")
                .getJSONObject("videoInfo");

        // 标题、封面
        result.setTitle(videoInfoObject.getStr("videoTitle"))
                .setCover(new BareResult.Image(videoInfoObject.getStr("videoCover")));

        JSONArray videoInfoList = videoInfoObject.getJSONArray("definitions");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    item.getStr("url"),
                    item.getStr("defName"),
                    item.getInt("width"),
                    item.getInt("height")
            ));
        }

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getId(String url) {
        int start = url.indexOf("/fans/") + "/fans/".length();
        int end = url.lastIndexOf("?");
        return url.substring(start, end).replace(".html", "");
    }
}
