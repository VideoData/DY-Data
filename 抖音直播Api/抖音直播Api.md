# 抖音直播Api


## 抖音视频Api、抖音直播Api、抖音评论采集、抖音弹幕采集、抖音爬虫、抖音去水印、抖音视频下载、抖音视频解析
## 抖音直播数据、抖音数据采集、抖音直播监控

### 免责声明
```
有任何问题可交流学习
请勿使用本服务于商用
请勿使用本服务大量抓取
若因使用本服务与抖音造成不必要的纠纷，本人盖不负责
本人纯粹技术爱好，若侵犯抖音贵公司的权益，请告知
```
```


## 直播间信息

### 请求Api
```http
http://主机地址/douyin/liveroom/info?token=xxx&room_id=6843198199583378191
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| room_id | int | 直播间id |


### 返回示例
```json
{
  "code": 200,
  "data": {
    "data": {
      "AnchorABMap": {
      },
      "admin_user_ids": [
      ],
      "anchor_scheduled_time_text": "",
      "anchor_share_text": "#在抖音，记录美好生活#【小鱼家服饰1店】正在直播，来和我一起支持TA吧。复制下方链接，打开【抖音短视频】，直接观看直播！",
      "anchor_tab_type": 0,
      "app_id": 0,
      "auto_cover": 0,
      "base_category": 0,
      "book_end_time": 0,
      "book_time": 0,
      "business_live": 1,
      "category": 0,
      "cell_style": 3,
      "challenge_info": "",
      "client_version": 110500,
      "comment_box": {
        "placeholder": "说点什么..."
      },
      "comment_name_mode": 0,
      "common_label_list": "",
      "content_tag": "",
      "cover": {
        "avg_color": "#EBE1CE",
        "height": 0,
        "image_type": 0,
        "is_animated": false,
        "open_web_url": "",
        "uri": "webcast/6819084786280876808",
        "url_list": [
          "http://p9-webcast-dycdn.byteimg.com/img/webcast/6819084786280876808~tplv-obj.image",
          "http://p1-webcast-dycdn.byteimg.com/img/webcast/6819084786280876808~tplv-obj.image"
        ],
        "width": 0
      },
      "create_time": 1593306241,
      "deco_list": [
      ],
      "distance": "",
      "distance_city": "",
      "distance_km": "",
      "dynamic_cover_dict": {
      },
      "dynamic_cover_uri": "",
      "enable_room_perspective": false,
      "fansclub_msg_style": 2,
      "fcdn_appid": 0,
      "feed_room_label": {
        "avg_color": "#A3967C",
        "height": 0,
        "image_type": 0,
        "is_animated": false,
        "open_web_url": "",
        "uri": "webcast/2ea90002aca1159b5c67",
        "url_list": [
          "http://p6-webcast-dycdn.byteimg.com/img/webcast/2ea90002aca1159b5c67~tplv-obj.image",
          "http://p3-webcast-dycdn.byteimg.com/img/webcast/2ea90002aca1159b5c67~tplv-obj.image"
        ],
        "width": 0
      },
      "finish_reason": 0,
      "finish_time": 1593362656,
      "finish_url": "",
      "follow_msg_style": 2,
      "forum_extra_data": "",
      "gift_msg_style": 2,
      "group_id": 0,
      "group_source": 0,
      "guide_button": {
        "avg_color": "#7A5353",
        "height": 0,
        "image_type": 0,
        "is_animated": false,
        "open_web_url": "",
        "uri": "webcast/aweme_button_togather_3x.png",
        "url_list": [
          "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_button_togather_3x.png~tplv-obj.image",
          "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_button_togather_3x.png~tplv-obj.image"
        ],
        "width": 0
      },
      "has_commerce_goods": true,
      "hot_sentence_info": "",
      "id": 6843198199583378191,
      "id_str": "6843198199583378191",
      "introduction": "",
      "is_replay": false,
      "is_show_inquiry_ball": false,
      "is_show_user_card_switch": true,
      "last_ping_time": 0,
      "layout": 0,
      "like_count": 4746,
      "linker_map": {
      },
      "linkmic_layout": 1,
      "live_distribution": [
      ],
      "live_id": 1,
      "live_type_audio": false,
      "live_type_linkmic": false,
      "live_type_normal": true,
      "live_type_official": false,
      "live_type_sandbox": false,
      "live_type_screenshot": false,
      "live_type_third_party": false,
      "living_room_attrs": {
        "admin_flag": 0,
        "rank": 0,
        "room_id": 6843198199583378191,
        "room_id_str": "6843198199583378191",
        "silence_flag": 0
      },
      "location": "",
      "lottery_finish_time": 0,
      "luckymoney_num": 0,
      "mosaic_status": 0,
      "mosaic_tip": "",
      "orientation": 0,
      "os_type": 1,
      "owner": {
        "adversary_authorization_info": 1,
        "adversary_user_status": 0,
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
        "authentication_info": {
          "authentication_badge": {
            "avg_color": "",
            "height": 0,
            "image_type": 0,
            "is_animated": false,
            "open_web_url": "",
            "uri": "webcast/authentication_icon.png",
            "url_list": [
              "http://p3-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image",
              "http://p9-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image"
            ],
            "width": 0
          },
          "custom_verify": "",
          "enterprise_verify_reason": "六安裕安星期八服装经营部"
        },
        "authorization_info": 3,
        "avatar_large": {
          "avg_color": "",
          "height": 0,
          "image_type": 0,
          "is_animated": false,
          "open_web_url": "",
          "uri": "1080x1080/3110f00056c0567624bbb",
          "url_list": [
            "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p6-dy-ipv6.byteimg.com/aweme/1080x1080/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p29-dy.byteimg.com/aweme/1080x1080/3110f00056c0567624bbb.jpeg?from=4010531038"
          ],
          "width": 0
        },
        "avatar_medium": {
          "avg_color": "",
          "height": 0,
          "image_type": 0,
          "is_animated": false,
          "open_web_url": "",
          "uri": "720x720/3110f00056c0567624bbb",
          "url_list": [
            "https://p29-dy.byteimg.com/aweme/720x720/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p9-dy.byteimg.com/aweme/720x720/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p26-dy.byteimg.com/aweme/720x720/3110f00056c0567624bbb.jpeg?from=4010531038"
          ],
          "width": 0
        },
        "avatar_thumb": {
          "avg_color": "",
          "height": 0,
          "image_type": 0,
          "is_animated": false,
          "open_web_url": "",
          "uri": "100x100/3110f00056c0567624bbb",
          "url_list": [
            "https://p29-dy.byteimg.com/aweme/100x100/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p6-dy-ipv6.byteimg.com/aweme/100x100/3110f00056c0567624bbb.jpeg?from=4010531038",
            "https://p9-dy.byteimg.com/aweme/100x100/3110f00056c0567624bbb.jpeg?from=4010531038"
          ],
          "width": 0
        },
        "badge_image_list": [
          {
            "avg_color": "",
            "height": 16,
            "image_type": 1,
            "is_animated": false,
            "open_web_url": "",
            "uri": "webcast/aweme_honor_level_icon_new_5.png",
            "url_list": [
              "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_5.png~tplv-obj.image",
              "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_5.png~tplv-obj.image"
            ],
            "width": 32
          }
        ],
        "bg_img_url": "",
        "birthday": 0,
        "birthday_description": "",
        "birthday_valid": false,
        "block_status": 0,
        "city": "",
        "comment_restrict": 0,
        "commerce_webcast_config_ids": [
        ],
        "constellation": "",
        "create_time": 0,
        "disable_ichat": 0,
        "display_id": "xiaoyu58888",
        "enable_ichat_img": 0,
        "exp": 0,
        "experience": 0,
        "fan_ticket_count": 0,
        "fans_club": {
          "data": {
            "anchor_id": 0,
            "available_gift_ids": [
            ],
            "badge": {
              "icons": {
                "0": {
                  "avg_color": "",
                  "height": 0,
                  "image_type": 0,
                  "is_animated": false,
                  "open_web_url": "",
                  "uri": "",
                  "url_list": [
                  ],
                  "width": 0
                }
              },
              "title": ""
            },
            "club_name": "",
            "level": 0,
            "user_fans_club_status": 0
          },
          "prefer_data": {
          }
        },
        "fold_stranger_chat": false,
        "follow_info": {
          "follow_status": 0,
          "follower_count": 214171,
          "following_count": 7,
          "push_status": 0
        },
        "follow_status": 0,
        "gender": 2,
        "hotsoon_verified": false,
        "hotsoon_verified_reason": "",
        "ichat_restrict_type": 0,
        "id": 95760275230,
        "id_str": "95760275230",
        "income_share_percent": 0,
        "is_follower": false,
        "is_following": false,
        "level": 0,
        "link_mic_stats": 1,
        "media_badge_image_list": [
        ],
        "modify_time": 1600068668,
        "need_profile_guide": false,
        "new_real_time_icons": [
        ],
        "nickname": "小鱼家服饰1店",
        "pay_grade": {
          "grade_banner": "",
          "grade_describe": "距离6级还差17抖币",
          "grade_icon_list": [
          ],
          "level": 5,
          "name": "",
          "new_im_icon_with_level": {
            "avg_color": "",
            "height": 16,
            "image_type": 1,
            "is_animated": false,
            "open_web_url": "",
            "uri": "webcast/aweme_honor_level_icon_new_5.png",
            "url_list": [
              "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_5.png~tplv-obj.image",
              "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_5.png~tplv-obj.image"
            ],
            "width": 32
          },
          "new_live_icon": {
            "avg_color": "",
            "height": 12,
            "image_type": 1,
            "is_animated": false,
            "open_web_url": "",
            "uri": "webcast/aweme_pay_grade_2x_5_9.png",
            "url_list": [
              "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_5_9.png~tplv-obj.image",
              "http://p3-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_5_9.png~tplv-obj.image"
            ],
            "width": 12
          },
          "next_diamond": 0,
          "next_name": "",
          "next_privileges": "",
          "now_diamond": 0,
          "pay_diamond_bak": 0,
          "score": 48,
          "screen_chat_type": 0,
          "this_grade_max_diamond": 65,
          "this_grade_min_diamond": 45,
          "total_diamond_count": 48,
          "upgrade_need_consume": 0
        },
        "pay_score": 48,
        "pay_scores": 0,
        "push_comment_status": false,
        "push_digg": false,
        "push_follow": false,
        "push_friend_action": false,
        "push_ichat": false,
        "push_status": false,
        "push_video_post": false,
        "push_video_recommend": false,
        "real_time_icons": [
        ],
        "sec_uid": "MS4wLjABAAAAKp0OuO92yhbvfneuhthk-gskWF0f_JD1W3LRVltoEkc",
        "secret": 0,
        "share_qrcode_uri": "7b85001cb87e09f40e06",
        "short_id": 830360786,
        "signature": "卖衣服的小鱼儿",
        "special_id": "",
        "status": 1,
        "telephone": "",
        "ticket_count": 1890,
        "top_fans": [
        ],
        "top_vip_no": 0,
        "total_recharge_diamond_count": 0,
        "user_attr": {
          "is_admin": false,
          "is_muted": false,
          "is_super_admin": false
        },
        "user_role": 0,
        "verified": true,
        "verified_content": "",
        "verified_mobile": false,
        "verified_reason": "",
        "with_car_management_permission": false,
        "with_commerce_permission": true,
        "with_fusion_shop_entry": true
      },
      "owner_device_id": 0,
      "owner_user_id": 95760275230,
      "popularity": 0,
      "popularity_str": "",
      "pre_enter_time": 0,
      "preview_copy": "世界很大，但我们很有缘~",
      "preview_flow_tag": 0,
      "private_info": "",
      "ranklist_audience_type": 0,
      "real_distance": "",
      "relation_tag": "",
      "replay": false,
      "replay_location": 0,
      "room_audit_status": 0,
      "room_auth": {
        "AudioChat": 2,
        "Banner": 1,
        "Chat": true,
        "CommerceCard": 1,
        "Danmaku": false,
        "DanmakuDefault": 0,
        "Digg": true,
        "DonationSticker": 2,
        "Gift": true,
        "GiftAnchorMt": 0,
        "HourRank": 0,
        "Landscape": 1,
        "LandscapeChat": 1,
        "LuckMoney": true,
        "MoreAnchor": 1,
        "POI": true,
        "Props": true,
        "PublicScreen": 1,
        "RecordScreen": 0,
        "RoomContributor": true,
        "Share": 1,
        "UserCard": true,
        "UserCorner": 1
      },
      "room_create_ab_param": "",
      "room_layout": 0,
      "room_tabs": [
      ],
      "room_tag": 0,
      "scroll_config": "",
      "search_id": 0,
      "sell_goods": false,
      "share_msg_style": 2,
      "share_url": "https://webcast.amemv.com/webcast/reflow/6843198199583378191",
      "short_title": "",
      "short_touch_area_config": {
        "elements": {
          "1": {
            "priority": 0,
            "type": 1
          },
          "2": {
            "priority": 0,
            "type": 2
          },
          "3": {
            "priority": 0,
            "type": 3
          },
          "4": {
            "priority": 2,
            "type": 4
          },
          "5": {
            "priority": 3,
            "type": 5
          },
          "6": {
            "priority": 2,
            "type": 6
          },
          "7": {
            "priority": 2,
            "type": 7
          },
          "8": {
            "priority": 2,
            "type": 8
          },
          "9": {
            "priority": 2,
            "type": 9
          },
          "10": {
            "priority": 2,
            "type": 10
          },
          "12": {
            "priority": 2,
            "type": 12
          }
        }
      },
      "stamps": "",
      "start_time": 1593306245,
      "stats": {
        "digg_count": 0,
        "dou_plus_promotion": "",
        "enter_count": 0,
        "fan_ticket": 0,
        "follow_count": 2612,
        "gift_uv_count": 26,
        "id": 6843198199583378191,
        "id_str": "6843198199583378191",
        "like_count": 0,
        "money": 0,
        "total_user": 164069,
        "total_user_desp": "",
        "user_count_composition": {
          "city": 0,
          "my_follow": 0.02,
          "other": 0.27,
          "video_detail": 0.71
        },
        "watermelon": 0
      },
      "status": 4,
      "stream_close_time": 0,
      "stream_id": 683385719577641061,
      "stream_id_str": "683385719577641061",
      "stream_provider": 0,
      "stream_url": {
        "candidate_resolution": [
        ],
        "complete_push_urls": [
        ],
        "default_resolution": "ORIGION",
        "extra": {
          "anchor_interact_profile": 0,
          "audience_interact_profile": 0,
          "bframe_enable": false,
          "bitrate_adapt_strategy": 0,
          "bytevc1_enable": false,
          "default_bitrate": 800,
          "fps": 15,
          "gop_sec": 0,
          "h265_enable": false,
          "hardware_encode": false,
          "height": 640,
          "max_bitrate": 1333,
          "min_bitrate": 512,
          "roi": false,
          "sw_roi": false,
          "video_profile": 0,
          "width": 368
        },
        "flv_pull_url": {
        },
        "flv_pull_url_params": {
        },
        "hls_pull_url": "http://pull-hls-f11.douyincdn.com/stage/stream-683385719577641061.m3u8",
        "hls_pull_url_map": {
        },
        "hls_pull_url_params": "{\"VCodec\":\"h264\"}",
        "id": 683385719577641061,
        "id_str": "683385719577641061",
        "live_core_sdk_data": {
          "pull_data": {
            "options": {
              "default_quality": {
                "level": 0,
                "name": "超清",
                "resolution": "",
                "sdk_key": "origin",
                "v_codec": ""
              },
              "qualities": [
                {
                  "level": 3,
                  "name": "超清",
                  "resolution": "720x1280",
                  "sdk_key": "origin",
                  "v_codec": "264"
                }
              ]
            },
            "stream_data": "{\"common\":{\"session_id\":\"037-20200914230522010021067202095FE415\"},\"data\":{\"origin\":{\"main\":{\"flv\":\"http://pull-flv-f11.douyincdn.com/stage/stream-683385719577641061.flv\",\"hls\":\"http://pull-hls-f11.douyincdn.com/stage/stream-683385719577641061.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"720x1280\\\",\\\"vbitrate\\\":909728000}\"}}}}"
          },
          "push_data": {
            "push_stream_level": 0,
            "resolution_params": {
              "ld": {
                "default_bitrate": 800000,
                "fps": 15,
                "height": 848,
                "max_bitrate": 1333000,
                "min_bitrate": 320000,
                "width": 480
              },
              "sd": {
                "default_bitrate": 1000000,
                "fps": 15,
                "height": 960,
                "max_bitrate": 1600000,
                "min_bitrate": 500000,
                "width": 540
              }
            }
          }
        },
        "provider": 0,
        "push_urls": [
        ],
        "resolution_name": {
          "FULL_HD1": "蓝光",
          "HD1": "超清",
          "ORIGION": "原画",
          "SD1": "标清",
          "SD2": "高清"
        },
        "rtmp_pull_url": "http://pull-flv-f11.douyincdn.com/stage/stream-683385719577641061.flv",
        "rtmp_pull_url_params": "{\"VCodec\":\"h264\"}",
        "rtmp_push_url": "",
        "rtmp_push_url_params": "",
        "stream_control_type": 0
      },
      "sun_daily_icon_content": "",
      "tags": [
      ],
      "title": "小鱼家🐟服饰正在直播",
      "top_fans": [
      ],
      "use_filter": false,
      "user_count": 0,
      "user_share_text": "#在抖音，记录美好生活#【小鱼家服饰1店】正在直播，来和我一起支持TA吧。复制下方链接，打开【抖音短视频】，直接观看直播！",
      "vertical_cover_uri": "",
      "vid": "",
      "video_feed_tag": "直播中",
      "wait_copy": "失去耐心的等待将幸福擦肩而过",
      "web_count": 0,
      "webcast_comment_tcs": 0,
      "webcast_sdk_version": 0,
      "with_draw_something": false,
      "with_ktv": false,
      "with_linkmic": false
    },
    "extra": {
      "now": 1600095922450
    },
    "status_code": 0
  },
  "msg": "success"
}
```

