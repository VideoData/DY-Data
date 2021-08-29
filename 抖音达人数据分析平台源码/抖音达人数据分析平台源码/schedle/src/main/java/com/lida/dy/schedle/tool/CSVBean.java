package com.lida.dy.schedle.tool;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/18 0018 22:35
 * @Version: 1.0
 */
@Data
public class CSVBean {
    @CsvBindByName(column = "总粉丝数")
    private String allfans;
    @CsvBindByName(column = "有效粉丝数")
    private String realfans;
    @CsvBindByName(column = "预期播放量")
    private String prePlayNum;
    @CsvBindByName(column = "预期cpm")
    private String preCPM;
    @CsvBindByName(column = "价格")
    private String price;
    @CsvBindByName(column = "平均播放量")
    private String avgPlaynmu;
}
