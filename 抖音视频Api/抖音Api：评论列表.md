# 抖音Api：视频评论列表


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




## 抖音视频评论列表Api：

### 请求Api
```http
http://主机地址/douyin/video/comments?token=xxx&aweme_id=6849103450475711752&cursor=0
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
| aweme_id | int | 视频的aweme_id |
| cursor | int | 翻页游标，根据结果返回的cursor传入作为下一页翻页参数，初始为0 |


### 

### 返回示例
```json
{
    "code":200,
    "data":{
        "comments":[
            {
                "aweme_id":"6870813760379030796",
                "cid":"6870867767437230091",
                "create_time":1599748572,
                "digg_count":82810,
                "is_author_digged":false,
                "label_list":null,
                "reply_comment":null,
                "reply_comment_total":4489,
                "reply_id":"0",
                "reply_to_reply_id":"0",
                "status":1,
                "stick_position":0,
                "text":"还有谁跟我一样傻傻的看完了[呲牙]",
                "text_extra":[
                ],
                "user":{
                    "accept_private_policy":false,
                    "account_region":"",
                    "ad_cover_url":null,
                    "apple_account":0,
                    "authority_status":0,
                    "avatar_168x168":{
                        "height":720,
                        "uri":"168x168/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                        "url_list":[
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_168x168.webp?from=2956013662",
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_168x168.webp?from=2956013662",
                            "https://p9-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_168x168.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_168x168.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_300x300":{
                        "height":720,
                        "uri":"300x300/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                        "url_list":[
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_300x300.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_300x300.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_300x300.webp?from=2956013662",
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_300x300.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_larger":{
                        "height":720,
                        "uri":"1080x1080/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                        "url_list":[
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_1080x1080.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_1080x1080.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_1080x1080.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_1080x1080.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_medium":{
                        "height":720,
                        "uri":"720x720/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                        "url_list":[
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_720x720.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_720x720.webp?from=2956013662",
                            "https://p9-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_720x720.webp?from=2956013662",
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_720x720.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_thumb":{
                        "height":720,
                        "uri":"100x100/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                        "url_list":[
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_100x100.webp?from=2956013662",
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_100x100.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_100x100.webp?from=2956013662",
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad~c5_100x100.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_uri":"tos-cn-i-0813/347e5ae1a1d24a14a238ed073d6d55ad",
                    "aweme_count":0,
                    "bind_phone":"",
                    "birthday":"1982-01-01",
                    "can_set_geofencing":null,
                    "cha_list":null,
                    "comment_filter_status":0,
                    "comment_setting":0,
                    "commerce_user_level":0,
                    "constellation":10,
                    "cover_url":[
                        {
                            "height":720,
                            "uri":"c8510002be9a3a61aad2",
                            "url_list":[
                                "https://p26-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662",
                                "https://p29-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662",
                                "https://p6-dy-ipv6.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662"
                            ],
                            "width":720
                        }
                    ],
                    "create_time":0,
                    "custom_verify":"",
                    "cv_level":"",
                    "download_prompt_ts":0,
                    "download_setting":-1,
                    "duet_setting":0,
                    "enable_nearby_visible":true,
                    "enterprise_verify_reason":"",
                    "favoriting_count":0,
                    "fb_expire_time":0,
                    "follow_status":0,
                    "follower_count":0,
                    "follower_status":0,
                    "followers_detail":null,
                    "following_count":0,
                    "gender":1,
                    "geofencing":[
                    ],
                    "google_account":"",
                    "has_email":false,
                    "has_facebook_token":false,
                    "has_insights":false,
                    "has_orders":false,
                    "has_twitter_token":false,
                    "has_unread_story":false,
                    "has_youtube_token":false,
                    "hide_location":false,
                    "hide_search":false,
                    "homepage_bottom_toast":null,
                    "ins_id":"",
                    "is_ad_fake":false,
                    "is_binded_weibo":false,
                    "is_block":false,
                    "is_discipline_member":false,
                    "is_gov_media_vip":false,
                    "is_phone_binded":false,
                    "is_star":false,
                    "is_verified":true,
                    "item_list":null,
                    "language":"zh-Hans",
                    "live_agreement":0,
                    "live_agreement_time":0,
                    "live_commerce":false,
                    "live_verify":0,
                    "location":"",
                    "need_points":null,
                    "need_recommend":0,
                    "neiguang_shield":0,
                    "new_story_cover":null,
                    "nickname":"樊长林",
                    "platform_sync_info":null,
                    "prevent_download":false,
                    "react_setting":0,
                    "reflow_page_gid":0,
                    "reflow_page_uid":0,
                    "region":"CN",
                    "relative_users":null,
                    "room_id":0,
                    "school_name":"",
                    "school_poi_id":"",
                    "school_type":0,
                    "sec_uid":"MS4wLjABAAAAfq7S41aHPM-g8ZMDUeRvdzpikN1B4CnOWjRmTYLHiX4",
                    "secret":0,
                    "shield_comment_notice":0,
                    "shield_digg_notice":0,
                    "shield_follow_notice":0,
                    "short_id":"590836693",
                    "show_image_bubble":false,
                    "signature":"社会",
                    "special_lock":1,
                    "status":1,
                    "stitch_setting":0,
                    "story_count":0,
                    "story_open":false,
                    "sync_to_toutiao":0,
                    "total_favorited":0,
                    "tw_expire_time":0,
                    "twitter_id":"",
                    "twitter_name":"",
                    "type_label":null,
                    "uid":"83981829524",
                    "unique_id":"",
                    "unique_id_modify_time":1600095491,
                    "user_canceled":false,
                    "user_mode":0,
                    "user_period":0,
                    "user_rate":1,
                    "user_tags":null,
                    "verification_type":1,
                    "verify_info":"",
                    "video_icon":{
                        "height":720,
                        "uri":"",
                        "url_list":[
                        ],
                        "width":720
                    },
                    "weibo_name":"",
                    "weibo_schema":"",
                    "weibo_url":"",
                    "weibo_verify":"",
                    "white_cover_url":null,
                    "with_commerce_entry":false,
                    "with_dou_entry":false,
                    "with_fusion_shop_entry":false,
                    "with_shop_entry":false,
                    "youtube_channel_id":"",
                    "youtube_channel_title":"",
                    "youtube_expire_time":0
                },
                "user_buried":false,
                "user_digged":0
            },
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...}
        ],
        "cursor":10,
        "extra":{
            "fatal_item_ids":null,
            "now":1600095491000
        },
        "has_more":1,
        "hotsoon_filtered_count":0,
        "hotsoon_has_more":1,
        "hotsoon_text":"剩余评论因未授权抖音短视频，暂不支持查看",
        "log_pb":{
            "impr_id":"202009142258100101980820732B2EBFD5"
        },
        "reply_style":2,
        "status_code":0,
        "total":102357
    },
    "msg":"success"
}
```


