# 抖音Api：地点搜索列表

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


## 抖音地点搜索列表Api：

### 请求Api
```http
http://主机地址/douyin/search/poi?token=xxx&keyword=热巴&cursor=20

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
        "cursor":20,
        "extra":{
            "fatal_item_ids":[
            ],
            "logid":"20200914214458010028037029131C0EEF",
            "now":1600091098000,
            "search_request_id":""
        },
        "has_more":1,
        "log_pb":{
            "impr_id":"20200914214458010028037029131C0EEF"
        },
        "poi_info_list":[
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
                "position_info":null,
                "simple_poi_info":{
                    "address_info":{
                        "city":"那曲市",
                        "city_code":"540600",
                        "district":"班戈县",
                        "province":"西藏自治区",
                        "simple_addr":"班戈县"
                    },
                    "business_area_name":"班戈县",
                    "geohash":"tvxcvj15fwp8",
                    "icon_service_type_list":[
                    ],
                    "is_admin_area":false,
                    "latitude":31.273259,
                    "longitude":89.869655,
                    "option_name":"山",
                    "poi_backend_type":{
                        "code":"180311",
                        "desc":"{"month_update_flag": 1, "score_show_flag": 1, "can_set_poi_accidental_injury": 1, "icon_id": 8, "address_show_flag": 1, "is_in_whitelist": 1, "category_show_flag": 1, "opentime_show_flag": 1, "subtype_show_flag": 1, "price_show_flag": 1, "phone_show_flag": 1}",
                        "name":"游玩;自然景观;山"
                    },
                    "poi_id":"6601220308181469188",
                    "poi_name":"热巴",
                    "poi_rank_desc":"",
                    "poi_voucher":"",
                    "voucher_release_areas":[
                    ]
                }
            }
        ],
        "qc":"",
        "status_code":0
    },
    "msg":"success"
}
```