### 

## 弹幕/关注/送礼/点赞/来了 实时获取

### 请求Api
```http
http://主机地址/douyin/liveroom/chat?token=xxx&room_id=6843198199583378191
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| room_id | int | 直播间id |


### 返回示例
```json
{
  "code": 200,
  "data": [
    {
      "type": "WebcastSocialMessage",
      "nickname": "薛莲",
      "uid": "111265487875",
      "short_id": "2072651305",
      "msg_id": "6843261579299965709",
      "sec_uid": "\"MS4wLjABAAAAmpM-hJ8AeUM8hSc3w5YlY8Q2ZUaiEu7uvt6cApLkyjg\"",
      "msg": "关注了主播"
    },
    {
      "type": "WebcastMemberMessage",
      "nickname": "用户5121651744892",
      "uid": "3654415794833197",
      "short_id": "2980367364",
      "msg_id": "6843261580051155719",
      "sec_uid": "\"MS4wLjABAAAAYcAoC-U8hSeyUxnGx_i5yoHRPPfwtr2wfplWg9KGsSMXyi7pWlPMV6XwMX7xpDgK\"",
      "msg": "来了"
    },
    {
      "type": "WebcastMemberMessage",
      "nickname": "大姑",
      "uid": "3091436132641739",
      "short_id": "2372670321",
      "msg_id": "6843261580789320462",
      "sec_uid": "\"MS4wLjABAAAAws0M9rKV7kK1ayWZ31Ebjsd8SwFI0rdf8goPY7HI8tELNK1XkFpX25yvHqe8WY9d\"",
      "msg": "来了"
    },
    {
      "type": "WebcastMemberMessage",
      "nickname": "我有一个好名字",
      "uid": "98675983627",
      "short_id": "1144452894",
      "msg_id": "6843261580508433159",
      "sec_uid": "\"MS4wLjABAAAAQhMqocOlzOLFvUE0tJKLQWKx1QuP8YXQmI2A6L3kWLQ\"",
      "msg": "来了"
    },
    {
      "type": "WebcastMemberMessage",
      "nickname": "李祥林",
      "uid": "2946292105354829",
      "short_id": "3496282621",
      "msg_id": "6843261585180560136",
      "sec_uid": "\"MS4wLjABAAAAcFKemBUvCP-CppApJZsS_4FEuIAWf2_2fpyrcsrs1PZi4U0PyXOK-3qRy4dVnAWW\"",
      "msg": "来了"
    },
 {
      "type": "WebcastChatMessage",
      "uid": "4006248980690445",
      "tid": "6843260054435826435",
      "nickname": "幸福",
      "text": "我不会买",
      "sec_uid": "MS4wLjABAAAAZWY-mQkfFitGRzNztj2FwNI6EJL6VJhEwuy3ehDmsVNBst1E2dU4umtJKmX4VW5S",
      "avatar": "https://p9-dy.byteimg.com/aweme/100x100/2dbd70006de205b08161b.jpeg?from=4010531038"
    },
    {
      "type": "WebcastMemberMessage",
      "nickname": "双子座一半天使，一半恶魔的陈欣彤🌺🌺",
      "uid": "945180703722141",
      "short_id": "2789104616",
      "msg_id": "6843261584941288205",
      "sec_uid": "\"MS4wLjABAAAAwvMatTP6mPsnysD0IPVmALci4CsfvRgOUi7lJxzq-c8\"",
      "msg": "来了"
    }
  ],
  "msg": 'success'
}
```



### 


## 直播间带货商品列表

### 请求Api
```http
http://主机地址/douyin/liveroom/promotions?token=xxx&room_id=6843198199583378191
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| room_id | int | 直播间id |


