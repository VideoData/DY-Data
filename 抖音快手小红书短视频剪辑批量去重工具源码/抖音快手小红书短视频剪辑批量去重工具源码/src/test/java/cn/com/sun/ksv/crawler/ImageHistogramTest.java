package cn.com.sun.ksv.crawler;

import cn.com.sun.ksv.util.ImageHistogram;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageHistogramTest {

    @Test
    public void testMatch() throws IOException {
        double score = ImageHistogram.getInstance().match(new File("E:\\dev\\ksv-crawler\\output\\1.jpg"), new File("E:\\dev\\ksv-crawler\\output\\1.jpg"));
        System.out.println("img1-->img1::::score : " + score);
    }

    @Test
    public void read() {
        try {
            ImageIO.read(new File("E:\\dev\\ksv-crawler\\output\\2021-06-06\\sampleImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




