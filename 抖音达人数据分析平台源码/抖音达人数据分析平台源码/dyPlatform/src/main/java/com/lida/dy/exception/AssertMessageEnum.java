package com.lida.dy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/10 0010 11:10
 * @Version: 1.0
 */
@AllArgsConstructor
public enum AssertMessageEnum {
    NotBlank("不能为空"), LargerZero("大于0");
    @Getter
    @Setter
    private String message;
}
