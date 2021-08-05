package com.haowen.bare.parse.parser;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.URLUtil;
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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 梨视频解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向定制
 * 1. 获取分享链接ID（路径形式）
 * 2. 请求接口获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> null
 * 封面 -> data -> videoInfo => (video_image, null, null)
 * 视频 -> data -> videoInfo -> videos => (srcUrl, null, null, null)
 * ==============================================================
 */
@Component
public class LiShiPinParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://www.pearvideo.com/videoStatus.jsp";

    /**
     * 方法描述: 获取无水印资源信息
     *
     * @param url 复制的链接
     * @return 无水印资源信息
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        String userAgent = UserAgentUtil.getOne();
        String realUrl = UrlUtil.getRealUrl(userAgent, url);
        String[] split = realUrl.split("\\?")[0].split("/");

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("contId", split[split.length - 1].split("_")[1]);
        paramMap.put("mrd", String.valueOf(RandomUtil.randomDouble()));
        String paramStr = URLUtil.buildQuery(paramMap, StandardCharsets.UTF_8);

        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + "?" + paramStr)
                .userAgent(userAgent)
                .header("Referer", url)
                .ignoreContentType(true)
                .execute()
                .body();

        // 解析无水印资源
        JSONObject videoInfoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("videoInfo");

        // 封面
        result.setCover(new BareResult.Image(videoInfoObject.getStr("video_image")));

        videos.add(new BareResult.Video(videoInfoObject.getJSONObject("videos").getStr("srcUrl")));

        return result;
    }
}
