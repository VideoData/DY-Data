# 抖音直播小时榜接口，抖音API接口数据采集教程，抖音SDK

##  简要描述：

- 直播带货小时榜

##  请求API：

- `http://主机地址/douyin/webcast/rank_all?token=xxx`

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
    "code": 200,
    "msg": "成功",
    "data": {
        "data": {
            "ranks": [
                {
                    "user": {
                        "id": 110836527391,
                        "short_id": 1993155989,
                        "nickname": "惠买兄弟",
                        "gender": 1,
                        "signature": "",
                        "level": 0,
                        "birthday": 0,
                        "telephone": "",
                        "avatar_thumb": {
                            "url_list": [
                                "https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/b900f8977e0a468594286c33e93f9fc1~c5_100x100.jpeg?from=4010531038",
                                "https:\/\/p26.douyinpic.com\/img\/tos-cn-i-0813\/b900f8977e0a468594286c33e93f9fc1~c5_100x100.jpeg?from=4010531038",
                                "https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/b900f8977e0a468594286c33e93f9fc1~c5_100x100.jpeg?from=4010531038"
                            ],
                            "uri": "100x100\/tos-cn-i-0813\/b900f8977e0a468594286c33e93f9fc1",
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
                            "total_diamond_count": 253636831,
                            "name": "",
                            "next_name": "",
                            "level": 60,
                            "next_diamond": 0,
                            "now_diamond": 0,
                            "this_grade_min_diamond": 200000000,
                            "this_grade_max_diamond": 0,
                            "pay_diamond_bak": 0,
                            "grade_describe": "",
                            "grade_icon_list": [],
                            "screen_chat_type": 0,
                            "new_im_icon_with_level": {
                                "url_list": [
                                    "http:\/\/p1-webcast-dycdn.byteimg.com\/img\/webcast\/user_grade_level_v4_60.png~tplv-obj.image",
                                    "http:\/\/p9-webcast-dycdn.byteimg.com\/img\/webcast\/user_grade_level_v4_60.png~tplv-obj.image",
                                    "http:\/\/p3-webcast-dycdn.byteimg.com\/img\/webcast\/user_grade_level_v4_60.png~tplv-obj.image"
                                ],
                                "uri": "webcast\/user_grade_level_v4_60.png",
                                "height": 16,
                                "width": 32,
                                "avg_color": "",
                                "image_type": 1,
                                "open_web_url": "",
                                "is_animated": false
                            },
                            "new_live_icon": {
                                "url_list": [
                                    "http:\/\/p6-webcast-dycdn.byteimg.com\/img\/webcast\/aweme_pay_grade_2x_45_49.png~tplv-obj.image",
                                    "http:\/\/p3-webcast-dycdn.byteimg.com\/img\/webcast\/aweme_pay_grade_2x_45_49.png~tplv-obj.image",
                                    "http:\/\/p1-webcast-dycdn.byteimg.com\/img\/webcast\/aweme_pay_grade_2x_45_49.png~tplv-obj.image"
                                ],
                                "uri": "webcast\/aweme_pay_grade_2x_45_49.png",
                                "height": 12,
                                "width": 12,
                                "avg_color": "",
                                "image_type": 1,
                                "open_web_url": "",
                                "is_animated": false
                            },
                            "upgrade_need_consume": 0,
                            "next_privileges": "",
                            "score": 253636831,
                            "grade_banner": ""
                        },
                        "fans_club": {
                            "data": {
                                "club_name": "",
                                "level": 0,
                                "user_fans_club_status": 0,
                                "badge": {
                                    "icons": [
                                        {
                                            "url_list": [],
                                            "uri": "",
                                            "height": 0,
                                            "width": 0,
                                            "avg_color": "",
                                            "image_type": 0,
                                            "open_web_url": "",
                                            "is_animated": false
                                        }
                                    ],
                                    "title": ""
                                },
                                "available_gift_ids": [],
                                "anchor_id": 0
                            },
                            "prefer_data": []
                        },
                        "border": {
                            "icon": {
                                "url_list": [
                                    "http:\/\/p1-webcast-dycdn.byteimg.com\/img\/webcast\/suit_level_3_award_avatar_v3.png~tplv-obj.png",
                                    "http:\/\/p3-webcast-dycdn.byteimg.com\/img\/webcast\/suit_level_3_award_avatar_v3.png~tplv-obj.png"
                                ],
                                "uri": "webcast\/suit_level_3_award_avatar_v3.png",
                                "height": 94,
                                "width": 94,
                                "avg_color": "",
                                "image_type": 0,
                                "open_web_url": "",
                                "is_animated": false
                            },
                            "level": 0
                        },
                        "special_id": "",
                        "real_time_icons": [],
                        "new_real_time_icons": [],
                        "top_vip_no": 0,
                        "own_room": {
                            "room_ids": [
                                6919377588314327816
                            ],
                            "room_ids_str": [
                                "6919377588314327816"
                            ]
                        },
                        "pay_score": 0,
                        "ticket_count": 0,
                        "link_mic_stats": 0,
                        "display_id": "huimaiXD",
                        "with_commerce_permission": false,
                        "with_fusion_shop_entry": false,
                        "total_recharge_diamond_count": 0,
                        "verified_content": "",
                        "top_fans": [],
                        "sec_uid": "MS4wLjABAAAAkwkwnqsWC0ZLpSxnTW7SqZpk23DjvbRKjiL-fVC_Ick",
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
                        "id_str": "110836527391",
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
                    "score": 151344,
                    "rank": 1,
                    "gap_description": "15.1万音浪",
                    "delta": 0,
                    "rich_description": "",
                    "city_code": "",
                    "gap_rich_description": "",
                    "shop_tags": [],
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
                            "https:\/\/p26.douyinpic.com\/aweme\/100x100\/30ed2000aad26be101cad.jpeg?from=4010531038",
                            "https:\/\/p9.douyinpic.com\/aweme\/100x100\/30ed2000aad26be101cad.jpeg?from=4010531038",
                            "https:\/\/p6.douyinpic.com\/aweme\/100x100\/30ed2000aad26be101cad.jpeg?from=4010531038"
                        ],
                        "uri": "100x100\/30ed2000aad26be101cad",
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
                                "icons": [
                                    {
                                        "url_list": [],
                                        "uri": "",
                                        "height": 0,
                                        "width": 0,
                                        "avg_color": "",
                                        "image_type": 0,
                                        "open_web_url": "",
                                        "is_animated": false
                                    }
                                ],
                                "title": ""
                            },
                            "available_gift_ids": [],
                            "anchor_id": 0
                        },
                        "prefer_data": []
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
                "gap_description": "",
                "delta": 3273,
                "rich_description": "",
                "city_code": "",
                "gap_rich_description": "",
                "shop_tags": [],
                "fixed_footer_description": ""
            },
            "seats": [],
            "charts_description": "TOP3主播获得直播广场热门推荐",
            "subtitle": "小时榜",
            "title": "全站",
            "begin_time": 1611050400,
            "direction": "给实时小时榜第一主播送礼最多的用户,会展示在此位置",
            "region_name": "",
            "is_hide_entrance": false,
            "top_img_url": "",
            "delta_time": 3411,
            "last_hour_description": "",
            "rules_url": "https:\/\/webcast.amemv.com\/falcon\/webcast_douyin\/page\/regional_list_rules\/index.html?list_label=revenue&type=fullscreen&hide_nav_bar=1&hide_status_bar=0",
            "highlight_content": "TOP3",
            "city_code": "",
            "currency": "音浪",
            "rules_url_v2": "sslocal:\/\/webcast_lynxview?url=https%3a%2f%2fs3.bytecdn.cn%2fies%2flive%2fwebcast_native_lynx_douyin%2fpages%2fdailyrank%2frule%2fhour%2ftemplate.js%3fab_type%3d1&web_bg_color=%23ffffff&type=popup&gravity=bottom&radius=10&rate_height=480&load_taro=0&fallback_url=sslocal%3a%2f%2fwebcast_webview%3furl%3dhttps%253a%252f%252fs3.bytecdn.cn%252fies%252flive%252fwebcast_native_lynx_douyin%252fh5%252findex.html%2523%252fpages%252fdailyrank%252frule%252fhour%252findex%253fab_type%253d1%26web_bg_color%3d%2523ffffff%26type%3dpopup%26gravity%3dbottom%26radius%3d10%26rate_height%3d480%26load_taro%3d0%26height%3d450"
        },
        "extra": {
            "now": 1611050589156
        },
        "status_code": 0
    }
}
```
