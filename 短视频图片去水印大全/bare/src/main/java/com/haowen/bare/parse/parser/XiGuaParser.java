package com.haowen.bare.parse.parser;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UrlUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 西瓜视频解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（路径形式）
 * 3. 获取html内容
 * 4. 获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> anyVideo -> gidInformation -> packerData -> video -> title
 * 封面 -> anyVideo -> gidInformation -> packerData -> video -> poster_url
 * 视频 -> anyVideo -> gidInformation -> packerData -> video -> dash -> dynamic_video -> dynamic_video_list =>
 * (main_url, definition, vwidth, vheight)
 * ==============================================================
 */
@Component
public class XiGuaParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://www.ixigua.com/";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        String userAgent = UserAgentUtil.getPC();

        String realUrl = UrlUtil.getRealUrl(userAgent, url);
        String itemId = getItemId(realUrl);

        // 获取分享资源信息
        Document document = Jsoup
                .connect(API + itemId)
                .userAgent(userAgent)
                .header("cookie", "MONITOR_WEB_ID=7892c49b-296e-4499-8704-e47c1b150c18; ixigua-a-s=1; ttcid=" +
                        "af99669b6304453480454f150701d5c226; BD_REF=1; __ac_nonce=060d88ff000a75e8d17eb; " +
                        "__ac_signature=_02B4Z6wo00f01kX9ZpgAAIDAKIBBQUIPYT5F2WIAAPG2ad; " +
                        "ttwid=1%7CcIsVF_3vqSIk4XErhPB0H2VaTxT0tdsTMRbMjrJOPN8%7C1624806049%7C08ce7dd6f7d20506a41ba0a" +
                        "331ef96a6505d96731e6ad9f6c8c709f53f227ab1")
                .ignoreContentType(true)
                .get();

        String jsonStr = document.getElementById("SSR_HYDRATED_DATA").html()
                .replace("window._SSR_HYDRATED_DATA=", "")
                .replace("undefined", "null");

        JSONObject videoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("anyVideo")
                .getJSONObject("gidInformation")
                .getJSONObject("packerData")
                .getJSONObject("video");

        // 标题、封面
        result.setTitle(videoObject.getStr("title"))
                .setCover(new BareResult.Image(videoObject.getStr("poster_url")));

        JSONArray videoInfoList = videoObject.getJSONObject("videoResource")
                .getJSONObject("dash")
                .getJSONObject("dynamic_video")
                .getJSONArray("dynamic_video_list");

        // 视频信息
        for (int i = 0; i < videoInfoList.size(); i++) {
            JSONObject item = videoInfoList.getJSONObject(i);
            videos.add(new BareResult.Video(
                    Base64.decodeStr(item.getStr("main_url")),
                    item.getStr("definition"),
                    item.getInt("vwidth"),
                    item.getInt("vheight")
            ));
        }

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getItemId(String url) {
        int start = url.indexOf("ixigua.com/") + "ixigua.com/".length();
        int end = url.lastIndexOf("?");
        return url.substring(start, end);
    }
}
