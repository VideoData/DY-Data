package com.lida.dy.schedle.entity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/2 0002 11:59
 * @Version: 1.0
 */
@Data
public class Tag {
    private String tag;
    private List<String> subTag;
}
