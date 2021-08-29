package com.lida.dy.cal.interfaces;

import com.lida.dy.cal.spider.HttpClientUtil;
import org.apache.http.HttpHost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WEBSpiderDy {
    /**
     * 映射关系
     */
    public static Map<String, String> analyCode = new HashMap<>(0);

    static {
        analyCode.put("0xe602", "1");
        analyCode.put("0xe603", "0");
        analyCode.put("0xe604", "3");
        analyCode.put("0xe605", "2");
        analyCode.put("0xe606", "4");
        analyCode.put("0xe607", "5");
        analyCode.put("0xe608", "6");
        analyCode.put("0xe609", "9");
        analyCode.put("0xe60a", "7");
        analyCode.put("0xe60b", "8");
        analyCode.put("0xe60c", "4");
        analyCode.put("0xe60d", "0");
        analyCode.put("0xe60e", "1");
        analyCode.put("0xe60f", "5");
        analyCode.put("0xe610", "2");
        analyCode.put("0xe611", "3");
        analyCode.put("0xe612", "6");
        analyCode.put("0xe613", "7");
        analyCode.put("0xe614", "8");
        analyCode.put("0xe615", "9");
        analyCode.put("0xe616", "0");
        analyCode.put("0xe617", "2");
        analyCode.put("0xe618", "1");
        analyCode.put("0xe619", "4");
        analyCode.put("0xe61a", "3");
        analyCode.put("0xe61b", "5");
        analyCode.put("0xe61c", "7");
        analyCode.put("0xe61d", "8");
        analyCode.put("0xe61e", "9");
        analyCode.put("0xe61f", "6");
    }

    /**
     * 正则匹配表达式
     */
    public static final Pattern PATTERN_NICKNAME = Pattern.compile("<p class=\"nickname\">(.*?)<");
    public static final Pattern PATTERN_SIGNATURE = Pattern.compile("<p class=\"signature\">([\\S\\s]*?)<");

    public static final Pattern PATTERN_ID = Pattern.compile("<p class=\"shortid\">抖音ID：(.*?)<");
    public static final Pattern PATTERN_ID_BLOCK = Pattern.compile("<p class=\"shortid\">([\\S\\s]*?)</p>");
    public static final Pattern PATTERN_ICON_FONT = Pattern.compile("<i class=\"icon iconfont \"> (.*?) </i>");

    public static final Pattern PATTERN_FOCUS_BLOCK = Pattern.compile("<span class=\"focus block\"><span class=\"num\">(.*?)</span>");
    public static final Pattern PATTERN_FANS_BLOCK = Pattern.compile("<span class=\"follower block\"><span class=\"num\">(.*?)</span>");
    public static final Pattern PATTERN_LIKE_NUM_BLOCK = Pattern.compile("<span class=\"liked-num block\"><span class=\"num\">(.*?)</span>");
    public static final Pattern PATTERN_FOLLOW_NUM = Pattern.compile("<i class=\"icon iconfont follow-num\"> (.*?) </i>|\\.|w ");

    public static final Pattern PATTERN_POST_BLOCK = Pattern.compile("<div class=\"user-tab active tab get-list\" data-type=\"post\">作品<span class=\"num\">(.*?)</span>");
    public static final Pattern PATTERN_LIKE_BLOCK = Pattern.compile("<div class=\"like-tab tab get-list\" data-type=\"like\">喜欢<span class=\"num\">(.*?)</span>");
    public static final Pattern PATTERN_TAB_NUM = Pattern.compile("<i class=\"icon iconfont tab-num\"> (.*?) </i>");

    /**
     * 正则匹配获取基础信息
     *
     * @param homepageHtml 页面HTML代码
     * @param pattern      基础信息正则表达式
     * @return java.lang.StringBuilder
     * @author LKET
     * @date 2019/11/21 下午3:51
     */
    public static String getUserInfo(String homepageHtml, Pattern pattern) {
        String info = "";
        Matcher matcher = pattern.matcher(homepageHtml);
        if (matcher.find()) {
            info = matcher.group(1).trim();
        }
        return info;
    }

    /**
     * 正则匹配获取真实数值
     *
     * @param homepageHtml 页面HTML代码
     * @param blockPattern 外层class正则表达式
     * @param numPattern   数值class正则表达式
     * @return java.lang.StringBuilder
     * @author LKET
     * @date 2019/11/21 下午3:51
     */
    public static StringBuilder getTrueNum(String homepageHtml, Pattern blockPattern, Pattern numPattern) {
        StringBuilder trueNum = new StringBuilder();
        Matcher matcherBlock = blockPattern.matcher(homepageHtml);
        if (matcherBlock.find()) {
            Matcher matcherNumList = numPattern.matcher(matcherBlock.group(1));
            while (matcherNumList.find()) {
                // 判断是否包含i标签，包含转数字，不包含则为.w字符
                if (matcherNumList.group(0).contains("<i")) {
                    String code = matcherNumList.group(1).replace("&#", "0").replace(";", "");
                    String number = analyCode.get(code);
                    trueNum.append(number);
                } else {
                    trueNum.append(matcherNumList.group(0));
                }
            }
        }
        return trueNum;
    }

    /**
     * 获取抖音用户基本数据
     */
    public static void main(String[] args) throws IOException {
        String talent = gettalent("100121486268");
        dealTalentWithWeb(talent,null);
    }

//    static String ip = getProxyIP();
    static String ip ;

    public static String gettalent(String id) throws IOException {
        String url = "https://www.iesdouyin.com/share/user/" + id;
        String cookie = "tt_webid=6815163373467043335; _ba=BA0.2-20200413-5199e-qhizb5NPm6hzOe7PqaCx; _ga=GA1.2.858585721.1586778881; _gid=GA1.2.1365561669.1589285856";
        Map<String, String> headers = new HashMap();
        headers.put("Host", "www.iesdouyin.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0");
        headers.put("pragma", "no-cache");
        headers.put(":authority", "www.iesdouyin.com");
        return HttpClientUtil.get(url, null, headers);
//        while (true) {
//            try {
//                HttpHost proxy = new HttpHost(ip.split(":")[0], Integer.parseInt(ip.split(":")[1].trim()));
//                String s = HttpClientUtil.get(url, null, headers, proxy);
//                System.out.println(s.length());
//                while (s.length() < 2000) {
//                    ip = getProxyIP();
//                    proxy = new HttpHost(ip.split(":")[0], Integer.parseInt(ip.split(":")[1].trim()));
//                    s = HttpClientUtil.get(url, null, headers, proxy);
//                }
//                return s;
//            } catch (Exception e) {
//                ip = getProxyIP();
//            }
//        }
    }

    static String ips ;
    static int offsetIP = 0;

    public static String getProxyIP() {
        return "";
    }

    public static void dealTalentWithWeb(String talent, ArrayList<String> video) {
        String nickname = getUserInfo(talent, PATTERN_NICKNAME);
        System.out.println("昵称：" + nickname);
        String id = getUserInfo(talent, PATTERN_ID);
        if (id.isEmpty()) {
            id = getTrueNum(talent, PATTERN_ID_BLOCK, PATTERN_ICON_FONT).toString();
        }
        System.out.println("抖音id：" + id);
        String signature = getUserInfo(talent, PATTERN_SIGNATURE);
        System.out.println("用户签名：" + signature);
        StringBuilder focusNum = getTrueNum(talent, PATTERN_FOCUS_BLOCK, PATTERN_FOLLOW_NUM);
        System.out.println("粉丝数：" + focusNum);
        StringBuilder fansNum = getTrueNum(talent, PATTERN_FANS_BLOCK, PATTERN_FOLLOW_NUM);
        System.out.println("粉丝数：" + fansNum);
        StringBuilder likeNumNum = getTrueNum(talent, PATTERN_LIKE_NUM_BLOCK, PATTERN_FOLLOW_NUM);
        System.out.println("点赞数：" + likeNumNum);
        StringBuilder postNum = getTrueNum(talent, PATTERN_POST_BLOCK, PATTERN_TAB_NUM);
        System.out.println("作品数：" + postNum);
        StringBuilder likeNum = getTrueNum(talent, PATTERN_LIKE_BLOCK, PATTERN_TAB_NUM);
        System.out.println("喜欢数：" + likeNum);
        video.add(fansNum.toString());
        video.add(likeNumNum.toString());
    }
}
