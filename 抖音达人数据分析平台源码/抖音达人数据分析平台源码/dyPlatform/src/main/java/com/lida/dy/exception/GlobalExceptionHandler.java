package com.lida.dy.exception;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @Auther: lida
 * @Description:
 * @Date 2020/1/10 0010 11:07
 * @Version: 1.0
 */
@ControllerAdvice
@Log
public class GlobalExceptionHandler {
    /*业务断言异常处理*/
    @ResponseBody
    @ExceptionHandler(AssertException.class)
    public Map<String, Object> handleCustomException(AssertException assertException) {
        log.warning(assertException.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("message", assertException.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(AssertionError.class)
    public Map<String, Object> handleCustomException(AssertionError assertionError) {
        log.warning(assertionError.getMessage());
        log.warning(assertionError.getLocalizedMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("message", assertionError.getMessage());
        map.put("localizedMessage", assertionError.getLocalizedMessage());
        return map;
    }
}
