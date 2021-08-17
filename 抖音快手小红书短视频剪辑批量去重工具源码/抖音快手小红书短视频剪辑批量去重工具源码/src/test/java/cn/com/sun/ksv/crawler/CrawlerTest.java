package cn.com.sun.ksv.crawler;

import cn.com.sun.ksv.util.HttpClient;
import org.junit.Test;

/**
 * @Description :
 * @Author : mockingbird
 * @Date : 2021/3/11 13:47
 */
public class CrawlerTest {

    @Test
    public void download() {
        HttpClient.downloadVideoToFs("https://video.kuaishou.com/short-video/3xuyc7r5khpvnz9?fid=25949119&cc=share_copylink&followRefer=151&shareMethod=TOKEN&docId=9&kpn=KUAISHOU&subBiz=PHOTO&photoId=3xuyc7r5khpvnz9&shareId=5809105166737&shareToken=X-2ILUzxhTtoU2a5_A&shareResourceType=PHOTO_OTHER&userId=3xxcvi49q2r52gu&shareType=1&et=1_i%2F2000258907078474817_p0&shareMode=APP&originShareId=5809105166737&appType=1&shareObjectId=5234308711257685168&shareUrlOpened=0&timestamp=1615441963485&utm_source=app_share&utm_medium=app_share&utm_campaign=app_share&location=app_share", "D:\\output\\2021-03-11\\111.mp4");
    }

    @Test
    public void process() {
        //String path = CrawlerConfig.getProperties("inputText");
        new ShortVideoCrawler(null).processVideo(null);
    }
}
