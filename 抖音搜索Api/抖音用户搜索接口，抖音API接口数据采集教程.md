# 抖音用户搜索接口，抖音API接口数据采集教程



我这里使用模拟器抓的包，params里面有设备信息：device_type、device_brand、device_platform、device_id
DEVICEID可唯一标识一个存储设备，搜索接口基于该参数做有一定的请求限制。
（我贴出来的参数中 设备id是假的，需要更换为自己的）


Post表单参数：
```
data = {
        'cursor': 0,	
        'keyword':'鞠婧祎',
        'count': 20,
        'hot_search': 0,
        'is_pull_refresh': 1,
        'search_source': 'challenge',
        'search_id':None,
        'query_correct_type': 1
        }
```
headers参数：
xgorgon是请求所需的加密参数、xtttoken在搜索接口用于用户身份的标示。


```
ts = str(time.time()).split(".")[0]
_rticket = str(time.time() * 1000).split(".")[0]
headers={
        "X-Gorgon":xgorgon,
        "X-Khronos": ts,
        "sdk-version":"1",
        "Accept-Encoding": "gzip",
        "X-SS-REQ-TICKET": _rticket,
        "Host": "aweme.snssdk.com",
        "Connection": "Keep-Alive",
        'User-Agent': 'okhttp/3.10.0.1',
        "x-tt-token":xtttoken
      } 
```
经过测试，搜索接口的 xgorgon 一个大概可以用2分钟。1秒请求1次，请求130条数据需要重新获取xgorgon。
当然也可以每次请求都重新生成xgorgon。
每个账号每天请求搜索接口有次数限制，大概在300左右。
超过限制需要更换账号，另外params也要改变。





## 抖音用户搜索列表Api：

### 请求Api
```http
http://主机地址/douyin/search/users?token=xxx&keyword=热巴&cursor=0
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
| keyword | string | 搜索关键词 |
| cursor | int | 翻页游标，根据结果返回的cursor传入作为下一页翻页参数，初始为0 |

### 

### 返回示例
```json
{
    "code":200,
    "data":{
        "challenge_list":null,
        "cursor":20,
        "extra":{
            "fatal_item_ids":[
            ],
            "logid":"202009142125500100290281622318FBCD",
            "now":1600089951000,
            "search_request_id":""
        },
        "has_more":1,
        "input_keyword":"热巴",
        "log_pb":{
            "impr_id":"202009142125500100290281622318FBCD"
        },
        "music_list":null,
        "myself_user_id":"0",
        "qc":"",
        "rid":"202009142125500100290281622318FBCD",
        "status_code":0,
        "type":1,
        "user_list":[
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
                "challenges":null,
                "effects":null,
                "items":null,
                "mix_list":null,
                "musics":null,
                "position":null,
                "uniqid_position":null,
                "user_info":{
                    "accept_private_policy":false,
                    "account_region":"",
                    "ad_cover_url":null,
                    "apple_account":0,
                    "authority_status":0,
                    "avatar_168x168":{
                        "height":720,
                        "uri":"168x168/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                        "url_list":[
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_168x168.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_168x168.webp?from=2956013662",
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_168x168.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_168x168.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_300x300":{
                        "height":720,
                        "uri":"300x300/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                        "url_list":[
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_300x300.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_300x300.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_300x300.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_300x300.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_larger":{
                        "height":720,
                        "uri":"1080x1080/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                        "url_list":[
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_1080x1080.webp?from=2956013662",
                            "https://p1-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_1080x1080.webp?from=2956013662",
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_1080x1080.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_1080x1080.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_medium":{
                        "height":720,
                        "uri":"720x720/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                        "url_list":[
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_720x720.webp?from=2956013662",
                            "https://p29-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_720x720.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_720x720.webp?from=2956013662",
                            "https://p6-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_720x720.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_thumb":{
                        "height":720,
                        "uri":"100x100/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                        "url_list":[
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_100x100.webp?from=2956013662",
                            "https://p26-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_100x100.webp?from=2956013662",
                            "https://p9-dy.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_100x100.webp?from=2956013662",
                            "https://p3-dy-ipv6.byteimg.com/img/tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df~c5_100x100.jpeg?from=2956013662"
                        ],
                        "width":720
                    },
                    "avatar_uri":"tos-cn-i-0813/7623b49a46dd44cba2d062c031d8b7df",
                    "aweme_count":0,
                    "bind_phone":"",
                    "birthday":"2000-01-01",
                    "can_set_geofencing":null,
                    "cha_list":null,
                    "comment_filter_status":0,
                    "comment_setting":0,
                    "commerce_user_level":0,
                    "constellation":9,
                    "cover_url":[
                        {
                            "height":720,
                            "uri":"c8510002be9a3a61aad2",
                            "url_list":[
                                "https://p3-dy-ipv6.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662",
                                "https://p29-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662",
                                "https://p9-dy.byteimg.com/obj/c8510002be9a3a61aad2?from=2956013662"
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
                    "favoriting_count":214,
                    "fb_expire_time":0,
                    "follow_status":0,
                    "follower_count":6800,
                    "follower_status":0,
                    "followers_detail":null,
                    "following_count":4,
                    "gender":2,
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
                    "nickname":"热巴",
                    "original_musician":{
                        "digg_count":0,
                        "music_count":0,
                        "music_used_count":0
                    },
                    "platform_sync_info":null,
                    "prevent_download":false,
                    "react_setting":0,
                    "reflow_page_gid":0,
                    "reflow_page_uid":0,
                    "region":"CN",
                    "relative_users":null,
                    "room_id":0,
                    "room_id_str":"0",
                    "school_name":"",
                    "school_poi_id":"",
                    "school_type":0,
                    "sec_uid":"MS4wLjABAAAA8vLHIRsiLyt-0m06Dvz0KuqkK3CfRSz2rytmFwrR39I",
                    "secret":0,
                    "share_info":{
                        "share_desc":"",
                        "share_desc_info":"",
                        "share_qrcode_url":{
                            "height":720,
                            "uri":"8d740001ca53dfac4162",
                            "url_list":[
                                "https://p6-dy-ipv6.byteimg.com/obj/8d740001ca53dfac4162?from=2956013662",
                                "https://p3-dy-ipv6.byteimg.com/obj/8d740001ca53dfac4162?from=2956013662",
                                "https://p9-dy.byteimg.com/obj/8d740001ca53dfac4162?from=2956013662"
                            ],
                            "width":720
                        },
                        "share_title":"",
                        "share_title_myself":"",
                        "share_title_other":"",
                        "share_url":"",
                        "share_weibo_desc":""
                    },
                    "share_qrcode_uri":"8d740001ca53dfac4162",
                    "shield_comment_notice":0,
                    "shield_digg_notice":0,
                    "shield_follow_notice":0,
                    "short_id":"1037063419",
                    "show_image_bubble":false,
                    "signature":"爱自己♥",
                    "special_lock":1,
                    "status":1,
                    "stitch_setting":0,
                    "story_count":0,
                    "story_open":false,
                    "sync_to_toutiao":0,
                    "total_favorited":17330,
                    "tw_expire_time":0,
                    "twitter_id":"",
                    "twitter_name":"",
                    "type_label":null,
                    "uid":"98803352045",
                    "unique_id":"daba1314",
                    "unique_id_modify_time":1600089951,
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
                    "youtube_channel_id":"",
                    "youtube_channel_title":""
                }
            }
        ]
    },
    "msg":"success"
}
```


