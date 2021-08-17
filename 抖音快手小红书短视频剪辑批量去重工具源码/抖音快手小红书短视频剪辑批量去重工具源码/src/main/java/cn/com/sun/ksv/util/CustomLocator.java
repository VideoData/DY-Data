package cn.com.sun.ksv.util;

import cn.com.sun.ksv.crawler.CrawlerConfig;
import ws.schild.jave.process.ProcessLocator;

/**
 * @Description :
 * @Author : mockingbird
 * @Date : 2021/3/11 22:26
 */
public class CustomLocator implements ProcessLocator {
    @Override
    public String getExecutablePath() {
        return CrawlerConfig.getProperties("rootDir") + "\\ffmpeg\\ffmpeg.exe";
    }
}
