# 抖音商城好物秒杀接口，抖音API接口数据采集教程



## 抖音商城新品接口

### 请求Api
```http
http://主机地址/douyin/commerce/new_product?token=xxx&cursor=0

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
		"feed": [
			{
				"type": 2,
				"product": {
					"product_id": "3478252528360121662",
					"title": "【月亮补贴】爱贝迪拉儿童防走失带宝宝防走丢两用防丢溜娃神器",
					"has_sec_kill": false,
					"sec_kol_id": "MS4wLjABAAAAsvtk8Kc1GwaVOFqWJrBmCndq6NwPZHHoODvUZUynNmo",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/e38fa64f133668df73b5b426ce13d91da3a92540www800-800~500x0.image"
						]
					},
					"sales": 205,
					"price": {
						"min_price": 990,
						"max_price": 1900,
						"market_price": 3500
					},
					"kol_id": "984790830423607",
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:1414:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3478252528360121662,\"leaf_ctg\":21401,\"ctg1\":20068,\"pred_ctg1\":20068,\"pred_leaf_ctg\":26575,\"predict_score\":0.6275537610054016,\"product_click\":0.006972819566726685,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.010116517543792725,\"rough_cvr\":0.020248085260391237},\"channel_id\":1111820,\"mix\":{\"ctr\":0.006972819566726685,\"cvr\":0.0,\"nctr\":0.09311445124325608,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":0,\"tab_id\":0,\"page_num\":1,\"pctr\":0.0061251819133758549,\"pcvr\":0.06487768888473511,\"pre\":0.03938063979148865,\"mix_score\":0.11291221529245377,\"price\":9}}",
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"product_icon": {
						"uri": "https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png",
						"url_list": [
							"https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png"
						],
						"width": 42,
						"height": 14
					},
					"icon_name": "main_new_arrival",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790026608"
					},
					"promotion_id": "3478252528360121662",
					"biz_kind": 0
				},
				"user": {
					"id": "984790830423607",
					"avatar": {
						"url_list": [
							"https:\/\/p26.douyinpic.com\/img\/tos-cn-i-0813\/92cc01f273fe4512b7c538db298e9a8c~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/92cc01f273fe4512b7c538db298e9a8c~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-i-0813\/92cc01f273fe4512b7c538db298e9a8c~c5_100x100.jpeg?from=4010531038"
						],
						"uri": "100x100\/tos-cn-i-0813\/92cc01f273fe4512b7c538db298e9a8c"
					},
					"nickname": "爱贝迪拉宝贝爱上刷牙（每天直播送福利）",
					"is_followed": false
				}
			},
			{
				"type": 2,
				"product": {
					"has_sec_kill": false,
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:1928:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3488268931213436787,\"leaf_ctg\":20472,\"ctg1\":20025,\"pred_ctg1\":20025,\"pred_leaf_ctg\":23982,\"predict_score\":0.5132138729095459,\"product_click\":0.005702376365661621,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.011253446340560912,\"rough_cvr\":0.007644683122634888},\"channel_id\":1111820,\"mix\":{\"ctr\":0.005702376365661621,\"cvr\":0.0,\"nctr\":0.06349999922462577,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":1,\"tab_id\":0,\"page_num\":1,\"pctr\":0.005668641999363899,\"pcvr\":0.03699382394552231,\"pre\":0.03938068449497223,\"mix_score\":0.08492127805948258,\"price\":12}}",
					"product_icon": {
						"height": 14,
						"uri": "https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png",
						"url_list": [
							"https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png"
						],
						"width": 42
					},
					"kol_id": "3096639099110029",
					"promotion_id": "3485275643774638999",
					"icon_name": "main_new_arrival",
					"product_id": "3485275643774638999",
					"price": {
						"min_price": 1280,
						"max_price": 0,
						"market_price": 2580
					},
					"sec_kol_id": "MS4wLjABAAAA8y7Ug8Nns3p3indCRRgs4gumfij8esIJxbm0PvxnALSUrc3kdOgRj7YF0yWpxRS9",
					"rec_reason": {
						"content": "",
						"type": 99
					},
					"biz_kind": 0,
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/74df951746840aca6c1a42e2a3f85bbcwww750-1000~500x0.image"
						]
					},
					"title": "Disney\/迪士尼儿童万花筒多棱镜益智玩具",
					"sales": 67,
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790026848"
					}
				},
				"user": {
					"nickname": "联众文具官方账号",
					"is_followed": false,
					"id": "3096639099110029",
					"avatar": {
						"url_list": [
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/74d4b6551bb64df0bd85fb27555dfdd9~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/img\/tos-cn-i-0813\/74d4b6551bb64df0bd85fb27555dfdd9~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/74d4b6551bb64df0bd85fb27555dfdd9~c5_100x100.jpeg?from=4010531038"
						],
						"uri": "100x100\/tos-cn-i-0813\/74d4b6551bb64df0bd85fb27555dfdd9"
					}
				}
			},
			{
				"product": {
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/cbc769ce35b99fe8da782f04d0721e09www800-800~500x0.image"
						]
					},
					"title": "Keep 户外超轻空顶帽",
					"commodity_type": 6,
					"product_id": "3486981209848981066",
					"has_sec_kill": false,
					"sec_kol_id": "MS4wLjABAAAACrmFb8z6tkoH1e4eZnpmddUoOMprctwO4lMyKS05NPw",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:157:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3486981209848981066,\"leaf_ctg\":20852,\"ctg1\":20052,\"pred_ctg1\":20052,\"pred_leaf_ctg\":20852,\"predict_score\":0.6752112507820129,\"product_click\":0.007502347230911255,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.00930294394493103,\"rough_cvr\":0.008189737796783448},\"channel_id\":1111820,\"mix\":{\"ctr\":0.007502347230911255,\"cvr\":0.0,\"nctr\":0.10622954129094091,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":2,\"tab_id\":0,\"page_num\":1,\"pctr\":0.007084459066390991,\"pcvr\":0.0105648934841156,\"pre\":0.03938063979148865,\"mix_score\":0.08436356484889984,\"price\":65}}",
					"sales": 278,
					"price": {
						"min_price": 9900,
						"max_price": 0,
						"market_price": 0
					},
					"kol_id": "60091455189",
					"promotion_id": "3486981209848981066",
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"biz_kind": 0,
					"product_icon": {
						"uri": "https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png",
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
						],
						"width": 30,
						"height": 16
					},
					"icon_name": "brand_shop",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790027104"
					}
				},
				"user": {
					"avatar": {
						"uri": "100x100\/310cc0007de38be13c902",
						"url_list": [
							"https:\/\/p26.douyinpic.com\/aweme\/100x100\/310cc0007de38be13c902.jpeg?from=4010531038",
							"https:\/\/p6.douyinpic.com\/aweme\/100x100\/310cc0007de38be13c902.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/aweme\/100x100\/310cc0007de38be13c902.jpeg?from=4010531038"
						]
					},
					"nickname": "Keep",
					"is_followed": false,
					"id": "60091455189"
				},
				"type": 2
			},
			{
				"type": 3,
				"activity": {
					"activity_id": "",
					"cover": {
						"url_list": [
							"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/16246172770678e76e79ca884cb212928f14c5b4be0d254a74.png"
						]
					},
					"url": "sslocal:\/\/webcast_lynxview\/?url=https%3A%2F%2Flf6-sourcecdn-tos.pstatp.com%2Fobj%2Fbyte-gurd-source%2Fecom%2Flynx%2Fcommon%2Ffe_lynx_commerce_product_rank%2Fapp%2Ftemplate.js%3Ftype=fullscreen&use_taro=0&load_taro=0&hide_nav_bar=1&status_bar_bg_color=ffffff&hide_status_bar=0&trans_status_bar=1&web_bg_color=ffffff&rank_id=6971699856322625800",
					"direct": true
				}
			},
			{
				"type": 2,
				"product": {
					"sec_kol_id": "MS4wLjABAAAAERNRa3jCMptFwY9bvSLZZ1WrdyPUK7Z53t5fjCZjYeY",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790027344"
					},
					"title": "{天一轻食专属}诺特兰德多维维生素片 60片\/72g",
					"kol_id": "101825365295",
					"has_sec_kill": false,
					"promotion_id": "3486455916004554496",
					"rec_reason": {
						"content": "",
						"type": 99
					},
					"biz_kind": 0,
					"product_id": "3486455916004554496",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/46e5c5daee489e53ddd8dd194503e0b0www800-800~500x0.image"
						]
					},
					"icon_name": "brand_shop",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:951:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3487516197417798771,\"leaf_ctg\":31281,\"ctg1\":20109,\"pred_ctg1\":20109,\"pred_leaf_ctg\":31998,\"predict_score\":0.6133058667182922,\"product_click\":0.006814509630203247,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.0075953006744384769,\"rough_cvr\":0.018562495708465577},\"channel_id\":1111820,\"mix\":{\"ctr\":0.006814509630203247,\"cvr\":0.0,\"nctr\":0.08931355921439159,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":3,\"tab_id\":0,\"page_num\":1,\"pctr\":0.006669133901596069,\"pcvr\":0.012576788663864136,\"pre\":0.03938063979148865,\"mix_score\":0.07918804883956909,\"price\":24}}",
					"product_icon": {
						"width": 30,
						"height": 16,
						"uri": "https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png",
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
						]
					},
					"commodity_type": 6,
					"sales": 500,
					"price": {
						"min_price": 2490,
						"max_price": 3900,
						"market_price": 9900
					}
				},
				"user": {
					"avatar": {
						"uri": "100x100\/9bb7000466b44703a8ef",
						"url_list": [
							"https:\/\/p3.douyinpic.com\/aweme\/100x100\/9bb7000466b44703a8ef.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/aweme\/100x100\/9bb7000466b44703a8ef.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/aweme\/100x100\/9bb7000466b44703a8ef.jpeg?from=4010531038"
						]
					},
					"nickname": "诺特兰德",
					"is_followed": false,
					"id": "101825365295"
				}
			},
			{
				"type": 2,
				"product": {
					"commodity_type": 6,
					"product_icon": {
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
						],
						"width": 30,
						"height": 16,
						"uri": "https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
					},
					"price": {
						"min_price": 3580,
						"max_price": 0,
						"market_price": 19200
					},
					"sec_kol_id": "MS4wLjABAAAAf8hbjRf_ZGNo40dW5SPnogskNMQB52dNJer4OEZJTn4fWORrXwnJXDf5Hjqv400b",
					"kol_id": "2375395286976791",
					"promotion_id": "3478650141400008021",
					"icon_name": "brand_shop",
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790027600"
					},
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/582a0317499400087ef71946be008b2594f73ea4www750-1000~500x0.image"
						]
					},
					"has_sec_kill": false,
					"sales": 8,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:630:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3478650141400008021,\"leaf_ctg\":26861,\"ctg1\":20072,\"pred_ctg1\":20072,\"pred_leaf_ctg\":26861,\"predict_score\":0.5542945861816406,\"product_click\":0.006158828735351563,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.009372204542160036,\"rough_cvr\":0.009450674057006836},\"channel_id\":1111820,\"mix\":{\"ctr\":0.0061588287353515629,\"cvr\":0.0,\"nctr\":0.0737885510752802,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":4,\"tab_id\":0,\"page_num\":1,\"pctr\":0.006126761436462402,\"pcvr\":0.015345662832260132,\"pre\":0.03938063979148865,\"mix_score\":0.07623178511857987,\"price\":35}}",
					"product_id": "3478650141400008021",
					"title": "朴西大理石凉拖鞋",
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"biz_kind": 0
				},
				"user": {
					"avatar": {
						"uri": "100x100\/douyin-user-file\/4a18811746b8017afc2b79e201255cdd",
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/douyin-user-file\/4a18811746b8017afc2b79e201255cdd~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/douyin-user-file\/4a18811746b8017afc2b79e201255cdd~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/douyin-user-file\/4a18811746b8017afc2b79e201255cdd~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "朴西母婴旗舰店",
					"is_followed": false,
					"id": "2375395286976791"
				}
			},
			{
				"type": 1,
				"live": {
					"room_id": "6977885004424629029",
					"status": 2,
					"uid": "105265941216",
					"sec_uid": "MS4wLjABAAAA9iovmBfz6-M5mFEzoPCBw459vPawk3DvZnyDemsEdfc",
					"title": "荣耀50开售！#新品荣耀50系列#",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/48825c3098df446b83f7ac8e4bd094a7",
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/48825c3098df446b83f7ac8e4bd094a7~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/48825c3098df446b83f7ac8e4bd094a7~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-i-0813\/48825c3098df446b83f7ac8e4bd094a7~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nick_name": "荣耀官方直播间",
					"product_count": 64,
					"total_number": 42265,
					"stream_data": "{\"common\":{\"session_id\":\"000-202106260938530101511921514A142951\",\"rule_ids\":\"{\\\"sched\\\":\\\"{\\\\\\\"result\\\\\\\":{\\\\\\\"hit\\\\\\\":\\\\\\\"default\\\\\\\",\\\\\\\"cdn\\\\\\\":538}}\\\",\\\"schedParam\\\":\\\"\\\",\\\"sdkParams\\\":\\\"{\\\\\\\"ids\\\\\\\":[]}\\\"}\"},\"data\":{\"hd\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/third\/stream-109029462998254044_hd.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/third\/stream-109029462998254044_hd.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"720x1280\\\",\\\"vbitrate\\\":4000000}\"}},\"sd\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/third\/stream-109029462998254044_sd.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/third\/stream-109029462998254044_sd.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"720x1280\\\",\\\"vbitrate\\\":2000000}\"}},\"ld\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/third\/stream-109029462998254044_ld.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/third\/stream-109029462998254044_ld.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"540x960\\\",\\\"vbitrate\\\":1000000}\"}},\"origin\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/third\/stream-109029462998254044_or4.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/third\/stream-109029462998254044_or4.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":25,\\\"resolution\\\":\\\"\\\",\\\"vbitrate\\\":0}\"}},\"uhd\":{\"main\":{\"flv\":\"http:\/\/pull-flv-l11.douyincdn.com\/third\/stream-109029462998254044_uhd.flv\",\"hls\":\"http:\/\/pull-hls-l11.douyincdn.com\/third\/stream-109029462998254044_uhd.m3u8\",\"cmaf\":\"\",\"dash\":\"\",\"lls\":\"\",\"tsl\":\"\",\"sdk_params\":\"{\\\"VCodec\\\":\\\"h264\\\",\\\"gop\\\":4,\\\"resolution\\\":\\\"1080x1920\\\",\\\"vbitrate\\\":6000000}\"}}}}",
					"number": 466,
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/webcast\/6976238951506037540~tplv-resize:500:0.image"
						]
					},
					"link": []
				},
				"product": {
					"title": "荣耀手机",
					"price": {
						"market_price": 269900,
						"min_price": 239900
					},
					"promotion_id": "3486449638926595496",
					"commodity_type": 6,
					"recommend_info": "{\"live\":{\"rough_predict_score\":0.2584729153482827,\"preclk\":0.006411954760551453,\"pctr\":0.06892428547143936,\"cvr\":0.0002833982289303094,\"price\":305.8804016113281,\"reason\":\"laear:34:1.62467e+09\",\"live_ctg1\":20000},\"ecom_center_live\":{\"is_new\":-1},\"channel_id\":1111820,\"req_id\":\"202106260938530101511921514A142951\",\"mix\":{\"ctr\":0.0,\"cvr\":0.0,\"nctr\":0.0,\"ncvr\":0.0,\"ctmn\":\"\",\"cvmn\":\"\",\"pos\":5,\"tab_id\":0,\"page_num\":1,\"pctr\":0.0051081180572509769,\"pcvr\":0.004506528377532959,\"pre\":0.01913723349571228,\"mix_score\":0.05338316783308983,\"price\":0}}",
					"product_id": "3486449638926595496",
					"cover": {
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/f1c8fcd71deeb0ffca9938c3d619b4dfwww800-800~500x0.image"
						]
					}
				}
			},
			{
				"type": 2,
				"product": {
					"sales": 20,
					"price": {
						"market_price": 72900,
						"min_price": 41900,
						"max_price": 0
					},
					"kol_id": "4292091693785975",
					"rec_reason": {
						"content": "",
						"type": 99
					},
					"title": "adidas 夏季男士运动涉水鞋 Q21031 S77946",
					"promotion_id": "3488264599797676999",
					"biz_kind": 0,
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790028048"
					},
					"product_id": "3488264599797676999",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/a3863d516b2851f6f6d51f69bf8420e7www800-800~500x0.image"
						]
					},
					"sec_kol_id": "MS4wLjABAAAAeTK16BeX2ODRR13MwaHp2SiCnfAJ7ihixWC56ODtbl4IEGpAXz7nEpPBXl3f9MiQ",
					"commodity_type": 6,
					"has_sec_kill": false,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:1541:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3488264599797676999,\"leaf_ctg\":20799,\"ctg1\":20046,\"pred_ctg1\":20046,\"pred_leaf_ctg\":20716,\"predict_score\":0.7179495692253113,\"product_click\":0.007977217435836792,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.013661235570907593,\"rough_cvr\":0.0012440979480743409},\"channel_id\":1111820,\"mix\":{\"ctr\":0.007977217435836792,\"cvr\":0.0,\"nctr\":0.11819281343791328,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":6,\"tab_id\":0,\"page_num\":1,\"pctr\":0.007318437099456787,\"pcvr\":0.0009391307830810547,\"pre\":0.03938063979148865,\"mix_score\":0.07527852803468704,\"price\":419}}",
					"product_icon": {
						"uri": "https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png",
						"url_list": [
							"https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png"
						],
						"width": 42,
						"height": 14
					},
					"icon_name": "main_new_arrival"
				},
				"user": {
					"id": "4292091693785975",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/2231ea12c23a4dbf968449611547df17",
						"url_list": [
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/2231ea12c23a4dbf968449611547df17~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/img\/tos-cn-i-0813\/2231ea12c23a4dbf968449611547df17~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/2231ea12c23a4dbf968449611547df17~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "@阿迪达斯adidas思墨运动鞋服",
					"is_followed": false
				}
			},
			{
				"type": 3,
				"activity": {
					"activity_id": "",
					"cover": {
						"url_list": [
							"https:\/\/sf6-ttcdn-tos.pstatp.com\/obj\/temai\/1624617236588b69a17367e012ed0b8838305fd6e521ddec9e.png"
						]
					},
					"url": "sslocal:\/\/webcast_lynxview\/?url=https%3A%2F%2Flf6-sourcecdn-tos.pstatp.com%2Fobj%2Fbyte-gurd-source%2Fecom%2Flynx%2Fcommon%2Ffe_lynx_commerce_product_rank%2Fapp%2Ftemplate.js%3Ftype=fullscreen&use_taro=0&load_taro=0&hide_nav_bar=1&status_bar_bg_color=ffffff&hide_status_bar=0&trans_status_bar=1&web_bg_color=ffffff&rank_id=6971091929694011679",
					"direct": true
				}
			},
			{
				"user": {
					"id": "14357720850",
					"avatar": {
						"uri": "100x100\/2ddea00075f18c9d577f7",
						"url_list": [
							"https:\/\/p29.douyinpic.com\/aweme\/100x100\/2ddea00075f18c9d577f7.jpeg?from=4010531038",
							"https:\/\/p6.douyinpic.com\/aweme\/100x100\/2ddea00075f18c9d577f7.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/aweme\/100x100\/2ddea00075f18c9d577f7.jpeg?from=4010531038"
						]
					},
					"nickname": "UGREEN绿联",
					"is_followed": false
				},
				"type": 2,
				"product": {
					"product_id": "3477822466850734857",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf1-ttcdn-tos.pstatp.com\/img\/temai\/f3ec3b3a396cae6320197f3b3ef710043ad14629www800-800~500x0.image"
						]
					},
					"coupons": [
						{
							"tag": "满138减10",
							"coupon_meta_id": "6975851832216469763",
							"tag_header": "",
							"type": 2
						}
					],
					"commodity_type": 6,
					"product_icon": {
						"uri": "https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png",
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
						],
						"width": 30,
						"height": 16
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790028288"
					},
					"has_sec_kill": false,
					"kol_id": "14357720850",
					"promotion_id": "3477822466850734857",
					"biz_kind": 0,
					"icon_name": "brand_shop",
					"title": "绿联 移动硬盘盒2.5英寸 Type-C USB3.0 SATA串口笔记本台式外置",
					"price": {
						"max_price": 7900,
						"market_price": 9900,
						"min_price": 4900
					},
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:676:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3487188126164750574,\"leaf_ctg\":20143,\"ctg1\":20000,\"pred_ctg1\":20098,\"pred_leaf_ctg\":28120,\"predict_score\":0.5205550789833069,\"product_click\":0.005783945322036743,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.014040112495422364,\"rough_cvr\":0.002582639455795288},\"channel_id\":1111820,\"mix\":{\"ctr\":0.005783945322036743,\"cvr\":0.0,\"nctr\":0.06532384080612297,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":7,\"tab_id\":0,\"page_num\":1,\"pctr\":0.005946040153503418,\"pcvr\":0.007768183946609497,\"pre\":0.03938063979148865,\"mix_score\":0.06731268763542175,\"price\":49}}",
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"sales": 26,
					"sec_kol_id": "MS4wLjABAAAAPBken3scyD-Vx3KTBEwuiXFnKLtbWe3GzxAzHs9uOnk"
				}
			},
			{
				"type": 2,
				"product": {
					"kol_id": "4152199042307454",
					"commodity_type": 6,
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"title": "Gree\/格力遥控电风扇家用低噪塔式落地扇新品塔扇 FL-08X61Bg",
					"has_sec_kill": false,
					"biz_kind": 0,
					"cover": {
						"url_list": [
							"https:\/\/sf6-ttcdn-tos.pstatp.com\/img\/temai\/abdea28656b12d982fcf32e76902749962b00a38www547-546~500x0.image"
						],
						"uri": ""
					},
					"sec_kol_id": "MS4wLjABAAAA1CDAoD3tTNmtFyQrthzMl2XP3DNZC6pcSzMOjqb8dnX0GaEo6DzKEj22MvBumP8x",
					"promotion_id": "3476560916575878975",
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:770:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3486587043553932169,\"leaf_ctg\":21145,\"ctg1\":20083,\"pred_ctg1\":20083,\"pred_leaf_ctg\":21145,\"predict_score\":0.5587953329086304,\"product_click\":0.006208837032318115,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.01286613941192627,\"rough_cvr\":0.0022419095039367677},\"channel_id\":1111820,\"mix\":{\"ctr\":0.006208837032318115,\"cvr\":0.0,\"nctr\":0.07496073043568802,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":8,\"tab_id\":0,\"page_num\":1,\"pctr\":0.005864202976226807,\"pcvr\":0.0024164915084838869,\"pre\":0.03938063979148865,\"mix_score\":0.06250946968793869,\"price\":299}}",
					"icon_name": "brand_shop",
					"product_id": "3476560916575878975",
					"sales": 34,
					"price": {
						"market_price": 59900,
						"min_price": 29900,
						"max_price": 0
					},
					"product_icon": {
						"uri": "https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png",
						"url_list": [
							"https:\/\/lf3-static.bytednsdoc.com\/obj\/eden-cn\/yhazeh7uhbfpsnupk\/feed\/brand_shop3.png"
						],
						"width": 30,
						"height": 16
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790028528"
					}
				},
				"user": {
					"id": "4152199042307454",
					"avatar": {
						"uri": "100x100\/tos-cn-i-0813\/dc444312b14146b6b50063ab5122bc83",
						"url_list": [
							"https:\/\/p29.douyinpic.com\/img\/tos-cn-i-0813\/dc444312b14146b6b50063ab5122bc83~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/dc444312b14146b6b50063ab5122bc83~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/img\/tos-cn-i-0813\/dc444312b14146b6b50063ab5122bc83~c5_100x100.jpeg?from=4010531038"
						]
					},
					"nickname": "格力生活电器旗舰店",
					"is_followed": false
				}
			},
			{
				"product": {
					"icon_name": "main_new_arrival",
					"cover": {
						"uri": "",
						"url_list": [
							"https:\/\/sf6-ttcdn-tos.pstatp.com\/img\/temai\/de2a8516f6631121778a30c4ff2014d0www1080-1080~500x0.image"
						]
					},
					"kol_id": "2897909445561412",
					"commodity_type": 6,
					"recommend_info": "{\"product\":{\"page_num\":1,\"page_name\":\"\",\"reason\":\"ecom_center_activity:674:1.62466e+09\",\"is_new\":-1,\"last_impr\":0,\"sim_id\":3484202619394753833,\"leaf_ctg\":25781,\"ctg1\":20053,\"pred_ctg1\":20053,\"pred_leaf_ctg\":25781,\"predict_score\":0.5634838342666626,\"product_click\":0.006260931491851807,\"product_buy\":0.0,\"order_submit\":0.0,\"rough_ctr\":0.012638479471206664,\"rough_cvr\":0.0009386539459228516},\"channel_id\":1111820,\"mix\":{\"ctr\":0.006260931491851807,\"cvr\":0.0,\"nctr\":0.07614204600509052,\"ncvr\":0.0,\"ctmn\":\"shop_center_product_predict_v33_r723190_0\",\"cvmn\":\"shop_center_product_predict_v33_r723190_0\",\"pos\":9,\"tab_id\":0,\"page_num\":1,\"pctr\":0.005866140127182007,\"pcvr\":0.0011613965034484864,\"pre\":0.03938063979148865,\"mix_score\":0.06134063005447388,\"price\":860}}",
					"rec_reason": {
						"type": 99,
						"content": ""
					},
					"sales": 2,
					"biz_kind": 0,
					"product_icon": {
						"uri": "https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png",
						"url_list": [
							"https:\/\/sf3-dycdn-tos.pstatp.com\/obj\/ecom-server\/aweme_main_new_arrival.png"
						],
						"width": 42,
						"height": 14
					},
					"product_id": "3485280288966338661",
					"title": "Fila\/斐乐体育有限公司FILA女士中长款连衣裙",
					"has_sec_kill": false,
					"sec_kol_id": "MS4wLjABAAAA0Wt7DFiKs-v7SR889EPHbg-x4y88KjOVGroyyYhwD_ZhcJKanIXtVl9IkWG-wPVr",
					"promotion_id": "3485280288966338661",
					"price": {
						"market_price": 98000,
						"min_price": 86000,
						"max_price": 0
					},
					"extra": {
						"similar_link": "https:\/\/ffh.jinritemai.com\/falcon\/e_commerce\/ecommerce_webcast_gaia\/pages\/centralization\/similar_find\/index.html?product_id=824790028768"
					}
				},
				"user": {
					"avatar": {
						"url_list": [
							"https:\/\/p6.douyinpic.com\/aweme\/100x100\/2fa1100005f9c83c01157.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/aweme\/100x100\/2fa1100005f9c83c01157.jpeg?from=4010531038",
							"https:\/\/p26.douyinpic.com\/aweme\/100x100\/2fa1100005f9c83c01157.jpeg?from=4010531038"
						],
						"uri": "100x100\/2fa1100005f9c83c01157"
					},
					"nickname": "青岛万象城斐乐FILA品牌中心店",
					"is_followed": false,
					"id": "2897909445561412"
				},
				"type": 2
			}
		],
		"cursor": -1,
		"ab": {
			"is_single_column": false
		},
		"extra": {
			"now": 1624671534000,
			"fatal_item_ids": [],
			"logid": "202106260938530101511921514A142951"
		},
		"log_pb": {
			"impr_id": "202106260938530101511921514A142951"
		}
	}
}
```


