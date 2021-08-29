package com.lida.dy.cal.spiderDy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

//达人分页page缓存
//@Component
public class PageDao {
    @Value("${my.pagepath}")
    private String pagepath;
    private int page = -1;

    public int getPage() {
        if (page == -1) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pagepath))));
                page = Integer.parseInt(reader.readLine());
                page--;
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        page++;
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(pagepath))));
            writer.write(String.valueOf(page));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}
