# 抖音Api：用户关注列表


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


## 抖音用户关注列表Api：

### 请求Api
```http
http://主机地址/douyin/user/followings?token=xxx&uid=100000004548&cursor=1577594707000

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
| cursor | int | 翻页游标，根据结果返回的cursor传入作为下一页翻页参数，初始为0 |


### 

### 返回示例
```json

{
    "code":200,
    "data":{
        "extra":{
            "fatal_item_ids":[
            ],
            "logid":"2020091421494601002802214309181ADB",
            "now":1600091386890
        },
        "followings":[
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            Object{...},
            {
                "accept_private_policy":false,
                "account_region":"",
                "apple_account":0,
                "authority_status":0,
                "avatar_168x168":{
                    "uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                    "url_list":[
                        "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_168x168.webp?from=4010531038",
                        "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_168x168.webp?from=4010531038",
                        "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_168x168.webp?from=4010531038"
                    ]
                },
                "avatar_300x300":{
                    "uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                    "url_list":[
                        "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_300x300.webp?from=4010531038",
                        "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_300x300.webp?from=4010531038",
                        "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_300x300.webp?from=4010531038"
                    ]
                },
                "avatar_larger":{
                    "uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                    "url_list":[
                        "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_1080x1080.jpeg?from=4010531038",
                        "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_1080x1080.jpeg?from=4010531038",
                        "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_1080x1080.jpeg?from=4010531038"
                    ]
                },
                "avatar_medium":{
                    "uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                    "url_list":[
                        "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_720x720.jpeg?from=4010531038",
                        "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_720x720.jpeg?from=4010531038",
                        "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_720x720.jpeg?from=4010531038"
                    ]
                },
                "avatar_thumb":{
                    "uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                    "url_list":[
                        "https://p29-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_100x100.jpeg?from=4010531038",
                        "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_100x100.jpeg?from=4010531038",
                        "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7030b6575bac4968a822669e457d26b5~c5_100x100.jpeg?from=4010531038"
                    ]
                },
                "avatar_uri":"tos-cn-i-0813/7030b6575bac4968a822669e457d26b5",
                "bind_phone":"",
                "bio_info_permission":0,
                "birthday":"2017-01-01",
                "birthday_hide_level":0,
                "comment_filter_status":0,
                "comment_setting":0,
                "commerce_user_level":0,
                "constellation":0,
                "cover_url":[
                    {
                        "uri":"c8510002be9a3a61aad2",
                        "url_list":[
                            "http://p1-dy.byteimg.com/obj/c8510002be9a3a61aad2",
                            "http://p3-dy.byteimg.com/obj/c8510002be9a3a61aad2",
                            "http://p3-dy.byteimg.com/obj/c8510002be9a3a61aad2"
                        ]
                    }
                ],
                "create_time":0,
                "custom_verify":"",
                "cv_level":"",
                "default_download_setting":0,
                "download_prompt_ts":0,
                "download_setting":0,
                "duet_setting":0,
                "enterprise_verify_reason":"CCTV-1《经典咏流传》节目官方抖音账号",
                "follow_status":0,
                "follower_status":0,
                "gender":2,
                "geofencing":[
                ],
                "google_account":"",
                "has_email":false,
                "has_insights":false,
                "has_orders":false,
                "hide_location":false,
                "hide_search":false,
                "ins_id":"",
                "is_ad_fake":false,
                "is_binded_weibo":false,
                "is_gov_media_vip":false,
                "is_mirror":false,
                "is_phone_binded":false,
                "is_star_atlas":0,
                "is_verified":false,
                "language":"",
                "live_agreement":0,
                "live_agreement_time":0,
                "live_commerce":false,
                "live_verify":0,
                "need_recommend":0,
                "neiguang_shield":0,
                "nickname":"经典咏流传",
                "original_music_cover":null,
                "original_music_qrcode":null,
                "policy_version":[
                ],
                "prevent_download":false,
                "react_setting":0,
                "reflow_page_gid":0,
                "reflow_page_uid":0,
                "region":"CN",
                "room_id":0,
                "school_name":"",
                "school_poi_id":"",
                "school_type":0,
                "sec_uid":"MS4wLjABAAAA-CA-lq0X19hfiIPG6wA19xuXTJre1JrQX2jVD79OgRg",
                "secret":0,
                "share_qrcode_uri":"80fa0024ca1dc388297d",
                "shield_comment_notice":0,
                "shield_digg_notice":0,
                "shield_follow_notice":0,
                "short_id":"926253136",
                "signature":"文以载道，歌以咏志！",
                "special_lock":1,
                "status":1,
                "story_open":false,
                "twitter_id":"",
                "twitter_name":"",
                "type_label":[
                    189,
                    6766427600769255000
                ],
                "uid":"98297838633",
                "unique_id":"",
                "unique_id_modify_time":1550569152,
                "user_canceled":false,
                "user_mode":0,
                "user_period":0,
                "user_rate":1,
                "user_rate_map":{
                },
                "verification_type":1,
                "verify_info":"",
                "video_icon":{
                    "uri":"",
                    "url_list":[
                    ]
                },
                "video_icon_virtual_URI":"",
                "weibo_name":"",
                "weibo_schema":"",
                "weibo_url":"",
                "weibo_verify":"",
                "with_commerce_entry":false,
                "with_fusion_shop_entry":false,
                "youtube_channel_id":"",
                "youtube_channel_title":""
            }
        ],
        "has_more":true,
        "hotsoon_has_more":0,
        "hotsoon_text":"",
        "log_pb":{
            "impr_id":"2020091421494601002802214309181ADB"
        },
        "max_time":1597329058,
        "min_time":1557925977,
        "myself_user_id":"0",
        "offset":0,
        "rec_has_more":false,
        "status_code":0,
        "total":27
    },
    "msg":"success"
}
```