### 返回示例
```json
{
    "code":200,
    "data":{
        "current_promotion_id":"3436129527946972390",
        "entries":[
            {
                "icon":"http://p3.pstatp.com/origin/321f50008dae87efe41ce",
                "title":"订单",
                "type":2,
                "url":"aweme://webview/?url=https%3A%2F%2Faweme.snssdk.com%2Ffalcon%2Fe_commerce%2Frn%2Forder_dashboard%2F%3Fstatus_font_dark%3D0%26hide_nav_bar%3D1%26loading_bgcolor%3D161823%26should_full_screen%3D1%26enter_from%3Dlive_list_card%26origin_type%3D9902106000&status_font_dark=0&hide_nav_bar=1&loading_bgcolor=161823&should_full_screen=1&enter_from=live_list_card&origin_type=9902106000&rn_schema=aweme%3A%2F%2Freactnative%2F%3Fmodule_name%3Dpage_order_dashboard%26status_font_dark%3D0%26hide_nav_bar%3D1%26loading_bgcolor%3D161823%26should_full_screen%3D1%26channel%3Dfe_lyon_order_dashboard%26bundle%3Dindex.js%26enter_from%3Dlive_list_card%26origin_type%3D9902106000"
            }
        ],
        "expire_time":300000,
        "flash_total":0,
        "has_more":false,
        "min_refresh_gap":10000,
        "next_page_id":"",
        "promotions":[
            Object{...},
            {
                "app_type":0,
                "app_url":"",
                "apply_coupon":0,
                "button_label":"去购买",
                "campaign":false,
                "can_explain":true,
                "can_seckill":false,
                "cos_fee":0,
                "cos_ratio":0,
                "coupons":[
                ],
                "cover":"https://sf6-ttcdn-tos.pstatp.com/img/temai/4d79a9bc80b64c9ffd9412fc45f59c9bwww850-850~tplv-resize:200:0.webp",
                "detail_url":"aweme://goods/seeding/?promotion_id=3436129527946972390&product_id=3436129527946972390&target_uid=3773170526723102&item_id=0&source_page=live&sec_target_uid=MS4wLjABAAAAtvPLMdtyUwsz7C5mYnFRnpVzkJTC4k_AGxjfPhzu8dWQymu9_lzXPHMXp1q5gnGj&meta_param={"enter_from":"live","live_room_id":"6872323400263797518"}&carrier_type=&entrance_info=",
                "elastic_title":"",
                "event_param":{
                },
                "extra":{
                    "coupon_min_price":"0",
                    "start_time":"0"
                },
                "flash_icon":"",
                "flash_type":0,
                "in_stock":true,
                "index":2,
                "item_type":6,
                "label_icon":"https://sf1-ttcdn-tos.pstatp.com/obj/cmp-ecom-alliance/explain_new.png",
                "min_price":5990,
                "next_page":"split",
                "order_url":"",
                "platform":4,
                "platform_icon":"https://sf6-ttcdn-tos.pstatp.com/obj/cmp-ecom-alliance/platform_xiaodian.png",
                "platform_label":"小店",
                "price":99900,
                "product_id":"3436129527946972390",
                "promotion_id":"3436129527946972390",
                "promotion_source":[
                ],
                "sale_num":0,
                "shop_id":3494225,
                "short_half_url":"",
                "short_title":"",
                "skip_style":0,
                "status":2,
                "stock_num":0,
                "title":"k00006三色显瘦牛仔裤"
            }
        ],
        "room_type":0,
        "show_begin_time":0,
        "show_duration":0,
        "status_code":0,
        "status_msg":"",
        "top_limit":100,
        "total":31
    },
    "msg":"success"
}
```



