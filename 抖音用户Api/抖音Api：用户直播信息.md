# 抖音Api：用户直播信息


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


## 抖音用户直播信息Api：

### 请求Api
```http
http://主机地址/douyin/user/live/info?token=xxx&uid=66598046050

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
| uid | int | 用户id|


### 

### 返回示例
```json
{
    "code":200,
    "data":{
        "data":{
            "adversary_authorization_info":1,
            "adversary_user_status":1,
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
                        "http://p6-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image",
                        "http://p9-webcast-dycdn.byteimg.com/img/webcast/authentication_icon.png~tplv-obj.image"
                    ],
                    "width":0
                },
                "custom_verify":"央视新闻官方账号",
                "enterprise_verify_reason":"央视新闻官方抖音号"
            },
            "authorization_info":3,
            "avatar_large":{
                "avg_color":"",
                "height":0,
                "image_type":0,
                "is_animated":false,
                "open_web_url":"",
                "uri":"1080x1080/30e520009a01cad2d810e",
                "url_list":[
                    "https://p29-dy.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p9-dy.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p1-dy-ipv6.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038"
                ],
                "width":0
            },
            "avatar_medium":{
                "avg_color":"",
                "height":0,
                "image_type":0,
                "is_animated":false,
                "open_web_url":"",
                "uri":"720x720/30e520009a01cad2d810e",
                "url_list":[
                    "https://p29-dy.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p6-dy-ipv6.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p3-dy-ipv6.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038"
                ],
                "width":0
            },
            "avatar_thumb":{
                "avg_color":"",
                "height":0,
                "image_type":0,
                "is_animated":false,
                "open_web_url":"",
                "uri":"100x100/30e520009a01cad2d810e",
                "url_list":[
                    "https://p6-dy-ipv6.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p26-dy.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p9-dy.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038"
                ],
                "width":0
            },
            "badge_image_list":[
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
            "display_id":"cctvnews",
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
                "follower_count":95769058,
                "following_count":26,
                "push_status":0
            },
            "follow_status":0,
            "gender":0,
            "hotsoon_verified":false,
            "hotsoon_verified_reason":"",
            "ichat_restrict_type":0,
            "id":66598046050,
            "id_str":"66598046050",
            "income_share_percent":0,
            "is_follower":false,
            "is_following":false,
            "level":0,
            "link_mic_stats":1,
            "media_badge_image_list":[
            ],
            "modify_time":1600091516,
            "need_profile_guide":false,
            "new_real_time_icons":[
            ],
            "nickname":"央视新闻",
            "own_room":{
                "room_ids":[
                    6872336845759090000
                ],
                "room_ids_str":[
                    "6872336845759089421"
                ]
            },
            "pay_grade":{
                "grade_banner":"",
                "grade_describe":"距离1级还差1抖币",
                "grade_icon_list":[
                ],
                "level":0,
                "name":"",
                "new_im_icon_with_level":{
                    "avg_color":"",
                    "height":0,
                    "image_type":0,
                    "is_animated":false,
                    "open_web_url":"",
                    "uri":"",
                    "url_list":[
                    ],
                    "width":0
                },
                "new_live_icon":{
                    "avg_color":"",
                    "height":0,
                    "image_type":0,
                    "is_animated":false,
                    "open_web_url":"",
                    "uri":"",
                    "url_list":[
                    ],
                    "width":0
                },
                "next_diamond":0,
                "next_name":"",
                "next_privileges":"",
                "now_diamond":0,
                "pay_diamond_bak":0,
                "score":0,
                "screen_chat_type":0,
                "this_grade_max_diamond":1,
                "this_grade_min_diamond":0,
                "total_diamond_count":0,
                "upgrade_need_consume":0
            },
            "pay_score":0,
            "pay_scores":0,
            "poi_info":{
                "is_poi_enabled":false,
                "poi_id":0,
                "poi_id_str":"",
                "poi_name":""
            },
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
            "sec_uid":"MS4wLjABAAAAgq8cb7cn9ByhZbmx-XQDdRTvFzmJeBBXOUO4QflP96M",
            "secret":0,
            "share_qrcode_uri":"72a4000fe1b5d865c51b",
            "short_id":653421556,
            "signature":"本宝宝暂时还没想到个性签名",
            "special_id":"",
            "status":1,
            "telephone":"",
            "ticket_count":1379873,
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
        "extra":{
            "now":1600091520634
        },
        "status_code":0
    },
    "msg":"success"
}
```


