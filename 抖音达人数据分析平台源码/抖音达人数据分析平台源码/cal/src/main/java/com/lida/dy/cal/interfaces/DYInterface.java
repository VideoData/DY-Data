package com.lida.dy.cal.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.spider.HttpClientUtil;
import com.lida.dy.cal.spiderDy.Utils;
import org.apache.commons.io.IOUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Component
public class DYInterface {
    protected static final String URL_REGEX = "^((https|http|ftp|rtsp|mms)?://)(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,5})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

    private List<CookieBean> cookieBeans;
    private int cookieIndex = 0;
    @Value("${my.device}")
    private String filePath = "";
    //    String cookie ="odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1588590398%7C5184000%7CFri%2C+03-Jul-2020+11%3A06%3A38+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a; install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4";
//    String cookie = "odin_tt=040efd2bf4c78c326ebea9cfef43c85c9fd71818c1187c4c4d9b0d1994358d2e26652a7ac37e10bc17dbb6d75b66d8f1581df65cc3b04fa8ec347c776bd32642; sid_guard=5fd28ea88ca3a63af05149dc57643f6a%7C1587343341%7C5184000%7CFri%2C+19-Jun-2020+00%3A42%3A21+GMT; uid_tt=95140db49dc514a38e2d3f2e397a4801; sid_tt=5fd28ea88ca3a63af05149dc57643f6a; sessionid=5fd28ea88ca3a63af05149dc57643f6a; install_id=111027412238; ttreq=1$aebda3ba060cdbc491478dc09302dba8abedbb86";
    String cookie = "install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4; passport_csrf_token=eae0cb8afd7ae83568ac9eb0d470b35d; d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a";

    public void init() {
        cookieBeans = getCookieBean(filePath);
    }

//    GET https://aweme.snssdk.com/aweme/v1/comment/list/reply/?comment_id=6815888148364115976&cursor=3&count=10&top_ids=6815888594369118216&item_id=6815877676876811523&insert_ids&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1586956831&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1586956831913&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000 HTTP/1.1
//    Accept-Encoding: gzip
//    X-SS-REQ-TICKET: 1586956831912
//    sdk-version: 1
//    User-Agent: ttnet okhttp/3.10.0.2
//    Cookie: d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a; install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4
//    x-tt-token: 00080ab789c0bf0519740314c59de87d8a34f4c01318053cf6ee5434e064816ba8bd601fb78b30d39a8cddba2d3c9f02cb48
//    X-Gorgon: 040100cd0000e85b5b1c92943706dd25a1b0b01443b370588127
//    X-Khronos: 1586956831
//    Host: aweme.snssdk.com
//    Connection: Keep-Alive
    /**
     * 获取回复
     *
     * @param cid 回复的评论的id
     * @param tempVid   视频id
     */
    private int replyCommentTimes = 0;

