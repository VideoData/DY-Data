package cn.com.sun.ksv.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description : Runner
 * @Author : mockingbird
 * @Date : 2021/3/9 15:23
 */
public class CrawlerRunner {

    public static void main(String[] args) throws IOException {
        String path = CrawlerConfig.getProperties("rootDir") + "//input.txt";
        ShortVideoCrawler crawler = new ShortVideoCrawler(getUrlList(path));
        if (args.length > 0 && args[0].equalsIgnoreCase("processOnly")) {
            String outputPath = CrawlerConfig.getProperties("inputDir");
            crawler.processVideo(outputPath);
        } else {
            crawler.parseDownloadUrl().download().processVideo(null);
        }
    }

    private static List<String> getUrlList(String path) throws IOException {
        System.out.println(path);
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = reader.readLine()) != null) {
            stringBuilder.append(temp);
            temp = "";
        }
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
        Matcher matcher = pattern.matcher(stringBuilder.toString());
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}
