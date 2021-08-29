package com.lida.dy.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/14 0014 21:47
 * @Version: 1.0
 */
@Data
@ToString
public class MutilSearchVo {
    String keyWord;
    String sortWord;
    boolean isDESC;    //排序，默认降序
    int page;
    int size;
    List<String> type;
    List<String> value;
    List<String> fans;
    int platform;
}
