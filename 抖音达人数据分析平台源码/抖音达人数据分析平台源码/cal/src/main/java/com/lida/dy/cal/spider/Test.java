package com.lida.dy.cal.spider;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/27 0027 14:59
 * @Version: 1.0
 */
public class Test {
    public JSONObject getComments() throws IOException {
        String aweme_id = "", cursor = "";
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String turl = "https://api3-core-c-hl.amemv.com/aweme/v1/user/profile/other/?version_code=10.4.0&js_sdk_version=1.55.0.3&app_name=aweme&app_version=10.4.0&device_id=54593542501&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82&os_api=18&ac=WIFI&os_version=13.3.1&device_platform=iphone&build_number=104012&iid=109185113352&device_type=iPhone8,2&is_vcd=1&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&publish_video_strategy_type=2&user_id=91760728768&address_book_access=0&sec_user_id=MS4wLjABAAAAtGHIuekGN2USKVPikYCbwhzfotK04UDiyXu7TLjU-P4";
        String tcookie = "passport_csrf_token=470d5de1790a5480888a61c62a5a9588; odin_tt=040efd2bf4c78c326ebea9cfef43c85c9fd71818c1187c4c4d9b0d1994358d2e26652a7ac37e10bc17dbb6d75b66d8f1581df65cc3b04fa8ec347c776bd32642; d_ticket=7061a2d71f0b7d7f808b8b5b387469b758fe5; sid_guard=5fd28ea88ca3a63af05149dc57643f6a%7C1585289794%7C5184000%7CTue%2C+26-May-2020+06%3A16%3A34+GMT; uid_tt=95140db49dc514a38e2d3f2e397a4801; sid_tt=5fd28ea88ca3a63af05149dc57643f6a; sessionid=5fd28ea88ca3a63af05149dc57643f6a; install_id=109185113352; ttreq=1$a1abb5ed067424994f0dced1a9b8e5ed555e39b8";
        String url = "http://aweme-lq.snssdk.com/aweme/v2/comment/list/?aweme_id=" + aweme_id + "&cursor=" + cursor + "&count=20&address_book_access=2&gps_access=1&ts=1577288824&js_sdk_version=1.13.10&app_type=normal&manifest_version_code=580&_rticket=1577288825214&ac=wifi&device_id=54568004779&iid=97004910564&mcc_mnc=46000&os_version=8.0.0&channel=wandoujia_aweme1&version_code=580&device_type=BKL-AL00&language=zh&uuid=868600033290907&resolution=1080*2040&openudid=f227e6d1519846a5&update_version_code=5800&app_name=aweme&version_name=5.8.0&os_api=26&device_brand=HONOR&ssmix=a&device_platform=android&dpi=480&aid=1128";
        String cookies = "odin_tt=baa38b212e2eb5f33eaa6aef8c105f2f03b7dfd228fd007704f10d30510a1995cfc012ca0c1b95cca923f1f77a694c9a9e3c7af014df4a1b5f1ccf580d9e15a2; ttreq=1$ee119f24ee6b7d6013a41af853b29e6291e00b5d";

        url = turl;
        cookies = tcookie;
        new JSONObject();
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookies);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "Aweme 10.4.0 rv:104012 (iPhone; iOS 13.3.1; zh_CN) Cronet");
//        headers.put("Host", "api.amemv.com");
        headers.put("Host", "api3-core-c-hl.amemv.com");
        headers.put("Cookie", cookies);
        headers.put("Connection", "Keep-Alive");
        String json = HttpClientUtil.get(url, null, headers);
        System.out.println(json);
        return null;
    }

    public static void main(String[] args) throws IOException {
        new Test().getComments();
    }
}
