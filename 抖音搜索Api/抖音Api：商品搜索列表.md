# 抖音Api：商品搜索列表

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




## 抖音商品搜索列表Api：

### 请求Api
```http
http://主机地址/douyin/search/goods?token=xxx&keyword=热巴&cursor=20

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
            "logid":"20200914214538010144061078301C11FC",
            "now":1600091139000
        },
        "goods":[
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
                "goods_info":{
                    "commodity_type":9,
                    "gid":"3373777775797344526",
                    "h5_url":"https://m-goods.kaola.com/product/5755274.html",
                    "img":"https://sf1-ttcdn-tos.pstatp.com/obj/temai-bw/1b4fb86c71f4c244babac62a8c019af3ec14b53fwww800-800",
                    "name":"Adidas阿迪达斯女羽绒服迪丽热巴同款冬季CS PUFFER运动保暖连帽羽绒服EI4421",
                    "platform_name":"考拉海购",
                    "schema":"aweme://goods/seeding/?promotion_id=3373777775797344526&target_uid=99514375927&sec_target_uid=MS4wLjABAAAA2I9NdgAKZrz9e0tLm1csyDMNqLESPDm34TdYYqXe8-I&item_id=0&product_id=5755274&meta_param=%7B%22page_type%22%3A1%7D",
                    "schema_type":2,
                    "show_price":58900
                },
                "position":[
                    {
                        "begin":16,
                        "end":17
                    }
                ]
            }
        ],
        "has_more":true,
        "log_pb":{
            "impr_id":"20200914214538010144061078301C11FC"
        },
        "status_code":0
    },
    "msg":"success"
}
```