## 开播查询

### 请求Api
```http
http://主机地址/douyin/liveroom/status?token=xxx&room_id=6843198199583378191,6872323400263797518
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| room_id | int | 直播间id |


### 返回示例
```json

{
  "code": 200,
  "data": {
    "data": [
      {
        "alive": false,
        "room_id": 6843198199583378191
      },
      {
        "alive": true,
        "room_id": 6872323400263797518
      }
    ],
    "extra": {
      "now": 1600096174925
    },
    "status_code": 0
  },
  "msg": "success"
}
```



## 在线观众

### 请求Api
```http
http://主机地址/douyin/liveroom/audience?token=xxx&room_id=6843198199583378191
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| room_id | int | 直播间id |


### 返回示例
```json

{
    "code": 200,
    "data": {
        "data": {
            "currency": "音浪",
            "has_more": false,
            "has_once_live": true,
            "music_wave": "音浪",
            "ranks": [
                {
                    "delta": 0,
                    "first_gift": false,
                    "gap_description": "99",
                    "rank": 1,
                    "score": 99,
                    "user": {
                        "adversary_authorization_info": 0,
                        "adversary_user_status": 0,
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
                        "authorization_info": 3,
                        "avatar_thumb": {
                            "avg_color": "",
                            "height": 0,
                            "image_type": 0,
                            "is_animated": false,
                            "open_web_url": "",
                            "uri": "100x100/316e3000c72bee4420e2d",
                            "url_list": [
                                "https://p3-dy-ipv6.byteimg.com/aweme/100x100/316e3000c72bee4420e2d.jpeg?from=4010531038",
                                "https://p6-dy-ipv6.byteimg.com/aweme/100x100/316e3000c72bee4420e2d.jpeg?from=4010531038",
                                "https://p26-dy.byteimg.com/aweme/100x100/316e3000c72bee4420e2d.jpeg?from=4010531038"
                            ],
                            "width": 0
                        },
                        "badge_image_list": [],
                        "bg_img_url": "",
                        "birthday": 0,
                        "birthday_description": "",
                        "birthday_valid": false,
                        "block_status": 0,
                        "city": "",
                        "comment_restrict": 0,
                        "commerce_webcast_config_ids": [],
                        "constellation": "",
                        "create_time": 0,
                        "disable_ichat": 0,
                        "display_id": "385190430",
                        "enable_ichat_img": 0,
                        "exp": 0,
                        "experience": 0,
                        "fan_ticket_count": 0,
                        "fans_club": {
                            "data": {
                                "anchor_id": 0,
                                "available_gift_ids": [],
                                "badge": {
                                    "icons": {
                                        "0": {
                                            "avg_color": "",
                                            "height": 0,
                                            "image_type": 0,
                                            "is_animated": false,
                                            "open_web_url": "",
                                            "uri": "",
                                            "url_list": [],
                                            "width": 0
                                        }
                                    },
                                    "title": ""
                                },
                                "club_name": "",
                                "level": 0,
                                "user_fans_club_status": 0
                            },
                            "prefer_data": {}
                        },
                        "fold_stranger_chat": false,
                        "follow_info": {
                            "follow_status": 0,
                            "follower_count": 0,
                            "following_count": 0,
                            "push_status": 0
                        },
                        "follow_status": 0,
                        "gender": 0,
                        "hotsoon_verified": false,
                        "hotsoon_verified_reason": "",
                        "ichat_restrict_type": 0,
                        "id": 66287019758,
                        "id_str": "66287019758",
                        "income_share_percent": 0,
                        "is_follower": false,
                        "is_following": false,
                        "level": 0,
                        "link_mic_stats": 0,
                        "media_badge_image_list": [],
                        "modify_time": 0,
                        "need_profile_guide": false,
                        "new_real_time_icons": [],
                        "nickname": "吉森",
                        "pay_grade": {
                            "grade_banner": "",
                            "grade_describe": "距离17级还差3抖币",
                            "grade_icon_list": [],
                            "level": 16,
                            "name": "",
                            "new_im_icon_with_level": {
                                "avg_color": "",
                                "height": 16,
                                "image_type": 1,
                                "is_animated": false,
                                "open_web_url": "",
                                "uri": "webcast/aweme_honor_level_icon_new_16.png",
                                "url_list": [
                                    "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_16.png~tplv-obj.image",
                                    "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_16.png~tplv-obj.image"
                                ],
                                "width": 32
                            },
                            "new_live_icon": {
                                "avg_color": "",
                                "height": 12,
                                "image_type": 1,
                                "is_animated": false,
                                "open_web_url": "",
                                "uri": "webcast/aweme_pay_grade_2x_15_19.png",
                                "url_list": [
                                    "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_15_19.png~tplv-obj.image",
                                    "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_15_19.png~tplv-obj.image"
                                ],
                                "width": 12
                            },
                            "next_diamond": 0,
                            "next_name": "",
                            "next_privileges": "",
                            "now_diamond": 0,
                            "pay_diamond_bak": 0,
                            "score": 1697,
                            "screen_chat_type": 0,
                            "this_grade_max_diamond": 1700,
                            "this_grade_min_diamond": 1300,
                            "total_diamond_count": 1697,
                            "upgrade_need_consume": 0
                        },
                        "pay_score": 0,
                        "pay_scores": 0,
                        "push_comment_status": false,
                        "push_digg": false,
                        "push_follow": false,
                        "push_friend_action": false,
                        "push_ichat": false,
                        "push_status": false,
                        "push_video_post": false,
                        "push_video_recommend": false,
                        "real_time_icons": [],
                        "sec_uid": "MS4wLjABAAAABkK4jcEax0iVyUVnrSH3Q63wM6vRb_OlpK0Zd9DbcwE",
                        "secret": 0,
                        "share_qrcode_uri": "",
                        "short_id": 385190430,
                        "signature": "",
                        "special_id": "",
                        "status": 0,
                        "telephone": "",
                        "ticket_count": 0,
                        "top_fans": [],
                        "top_vip_no": 0,
                        "total_recharge_diamond_count": 0,
                        "user_role": 0,
                        "verified": false,
                        "verified_content": "",
                        "verified_mobile": false,
                        "verified_reason": "",
                        "with_car_management_permission": false,
                        "with_commerce_permission": false,
                        "with_fusion_shop_entry": false
                    }
                },
            ],
            "rules_url": "sslocal://webcast_webview?url=https%3A%2F%2Faweme.snssdk.com%2Fmagic%2Fpage%2Fejs%2F5f27c6ca9950ec0307de9248%3FappType%3Ddouyin%26pull_down_indicator_color%3Ddark%26pull_down_indicator_not_show%3D0%26web_bg_color%3D%2523ffffffff&pull_down_close=0&pull_down_indicator_not_show=1&pull_down_indicator_color=dark&type=popup&gravity=bottom&height=450&radius=8&hide_more=0&hide_nav_bar=0&hide_status_bar=0&landscape_custom_width=1&rate_height=450",
            "seats": [],
            "self_info": {
                "delta": 0,
                "first_gift": false,
                "gap_description": "本场贡献：0音浪",
                "rank": 0,
                "score": 0
            },
            "total": 0
        },
        "extra": {
            "now": 1600957337628
        },
        "status_code": 0
    },
    "msg": "success"
}
```



