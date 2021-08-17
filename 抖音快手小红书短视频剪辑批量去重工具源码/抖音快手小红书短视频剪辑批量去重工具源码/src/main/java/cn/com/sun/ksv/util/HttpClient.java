package cn.com.sun.ksv.util;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description : HTTP客户端工具
 * @Author : Mockingbird
 * @Date: 2020-07-18 00:34
 */
public class HttpClient {

    public static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    private static CloseableHttpClient httpClient;

    private static RequestConfig requestConfig;

    static {
        PoolingHttpClientConnectionManager conManager = new PoolingHttpClientConnectionManager();
        // 设置整个池子的最大连接数
        conManager.setMaxTotal(50);
        // 设置连接到单个路由地址的最大连接数
        conManager.setDefaultMaxPerRoute(8);
        //conManager.
        httpClient = HttpClients.custom().setConnectionManager(conManager).build();
        requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setSocketTimeout(20000).setCookieSpec(CookieSpecs.STANDARD).build();
    }

    /**
     * 通过http方式将远程资源下载到本地文件
     *
     * @return
     */
    public static boolean downloadVideoToFs(String videoUrl, String filePath) {
        // 请求
        HttpGet request = createHttpGetRequest(videoUrl);
        request.setConfig(RequestConfig.copy(requestConfig).setSocketTimeout(30000).build());
        // 下载
        File file = new File(filePath);
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            try (FileOutputStream out = new FileOutputStream(file);
                 InputStream in = response.getEntity().getContent()) {
                if (response.getStatusLine().getStatusCode() == 200) {
                    IOUtil.copy(in, out);
                } else {
                    logger.warn("get请求失败,地址:{}, response status:{}", videoUrl, response.getStatusLine().getStatusCode());
                    return false;
                }
            } catch (IOException e) {
                //下载失败之后忽略异常继续执行
                //logger.error("下载视频失败,地址:{}, cause:{}", videoUrl, e.getMessage());
                return false;
            } finally {
                response.close();
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    private static HttpGet createHttpGetRequest(String url) {
        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        //request.setHeader("Host", request.getURI().getHost());
        request.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7");
        request.setHeader("Accept-Encoding", "gzip");
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/84.0.4147.89 Safari/537.36");
        return request;
    }
}
