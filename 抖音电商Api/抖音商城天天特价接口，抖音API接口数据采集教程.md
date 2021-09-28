# 抖音商城天天特价接口，抖音API接口数据采集教程



## 抖音商城新品接口

### 请求Api
```http
http://主机地址/douyin/commerce/seckill_page?token=xxx

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
		"banners": [
			{
				"banner_image": {
					"url_list": [
						"https:\/\/sf3-cdn-tos.huoshanstatic.com\/obj\/ies.fe.mis\/aad9dde1b8e119e0c90b3a9d904aff5e.png"
					]
				},
				"link_url": "https:\/\/mix.jinritemai.com\/h5\/page\/6972099254965764365"
			}
		],
		"platform_seckill": {
			"title": "天天特价",
			"sub_title": "全天多时段惊喜1元购",
			"avatars": null,
			"products": [
				{
					"time": "1624636800",
					"seckill_status": "",
					"products": [
						{
							"item_type": "6",
							"start_time": "1624636800",
							"sec_user_id": "MS4wLjABAAAApkvDkwIoWC6W8IY2XDSe7dfJgjngZvabYA6gk7yCl8A",
							"seckill_status": 2,
							"activity_type": 0,
							"product_id": "3480295369441687163",
							"market_price": "990",
							"end_time": "1624723199",
							"user_id": "111321699183",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/ec3cea913fe8d3c5b9890104664bba62www800-800"
								]
							},
							"seckill_price": "690",
							"bought_percentage": 26.5,
							"has_coupon": false,
							"product_title": "干发帽2条"
						},
						{
							"sec_user_id": "MS4wLjABAAAAneVMwfZOymguOMXNUil4Y23WBy_iBauJXxy65LH9dhY",
							"activity_type": 0,
							"bought_percentage": 43.5,
							"item_type": "6",
							"market_price": "990",
							"start_time": "1624636800",
							"seckill_status": 2,
							"has_coupon": false,
							"user_id": "104280777639",
							"product_title": "大吃兄海鲜锅巴",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/aefaac151894947a49906ad1cafd9009www800-800"
								]
							},
							"seckill_price": "590",
							"product_id": "3479723943328363294",
							"end_time": "1624723199"
						},
						{
							"market_price": "980",
							"end_time": "1624723199",
							"seckill_status": 2,
							"product_id": "3477860844539393587",
							"start_time": "1624636800",
							"has_coupon": false,
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/fd99e2a772091e9bf35130cf6ae7dc4d405897b0www800-800"
								]
							},
							"seckill_price": "790",
							"user_id": "103050919600",
							"activity_type": 0,
							"product_title": "笔筒斜插式收纳盒",
							"bought_percentage": 10.5,
							"sec_user_id": "MS4wLjABAAAAsdn2LYd9rh7Ad1Ihco9DBwtNpwJNm5B48cWuFox722Q"
						},
						{
							"product_id": "3475261738511905078",
							"seckill_price": "690",
							"end_time": "1624723199",
							"start_time": "1624636800",
							"sec_user_id": "MS4wLjABAAAA_obF8p4lrNLJFm1y7PjSs1-NxJ1bySyadfXjI96u4FAeoH3ZK2HcamzIwm9IvQBM",
							"product_title": "消毒卫生湿纸巾",
							"item_type": "6",
							"user_id": "3034268657784941",
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/a958f82bac622d7ad16d6df5f534dc5bwww800-800"
								]
							},
							"market_price": "1980",
							"bought_percentage": 2.5,
							"seckill_status": 2,
							"has_coupon": false,
							"activity_type": 0
						},
						{
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/081daaf98407857b1faf7e6da2f6485dwww800-800"
								]
							},
							"seckill_price": "690",
							"start_time": "1624636800",
							"user_id": "85032320076",
							"item_type": "6",
							"activity_type": 0,
							"product_title": "脆藕片250g",
							"market_price": "1290",
							"end_time": "1624723199",
							"has_coupon": false,
							"product_id": "3472815266990264015",
							"bought_percentage": 14.5,
							"seckill_status": 2,
							"sec_user_id": "MS4wLjABAAAA_7YCNHuBmuEb_8YfrEfvw1Vs77uHOGKbYM2cApD5q-M"
						},
						{
							"product_id": "3459939536778449106",
							"sec_user_id": "MS4wLjABAAAATCJ1VEkZe_O3ROZYwuG1TzuSHbqQteqkD0ZR3KfAgiM",
							"item_type": "6",
							"market_price": "3800",
							"seckill_status": 2,
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/812be4db6eeb3a20f675d9a4828be987www800-800"
								]
							},
							"user_id": "193145469681132",
							"activity_type": 0,
							"product_title": "红丝绒欧包9个",
							"seckill_price": "1290",
							"start_time": "1624636800",
							"end_time": "1624723199",
							"bought_percentage": 30,
							"has_coupon": false
						}
					]
				},
				{
					"time": "1624665600",
					"seckill_status": "",
					"products": [
						{
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/c1465a3f3b01daa55d53775ee01de9e0www800-800"
								]
							},
							"seckill_price": "890",
							"user_id": "3501306403624700",
							"seckill_status": 2,
							"sec_user_id": "MS4wLjABAAAAZ0FHbUIAuh4xVNckZq4cmz-JEskpFaro7rONV47KOLUMp2RVPq6hYWEinmz3uj82",
							"product_id": "3485484067800096857",
							"item_type": "6",
							"market_price": "1590",
							"start_time": "1624665600",
							"bought_percentage": 31.5,
							"has_coupon": false,
							"end_time": "1624723199",
							"activity_type": 0,
							"product_title": "清风抽纸6包"
						},
						{
							"end_time": "1624723199",
							"has_coupon": false,
							"product_id": "3452413282906948322",
							"market_price": "1990",
							"seckill_price": "590",
							"start_time": "1624665600",
							"bought_percentage": 19.727891156462587,
							"activity_type": 0,
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/8488435e272e4d81bf81d90cd5e3a374www800-800"
								]
							},
							"sec_user_id": "MS4wLjABAAAAif45TbPg3l8Xzcf_LgUrNm7irGSbudqYLA79Wi-pkUQ",
							"product_title": "心相印保鲜膜3卷",
							"seckill_status": 2,
							"user_id": "8447610067352"
						},
						{
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/a736f6fcfbdc7e8b482277028954fabbwww800-800"
								]
							},
							"seckill_status": 2,
							"sec_user_id": "MS4wLjABAAAA5QGDHPcDBFToTZdGQnEd297VQadTA9LkSH_BPfywkAg",
							"market_price": "1990",
							"end_time": "1624723199",
							"activity_type": 0,
							"product_id": "3485451784863010645",
							"item_type": "6",
							"seckill_price": "1290",
							"bought_percentage": 31.25,
							"start_time": "1624665600",
							"has_coupon": false,
							"user_id": "111247674813",
							"product_title": "陕西哈密瓜2枚装"
						},
						{
							"item_type": "6",
							"start_time": "1624665600",
							"sec_user_id": "MS4wLjABAAAAbL4gN6ODmL_iQPJu-w_A7dJp-KPlplc0L7L7Rux6HRU",
							"product_title": "碧生源胶原蛋白饮",
							"seckill_price": "5490",
							"seckill_status": 2,
							"product_id": "3478204594386017381",
							"end_time": "1624723199",
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/e5c97c0c122defc83e9623b454efe027www790-900"
								]
							},
							"market_price": "9900",
							"bought_percentage": 0,
							"has_coupon": false,
							"user_id": "60812055244"
						},
						{
							"market_price": "5800",
							"sec_user_id": "MS4wLjABAAAACr9ZfJ46uyT_dZI0K2VwBSBhh9BAcseRotW_4ArbkpLHhIHr1s6SsDOiKvs77qC1",
							"end_time": "1624723199",
							"user_id": "2972668247157488",
							"product_id": "3467469407045945516",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/468f0fbc6596b4c5206d40632b64c864www800-800"
								]
							},
							"seckill_price": "4000",
							"item_type": "6",
							"bought_percentage": 30,
							"has_coupon": false,
							"product_title": "海澜之家T恤",
							"start_time": "1624665600",
							"seckill_status": 2,
							"activity_type": 0
						},
						{
							"bought_percentage": 100,
							"product_id": "3455632863674924623",
							"item_type": "6",
							"start_time": "1624665600",
							"end_time": "1624723199",
							"user_id": "2576852248964231",
							"sec_user_id": "MS4wLjABAAAApvmD7W2W3w2XaT3rvFoX4ZJB82m8bgKiavlHfkM9zSOlNGgBpgx_hi92oIepxaZl",
							"market_price": "89900",
							"seckill_status": 3,
							"has_coupon": false,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/628e66c1620358cecd5485daf6158eb2www1000-1000"
								]
							},
							"seckill_price": "100",
							"activity_type": 0,
							"product_title": "美的微波炉"
						}
					]
				},
				{
					"time": "1624669200",
					"seckill_status": "",
					"products": [
						{
							"item_type": "6",
							"activity_type": 0,
							"product_title": "3A快充数据线",
							"seckill_status": 2,
							"has_coupon": false,
							"sec_user_id": "MS4wLjABAAAAPBken3scyD-Vx3KTBEwuiXFnKLtbWe3GzxAzHs9uOnk",
							"product_id": "3473058370544634167",
							"seckill_price": "690",
							"market_price": "1490",
							"start_time": "1624669200",
							"bought_percentage": 12,
							"user_id": "14357720850",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/e5ce9299456ba230a4c03417af26bc23www800-800"
								]
							},
							"end_time": "1624723199"
						},
						{
							"product_id": "3461198670999985734",
							"item_type": "6",
							"seckill_price": "490",
							"seckill_status": 2,
							"has_coupon": false,
							"sec_user_id": "MS4wLjABAAAAMnIIHva9IKSzJ7MCT8X5xHydz_VsAyR_SBh8wKBn7Fs",
							"activity_type": 0,
							"end_time": "1624723199",
							"product_title": "其妙350g蛋酥",
							"market_price": "1490",
							"start_time": "1624669200",
							"bought_percentage": 33.5,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/48721ca8b758cbe9128f22e88bc0dae0www800-800"
								]
							},
							"user_id": "77403192245"
						},
						{
							"product_id": "3484688783906109015",
							"activity_type": 0,
							"item_type": "6",
							"market_price": "1600",
							"seckill_status": 2,
							"end_time": "1624723199",
							"sec_user_id": "MS4wLjABAAAAsvtk8Kc1GwaVOFqWJrBmCndq6NwPZHHoODvUZUynNmo",
							"bought_percentage": 1.25,
							"has_coupon": false,
							"user_id": "984790830423607",
							"product_title": "辅食米粉盒",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/0ccd319260b906c08db7a3cda3c2185b9ad4eba5www800-800"
								]
							},
							"seckill_price": "1600",
							"start_time": "1624669200"
						},
						{
							"activity_type": 0,
							"product_id": "3458227638102052735",
							"item_type": "6",
							"user_id": "1772039902333048",
							"start_time": "1624669200",
							"seckill_status": 2,
							"has_coupon": false,
							"end_time": "1624723199",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/5288ba2016a97932e69ec819c8dbb8c7b48d77e9www800-800"
								]
							},
							"seckill_price": "1990",
							"market_price": "2990",
							"bought_percentage": 5,
							"sec_user_id": "MS4wLjABAAAAVCLXDxtkW50eBF9OtzbJ5bwQJGQ75ezSfx7AvtNaetCsZPp7gyat8-mVYncrqCHx",
							"product_title": "可心柔婴儿湿巾"
						},
						{
							"start_time": "1624669200",
							"product_id": "3486576731287088091",
							"item_type": "6",
							"end_time": "1624723199",
							"has_coupon": false,
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/39cf447280b2ceb7ce30d298e7e8bf0bwww800-800"
								]
							},
							"seckill_price": "3090",
							"user_id": "193145469681132",
							"sec_user_id": "MS4wLjABAAAATCJ1VEkZe_O3ROZYwuG1TzuSHbqQteqkD0ZR3KfAgiM",
							"market_price": "3090",
							"bought_percentage": 38,
							"seckill_status": 2,
							"product_title": "康师傅方便面整箱"
						},
						{
							"end_time": "1624723199",
							"bought_percentage": 100,
							"product_title": "板栗味小南瓜",
							"product_id": "3484885495572494390",
							"market_price": "3990",
							"sec_user_id": "MS4wLjABAAAA5QGDHPcDBFToTZdGQnEd297VQadTA9LkSH_BPfywkAg",
							"start_time": "1624669200",
							"has_coupon": false,
							"activity_type": 0,
							"item_type": "6",
							"seckill_status": 3,
							"user_id": "111247674813",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/45e5935fc33ade61ca764ba4d1daa1aawww800-800"
								]
							},
							"seckill_price": "100"
						}
					]
				},
				{
					"seckill_status": "",
					"products": [
						{
							"bought_percentage": 0,
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/2777513ae98f04e943f4fc43d12a83c3www800-800"
								]
							},
							"seckill_price": "490",
							"end_time": "1624723199",
							"market_price": "1490",
							"sec_user_id": "MS4wLjABAAAAif45TbPg3l8Xzcf_LgUrNm7irGSbudqYLA79Wi-pkUQ",
							"product_title": "心相印厨房纸2卷",
							"seckill_status": 1,
							"has_coupon": false,
							"user_id": "8447610067352",
							"product_id": "3454868715869463684",
							"item_type": "6",
							"start_time": "1624672800"
						},
						{
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/d508561b1b4f28c1b1ac0ed89d4d715awww1280-1280"
								]
							},
							"end_time": "1624723199",
							"bought_percentage": 0,
							"seckill_status": 1,
							"has_coupon": false,
							"item_type": "6",
							"seckill_price": "590",
							"start_time": "1624672800",
							"sec_user_id": "MS4wLjABAAAAhuTbh-NymO4Be6dDE_Dp5Ebk72IgkJoaFgqAMNNdoRQ",
							"activity_type": 0,
							"product_id": "3444648322906849882",
							"product_title": "四川安岳9斤柠檬",
							"market_price": "990",
							"user_id": "99779364483"
						},
						{
							"bought_percentage": 0,
							"product_id": "3416280606877823450",
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/Fl-jJwXNjZ24D7W19lvCc4BY9fEtwww800-800"
								]
							},
							"user_id": "110868228657",
							"sec_user_id": "MS4wLjABAAAAj3i05t3vQd1ez26EeVNxHfjvMbonruPn_nU8F-YSqD4",
							"product_title": "涤尚除螨洗衣液",
							"start_time": "1624672800",
							"has_coupon": false,
							"market_price": "3990",
							"end_time": "1624723199",
							"seckill_status": 1,
							"item_type": "6",
							"seckill_price": "1990",
							"activity_type": 0
						},
						{
							"market_price": "1690",
							"product_title": "广西金煌芒5斤",
							"activity_type": 0,
							"seckill_price": "1090",
							"bought_percentage": 0,
							"seckill_status": 1,
							"has_coupon": false,
							"user_id": "95890690282",
							"sec_user_id": "MS4wLjABAAAAxvMCNVc5bdGAT3TBfhzexmdzenOnZBN1l0BI5BCYGVQ",
							"end_time": "1624723199",
							"product_id": "3486615265733670425",
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/3397d337d7374ef8c091aadda1af0ae1www828-817"
								]
							},
							"start_time": "1624672800"
						},
						{
							"product_id": "3477466656593302120",
							"sec_user_id": "MS4wLjABAAAAneVMwfZOymguOMXNUil4Y23WBy_iBauJXxy65LH9dhY",
							"market_price": "2490",
							"seckill_price": "1490",
							"start_time": "1624672800",
							"end_time": "1624723199",
							"bought_percentage": 0,
							"seckill_status": 1,
							"user_id": "104280777639",
							"product_title": "粮悦传统麻花3袋",
							"item_type": "6",
							"cover": {
								"url_list": [
									"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/34aa04494b5274e5278571787f0aea85www800-800"
								]
							},
							"has_coupon": false,
							"activity_type": 0
						},
						{
							"activity_type": 0,
							"cover": {
								"url_list": [
									"https:\/\/sf1-ttcdn-tos.pstatp.com\/obj\/temai\/39d3ebe6ca6e89f82ee539f83c472866www800-800"
								]
							},
							"market_price": "39900",
							"has_coupon": false,
							"product_id": "3478266690947710680",
							"item_type": "6",
							"start_time": "1624672800",
							"end_time": "1624723199",
							"seckill_status": 1,
							"user_id": "106400563183",
							"product_title": "无线立体声耳机",
							"seckill_price": "100",
							"bought_percentage": 0,
							"sec_user_id": "MS4wLjABAAAApx4-L5tqL3CJ0_LN0EeHdTfShrE3YUcdAAUzsPNEMSw"
						}
					],
					"time": "1624672800"
				}
			],
			"current_index": 0
		},
		"is_activity": false,
		"activity_name": "activity_618",
		"super_seckill_live": {
			"sub_title": "",
			"lives": [],
			"title": "超级秒杀直播间"
		},
		"extra": {
			"now": 1624672152000,
			"fatal_item_ids": [],
			"logid": "202106260949120102121521660E257A12"
		},
		"log_pb": {
			"impr_id": "202106260949120102121521660E257A12"
		},
		"status_code": 0
	}
}
```


