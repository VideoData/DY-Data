package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONNull;
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
 * 抖音解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取重定向地址
 * 2. 获取分享链接ID（路径形式）
 * 3. 请求接口获取数据json
 * 4. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> item_list[0] -> desc
 * 封面 -> item_list[0] -> video -> cover -> url_list[0]
 * 视频 -> item_list[0] -> video => ( -> play_addr -> url_list[0], radio, width, height)
 * --------------------------------------------------------------
 * 图片 -> item_list[0] -> images => (url_list[0], null, null)
 * ==============================================================
 */
@Component
public class DouYinParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";

    /**
     * 方法描述: 获取无水印资源信息
     *
     * @param url 复制的链接
     * @return 无水印资源信息
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult();
        List<BareResult.Video> videos = new ArrayList<>();
        List<BareResult.Image> images = new ArrayList<>();

        String userAgent = UserAgentUtil.getOne();
        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API + getItemId(UrlUtil.getRealUrl(userAgent, url)))
                .userAgent(userAgent)
                .ignoreContentType(true)
                .execute()
                .body();

        // 解析无水印资源
        JSONObject itemFirst = JSONUtil.parseObj(jsonStr)
                .getJSONArray("item_list")
                .getJSONObject(0);

        // 标题、封面
        result.setTitle(itemFirst.getStr("desc"))
                .setCover(new BareResult.Image(itemFirst.getJSONObject("video")
                        .getJSONObject("cover")
                        .getJSONArray("url_list")
                        .getStr(0)));

        if (!JSONNull.NULL.equals(itemFirst.get("images"))) {

            result.setType(MediaType.IMAGE);
            result.setImages(images);

            JSONArray imageJSONArray = itemFirst.getJSONArray("images");
            for (int i = 0; i < imageJSONArray.size(); i++) {
                images.add(new BareResult.Image(
                        imageJSONArray.getJSONObject(i).getJSONArray("url_list").getStr(0),
                        imageJSONArray.getJSONObject(i).getInt("width"),
                        imageJSONArray.getJSONObject(i).getInt("height")
                ));
            }
        } else {
            JSONObject videoObject = itemFirst.getJSONObject("video");

            result.setType(MediaType.VIDEO);
            result.setVideos(videos);

            // 视频信息
            videos.add(new BareResult.Video(
                    videoObject.getJSONObject("play_addr").getJSONArray("url_list").getStr(0).replace("playwm", "play"),
                    videoObject.getStr("radio"),
                    videoObject.getInt("width"),
                    videoObject.getInt("height")
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
        int start = url.indexOf("/video/") + "/video/".length();
        int end = url.lastIndexOf("/");
        return url.substring(start, end);
    }
}
