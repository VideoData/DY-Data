# 抖音商城精选商品列表接口数据采集，抖音API接口数据采集教程



## 抖音商城精选商品列表接口

### 请求Api
```http
http://主机地址/douyin/commerce/feed?token=xxx&tab_id=1

```

### 

### 请求方式
```http
GET
```



### 参数
| 字段 | 类型 | 说明 |
| --- | --- | --- |
| token | string | 接口授权码 |
| tab_id	 | int | 商品分类id，详见“商城商品分类” |
| page_num	 | int | 翻页，默认1，翻页：1、2、3、4…… |

 
### 返回示例
```json
{
	"code": 200,
	"msg": "成功",
	"data": {
		"log_pb": {
			"impr_id": "2021062609170301021216416722198618"
		},
		"status_code": 0,
		"item_cards": [
			{
				"type": 2,
				"product": {
					"price": {
						"min_price": 990,
						"max_price": 3980,
						"market_price": 4990
					},
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"product_id": "3448538852938149889",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/b5ab6f11ae1c8cd1fdd1f2d6f3f08b24www800-800~500x0.image"
						]
					},
					"sec_kol_id": "MS4wLjABAAAAE0ouARvyRiXmPGL1Vp7DqJjMo0x-O4akGOcfASFbsg1wryEzx5Au9okV66tWFPF1",
					"title": "【宠粉专享】清宜 奇亚籽水果酸奶谷物坚果燕麦片即食早餐250g",
					"kol_id": "2440571626195724",
					"biz_kind": 0,
					"icon_name": "",
					"sales": 18405,
					"promotion_id": "3448538852938149889",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_tab_cid1:46:2.48181\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":2.481811046600342,\"sim_id\":3448538852938149889,\"leaf_ctg\":23061,\"ctg1\":20017,\"pred_ctg1\":20017,\"pred_leaf_ctg\":23061,\"predict_score\":0.9128040075302124,\"product_click\":0.010142266750335694,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.005818754434585571,\"rough_cvr\":0.0377647876739502},\"channel_id\":1111818,\"mix\":{\"ctr\":0.010142266750335694,\"cvr\":0.0,\"nctr\":0.17487776205603992,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":0,\"tab_id\":1,\"page_num\":1,\"pctr\":0.008675575256347657,\"pcvr\":0.045970618724823,\"pre\":0.04083538055419922,\"mix_score\":0.13860255479812623,\"price\":9}}",
					"rec_reason": {
						"content": ""
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141920944"
					},
					"has_sec_kill": true,
					"commodity_type": 6
				},
				"user": {
					"is_followed": false,
					"id": "2440571626195724",
					"avatar": {
						"uri": "100x100\/tos-cn-avt-0015\/6a231a900a45bb48958e84ac318ef738",
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-avt-0015\/6a231a900a45bb48958e84ac318ef738~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-avt-0015\/6a231a900a45bb48958e84ac318ef738~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-avt-0015\/6a231a900a45bb48958e84ac318ef738~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "清宜旗舰店"
				}
			},
			{
				"type": 2,
				"product": {
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/f8d58414221b5846dd33a0cae9f0fd00www800-800~500x0.image"
						]
					},
					"price": {
						"min_price": 1300,
						"max_price": 5000,
						"market_price": 5800
					},
					"has_sec_kill": false,
					"product_icon": {
						"height": 14,
						"uri": "",
						"url_list": [
							""
						],
						"width": 42
					},
					"product_id": "3479170047115679217",
					"sales": 4029,
					"rec_reason": {
						"content": ""
					},
					"commodity_type": 6,
					"icon_name": "",
					"title": "高粱饴软糖-童年记忆 拉丝多口味饴糖 500g\/包",
					"kol_id": "84651591523",
					"sec_kol_id": "MS4wLjABAAAADFBYdtGL_UXMisIume2_2xmywOeQk5oZNX7Qed9bhnY",
					"promotion_id": "3479170047115679217",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_guess_u_like_recall:189:0.566711,viking_ecom_center_tab_cid1:64:2.10603\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":2.106029748916626,\"viking_ecom_center_guess_u_like_recall\":0.5667113065719605,\"sim_id\":3488296850656733440,\"leaf_ctg\":23376,\"ctg1\":20018,\"pred_ctg1\":20018,\"pred_leaf_ctg\":23376,\"predict_score\":0.9891638159751892,\"product_click\":0.010990709066390992,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.00718650221824646,\"rough_cvr\":0.03058803081512451},\"channel_id\":1111818,\"mix\":{\"ctr\":0.010990709066390992,\"cvr\":0.0,\"nctr\":0.19751932909818008,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":1,\"tab_id\":1,\"page_num\":1,\"pctr\":0.009879887104034424,\"pcvr\":0.021731853485107423,\"pre\":0.04083538055419922,\"mix_score\":0.12801110744476319,\"price\":13}}",
					"biz_kind": 0,
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141921184"
					}
				},
				"user": {
					"nickname": "小嗨鲜商贸",
					"is_followed": false,
					"id": "84651591523",
					"avatar": {
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/99c1042c488a44d6a150a2d8b6526121~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/99c1042c488a44d6a150a2d8b6526121~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/99c1042c488a44d6a150a2d8b6526121~c5_100x100.jpeg?from=4010531038"
						],
						"uri": "100x100\/tos-cn-i-0813\/99c1042c488a44d6a150a2d8b6526121"
					}
				}
			},
			{
				"type": 2,
				"product": {
					"promotion_id": "3473642672936321986",
					"rec_reason": {
						"content": ""
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141921440"
					},
					"biz_kind": 0,
					"product_icon": {
						"url_list": [
							""
						],
						"width": 42,
						"height": 14,
						"uri": ""
					},
					"icon_name": "",
					"product_id": "3473642672936321986",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/b40b1307657a46596807a7ac729a3a018add9b6bwww800-800~500x0.image"
						]
					},
					"sales": 7271,
					"price": {
						"min_price": 990,
						"max_price": 3790,
						"market_price": 3990
					},
					"title": "【A】娃哈哈AD钙奶大瓶220ml*4瓶 (新鲜日期)",
					"kol_id": "2704409592332755",
					"commodity_type": 6,
					"has_sec_kill": true,
					"sec_kol_id": "MS4wLjABAAAAa5QExH2BFdJO-xQNo2UQ8defl7rkgobM03flvk2RM91yfi2tuSgYdjYGMfyXikKS",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_u2u_recall:442:0.487218,viking_ecom_center_tab_cid1:186:0.70667\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_u2u_recall\":0.4872175455093384,\"viking_ecom_center_tab_cid1\":0.7066702842712402,\"sim_id\":3478247687915212607,\"leaf_ctg\":23143,\"ctg1\":20017,\"pred_ctg1\":20017,\"pred_leaf_ctg\":23143,\"predict_score\":0.8571052551269531,\"product_click\":0.009523391723632813,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.008174657821655274,\"rough_cvr\":0.03156179189682007},\"channel_id\":1111818,\"mix\":{\"ctr\":0.009523391723632813,\"cvr\":0.0,\"nctr\":0.15844065400580016,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":2,\"tab_id\":1,\"page_num\":1,\"pctr\":0.007977277040481568,\"pcvr\":0.019445031881332399,\"pre\":0.04083538055419922,\"mix_score\":0.09993816167116165,\"price\":9}}"
				},
				"user": {
					"id": "2704409592332755",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/5de711e018a940f398f77d354264b213",
						"url_list": [
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-i-0813\/5de711e018a940f398f77d354264b213~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/5de711e018a940f398f77d354264b213~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/5de711e018a940f398f77d354264b213~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "选品官",
					"is_followed": false
				}
			},
			{
				"type": 2,
				"product": {
					"sales": 8482,
					"price": {
						"min_price": 5000,
						"max_price": 0,
						"market_price": 7000
					},
					"has_sec_kill": false,
					"kol_id": "2867126809666110",
					"rec_reason": {
						"content": ""
					},
					"product_icon": {
						"height": 14,
						"uri": "",
						"url_list": [
							""
						],
						"width": 42
					},
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_tab_cid1:96:1.72175\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":1.7217543125152588,\"sim_id\":3442047071803317828,\"leaf_ctg\":31183,\"ctg1\":20104,\"pred_ctg1\":20104,\"pred_leaf_ctg\":31265,\"predict_score\":0.9246540069580078,\"product_click\":0.010273933410644532,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.011461228132247925,\"rough_cvr\":0.004094481468200684},\"channel_id\":1111818,\"mix\":{\"ctr\":0.010273933410644532,\"cvr\":0.0,\"nctr\":0.1783929643391232,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":3,\"tab_id\":1,\"page_num\":1,\"pctr\":0.009110957384109497,\"pcvr\":0.005458652973175049,\"pre\":0.04083538055419922,\"mix_score\":0.09959962218999863,\"price\":50}}",
					"biz_kind": 0,
					"icon_name": "",
					"title": "红薯粉条五斤装",
					"sec_kol_id": "MS4wLjABAAAAeT8NWWGWY_UDWTLi073jTFSd9lp2C4UBA88XAKakLJOLds9Pmil5mvw77WhxnHfV",
					"product_id": "3442047071803317828",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/7fb38e627c7c4ce2d765bea0e95fab3ewww1080-1080~500x0.image"
						]
					},
					"promotion_id": "3442047071803317828",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141922016"
					}
				},
				"user": {
					"id": "2867126809666110",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/2ae47b590f8e46d196c1b164230a5455",
						"url_list": [
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-i-0813\/2ae47b590f8e46d196c1b164230a5455~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/2ae47b590f8e46d196c1b164230a5455~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/2ae47b590f8e46d196c1b164230a5455~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "才艺崔帅",
					"is_followed": false
				}
			},
			{
				"user": {
					"is_followed": false,
					"id": "1178265260140523",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/038e7f5be1c34d9099d20d2f4d333f66",
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/038e7f5be1c34d9099d20d2f4d333f66~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/038e7f5be1c34d9099d20d2f4d333f66~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/038e7f5be1c34d9099d20d2f4d333f66~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "德清拾味电子商务有限公司"
				},
				"type": 2,
				"product": {
					"sales": 4889,
					"promotion_id": "3480669774684492720",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141923168"
					},
					"product_id": "3480669774684492720",
					"sec_kol_id": "MS4wLjABAAAA05lKy_UMCqoILYcIOTWdPcVE-GU81Kc5tQTevnnIMsaM0eFE5gK7DX1_9jlVbLtC",
					"price": {
						"min_price": 990,
						"max_price": 3880,
						"market_price": 5990
					},
					"commodity_type": 6,
					"rec_reason": {
						"content": ""
					},
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"icon_name": "",
					"has_sec_kill": false,
					"title": "碳酸饮料可口可乐汽水300ml*12瓶\/箱整箱装Coca迷你饮品雪碧芬达",
					"kol_id": "1178265260140523",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_tab_cid1:132:1.31227\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":1.3122737407684329,\"sim_id\":3488489132097934219,\"leaf_ctg\":22912,\"ctg1\":20017,\"pred_ctg1\":20017,\"pred_leaf_ctg\":22912,\"predict_score\":1.053333044052124,\"product_click\":0.011703699827194214,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.01091715693473816,\"rough_cvr\":0.02392059564590454},\"channel_id\":1111818,\"mix\":{\"ctr\":0.011703699827194214,\"cvr\":0.0,\"nctr\":0.21668674783981627,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":4,\"tab_id\":1,\"page_num\":1,\"pctr\":0.010652512311935425,\"pcvr\":0.017526775598526,\"pre\":0.04083538055419922,\"mix_score\":0.1307966709136963,\"price\":9}}",
					"biz_kind": 0,
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf6-ttcdn-tos.pstatp.com\/img\/temai\/c6a3eb9f40b1795ce9d7f30b81e0d6d9www800-800~500x0.image"
						]
					}
				}
			},
			{
				"product": {
					"promotion_id": "3449291616739793026",
					"sales": 25,
					"price": {
						"min_price": 990,
						"max_price": 3990,
						"market_price": 4990
					},
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/60213c3f2b22aef6e50f3d34cd98e3adwww800-800~500x0.image"
						],
						"uri": ""
					},
					"title": "懒人自热便携小火锅方便自煮即食速食麻辣烫网红252g多规格可选",
					"rec_reason": {
						"content": ""
					},
					"biz_kind": 0,
					"kol_id": "63633679866",
					"sec_kol_id": "MS4wLjABAAAA0SvgxpUn-60TLnGMzpKH0q77wCVKtPjuImAmbqFt4HY",
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"ecom_center_tab_cid1:41:0.0436,viking_ecom_center_tab_cid1:58:2.18267,viking_ecom_center_guess_u_like_recall:168:0.63693\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":2.182668924331665,\"viking_ecom_center_guess_u_like_recall\":0.6369298696517944,\"sim_id\":3472170199409653839,\"leaf_ctg\":28264,\"ctg1\":20104,\"pred_ctg1\":20104,\"pred_leaf_ctg\":28264,\"predict_score\":0.8240416646003723,\"product_click\":0.009156018495559693,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.011102885007858277,\"rough_cvr\":0.012096434831619265},\"channel_id\":1111818,\"mix\":{\"ctr\":0.009156018495559693,\"cvr\":0.0,\"nctr\":0.14877709992932437,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":5,\"tab_id\":1,\"page_num\":1,\"pctr\":0.008880853652954102,\"pcvr\":0.0083598792552948,\"pre\":0.04083538055419922,\"mix_score\":0.0984601080417633,\"price\":9}}",
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"icon_name": "",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141923408"
					},
					"product_id": "3449291616739793026",
					"has_sec_kill": false
				},
				"user": {
					"id": "63633679866",
					"avatar": {
						"uri": "100x100\/tos-cn-avt-0015\/093fca184bc1684344fb2da3e077c739",
						"url_list": [
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-avt-0015\/093fca184bc1684344fb2da3e077c739~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/img\/tos-cn-avt-0015\/093fca184bc1684344fb2da3e077c739~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-avt-0015\/093fca184bc1684344fb2da3e077c739~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "正宗川渝特产",
					"is_followed": false
				},
				"type": 2
			},
			{
				"type": 2,
				"product": {
					"price": {
						"min_price": 6900,
						"max_price": 0,
						"market_price": 9900
					},
					"biz_kind": 0,
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"product_id": "3415593465797555572",
					"sales": 34553,
					"kol_id": "83171853163",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141923648"
					},
					"promotion_id": "3415593465797555572",
					"rec_reason": {
						"content": ""
					},
					"icon_name": "",
					"sec_kol_id": "MS4wLjABAAAAUafBU386PVpsBsX6qEZ3fkdIYx_0UtvV31-JQXepNYk",
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_tab_cid1:29:3.11973\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":3.119725227355957,\"sim_id\":3415593465797555572,\"leaf_ctg\":20363,\"ctg1\":20017,\"pred_ctg1\":20017,\"pred_leaf_ctg\":20363,\"predict_score\":0.7961654663085938,\"product_click\":0.008846282958984375,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.010042041540145874,\"rough_cvr\":0.004227697849273682},\"channel_id\":1111818,\"mix\":{\"ctr\":0.008846282958984375,\"cvr\":0.0,\"nctr\":0.14058381085469333,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":6,\"tab_id\":1,\"page_num\":1,\"pctr\":0.008061068132519722,\"pcvr\":0.009094052016735077,\"pre\":0.04083535820245743,\"mix_score\":0.09403085708618164,\"price\":69}}",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/8ee11c4c9b9368b289151e2366107292www1080-1440~500x0.image"
						]
					},
					"title": "【阿亮亮】宣城农家自产葛根粉 无添加 1斤装",
					"has_sec_kill": false
				},
				"user": {
					"id": "83171853163",
					"avatar": {
						"url_list": [
							"https:\/\/p3.douyinpic.com\/aweme\/100x100\/310ac0000a0eea296b916.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/aweme\/100x100\/310ac0000a0eea296b916.jpeg?from=4010531038",
							"https:\/\/p6.douyinpic.com\/aweme\/100x100\/310ac0000a0eea296b916.jpeg?from=4010531038"
						],
						"uri": "100x100\/310ac0000a0eea296b916"
					},
					"nickname": "阿亮亮农原",
					"is_followed": false
				}
			},
			{
				"type": 2,
				"product": {
					"sec_kol_id": "MS4wLjABAAAAbfbFfmRwfiYoC9GKIPuzza1dY3RxhzvQQiHL_epv5xg",
					"promotion_id": "3435560794895563569",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"ecom_center_tab_cid1:10:0.0477,viking_ecom_center_tab_cid1:20:3.60507,viking_ecom_center_guess_u_like_recall:43:0.661644\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":3.605071783065796,\"viking_ecom_center_guess_u_like_recall\":0.6616437435150147,\"sim_id\":3481272972801648235,\"leaf_ctg\":23376,\"ctg1\":20018,\"pred_ctg1\":20018,\"pred_leaf_ctg\":23376,\"predict_score\":1.0689380168914796,\"product_click\":0.011877089738845826,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.011077135801315308,\"rough_cvr\":0.004163026809692383},\"channel_id\":1111818,\"mix\":{\"ctr\":0.011877089738845826,\"cvr\":0.0,\"nctr\":0.22133412016605545,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":7,\"tab_id\":1,\"page_num\":1,\"pctr\":0.011138349771499634,\"pcvr\":0.008683383464813233,\"pre\":0.04083538055419922,\"mix_score\":0.12579357624053956,\"price\":24}}",
					"biz_kind": 0,
					"product_id": "3435560794895563569",
					"title": "德国trolli口力橡皮糖恶搞怪爆浆眼珠糖眼睛眼球地球软糖糖果90g",
					"kol_id": "63834895830",
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"price": {
						"min_price": 2490,
						"max_price": 0,
						"market_price": 22120
					},
					"has_sec_kill": false,
					"icon_name": "",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/3e58d1ec13c911b8e305eee60df9cd8bwww800-800~500x0.image"
						]
					},
					"rec_reason": {
						"content": ""
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141923888"
					},
					"sales": 417,
					"commodity_type": 6
				},
				"user": {
					"avatar": {
						"url_list": [
							"https:\/\/p29.douyinpic.com\/aweme\/100x100\/2d0900006094f6d500306.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/aweme\/100x100\/2d0900006094f6d500306.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/aweme\/100x100\/2d0900006094f6d500306.jpeg?from=4010531038"
						],
						"uri": "100x100\/2d0900006094f6d500306"
					},
					"nickname": "Trolli口力",
					"is_followed": false,
					"id": "63834895830"
				}
			},
			{
				"type": 2,
				"product": {
					"product_icon": {
						"uri": "",
						"url_list": [
							""
						],
						"width": 42,
						"height": 14
					},
					"icon_name": "",
					"rec_reason": {
						"content": ""
					},
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/b8b7fd959a4ce8dad6afb1fefe709d65www800-800~500x0.image"
						],
						"uri": ""
					},
					"price": {
						"min_price": 980,
						"max_price": 3980,
						"market_price": 4800
					},
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"order_homepage\",\"reason\":\"viking_ecom_center_tab_cid1:114:1.2155,viking_ecom_center_guess_u_like_recall:340:0.618825\",\"is_new\":-1,\"last_impr\":0,\"viking_ecom_center_tab_cid1\":1.2154951095581058,\"viking_ecom_center_guess_u_like_recall\":0.6188252568244934,\"sim_id\":3479198641011465334,\"leaf_ctg\":28262,\"ctg1\":20104,\"pred_ctg1\":20104,\"pred_leaf_ctg\":28262,\"predict_score\":0.724622905254364,\"product_click\":0.008051365613937378,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.007714062929153442,\"rough_cvr\":0.022219717502593999},\"channel_id\":1111818,\"mix\":{\"ctr\":0.008051365613937378,\"cvr\":0.0,\"nctr\":0.12008703435792735,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":8,\"tab_id\":1,\"page_num\":1,\"pctr\":0.007134854793548584,\"pcvr\":0.026404261589050294,\"pre\":0.04083538055419922,\"mix_score\":0.09583932161331177,\"price\":9}}",
					"product_id": "3479198641011465334",
					"sales": 240,
					"kol_id": "4116212430407230",
					"biz_kind": 0,
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=825141924128"
					},
					"title": "康师傅方便面整箱装24袋好滋味红烧牛肉面老坛酸菜混搭袋装泡面",
					"sec_kol_id": "MS4wLjABAAAAbFGGLRfSfg0SrbLhtLaL4TNHIXCrqVknkzlxlRmqyU05hrSVsB2vh2jaDqFAD1rH",
					"promotion_id": "3479198641011465334",
					"commodity_type": 6,
					"has_sec_kill": true
				},
				"user": {
					"id": "4116212430407230",
					"avatar": {
						"uri": "https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/mosaic-legacy\/3791\/5035712059~120x256.image",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/mosaic-legacy\/3791\/5035712059~120x256.image"
						]
					},
					"nickname": "惠州市造物者实业有限公司",
					"is_followed": false
				}
			},
			{
				"type": 1,
				"live": {
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/webcast\/6748671213339478787~tplv-resize:500:0.image"
						]
					},
					"total_number": 5609,
					"uid": "989205094214780",
					"sec_uid": "MS4wLjABAAAA79koLybPa_29UZmTjlJKSbUlzrxxVpKWeiaXKCMbPCI",
					"product_count": 3,
					"stream_data": "{\"common\":{\"session_id\":\"000-2021062609170301021216416722198618\",\"rule_ids\":\"{\\\"sched\\\":\\\"{\\\\\\\"result\\\\\\\":{\\\\\\\"hit\\\\\\\":\\\\\\\"default\\\\\\\",\\\\\\\"cdn\\\\\\\":191}}\\\",\\\"schedParam\\\":\\\"\\\",\\\"sdkParams\\\":\\\"{\\\\\\\"ids\\\\\\\":[\\\\\\\"origin_df_1504(Weight:100)\\\\\\\",\\\\\\\"md_df_1504(Weight:100)\\\\\\\",\\\\\\\"or4_df_1504(Weight:100)\\\\\\\",\\\\\\\"hd_df_1504(Weight:100)\\\\\\\",\\\\\\\"sd_df_1504(Weight:100)\\\\\\\",\\\\\\\"hd5_df_1504(Weight:100)\\\\\\\",\\\\\\\"sd5_df_1504(Weight:100)\\\\\\\",\\\\\\\"ld_df_1504(Weight:100)\\\\\\\",\\\\\\\"ld5_df_1504(Weight:100)\\\\\\\",\\\\\\\"zhd_df_1504(Weight:100)\\\\\\\",\\\\\\\"zsd_df_1504(Weight:100)\\\\\\\",\\\\\\\"zld_df_1504(Weight:100)\\\\\\\",\\\\\\\"zhd5_df_1504(Weight:100)\\\\\\\",\\\\\\\"zsd5_df_1504(Weight:100)\\\\\\\",\\\\\\\"zld5_df_1504(Weight:100)\\\\\\\"]}\\\"}\"},\"data\":{\"ld\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/stage\/stream-685490256102817937_ld.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/stage\/stream-685490256102817937_ld.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"http:\/\/pull-lls-l11.douyincdn.com\/stage\/stream-685490256102817937_ld.sdp\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"480x847\\\",\\\"vbitrate\\\":1000000}\"}},\"origin\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/stage\/stream-685490256102817937_or4.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/stage\/stream-685490256102817937_or4.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"http:\/\/pull-lls-l11.douyincdn.com\/stage\/stream-685490256102817937_or4.sdp\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":25,\\\"resolution\\\":\\\"\\\",\\\"vbitrate\\\":0}\"}}}}",
					"live_icon": {
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/fylmmlqeh7nupanuhog\/people_icon.png",
							"https:\/\/lf9-static.bytednsdoc.com\/obj\/eden-cn\/fylmmlqeh7nupanuhog\/people_icon.png",
							"https:\/\/lf26-static.bytednsdoc.com\/obj\/eden-cn\/fylmmlqeh7nupanuhog\/people_icon.png"
						],
						"width": 12,
						"height": 12
					},
					"live_description": "62",
					"room_id": "6977887651831548707",
					"number": 62,
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/1a8451d944a84288bbcdb988bbe477bb",
						"url_list": [
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/1a8451d944a84288bbcdb988bbe477bb~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/1a8451d944a84288bbcdb988bbe477bb~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/1a8451d944a84288bbcdb988bbe477bb~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nick_name": "依线牵",
					"link": {
						"live": "sslocal:\/\/webcast_room?room_id=6977887651831548707&user_id=989205094214780",
						"live_with_product": "sslocal:\/\/webcast_room?room_id=6977887651831548707&user_id=989205094214780&pop_type=ecom_list_panel&ecom_live_params=%7B%22product_id%22%3A%223345405086783380272%22%2C%22pop_goods_detail%22%3A1%2C%22should_not_show_panel%22%3A1%7D"
					},
					"status": 2,
					"title": "欢迎来到依线牵直播间"
				},
				"product": {
					"recommend_info": "{\"live\":{\"rough_predict_score\":625.0,\"preclk\":0.004757553339004517,\"pctr\":0.013305217027664185,\"cvr\":2.980232238769531e-7,\"price\":43.32482147216797,\"reason\":\"lecr:67:60\",\"live_ctg1\":20004},\"ecom_center_live\":{\"is_new\":-1},\"channel_id\":1111818,\"req_id\":\"2021062609170301021216416722198618\",\"mix\":{\"ctr\":0.004757553339004517,\"cvr\":3.965263672967012e-9,\"nctr\":0.23692145263340853,\"ncvr\":0.000029513111978378434,\"ctmn\":\"chandler_ecom_din_ctr_center_r777559_0\",\"cvmn\":\"chandler_ecom_din_ctr_center_r777559_0\",\"pos\":9,\"tab_id\":1,\"page_num\":1,\"pctr\":0.007544457912445068,\"pcvr\":0.0028589367866516115,\"pre\":0.014823436737060547,\"mix_score\":0.07901587337255478,\"price\":43}}",
					"rec_reason": [],
					"product_id": "3345405086783380272",
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/Fsuday6QCJeaVZ0aDgY1aEEPTprcwww800-800~500x0.image"
						]
					},
					"title": "高山绿茶125g",
					"price": {
						"min_price": 4980,
						"market_price": 9800
					},
					"promotion_id": "3345405086783380272",
					"commodity_type": 6
				}
			}
		],
		"cursor": -1,
		"ab": {
			"live_show_total_number": false,
			"live_autoplay": true,
			"video_autoplay": true
		},
		"tabs": null,
		"extra": {
			"now": 1624670224000,
			"fatal_item_ids": [],
			"logid": "2021062609170301021216416722198618"
		}
	}
}
```


