package com.haowen.bare.parse.parser;

import cn.hutool.json.JSONArray;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小红书解析器
 */
@Component
public class XiaoHongShuParser implements BareParser {

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Image> images = new ArrayList<>();
        result.setImages(images);

        String realUrl = UrlUtil.getRealUrl(UserAgentUtil.getOne(), url);
        String redirectPath = StringUtil.getQueryParams(realUrl).get("redirectPath").get(0);

        // 获取html内容
        String html = Jsoup
                .connect(redirectPath)
                .header("cookie", "xhsTrackerId=b1da7fa6-9a2f-4b71-cb7a-78628d52d940; xhsuid=ZJzD8ASvuaZBr7CT; xhsTracker=url=noteDetail&xhsshare=CopyLink; timestamp2=20210804f04f5ea8e904335c3516242c; timestamp2.sig=rA2FFH3kKjaO4G2vJ56GQ4Yc_02M9jtgdX91SwxukMU; extra_exp_ids=gif_exp1,ques_clt2; noteIndex=6")
                .userAgent(UserAgentUtil.getOne())
                .ignoreContentType(true)
                .execute()
                .body();

        // 获取json数据
        String jsonStr = regexJson(html);
        JSONObject contentObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("NoteView")
                .getJSONObject("content");

        // 标题
        result.setTitle(contentObject.getStr("title"));

        JSONArray imageArray = contentObject.getJSONArray("imageList");
        // 图片信息
        for (int i = 0; i < imageArray.size(); i++) {
            JSONObject item = imageArray.getJSONObject(i);
            images.add(new BareResult.Image(
                    "http://ci.xiaohongshu.com/" + item.getStr("traceId"),
                    item.getInt("width"),
                    item.getInt("height")
            ));
        }

        return result;
    }

    /**
     * 方法描述: 正则获取数据json
     *
     * @param html 网页内容
     */
    public static String regexJson(String html) {
        // 匹配网址
        String regex = "<script>window.__INITIAL_SSR_STATE__=\\{(.*?)\\}</script>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("<script>window.__INITIAL_SSR_STATE__=", "")
                    .replace("</script>", "")
                    .replace("undefined", "null");
        }
        return "";
    }
}
