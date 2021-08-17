package cn.com.sun.ksv.util;

import cn.com.sun.ksv.crawler.CrawlerConfig;
import cn.com.sun.ksv.model.Video;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description : 文件读写管理器
 * @Author : Mockingbird
 * @Date : 2020-08-16 10:48
 */
public class FileAccessManager {

    private static final Logger logger = LoggerFactory.getLogger(FileAccessManager.class);

    /**
     * 文件访问读写锁
     */
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();
    private static final Lock READ_LOCK = READ_WRITE_LOCK.readLock();
    private static final Lock WRITE_LOCK = READ_WRITE_LOCK.writeLock();
    private static FileAccessManager instance;
    private File jsonFile;
    private ObjectMapper mapper;

    private FileAccessManager(File file) {
        this.jsonFile = file;
        if (!jsonFile.exists()) {
            try {
                jsonFile.createNewFile();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        this.mapper = new ObjectMapper();
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略值为默认值的属性
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static FileAccessManager getInstance() {
        if (instance == null) {
            instance = new FileAccessManager(new File(CrawlerConfig.getProperties("rootDir")+"//log//crawler.json"));
        }
        return instance;
    }

    /**
     * 读取已下载的文件
     *
     * @return
     */
    public Map<String, Video> read() {
        Map<String, Video> map = new HashMap<>();
        READ_LOCK.lock();
        try {
            //logger.info("{} get readLock", Thread.currentThread().getName());
            try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
                br.lines().forEach(info -> {
                    try {
                        Video video = mapper.readValue(info, Video.class);
                        map.put(video.getId(), video);
                    } catch (JsonProcessingException e) {
                        logger.error(e.getMessage(), e);
                    }
                });
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        } finally {
            READ_LOCK.unlock();
            //logger.info("{} release readLock", Thread.currentThread().getName());
        }
        return map;
    }

    /**
     * 记录下载成功的文件
     *
     * @param video
     */
    public void write(Video video) {
        WRITE_LOCK.lock();
        try {
            //logger.info("{} get writeLock", Thread.currentThread().getName());
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile, true))) {
                String json = mapper.writeValueAsString(video);
                bw.write(json + "\n");
                bw.flush();
                logger.info("write json file:{}", json);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        } finally {
            WRITE_LOCK.unlock();
            //logger.info("{} release writeLock", Thread.currentThread().getName());
        }
    }
}
