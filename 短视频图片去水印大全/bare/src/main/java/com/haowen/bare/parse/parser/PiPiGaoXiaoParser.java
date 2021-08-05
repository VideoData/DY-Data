package com.haowen.bare.parse.parser;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.StringUtil;
import com.haowen.bare.utils.UserAgentUtil;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 皮皮搞笑解析器
 * ==============================================================
 * User-Agent Mobile
 * 1. 获取分享链接ID（参数形式）
 * 2. 请求接口获取数据json
 * 5. 解析获取想要的结果
 * --------------------------------------------------------------
 * 标题 -> data -> post -> content
 * 封面 -> data -> post -> imgs[0] -> id => ('https://file.ippzone.com/img/view/id/' + id, null, null)
 * 视频 -> data -> post -> videos -> thumb(Var) => (url, null, null, null)
 * ==============================================================
 */
@Component
public class PiPiGaoXiaoParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://h5.pipigx.com/ppapi/share/fetch_content";

    /**
     * 方法描述:短视频解析
     *
     * @param url 链接地址
     */
    @Override
    public BareResult parse(String url) {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取URL参数
        Map<String, List<String>> queryParams = StringUtil.getQueryParams(url);

        Map<String, Object> map = new HashMap<>();
        map.put("mid", Long.parseLong(queryParams.get("mid").get(0)));
        map.put("pid", Long.parseLong(queryParams.get("pid").get(0)));
        map.put("type", "post");

        // 获取分享资源信息
        String jsonStr = HttpUtil.createPost(API)
                .header("User-Agent", UserAgentUtil.getOne())
                .body(JSONUtil.toJsonStr(map))
                .execute()
                .body();

        JSONObject postObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data")
                .getJSONObject("post");

        JSONObject videosObject = postObject.getJSONObject("videos");

        Set<String> set = videosObject.keySet();
        String thumb = null;
        for (String item : set) {
            thumb = item;
        }
        JSONObject thumbObject = videosObject.getJSONObject(thumb);

        // 标题、封面
        result.setTitle(postObject.getStr("content"))
                .setCover(new BareResult.Image("https://file.ippzone.com/img/view/id/" +
                        postObject.getJSONArray("imgs").getJSONObject(0).getStr("id")));

        // 视频信息
        videos.add(new BareResult.Video(thumbObject.getStr("url")));

        return result;
    }
}
