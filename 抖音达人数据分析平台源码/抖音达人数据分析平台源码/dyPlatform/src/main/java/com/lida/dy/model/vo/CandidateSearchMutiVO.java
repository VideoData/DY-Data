package com.lida.dy.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/7 0007 9:32
 * @Version: 1.0
 */
@Data
public class CandidateSearchMutiVO {
    private String key; //删选类型名字
    private List<String> val;   //类型的值
}
