# 抖音直播间信息接口，抖音接口数据采集SDK



# 接口：直播间信息

### 请求Api
```http
http://主机地址/douyin/liveroom/info?token=xxx&room_id=6843198199583378191
```

### 

### 请求方式
```http
GET
```

### 

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
