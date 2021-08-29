package com.lida.dy.model.vo;

import com.lida.dy.model.entity.VideoEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/6 0006 21:55
 * @Version: 1.0
 */
@Data
public class VideoVo {
    private String description;
    private int mid;
    private List<VideoEntity> videoEntities;
    private double standardDeviation;   //标准差
}
