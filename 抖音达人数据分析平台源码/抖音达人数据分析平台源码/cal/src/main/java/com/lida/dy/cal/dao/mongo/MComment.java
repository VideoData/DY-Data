package com.lida.dy.cal.dao.mongo;

import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/29 0029 14:50
 * @Version: 1.0
 */
//@Document("comment")
@Data
public class MComment {
    private String id;
    private int stick_position;
    private String reply_to_reply_id;
    private long create_time;
    private int reply_comment_total;
    private boolean user_buried;
    private int user_digged;
    private List<Reply_comment> reply_comment;
    private String aweme_id;
    private String reply_id;
    private List<String> text_extra;
    private int digg_count;
    private String text;
    private User user;
    private boolean is_author_digged;
    private String cid;
    private int status;


    private String my_reply_id;
    private int my_author_id;
    private int my_video_id;
    private int my_user_id;
    @Transient
    private List<MComment> replys;
}
