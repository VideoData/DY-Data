package com.lida.dy.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 11:22
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return new Result(HttpStatus.OK.value(), null, data);
    }

    public static Result success() {
        return new Result(HttpStatus.OK.value(), null, null);
    }

    public static Result fail(String msg) {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

    public static Result fail() {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", null);
    }

}
