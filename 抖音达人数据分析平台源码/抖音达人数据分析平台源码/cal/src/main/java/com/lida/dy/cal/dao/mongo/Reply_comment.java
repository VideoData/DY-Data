package com.lida.dy.cal.dao.mongo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/29 0029 16:11
 * @Version: 1.0
 */
@Data
public class Reply_comment {

    private String reply_to_reply_id;
    private long create_time;
    private boolean user_buried;
    private int user_digged;
    private String reply_comment;
    private String aweme_id;
    private String reply_id;
    private List<String> text_extra;
    private int digg_count;
    private String text;
    private User user;
    private boolean is_author_digged;
    private String cid;
    private int status;
    private int My_user_id;
}
