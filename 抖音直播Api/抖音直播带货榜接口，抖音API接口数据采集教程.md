# 抖音直播带货榜接口，抖音API接口数据采集教程，抖音SDK

##  简要描述：

- 直播带货小时榜

##  请求API：

- `http://主机地址/douyin/webcast/rank_goods?token=xxx`

##  请求方式：

- GET

##  参数：

| 参数名 | 必选 | 类型 | 说明 |
| --- | --- | --- | --- |
| token | 是 | string | 接口授权码 |
| sec_anchor_id | 否 | string | 主播 sec_user_id |

 
##  返回示例
```json
{
    "data": {
        "ranks": [
            {
                "user": {
                    "id": 84990209480,
                    "short_id": 191433445,
                    "nickname": "陈赫",
                    "gender": 1,
                    "signature": "",
                    "level": 0,
                    "birthday": 0,
                    "telephone": "",
                    "avatar_thumb": {
                        "url_list": [
                            "https://p3.douyinpic.com/aweme/100x100/fa5a000368a5098c3d15.jpeg?from=4010531038",
                            "https://p9.douyinpic.com/aweme/100x100/fa5a000368a5098c3d15.jpeg?from=4010531038",
                            "https://p26.douyinpic.com/aweme/100x100/fa5a000368a5098c3d15.jpeg?from=4010531038"
                        ],
                        "uri": "100x100/fa5a000368a5098c3d15",
                        "height": 0,
                        "width": 0,
                        "avg_color": "",
                        "image_type": 0,
                        "open_web_url": "",
                        "is_animated": false
                    },
                    "verified": false,
                    "experience": 0,
                    "city": "",
                    "status": 0,
                    "create_time": 0,
                    "modify_time": 0,
                    "secret": 0,
                    "share_qrcode_uri": "",
                    "income_share_percent": 0,
                    "badge_image_list": [],
                    "follow_info": {
                        "following_count": 0,
                        "follower_count": 0,
                        "follow_status": 0,
                        "push_status": 0
                    },
                    "pay_grade": {
                        "total_diamond_count": 1363356,
                        "name": "",
                        "next_name": "",
                        "level": 41,
                        "next_diamond": 0,
                        "now_diamond": 0,
                        "this_grade_min_diamond": 1100000,
                        "this_grade_max_diamond": 1500000,
                        "pay_diamond_bak": 0,
                        "grade_describe": "距离42级还差13.7w抖币",
                        "grade_icon_list": [],
                        "screen_chat_type": 0,
                        "new_im_icon_with_level": {
                            "url_list": [
                                "http://p6-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_41.png~tplv-obj.image",
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_41.png~tplv-obj.image",
                                "http://p3-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_41.png~tplv-obj.image"
                            ],
                            "uri": "webcast/user_grade_level_v4_41.png",
                            "height": 16,
                            "width": 32,
                            "avg_color": "",
                            "image_type": 1,
                            "open_web_url": "",
                            "is_animated": false
                        },
                        "new_live_icon": {
                            "url_list": [
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_40_44.png~tplv-obj.image",
                                "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_40_44.png~tplv-obj.image",
                                "http://p3-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_40_44.png~tplv-obj.image"
                            ],
                            "uri": "webcast/aweme_pay_grade_2x_40_44.png",
                            "height": 12,
                            "width": 12,
                            "avg_color": "",
                            "image_type": 1,
                            "open_web_url": "",
                            "is_animated": false
                        },
                        "upgrade_need_consume": 0,
                        "next_privileges": "",
                        "score": 1363356,
                        "grade_banner": ""
                    },
                    "fans_club": {
                        "data": {
                            "club_name": "",
                            "level": 0,
                            "user_fans_club_status": 0,
                            "badge": {
                                "icons": {
                                    "0": {
                                        "url_list": [],
                                        "uri": "",
                                        "height": 0,
                                        "width": 0,
                                        "avg_color": "",
                                        "image_type": 0,
                                        "open_web_url": "",
                                        "is_animated": false
                                    }
                                },
                                "title": ""
                            },
                            "available_gift_ids": [],
                            "anchor_id": 0
                        },
                        "prefer_data": {}
                    },
                    "special_id": "",
                    "real_time_icons": [],
                    "new_real_time_icons": [],
                    "top_vip_no": 0,
                    "own_room": {
                        "room_ids": [
                            6919375969501465352
                        ],
                        "room_ids_str": [
                            "6919375969501465352"
                        ]
                    },
                    "pay_score": 0,
                    "ticket_count": 0,
                    "link_mic_stats": 0,
                    "display_id": "191433445",
                    "with_commerce_permission": false,
                    "with_fusion_shop_entry": false,
                    "total_recharge_diamond_count": 0,
                    "verified_content": "",
                    "top_fans": [],
                    "sec_uid": "MS4wLjABAAAAAEtO1dCIZvj4VWbLU4Xce7DgVgsKNMNu88eNR2c2LtY",
                    "user_role": 0,
                    "authorization_info": 3,
                    "adversary_authorization_info": 0,
                    "media_badge_image_list": [],
                    "adversary_user_status": 0,
                    "commerce_webcast_config_ids": [],
                    "badge_image_list_v2": [],
                    "allow_be_located": false,
                    "allow_find_by_contacts": false,
                    "allow_others_download_video": false,
                    "allow_others_download_when_sharing_video": false,
                    "allow_share_show_profile": false,
                    "allow_show_in_gossip": false,
                    "allow_show_my_action": false,
                    "allow_strange_comment": false,
                    "allow_unfollower_comment": false,
                    "allow_use_linkmic": false,
                    "bg_img_url": "",
                    "birthday_description": "",
                    "birthday_valid": false,
                    "block_status": 0,
                    "comment_restrict": 0,
                    "constellation": "",
                    "disable_ichat": 0,
                    "enable_ichat_img": 0,
                    "exp": 0,
                    "fan_ticket_count": 0,
                    "fold_stranger_chat": false,
                    "follow_status": 0,
                    "hotsoon_verified": false,
                    "hotsoon_verified_reason": "",
                    "ichat_restrict_type": 0,
                    "id_str": "84990209480",
                    "is_follower": false,
                    "is_following": false,
                    "need_profile_guide": false,
                    "pay_scores": 0,
                    "push_comment_status": false,
                    "push_digg": false,
                    "push_follow": false,
                    "push_friend_action": false,
                    "push_ichat": false,
                    "push_status": false,
                    "push_video_post": false,
                    "push_video_recommend": false,
                    "verified_mobile": false,
                    "verified_reason": "",
                    "with_car_management_permission": false
                },
                "score": 49232,
                "rank": 1,
                "gap_description": "4.9万",
                "delta": 0,
                "rich_description": "",
                "city_code": "",
                "gap_rich_description": "<html><body><b><font size=\"12\" color=\"#161823\">4.9万</font></b><span><font size=\"12\" color=\"#80161823\">热度</font></span></body></html>",
                "shop_tags": [
                    "综合"
                ],
                "fixed_footer_description": ""
            },
            {
                "user": {
                    "id": 64036627979,
                    "short_id": 46826908,
                    "nickname": "朱梓骁",
                    "gender": 1,
                    "signature": "",
                    "level": 0,
                    "birthday": 0,
                    "telephone": "",
                    "avatar_thumb": {
                        "url_list": [
                            "https://p9.douyinpic.com/img/tos-cn-avt-0015/c837d38ea8854c0f46e625666aba52e8~c5_100x100.jpeg?from=4010531038",
                            "https://p6.douyinpic.com/img/tos-cn-avt-0015/c837d38ea8854c0f46e625666aba52e8~c5_100x100.jpeg?from=4010531038",
                            "https://p3.douyinpic.com/img/tos-cn-avt-0015/c837d38ea8854c0f46e625666aba52e8~c5_100x100.jpeg?from=4010531038"
                        ],
                        "uri": "100x100/tos-cn-avt-0015/c837d38ea8854c0f46e625666aba52e8",
                        "height": 0,
                        "width": 0,
                        "avg_color": "",
                        "image_type": 0,
                        "open_web_url": "",
                        "is_animated": false
                    },
                    "verified": false,
                    "experience": 0,
                    "city": "",
                    "status": 0,
                    "create_time": 0,
                    "modify_time": 0,
                    "secret": 0,
                    "share_qrcode_uri": "",
                    "income_share_percent": 0,
                    "badge_image_list": [],
                    "follow_info": {
                        "following_count": 0,
                        "follower_count": 0,
                        "follow_status": 0,
                        "push_status": 0
                    },
                    "pay_grade": {
                        "total_diamond_count": 37266,
                        "name": "",
                        "next_name": "",
                        "level": 28,
                        "next_diamond": 0,
                        "now_diamond": 0,
                        "this_grade_min_diamond": 34000,
                        "this_grade_max_diamond": 44000,
                        "pay_diamond_bak": 0,
                        "grade_describe": "距离29级还差6734抖币",
                        "grade_icon_list": [],
                        "screen_chat_type": 0,
                        "new_im_icon_with_level": {
                            "url_list": [
                                "http://p3-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_28.png~tplv-obj.image",
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_28.png~tplv-obj.image",
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/user_grade_level_v4_28.png~tplv-obj.image"
                            ],
                            "uri": "webcast/user_grade_level_v4_28.png",
                            "height": 16,
                            "width": 32,
                            "avg_color": "",
                            "image_type": 1,
                            "open_web_url": "",
                            "is_animated": false
                        },
                        "new_live_icon": {
                            "url_list": [
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_25_29.png~tplv-obj.image",
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_25_29.png~tplv-obj.image",
                                "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_25_29.png~tplv-obj.image"
                            ],
                            "uri": "webcast/aweme_pay_grade_2x_25_29.png",
                            "height": 12,
                            "width": 12,
                            "avg_color": "",
                            "image_type": 1,
                            "open_web_url": "",
                            "is_animated": false
                        },
                        "upgrade_need_consume": 0,
                        "next_privileges": "",
                        "score": 37266,
                        "grade_banner": ""
                    },
                    "fans_club": {
                        "data": {
                            "club_name": "",
                            "level": 0,
                            "user_fans_club_status": 0,
                            "badge": {
                                "icons": {
                                    "0": {
                                        "url_list": [],
                                        "uri": "",
                                        "height": 0,
                                        "width": 0,
                                        "avg_color": "",
                                        "image_type": 0,
                                        "open_web_url": "",
                                        "is_animated": false
                                    }
                                },
                                "title": ""
                            },
                            "available_gift_ids": [],
                            "anchor_id": 0
                        },
                        "prefer_data": {}
                    },
                    "special_id": "",
                    "real_time_icons": [],
                    "new_real_time_icons": [],
                    "top_vip_no": 0,
                    "own_room": {
                        "room_ids": [
                            6919392908231691011
                        ],
                        "room_ids_str": [
                            "6919392908231691011"
                        ]
                    },
                    "pay_score": 0,
                    "ticket_count": 0,
                    "link_mic_stats": 0,
                    "display_id": "Zhu.Zi.Xiao_813",
                    "with_commerce_permission": false,
                    "with_fusion_shop_entry": false,
                    "total_recharge_diamond_count": 0,
                    "verified_content": "",
                    "top_fans": [],
                    "sec_uid": "MS4wLjABAAAAap4V4ShgmTBxsTl5JgKYnkywnroBJKyLRxAFAUHsD_0",
                    "user_role": 0,
                    "authorization_info": 3,
                    "adversary_authorization_info": 0,
                    "media_badge_image_list": [],
                    "adversary_user_status": 0,
                    "commerce_webcast_config_ids": [],
                    "badge_image_list_v2": [],
                    "allow_be_located": false,
                    "allow_find_by_contacts": false,
                    "allow_others_download_video": false,
                    "allow_others_download_when_sharing_video": false,
                    "allow_share_show_profile": false,
                    "allow_show_in_gossip": false,
                    "allow_show_my_action": false,
                    "allow_strange_comment": false,
                    "allow_unfollower_comment": false,
                    "allow_use_linkmic": false,
                    "bg_img_url": "",
                    "birthday_description": "",
                    "birthday_valid": false,
                    "block_status": 0,
                    "comment_restrict": 0,
                    "constellation": "",
                    "disable_ichat": 0,
                    "enable_ichat_img": 0,
                    "exp": 0,
                    "fan_ticket_count": 0,
                    "fold_stranger_chat": false,
                    "follow_status": 0,
                    "hotsoon_verified": false,
                    "hotsoon_verified_reason": "",
                    "ichat_restrict_type": 0,
                    "id_str": "64036627979",
                    "is_follower": false,
                    "is_following": false,
                    "need_profile_guide": false,
                    "pay_scores": 0,
                    "push_comment_status": false,
                    "push_digg": false,
                    "push_follow": false,
                    "push_friend_action": false,
                    "push_ichat": false,
                    "push_status": false,
                    "push_video_post": false,
                    "push_video_recommend": false,
                    "verified_mobile": false,
                    "verified_reason": "",
                    "with_car_management_permission": false
                },
                "score": 29085,
                "rank": 2,
                "gap_description": "2.9万",
                "delta": 20147,
                "rich_description": "",
                "city_code": "",
                "gap_rich_description": "<html><body><b><font size=\"12\" color=\"#161823\">2.9万</font></b><span><font size=\"12\" color=\"#80161823\">热度</font></span></body></html>",
                "shop_tags": [
                    "综合"
                ],
                "fixed_footer_description": ""
            }
        ],
        "anchor_info": {
            "user": {
                "id": 104255897823,
                "short_id": 1449765156,
                "nickname": "人民日报",
                "gender": 0,
                "signature": "",
                "level": 0,
                "birthday": 0,
                "telephone": "",
                "avatar_thumb": {
                    "url_list": [
                        "https://p6.douyinpic.com/aweme/100x100/30ed2000aad26be101cad.jpeg?from=4010531038",
                        "https://p29.douyinpic.com/aweme/100x100/30ed2000aad26be101cad.jpeg?from=4010531038",
                        "https://p3.douyinpic.com/aweme/100x100/30ed2000aad26be101cad.jpeg?from=4010531038"
                    ],
                    "uri": "100x100/30ed2000aad26be101cad",
                    "height": 0,
                    "width": 0,
                    "avg_color": "",
                    "image_type": 0,
                    "open_web_url": "",
                    "is_animated": false
                },
                "verified": false,
                "experience": 0,
                "city": "",
                "status": 0,
                "create_time": 0,
                "modify_time": 0,
                "secret": 0,
                "share_qrcode_uri": "",
                "income_share_percent": 0,
                "badge_image_list": [],
                "follow_info": {
                    "following_count": 0,
                    "follower_count": 0,
                    "follow_status": 0,
                    "push_status": 0
                },
                "pay_grade": {
                    "total_diamond_count": 0,
                    "name": "",
                    "next_name": "",
                    "level": 0,
                    "next_diamond": 0,
                    "now_diamond": 0,
                    "this_grade_min_diamond": 0,
                    "this_grade_max_diamond": 1,
                    "pay_diamond_bak": 0,
                    "grade_describe": "距离1级还差1抖币",
                    "grade_icon_list": [],
                    "screen_chat_type": 0,
                    "new_im_icon_with_level": {
                        "url_list": [],
                        "uri": "",
                        "height": 0,
                        "width": 0,
                        "avg_color": "",
                        "image_type": 0,
                        "open_web_url": "",
                        "is_animated": false
                    },
                    "new_live_icon": {
                        "url_list": [],
                        "uri": "",
                        "height": 0,
                        "width": 0,
                        "avg_color": "",
                        "image_type": 0,
                        "open_web_url": "",
                        "is_animated": false
                    },
                    "upgrade_need_consume": 0,
                    "next_privileges": "",
                    "score": 0,
                    "grade_banner": ""
                },
                "fans_club": {
                    "data": {
                        "club_name": "",
                        "level": 0,
                        "user_fans_club_status": 0,
                        "badge": {
                            "icons": {
                                "0": {
                                    "url_list": [],
                                    "uri": "",
                                    "height": 0,
                                    "width": 0,
                                    "avg_color": "",
                                    "image_type": 0,
                                    "open_web_url": "",
                                    "is_animated": false
                                }
                            },
                            "title": ""
                        },
                        "available_gift_ids": [],
                        "anchor_id": 0
                    },
                    "prefer_data": {}
                },
                "special_id": "",
                "real_time_icons": [],
                "new_real_time_icons": [],
                "top_vip_no": 0,
                "pay_score": 0,
                "ticket_count": 0,
                "link_mic_stats": 0,
                "display_id": "rmrbxmt",
                "with_commerce_permission": false,
                "with_fusion_shop_entry": false,
                "total_recharge_diamond_count": 0,
                "verified_content": "",
                "top_fans": [],
                "sec_uid": "MS4wLjABAAAA8U_l6rBzmy7bcy6xOJel4v0RzoR_wfAubGPeJimN__4",
                "user_role": 0,
                "authorization_info": 3,
                "adversary_authorization_info": 0,
                "media_badge_image_list": [],
                "adversary_user_status": 0,
                "commerce_webcast_config_ids": [],
                "badge_image_list_v2": [],
                "allow_be_located": false,
                "allow_find_by_contacts": false,
                "allow_others_download_video": false,
                "allow_others_download_when_sharing_video": false,
                "allow_share_show_profile": false,
                "allow_show_in_gossip": false,
                "allow_show_my_action": false,
                "allow_strange_comment": false,
                "allow_unfollower_comment": false,
                "allow_use_linkmic": false,
                "bg_img_url": "",
                "birthday_description": "",
                "birthday_valid": false,
                "block_status": 0,
                "comment_restrict": 0,
                "constellation": "",
                "disable_ichat": 0,
                "enable_ichat_img": 0,
                "exp": 0,
                "fan_ticket_count": 0,
                "fold_stranger_chat": false,
                "follow_status": 0,
                "hotsoon_verified": false,
                "hotsoon_verified_reason": "",
                "ichat_restrict_type": 0,
                "id_str": "104255897823",
                "is_follower": false,
                "is_following": false,
                "need_profile_guide": false,
                "pay_scores": 0,
                "push_comment_status": false,
                "push_digg": false,
                "push_follow": false,
                "push_friend_action": false,
                "push_ichat": false,
                "push_status": false,
                "push_video_post": false,
                "push_video_recommend": false,
                "verified_mobile": false,
                "verified_reason": "",
                "with_car_management_permission": false
            },
            "score": 0,
            "rank": 0,
            "gap_description": "距上榜还差50热度",
            "delta": 1502,
            "rich_description": "",
            "city_code": "",
            "gap_rich_description": "",
            "shop_tags": [],
            "fixed_footer_description": "0热度"
        },
        "seats": [],
        "charts_description": "",
        "subtitle": "小时榜",
        "title": "全站",
        "begin_time": 1611054000,
        "direction": "给实时小时榜第一主播送礼最多的用户,会展示在此位置",
        "region_name": "",
        "is_hide_entrance": false,
        "top_img_url": "",
        "delta_time": 2551,
        "last_hour_description": "",
        "rules_url": "https://webcast.amemv.com/falcon/webcast_douyin/page/regional_list_rules/index.html?list_label=revenue&type=fullscreen&hide_nav_bar=1&hide_status_bar=0",
        "highlight_content": "",
        "city_code": "",
        "currency": "热度",
        "rules_url_v2": "https://webcast.amemv.com/falcon/webcast_douyin/page/ecom_list_rule/index.html"
    },
    "extra": {
        "now": 1611055049817
    },
    "status_code": 0
}
```
