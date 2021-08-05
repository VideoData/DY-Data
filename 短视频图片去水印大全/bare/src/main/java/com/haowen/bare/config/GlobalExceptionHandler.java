package com.haowen.bare.config;

import com.haowen.bare.utils.BizException;
import com.haowen.bare.utils.ErrorCode;
import com.haowen.bare.utils.ResponseUtil;
import com.haowen.bare.utils.ReturnObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ReturnObject<Void> handleException(Exception ex) {
        String errorMessage = ex.getMessage();
        log.error(errorMessage, ex);
        return ResponseUtil.error(ErrorCode.UNKNOW_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ReturnObject<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorMessage = ex.getMessage();
        log.error(errorMessage, ex);
        return ResponseUtil.error(ErrorCode.PARAM_ERROR);
    }

    @ExceptionHandler(value = BizException.class)
    public ReturnObject<Void> bizExceptionHandler(BizException ex) {
        return new ReturnObject<>(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ReturnObject<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();

        StringBuilder builder = new StringBuilder();
        int index = 1;
        String message = "参数校验不通过";
        for (ObjectError error : allErrors) {
            message = ((FieldError) error).getField() + error.getDefaultMessage();
            builder.append(index).append("：").append(message).append("  ");
            index++;
        }
        return new ReturnObject<>(ErrorCode.PARAM_ERROR.value(), null, "参数校验不通过：" + builder.toString().trim());
    }
}
