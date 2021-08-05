package com.haowen.bare.parse.parser;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.enums.MediaType;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.AESUtil;
import com.haowen.bare.utils.SysConvert;
import com.haowen.bare.utils.UserAgentUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

/**
 * 秒拍解析器
 */
@Component
public class MiaoPaiParser implements BareParser {

    /**
     * 获取视频接口地址
     */
    private static final String API = "https://v5-api.miaopai.com/media/media/info";

    /**
     * 方法描述: 获取无水印资源信息
     *
     * @param url 复制的链接
     * @return 无水印资源信息
     */
    @Override
    public BareResult parse(String url) throws Exception {

        // 构建结果
        BareResult result = new BareResult(MediaType.VIDEO);
        List<BareResult.Video> videos = new ArrayList<>();
        result.setVideos(videos);

        String[] split = url.split("/");
        String smId = split[split.length - 1];

        Map<String, String> headerMap = createHeaders(smId);

        // 获取分享资源信息
        String jsonStr = Jsoup
                .connect(API)
                .method(Connection.Method.POST)
                .data("smId", smId)
                .headers(headerMap)
                .userAgent(UserAgentUtil.getOne())
                .ignoreContentType(true)
                .execute()
                .body();

        JSONObject dataObject = JSONUtil.parseObj(jsonStr)
                .getJSONObject("data");

        String title = dataObject.getJSONObject("basic")
                .getStr("title");
        JSONObject coverObject = dataObject.getJSONObject("cover")
                .getJSONObject("b");

        // 标题、封面
        result.setTitle(title)
                .setCover(new BareResult.Image(
                        coverObject.getStr("url"),
                        coverObject.getInt("width"),
                        coverObject.getInt("height")
                ));

        JSONObject videoObject = dataObject.getJSONObject("video")
                .getJSONArray("playUrl")
                .getJSONObject(0);

        // 视频
        videos.add(new BareResult.Video(
                videoObject.getStr("playUrl"),
                null,
                videoObject.getInt("width"),
                videoObject.getInt("height")
        ));

        return result;
    }

    public Map<String, String> createHeaders(String smId) throws Exception {
        String randomStr = this.getRandomStr();
        Long timeStamp = this.getTimeStamp();
        String rv = "1.0.0";
        String ak = getAk(timeStamp, randomStr);
        String ti = getTi(timeStamp, randomStr);
        String pk = "com.yixia.videoeditor";
        String si = getSi(ak);
        String t = "{\"did\":\"80D57A2A73AA45888331D614B0E3652B\",\"dname\":\"Chrome 90.0.4430.93 WebKit 537.36 Windows NT 10.0 \",\"os\":\"web\"}";
        String sk = getSk(smId, rv, timeStamp, pk, ti, t, ak);
        String p = getP(t, ak);

        Map<String, String> map = new HashMap<>();
        map.put("Referer", "https://n.miaopai.com/");
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("p", p);
        map.put("pk", pk);
        map.put("rt", String.valueOf(timeStamp));
        map.put("rv", rv);
        map.put("si", si);
        map.put("sk", sk);
        map.put("ti", ti);

        return map;
    }

    /**
     * 时间戳
     */
    public Long getTimeStamp() {
        return new Date().getTime();
    }

    /**
     * 随机数（6位）
     */
    public String getRandomStr() {
        String randomLongStr = SysConvert.getInstance().Convert(10, 36, String.valueOf(Math.random()), 18);
        return randomLongStr.substring(randomLongStr.length() - 6);
    }

    /**
     * ak
     */
    public String getAk(Long timeStamp, String randomStr) {
        return SecureUtil.md5(timeStamp + randomStr).substring(16);
    }

    /**
     * ti
     */
    public String getTi(Long timeStamp, String randomStr) {
        return SecureUtil.md5(timeStamp + randomStr);
    }

    /**
     * si
     */
    public String getSi(String ak) throws Exception {
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvuIXFVCmesMB9dBaPzuj4R+5VAtDzK+KK+jfFtBTcynKD1JD4YMgPWJAQhR5pGh/a2DIGlCWk77ZqmcCv69jFoi9fFKimWMP2vQ1FK0NiVYDVa7h/AUh8wGjo9pVKjw1qTcp+lrAsfNzdttWlxZiJtST/H6gMii6lUj9YHufLhXovsqwKe4DcWondCiGV0xYaUC22aKELO9dhjv40wwDuAvp7aQ5Ky0fUI+DaZo9xAO9mZlr834RPgrk135TkXMmHM6cMiy8Fx3dtLcPpMqexLcEy1n/hRWkvBbGvInc9xKw6ARbsW1rQt2ExZYswKJrciz3oA38YfuR+Z8HWUzNtQIDAQAB";
        return encrypt(ak, publicKey);
    }

    /**
     * sk
     */
    public String getSk(String smId, String rv, Long timeStamp, String pk, String ti, String t, String ak) {
        String s = SecureUtil.md5(smId);
        String l = SecureUtil.md5(rv + timeStamp + pk + ti + t);
        return SecureUtil.md5(l + s + ak);
    }

    public String getP(String e, String ak) {
        AESUtil aesUtil = new AESUtil(ak);
        return aesUtil.encrypt(e);
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public String encrypt(String str, String publicKey) throws Exception {
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return Base64.encodeBase64String(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
    }
}
