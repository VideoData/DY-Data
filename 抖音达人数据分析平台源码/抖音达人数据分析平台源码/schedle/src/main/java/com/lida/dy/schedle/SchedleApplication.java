package com.lida.dy.schedle;

import com.lida.dy.schedle.any2.ExportComment;
import com.lida.dy.schedle.linuxSpider.FixFansCount;
import com.lida.dy.schedle.linuxSpider.Spider;
import com.lida.dy.schedle.linuxSpider.SpiderMgmt;
import com.lida.dy.schedle.liudataset.DataSetSpFromXingtu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class SchedleApplication implements CommandLineRunner {
    @Autowired
    Spider spider;
    @Autowired
    SpiderMgmt spiderMgmt;
    @Value("${my.linux.chrome}")
    private String chrome;
    @Value("${my.linux.hasChrome}")
    private boolean hasChrome;
    @Value("${my.linux.isTask}")
    private boolean isTask;
    @Autowired
    ExportComment exportComment;
    @Autowired
    FixFansCount fixFansCount;
    @Autowired
    DataSetSpFromXingtu dataSetSp;
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SchedleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (hasChrome) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }
        if (isTask) {
            spiderMgmt.startSpiderThread();
        } else {
            spider.main(true);
        }
    }

}
