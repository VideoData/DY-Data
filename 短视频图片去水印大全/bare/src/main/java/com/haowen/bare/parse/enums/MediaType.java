package com.haowen.bare.parse.enums;

public enum MediaType {

    VIDEO("视频"),
    IMAGE("图片");

    public final String name;

    MediaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
