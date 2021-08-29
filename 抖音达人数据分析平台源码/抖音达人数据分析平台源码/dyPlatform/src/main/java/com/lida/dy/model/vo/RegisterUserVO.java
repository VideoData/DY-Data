package com.lida.dy.model.vo;

import lombok.Data;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/3 0003 15:52
 * @Version: 1.0
 */
@Data
public class RegisterUserVO {
    private String username;
    private String passwd;
    private String email;
    private String code;
}
