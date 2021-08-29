package com.lida.dy.schedle.liudataset;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component
public class DriverUtil {
    public WebDriver driver;

    public WebDriver createDriver(boolean hasUi) {
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
        return driver;
    }

    public void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public boolean mockLogin(WebDriver driver) throws Exception {
        driver.get("https://star.toutiao.com/");
//        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div[4]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("information")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("user-name")).sendKeys("wangzichao@YIXIforce.com");
        Thread.sleep(300);
        driver.findElement(By.id("password")).sendKeys("13910073557");
        Thread.sleep(300);
//        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.findElement(By.id("bytedance-SubmitStatic")).click();
        Thread.sleep(2000);
        dealCheckCode();
        Thread.sleep(1000);
        return true;
    }

    /*处理滑动验证码*/
    private void dealCheckCode() throws IOException, InterruptedException {
        WebElement dragBtn = driver.findElement(By.xpath("//*[@id=\"validate-drag-wrapper\"]/div[2]/img"));
        while (dragBtn != null) {
            Thread.sleep(1000);
            BufferedImage bgImage = getImage("//*[@id=\"validate-big\"]");
            int left = getLeft(bgImage);
            System.out.println("left:" + left);
            move(driver, dragBtn, left);
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/index")) {
                return;
            }
            dragBtn = driver.findElement(By.xpath("//*[@id=\"validate-drag-wrapper\"]/div[2]/img"));
//            System.out.println(dragBtn == null);
        }
    }

    private BufferedImage getImage(String xPath) throws IOException {
        WebElement ele = driver.findElement(By.xpath(xPath));
        String url = ele.getAttribute("src");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        BufferedImage fullImg = null;
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            fullImg = ImageIO.read(inputStream);
        }
        return fullImg;
    }

    private static int getLeft(BufferedImage bgimage) {
        int width = bgimage.getWidth();
        int height = bgimage.getHeight();
        for (int i = width / 5; i < width - 2; i++) {
            for (int j = 0; j < height - 8; j++) {
                int rgb = bgimage.getRGB(i, j);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                int sum = red + green + blue;
//                System.out.println(rgb +" "+red+" "+green+" "+blue+"  "+sum);
                boolean b = checkPoint(bgimage, i, j);
                if (b) {
                    System.out.println(i + " " + j);
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean checkPoint(BufferedImage bgimage, int i, int j) {
        int rgb = bgimage.getRGB(i, j);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        int temp = 28;
        if (Math.abs(red - green) > temp || Math.abs(red - blue) > temp || Math.abs(blue - green) > temp) {
            return false;
        }
        if (red + green + blue < 50 * 3 || red + green + blue > 210 * 3) {
            return false;
        }

        int mix = 25;
        int all = 0;
        for (int k = 0; k < 7; k++) {
            for (int l = 0; l < 2; l++) {
                int testrgb = bgimage.getRGB(i + l, j + k);
                int testred = (testrgb >> 16) & 0xFF;
                int testgreen = (testrgb >> 8) & 0xFF;
                int testblue = testrgb & 0xFF;
                int flag = 0;
                if (red - mix < testred && testred < red + mix) {
                    flag++;
                }
                if (blue - mix < testblue && testblue < blue + mix) {
                    flag++;
                }
                if (green - mix < testgreen && testgreen < green + mix) {
                    flag++;
                }
                if (flag == 3) {
                    all++;
                }
            }
        }
        if (all >= 11) {
            mix = 60;
            all = 0;
            for (int k = 0; k < 7; k++) {
                int testrgb = bgimage.getRGB(i + 2, j + k);
                int testred = (testrgb >> 16) & 0xFF;
                int testgreen = (testrgb >> 8) & 0xFF;
                int testblue = testrgb & 0xFF;
                int flag = 0;
                if (red - mix > testred || testred > red + mix) {
                    flag++;
                }
                if (blue - mix > testblue || testblue > blue + mix) {
                    flag++;
                }
                if (green - mix > testgreen || testgreen > green + mix) {
                    flag++;
                }
                if (flag > 0) {
                    all++;
                }
            }
            if (all >= 6) {
                return true;
            }
        }
        return false;
    }

    public static void move(WebDriver driver, WebElement element, int distance) throws InterruptedException {
        int xDis = distance;
        System.out.println("应平移距离：" + xDis);
        Actions actions = new Actions(driver);
        new Actions(driver).clickAndHold(element).perform();
        Thread.sleep(200);
        printLocation(element);
        for (int i = 0; i < 5; i++) {
            int temp = (xDis / 5);
            actions.moveByOffset(temp, 1).perform();
            Thread.sleep(200);
            printLocation(element);
        }
//        actions.moveByOffset(xDis, 1).perform();
        printLocation(element);
        Thread.sleep(4000);
        actions.release(element).perform();
    }

    private static void printLocation(WebElement element) {
        Point location = element.getLocation();
        System.out.println(location.getX() + "____" + location.getY());
    }
}
