#  抖音带货商品详情（含店铺信息）


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
| product_id     | int     | 商品的product_id     | 


#  部分返回示例：
```
{
    "code": 200,
    "msg": "成功",
    "data": {
        "st": 0,
        "msg": "",
        "data": {
            "appoint_num": 0,
            "assoc_ids": "",
            "biz_type": 4,
            "buy_record_switch": 0,
            "check_status": 3,
            "company_name": "清河县车品蕙汽车装饰用品店",
            "cos_ratio": 0,
            "current_time": 1609753673,
            "description": "\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/6456cc2d095cc9c35073017dd7201a7f2d092de6www790-725\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/348e907736e2ee57f446239e252817ebad035c68www790-297\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/ed4f2a217b0ffa7abf18c6ac5bc9cbe3a5033b81www790-613\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/6d02c813cf036473b39002beb8a746f972a162d3www790-338\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf6-ttcdn-tos.pstatp.com/obj/temai/a6992bfe1477dfb9635bb4471d15bb16bf8d1cfewww790-624\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/ba3b76395c2221a5b19f52d3ac5d3b922877d2a4www790-324\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf6-ttcdn-tos.pstatp.com/obj/temai/84743e66d27f60a457c8a10781a6243961a753c0www790-623\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf6-ttcdn-tos.pstatp.com/obj/temai/44ce77c2ae1584e0f8dd4c7baa3306d571fa593awww790-328\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/19086b076c9dde1582b181fc8a295bd103555a11www790-604\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf6-ttcdn-tos.pstatp.com/obj/temai/12aa974fbcb3758f984955c1a8483fdb1ad4efd0www790-344\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/1434ff2da4fc7c54f4134d018dad4ef60b15e999www790-623\" style=\"width:100%;\"/\u003e\u003cimg src=\"https://sf1-ttcdn-tos.pstatp.com/obj/temai/64eb85d47cfabb982d44902f1d9216eb495adab9www790-325\" style=\"width:100%;\"/\u003e",
            "discount": 0,
            "discount_price": 3990,
            "dsrInfo": {
                "default": 0,
                "gap_logistics": 0,
                "gap_product": 0,
                "gap_shop": 0,
                "logistics": 0,
                "merchant_id": 0,
                "product": 0,
                "shop": 0
            },
            "end_time": 2145916800,
            "extra": {
                "category_detail": {
                    "first_cid": 20094,
                    "first_cname": "汽车用品/电子/清洗/改装",
                    "fourth_cid": 0,
                    "fourth_cname": "",
                    "is_leaf": true,
                    "second_cid": 21520,
                    "second_cname": "汽车用品/内饰品",
                    "third_cid": 27990,
                    "third_cname": "通用座垫"
                },
                "class_quality": "",
                "quality_report": "",
                "stone": {
                    "remark": ""
                }
            },
            "first_cid": 16,
            "freight": {
                "calculate_type": 2,
                "product_province": 130000,
                "product_province_name": "河北省",
                "rule_type": 0,
                "fixed_amount": 0,
                "columns": [
                    {
                        "add_num": 1,
                        "add_num_price": 3000,
                        "add_weight": 0,
                        "add_weight_price": 0,
                        "first_num": 1,
                        "first_num_price": 2000,
                        "first_weight": 0,
                        "first_weight_price": 0,
                        "is_default": 0,
                        "province": [
                            540000,
                            650000
                        ],
                        "province_name": [
                            "西藏自治区",
                            "新疆维吾尔自治区"
                        ],
                        "rule_id": 3,
                        "is_limited": false,
                        "is_over_free": false,
                        "over_weight": 0,
                        "over_num": 0,
                        "over_amount": 0,
                        "address": {
                            "540000": [],
                            "650000": []
                        }
                    },
                    {
                        "add_num": 0,
                        "add_num_price": 0,
                        "add_weight": 0,
                        "add_weight_price": 0,
                        "first_num": 0,
                        "first_num_price": 0,
                        "first_weight": 0,
                        "first_weight_price": 0,
                        "is_default": 0,
                        "province": [
                            710000,
                            820000,
                            810000
                        ],
                        "province_name": [
                            "台湾省",
                            "澳门特别行政区",
                            "香港特别行政区"
                        ],
                        "rule_id": 2,
                        "is_limited": true,
                        "is_over_free": false,
                        "over_weight": 0,
                        "over_num": 0,
                        "over_amount": 0,
                        "address": {
                            "710000": [],
                            "810000": [],
                            "820000": []
                        }
                    }
                ],
                "default": {
                    "calculate_type": 2,
                    "template_id": 410240,
                    "first_num": 1,
                    "first_num_price": 0,
                    "first_weight": 0,
                    "first_weight_price": 0,
                    "add_num": 1,
                    "add_num_price": 0,
                    "add_weight": 0,
                    "add_weight_price": 0,
                    "is_default": 1,
                    "rule_id": 1,
                    "is_limited": false
                }
            },
            "freight_id": 410240,
            "group_id": "0",
            "img": "https://sf1-ttcdn-tos.pstatp.com/obj/temai/dade8189dc3455b589d439b594337c9796ae7968www800-800",
            "img_list": [
                "https://sf1-ttcdn-tos.pstatp.com/obj/temai/dade8189dc3455b589d439b594337c9796ae7968www800-800",
                "https://sf1-ttcdn-tos.pstatp.com/obj/temai/9c2667b10ea816385ebeed15c222bbeae233f9efwww800-800",
                "https://sf1-ttcdn-tos.pstatp.com/obj/temai/74802ace23beea91345f90ddac05621ae763f70fwww800-800",
                "https://sf6-ttcdn-tos.pstatp.com/obj/temai/c209480f5e9e7787f8987f842b4f9fe4aaa28f13www800-800",
                "https://sf1-ttcdn-tos.pstatp.com/obj/temai/6ff65b6e56b6a793754877efe17e8e31ba55f032www800-800"
            ],
            "img_style_switch": 0,
            "is_alliance": 0,
            "is_pledge_cash": 1,
            "limit_time_desc": "",
            "market_price": 6980,
            "mobile": "18730919293",
            "name": "秋冬季汽车方向盘套 仿羊毛绒把套38cm 保暖通用尺码防滑不",
            "need_code": 0,
            "need_share": 1,
            "out_product_id": "627492879230",
            "pay_type": 1,
            "presell_delay": 0,
            "presell_end_time": 0,
            "presell_type": 0,
            "product_format": {
                "主要表层材质": "羊毛",
                "功能": "其他",
                "图案": "其他",
                "填充物": "其他",
                "座垫风格": "运动",
                "汽车坐垫类型": "其他",
                "组合形式": "其他",
                "表层材质": "羊毛",
                "适用季节": "冬季"
            },
            "product_id": "3435777534069985212",
            "product_type": 0,
            "recommend_remark": "",
            "report_id__for_event": 4365090,
            "saved": 0,
            "second_cid": 124,
            "second_mobile": "",
            "sell_num": "5",
            "shop_id": "hiuivgx",
            "shop_logo": "https://sf6-ttcdn-tos.pstatp.com/obj/temai/15971233562145a310e626021a28942c3d95733cc8b2e31d09",
            "shop_name": "车友道",
            "shop_tel": "18730919293",
            "show_buyers": 1,
            "show_comments": 1,
            "show_place": 0,
            "sku_max_price": 3990,
            "sku_min_price": 3990,
            "spec_id": 140694189,
            "spec_info": [
                {
                    "list": [
                        {
                            "id": "1154597684",
                            "name": "米黄色单个把套"
                        },
                        {
                            "id": "1154597685",
                            "name": "神秘黑单个把套"
                        },
                        {
                            "id": "1154597686",
                            "name": "魅力紫单个把套"
                        },
                        {
                            "id": "1154597687",
                            "name": "白色单个把套"
                        },
                        {
                            "id": "1154597688",
                            "name": "酒红色单个把套"
                        }
                    ],
                    "name": "规格"
                }
            ],
            "status": 0,
            "start_time": 0,
            "supply_status": 0,
            "third_cid": 1075,
            "usp": "",
            "user_limit": 0,
            "v_type": 41,
            "weight": "1.00",
            "need_logistic": true,
            "need_checkout": false,
            "is_educational": false,
            "ins_product": {
                "returnfreight2020v1": 0
            },
            "product_tag": {
                "service_tag": [
                    "freight_insurance",
                    "support_7days_refund",
                    "pay_for_fake",
                    "customer_protection",
                    "shop_qualification",
                    "platform_announcement"
                ],
                "tag_infos": null
            },
            "credit_score": {
                "product": 4.46,
                "logistics": 4.77,
                "shop": 4.98,
                "gap_logistics": 1,
                "gap_product": 2,
                "gap_shop": 1
            },
            "category_id": 27990,
            "biz_kind": 0,
            "ep_extra_info": null,
            "ep_user_info": null
        }
    }
}
```



#  免责声明
    有任何问题可交流学习  
    请勿使用本服务于商用  
    请勿使用本服务大量抓取  
    若因使用本服务与平台造成不必要的纠纷，本人盖不负责  
    本人纯粹技术爱好，若侵犯贵公司的权益，请告知
