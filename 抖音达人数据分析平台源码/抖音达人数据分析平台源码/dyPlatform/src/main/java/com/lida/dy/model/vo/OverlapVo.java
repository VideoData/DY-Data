package com.lida.dy.model.vo;

import com.lida.dy.model.entity.TalentUserInfoEntity;
import lombok.Data;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/4 0004 22:13
 * @Version: 1.0
 */
@Data
public class OverlapVo {
    private TalentUserInfoEntity userInfoEntitya;
    private TalentUserInfoEntity userInfoEntityb;
    private Integer overlapValue;
    private Integer talendaFanNum;
    private Integer talendbFanNum;
}
