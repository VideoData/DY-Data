package com.haowen.bare.parse;

import com.haowen.bare.utils.ApplicationContextGetBeanHelper;
import org.springframework.stereotype.Component;


@Component
public class ParserFactory {

    /**
     * 获取解析器
     *
     * @param url 分享链接文字
     * @return 解析器
     */
    public BareParser getParser(String url) {
        for (Platform platform : ParsePlatformConfig.platforms) {
            if (isPlatform(url, platform)) {
                return (BareParser) ApplicationContextGetBeanHelper.getBean(platform.getParserClass().getSimpleName());
            }
        }
        return null;
    }

    /**
     * 平台归属
     *
     * @param url      复制的链接地址
     * @param platform 平台
     * @return 是否是 {@link Platform}
     */
    private boolean isPlatform(String url, Platform platform) {
        return url.contains(platform.getDomain());
    }

    /**
     * 是否是支持的平台
     *
     * @param url 分享链接文字
     * @return 是否支持
     */
    public boolean isSupportPlatform(String url) {
        for (Platform platform : ParsePlatformConfig.platforms) {
            if (isPlatform(url, platform)) {
                return true;
            }
        }
        return false;
    }
}
