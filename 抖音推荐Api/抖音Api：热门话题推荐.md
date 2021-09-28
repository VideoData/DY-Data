# 抖音Api：热门话题推荐

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


## 抖音Api：热门话题推荐

### 请求Api
```http
http://主机地址/douyin/feed/funnytags?token=xxx

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


### 

### 返回示例
```json


{
    "code":200,
    "data":{
        "category_list":[
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
                "challenge_info":{
                    "author":{
                        "ad_cover_url":null,
                        "can_set_geofencing":null,
                        "cha_list":null,
                        "cover_url":null,
                        "followers_detail":null,
                        "geofencing":null,
                        "homepage_bottom_toast":null,
                        "item_list":null,
                        "need_points":null,
                        "new_story_cover":null,
                        "platform_sync_info":null,
                        "relative_users":null,
                        "type_label":null,
                        "user_tags":null,
                        "white_cover_url":null
                    },
                    "banner_list":null,
                    "category_cover_info":{
                        "aweme_id":"6872304402133257487",
                        "cover":{
                            "uri":"tos-cn-p-0015/367b488536a54648a8ca71f62276b47d",
                            "url_list":[
                                "https://p26-dy.byteimg.com/img/tos-cn-p-0015/367b488536a54648a8ca71f62276b47d~noop.jpeg?from=2563711402_large",
                                "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/367b488536a54648a8ca71f62276b47d~noop.jpeg?from=2563711402_large",
                                "https://p9-dy.byteimg.com/img/tos-cn-p-0015/367b488536a54648a8ca71f62276b47d~noop.jpeg?from=2563711402_large"
                            ]
                        },
                        "dynamic_cover":{
                            "uri":"tos-cn-p-0015/411a0c5cbf214163a88669531923b1bd_1600083062",
                            "url_list":[
                                "https://p3-dy-ipv6.byteimg.com/obj/tos-cn-p-0015/411a0c5cbf214163a88669531923b1bd_1600083062?from=2563711402_large",
                                "https://p6-dy-ipv6.byteimg.com/obj/tos-cn-p-0015/411a0c5cbf214163a88669531923b1bd_1600083062?from=2563711402_large",
                                "https://p29-dy.byteimg.com/obj/tos-cn-p-0015/411a0c5cbf214163a88669531923b1bd_1600083062?from=2563711402_large"
                            ]
                        }
                    },
                    "cha_attrs":null,
                    "cha_name":"罔1云歌名起风了",
                    "cid":"1674728436234252",
                    "collect_stat":0,
                    "connect_music":[
                    ],
                    "desc":"",
                    "extra_attr":{
                        "is_live":false
                    },
                    "hashtag_profile":"tos-cn-p-0015/261b04c24ba24d02afc39b762a5567e5",
                    "is_challenge":0,
                    "is_commerce":false,
                    "is_pgcshow":false,
                    "schema":"aweme://aweme/challenge/detail?cid=1674728436234252",
                    "share_info":{
                        "bool_persist":0,
                        "share_desc":"在抖音，记录美好生活",
                        "share_desc_info":"我在抖音参加#罔1云歌名起风了 ",
                        "share_quote":"",
                        "share_signature_desc":"",
                        "share_signature_url":"",
                        "share_title":"我在抖音参加#罔1云歌名起风了 ",
                        "share_title_myself":"",
                        "share_title_other":"",
                        "share_url":"https://www.iesdouyin.com/share/challenge/1674728436234252/?u_code=0",
                        "share_weibo_desc":"我在抖音参加#罔1云歌名起风了 "
                    },
                    "show_items":null,
                    "sub_type":0,
                    "type":1,
                    "user_count":0,
                    "view_count":0
                }
            }
        ],
        "cursor":10,
        "extra":{
            "fatal_item_ids":[
            ],
            "logid":"20200914234019010144040206382C40F3",
            "now":1600098019000
        },
        "has_more":1,
        "log_pb":{
            "impr_id":"20200914234019010144040206382C40F3"
        },
        "status_code":0
    },
    "msg":"success"
}
```


