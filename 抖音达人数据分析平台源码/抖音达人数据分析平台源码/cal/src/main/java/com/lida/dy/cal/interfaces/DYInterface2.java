package com.lida.dy.cal.interfaces;

import com.lida.dy.cal.spider.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DYInterface2 {
    protected static final String URL_REGEX = "^((https|http|ftp|rtsp|mms)?://)(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,5})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";

    private List<CookieBean> cookieBeans;
    private int cookieIndex = 0;
    String urlOther = "&os_api=22&device_type=OXF-AN10&ssmix=a&manifest_version_code=920&dpi=216&uuid=868722101253623&app_name=aweme&version_name=9.2.0&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&device_platform=android&iid=2207456677868648&version_code=920&cdid=6017e681-cdd2-456d-9929-aeb584972f40&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1440*810&os_version=5.1.1&language=zh&device_brand=HUAWEI&aid=1128&mcc_mnc=46001";
    String cookie = "passport_csrf_token=7a7b2edfa2d910ee6930af6785d7b656; d_ticket=c8531fe3c2bec8106c7fdfb1cd2ae0374f1d3; odin_tt=29d622dcf756c0cc08ced8dfd2986cf2ffeefd6f0dad414a5d4e791f9651dab509df10ab39802cf9427e7b201372bde23083017521246bfbf1b163c1aa393a9d; sid_guard=3dd5eb7e7d83e3461d72f1bf0785c3e0%7C1589513241%7C5184000%7CTue%2C+14-Jul-2020+03%3A27%3A21+GMT; uid_tt=18cb23c8e2bc58d14bc8a236235414a9; uid_tt_ss=18cb23c8e2bc58d14bc8a236235414a9; sid_tt=3dd5eb7e7d83e3461d72f1bf0785c3e0; sessionid=3dd5eb7e7d83e3461d72f1bf0785c3e0; sessionid_ss=3dd5eb7e7d83e3461d72f1bf0785c3e0; install_id=3685200987961118; ttreq=1$6938cb814d01154a3953030daa25ce34fec2296e";
    String x_tt_token = "003dd5eb7e7d83e3461d72f1bf0785c3e095354772adc72045b6572160aba735acacc6e197c4ec983bbd19a20c7dea360ab";

    /**
     * 请求评论者的数据
     *
     * @return
     * @throws IOException
     */
    String device = "os_api=22&device_type=HD1910&ssmix=a&manifest_version_code=100801&dpi=192&uuid=863904335032248&app_name=aweme&version_name=10.8.0&ts=1588163550&app_type=normal&ac=wifi&host_abi=armeabi&update_version_code=10809900&channel=aweGW&_rticket=1588163550414&device_platform=android&iid=1802831481288829&version_code=100800&cdid=b7eae21a-5e61-4d0e-a448-92479f498d6d&openudid=e07b45245c3827ff&device_id=3210206363523879&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=OnePlus&aid=1128&mcc_mnc=46000";

    public String getLastVideo() throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.7333333333333333&pull_type=1&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=121.492479&latitude=31.247221&address_book_access=2&gps_access=1&cached_item_num=0&last_ad_show_interval=-1&os_api=22&device_type=MI%205s&device_platform=android&ssmix=a&iid=3175025109642029&manifest_version_code=715215876&dpi=192&uuid=865531460558214&version_code=850&app_name=aweme&version_name=8.5.0&ts=" + ts + "&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=720*1280&os_version=5.1.1&language=zh&device_brand=Xiaomi&app_type=normal&ac=wifi&update_version_code=715215876&aid=1128&channel=update%2Coppo%2Cvivo%2Chuawei_1%2Cxiaomi%2Cmeizu%2Csamsungapps%2Caweme_gionee%2Csmartisan%2Clephone%2Came_nubiamm%2Czb_xiaomi_awe_mimeng%2Chuawei_pps%2Chuawei_ywjj%2Came_ydzhuomian%2Ctengxun_new%2Cdouyin_tengxun_wzl%2Cbaidu%2C360_aweme%2Cgoapk_aweme%2Cwandoujia_aweme2%2CsougouAD%2Calios%2Cgoogle%2Cbaidu_ss%2Cyingyonghui0305&_rticket=" + _rticket + "&mcc_mnc=46000";
        url = "https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=-1&count=6&volume=0.7333333333333333&pull_type=2&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=121.492479&latitude=31.247221&address_book_access=1&gps_access=1&cached_item_num=3&last_ad_show_interval=-1&mac_address=e0%3A36%3A28%3Ab5%3A7a%3A27&preload_aweme_ids&os_api=22&device_type=MI%205s&ssmix=a&manifest_version_code=920&dpi=192&uuid=862492414825535&app_name=aweme&version_name=9.2.0&ts=" + ts + "&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=2207456677868648&version_code=920&cdid=6017e681-cdd2-456d-9929-aeb584972f40&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=720*1280&os_version=5.1.1&language=zh&device_brand=Xiaomi&aid=1128&mcc_mnc=46003";
        url = "https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=-1&count=6&volume=0.7333333333333333&pull_type=2&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=121.492479&latitude=31.247221&address_book_access=1&gps_access=1&cached_item_num=3&last_ad_show_interval=2&mac_address=72%3A6d%3Ade%3A16%3A95%3A62&preload_aweme_ids=6825572153677647116&os_api=22&device_type=OXF-AN10&ssmix=a&manifest_version_code=920&dpi=216&uuid=868722101253623&app_name=aweme&version_name=9.2.0&ts=" + ts + "&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=2207456677868648&version_code=920&cdid=6017e681-cdd2-456d-9929-aeb584972f40&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=810*1440&os_version=5.1.1&language=zh&device_brand=HUAWEI&aid=1128&mcc_mnc=46001";
        url = "https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=-1&count=6&volume=0.7333333333333333&pull_type=2&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=121.492479&latitude=31.247221&address_book_access=1&gps_access=1&cached_item_num=3&last_ad_show_interval=2&mac_address=72%3A6d%3Ade%3A16%3A95%3A62&preload_aweme_ids=6825572153677647116&" + device;
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        System.out.println();
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "ttnet okhttp/3.10.0.2");
//        headers.put("Host", "api.amemv.com");
        headers.put("x-tt-token", x_tt_token);
        headers.put("Host", "aweme-eagle.snssdk.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        return HttpClientUtil.get(url, null, headers);
    }

    public String getLastVideoByIPhone() throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.7333333333333333&pull_type=1&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=121.492479&latitude=31.247221&address_book_access=2&gps_access=1&cached_item_num=0&last_ad_show_interval=-1&os_api=22&device_type=MI%205s&device_platform=android&ssmix=a&iid=3175025109642029&manifest_version_code=715215876&dpi=192&uuid=865531460558214&version_code=850&app_name=aweme&version_name=8.5.0&ts=" + ts + "&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=720*1280&os_version=5.1.1&language=zh&device_brand=Xiaomi&app_type=normal&ac=wifi&update_version_code=715215876&aid=1128&channel=update%2Coppo%2Cvivo%2Chuawei_1%2Cxiaomi%2Cmeizu%2Csamsungapps%2Caweme_gionee%2Csmartisan%2Clephone%2Came_nubiamm%2Czb_xiaomi_awe_mimeng%2Chuawei_pps%2Chuawei_ywjj%2Came_ydzhuomian%2Ctengxun_new%2Cdouyin_tengxun_wzl%2Cbaidu%2C360_aweme%2Cgoapk_aweme%2Cwandoujia_aweme2%2CsougouAD%2Calios%2Cgoogle%2Cbaidu_ss%2Cyingyonghui0305&_rticket=" + _rticket + "&mcc_mnc=46000";
        url = "https://api3-normal-c-hl.amemv.com/aweme/v2/feed/?ac=4G&is_vcd=1&volume=0.25&action_mask=-1&count=6&mac_address=02%3A00%3A00%3A00%3A00%3A00&longitude=0&user_id=103206846669&type=0&cached_item_num=0&min_cursor=0&address_book_access=0&last_ad_show_interval=-1&is_cold_start=1&gps_access=0&feed_style=0&filter_warn=0&pull_type=0&max_cursor=0&latitude=0&";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "Aweme 10.5.0 rv:105012 (iPhone; iOS 13.3.1; zh_CN) Cronet");
        headers.put("Host", "api3-normal-c-hl.amemv.com");
        headers.put("x-tt-token", x_tt_token);
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        headers.put("x-tt-trace-id", " 00-03490fc809cb607596569a82ea400468-03490fc809cb6075-01");
        headers.put("X-SS-DP", "1128");
        headers.put("x-common-params-v2", " channel=App%20Store&version_code=10.5.0&app_name=aweme&vid=E33504C7-7C2F-4DCB-AA19-9432BB88E6C2&app_version=10.5.0&mcc_mnc=46002&device_id=54593542501&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&os_api=18&os_version=13.3.1&device_platform=iphone&build_number=105012&device_type=iPhone8,2&iid=111027412238&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&js_sdk_version=1.55.0.3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82");
        return HttpClientUtil.get(url, null, headers);
    }

    public String getTalent(String userId) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://api3-core-c-hl.amemv.com/aweme/v1/user/profile/other/?version_code=10.4.0&js_sdk_version=1.55.0.3&app_name=aweme&app_version=10.4.0&device_id=54593542501&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82&os_api=18&ac=WIFI&os_version=13.3.1&device_platform=iphone&build_number=104012&iid=109185113352&device_type=iPhone8,2&is_vcd=1&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&publish_video_strategy_type=2&user_id=" + userId + "&address_book_access=0";
        url = "https://aweme-eagle.snssdk.com/aweme/v1/user/?user_id=" + userId + "&address_book_access=1&ts=" + ts + "&_rticket=" + _rticket + "&" + urlOther;
        url = "https://aweme-eagle.snssdk.com/aweme/v1/user/?user_id=" + userId + "&address_book_access=1&os_api=22&device_type=OXF-AN10&ssmix=a&manifest_version_code=920&dpi=216&uuid=868722101253623&app_name=aweme&version_name=9.2.0&ts=" + ts + "&app_type=normal&ac=wifi&update_version_code=9202&channel=aweGW&_rticket=" + _rticket + "&device_platform=android&iid=2207456677868648&version_code=920&cdid=6017e681-cdd2-456d-9929-aeb584972f40&openudid=f4c3dc16590ada36&device_id=69567395847&resolution=1440*810&os_version=5.1.1&language=zh&device_brand=HUAWEI&aid=1128&mcc_mnc=46001";
        url="https://api3-core-c-lf.amemv.com/aweme/v1/user/profile/other/?user_id="+userId+"&address_book_access=1&from=0&publish_video_strategy_type=2&os_api=22&device_type=vivo%20X7&ssmix=a&manifest_version_code=110001&dpi=480&uuid=862681039226067&app_name=aweme&version_name=11.0.0&ts="+ts+"&cpu_support64=true&app_type=normal&ac=wifi&host_abi=armeabi-v7a&update_version_code=11009900&channel=vivo&_rticket="+_rticket+"&device_platform=android&iid=3685200987961118&version_code=110000&cdid=78f8bdab-1c38-4865-b4d0-2aebd90e4376&openudid=911ddecfa29d0441&device_id=40920273236&resolution=1080*1920&os_version=5.1.1&language=zh&device_brand=vivo&aid=1128";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "com.ss.android.ugc.aweme/110001 (Linux; U; Android 5.1.1; zh_CN; vivo X7; Build/LMY47V; Cronet/TTNetVersion:6c7b701a 2020-04-23 QuicVersion:0144d358 2020-03-24)");
