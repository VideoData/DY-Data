package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开眼解析器
 */
@Component
public class KaiYanParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://proxy.eyepetizer.net/v1/content/item/get_item_detail_v2";

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        Map<String, List<String>> queryParams = StringUtil.getQueryParams(url);

        // 视频ID
        String videoId = queryParams.get("video_id").get(0);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-type", "application/x-www-form-urlencoded");
        headerMap.put("x-thefair-appid", "xfpa44crf2p70lk8");
        headerMap.put("x-thefair-auth", "8JHDGTy9mkeGg5gvxhnm3du60+I38zKvNabkkwANNr0PS97YgbP3GJwStiBZgQ1Z4TDA8iR9fnPbHN1Rxp7QTOMPU0YBcbKs8F6+TxdtwjKLAa6JJMfAZDP6DZHuSPi1S8qMW739zFedR4aQOa5/QDkKzDOskQB0n+Ur91pNYshFGh7K9bqKzeRYpXPbIEG74G0Lfysha6htUyJ8EW6v++Jt2nNMUIuc6Diea0pCauTXfXy/uQkEmEegQwq/5g7X");
        headerMap.put("x-thefair-cid", "44c6312e40444a5e5e5a726db4e6a542");
        headerMap.put("x-thefair-forward-host", "https://api.eyepetizer.net");
        headerMap.put("x-thefair-ua", "EYEPETIZER_UNIAPP_H5/100000 (android;android;OS_VERSION_UNKNOWN;zh-Hans-CN;h5;1.0.0;cn-bj;SOURCE_UNKNOWN;44c6312e40444a5e5e5a726db4e6a542;1920*1080;NETWORK_UNKNOWN) native/1.0");

        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API)
                .method(Connection.Method.POST)
                .headers(headerMap)
                .userAgent(UserAgentUtil.getOne())
                .referrer("https://m.eyepetizer.net/")
                .data("resource_type", "pgc_video")
                .data("resource_id", videoId)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject videoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("result")
                .getJSONObject("video");

        JSONObject coverObject = videoObject.getJSONObject("cover");


        // 标题、封面
        result.setTitle(videoObject.getStr("title"))
                .setCover(new BareResult.Image(
                        coverObject.getStr("url"),
                        coverObject.getJSONObject("img_info").getInt("width"),
                        coverObject.getJSONObject("img_info").getInt("height")));

        videos.add(new BareResult.Video(videoObject.getStr("play_url"), null, null, null));

        return result;
    }
}
