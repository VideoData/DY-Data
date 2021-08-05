package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UrlUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 抖音火山版解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（参数形式）
 * 3. 请求接口获取数据json
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> null
 * 封面 -> data -> item_info -> cover
 * 视频 -> data -> item_info -> url
 * ==============================================================
 */
@Component
public class HuoShanParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://share.huoshan.com/api/item/info?item_id=";

    /**
     * 无水印视频地址
     */
    private static final String BASE_VIDEO_URL = "https://api-hl.huoshan.com/hotsoon/item/video/_playback/?video_id=";

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
        // 获取重定向地址
        String realUrl = UrlUtil.getRealUrl(userAgent, url);

        // 获取URL参数
        Map<String, List<String>> queryParams = StringUtil.getQueryParams(realUrl);

        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + queryParams.get("item_id").get(0))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject itemInfoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("item_info");

        // 封面
        result.setCover(new BareResult.Image(itemInfoObject.getStr("cover")));


        // 解析出有水印的视频
        String videoWmUrl = itemInfoObject.getStr("url");

        BareResult.Video videoResult = new BareResult.Video(
                BASE_VIDEO_URL + StringUtil.getQueryParams(videoWmUrl).get("video_id").get(0),
                null,
                null,
                null);
        videos.add(videoResult);

        return result;
    }
}
