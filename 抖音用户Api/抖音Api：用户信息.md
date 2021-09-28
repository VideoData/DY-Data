# 抖音Api：用户信息


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




## 抖音用户信息Api：

### 请求Api
```http
http://主机地址/douyin/user/info?token=xxx&uid=66598046050

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
| uid | int | 用户id |


### 

### 返回示例
```json
{
    "code": 200,
    "data": {
        "extra": {
            "now": 1600091272000
        },
        "log_pb": {
            "impr_id": "202009142147520101980590212E21A4C9"
        },
        "status_code": 0,
        "user": {
            "apple_account": 0,
            "avatar_168x168": {
                "uri": "30e520009a01cad2d810e",
                "url_list": [
                    "https://p1-dy-ipv6.byteimg.com/img/30e520009a01cad2d810e~c5_168x168.webp?from=4010531038",
                    "https://p26-dy.byteimg.com/img/30e520009a01cad2d810e~c5_168x168.webp?from=4010531038",
                    "https://p9-dy.byteimg.com/img/30e520009a01cad2d810e~c5_168x168.webp?from=4010531038"
                ]
            },
            "avatar_300x300": {
                "uri": "30e520009a01cad2d810e",
                "url_list": [
                    "https://p3-dy-ipv6.byteimg.com/img/30e520009a01cad2d810e~c5_300x300.webp?from=4010531038",
                    "https://p1-dy-ipv6.byteimg.com/img/30e520009a01cad2d810e~c5_300x300.webp?from=4010531038",
                    "https://p26-dy.byteimg.com/img/30e520009a01cad2d810e~c5_300x300.webp?from=4010531038"
                ]
            },
            "avatar_larger": {
                "uri": "30e520009a01cad2d810e",
                "url_list": [
                    "https://p6-dy-ipv6.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p26-dy.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/30e520009a01cad2d810e.jpeg?from=4010531038"
                ]
            },
            "avatar_medium": {
                "uri": "30e520009a01cad2d810e",
                "url_list": [
                    "https://p29-dy.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p6-dy-ipv6.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p3-dy-ipv6.byteimg.com/aweme/720x720/30e520009a01cad2d810e.jpeg?from=4010531038"
                ]
            },
            "avatar_thumb": {
                "uri": "30e520009a01cad2d810e",
                "url_list": [
                    "https://p9-dy.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p6-dy-ipv6.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038",
                    "https://p29-dy.byteimg.com/aweme/100x100/30e520009a01cad2d810e.jpeg?from=4010531038"
                ]
            },
            "aweme_count": 3467,
            "birthday": "",
            "birthday_hide_level": 0,
            "city": "北京",
            "commerce_info": {
                "challenge_list": [],
                "head_image_list": null,
                "offline_info_list": [],
                "smart_phone_list": null,
                "task_list": null
            },
            "commerce_user_info": {
                "ad_revenue_rits": null,
                "has_ads_entry": false
            },
            "commerce_user_level": 0,
            "country": "中国",
            "cover_url": [
                {
                    "uri": "c8510002be9a3a61aad2",
                    "url_list": [
                        "https://p6-dy-ipv6.byteimg.com/obj/c8510002be9a3a61aad2?from=1247829622",
                        "https://p9-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=1247829622",
                        "https://p26-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=1247829622"
                    ]
                }
            ],
            "custom_verify": "央视新闻官方账号",
            "district": "朝阳",
            "dongtai_count": 3474,
            "enterprise_user_info": "{"commerce_info":{"offline_info_list":[],"challenge_list":[],"task_list":null,"head_image_list":null,"smart_phone_list":null},"homepage_bottom_toast":[],"permissions":[{"Id":4,"Key":"LiveShop","Name":"直播电商","AppId":1128,"Status":1,"Extra":null,"Customization":null,"Parent":0},{"Id":3,"Key":"ItemShop","Name":"视频电商","AppId":1128,"Status":1,"Extra":null,"Customization":null,"Parent":0},{"Id":5,"Key":"UserShop","Name":"个人橱窗","AppId":1128,"Status":1,"Extra":null,"Customization":null,"Parent":0}]}",
            "enterprise_verify_reason": "央视新闻官方抖音号",
            "favoriting_count": 39,
            "follow_status": 0,
            "follower_count": 95769103,
            "follower_status": 0,
            "followers_detail": [
                {
                    "app_name": "aweme",
                    "apple_id": "1142110895",
                    "download_url": "https://d.douyin.com/JsvN/",
                    "fans_count": 95769103,
                    "icon": "http://p3.pstatp.com/origin/50ec00079b64de2050dc",
                    "name": "抖音",
                    "open_url": "snssdk1128://user/profile/66598046050?",
                    "package_name": "com.ss.android.ugc.aweme"
                },
                {
                    "app_name": "news_article",
                    "apple_id": "529092160",
                    "download_url": "https://d.toutiao.com/YjjY/",
                    "fans_count": 0,
                    "icon": "http://p3.pstatp.com/origin/50ed00079a1b6b8d1fb1",
                    "name": "头条",
                    "open_url": "snssdk143://profile?uid=0",
                    "package_name": "com.ss.android.article.news"
                },
                {
                    "app_name": "live_stream",
                    "apple_id": "1086047750",
                    "download_url": "http://d.huoshanzhibo.com/eFvB/",
                    "fans_count": 0,
                    "icon": "http://p3.pstatp.com/origin/2ea5c000abe106154adef",
                    "name": "抖音火山版",
                    "open_url": "snssdk1112://profile?id=0",
                    "package_name": "com.ss.android.ugc.live"
                }
            ],
            "following_count": 26,
            "forward_count": 7,
            "gender": 0,
            "ins_id": "",
            "is_activity_user": false,
            "is_block": false,
            "is_blocked": false,
            "is_effect_artist": false,
            "is_gov_media_vip": true,
            "is_mix_user": true,
            "is_star": false,
            "iso_country_code": "",
            "live_commerce": true,
            "location": "北京",
            "message_chat_entry": true,
            "mplatform_followers_count": 95769103,
            "nickname": "央视新闻",
            "original_musician": {
                "digg_count": 0,
                "music_count": 0,
                "music_used_count": 0
            },
            "profile_story": {
                "ttl_story_status": 0,
                "unread_story_ids": null
            },
            "profile_tab_type": 0,
            "province": "北京",
            "r_fans_group_info": {},
            "recommend_reason_relation": "",
            "recommend_user_reason_source": 0,
            "room_data": "",
            "room_id": 6872336845759089421,
            "school_name": "",
            "sec_uid": "MS4wLjABAAAAgq8cb7cn9ByhZbmx-XQDdRTvFzmJeBBXOUO4QflP96M",
            "secret": 0,
            "share_info": {
                "bool_persist": 1,
                "share_desc": "在抖音，记录美好生活！",
                "share_image_url": {
                    "url_list": null
                },
                "share_qrcode_url": {
                    "uri": "72a4000fe1b5d865c51b",
                    "url_list": [
                        "https://p6-dy-ipv6.byteimg.com/obj/72a4000fe1b5d865c51b",
                        "https://p3-dy-ipv6.byteimg.com/obj/72a4000fe1b5d865c51b",
                        "https://p9-dy.byteimg.com/obj/72a4000fe1b5d865c51b"
                    ]
                },
                "share_title": "快来加入抖音，让你发现最有趣的我！",
                "share_url": "www.iesdouyin.com/share/user/66598046050?sec_uid=MS4wLjABAAAAgq8cb7cn9ByhZbmx-XQDdRTvFzmJeBBXOUO4QflP96M",
                "share_weibo_desc": "在抖音，记录美好生活！"
            },
            "shop_micro_app": "",
            "short_id": "0",
            "show_favorite_list": true,
            "signature": "本宝宝暂时还没想到个性签名",
            "signature_language": "un",
            "sync_to_toutiao": 0,
            "tab_settings": {
                "private_tab": {
                    "private_tab_style": 1,
                    "show_private_tab": false
                }
            },
            "total_favorited": 3577047946,
            "twitter_id": "",
            "twitter_name": "",
            "uid": "66598046050",
            "unique_id": "cctvnews",
            "urge_detail": {
                "user_urged": 0
            },
            "verification_type": 1,
            "video_cover": {},
            "video_icon": {
                "uri": "",
                "url_list": []
            },
            "watch_status": false,
            "white_cover_url": [
                {
                    "uri": "318f1000413827e122102",
                    "url_list": [
                        "https://p1-dy-ipv6.byteimg.com/obj/318f1000413827e122102?from=1247829622",
                        "https://p6-dy-ipv6.byteimg.com/obj/318f1000413827e122102?from=1247829622",
                        "https://p29-dy.byteimg.com/obj/318f1000413827e122102?from=1247829622"
                    ]
                }
            ],
            "with_commerce_enterprise_tab_entry": false,
            "with_commerce_entry": true,
            "with_fusion_shop_entry": true,
            "with_new_goods": false,
            "youtube_channel_id": "",
            "youtube_channel_title": ""
        }
    },
    "msg": "success"
}
```


