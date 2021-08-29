package com.lida.dy.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/5 0005 19:41
 * @Version: 1.0
 */
@Data
@ToString
@ApiModel(value = "BagVo", description = "背包计算数据bean")
public class BagVo {
    // [id,price,（value:播放量/粉丝数）,isSelect,realfans,播放量]
    @ApiModelProperty(hidden = true)
    public float[][] user;
    @ApiModelProperty(value = "用户计算的限制金额", example = "10000", required = true)
    public int limitMony;
    @ApiModelProperty(hidden = true)
    public int limitNum;
    @ApiModelProperty(value = "视频长度类型", required = true)
    public String videoLength;
    @ApiModelProperty(value = "候选达人的id列表", required = true)
    public String ids;
    @ApiModelProperty(value = "全局计算时需要，达人的类型", required = false)
    public String type;
    @ApiModelProperty(hidden = true)
    public float resultValue;    //最终价值
    @ApiModelProperty(hidden = true)
    public int realFans;
    @ApiModelProperty(hidden = true)
    public BagVo otherOptimization;
    @ApiModelProperty(hidden = true)
    public List<Integer> resultIds;
    @ApiModelProperty(hidden = true)
    public int talentNum;
    @ApiModelProperty(hidden = true)
    public int totalPrice;
    @ApiModelProperty(hidden = true)
    public int totalPlayNum;
    @ApiModelProperty(hidden = true)
    public float optimizationRate;  //更好的money 比例
}

