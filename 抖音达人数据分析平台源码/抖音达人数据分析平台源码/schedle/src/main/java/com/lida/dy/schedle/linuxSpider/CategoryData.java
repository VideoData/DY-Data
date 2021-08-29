package com.lida.dy.schedle.linuxSpider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/3 0003 17:40
 * @Version: 1.0
 */
public class CategoryData {
    public static String categoryPath;
    public static JSONObject categoryJsonObject = null;

    public static void init(LinuxConf conf) {
        categoryPath = conf.getCategoryFilePath();
        getCategoryJsonObject();
    }

    /**
     * 读取分类数据
     */
    private static void getCategoryJsonObject() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(categoryPath))));
            String text = "";
            while (reader.read() > -1) {
                text += reader.readLine();
            }
            text = text.replace("\n", "");
            text = text.replace("\\s", "");
            text = text.replace("\t", "");
            categoryJsonObject = JSONObject.parseObject(text);
            System.out.println(categoryJsonObject.getString("platformSource1"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取分类
     *
     * @return
     */
    public static String getCategory(int platformSource, int index) {
        if (categoryJsonObject == null) {
            getCategoryJsonObject();
        }
        if (platformSource == 1) {
            JSONArray platformSource1 = categoryJsonObject.getJSONArray("platformSource1");
            if (index > platformSource1.size()) {
                return null;
            } else {
                JSONObject jsonObject = platformSource1.getJSONObject(index - 1).getJSONObject("first");
                Set<String> keySet = jsonObject.keySet();
                for (String s : keySet) {
                    return s;
                }
            }
        } else {
            JSONArray jsonArray = categoryJsonObject.getJSONArray("platformSource" + platformSource);
            if (index > jsonArray.size()) {
                return null;
            } else {
                return jsonArray.getString(index - 1);
            }
        }
        return null;
    }

    public static int getCategoryTotal(int platformSource) {
        JSONArray categoryArray = categoryJsonObject.getJSONArray("platformSource" + platformSource);
        return categoryArray.size();
    }

    public static void main(String[] args) {
        categoryPath = "E:\\桌面\\dy\\linuxData\\category.json";
        System.out.println(getCategoryTotal(1));
        getCategoryJsonObject();
    }
}