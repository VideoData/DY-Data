# 抖音商城新品接口，抖音API接口数据采集教程



## 抖音商城新品接口

### 请求Api
```http
http://主机地址/douyin/commerce/seckill_live?token=xxx&cursor=0

```


### 请求方式
```http
GET
```

### 

### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| cursor | int | 翻页游标，初始为1，第二页则传2，以此类推 |
 

### 返回示例
```json
{
	"code": 200,
	"msg": "成功",
	"data": {
		"status_code": 0,
		"good_product_seckill": {
			"lives": [
				{
					"live_card": {
						"room_id": "6977900708301474594",
						"cover": {
							"uri": "webcast\/6975492172162665250",
							"url_list": [
								"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/6975492172162665250~tplv-resize:400:400.image",
								"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/6975492172162665250~tplv-resize:400:400.image",
								"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/6975492172162665250~tplv-resize:400:400.image"
							],
							"width": 400,
							"height": 400
						},
						"title": "300万粉丝在线观看",
						"avatar": {
							"uri": "100x100\/2ce1900038edc36efcacb",
							"url_list": [
								"https:\/\/p29.douyinpic.com\/aweme\/100x100\/2ce1900038edc36efcacb.jpeg?from=4010531038",
								"https:\/\/p6.douyinpic.com\/aweme\/100x100\/2ce1900038edc36efcacb.jpeg?from=4010531038",
								"https:\/\/p3.douyinpic.com\/aweme\/100x100\/2ce1900038edc36efcacb.jpeg?from=4010531038"
							]
						},
						"uid": "83357987291",
						"sec_uid": "MS4wLjABAAAAUXPNaVNfkuRbV17BbNOTMcpxn_oxf22AvrLyksl3dRI",
						"status": 2,
						"number": 469,
						"nick_name": "艾日秀每天10点准时开播",
						"follow_status": 0
					},
					"products": [
						{
							"market_price": "99900",
							"seckill_status": 2,
							"user_id": "83357987291",
							"sec_user_id": "MS4wLjABAAAAUXPNaVNfkuRbV17BbNOTMcpxn_oxf22AvrLyksl3dRI",
							"activity_type": 0,
							"seckill_price": "24900",
							"has_coupon": false,
							"product_id": "3488622275891192038",
							"item_type": "6",
							"product_title": "网纱半身裙两件套",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/715deba9bcb7e97edde639c872d0f075www1080-1080"
								]
							},
							"start_time": "1624672368",
							"end_time": "1624672969",
							"bought_percentage": 0
						},
						{
							"product_id": "3485106544645937903",
							"item_type": "6",
							"user_id": "0",
							"sec_user_id": "",
							"activity_type": 1,
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/img\/temai\/ccf799ba4e15790ad59a86d7e06c6f3awww1920-1920~tplv-resize:200:0.jpg"
								]
							},
							"has_coupon": false,
							"seckill_price": "10900",
							"market_price": "99900",
							"start_time": "-62135596800",
							"end_time": "-62135596800",
							"bought_percentage": 0,
							"seckill_status": 0,
							"product_title": "收腰显瘦连衣裙"
						},
						{
							"product_id": "3482152416655311035",
							"seckill_price": "8900",
							"market_price": "66600",
							"seckill_status": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/img\/temai\/803e21edb2d991ac5204aa2d0667a159www1080-1080~tplv-resize:200:0.jpg"
								]
							},
							"end_time": "-62135596800",
							"user_id": "0",
							"product_title": "钉珠花朵针织衫",
							"start_time": "-62135596800",
							"bought_percentage": 0,
							"activity_type": 1,
							"item_type": "6",
							"has_coupon": false,
							"sec_user_id": ""
						}
					],
					"anchor_id": "83357987291"
				},
				{
					"live_card": {
						"room_id": "6977865487099202344",
						"status": 2,
						"number": 1085,
						"cover": {
							"uri": "webcast\/6972071043418802944",
							"url_list": [
								"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/6972071043418802944~tplv-resize:400:400.image",
								"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/6972071043418802944~tplv-resize:400:400.image",
								"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/6972071043418802944~tplv-resize:400:400.image"
							],
							"width": 400,
							"height": 400
						},
						"avatar": {
							"uri": "100x100\/douyin-user-file\/f7b52f034734b9bb9c214e6c559ff180",
							"url_list": [
								"https:\/\/p29.douyinpic.com\/img\/douyin-user-file\/f7b52f034734b9bb9c214e6c559ff180~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p9.douyinpic.com\/img\/douyin-user-file\/f7b52f034734b9bb9c214e6c559ff180~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p6.douyinpic.com\/img\/douyin-user-file\/f7b52f034734b9bb9c214e6c559ff180~c5_100x100.jpeg?from=4010531038"
							]
						},
						"uid": "2418534997828142",
						"title": "夏季新款 全场1.9起",
						"nick_name": "可柔爱官方旗舰店",
						"follow_status": 0,
						"sec_uid": "MS4wLjABAAAAfIljrZ8J0XAKN9FB_m11rv7SwbWAwRVFrf1UpdUtmDTICykdbppAD_j24TXginUL"
					},
					"products": [
						{
							"product_id": "3488834425909818685",
							"sec_user_id": "MS4wLjABAAAAfIljrZ8J0XAKN9FB_m11rv7SwbWAwRVFrf1UpdUtmDTICykdbppAD_j24TXginUL",
							"product_title": "打结修身短袖T恤",
							"start_time": "1622995200",
							"bought_percentage": 0.678,
							"seckill_status": 2,
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/15901642fb4b481547e77ee221cfdbc8www800-800"
								]
							},
							"seckill_price": "19800",
							"user_id": "2418534997828142",
							"activity_type": 0,
							"market_price": "19900",
							"end_time": "1643644799",
							"has_coupon": false
						},
						{
							"product_id": "3484704415422755822",
							"bought_percentage": 17.915625,
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/687db3ff539e0dfc406d0c05ec8e1462www800-800"
								]
							},
							"market_price": "26900",
							"has_coupon": false,
							"user_id": "2418534997828142",
							"item_type": "6",
							"seckill_price": "3990",
							"end_time": "1643644799",
							"seckill_status": 2,
							"product_title": "松紧腰宽松九分裤",
							"start_time": "1622995200",
							"sec_user_id": "MS4wLjABAAAAfIljrZ8J0XAKN9FB_m11rv7SwbWAwRVFrf1UpdUtmDTICykdbppAD_j24TXginUL"
						},
						{
							"bought_percentage": 28.793333333333333,
							"item_type": "6",
							"seckill_price": "2990",
							"start_time": "1622995200",
							"end_time": "1643644799",
							"seckill_status": 2,
							"user_id": "2418534997828142",
							"product_title": "修身条纹短袖t恤",
							"product_id": "3484713357544662648",
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/718f56a6ed3999e028b88098c81174c7www800-800"
								]
							},
							"market_price": "16800",
							"has_coupon": false,
							"activity_type": 0,
							"sec_user_id": "MS4wLjABAAAAfIljrZ8J0XAKN9FB_m11rv7SwbWAwRVFrf1UpdUtmDTICykdbppAD_j24TXginUL"
						}
					],
					"anchor_id": "2418534997828142"
				},
				{
					"live_card": {
						"follow_status": 0,
						"uid": "109643472667",
						"sec_uid": "MS4wLjABAAAA9VSE07wTe7Dpx-kvlVrffj4-CFOfTxlGjc1s93NjV5M",
						"room_id": "6977897141985774340",
						"status": 2,
						"nick_name": "程程妈(直播发万元补贴）",
						"number": 147,
						"cover": {
							"uri": "webcast\/6924012679321357059",
							"url_list": [
								"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/6924012679321357059~tplv-resize:400:400.image",
								"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/6924012679321357059~tplv-resize:400:400.image",
								"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/6924012679321357059~tplv-resize:400:400.image"
							],
							"width": 400,
							"height": 400
						},
						"title": "万元补贴，10万人已领券",
						"avatar": {
							"uri": "100x100\/2e51a000620634e258e8c",
							"url_list": [
								"https:\/\/p29.douyinpic.com\/aweme\/100x100\/2e51a000620634e258e8c.jpeg?from=4010531038",
								"https:\/\/p9.douyinpic.com\/aweme\/100x100\/2e51a000620634e258e8c.jpeg?from=4010531038",
								"https:\/\/p3.douyinpic.com\/aweme\/100x100\/2e51a000620634e258e8c.jpeg?from=4010531038"
							]
						}
					},
					"products": [
						{
							"product_id": "3477275163337333571",
							"item_type": "6",
							"start_time": "1624550400",
							"bought_percentage": 0.016,
							"seckill_status": 2,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/76c51a5c27646d0bc0ed8dfaaf7446b3www800-800"
								]
							},
							"market_price": "8990",
							"user_id": "2392147956335614",
							"end_time": "1625068799",
							"product_title": "爱酷熊纸尿裤",
							"seckill_price": "6490",
							"has_coupon": false,
							"sec_user_id": "MS4wLjABAAAAFP1WLVOIDSJ4n38R9JzJDF90fZbb8JwrlzPcP50fPRSDMVS7g1Oy5mBlTaxS9XGe",
							"activity_type": 0
						},
						{
							"market_price": "6490",
							"product_title": "夏季超薄纸尿裤",
							"end_time": "1625068799",
							"has_coupon": false,
							"activity_type": 0,
							"product_id": "3488074212487364583",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/6d5991a398fa2054689068a7cd901934www800-800"
								]
							},
							"seckill_price": "4990",
							"seckill_status": 2,
							"user_id": "4152175892891470",
							"item_type": "6",
							"start_time": "1624204800",
							"bought_percentage": 19.40740740740741,
							"sec_user_id": "MS4wLjABAAAAjDg905NhuBN8GTDTKI92CNNxAreNnFGC1OgScBMRWXFpcJe9AhJgkMhoAkIBKTxj"
						},
						{
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/35eddfdee5b9e2a53eb9480dd6caa895www800-800"
								]
							},
							"bought_percentage": 25.575163398692812,
							"product_title": "儿童喝水早餐杯",
							"product_id": "3480268461463201034",
							"end_time": "1625068799",
							"sec_user_id": "MS4wLjABAAAAGSKzL9Ciw_XHGRo2FlV07wwpEa0tn1B98y7nJdur1kU",
							"item_type": "6",
							"market_price": "490",
							"start_time": "1623254400",
							"seckill_status": 2,
							"activity_type": 0,
							"seckill_price": "490",
							"has_coupon": false,
							"user_id": "510625094840699"
						}
					],
					"anchor_id": "109643472667"
				},
				{
					"products": [
						{
							"has_coupon": false,
							"product_title": "M-4XL连衣裙",
							"start_time": "1624672461",
							"seckill_status": 2,
							"bought_percentage": 66.3157894736842,
							"product_id": "3488834584706179196",
							"market_price": "39900",
							"end_time": "1624673061",
							"sec_user_id": "MS4wLjABAAAA7gn46ESmX_h-9TjS4zIGVO5bOCi0VNo2uEp12M14Amy6quaNRLzF04KhxcZuuFok",
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/441ab7e2194726b366a35752014ccaa2www800-800"
								]
							},
							"seckill_price": "16800",
							"item_type": "6",
							"user_id": "1613674167928915"
						},
						{
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/1d05d210d2dbab7afaabdb05a3133329www800-800"
								]
							},
							"market_price": "39900",
							"sec_user_id": "MS4wLjABAAAA7gn46ESmX_h-9TjS4zIGVO5bOCi0VNo2uEp12M14Amy6quaNRLzF04KhxcZuuFok",
							"start_time": "1624464000",
							"user_id": "1613674167928915",
							"product_title": "M-4XL连衣裙",
							"has_coupon": false,
							"item_type": "6",
							"seckill_price": "16800",
							"end_time": "1625068799",
							"product_id": "3488838918495936460",
							"bought_percentage": 0,
							"seckill_status": 2
						},
						{
							"product_id": "3488813395510212552",
							"product_title": "M-3XL连衣裙",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/f87421c6cd30ac0152ef84618296def9www800-800"
								]
							},
							"seckill_price": "16800",
							"has_coupon": false,
							"start_time": "1624550400",
							"end_time": "1625068799",
							"seckill_status": 2,
							"user_id": "1613674167928915",
							"activity_type": 0,
							"item_type": "6",
							"market_price": "39900",
							"bought_percentage": 4,
							"sec_user_id": "MS4wLjABAAAA7gn46ESmX_h-9TjS4zIGVO5bOCi0VNo2uEp12M14Amy6quaNRLzF04KhxcZuuFok"
						}
					],
					"anchor_id": "2581262732366036",
					"live_card": {
						"sec_uid": "MS4wLjABAAAAga6g5wP9qVBdm0loqUj370Es6FT_-lUVXRYuynjEx-ELY4JhV56XZVuaEzXjAly3",
						"room_id": "6977854535792380708",
						"title": "一万人都在抢购的连衣裙",
						"follow_status": 0,
						"uid": "2581262732366036",
						"status": 2,
						"number": 978,
						"cover": {
							"uri": "webcast\/6971029538373946142",
							"url_list": [
								"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/6971029538373946142~tplv-resize:400:400.image",
								"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/6971029538373946142~tplv-resize:400:400.image",
								"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/6971029538373946142~tplv-resize:400:400.image"
							],
							"width": 400,
							"height": 400
						},
						"avatar": {
							"uri": "100x100\/tos-cn-avt-0015\/cad304ca2e0326fcf9fd377578eb243c",
							"url_list": [
								"https:\/\/p3.douyinpic.com\/img\/tos-cn-avt-0015\/cad304ca2e0326fcf9fd377578eb243c~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p26.douyinpic.com\/img\/tos-cn-avt-0015\/cad304ca2e0326fcf9fd377578eb243c~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p29.douyinpic.com\/img\/tos-cn-avt-0015\/cad304ca2e0326fcf9fd377578eb243c~c5_100x100.jpeg?from=4010531038"
							]
						},
						"nick_name": "袖恩女装"
					}
				},
				{
					"anchor_id": "2084294727053032",
					"live_card": {
						"number": 290,
						"cover": {
							"width": 400,
							"height": 400,
							"uri": "webcast\/6944400980247087880",
							"url_list": [
								"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/6944400980247087880~tplv-resize:400:400.image",
								"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/6944400980247087880~tplv-resize:400:400.image",
								"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/6944400980247087880~tplv-resize:400:400.image"
							]
						},
						"avatar": {
							"uri": "100x100\/tos-cn-avt-0015\/41ca4d00098774ee8c69c624fc26ec25",
							"url_list": [
								"https:\/\/p3.douyinpic.com\/img\/tos-cn-avt-0015\/41ca4d00098774ee8c69c624fc26ec25~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p9.douyinpic.com\/img\/tos-cn-avt-0015\/41ca4d00098774ee8c69c624fc26ec25~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p6.douyinpic.com\/img\/tos-cn-avt-0015\/41ca4d00098774ee8c69c624fc26ec25~c5_100x100.jpeg?from=4010531038"
							]
						},
						"follow_status": 0,
						"sec_uid": "MS4wLjABAAAAnIvBAQMQHa0hvHV_NgIl3qstQ7TB6XbxjXS8f266BEy3yKeVobshynIXQw14hd6_",
						"room_id": "6977891022718569223",
						"status": 2,
						"title": "冲刺一百万粉丝买一送一",
						"nick_name": "旺达首饰",
						"uid": "2084294727053032"
					},
					"products": [
						{
							"product_id": "3465988429265900055",
							"market_price": "5800",
							"end_time": "1625068799",
							"bought_percentage": 14.824584542337114,
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/d190f5b8ffde8c623c234ffd5a56cf42www2300-2300"
								]
							},
							"product_title": "右手等待银戒指",
							"seckill_price": "3800",
							"has_coupon": false,
							"user_id": "2084294727053032",
							"sec_user_id": "MS4wLjABAAAAnIvBAQMQHa0hvHV_NgIl3qstQ7TB6XbxjXS8f266BEy3yKeVobshynIXQw14hd6_",
							"start_time": "1623772800",
							"seckill_status": 2,
							"activity_type": 0
						},
						{
							"bought_percentage": 0,
							"has_coupon": false,
							"sec_user_id": "",
							"seckill_price": "8900",
							"market_price": "19800",
							"seckill_status": 0,
							"user_id": "0",
							"item_type": "6",
							"end_time": "-62135596800",
							"start_time": "-62135596800",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/0141b3449d2f3d54e681b943fcd5dd8awww767-769~tplv-resize:200:0.jpg"
								]
							},
							"activity_type": 1,
							"product_title": "简约6爪莫桑钻",
							"product_id": "3484741044975851046"
						},
						{
							"bought_percentage": 0,
							"activity_type": 1,
							"seckill_price": "19800",
							"end_time": "-62135596800",
							"seckill_status": 0,
							"product_id": "3488834498941031641",
							"start_time": "-62135596800",
							"product_title": "芭比粉钻925银",
							"market_price": "98800",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/bcba1a9756ef3db2d1b1b55fc9fcca78www835-833~tplv-resize:200:0.jpg"
								]
							},
							"has_coupon": false,
							"user_id": "0",
							"sec_user_id": "",
							"item_type": "6"
						}
					]
				}
			],
			"title": "好物秒杀",
			"sub_title": ""
		},
		"cursor": 1,
		"extra": {
			"logid": "2021062609580101021204523515259E46",
			"now": 1624672682000,
			"fatal_item_ids": []
		},
		"log_pb": {
			"impr_id": "2021062609580101021204523515259E46"
		}
	}
}
```


