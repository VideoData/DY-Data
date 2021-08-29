package com.lida.dy.schedle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchedleApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        System.setProperty("phantomjs.binary.path", "C:/Users/Administrator/Downloads/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        //    WebDriver driver = new FirefoxDriver();
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
    }
}