    public String searchReply(String cid, String tempVid, String cursor, int count) {
        try {
//            Thread.sleep(500);
            System.out.println("回复：" + replyCommentTimes);
            replyCommentTimes++;
            int ts = (int) (System.currentTimeMillis() / 1000L);
            System.out.println(ts);
            String _rticket = System.currentTimeMillis() + "";
            String url = "https://aweme.snssdk.com/aweme/v1/comment/list/reply/?comment_id=" + cid + "&cursor=" + cursor + "&count=" + count + "&top_ids&item_id=" + tempVid + "&insert_ids&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1586956831&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1586956831913&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";
            String cookies = "install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4; passport_csrf_token=eae0cb8afd7ae83568ac9eb0d470b35d; d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a";
            String params = url.substring(url.indexOf("?") + 1, url.length());
            String STUB = "";
            String s = XGorgon.getXGon(params, STUB, cookies);
            String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
            Map<String, Object> headers = new HashMap();
            headers.put("X-Gorgon", Gorgon);
            headers.put("X-SS-REQ-TICKET", "1585711173953");
            headers.put("X-Khronos", ts);
            headers.put("sdk-version", "1");
            headers.put("Accept-Encoding", "gzip");
            headers.put("X-SS-REQ-TICKET", _rticket);
            headers.put("User-Agent", "ttnet okhttp/3.10.0.2");
            headers.put("Host", "aweme.snssdk.com");
            headers.put("Cookie", cookies);
            headers.put("Connection", "Keep-Alive");
            headers.put("x-tt-token", "00080ab789c0bf0519740314c59de87d8ace96d49d8ab2afd7a0f09cba0911612f99baf92acae289860e0f84ffd97fc2c344");
            String json = doGetGzip(url, headers, "UTF-8");
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 请求评论者的数据
     *
     * @param userId
     * @param serUserId
     * @return
     * @throws IOException
     */
    public String getFansUserInfo(String userId, String serUserId) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String suffix = serUserId == null ? "" : "&sec_user_id=" + serUserId;
        String url = "https://api3-core-c-hl.amemv.com/aweme/v1/user/profile/other/?version_code=10.4.0&js_sdk_version=1.55.0.3&app_name=aweme&app_version=10.4.0&device_id=54593542501&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82&os_api=18&ac=WIFI&os_version=13.3.1&device_platform=iphone&build_number=104012&iid=109185113352&device_type=iPhone8,2&is_vcd=1&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&publish_video_strategy_type=2&user_id=" + userId + "&address_book_access=0" + suffix;
//        url = "https://aweme-eagle.snssdk.com/aweme/v1/user/?address_book_access=1&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1588734757&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket="+_rticket+"&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000&user_id=" + userId;
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = com.lida.dy.cal.spider.XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = com.lida.dy.cal.spider.XGorgon.xGorgon(ts, com.lida.dy.cal.spider.XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "Aweme 10.4.0 rv:104012 (iPhone; iOS 13.3.1; zh_CN) Cronet");
//        headers.put("Host", "api.amemv.com");
        headers.put("Host", "api3-core-c-hl.amemv.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        return HttpClientUtil.get(url, null, headers);
    }

    public String getFansUserInfo2(String userId, String serUserId) throws IOException {
        String _rticket = System.currentTimeMillis() + "";
        int ts = (int) (System.currentTimeMillis() / 1000L);
        int ts2 = (int) (System.currentTimeMillis() / 1000L);
        String suffix = serUserId == null ? "" : "&sec_user_id=" + serUserId;
        String url = "https://api3-core-c-hl.amemv.com/aweme/v1/user/profile/other/?version_code=10.4.0&js_sdk_version=1.55.0.3&app_name=aweme&app_version=10.4.0&device_id=54593542501&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82&os_api=18&ac=WIFI&os_version=13.3.1&device_platform=iphone&build_number=104012&iid=109185113352&device_type=iPhone8,2&is_vcd=1&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&publish_video_strategy_type=2&user_id=" + userId + "&address_book_access=0" + suffix;
//        url = "https://aweme-eagle.snssdk.com/aweme/v1/user/?address_book_access=1&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1588734757&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket="+_rticket+"&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000&user_id=" + userId;
        url = "/aweme/v1/user/?sec_user_id=MS4wLjABAAAAqYIx3rTezm_GAgamqJJpn_sXnJUU1PaGO8QWwje_v93Fg9tOitTuclYqj6UEqU4b&address_book_access=1&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=865531460558214&app_name=aweme&version_name=9.2.0&ts=1588736116&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=720*1280&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";
        url = "https://aweme-eagle.snssdk.com/aweme/v1/user/?sec_user_id=MS4wLjABAAAAjtzJJ5SwMkNFmkJZSGXOYE1ccXZAS2yjb1VChIJjEZE&address_book_access=2&retry_type=no_retry&iid=3175025109642029&device_id=69567395847&ac=wifi&channel=update%2Coppo%2Cvivo%2Chuawei_1%2Cxiaomi%2Cmeizu%2Csamsungapps%2Caweme_gionee%2Csmartisan%2Clephone%2Came_nubiamm%2Czb_xiaomi_awe_mimeng%2Chuawei_pps%2Chuawei_ywjj%2Came_ydzhuomian%2Ctengxun_new%2Cdouyin_tengxun_wzl%2Cbaidu%2C360_aweme%2Cgoapk_aweme%2Cwandoujia_aweme2%2CsougouAD%2Calios%2Cgoogle%2Cbaidu_ss%2Cyingyonghui0305&aid=1128&app_name=aweme&version_code=850&version_name=8.5.0&device_platform=android&ssmix=a&device_type=MI+5s&device_brand=Xiaomi&language=zh&os_api=22&os_version=5.1.1&uuid=865531460558214&openudid=f4c3dc16590ada36&manifest_version_code=715215876&resolution=720*1280&dpi=192&update_version_code=715215876&_rticket=" + _rticket + "&mcc_mnc=46000&ts=1588739485&app_type=normal";
//        _rticket = "1588739485479";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = com.lida.dy.cal.spider.XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = com.lida.dy.cal.spider.XGorgon.xGorgon(ts, com.lida.dy.cal.spider.XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
//        headers.put("X-Gorgon", "030000000000d9c3e3654f610707e58cec5bc36ead27ac20df51");
        headers.put("X-Khronos", ts + "");
//        headers.put("X-Khronos", "1588739485");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", ts2 + "");
//        headers.put("X-SS-REQ-TICKET", "1588739485492");
        headers.put("User-Agent", "ttnet okhttp/3.10.0.1");
        headers.put("x-tt-token", "00080ab789c0bf0519740314c59de87d8a817a7a45fb595dd45d51f8a111458ca1e3ed8ad3ad202d554708ca80952f2c3948");
        headers.put("Host", "aweme-eagle.snssdk.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        return HttpClientUtil.get(url, null, headers);
    }

    public String getTalentUserInfo(String userId) throws IOException {
//        return getFansUserInfo(userId, null);
        return getFansUserInfo2(userId, null);
    }

    /**
     * 解析cookie文件
     *
     * @return
     */
    private List<CookieBean> getCookieBean(String filePath) {
        ArrayList<CookieBean> cookieBeans = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
            while (reader.ready()) {
                String s = reader.readLine();
                if (s.startsWith("cookie")) {
                    s += reader.readLine();
                    s = s.replace("cookie:", "");
                    s = s.replace("}{", ",");
                    CookieBean cookieBean = JSONObject.parseObject(s, CookieBean.class);
                    cookieBeans.add(cookieBean);
                    reader.readLine();
                } else {
                    reader.readLine();
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookieBeans;
    }


    public JSONObject douyinVideoParse(String shareUrl) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String realUrl = shortUrlConvertLongUrl(shareUrl);
        System.out.println("\u001b[32;3m抖音分享长地址是：" + realUrl + "\u001b[1m\n");
        String aweme_id = matchUrlKeyAfterValue(realUrl, "video");
        String url = "https://aweme-lq.snssdk.com/aweme/v1/aweme/detail/?aweme_id=" + aweme_id + "&origin_type=link&manifest_version_code=700&_rticket=" + _rticket + "&app_type=normal&iid=9366650763333342308&channel=goapk_aweme&device_type=MI%206&language=zh&uuid=867391333038812504&resolution=1080*1920&openudid=26b3dc2e1d807ca8&update_version_code=7002&os_api=26&dpi=480&ac=wifi&device_id=50624534331127&os_version=8.0.0&version_code=700&app_name=aweme&version_name=7.0.0&js_sdk_version=1.18.2.5&device_brand=Xiaomi&ssmix=a&device_platform=android&aid=1128&ts=" + ts;
        String cookies = "msh=e9aaFLVaZh9ZRITWAUN0e0TUZ_s; uid_tt_ss=a22b36f267d1229ae6c7f56dcab32934; sessionid_ss=22cc9d971ba75ec0a332b78d78aa5a68; sid_guard=2c747ba418b4b12ad86534e9fdfa42f3%7C1585187799%7C21600%7CThu%2C+26-Mar-2020+07%3A56%3A39+GMT; uid_tt=2d4540fa9e768b6234883065e5d2c94f; sid_tt=2c747ba418b4b12ad86534e9fdfa42f3; sessionid=2c747ba418b4b12ad86534e9fdfa42f3; passport_csrf_token=4a54633d37d4c98e0848c34f5ead66ab; odin_tt=482d51eb0191d50e7ff8c8793b9459274d2c2d479074dc2c1754ea9b7e1240945b5c07b461fdd5b2f97a7e558bbc61497e79e292458ba1fca5d8c374ed725b0c; install_id=108618882417; ttreq=1$603b7c2a4846140cce8673a24c526fa4692df525";
        new JSONObject();
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookies);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, Object> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts);
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "com.ss.android.ugc.aweme/700 (Linux; U; Android 8.0.0; zh_CN; MI 6; Build/OPR1.170623.027; Cronet/58.0.2991.0)");
        headers.put("x-Tt-Token", "008d7f39171fe3242bcde1fb382ce1e35ff6eb484228d14256cbc6c2e62e8e046259381d32ee9546e1ca5ae2ed2562227dc59839");
        headers.put("Host", "aweme-lq.snssdk.com");
        headers.put("Cookie", cookies);
        headers.put("Connection", "Keep-Alive");
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        String json = doGetGzip(url, headers, "UTF-8");
        return JSONObject.parseObject(json);
    }


    private int commentTimes = 0;


    public static void main(String[] args) throws IOException {
        DYInterface DYInterface = new DYInterface();
//        System.out.println(DYInterface.searchReply("6815852267972001805", "6815818046297476359", "0", 3));
//        System.out.println(DYInterface.get_video_list(0, "", "", ""));
//        System.out.println(DYInterface.getMyComment("6810650141905669383", "0"));
//        System.out.println(DYInterface.getTalentUserInfo("84412490493"));
        System.out.println(DYInterface.getFansUserInfo("84412490493", ""));
        System.out.println(DYInterface.ios());
    }

    //    GET https://aweme.snssdk.com/aweme/v2/comment/list/?aweme_id=6810650141905669383&cursor=0&count=20&address_book_access=1&gps_access=1&forward_page_type=1&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1585739874&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1585739874633&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000 HTTP/1.1
//    Accept-Encoding: gzip
//    X-SS-REQ-TICKET: 1585739874632+
//    sdk-version: 1
//    User-Agent: ttnet okhttp/3.10.0.2
//    Cookie: passport_csrf_token=eae0cb8afd7ae83568ac9eb0d470b35d; d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a; install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4
//    x-tt-token: 00080ab789c0bf0519740314c59de87d8ace96d49d8ab2afd7a0f09cba0911612f99baf92acae289860e0f84ffd97fc2c344
//    X-Gorgon: 040160480000e13bcf0f29c5451d88bfdb2450a995fb7f2ed07a
//    X-Khronos: 1585739874
//    Host: aweme.snssdk.com
//    Connection: Keep-Alive
    public String getMyComment(String aweme_id, String cursor) {
        try {
//            Thread.sleep(500);
            System.out.println(Utils.getNowDate() + ":" + "评论请求次数：" + commentTimes);
            commentTimes++;
            int ts = (int) (System.currentTimeMillis() / 1000L);
            System.out.println(ts);
            String _rticket = System.currentTimeMillis() + "";
//            CookieBean cookieBean = cookieBeans.get(cookieIndex);
            String url = "https://aweme.snssdk.com/aweme/v2/comment/list/?aweme_id=" + aweme_id + "&cursor= " + cursor + "&count=20&address_book_access=1&gps_access=1&forward_page_type=1&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1585739874&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1585739874633&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";
            url = "https://aweme.snssdk.com/aweme/v2/comment/list/?aweme_id=" + aweme_id + "&cursor=" + cursor + "&count=20&address_book_access=1&gps_access=1&forward_page_type=1&os_api=22&device_type=MIX&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1585711173&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1585711173953&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";
            String cookies = "install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4; passport_csrf_token=eae0cb8afd7ae83568ac9eb0d470b35d; d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a";
            String params = url.substring(url.indexOf("?") + 1, url.length());
            String STUB = "";
            String s = XGorgon.getXGon(params, STUB, cookies);
            String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
            Map<String, Object> headers = new HashMap();
            headers.put("X-Gorgon", Gorgon);
            headers.put("X-SS-REQ-TICKET", "1585711173953");
            headers.put("X-Khronos", ts);
            headers.put("sdk-version", "1");
            headers.put("Accept-Encoding", "gzip");
            headers.put("X-SS-REQ-TICKET", _rticket);
            headers.put("User-Agent", "ttnet okhttp/3.10.0.2");
            headers.put("Host", "aweme.snssdk.com");
            headers.put("Cookie", cookies);
            headers.put("Connection", "Keep-Alive");
            headers.put("x-tt-token", "00080ab789c0bf0519740314c59de87d8ace96d49d8ab2afd7a0f09cba0911612f99baf92acae289860e0f84ffd97fc2c344");
            String json = doGetGzip(url, headers, "UTF-8");
            if (!isAddIndex(json)) {
                return json;
            } else {
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 测试cookie索引是否加一
     *
     * @param jsonObject
     */
    private int failTimes = 0;

    private boolean isAddIndex(String json) {
        if (json == null || json.length() < 400) {
            cookieIndex++;
            if (cookieIndex >= cookieBeans.size()) {
                cookieIndex = 0;
            }
            failTimes++;
            System.out.println("无法获取数据,次数:" + failTimes);
            return true;
        }
        return false;
    }


    public JSONObject Gorgon(String r_url) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String url = r_url;
        String cookies = "odin_tt=baa38b212e2eb5f33eaa6aef8c105f2f03b7dfd228fd007704f10d30510a1995cfc012ca0c1b95cca923f1f77a694c9a9e3c7af014df4a1b5f1ccf580d9e15a2; ttreq=1$ee119f24ee6b7d6013a41af853b29e6291e00b5d";
        new JSONObject();
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookies);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        return JSONObject.parseObject(Gorgon);
    }


//    GET https://api3-normal-c-hl.amemv.com/aweme/v2/comment/list/?version_code=10.3.0&js_sdk_version=1.43.0.1&app_name=aweme&vid=2AA52B93-9F10-4331-AF27-14AF26FCD021&app_version=10.3.0&device_id=70571338900&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e467d5c93480dcfe0a45c37929d699730b5558ea&cdid=D023F5C4-CC5E-4CD6-A44D-17178830B5BE&os_api=18&ac=4G&os_version=13.3&device_platform=iphone&build_number=103020&iid=108618882417&device_type=iPhone10,5&is_vcd=1&idfa=D8573AEB-2E10-4989-9694-17F3FBF97AB0&cursor=0&forward_page_type=1&insert_ids=&gps_access=0&address_book_access=2&count=20&hotsoon_has_more=0&hotsoon_filtered_count=0&channel_id=0&aweme_id=6802888176059862279&city=341000 HTTP/1.1
//    Host: api3-normal-c-hl.amemv.com
//    Connection: keep-alive
//    x-Tt-Token: 002c747ba418b4b12ad86534e9fdfa42f389005cdd0537fe6d27bb0b6ec8ecf575e1bc83d140e6914730e1d088e55f85b318
//    sdk-version: 1
//    User-Agent: Aweme 10.3.0 rv:103020 (iPhone; iOS 13.3; zh_CN) Cronet
//    X-SS-DP: 1128
//    x-tt-trace-id: 00-164318fc0a106e612c9456720b210468-164318fc0a106e61-01
//    Accept-Encoding: gzip, deflate, br
//    Cookie: msh=e9aaFLVaZh9ZRITWAUN0e0TUZ_s; uid_tt_ss=a22b36f267d1229ae6c7f56dcab32934; sessionid_ss=22cc9d971ba75ec0a332b78d78aa5a68; passport_csrf_token=4a54633d37d4c98e0848c34f5ead66ab; odin_tt=482d51eb0191d50e7ff8c8793b9459274d2c2d479074dc2c1754ea9b7e1240945b5c07b461fdd5b2f97a7e558bbc61497e79e292458ba1fca5d8c374ed725b0c; install_id=108618882417; ttreq=1$603b7c2a4846140cce8673a24c526fa4692df525
//    X-Khronos: 1585216427
//    X-Gorgon: 840280f80000ca84909edf3d479c53991b8837b038d6aec96c3d


    public JSONObject ios() throws IOException {

        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://api3-normal-c-hl.amemv.com/aweme/v2/comment/list/?version_code=10.3.0&js_sdk_version=1.43.0.1&app_name=aweme&vid=2AA52B93-9F10-4331-AF27-14AF26FCD021&app_version=10.3.0&device_id=70571338900&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e467d5c93480dcfe0a45c37929d699730b5558ea&cdid=D023F5C4-CC5E-4CD6-A44D-17178830B5BE&os_api=18&ac=4G&os_version=13.3&device_platform=iphone&build_number=103020&iid=108618882417&device_type=iPhone10,5&is_vcd=1&idfa=D8573AEB-2E10-4989-9694-17F3FBF97AB0&cursor=0&forward_page_type=1&insert_ids=&gps_access=0&address_book_access=2&count=20&hotsoon_has_more=0&hotsoon_filtered_count=0&channel_id=0&aweme_id=6802888176059862279&city=341000";
//        String cookies = "msh=e9aaFLVaZh9ZRITWAUN0e0TUZ_s; uid_tt_ss=a22b36f267d1229ae6c7f56dcab32934; sessionid_ss=22cc9d971ba75ec0a332b78d78aa5a68; passport_csrf_token=4a54633d37d4c98e0848c34f5ead66ab; odin_tt=482d51eb0191d50e7ff8c8793b9459274d2c2d479074dc2c1754ea9b7e1240945b5c07b461fdd5b2f97a7e558bbc61497e79e292458ba1fca5d8c374ed725b0c; install_id=108618882417; ttreq=1$603b7c2a4846140cce8673a24c526fa4692df525";
        new JSONObject();
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, Object> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts);
        headers.put("sdk-version", "1");
        headers.put("X-SS-DP", "1128");
        headers.put("x-Tt-Token", "002c747ba418b4b12ad86534e9fdfa42f389005cdd0537fe6d27bb0b6ec8ecf575e1bc83d140e6914730e1d088e55f85b318");
        headers.put("x-tt-trace-id", "00-164318fc0a106e612c9456720b210468-164318fc0a106e61-01");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "Aweme 10.3.0 rv:103020 (iPhone; iOS 13.3; zh_CN) Cronet");
        headers.put("Host", "api3-normal-c-hl.amemv.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        String json = doGetGzip(url, headers, "UTF-8");
        return JSONObject.parseObject(json);
    }

//    GET https://api.amemv.com/aweme/v1/aweme/post/?max_cursor=0&user_id=3988636999116436&count=20&retry_type=no_retry&iid=107759113770&device_id=67765281791&ac=wifi&channel=wandoujia_aweme1&aid=1128&app_name=aweme&version_code=580&version_name=5.8.0&device_platform=android&ssmix=a&device_type=Redmi+7&device_brand=xiaomi&language=zh&os_api=28&os_version=9&uuid=867183041019296&openudid=23ff9f6b93efea26&manifest_version_code=580&resolution=720*1369&dpi=320&update_version_code=5800&_rticket=1585203611362&mcc_mnc=46000&ts=1585203610&js_sdk_version=1.13.10&as=a145e4573a697ec94c4388&cp=4d96e95ca9ca7095e1QiYm&mas=011e3edaa330cfa2b4aaad7ffd200ad3c91c1ccc2cc62c9cc6a6ec HTTP/1.1
//    Host: api.amemv.com
//    Connection: keep-alive
//    Cookie: install_id=107759113770; ttreq=1$ee119f24ee6b7d6013a41af853b29e6291e00b5d; odin_tt=baa38b212e2eb5f33eaa6aef8c105f2f03b7dfd228fd007704f10d30510a1995cfc012ca0c1b95cca923f1f77a694c9a9e3c7af014df4a1b5f1ccf580d9e15a2; qh[360]=1
//    Accept-Encoding: gzip
//    sdk-version: 1
//    User-Agent: com.ss.android.ugc.aweme/580 (Linux; U; Android 9; zh_CN; Redmi 7; Build/PKQ1.181021.001; Cronet/58.0.2991.0)
//    X-Khronos: 1585203611
//    X-Gorgon: 030096600000a2bb8b3f2e35f04e523dd0832eb7c4f96dddc247
//    X-Pods:
/*    GET https://api.amemv.com/aweme/v1/aweme/post/?source=0&max_cursor=0&sec_user_id=MS4wLjABAAAA0bTdkIMcLeVjGRojO1_ZdFspSKY-aHTJxjXZKLw7s35l-ba02095fZraeLnN3YkH&count=20&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=1587527615&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=1587527615729&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000 HTTP/1.1
    Accept-Encoding: gzip
    X-SS-REQ-TICKET: 1587527615728
    sdk-version: 1
    User-Agent: ttnet okhttp/3.10.0.2
    Cookie: d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a; install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4
    x-tt-token: 00080ab789c0bf0519740314c59de87d8a5eed0010627aa792c1247a70e690c1e2e08ba8e66e8c66372cabffb7aeca41b557
    X-Gorgon: 040160d60000ef31d8758d7273dd374915572bb7d16215f9c93c
    X-Khronos: 1587527615
    Host: api.amemv.com
    Connection: Keep-Alive*/

    /**
     * @param step       0，1
     * @param uid
     * @param max_cursor
     * @param min_cursor
     * @return
     * @throws IOException
     */
    private int videoTimes = 0;


    public String get_video_list(int step, String uid, String max_cursor, String min_cursor) throws IOException {
        try {
            System.out.println("视频：" + videoTimes);
            videoTimes++;
            int ts = (int) (System.currentTimeMillis() / 1000L);
            String _rticket = System.currentTimeMillis() + "";
            String url;
            if (step == 0) {
////                url = "https://api.amemv.com/aweme/v1/aweme/post/?min_cursor=0&max_cursor=0&user_id=" + uid + "&count=12&retry_type=no_retry&iid=" + cookieBean.getIid() + "&device_id=" + cookieBean.getDevice_id() + "&ac=wifi&channel=wandoujia_aweme1&aid=1128&app_name=aweme&version_code=580&version_name=5.8.0&device_platform=android&ssmix=a&device_type=Redmi+7&device_brand=xiaomi&language=zh&os_api=28&os_version=9&uuid=" + cookieBean.getUuid() + "&openudid=" + cookieBean.getOpenudid() + "&manifest_version_code=580&resolution=720*1369&dpi=320&update_version_code=5800&_rticket=" + _rticket + "&mcc_mnc=46000&ts=" + ts + "&js_sdk_version=1.13.10&as=a145e4573a697ec94c4388&cp=4d96e95ca9ca7095e1QiYm&mas=011e3edaa330cfa2b4aaad7ffd200ad3c91c1ccc2cc62c9cc6a6ec";
                url = "https://api.amemv.com/aweme/v1/aweme/post/?source=0&user_id=" + uid + "&max_cursor=0&count=20&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=" + ts + "&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";

            } else {
//                url = "https://api.amemv.com/aweme/v1/aweme/post/?max_cursor=" + max_cursor + "&user_id=" + uid + "&count=12&retry_type=no_retry&iid=" + cookieBean.getIid() + "&device_id=" + cookieBean.getDevice_id() + "&ac=wifi&channel=wandoujia_aweme1&aid=1128&app_name=aweme&version_code=580&version_name=5.8.0&device_platform=android&ssmix=a&device_type=Redmi+7&device_brand=xiaomi&language=zh&os_api=28&os_version=9&uuid=" + cookieBean.getUuid() + "&openudid=" + cookieBean.getOpenudid() + "&manifest_version_code=580&resolution=720*1369&dpi=320&update_version_code=5800&_rticket=" + _rticket + "&mcc_mnc=46000&ts=" + ts + "&js_sdk_version=1.13.10&as=a145e4573a697ec94c4388&cp=4d96e95ca9ca7095e1QiYm&mas=011e3edaa330cfa2b4aaad7ffd200ad3c91c1ccc2cc62c9cc6a6ec";
                url = "https://api.amemv.com/aweme/v1/aweme/post/?source=0&user_id=" + uid + "&max_cursor=" + max_cursor + "&count=20&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=869273222474044&app_name=aweme&version_name=9.2.0&ts=" + ts + "&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=110128576639&version_code=920&cdid=e7d2d302-0ff6-4774-8750-acec805feb67&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46000";

            }
            String cookies = "d_ticket=f6d6d5c5aa2a95349b6fb01c0f8f029e1cf3b; odin_tt=ca86a870c665e2857ec3af1df759ee747bcadae223cd706f61e55ce4352bc4ed8d6af5bb42a78ecaa7714daccc9884639f2b2f36d4231ce5bab18051f91d9b11; sid_guard=080ab789c0bf0519740314c59de87d8a%7C1585711138%7C5184000%7CSun%2C+31-May-2020+03%3A18%3A58+GMT; uid_tt=f02935cf52727202351fb06c888f4a28; sid_tt=080ab789c0bf0519740314c59de87d8a; sessionid=080ab789c0bf0519740314c59de87d8a; install_id=110128576639; ttreq=1$b3de35bd51c867f4a291a7f697bf4f5d3da252f4";
            String params = url.substring(url.indexOf("?") + 1, url.length());
            String STUB = "";
            String s = XGorgon.getXGon(params, STUB, cookies);
            String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
            Map<String, Object> headers = new HashMap();
            headers.put("X-Gorgon", Gorgon);
            headers.put("X-Khronos", ts);
            headers.put("x-tt-token", "00080ab789c0bf0519740314c59de87d8a5eed0010627aa792c1247a70e690c1e2e08ba8e66e8c66372cabffb7aeca41b557");
            headers.put("sdk-version", "1");
            headers.put("Accept-Encoding", "gzip");
            headers.put("User-Agent", "ttnet okhttp/3.10.0.2");
            headers.put("Host", "api.amemv.com");
            headers.put("Cookie", cookies);
            headers.put("Connection", "Keep-Alive");
            String json = doGetGzip(url, headers, "UTF-8");
            if (!isAddIndex(json)) {
                JSONObject jsonObject = JSONObject.parseObject(json);
                return json;
            } else {
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    public static String matchUrlKeyAfterValue(String url, String key) {
        String[] param = url.split("/");
        for (int i = 0; i < param.length; i++) {
            String str = param[i];
            String result = param[i + 1];
            if (key.equals(str)) {
                if (str.contains("?")) {
                    return result;
                }
                if (result.contains("?")) {
                    return result.substring(0, result.indexOf("?"));
                }
                return result;
            }
        }
        return null;
    }

    /**
     * 通过短链接 获取长链接
     * 短链接转换成长链接
     *
     * @param shortUrl 短链接
     */
    public static String shortUrlConvertLongUrl(String shortUrl) {
        if (isURL(shortUrl)) {
            Document document = null;
            try {
                //ignoreHttpErrors  忽略请求错误404 例如当把http://v.douyin.com/jek538/转成长链接的时候会报错 因为这个页面是404  加上这个不会报错
                document = Jsoup.connect(shortUrl).timeout(60000).method(Connection.Method.GET).ignoreHttpErrors(true).followRedirects(true).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return document.location();
        } else {
            return "非法网址";
        }
    }

    /**
     * @param str url字符串
     * @return boolean
     * @author HONGLINCHEN
     * @description 判断一个字符串是否为url
     * @date 2019-08-20-0020 17:47
     */
    public static boolean isURL(String str) {
        //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"//https、http、ftp、rtsp、mms
                // + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184  
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        return str.matches(URL_REGEX);
    }

    public static String doGetGzip(String url, Map<String, Object> headers, String charset) throws IOException {
        String result = null;
        InputStream is = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setRequestMethod("GET");// 提交模式
            conn.setDoInput(true);
            conn.setDoOutput(false);
            conn.setUseCaches(false);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(2000);
            if (headers != null) {
                for (Map.Entry<String, Object> entry : headers.entrySet()) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue().toString());
                }
            }
            conn.setRequestProperty("Connection", "close");
            conn.setConnectTimeout(3000);  //设置连接主机超时（单位：毫秒）
            conn.setReadTimeout(3000);     //设置从主机读取数据超时（单位：毫秒）
            String content_encoding = conn.getHeaderField("Content-Encoding");
            is = conn.getInputStream();
            if (content_encoding != null && content_encoding.equals("gzip")) {
				/*InputStream stream = new GZIPInputStream(conn.getInputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"utf-8"));
				StringBuffer sb = new StringBuffer();
				String line = "";
				while ((line = reader.readLine()) != null){
					sb.append(line);
				}
				System.out.println(sb.toString());*/
                InputStream stream = new GZIPInputStream(is);
                result = IOUtils.toString(stream, charset);
            } else {
                result = IOUtils.toString(is, charset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return result;
    }


}




