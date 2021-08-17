package cn.com.sun.ksv.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Description : IO 工具类
 * @Author : Mockingbird
 * @Date : 2020-08-16 17:19
 */
public class IOUtil {

    public static final Logger logger = LoggerFactory.getLogger(IOUtil.class);

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[4096];
        int count = 0;
        while ((count = in.read(bytes)) != -1) {
            out.write(bytes, 0, count);
        }
        out.flush();
    }

    public static void move(File src, File dest) {
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            if (src.renameTo(dest)) {
                logger.info("file move success dest:{}", dest.getAbsolutePath());
            } else {
                logger.error("file move failed src:{}", src.getAbsolutePath());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
