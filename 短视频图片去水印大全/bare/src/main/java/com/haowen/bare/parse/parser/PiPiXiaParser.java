package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.UrlUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 皮皮虾解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 1. 获取分享链接ID（路径形式）
 * 2. 请求接口获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> data -> item -> content
 * 封面 -> data -> data -> item -> origin_video_download -> cover_image => (url_list[0].url, width, height)
 * 视频 -> data -> data -> item -> origin_video_download => (url_list[0].url, null, width, height)
 * ==============================================================
 */
@Component
public class PiPiXiaParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://is.snssdk.com/bds/cell/detail/?cell_type=1&aid=1319&app_name=super&cell_id=";

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
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + getItemId(UrlUtil.getRealUrl(userAgent, url)))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        // 解析无水印资源
        JSONObject itemObject = JSONUtil
                .parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("data")
                .getJSONObject("item");

        JSONObject videoObject = itemObject
                .getJSONObject("origin_video_download");

        JSONObject coverObject = videoObject.getJSONObject("cover_image");

        // 标题、封面
        result.setTitle(itemObject.getStr("content"))
                .setCover(new BareResult.Image(
                        coverObject.getJSONArray("url_list").getJSONObject(0).getStr("url"),
                        coverObject.getInt("width"),
                        coverObject.getInt("height")));

        videos.add(new BareResult.Video(
                videoObject.getJSONArray("url_list").getJSONObject(0).getStr("url"),
                null,
                videoObject.getInt("width"),
                videoObject.getInt("height")));

        return result;
    }

    /**
     * 方法描述: 获取分享视频id
     *
     * @param url 分享链接
     */
    public String getItemId(String url) {
        int start = url.indexOf("/item/") + "/item/".length();
        int end = url.lastIndexOf("?");
        return url.substring(start, end);
    }
}
