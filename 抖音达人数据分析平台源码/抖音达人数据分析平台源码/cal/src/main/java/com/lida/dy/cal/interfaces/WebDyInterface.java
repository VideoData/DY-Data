package com.lida.dy.cal.interfaces;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.spider.HttpClientUtil;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class WebDyInterface {
    ChromeDriver driver;
    @Value("${my.linux.chrome}")
    private String chrome;
    @Value("${my.linux.hasChrome}")
    private boolean hasChrome;
    @Value("${my.linux.hasUi}")
    private boolean hasUi;
    @Value("${my.signatureHtml}")
    private String signatureHtmlpath;

    public void init() {
        if (hasChrome) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }
        if (driver != null) {
            driver.close();
        }
        System.out.println("start ....................");
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置为 headless 模式 （无头浏览器）
        if (!hasUi) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        System.out.println("drive:" + driver != null);
    }

    public String getByUrl(String url, boolean isClean) {
        driver.get(url);
        String pageSource = driver.getPageSource();
        if (isClean) {
            pageSource = cleanHtml(pageSource);
        }
        return pageSource;
    }

    public static String cleanHtml(String data) {
        String splitStr = "pre-wrap;\">";
        String splitEndStr = "</pre>";
        data = data.split(splitStr)[1];
        return data.split(splitEndStr)[0];
    }

    public static void main(String[] args) {
        WebDyInterface webDyInterface = new WebDyInterface();
        webDyInterface.init();
        webDyInterface.getByUrl("https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=6824738047448435972", true);
    }

    public JSONArray getVideo(String uid, String short_id) {
        int times = 0;
        String signature = getByUrl(signatureHtmlpath + "?a=" + short_id.trim(), false);
        signature = signature.split("</script>")[1].split("</body>")[0].trim();
        do {
            times++;
            String videos = getByUrl("https://www.iesdouyin.com/web/api/v2/aweme/post/?user_id=" + uid + "&sec_uid=&count=21&max_cursor=0&aid=1128&_signature=" + signature + "&dytk=f16011579661e823235d034fdb1bd459", true);
            System.out.println(uid + "获取视频长度：" + videos.length());
//            System.out.println(videos);
            JSONArray aweme_list = JSONObject.parseObject(videos).getJSONArray("aweme_list");
            if (aweme_list.size() > 0) {
                return aweme_list;
            }
            if (times % 8 == 0) {
                signature = getByUrl(signatureHtmlpath+"?a=" + short_id.trim(), false);
                signature = signature.split("</script>")[1].split("</body>")[0].trim();
            }
        } while (times < 20);
        return null;
    }

    public String getTalent(String uid) {
        String url = "https://www.iesdouyin.com/share/user/" + uid;
        String cookie = "tt_webid=6815163373467043335; _ba=BA0.2-20200413-5199e-qhizb5NPm6hzOe7PqaCx; _ga=GA1.2.858585721.1586778881; _gid=GA1.2.1365561669.1589285856";
        Map<String, String> headers = new HashMap();
        headers.put("Host", "www.iesdouyin.com");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0");
        headers.put("pragma", "no-cache");
        headers.put(":authority", "www.iesdouyin.com");
        try {
            return HttpClientUtil.get(url, null, headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
