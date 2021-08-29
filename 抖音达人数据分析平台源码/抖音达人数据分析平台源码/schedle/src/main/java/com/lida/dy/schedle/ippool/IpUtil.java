package com.lida.dy.schedle.ippool;

import com.google.gson.Gson;
import com.lida.dy.schedle.ippool.util.IPUtils;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/28 0028 18:05
 * @Version: 1.0
 */
public class IpUtil {
    private static int i = 0;
    private static List<IPBean> ips = null;

    public static List<IPBean> getIpList() {
        System.out.println("Start: ");

        IPSpider spider = new IPSpider();
        List<IPBean> list = spider.crawlHttp(6);

        System.out.println("爬取数量：" + list.size());

        Gson gson = new Gson();
        for (IPBean ipBean : list) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean valid = IPUtils.isValid(ipBean);
                    if (valid) {
                        IPList.add(ipBean);
                    }
                    IPList.increase();
                }
            }).start();
        }

        while (true) {
            // 判断所有副线程是否完成
            if (IPList.getCount() == list.size()) {
                System.out.println("有效数量：" + IPList.getSize());
                break;
            }
        }
        return IPList.getips();
    }

    public static String next() {
        if (ips == null) {
            ips = getIpList();
        }
        if (i >= ips.size()) {
            i = 0;
        }
        i++;
        return ips.get(i - 1).getIp() + ":" + ips.get(i - 1).getPort();
    }
}