## 随机推荐

### 请求Api
```http
http://主机地址/douyin/liveroom/feed?token=xxx
```

### 请求方式
```http
GET
```

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |


### 返回示例
```json

{
    "code":200,
    "data":{
        "data":[
            {
                "AnchorABMap":{
                },
                "admin_user_ids":[
                    99861659499,
                    52271736462,
                    1011196253964014,
                    96403313823,
                    101799896778,
                    103146623893,
                    105895303173,
                    2084292323972430,
                    1103515168282891,
                    106708685343
                ],
                "anchor_scheduled_time_text":"",
                "anchor_share_text":"#在抖音，记录美好生活#【君少🔥】正在直播，来和我一起支持TA吧。复制下方链接，打开【抖音短视频】，直接观看直播！",
                "anchor_tab_type":0,
                "app_id":0,
                "auto_cover":0,
                "base_category":0,
                "book_end_time":0,
                "book_time":0,
                "business_live":0,
                "category":0,
                "cell_style":3,
                "challenge_info":"",
                "client_version":120400,
                "comment_box":{
                    "placeholder":"说点什么..."
                },
                "comment_name_mode":0,
                "common_label_list":"",
                "content_tag":"语音互动",
                "cover":{
                    "avg_color":"#A3A3CC",
                    "height":0,
                    "image_type":0,
                    "is_animated":false,
                    "open_web_url":"",
                    "uri":"webcast/6825919466414000909",
                    "url_list":[
                        "http://p3-webcast-dycdn.byteimg.com/img/webcast/6825919466414000909~tplv-obj.image",
                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/6825919466414000909~tplv-obj.image"
                    ],
                    "width":0
                },
                "create_time":1600093069,
                "deco_list":[
                ],
                "distance":"",
                "distance_city":"",
                "distance_km":"",
                "dynamic_cover_dict":{
                },
                "dynamic_cover_uri":"",
                "enable_room_perspective":true,
                "fansclub_msg_style":0,
                "fcdn_appid":0,
                "feed_room_label":{
                    "avg_color":"#E0D4BC",
                    "height":0,
                    "image_type":0,
                    "is_animated":false,
                    "open_web_url":"",
                    "uri":"webcast/2ea90002aca1159b5c67",
                    "url_list":[
                        "http://p3-webcast-dycdn.byteimg.com/img/webcast/2ea90002aca1159b5c67~tplv-obj.image",
                        "http://p1-webcast-dycdn.byteimg.com/img/webcast/2ea90002aca1159b5c67~tplv-obj.image"
                    ],
                    "width":0
                },
                "finish_reason":0,
                "finish_time":1600096193,
                "finish_url":"",
                "follow_msg_style":0,
                "forum_extra_data":"",
                "gift_msg_style":0,
                "group_id":0,
                "group_source":22,
                "guide_button":{
                    "avg_color":"#7A5353",
                    "height":0,
                    "image_type":0,
                    "is_animated":false,
                    "open_web_url":"",
                    "uri":"webcast/aweme_button_togather_3x.png",
                    "url_list":[
                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_button_togather_3x.png~tplv-obj.image",
                        "http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_button_togather_3x.png~tplv-obj.image"
                    ],
                    "width":0
                },
                "has_commerce_goods":true,
                "hot_sentence_info":"",
                "id":6872347400942570254,
                "id_str":"6872347400942570254",
                "introduction":"",
                "is_replay":false,
                "is_show_inquiry_ball":false,
                "is_show_user_card_switch":true,
                "last_ping_time":0,
                "layout":0,
                "like_count":92949,
                "linker_map":{
                },
                "linkmic_layout":1,
                "live_distribution":[
                ],
                "live_id":1,
                "live_type_audio":false,
                "live_type_linkmic":false,
                "live_type_normal":true,
                "live_type_official":false,
                "live_type_sandbox":false,
                "live_type_screenshot":false,
                "live_type_third_party":false,
                "living_room_attrs":{
                    "admin_flag":0,
                    "rank":0,
                    "room_id":6872347400942570254,
                    "room_id_str":"6872347400942570254",
                    "silence_flag":0
                },
                "location":"",
                "lottery_finish_time":0,
                "luckymoney_num":0,
                "mosaic_status":0,
                "mosaic_tip":"",
                "orientation":0,
                "os_type":1,
                "owner":{
                    "adversary_authorization_info":1,
                    "adversary_user_status":0,
                    "allow_be_located":false,
                    "allow_find_by_contacts":false,
                    "allow_others_download_video":false,
                    "allow_others_download_when_sharing_video":false,
                    "allow_share_show_profile":false,
                    "allow_show_in_gossip":false,
                    "allow_show_my_action":false,
                    "allow_strange_comment":false,
                    "allow_unfollower_comment":false,
                    "allow_use_linkmic":false,
                    "authentication_info":{
                        "authentication_badge":{
                            "avg_color":"",
                            "height":0,
                            "image_type":0,
                            "is_animated":false,
                            "open_web_url":"",
                            "uri":"webcast/authentication_icon.png",
                            "url_list":[
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image",
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image"
                            ],
                            "width":0
                        },
                        "custom_verify":"抖音音乐人",
                        "enterprise_verify_reason":""
                    },
                    "authorization_info":3,
                    "avatar_large":{
                        "avg_color":"",
                        "height":0,
                        "image_type":0,
                        "is_animated":false,
                        "open_web_url":"",
                        "uri":"1080x1080/3109c00018629796e0bbf",
                        "url_list":[
                            "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p29-dy.byteimg.com/aweme/1080x1080/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p6-dy-ipv6.byteimg.com/aweme/1080x1080/3109c00018629796e0bbf.jpeg?from=4010531038"
                        ],
                        "width":0
                    },
                    "avatar_medium":{
                        "avg_color":"",
                        "height":0,
                        "image_type":0,
                        "is_animated":false,
                        "open_web_url":"",
                        "uri":"720x720/3109c00018629796e0bbf",
                        "url_list":[
                            "https://p29-dy.byteimg.com/aweme/720x720/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p9-dy.byteimg.com/aweme/720x720/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p3-dy-ipv6.byteimg.com/aweme/720x720/3109c00018629796e0bbf.jpeg?from=4010531038"
                        ],
                        "width":0
                    },
                    "avatar_thumb":{
                        "avg_color":"",
                        "height":0,
                        "image_type":0,
                        "is_animated":false,
                        "open_web_url":"",
                        "uri":"100x100/3109c00018629796e0bbf",
                        "url_list":[
                            "https://p29-dy.byteimg.com/aweme/100x100/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p1-dy-ipv6.byteimg.com/aweme/100x100/3109c00018629796e0bbf.jpeg?from=4010531038",
                            "https://p9-dy.byteimg.com/aweme/100x100/3109c00018629796e0bbf.jpeg?from=4010531038"
                        ],
                        "width":0
                    },
                    "badge_image_list":[
                        {
                            "avg_color":"",
                            "height":16,
                            "image_type":1,
                            "is_animated":false,
                            "open_web_url":"",
                            "uri":"webcast/aweme_honor_level_icon_new_10.png",
                            "url_list":[
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_10.png~tplv-obj.image",
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_10.png~tplv-obj.image"
                            ],
                            "width":32
                        }
                    ],
                    "bg_img_url":"",
                    "birthday":0,
                    "birthday_description":"",
                    "birthday_valid":false,
                    "block_status":0,
                    "city":"上海",
                    "comment_restrict":0,
                    "commerce_webcast_config_ids":[
                    ],
                    "constellation":"",
                    "create_time":0,
                    "disable_ichat":0,
                    "display_id":"hanyu8866",
                    "enable_ichat_img":0,
                    "exp":0,
                    "experience":0,
                    "fan_ticket_count":0,
                    "fans_club":{
                        "data":{
                            "anchor_id":0,
                            "available_gift_ids":[
                            ],
                            "badge":{
                                "icons":{
                                    "0":{
                                        "avg_color":"",
                                        "height":0,
                                        "image_type":0,
                                        "is_animated":false,
                                        "open_web_url":"",
                                        "uri":"",
                                        "url_list":[
                                        ],
                                        "width":0
                                    }
                                },
                                "title":""
                            },
                            "club_name":"",
                            "level":0,
                            "user_fans_club_status":0
                        },
                        "prefer_data":{
                        }
                    },
                    "fold_stranger_chat":false,
                    "follow_info":{
                        "follow_status":0,
                        "follower_count":88159,
                        "following_count":272,
                        "push_status":0
                    },
                    "follow_status":0,
                    "gender":1,
                    "hotsoon_verified":false,
                    "hotsoon_verified_reason":"",
                    "ichat_restrict_type":0,
                    "id":53116625314,
                    "id_str":"53116625314",
                    "income_share_percent":0,
                    "is_follower":false,
                    "is_following":false,
                    "level":0,
                    "link_mic_stats":1,
                    "media_badge_image_list":[
                    ],
                    "modify_time":1600095187,
                    "need_profile_guide":false,
                    "new_real_time_icons":[
                    ],
                    "nickname":"君少🔥",
                    "own_room":{
                        "room_ids":[
                            6872347400942570000
                        ],
                        "room_ids_str":[
                            "6872347400942570254"
                        ]
                    },
                    "pay_grade":{
                        "grade_banner":"",
                        "grade_describe":"距离11级还差76抖币",
                        "grade_icon_list":[
                        ],
                        "level":10,
                        "name":"",
                        "new_im_icon_with_level":{
                            "avg_color":"",
                            "height":16,
                            "image_type":1,
                            "is_animated":false,
                            "open_web_url":"",
                            "uri":"webcast/aweme_honor_level_icon_new_10.png",
                            "url_list":[
                                "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_10.png~tplv-obj.image",
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_10.png~tplv-obj.image"
                            ],
                            "width":32
                        },
                        "new_live_icon":{
                            "avg_color":"",
                            "height":12,
                            "image_type":1,
                            "is_animated":false,
                            "open_web_url":"",
                            "uri":"webcast/aweme_pay_grade_2x_10_14.png",
                            "url_list":[
                                "http://p3-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_10_14.png~tplv-obj.image",
                                "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_10_14.png~tplv-obj.image"
                            ],
                            "width":12
                        },
                        "next_diamond":0,
                        "next_name":"",
                        "next_privileges":"",
                        "now_diamond":0,
                        "pay_diamond_bak":0,
                        "score":234,
                        "screen_chat_type":0,
                        "this_grade_max_diamond":310,
                        "this_grade_min_diamond":230,
                        "total_diamond_count":234,
                        "upgrade_need_consume":0
                    },
                    "pay_score":234,
                    "pay_scores":0,
                    "push_comment_status":false,
                    "push_digg":false,
                    "push_follow":false,
                    "push_friend_action":false,
                    "push_ichat":false,
                    "push_status":false,
                    "push_video_post":false,
                    "push_video_recommend":false,
                    "real_time_icons":[
                    ],
                    "sec_uid":"MS4wLjABAAAA3MeJAw6E5g0nxsRGlIwlHEVyhjGYcZPQST_y4Zqt9xw",
                    "secret":0,
                    "share_qrcode_uri":"671000112a883c693062",
                    "short_id":379542891,
                    "signature":"👉开播时间：晚21:00～2:00    (偶尔延迟请谅解下）
👉直播内容: 唱歌, 幽默, 老歌, 新歌, 心灵, 情感生活..
👉酷🐶搜君少 关注下哈, 唯一抖音号其他冒充非本人
👉身高182:体重135:坚持做个好的品行内外兼修的人
👉小视频全部本人现录现场,  5级粉丝团➕V❤V👗",
                    "special_id":"",
                    "status":1,
                    "telephone":"",
                    "ticket_count":52070102,
                    "top_fans":[
                    ],
                    "top_vip_no":0,
                    "total_recharge_diamond_count":0,
                    "user_attr":{
                        "is_admin":false,
                        "is_muted":false,
                        "is_super_admin":false
                    },
                    "user_role":0,
                    "verified":true,
                    "verified_content":"",
                    "verified_mobile":false,
                    "verified_reason":"",
                    "with_car_management_permission":false,
                    "with_commerce_permission":true,
                    "with_fusion_shop_entry":true
                },
                "owner_device_id":0,
                "owner_user_id":53116625314,
                "popularity":0,
                "popularity_str":"",
                "pre_enter_time":0,
                "preview_copy":" 昨天擦肩而过，今天不再错过~",
                "preview_flow_tag":0,
                "private_info":"",
                "ranklist_audience_type":0,
                "real_distance":"",
                "relation_tag":"",
                "replay":true,
                "replay_location":0,
                "room_audit_status":0,
                "room_auth":{
                    "AudioChat":0,
                    "Banner":1,
                    "Chat":true,
                    "CommerceCard":1,
                    "Danmaku":false,
                    "DanmakuDefault":1,
                    "Digg":true,
                    "DonationSticker":2,
                    "Gift":true,
                    "GiftAnchorMt":1,
                    "HourRank":0,
                    "Landscape":1,
                    "LandscapeChat":1,
                    "LuckMoney":true,
                    "MoreAnchor":1,
                    "POI":true,
                    "Props":true,
                    "PublicScreen":1,
                    "RecordScreen":2,
                    "RoomContributor":true,
                    "Share":1,
                    "UserCard":true,
                    "UserCorner":1
                },
                "room_create_ab_param":"",
                "room_layout":0,
                "room_tabs":[
                ],
                "room_tag":0,
                "scroll_config":"",
                "search_id":0,
                "sell_goods":false,
                "share_msg_style":0,
                "share_url":"https://webcast.amemv.com/webcast/reflow/6872347400942570254",
                "short_title":"",
                "short_touch_area_config":{
                    "elements":{
                        "1":{
                            "priority":0,
                            "type":1
                        },
                        "2":{
                            "priority":0,
                            "type":2
                        },
                        "3":{
                            "priority":0,
                            "type":3
                        },
                        "4":{
                            "priority":2,
                            "type":4
                        },
                        "5":{
                            "priority":3,
                            "type":5
                        },
                        "6":{
                            "priority":2,
                            "type":6
                        },
                        "7":{
                            "priority":2,
                            "type":7
                        },
                        "8":{
                            "priority":2,
                            "type":8
                        },
                        "9":{
                            "priority":2,
                            "type":9
                        },
                        "10":{
                            "priority":2,
                            "type":10
                        },
                        "12":{
                            "priority":2,
                            "type":12
                        }
                    }
                },
                "stamps":"",
                "start_time":0,
                "stats":{
                    "digg_count":0,
                    "dou_plus_promotion":"",
                    "enter_count":0,
                    "fan_ticket":35487,
                    "follow_count":130,
                    "gift_uv_count":114,
                    "id":6872347400942570254,
                    "id_str":"6872347400942570254",
                    "like_count":0,
                    "money":0,
                    "total_user":19291,
                    "total_user_desp":"",
                    "user_count_composition":{
                        "city":0,
                        "my_follow":0.02,
                        "other":0.54,
                        "video_detail":0.43
                    },
                    "watermelon":0
                },
                "status":2,
                "stream_close_time":0,
                "stream_id":107380421578457227,
                "stream_id_str":"107380421578457227",
                "stream_provider":0,
                "stream_url":{
                    "candidate_resolution":[
                    ],
                    "complete_push_urls":[
                    ],
                    "default_resolution":"ORIGION",
                    "extra":{
                        "anchor_interact_profile":0,
                        "audience_interact_profile":0,
                        "bframe_enable":false,
                        "bitrate_adapt_strategy":0,
                        "bytevc1_enable":false,
                        "default_bitrate":800,
                        "fps":15,
                        "gop_sec":0,
                        "h265_enable":false,
                        "hardware_encode":false,
                        "height":1280,
                        "max_bitrate":1333,
                        "min_bitrate":512,
                        "roi":false,
                        "sw_roi":false,
                        "video_profile":0,
                        "width":720
                    },
                    "flv_pull_url":{
                    },
                    "flv_pull_url_params":{
                    },
                    "hls_pull_url":"http://pull-hls-l26.douyincdn.com/stage/stream-107380421578457227_or4.m3u8",
                    "hls_pull_url_map":{
                    },
                    "hls_pull_url_params":"{"VCodec":"h264"}",
                    "id":107380421578457227,
                    "id_str":"107380421578457227",
                    "live_core_sdk_data":{
                        "pull_data":{
                            "options":{
                                "default_quality":{
                                    "level":0,
                                    "name":"原画",
                                    "resolution":"",
                                    "sdk_key":"origin",
                                    "v_codec":""
                                },
                                "qualities":[
                                    {
                                        "level":0,
                                        "name":"原画",
                                        "resolution":"",
                                        "sdk_key":"origin",
                                        "v_codec":""
                                    }
                                ]
                            },
                            "stream_data":"{"common":{"session_id":"037-202009142310030100120330321750DAD3"},"data":{"origin":{"main":{"flv":"http://pull-flv-l26.douyincdn.com/stage/stream-107380421578457227_or4.flv","hls":"http://pull-hls-l26.douyincdn.com/stage/stream-107380421578457227_or4.m3u8","cmaf":"","dash":"","sdk_params":"{\"VCodec\":\"h264\",\"gop\":4,\"resolution\":\"or4\",\"vbitrate\":0}"}}}}"
                        }
                    },
                    "provider":0,
                    "push_urls":[
                    ],
                    "resolution_name":{
                        "FULL_HD1":"蓝光",
                        "HD1":"超清",
                        "ORIGION":"原画",
                        "SD1":"标清",
                        "SD2":"高清"
                    },
                    "rtmp_pull_url":"http://pull-flv-l26.douyincdn.com/stage/stream-107380421578457227_or4.flv",
                    "rtmp_pull_url_params":"{"VCodec":"h264"}",
                    "rtmp_push_url":"",
                    "rtmp_push_url_params":"",
                    "stream_control_type":0
                },
                "sun_daily_icon_content":"",
                "tags":[
                ],
                "title":"人帅歌美☘️正能量",
                "top_fans":[
                    {
                        "fan_ticket":10400,
                        "user":{
                            "adversary_authorization_info":1,
                            "adversary_user_status":0,
                            "allow_be_located":false,
                            "allow_find_by_contacts":false,
                            "allow_others_download_video":false,
                            "allow_others_download_when_sharing_video":false,
                            "allow_share_show_profile":false,
                            "allow_show_in_gossip":false,
                            "allow_show_my_action":false,
                            "allow_strange_comment":false,
                            "allow_unfollower_comment":false,
                            "allow_use_linkmic":false,
                            "authorization_info":3,
                            "avatar_large":{
                                "avg_color":"",
                                "height":0,
                                "image_type":0,
                                "is_animated":false,
                                "open_web_url":"",
                                "uri":"1080x1080/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b",
                                "url_list":[
                                    "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_1080x1080.jpeg?from=4010531038",
                                    "https://p9-dy.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_1080x1080.jpeg?from=4010531038",
                                    "https://p26-dy.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_1080x1080.jpeg?from=4010531038"
                                ],
                                "width":0
                            },
                            "avatar_medium":{
                                "avg_color":"",
                                "height":0,
                                "image_type":0,
                                "is_animated":false,
                                "open_web_url":"",
                                "uri":"720x720/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b",
                                "url_list":[
                                    "https://p29-dy.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_720x720.jpeg?from=4010531038",
                                    "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_720x720.jpeg?from=4010531038",
                                    "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_720x720.jpeg?from=4010531038"
                                ],
                                "width":0
                            },
                            "avatar_thumb":{
                                "avg_color":"",
                                "height":0,
                                "image_type":0,
                                "is_animated":false,
                                "open_web_url":"",
                                "uri":"100x100/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b",
                                "url_list":[
                                    "https://p29-dy.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_100x100.jpeg?from=4010531038",
                                    "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_100x100.jpeg?from=4010531038",
                                    "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/933a3000b63148a7b46ff2933bf6a64b~c5_100x100.jpeg?from=4010531038"
                                ],
                                "width":0
                            },
                            "badge_image_list":[
                                {
                                    "avg_color":"",
                                    "height":16,
                                    "image_type":1,
                                    "is_animated":false,
                                    "open_web_url":"",
                                    "uri":"webcast/aweme_honor_level_icon_new_45.png",
                                    "url_list":[
                                        "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_45.png~tplv-obj.image",
                                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_45.png~tplv-obj.image"
                                    ],
                                    "width":32
                                }
                            ],
                            "bg_img_url":"",
                            "birthday":0,
                            "birthday_description":"",
                            "birthday_valid":false,
                            "block_status":0,
                            "city":"",
                            "comment_restrict":0,
                            "commerce_webcast_config_ids":[
                            ],
                            "constellation":"",
                            "create_time":0,
                            "disable_ichat":0,
                            "display_id":"dyru1g558bhr",
                            "enable_ichat_img":0,
                            "exp":0,
                            "experience":0,
                            "fan_ticket_count":0,
                            "fans_club":{
                                "data":{
                                    "anchor_id":0,
                                    "available_gift_ids":[
                                    ],
                                    "badge":{
                                        "icons":{
                                            "0":{
                                                "avg_color":"",
                                                "height":0,
                                                "image_type":0,
                                                "is_animated":false,
                                                "open_web_url":"",
                                                "uri":"",
                                                "url_list":[
                                                ],
                                                "width":0
                                            }
                                        },
                                        "title":""
                                    },
                                    "club_name":"",
                                    "level":0,
                                    "user_fans_club_status":0
                                },
                                "prefer_data":{
                                }
                            },
                            "fold_stranger_chat":false,
                            "follow_info":{
                                "follow_status":0,
                                "follower_count":57,
                                "following_count":31,
                                "push_status":0
                            },
                            "follow_status":0,
                            "gender":2,
                            "hotsoon_verified":false,
                            "hotsoon_verified_reason":"",
                            "ichat_restrict_type":0,
                            "id":1103515168282891,
                            "id_str":"1103515168282891",
                            "income_share_percent":0,
                            "is_follower":false,
                            "is_following":false,
                            "level":0,
                            "link_mic_stats":1,
                            "media_badge_image_list":[
                            ],
                            "modify_time":1599832509,
                            "need_profile_guide":false,
                            "new_real_time_icons":[
                            ],
                            "nickname":"雅玉",
                            "pay_grade":{
                                "grade_banner":"",
                                "grade_describe":"距离46级还差50.0w抖币",
                                "grade_icon_list":[
                                ],
                                "level":45,
                                "name":"",
                                "new_im_icon_with_level":{
                                    "avg_color":"",
                                    "height":16,
                                    "image_type":1,
                                    "is_animated":false,
                                    "open_web_url":"",
                                    "uri":"webcast/aweme_honor_level_icon_new_45.png",
                                    "url_list":[
                                        "http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_45.png~tplv-obj.image",
                                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_45.png~tplv-obj.image"
                                    ],
                                    "width":32
                                },
                                "new_live_icon":{
                                    "avg_color":"",
                                    "height":12,
                                    "image_type":1,
                                    "is_animated":false,
                                    "open_web_url":"",
                                    "uri":"webcast/aweme_pay_grade_2x_45_49.png",
                                    "url_list":[
                                        "http://p3-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_45_49.png~tplv-obj.image",
                                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_45_49.png~tplv-obj.image"
                                    ],
                                    "width":12
                                },
                                "next_diamond":0,
                                "next_name":"",
                                "next_privileges":"",
                                "now_diamond":0,
                                "pay_diamond_bak":0,
                                "score":4000225,
                                "screen_chat_type":0,
                                "this_grade_max_diamond":4500000,
                                "this_grade_min_diamond":3400000,
                                "total_diamond_count":4000225,
                                "upgrade_need_consume":0
                            },
                            "pay_score":4000225,
                            "pay_scores":0,
                            "push_comment_status":false,
                            "push_digg":false,
                            "push_follow":false,
                            "push_friend_action":false,
                            "push_ichat":false,
                            "push_status":false,
                            "push_video_post":false,
                            "push_video_recommend":false,
                            "real_time_icons":[
                            ],
                            "sec_uid":"MS4wLjABAAAA1iOTCLUnU0ltsnYC-NIh3dIkse2of0cgJxeM9w7P102k8xK4TtEeAvyAnSg6hOys",
                            "secret":1,
                            "share_qrcode_uri":"31166000284aa5924b352",
                            "short_id":3589316171,
                            "signature":"我不能改变生命的长度，但我可以把握生命的宽度！
     断、舍、离。
     断：把不快乐的一切事情从脑海里删除。
    舍：把心里面的垃圾定期的处理掉。
    离：放过自己放空自己，才会有机会储存快乐的空间。",
                            "special_id":"",
                            "status":1,
                            "telephone":"",
                            "ticket_count":0,
                            "top_fans":[
                            ],
                            "top_vip_no":0,
                            "total_recharge_diamond_count":0,
                            "user_attr":{
                                "is_admin":false,
                                "is_muted":false,
                                "is_super_admin":false
                            },
                            "user_role":0,
                            "verified":true,
                            "verified_content":"",
                            "verified_mobile":false,
                            "verified_reason":"",
                            "with_car_management_permission":false,
                            "with_commerce_permission":false,
                            "with_fusion_shop_entry":false
                        }
                    }
                ],
                "use_filter":false,
                "user_count":1083,
                "user_share_text":"#在抖音，记录美好生活#【君少🔥】正在直播，来和我一起支持TA吧。复制下方链接，打开【抖音短视频】，直接观看直播！",
                "vertical_cover_uri":"",
                "vid":"",
                "video_feed_tag":"直播中",
                "wait_copy":"失去耐心的等待将幸福擦肩而过",
                "web_count":0,
                "webcast_comment_tcs":0,
                "webcast_sdk_version":0,
                "with_draw_something":false,
                "with_ktv":false,
                "with_linkmic":false
            }
        ],
        "extra":{
            "now":1600096204128
        },
        "status_code":0
    },
    "msg":"success"
}
```


