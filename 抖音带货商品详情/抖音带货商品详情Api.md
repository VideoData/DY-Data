#  带货商品详情


#  请求Api：
```java
http://主机地址/dy/***/?token=xxx&pid=67431981995834577
```
#  请求方式：
```java
Get
```

#  参数 
| 参数名      | 类型     | 说明     |
| ---------- | :-----------:  | :-----------: |
| token     | string     | 接口授权码     |
| promotion_id     | int     | 商品的promotion_id     | 


#  部分返回示例：
```
{
    "code": 200,
    "msg": "成功",
    "data": {
        "extra": {
            "fatal_item_ids": [],
            "logid": "20210105160821010198066200180061B2",
            "now": 1609834102000
        },
        "log_pb": {
            "impr_id": "20210105160821010198066200180061B2"
        },
        "page_style": {
            "comment_page_tag_max": 0,
            "confirm_order_short_url": null,
            "confirm_order_style": 1,
            "detail_page_stats_show": true,
            "detail_page_tag_max": 3,
            "detail_page_tag_show": false
        },
        "promotions": [
            {
                "base_info": {
                    "images": [
                        {
                            "height": 720,
                            "uri": "temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750",
                            "url_list": [
                                "http:\/\/p3.pstatp.com\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750~tplv-obj.webp",
                                "http:\/\/pb9.pstatp.com\/obj\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750",
                                "http:\/\/pb3.pstatp.com\/obj\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750"
                            ],
                            "width": 720
                        },
                        {
                            "height": 720,
                            "uri": "temai\/12f9ceea89422a803435f634911abdfcwww760-760",
                            "url_list": [
                                "http:\/\/p3.pstatp.com\/temai\/12f9ceea89422a803435f634911abdfcwww760-760~tplv-obj.webp",
                                "http:\/\/pb9.pstatp.com\/obj\/temai\/12f9ceea89422a803435f634911abdfcwww760-760",
                                "http:\/\/pb3.pstatp.com\/obj\/temai\/12f9ceea89422a803435f634911abdfcwww760-760"
                            ],
                            "width": 720
                        }
                    ],
                    "links": {
                        "h5_url": "https:\/\/haohuo.jinritemai.com\/views\/product\/buynow?id=3452801395571437104&product_id=3452801395571437104&origin_type=2002170010&origin_id=99514375927_3452832680012608946&disable_activity=0&group_id=0&alkey=1128_99514375927_0_3452832680012608946_011&new_source_type=product_detail&status_bar_color=ffffff&loading_bgcolor=ffffff&hide_nav_bar=1&status_font_dark=1&trans_status_bar=0&buyin_track=COgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC&c_biz_combo=2&author_id=99514375927&combo_id=1403741102&combo_num=1",
                        "small_app_url": "sslocal:\/\/microapp?version=v2&app_id=tt7cca0a77e3e0cd15&scene=027001&version_type=current&start_page=pages%2Fproduct-pay%2Fproduct-pay%3Falkey%3D1128_99514375927_0_3452832680012608946_011%26buyin_track%3DCOgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC%26c_biz_combo%3D2%26combo_id%3D1403741102%26combo_num%3D1%26disable_activity%3D0%26new_source_type%3Dproduct_detail%26origin_id%3D99514375927_3452832680012608946%26origin_type%3D2002170010%26product_id%3D3452801395571437104&bdp_log=%7B%22launch_from%22%3A%22full_screen_card%22%2C%22location%22%3A%22click_product%22%7D&bdpsum=65b0219"
                    },
                    "presell_type": 0,
                    "price": {
                        "market_price": 2990,
                        "min_price": 990
                    },
                    "product_id": "3452801395571437104",
                    "promotion_id": "3452832680012608946",
                    "promotion_source": 4,
                    "promotion_source_text": "商品来自小店",
                    "sales": 251,
                    "sold_out": false,
                    "status": 2,
                    "title": "【36个】红包婚庆喜庆结婚新年创意镂空红包"
                },
                "comment_info": {
                    "comments": [
                        {
                            "app_id": 1128,
                            "comment_time": "2020-12-23 10:28:54",
                            "content": "已经处理了，态度还不错👍，下回一定记得发",
                            "id": 353624168,
                            "liked": false,
                            "likes": 0,
                            "parent_id": 0,
                            "product_id": 0,
                            "rank": 15,
                            "rank_logistic": 5,
                            "rank_product": 5,
                            "rank_shop": 5,
                            "recommend": false,
                            "shop_reply": "",
                            "sku": "36个（6组装）",
                            "user_avatar": {
                                "uri": "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059",
                                "url_list": [
                                    "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059"
                                ]
                            },
                            "user_id": 93902675240,
                            "user_name": "⚡**⚡",
                            "user_type": 12
                        },
                        {
                            "app_id": 1128,
                            "comment_time": "2021-01-03 14:24:31",
                            "content": "此用户未填写评价内容",
                            "id": 372843905,
                            "liked": false,
                            "likes": 0,
                            "parent_id": 0,
                            "product_id": 0,
                            "rank": 15,
                            "rank_logistic": 5,
                            "rank_product": 5,
                            "rank_shop": 5,
                            "recommend": false,
                            "shop_reply": "",
                            "sku": "36个（6组装）",
                            "user_avatar": {
                                "uri": "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059",
                                "url_list": [
                                    "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059"
                                ]
                            },
                            "user_id": 75040134697,
                            "user_name": "我**为",
                            "user_type": 12
                        },
                        {
                            "app_id": 1128,
                            "comment_time": "2020-12-28 08:01:54",
                            "content": "此用户未填写评价内容",
                            "id": 359444620,
                            "liked": false,
                            "likes": 0,
                            "parent_id": 0,
                            "product_id": 0,
                            "rank": 15,
                            "rank_logistic": 5,
                            "rank_product": 5,
                            "rank_shop": 5,
                            "recommend": false,
                            "shop_reply": "",
                            "sku": "36个（6组装）",
                            "user_avatar": {
                                "uri": "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059",
                                "url_list": [
                                    "http:\/\/p0.pstatp.com\/origin\/3791\/5035712059"
                                ]
                            },
                            "user_id": 3900661233362439,
                            "user_name": "小**平",
                            "user_type": 12
                        }
                    ],
                    "good_ratio": "0",
                    "stats": [
                        {
                            "caption": "全部",
                            "count": 5,
                            "id": 1,
                            "title": "全部 5"
                        },
                        {
                            "caption": "有图",
                            "count": 1,
                            "id": 2,
                            "title": "有图 1"
                        },
                        {
                            "caption": "好评",
                            "count": 4,
                            "id": 3,
                            "title": "好评 4"
                        },
                        {
                            "caption": "差评",
                            "count": 1,
                            "id": 6,
                            "title": "差评 1"
                        }
                    ],
                    "total_count": 5
                },
                "detail_info": {
                    "detail_imgs": [
                        {
                            "height": 750,
                            "uri": "temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750",
                            "url_list": [
                                "http:\/\/p3.pstatp.com\/obj\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750",
                                "http:\/\/pb9.pstatp.com\/obj\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750",
                                "http:\/\/pb3.pstatp.com\/obj\/temai\/bed5e19dd3fc4a7d65a393de01c1d41awww750-750"
                            ],
                            "width": 750
                        },
                        {
                            "height": 760,
                            "uri": "temai\/12f9ceea89422a803435f634911abdfcwww760-760",
                            "url_list": [
                                "http:\/\/p3.pstatp.com\/obj\/temai\/12f9ceea89422a803435f634911abdfcwww760-760",
                                "http:\/\/pb9.pstatp.com\/obj\/temai\/12f9ceea89422a803435f634911abdfcwww760-760",
                                "http:\/\/pb3.pstatp.com\/obj\/temai\/12f9ceea89422a803435f634911abdfcwww760-760"
                            ],
                            "width": 760
                        }
                    ]
                },
                "extra_info": {
                    "addition_modules_data": [],
                    "alliance_key": "1128_99514375927_0_3452832680012608946_011",
                    "already_buy": false,
                    "buy_button": {
                        "links": {
                            "h5_url": "https:\/\/haohuo.jinritemai.com\/views\/product\/buynow?id=3452801395571437104&product_id=3452801395571437104&origin_type=2002170010&origin_id=99514375927_3452832680012608946&disable_activity=0&group_id=0&alkey=1128_99514375927_0_3452832680012608946_011&new_source_type=product_detail&status_bar_color=ffffff&loading_bgcolor=ffffff&hide_nav_bar=1&status_font_dark=1&trans_status_bar=0&buyin_track=COgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC&c_biz_combo=2&author_id=99514375927&combo_id=1403741102&combo_num=1",
                            "small_app_url": "sslocal:\/\/microapp?version=v2&app_id=tt7cca0a77e3e0cd15&scene=027001&version_type=current&start_page=pages%2Fproduct-pay%2Fproduct-pay%3Falkey%3D1128_99514375927_0_3452832680012608946_011%26buyin_track%3DCOgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC%26c_biz_combo%3D2%26combo_id%3D1403741102%26combo_num%3D1%26disable_activity%3D0%26new_source_type%3Dproduct_detail%26origin_id%3D99514375927_3452832680012608946%26origin_type%3D2002170010%26product_id%3D3452801395571437104&bdp_log=%7B%22launch_from%22%3A%22full_screen_card%22%2C%22location%22%3A%22click_product%22%7D&bdpsum=65b0219"
                        },
                        "order_status": 1,
                        "text": "立即购买"
                    },
                    "cart_url": "https:\/\/haohuo.jinritemai.com\/views\/cart\/index?status_bar_color=ffffff&loading_bgcolor=ffffff&hide_nav_bar=1&status_font_dark=1&new_source_type=product_detail",
                    "detail_url": "https:\/\/haohuo.jinritemai.com\/views\/product\/item2?id=3452801395571437104&origin_type=2002170010&origin_id=99514375927_3452832680012608946&alkey=1128_99514375927_0_3452832680012608946_011&sec_author_id=MS4wLjABAAAA2I9NdgAKZrz9e0tLm1csyDMNqLESPDm34TdYYqXe8-I&buyin_track=COgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC&c_biz_combo=2",
                    "favorited": false,
                    "im_url": "https:\/\/im.jinritemai.com\/douyin_mobile_customer_from_goods\/?fromGoods=3452801395571437104&origin_id=99514375927_3452832680012608946&origin_type=2002170010&alkey=1128_99514375927_0_3452832680012608946_011&buyin_track=COgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC&c_biz_combo=2&promotion_id=3452832680012608946&item_id=0&author_id=99514375927&request_additions=%7B%22enter_from%22%3A%22live%22%2C%22sec_author_id%22%3A%22MS4wLjABAAAA2I9NdgAKZrz9e0tLm1csyDMNqLESPDm34TdYYqXe8-I%22%7D",
                    "is_virtual_product": false,
                    "need_check": false,
                    "origin_id": "99514375927_3452832680012608946",
                    "origin_type": "2002170010",
                    "pay_type": 1,
                    "shop_id": "3433133",
                    "track_extra": "{\"buyin_track\":\"COgIEPe9k9zyAhoECAAQACIAKLDciLi1krT1LzAC\",\"c_biz_combo\":\"2\"}",
                    "visitor_count": 3714
                },
                "hotsoon": {
                    "shop_entry": []
                },
                "page_coms_config": {
                    "display_gyl": true,
                    "display_want": true,
                    "set_cart_gray": false,
                    "shopping_cart": true,
                    "store_icon": false
                },
                "privilege_info": {
                    "activities": [],
                    "coupons": [],
                    "logistics": {
                        "delivery_delay_desc": "7天内发货",
                        "post_fee": 300,
                        "post_fee_text": "运费3元起",
                        "send_from": "7天内浙江省发货"
                    },
                    "services": [
                        {
                            "content": "支付后6小时内，待发货状态下，提交退款申请将立即退款",
                            "icon": "https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/eden-cn\/nupfupebo\/services\/QuickRefund.png",
                            "service_type": 5,
                            "small_icon": "http:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/ttfe\/obj\/ttfe\/alliance\/detail_support_3x.png",
                            "title": "极速退款"
                        },
                        {
                            "content": "在签收商品之日起7天内，符合完好标准的商品，可申请无理由退货",
                            "icon": "http:\/\/sf3-ttcdn-tos.pstatp.com\/obj\/temai\/full_return.png",
                            "service_type": 6,
                            "small_icon": "http:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/ttfe\/obj\/ttfe\/alliance\/detail_support_3x.png",
                            "title": "7天无理由退货"
                        },
                        {
                            "content": "联系平台客服举证，若假货举证属实则全额退款，并赔付三倍货款",
                            "icon": "http:\/\/sf3-ttcdn-tos.pstatp.com\/obj\/temai\/punishment.png",
                            "service_type": 7,
                            "small_icon": "http:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/ttfe\/obj\/ttfe\/alliance\/detail_support_3x.png",
                            "title": "假一赔三"
                        },
                        {
                            "content": "卖家已缴纳保证金，如有商品质量问题、描述不符等，您有权申请退款或退货",
                            "icon": "http:\/\/sf3-ttcdn-tos.pstatp.com\/obj\/temai\/comsumer_protect.png",
                            "service_type": 8,
                            "small_icon": "http:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/ttfe\/obj\/ttfe\/alliance\/detail_support_3x.png",
                            "title": "消费者保障服务"
                        },
                        {
                            "content": "查看商家详细资质信息",
                            "icon": "http:\/\/sf3-ttcdn-tos.pstatp.com\/obj\/temai\/shop_certification.png",
                            "service_type": 9,
                            "small_icon": "http:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/ttfe\/obj\/ttfe\/alliance\/detail_support_3x.png",
                            "title": "商家资质",
                            "url": "https:\/\/haohuo.jinritemai.com\/views\/shop\/multipleLicenses?id=ejGyeIZ"
                        },
                        {
                            "content": "点击查看平台公示专区",
                            "service_type": 10,
                            "tag": "public_zone",
                            "title": "",
                            "url": "https:\/\/bolt.jinritemai.com\/api\/h5\/activity\/3445385474695895474?d=1"
                        }
                    ]
                }
            }
        ],
        "status_code": 0
    }
}
```
