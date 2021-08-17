package cn.com.sun.ksv.crawler;

/**
 * @Description :
 * @Author : mockingbird
 * @Date : 2021/3/9 14:10
 */
public interface VideoCrawler {
    /**
     * 基础信息
     *
     * @return
     */
    VideoCrawler parseVideoBaseInfo();

    /**
     * 扩展信息
     *
     * @return
     */
    VideoCrawler parseVideoExtInfo();

    /**
     * 下载链接
     *
     * @return
     */
    VideoCrawler parseDownloadUrl();

    VideoCrawler download();

    void processVideo(String path);
}

