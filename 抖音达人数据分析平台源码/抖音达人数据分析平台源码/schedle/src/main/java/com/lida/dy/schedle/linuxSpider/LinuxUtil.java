package com.lida.dy.schedle.linuxSpider;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/2 0002 11:44
 * @Version: 1.0
 */
public class LinuxUtil {
    public static String path;
    public static LinuxData linuxData;

    public static void init(LinuxConf conf) {
        path = conf.getTempFilePath();
        getLinuxData();
        linuxData.setMaxCatagory();
    }

    private static String getp1AuthorList(int page, int limit, String categoryId) {
        return "https://star.toutiao.com/v/api/demand/author_list/?page=" + page + "&limit=" + limit + "&need_detail=true&platform_source=1&task_category=1&tag=" + categoryId + "&order_by=score";
    }

    public static String getOtherAuthorList(int platformSource, int page, int limit, String categoryName) {
        if (platformSource == 1) {
            return getp1AuthorList(page, limit, categoryName);
        }
        String task_category = platformSource == 2 ? "21" : "41";
        return "https://star.toutiao.com/v/api/demand/author_list/?page=" + page + "&limit=" + limit + "&need_detail=true&platform_source=" + (platformSource + 1) + "&task_category=" + task_category + "&tag=" + getURLEncoderString(categoryName) + "&order_by=score";
    }

    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getVideoUrl(String authorid) {
        int platformSource = linuxData.getPlatformSource();
        platformSource = platformSource == 1 ? platformSource : platformSource + 1;
        return "https://star.toutiao.com/v/api/demand/author_item_data/?author_id=" + authorid + "&platform_source=" + platformSource + "&item_cnt=";
    }
    public static String getVideoUrl(String authorid,String platformSource) {
        return "https://star.toutiao.com/v/api/demand/author_item_data/?author_id=" + authorid + "&platform_source=" + platformSource + "&item_cnt=";

    }

    public static void getLinuxData() {
        BufferedInputStream inputStream = null;
        try {
            File file = new File(path);
            inputStream = new BufferedInputStream(new FileInputStream(file));
            if (inputStream.available() > 1) {
                linuxData = JSON.parseObject(inputStream, LinuxData.class);
            } else {
                throw new FileNotFoundException();
            }

        } catch (Exception e) {
            e.printStackTrace();
            initLinuxData();
            saveLinuxData();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveLinuxData() {
        String s = JSON.toJSONString(linuxData);
        OutputStreamWriter writer = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void initLinuxData() {
        linuxData = new LinuxData();
        linuxData.setCurrentCatagoryNum(1);
        linuxData.setPlatformSource(1);
        linuxData.setLimit(20);
        linuxData.setCurrentTotalCount(0);
    }

    /**
     * 清除数据里的html代码
     *
     * @return
     */
    public static String cleanHtml(String data) {
        String splitStr ="pre-wrap;\">";
        String splitEndStr ="</pre>";
        data =data.split(splitStr)[1];
        return data.split(splitEndStr)[0];
    }


    private static void addPlatformSource() {
        if (linuxData.getPlatformSource() == linuxData.getMaxPlatformSource()) {
            end();
        } else {
            linuxData.setPlatformSource(linuxData.getPlatformSource() + 1);
            linuxData.setCurrentCatagoryNum(1);
        }
    }

    public static void end() {
        System.out.println("====结束======");
        saveLinuxData();
    }
    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
    public static void main(String[] args) {
        path = "E:\\桌面\\dy\\linuxData\\linuxTemp.txt";
        getLinuxData();
        linuxData.setTotalCount(10);
        for (int i = 0; i < 9; i++) {
            linuxData.addTalent();
        }
        linuxData.addTalent();
        linuxData.addTalent();
        System.out.println(linuxData.getPage());
        System.out.println(getURLEncoderString("少人"));

    }
}