//        headers.put("Host", "api.amemv.com");
        headers.put("Host", "api3-core-c-lf.amemv.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        headers.put("x-tt-trace-id", "00-0329171c09cb60759652c0579fd80468-0329171c09cb6075-01");
        headers.put("x-Tt-Token", x_tt_token);

        return HttpClientUtil.get(url, null, headers);
    }

    public String getVideos(String uid) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://api.amemv.com/aweme/v1/aweme/post/?max_cursor=0&sec_user_id=" + uid + "&count=20&retry_type=no_retry&iid=3175025109642029&device_id=69567395847&ac=wifi&channel=update%2Coppo%2Cvivo%2Chuawei_1%2Cxiaomi%2Cmeizu%2Csamsungapps%2Caweme_gionee%2Csmartisan%2Clephone%2Came_nubiamm%2Czb_xiaomi_awe_mimeng%2Chuawei_pps%2Chuawei_ywjj%2Came_ydzhuomian%2Ctengxun_new%2Cdouyin_tengxun_wzl%2Cbaidu%2C360_aweme%2Cgoapk_aweme%2Cwandoujia_aweme2%2CsougouAD%2Calios%2Cgoogle%2Cbaidu_ss%2Cyingyonghui0305&aid=1128&app_name=aweme&version_code=850&version_name=8.5.0&device_platform=android&ssmix=a&device_type=MI+5s&device_brand=Xiaomi&language=zh&os_api=22&os_version=5.1.1&uuid=865531460558214&openudid=f4c3dc16590ada36&manifest_version_code=715215876&resolution=720*1280&dpi=192&update_version_code=715215876&_rticket=" + _rticket + "&mcc_mnc=46000&ts=" + ts + "&app_type=normal";
        url = "https://api3-core-c-lf.amemv.com/aweme/v1/aweme/post/?source=0&publish_video_strategy_type=2&max_cursor=0&user_id=" + uid + "&count=20&ts=" + ts + "&cpu_support64=true&host_abi=armeabi-v7a&_rticket=" + _rticket + "&os_api=22&device_platform=android&device_type=vivo%20X7&iid=3685200987961118&version_code=110000&app_name=aweme&openudid=911ddecfa29d0441&device_id=40920273236&os_version=5.1.1&aid=1128&channel=vivo&ssmix=a&manifest_version_code=110001&dpi=480&cdid=78f8bdab-1c38-4865-b4d0-2aebd90e4376&version_name=11.0.0&resolution=1080*1920&language=zh&device_brand=vivo&app_type=normal&ac=wifi&update_version_code=11009900&uuid=862681039226067";
        url="https://aweme.snssdk.com/aweme/v1/aweme/post/?max_cursor=0&user_id="+uid+"&count=20&retry_type=no_retry&iid=1134336570564488&device_id=40920273236&ac=wifi&channel=xiaomi&aid=1128&app_name=aweme&version_code=770&version_name=7.7.0&device_platform=android&ssmix=a&device_type=vivo+X7&device_brand=vivo&language=zh&os_api=22&os_version=5.1.1&uuid=862681039226067&openudid=911ddecfa29d0441&manifest_version_code=770&resolution=1080*1920&dpi=480&update_version_code=7702&_rticket="+_rticket+"&ts="+ts+"&app_type=normal";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        cookie = "odin_tt=936da18372bfc517dc422051d26e6965f3df6d173d0579afb5439a1157c7ce7240926b4dec2cd4d45bed318d16090764c90ef54a83f5dff77b0cdbe901b2f136; install_id=1134336570564488; ttreq=1$9cd529f98a6180c663abfc098b4e33ed218fc4a2; qh[360]=1";
        x_tt_token = "003dd5eb7e7d83e3461d72f1bf0785c3e095354772adc72045b6572160aba735acacc6e197c4ec983bbd19a20c7dea360ab";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "com.ss.android.ugc.aweme/770 (Linux; U; Android 5.1.1; zh_CN; vivo X7; Build/LMY47V; Cronet/58.0.2991.0)");
        headers.put("Host", "aweme.snssdk.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
//        headers.put("x-Tt-Token", x_tt_token);
        headers.put("x-tt-trace-id","00-8148677df345b2075e3711109551dbb1-8148677df345b207-01");
        return HttpClientUtil.get(url, null, headers);
    }

    public String getFocus() throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000L);
        String _rticket = System.currentTimeMillis() + "";
        String url = "https://api.amemv.com/aweme/v1/aweme/post/?max_cursor=0&sec_user_id= &count=20&retry_type=no_retry&iid=3175025109642029&device_id=69567395847&ac=wifi&channel=update%2Coppo%2Cvivo%2Chuawei_1%2Cxiaomi%2Cmeizu%2Csamsungapps%2Caweme_gionee%2Csmartisan%2Clephone%2Came_nubiamm%2Czb_xiaomi_awe_mimeng%2Chuawei_pps%2Chuawei_ywjj%2Came_ydzhuomian%2Ctengxun_new%2Cdouyin_tengxun_wzl%2Cbaidu%2C360_aweme%2Cgoapk_aweme%2Cwandoujia_aweme2%2CsougouAD%2Calios%2Cgoogle%2Cbaidu_ss%2Cyingyonghui0305&aid=1128&app_name=aweme&version_code=850&version_name=8.5.0&device_platform=android&ssmix=a&device_type=MI+5s&device_brand=Xiaomi&language=zh&os_api=22&os_version=5.1.1&uuid=865531460558214&openudid=f4c3dc16590ada36&manifest_version_code=715215876&resolution=720*1280&dpi=192&update_version_code=715215876&_rticket=" + _rticket + "&mcc_mnc=46000&ts=" + ts + "&app_type=normal";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        String STUB = "";
        String s = XGorgon.getXGon(params, STUB, cookie);
        String Gorgon = XGorgon.xGorgon(ts, XGorgon.StrToByte(s));
        Map<String, String> headers = new HashMap();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "ttnet okhttp/3.10.0.2");
//        headers.put("Host", "api.amemv.com");
        headers.put("Host", "aweme.snssdk.com");
        headers.put("Cookie", cookie);
        headers.put("Connection", "Keep-Alive");
        headers.put("x-Tt-Token", x_tt_token);
        return HttpClientUtil.get(url, null, headers);
    }

    public ArrayList<String> dealUrl(String s) {
        Pattern pattern = Pattern.compile("https://www.*=title");
        Matcher matcher = pattern.matcher(s);
        HashSet<String> urls = new HashSet<>();
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        ArrayList<String> result = new ArrayList<>();
        for (String url : urls) {
            url = url.split("video/")[1];
            url = url.split("/")[0];
            url = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=" + url;
            result.add(url);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(new DYInterface2().getLastVideo());
        DYInterface2 dyInterface2 = new DYInterface2();
//        System.out.println(dyInterface2.getVideos("MS4wLjABAAAAJSjLx5ZbOY4B3xRQ9KLQaF5MWG60W-V7fhW5wLswyVo"));
        System.out.println(dyInterface2.getVideos("61930778446"));
//        System.out.println(dyInterface2.getTalent("61930778446"));
//        System.out.println(dyInterface2.getLastVideo());
    }

}




