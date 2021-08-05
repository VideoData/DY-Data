package com.haowen.bare.utils;

import java.util.Arrays;
import java.util.Optional;

/**
 * 统一错误代码
 */
public enum ErrorCode {
    /**
     *
     */
    OK(200, "OK"),

    /**
     * 系统错误
     */
    NETWORK_ERROR(1000000, "网络错误"),
    MYSQL_ERROR(1010000, "MYSQL错误"),
    REDIS_ERROR(1020000, "REDIS错误"),
    MONGO_ERROR(1030000, "MONGO错误"),
    RABBITMQ_ERROR(1040000, "RABBITMQ错误"),
    KAFKA_ERROR(1050000, "KAFKA错误"),
    ES_ERROR(1060000, "ES错误"),
    QUARTZ_ERROR(1070000, "QUARTZ错误"),
    FEIGN_ERROR(1090000, "FEIGN请求异常"),

    /**
     * 业务错误
     */
    BIZ_ERROR(2000000, "业务错误"),
    PARAM_ERROR(BIZ_ERROR.value + 1, "参数错误"),
    AUTH_ERROR(BIZ_ERROR.value + 2, "认证错误"),
    PRIORITY_ERROR(BIZ_ERROR.value + 3, "权限错误"),
    VERSION_ERROR(BIZ_ERROR.value + 4, "版本错误"),
    SCHEDULE_ERROR(BIZ_ERROR.value + 5, "调度器使用错误"),
    SIGNATURE_ERROR(BIZ_ERROR.value + 6, "签名错误"),
    NOT_SUPPORTED_PLATFORM_ERROR(BIZ_ERROR.value + 7, "不支持的平台"),

    /**
     * 数据库错误
     */
    DUPLICATE_KEY_ERROR(2070000, "唯一性约束错误"),

    /**
     * 未知错误
     */
    UNKNOW_ERROR(9990000, "未知错误");

    private final int value;
    private final String msg;

    ErrorCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public int value() {
        return this.value;
    }

    public String msg() {
        return this.msg;
    }

    public static ErrorCode valueOf(int code) {
        Optional<ErrorCode> optional = Arrays.stream(values()).filter(instance -> instance.value == code).limit(1)
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
