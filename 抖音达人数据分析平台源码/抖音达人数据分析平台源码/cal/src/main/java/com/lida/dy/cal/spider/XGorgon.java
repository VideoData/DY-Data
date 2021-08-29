package com.lida.dy.cal.spider;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//抖音注册设备号api：https://ib.snssdk.com/service/2/device_register/?

//首先要用自己抖音账号登录，然后使用fiddle抓包，（android手机不能使用7.0或以上的版本抓，会抓不到https）
//随便抓一个url 拿到其中的cookie和url ，url用里面的从 iid开始往后面的参数 拼接在你要请求的url后面 再加上最新的时间戳和ascp算法
public class XGorgon {

    public static String byteTable1 =
            "D6 28 3B 71 70 76 BE 1B A4 FE 19 57 5E 6C BC 21 B2 14 37 " +
                    "7D 8C A2 FA 67 55 6A 95 E3 FA 67 78 ED 8E 55 33 " +
                    "89 A8 CE 36 B3 5C D6 B2 6F 96 C4 34 B9 6A EC 34 " +
                    "95 C4 FA 72 FF B8 42 8D FB EC 70 F0 85 46 D8 B2 " +
                    "A1 E0 CE AE 4B 7D AE A4 87 CE E3 AC 51 55 C4 36 " +
                    "AD FC C4 EA 97 70 6A 85 37 6A C8 68 FA FE B0 33 " +
                    "B9 67 7E CE E3 CC 86 D6 9F 76 74 89 E9 DA 9C 78 " +
                    "C5 95 AA B0 34 B3 F2 7D B2 A2 ED E0 B5 B6 88 95 " +
                    "D1 51 D6 9E 7D D1 C8 F9 B7 70 CC 9C B6 92 C5 FA " +
                    "DD 9F 28 DA C7 E0 CA 95 B2 DA 34 97 CE 74 FA 37 " +
                    "E9 7D C4 A2 37 FB FA F1 CF AA 89 7D 55 AE 87 BC " +
                    "F5 E9 6A C4 68 C7 FA 76 85 14 D0 D0 E5 CE FF 19 " +
                    "D6 E5 D6 CC F1 F4 6C E9 E7 89 B2 B7 AE 28 89 BE " +
                    "5E DC 87 6C F7 51 F2 67 78 AE B3 4B A2 B3 21 3B " +
                    "55 F8 B3 76 B2 CF B3 B3 FF B3 5E 71 7D FA FC FF " +
                    "A8 7D FE D8 9C 1B C4 6A F9 88 B5 E5";

    public static String[] byteTable2 = byteTable1.split(" ");
    private static final String NULL_MD5_STRING = "00000000000000000000000000000000";

    public static String cookies = "sid_tt=74c52723180b10978d083d14fced36f2; uid_tt=593003c106c6de4a1198fb10ff9053f4; ttreq=1$85338baf79830fee82d11295117fc897e8d76892; sid_guard=74c52723180b10978d083d14fced36f2%7C1548476024%7C5184000%7CWed%2C+27-Mar-2019+04%3A13%3A44+GMT; odin_tt=7f57a517a48a1d2ad03e716ced77e48c8b03b7aa786c21e21a8a4ab7b4aae1521cf947f5fa106b969fd94ffc6b6003a372470eef06deeb01a8e550e0fc5689aa; install_id=50651589426; sessionid=74c52723180b10978d083d14fced36f2";


