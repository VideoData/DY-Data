package com.lida.dy.schedle.ippool;

import com.lida.dy.schedle.ippool.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/28 0028 18:08
 * @Version: 1.0
 */
public class IPSpider {
    private final String HTTP_API = "https://www.xicidaili.com/wt/";
    private final String HTTPS_API = "https://www.xicidaili.com/wn/";

    private List<IPBean> ipList = new ArrayList<>();

    // 爬取的页数----每页包含100个IP
    private int pages = 5;


    public IPSpider() {
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<IPBean> crawlHttp() {
        List<IPBean> ipBeans = new ArrayList<>();
        for (int page = 1; page <= pages; page++) {
            ipBeans.addAll(crawl(HTTP_API, page));
        }
        return ipBeans;
    }

    public List<IPBean> crawlHttp(int pages) {
        this.pages = pages;
        return crawlHttp();
    }

    public List<IPBean> crawlHttps() {
        List<IPBean> ipBeans = new ArrayList<>();
        for (int page = 1; page <= pages; page++) {
            ipBeans.addAll(crawl(HTTPS_API, page));
        }
        return ipBeans;
    }

    public List<IPBean> crawlHttps(int pages) {
        this.pages = pages;
        return crawlHttps();
    }

    private List<IPBean> crawl(String api, int index) {
        String html = HttpUtils.getResponseContent(api + index);
        System.out.println(html);

        Document document = Jsoup.parse(html);
        Elements eles = document.selectFirst("table").select("tr");

        for (int i = 0; i < eles.size(); i++) {
            if (i == 0) {
                continue;
            }
            Element ele = eles.get(i);
            String ip = ele.children().get(1).text();
            int port = Integer.parseInt(ele.children().get(2).text().trim());
            String typeStr = ele.children().get(5).text().trim();

            int type;
            if ("HTTP".equalsIgnoreCase(typeStr)) {
                type = IPBean.TYPE_HTTP;
            } else {
                type = IPBean.TYPE_HTTPS;
            }

            IPBean ipBean = new IPBean(ip, port, type);
            ipList.add(ipBean);
        }
        return ipList;
    }
}
