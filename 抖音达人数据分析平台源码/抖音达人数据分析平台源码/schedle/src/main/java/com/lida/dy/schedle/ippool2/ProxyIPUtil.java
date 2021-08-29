package com.lida.dy.schedle.ippool2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.schedle.ippool.util.HttpUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/30 0030 14:11
 * @Version: 1.0
 */
public class ProxyIPUtil {
    private static String url = "http://http.tiqu.alicdns.com/getip3?num=7&type=2&pro=440000&city=0&yys=0&port=1&time=1&ts=0&ys=0&cs=0&lb=1&sb=0&pb=4&mr=1&regions=110000";
    private static List<String> ips = new ArrayList<>();
    private static int index = 0;
    private static int depth = 0;

    public static void main(String[] args) {
        getips();
        next();
    }

    public static void getips() {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String data = reader.readLine();
            JSONObject object = JSON.parseObject(data);
            Integer code = object.getInteger("code");
            if (code == 0) {
                JSONArray jsonArray = object.getJSONArray("data");
                if (jsonArray != null) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject object1 = jsonArray.getJSONObject(i);
                        String ip = object1.getString("ip") + ":" + object1.getInteger("port");
                        ips.add(ip);
                    }
                }
                System.out.println("ip数量： " + ips.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String next() {
        if (depth > 3) {
            return null;
        }
        if (ips != null && ips.size() > 0) {
            if (index >= ips.size()) {
                index = 1;
            }
            index++;
            depth = 0;
            return ips.get(index - 1);
        } else {
            getips();
            depth++;
            return next();
        }
    }
}