    /**
     * STUB算法是这样来的  把抖音api的body参数按照如下拼接 然后使用encryption加密获取到 注意是body参数 并不是url后面跟的参数QueryString
     * String Str = "aweme_id=6759108056103128333&channel_id=0&type=1";
     * String STUB = XGorgon.encryption(Str);
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        int ts = (int) (System.currentTimeMillis() / 1000);
        String _rticket = System.currentTimeMillis() + "";

        String sessionid = "";
        //String k = "os_api=22&device_type=SM-G925F&ssmix=a&manifest_version_code=570&dpi=192&uuid=867585507125724&app_name=aweme&version_name=5.7.0&unbind_exist=35&retry_type=no_retry&auto_read=0&ac=wifi&channel=tengxun_new&update_version_code=5702&type=3731&_rticket=" + _rticket + "&device_platform=android&iid=67982304031&mix_mode=1&mobile=2e3d332534303025373235312534303336&version_code=570&openudid=2021049774027898&device_id=50624531127&resolution=720*1280&device_brand=samsung&language=zh&os_version=5.1.1&account_sdk_source=app&aid=1128&mcc_mnc=46000";

        //这段参数是从fiddle抓包抓取的url中截取出来的  拼接在我要请求的url后面。iid=84579705899&device_id=69367187550&ac=wifi&channel=douyin_lite_gw&aid=2329&app_name=douyin_lite&version_code=180&version_name=1.8.0&device_platform=android&ssmix=a&device_type=Redmi+Note+7+Pro&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&openudid=e4680b0d0446ad09&manifest_version_code=180&resolution=1080*2119&dpi=440&update_version_code=1800&_rticket=1573653896264

        //url  跟  cookie  要对应的 . device_id不是随便写额
        //String url = "https://aweme.snssdk.com/aweme/v1/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.8666666666666667&pull_type=2&need_relieve_aweme=0&filter_warn=0&req_from=&is_cold_start=0&iid=84579705899&device_id=69367187550&ac=wifi&channel=douyin_lite_gw&aid=2329&app_name=douyin_lite&version_code=180&version_name=1.8.0&device_platform=android&ssmix=a&device_type=Redmi+Note+7+Pro&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&openudid=e4680b0d0446ad09&manifest_version_code=180&resolution=1080*2119&dpi=440&update_version_code=1800&_rticket=" + _rticket + "&ts=" + ts + "&js_sdk_version=1.10.4&as=a1iosdfgh&cp=androide1";
        //String loveUrl = "https://api.amemv.com/aweme/v1/commit/item/digg/?aweme_id=6716988402044079372&type=1&retry_type=no_retry&iid=68200767941&device_id=50624531127&ac=wifi&channel=huanliang&aid=1128&app_name=aweme&version_code=230&version_name=2.3.0&device_platform=android&ssmix=a&device_type=MI+6&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=867391038812504&openudid=26b3dc2e1d807ca8&manifest_version_code=230&resolution=1080*1920&dpi=480&update_version_code=-1&_rticket="+_rticket+"&ts="+ts+"&js_sdk_version=1.10.4&as=a1iosdfgh&cp=androide1";
        //  String nearbyUrl = "https://api.amemv.com/aweme/v1/nearby/feed/?max_cursor=0&min_cursor=0&count=20&feed_style=1&retry_type=no_retry&iid=84579705899&device_id=69367187550&ac=wifi&channel=douyin_lite_gw&aid=2329&app_name=douyin_lite&version_code=180&version_name=1.8.0&device_platform=android&ssmix=a&device_type=Redmi+Note+7+Pro&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&openudid=e4680b0d0446ad09&manifest_version_code=180&resolution=1080*2119&dpi=440&update_version_code=1800&_rticket=" + _rticket + "&ts=" + ts + "&js_sdk_version=1.10.4&as=a1iosdfgh&cp=androide1";
        //String videoDetailUrl= "https://aweme-hl.snssdk.com/aweme/v1/aweme/detail/?aweme_id=6690823026625219848&retry_type=no_retry&mcc_mnc=46001&iid=84579705899&device_id=69367187550&ac=wifi&channel=douyin_lite_gw&aid=2329&app_name=douyin_lite&version_code=180&version_name=1.8.0&device_platform=android&ssmix=a&device_type=Redmi+Note+7+Pro&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&openudid=e4680b0d0446ad09&manifest_version_code=180&resolution=1080*2119&dpi=440&update_version_code=1800&_rticket="+_rticket+"&ts="+ts+"&js_sdk_version=1.10.4&as=a1iosdfgh&cp=androide1";
        String url = "https://aweme-hl.snssdk.com/aweme/v1/aweme/detail/?aweme_id=6690823026625219848&retry_type=no_retry&mcc_mnc=46001&iid=84579705899&device_id=69367187550&ac=wifi&channel=douyin_lite_gw&aid=2329&app_name=douyin_lite&version_code=180&version_name=1.8.0&device_platform=android&ssmix=a&device_type=Redmi+Note+7+Pro&device_brand=Xiaomi&language=zh&os_api=28&os_version=9&openudid=e4680b0d0446ad09&manifest_version_code=180&resolution=1080*2119&dpi=440&update_version_code=1800&_rticket=" + _rticket + "&ts=" + ts + "&js_sdk_version=1.10.4&as=a1iosdfgh&cp=androide1";
        String commentUrl = " https://api3-normal-c-hl.amemv.com/aweme/v2/comment/list/?version_code=10.4.0&js_sdk_version=1.55.0.3&app_name=aweme&vid=E33504C7-7C2F-4DCB-AA19-9432BB88E6C2&app_version=10.4.0&device_id=54593542501&channel=App%20Store&mcc_mnc=46002&aid=1128&screen_width=1242&openudid=e61d16c77dde079114262ea292a3f0e3b51e28f3&cdid=F417DDA0-CAF2-4E2B-B20F-C1E9C5CBBD82&os_api=18&ac=WIFI&os_version=13.3.1&device_platform=iphone&build_number=104012&iid=109185113352&device_type=iPhone8,2&is_vcd=1&idfa=648A4394-1A50-4178-B2C6-4A661ADE2936&cursor=0&forward_page_type=1&insert_ids=&gps_access=0&address_book_access=0&count=20&hotsoon_has_more=0&hotsoon_filtered_count=0&channel_id=3&aweme_id=6804782838399945997&city=440600";
        String params = url.substring(url.indexOf("?") + 1, url.length());
        //String STUB = encryption(k).toUpperCase();
        String STUB = "";
        String s = getXGon(params, STUB, cookies);


        String Gorgon = xGorgon(ts, StrToByte(s));
        System.err.println("Gorgon=" + Gorgon);
        System.err.println(url);

        long ticket = System.currentTimeMillis();
        long time = ticket / 1000;
        System.err.println("ts             =" + ts);
        System.err.println("time           =" + time);
        System.err.println("X-SS-REQ-TICKET=" + _rticket);
        System.err.println("X-Khronos      =" + ts);

        Map<String, String> headers = new HashMap<>();
        headers.put("X-Gorgon", Gorgon);
        headers.put("X-Khronos", ts + "");
        headers.put("sdk-version", "1");
        headers.put("Accept-Encoding", "gzip");
        headers.put("X-SS-REQ-TICKET", _rticket);
        headers.put("User-Agent", "com.ss.android.ugc.aweme/700 (Linux; U; Android 8.0.0; zh_CN; MIX 2; Build/NRD90M; Cronet/58.0.2991.0)");
        //headers.put("X-Tt-Token","0074c52723180b10978d083d14fced36f2657c568e39488298d5647c37a3a5cc121057ae220e72a63922b6ccbb02c28ad64");
        headers.put("Host", "aweme.snssdk.com");
        headers.put("Cookie", cookies);
        headers.put("Connection", "Keep-Alive");

//        String json = HttpClientUtil.get(url,headers,null,"UTF-8",null);
        String json = HttpClientUtil.get(url, null, headers);
        System.err.println(json);


    }

    public static String structCommentUrl(String vid,String deviceId) {
        return null;
    }

    public static String ByteToStr(byte[] bArr) {

        int i = 0;

        char[] toCharArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        while (i < bArr.length) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = toCharArray[i2 >>> 4];
            cArr[i3 + 1] = toCharArray[i2 & 15];
            i++;
        }
        return new String(cArr);

    }

    public static byte[] StrToByte(String str) {
        String str2 = str;
        Object[] objArr = new Object[1];
        int i = 0;
        objArr[0] = str2;

        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        while (i < length) {
            bArr[i / 2] = (byte) ((Character.digit(str2.charAt(i), 16) << 4) + Character.digit(str2.charAt(i + 1), 16));
            i += 2;
        }
        return bArr;
    }

    public static String encryption(String str) {
        String re_md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5.toUpperCase();
    }

    public static String getXGon(String url, String stub, String cookies) {
        StringBuilder sb = new StringBuilder();
        if (url != null && !url.isEmpty()) {
            sb.append(NULL_MD5_STRING);
        } else {
            sb.append(encryption(url).toLowerCase());
        }

        if (stub != null && !stub.isEmpty()) {
            sb.append(NULL_MD5_STRING);
        } else {
            sb.append(stub);
        }


        if (cookies != null && !cookies.isEmpty()) {
            sb.append(NULL_MD5_STRING);
        } else {
            sb.append(encryption(cookies).toLowerCase());
        }
        /*

        if (TextUtils.isEmpty(sessionid)) {
            sb.append(NULL_MD5_STRING);
        } else {
            sb.append(encryption(sessionid).toLowerCase());
        }*/
        int index = cookies.indexOf("sessionid=");
        if (index == -1) {
            sb.append(NULL_MD5_STRING);
        } else {
            String sessionid = StringUtils.substringBetween(cookies, "sessionid=", ";");
            if (sessionid == null) {//sessionid在cookie字符串中的最后
                sessionid = cookies.substring(index + 10);
            }
            sb.append(encryption(sessionid).toLowerCase());
        }

