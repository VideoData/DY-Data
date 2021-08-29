package com.lida.dy.model.vo;

import com.lida.dy.model.entity.TalentUserInfoEntity;
import lombok.Data;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 19:49
 * @Version: 1.0
 */
@Data
public class TalentUserInfoVo extends TalentUserInfoEntity {
    private boolean isCandidata;
}
