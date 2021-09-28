# 抖音Api：视频带货商品列表



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


## 抖音视频带货商品列表Api：

### 请求Api
```http
http://主机地址/douyin/video/promotions?token=xxx&aweme_id=6778721637886872846

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


### 

### 返回示例
```json
{
    "code":200,
    "data":{
        "extra":{
            "fatal_item_ids":[
            ],
            "logid":"2020091422594601012903822921260D19",
            "now":1600095586000
        },
        "log_pb":{
            "impr_id":"2020091422594601012903822921260D19"
        },
        "promotion":"[{"promotion_id":"3425376233108669537","product_id":"3425376233108669537","title":"时来运转简约轻奢金鹿床边客厅门厅地毯120*160","market_price":12000,"price":3880,"detail_url":"https://haohuo.jinritemai.com/views/product/item2?id=3425376233108669537\u0026origin_type=3002001000\u0026origin_id=6869729358253247752_3425376233108669537\u0026alkey=1128_99514375927_6869729358253247752_3425376233108669537_010","sales":29071,"images":[{"uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800","url_list":["http://p1.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800","http://pb3.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800","http://pb3.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800"],"width":720,"height":720},{"uri":"temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800","url_list":["http://p1.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800","http://pb3.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800","http://pb3.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800"],"width":720,"height":720},{"uri":"temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800","url_list":["http://p1.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800","http://pb3.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800","http://pb3.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800"],"width":720,"height":720}],"status":2,"promotion_source":6,"brand_icon":{"uri":"temai/FqHBvTfXMoSfOaR6cjKqR40LOlHlwww84-42","url_list":["https://sf1-ttcdn-tos.pstatp.com/obj/temai/FqHBvTfXMoSfOaR6cjKqR40LOlHlwww84-42"]},"last_aweme_id":"6869729358253247752","medias":[6869729358253247752],"label":null,"elastic_images":[{"uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800","url_list":["http://p1.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg"],"width":720,"height":720},{"uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800","url_list":["http://p1.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg"],"width":720,"height":720},{"uri":"temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800","url_list":["http://p1.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg"],"width":720,"height":720},{"uri":"temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800","url_list":["http://p1.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg","http://pb3.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg"],"width":720,"height":720}],"toutiao":{"coupon_rule":null,"origin_type":"3002001000","origin_id":"6869729358253247752_3425376233108669537","im_url":"https://im.jinritemai.com/douyin_mobile_customer_from_goods/?fromGoods=3425376233108669537\u0026origin_id=6869729358253247752_3425376233108669537\u0026origin_type=3002001000\u0026alkey=1128_99514375927_6869729358253247752_3425376233108669537_010","cart_url":"https://haohuo.jinritemai.com/views/cart/index?status_bar_color=ffffff\u0026loading_bgcolor=ffffff\u0026hide_nav_bar=1\u0026status_font_dark=1","order_url":"https://haohuo.jinritemai.com/views/product/buynow?id=3425376233108669537\u0026product_id=3425376233108669537\u0026origin_type=3002001000\u0026origin_id=6869729358253247752_3425376233108669537\u0026disable_activity=0\u0026group_id=6869729358253247752\u0026alkey=1128_99514375927_6869729358253247752_3425376233108669537_010\u0026status_bar_color=ffffff\u0026loading_bgcolor=ffffff\u0026hide_nav_bar=1\u0026status_font_dark=1","max_price":3880,"min_price":3880,"detail_url":"https://haohuo.jinritemai.com/views/product/item2?id=3425376233108669537\u0026origin_type=3002001000\u0026origin_id=6869729358253247752_3425376233108669537\u0026alkey=1128_99514375927_6869729358253247752_3425376233108669537_010","delivery_delay_text":"下单后7天内发货","virtual_promotion":{"is":false,"already_buy":false},"aggregate_page":null,"full_reduction":{"full_reduction":null,"url":"","coupon":0},"already_buy":false,"need_check":true,"shop_name":""},"visitor":{"avatar":[{"uri":"100x100/30f4d000647038f0f6f11","url_list":["https://p29-dy.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038","https://p9-dy.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038","https://p3-dy-ipv6.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038"]},{"uri":"100x100/90f200187c0715f6887f","url_list":["https://p3-dy-ipv6.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038","https://p6-dy-ipv6.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038","https://p29-dy.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038"]},{"uri":"100x100/2e0a800025fc74ab85d5f","url_list":["https://p3-dy-ipv6.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038","https://p26-dy.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038","https://p29-dy.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038"]},{"uri":"100x100/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e","url_list":["https://p6-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038","https://p3-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038","https://p9-dy.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038"]},{"uri":"100x100/2f78b0001920bf0c9c54f","url_list":["https://p29-dy.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038","https://p6-dy-ipv6.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038","https://p9-dy.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038"]}],"count":563084},"has_gyl":true,"user_shop_categories":null,"marketing_floors":null,"cos_fee":0,"favorited":false,"consumer_comment":null,"meta_param":"%7B%22page_type%22%3A0%7D","price_tag":"","module_control":{"store_card":{"visible":false},"store_icon":{"visible":false},"want":{"visible":true},"comment":{"visible":true},"order_share":{"visible":true}},"goods_source":"来自小店","pic_audit_status":null,"jump_to_url":false,"shop_icons":null}]",
        "promotions":[
            {
                "brand_icon":{
                    "uri":"temai/FqHBvTfXMoSfOaR6cjKqR40LOlHlwww84-42",
                    "url_list":[
                        "https://sf1-ttcdn-tos.pstatp.com/obj/temai/FqHBvTfXMoSfOaR6cjKqR40LOlHlwww84-42"
                    ]
                },
                "consumer_comment":null,
                "cos_fee":0,
                "detail_url":"https://haohuo.jinritemai.com/views/product/item2?id=3425376233108669537&origin_type=3002001000&origin_id=6869729358253247752_3425376233108669537&alkey=1128_99514375927_6869729358253247752_3425376233108669537_010",
                "elastic_images":[
                    {
                        "height":720,
                        "uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg"
                        ],
                        "width":720
                    },
                    {
                        "height":720,
                        "uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800.jpeg"
                        ],
                        "width":720
                    },
                    {
                        "height":720,
                        "uri":"temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800.jpeg"
                        ],
                        "width":720
                    },
                    {
                        "height":720,
                        "uri":"temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg",
                            "http://pb3.pstatp.com/aweme/720x720/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800.jpeg"
                        ],
                        "width":720
                    }
                ],
                "favorited":false,
                "goods_source":"来自小店",
                "has_gyl":true,
                "images":[
                    {
                        "height":720,
                        "uri":"temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FoDNKXbh0haE0JlluARQVvW1el9pwww800-800"
                        ],
                        "width":720
                    },
                    {
                        "height":720,
                        "uri":"temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FqyvfYYjlJkkVDh8zqUduTf5TUoIwww800-800"
                        ],
                        "width":720
                    },
                    {
                        "height":720,
                        "uri":"temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800",
                        "url_list":[
                            "http://p1.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800",
                            "http://pb3.pstatp.com/obj/temai/FjkRnTIpeCXdcSmiYk-LCCb3DnEZwww800-800"
                        ],
                        "width":720
                    }
                ],
                "jump_to_url":false,
                "label":null,
                "last_aweme_id":"6869729358253247752",
                "market_price":12000,
                "marketing_floors":null,
                "medias":[
                    6869729358253247000
                ],
                "meta_param":"%7B%22page_type%22%3A0%7D",
                "module_control":{
                    "comment":{
                        "visible":true
                    },
                    "order_share":{
                        "visible":true
                    },
                    "store_card":{
                        "visible":false
                    },
                    "store_icon":{
                        "visible":false
                    },
                    "want":{
                        "visible":true
                    }
                },
                "pic_audit_status":null,
                "price":3880,
                "price_tag":"",
                "product_id":"3425376233108669537",
                "promotion_id":"3425376233108669537",
                "promotion_source":6,
                "sales":29071,
                "shop_icons":null,
                "status":2,
                "title":"时来运转简约轻奢金鹿床边客厅门厅地毯120*160",
                "toutiao":{
                    "aggregate_page":null,
                    "already_buy":false,
                    "cart_url":"https://haohuo.jinritemai.com/views/cart/index?status_bar_color=ffffff&loading_bgcolor=ffffff&hide_nav_bar=1&status_font_dark=1",
                    "coupon_rule":null,
                    "delivery_delay_text":"下单后7天内发货",
                    "detail_url":"https://haohuo.jinritemai.com/views/product/item2?id=3425376233108669537&origin_type=3002001000&origin_id=6869729358253247752_3425376233108669537&alkey=1128_99514375927_6869729358253247752_3425376233108669537_010",
                    "full_reduction":{
                        "coupon":0,
                        "full_reduction":null,
                        "url":""
                    },
                    "im_url":"https://im.jinritemai.com/douyin_mobile_customer_from_goods/?fromGoods=3425376233108669537&origin_id=6869729358253247752_3425376233108669537&origin_type=3002001000&alkey=1128_99514375927_6869729358253247752_3425376233108669537_010",
                    "max_price":3880,
                    "min_price":3880,
                    "need_check":true,
                    "order_url":"https://haohuo.jinritemai.com/views/product/buynow?id=3425376233108669537&product_id=3425376233108669537&origin_type=3002001000&origin_id=6869729358253247752_3425376233108669537&disable_activity=0&group_id=6869729358253247752&alkey=1128_99514375927_6869729358253247752_3425376233108669537_010&status_bar_color=ffffff&loading_bgcolor=ffffff&hide_nav_bar=1&status_font_dark=1",
                    "origin_id":"6869729358253247752_3425376233108669537",
                    "origin_type":"3002001000",
                    "shop_name":"",
                    "virtual_promotion":{
                        "already_buy":false,
                        "is":false
                    }
                },
                "user_shop_categories":null,
                "visitor":{
                    "avatar":[
                        {
                            "uri":"100x100/30f4d000647038f0f6f11",
                            "url_list":[
                                "https://p29-dy.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038",
                                "https://p9-dy.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038",
                                "https://p3-dy-ipv6.byteimg.com/aweme/100x100/30f4d000647038f0f6f11.jpeg?from=4010531038"
                            ]
                        },
                        {
                            "uri":"100x100/90f200187c0715f6887f",
                            "url_list":[
                                "https://p3-dy-ipv6.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038",
                                "https://p6-dy-ipv6.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038",
                                "https://p29-dy.byteimg.com/aweme/100x100/90f200187c0715f6887f.jpeg?from=4010531038"
                            ]
                        },
                        {
                            "uri":"100x100/2e0a800025fc74ab85d5f",
                            "url_list":[
                                "https://p3-dy-ipv6.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038",
                                "https://p26-dy.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038",
                                "https://p29-dy.byteimg.com/aweme/100x100/2e0a800025fc74ab85d5f.jpeg?from=4010531038"
                            ]
                        },
                        {
                            "uri":"100x100/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e",
                            "url_list":[
                                "https://p6-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038",
                                "https://p3-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038",
                                "https://p9-dy.byteimg.com/img/tos-cn-avt-0015/3d2de81eb05156ecfa6cad8fc98a5f0e~c5_100x100.jpeg?from=4010531038"
                            ]
                        },
                        {
                            "uri":"100x100/2f78b0001920bf0c9c54f",
                            "url_list":[
                                "https://p29-dy.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038",
                                "https://p6-dy-ipv6.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038",
                                "https://p9-dy.byteimg.com/aweme/100x100/2f78b0001920bf0c9c54f.jpeg?from=4010531038"
                            ]
                        }
                    ],
                    "count":563084
                }
            }
        ],
        "status_code":0
    },
    "msg":"success"
}
```