        return sb.toString();
    }

    public static ArrayList<String> input(int timeMillis, byte[] inputBytes) {


        ArrayList<String> byteTable = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (inputBytes[i] < 0) {
                byteTable.add(Integer.toHexString(inputBytes[i]).substring(6));
            } else {
                byteTable.add(Integer.toHexString(inputBytes[i]));
            }
        }
        for (int i = 0; i < 4; i++) {
            byteTable.add("0");
        }
        for (int i = 32; i < 36; i++) {
            if (inputBytes[i] < 0) {
                byteTable.add(Integer.toHexString(inputBytes[i]).substring(6));
            } else {
                byteTable.add(Integer.toHexString(inputBytes[i]));
            }
        }
        for (int i = 0; i < 4; i++) {
            byteTable.add("0");
        }
        String timeByte = Integer.toHexString(timeMillis);
        for (int i = 0; i < 4; i++) {
            byteTable.add(timeByte.substring(2 * i, 2 * i + 2));
        }
        return byteTable;
    }

    private static ArrayList<String> initialize(ArrayList<String> data) {

        int hex = 0;
        byteTable2 = byteTable1.split(" ");
        for (int i = 0; i < data.size(); i++) {
            int hex1 = 0;
            if (i == 0) {
                hex1 = Integer.valueOf(byteTable2[Integer.valueOf(byteTable2[0], 16) - 1], 16);
                byteTable2[i] = Integer.toHexString(hex1);
            } else if (i == 1) {
                int temp = Integer.valueOf("D6", 16) + Integer.valueOf("28", 16);
                if (temp > 256) {
                    temp -= 256;
                }
                hex1 = Integer.valueOf(byteTable2[temp - 1], 16);
                hex = temp;
                byteTable2[i] = Integer.toHexString(hex1);
            } else {
                int temp = hex + Integer.valueOf(byteTable2[i], 16);
                if (temp > 256) {
                    temp -= 256;
                }
                hex1 = Integer.valueOf(byteTable2[temp - 1], 16);
                hex = temp;
                byteTable2[i] = Integer.toHexString(hex1);
            }
            if (hex1 * 2 > 256) {
                hex1 = hex1 * 2 - 256;
            } else {
                hex1 = hex1 * 2;
            }

            String hex2 = byteTable2[hex1 - 1];
            int result = Integer.valueOf(hex2, 16) ^ Integer.valueOf(data.get(i), 16);
            data.set(i, Integer.toHexString(result));
        }
        return data;
    }

    public static ArrayList<String> handle(ArrayList<String> data) {

        for (int i = 0; i < data.size(); i++) {
            String byte1 = data.get(i);
            if (byte1.length() < 2) {
                byte1 += "0";
            } else {
                byte1 = data.get(i).split("")[1] + data.get(i).split("")[0];
            }
            if (i < data.size() - 1) {
                byte1 = Integer.toHexString(Integer.valueOf(byte1, 16) ^ Integer.valueOf(data.get(i + 1), 16));
            } else {
                byte1 = Integer.toHexString(Integer.valueOf(byte1, 16) ^ Integer.valueOf(data.get(0), 16));
            }
            int byte2 = ((Integer.valueOf(byte1, 16) & Integer.valueOf("55", 16)) * 2) | ((Integer.valueOf(byte1, 16) & Integer.valueOf("AA", 16)) / 2);
            byte2 = ((byte2 & Integer.valueOf("33", 16)) * 4) | ((byte2 & Integer.valueOf("CC", 16)) / 4);
            String byte3 = Integer.toHexString(byte2);
            if (byte3.length() > 1) {
                byte3 = byte3.split("")[1] + byte3.split("")[0];
            } else {
                byte3 += "0";
            }
            int byte4 = Integer.valueOf(byte3, 16) ^ Integer.valueOf("FF", 16);
            byte4 = byte4 ^ Integer.valueOf("14", 16);
            data.set(i, Integer.toHexString(byte4));
        }
        return data;
    }

    public static String xGorgon(int timeMillis, byte[] inputBytes) {

        ArrayList<String> data1 = new ArrayList<>();
        data1.add("3");
        data1.add("61");
        data1.add("41");
        data1.add("10");
        data1.add("80");
        data1.add("0");

        ArrayList<String> data2 = input(timeMillis, inputBytes);
        data2 = initialize(data2);
        data2 = handle(data2);
        data1.addAll(data2);

        String xGorgonStr = "";
        for (int i = 0; i < data1.size(); i++) {
            String temp = String.valueOf(data1.get(i));
            if (temp.length() > 1) {
                xGorgonStr += temp;
            } else {
                xGorgonStr += "0";
                xGorgonStr += temp;
            }
        }

        return xGorgonStr;
    }

}
