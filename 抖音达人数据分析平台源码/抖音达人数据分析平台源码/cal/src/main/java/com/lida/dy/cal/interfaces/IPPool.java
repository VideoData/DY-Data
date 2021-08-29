package com.lida.dy.cal.interfaces;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.spider.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPPool {
    public static int page = 0;

    public static List<String> getIP() throws IOException {
        page++;
        Map<String, String> headers = new HashMap();
        headers.put("Cookie", "_free_proxy_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFVEkiJWU1ZmVmZjE3YzhjNDZhMTRlYzM1MDc3ODUyYTVjNjRiBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMTFHVDdyUStacExXQ0FsekZCa2hoTEVvMysxdDdhNSs2Z0s2MTh2TU1yWkU9BjsARg%3D%3D--95b74cfc8a839b90308c781f8295acdfa47f74e5; Hm_lvt_0cf76c77469e965d2957f0553e6ecf59=1589349923; Hm_lpvt_0cf76c77469e965d2957f0553e6ecf59=1589349923");
        headers.put("Host", " www.xicidaili.com");
        headers.put("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0");
        headers.put("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Connection", "keep-alive");
        headers.put("Accept-Language", " zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        String s = HttpClientUtil.get("https://www.xicidaili.com/nn/" + page, null, headers);
        Document document = Jsoup.parse(s);
        Elements tbody = document.getElementsByTag("tr");
        ArrayList<String> ips = new ArrayList<>();
        for (Element element : tbody) {
            Elements td = element.getElementsByTag("td");
            if (td.size() > 0) {
                Element element1 = td.get(1);
                String text = element1.text();
                text += (":" + td.get(2).text());
                ips.add(text.trim());
            }
        }
        return ips;
    }

    public static String getIP2() throws IOException {
        String url = "http://ip.11jsq.com/index.php/api/entry?method=proxyServer.generate_api_url&packid=0&fa=0&fetch_key=&groupid=0&qty=1&time=3&pro=%E5%B9%BF%E4%B8%9C%E7%9C%81&city=%E4%B8%9C%E8%8E%9E%E5%B8%82&port=1&format=json&ss=5&css=&ipport=1&dt=1&specialTxt=3&specialJson=&usertype=16";        String s = HttpClientUtil.get(url);
        JSONObject jsonObject = JSONObject.parseObject(s);
        ArrayList<String> strings = new ArrayList<>();
        JSONArray data = jsonObject.getJSONArray("data");
        return data.getJSONObject(0).getString("IP");
    }

    public static void main(String[] args) {
        try {
            List<String> ip = getIP();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
