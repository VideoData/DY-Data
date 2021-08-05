package com.haowen.bare.parse.parser;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Pair;
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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 美拍解析器
 */
@Component
public class MeiPaiParser implements BareParser {

    /**
     * 方法描述:短视频解析
     */
    @Override
    public BareResult parse(String url) throws IOException {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        // 获取分享资源信息
        String html = Jsoup
                .connect(url)
                .userAgent(UserAgentUtil.getOne())
                .ignoreContentType(true)
                .execute()
                .body();

        String jsonStr = regexJson(html);

        JSONObject mediaInfoObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("mediaInfo");

        // 标题、封面
        result.setTitle(mediaInfoObject.getStr("caption_origin"))
                .setCover(new BareResult.Image(mediaInfoObject.getStr("cover_pic")));

        // 视频
        videos.add(new BareResult.Video("http:" + decode(mediaInfoObject.getStr("video"))));

        return result;
    }

    /**
     * 方法描述: 正则获取数据json
     *
     * @param html 网页内容
     */
    public static String regexJson(String html) {
        // 匹配网址
        String regex = "<script>window.PHPDATA\\s=\\s(.*?)</script>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(html);
        if (m.find()) {
            return html.substring(m.start(), m.end())
                    .replace("<script>window.PHPDATA = ", "")
                    .replace("</script>", "");
        }
        return "";
    }

    public Pair<String, String> getHex(String text) {
        List<String> reverse = CollectionUtil.reverse(Arrays.asList(text.substring(0, 4).split("")));
        StringBuilder str = new StringBuilder();
        for (String s : reverse) {
            str.append(s);
        }
        return new Pair<>(text.substring(4), str.toString());
    }

    public Pair<String[], String[]> getDec(String t) {
        String e = String.valueOf(Integer.parseInt(t, 16));
        String[] pre = e.substring(0, 2).split("");
        String[] tail = e.substring(2).split("");
        return new Pair<>(pre, tail);
    }

    public String substr(String t, String[] e) {
        String i = t.substring(0, Integer.parseInt(e[0]));
        String a = t.substring(Integer.parseInt(e[0]), Integer.parseInt(e[0]) + Integer.parseInt(e[1]));
        return i + t.substring(Integer.parseInt(e[0])).replace(a, "");
    }

    public String[] getPos(String t, String[] e) {
        e[0] = String.valueOf(t.length() - Integer.parseInt(e[0]) - Integer.parseInt(e[1]));
        return e;
    }

    /**
     * 视频地址解码
     *
     * @param t 接口请求到的地址
     */
    public String decode(String t) {
        Pair<String, String> e = this.getHex(t);
        Pair<String[], String[]> i = this.getDec(e.getValue());
        String a = this.substr(e.getKey(), i.getKey());
        return Base64.decodeStr(this.substr(a, this.getPos(a, i.getValue())));
    }
}
