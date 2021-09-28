
# 抖音直播间音浪榜接口，抖音直播数据抓取SDK，音浪榜前100名


**请求API：**

- `http://主机地址/douyin/liveroom/ranklist?token=xxx&room_id=6994259511469247263`

**请求方式：**

- GET

**参数：**

| 参数名 | 必选 | 类型 | 说明 |
| --- | --- | --- | --- |
| token | 是 | string | 接口授权码 |
| room_id | 是 | int | 直播间room_id |
| anchor_id | 否 | int | 主播uid，如果需要粉丝团数据，主播uid必传 |

 

**返回字段说明：**

| 字段 | 说明 |
| --- | --- |
| exactly_score | 打赏音浪数 |
| pay_grade -> level | 直播间用户等级 |
| pay_grade -> this_grade_max_diamond | 当前用户等级最大抖币数 |
| pay_grade -> grade_describe | 总支付抖币描述，如：距离13级还差35抖币 |
| fans_club | 粉丝团数据 |

**​**

**返回示例**
```json
{
	"code": 200,
	"msg": "成功",
	"data": {
		"data": {
			"ranks": [
				{
					"user": {
						"id": 98204909466,
						"short_id": 920536341,
						"nickname": "ddezf",
						"gender": 0,
						"signature": "",
						"level": 0,
						"birthday": 0,
						"telephone": "",
						"avatar_thumb": {
							"url_list": [
								"https:\/\/p3.douyinpic.com\/aweme\/100x100\/aweme-avatar\/mosaic-legacy_3796_2975850990.jpeg?from=4010531038",
								"https:\/\/p9.douyinpic.com\/aweme\/100x100\/aweme-avatar\/mosaic-legacy_3796_2975850990.jpeg?from=4010531038",
								"https:\/\/p6.douyinpic.com\/aweme\/100x100\/aweme-avatar\/mosaic-legacy_3796_2975850990.jpeg?from=4010531038"
							],
							"uri": "100x100\/aweme-avatar\/mosaic-legacy_3796_2975850990",
							"height": 0,
							"width": 0,
							"avg_color": "",
							"image_type": 0,
							"open_web_url": "",
							"is_animated": false
						},
						"verified": false,
						"experience": 0,
						"city": "",
						"status": 0,
						"create_time": 0,
						"modify_time": 0,
						"secret": 1,
						"share_qrcode_uri": "",
						"income_share_percent": 0,
						"badge_image_list": [],
						"follow_info": {
							"following_count": 0,
							"follower_count": 0,
							"follow_status": 0,
							"push_status": 0,
							"remark_name": ""
						},
						"pay_grade": {
							"total_diamond_count": 0,
							"name": "",
							"next_name": "",
							"level": 25,
							"next_diamond": 0,
							"now_diamond": 0,
							"this_grade_min_diamond": 15000,
							"this_grade_max_diamond": 20000,
							"pay_diamond_bak": 0,
							"grade_describe": "距离26级还差1998抖币",
							"grade_icon_list": [],
							"screen_chat_type": 0,
							"new_im_icon_with_level": {
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image"
								],
								"uri": "user_grade_level_v5_25.png",
								"height": 16,
								"width": 32,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							},
							"new_live_icon": {
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_25_29.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_25_29.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_25_29.png~tplv-obj.image"
								],
								"uri": "aweme_pay_grade_2x_25_29.png",
								"height": 12,
								"width": 12,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							},
							"upgrade_need_consume": 0,
							"next_privileges": "",
							"score": 0,
							"grade_banner": ""
						},
						"fans_club": {
							"data": {
								"club_name": "",
								"level": 0,
								"user_fans_club_status": 0,
								"badge": {
									"icons": [
										{
											"url_list": [],
											"uri": "",
											"height": 0,
											"width": 0,
											"avg_color": "",
											"image_type": 0,
											"open_web_url": "",
											"is_animated": false
										}
									],
									"title": ""
								},
								"available_gift_ids": [],
								"anchor_id": 0
							},
							"prefer_data": []
						},
						"special_id": "",
						"real_time_icons": [],
						"new_real_time_icons": [],
						"top_vip_no": 0,
						"pay_score": 0,
						"ticket_count": 0,
						"link_mic_stats": 0,
						"display_id": "920536341",
						"with_commerce_permission": false,
						"with_fusion_shop_entry": false,
						"total_recharge_diamond_count": 0,
						"verified_content": "",
						"top_fans": [],
						"sec_uid": "MS4wLjABAAAAGYwZdU382qFqJ9-EtVM5SJ8ZK5K-5NvsrZTGSb85WuQ",
						"user_role": 0,
						"authorization_info": 3,
						"adversary_authorization_info": 0,
						"media_badge_image_list": [],
						"adversary_user_status": 0,
						"commerce_webcast_config_ids": [],
						"badge_image_list_v2": [
							{
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_25.png~tplv-obj.image"
								],
								"uri": "user_grade_level_v5_25.png",
								"height": 16,
								"width": 32,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							}
						],
						"location_city": "",
						"remark_name": "",
						"mystery_man": 1,
						"web_rid": "",
						"desensitized_nickname": "",
						"allow_be_located": false,
						"allow_find_by_contacts": false,
						"allow_others_download_video": false,
						"allow_others_download_when_sharing_video": false,
						"allow_share_show_profile": false,
						"allow_show_in_gossip": false,
						"allow_show_my_action": false,
						"allow_strange_comment": false,
						"allow_unfollower_comment": false,
						"allow_use_linkmic": false,
						"bg_img_url": "",
						"birthday_description": "",
						"birthday_valid": false,
						"block_status": 0,
						"comment_restrict": 0,
						"constellation": "",
						"disable_ichat": 0,
						"enable_ichat_img": 0,
						"exp": 0,
						"fan_ticket_count": 0,
						"fold_stranger_chat": false,
						"follow_status": 0,
						"hotsoon_verified": false,
						"hotsoon_verified_reason": "",
						"ichat_restrict_type": 0,
						"id_str": "98204909466",
						"is_follower": false,
						"is_following": false,
						"need_profile_guide": false,
						"pay_scores": 0,
						"push_comment_status": false,
						"push_digg": false,
						"push_follow": false,
						"push_friend_action": false,
						"push_ichat": false,
						"push_status": false,
						"push_video_post": false,
						"push_video_recommend": false,
						"verified_mobile": false,
						"verified_reason": "",
						"with_car_management_permission": false
					},
					"score": 10001,
					"rank": 1,
					"gap_description": "1.0万",
					"delta": 0,
					"first_gift": false,
					"is_hidden": false,
					"score_description": "1.0万",
					"exactly_score": "1.0万"
				},
				{
					"user": {
						"id": 2955104372400333,
						"short_id": 3867649405,
						"nickname": "别扔鸡蛋砸我",
						"gender": 1,
						"signature": "",
						"level": 0,
						"birthday": 0,
						"telephone": "",
						"avatar_thumb": {
							"url_list": [
								"https:\/\/p3.douyinpic.com\/img\/tos-cn-i-0813\/3a39c7a231aa4c0d9efd2ad994123380~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p9.douyinpic.com\/img\/tos-cn-i-0813\/3a39c7a231aa4c0d9efd2ad994123380~c5_100x100.jpeg?from=4010531038",
								"https:\/\/p6.douyinpic.com\/img\/tos-cn-i-0813\/3a39c7a231aa4c0d9efd2ad994123380~c5_100x100.jpeg?from=4010531038"
							],
							"uri": "100x100\/tos-cn-i-0813\/3a39c7a231aa4c0d9efd2ad994123380",
							"height": 0,
							"width": 0,
							"avg_color": "",
							"image_type": 0,
							"open_web_url": "",
							"is_animated": false
						},
						"verified": false,
						"experience": 0,
						"city": "",
						"status": 0,
						"create_time": 0,
						"modify_time": 0,
						"secret": 0,
						"share_qrcode_uri": "",
						"income_share_percent": 0,
						"badge_image_list": [],
						"follow_info": {
							"following_count": 0,
							"follower_count": 0,
							"follow_status": 0,
							"push_status": 0,
							"remark_name": ""
						},
						"pay_grade": {
							"total_diamond_count": 0,
							"name": "",
							"next_name": "",
							"level": 20,
							"next_diamond": 0,
							"now_diamond": 0,
							"this_grade_min_diamond": 3800,
							"this_grade_max_diamond": 5000,
							"pay_diamond_bak": 0,
							"grade_describe": "距离21级还差324抖币",
							"grade_icon_list": [],
							"screen_chat_type": 0,
							"new_im_icon_with_level": {
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image"
								],
								"uri": "user_grade_level_v5_20.png",
								"height": 16,
								"width": 32,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							},
							"new_live_icon": {
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_20_24.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_20_24.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/aweme_pay_grade_2x_20_24.png~tplv-obj.image"
								],
								"uri": "aweme_pay_grade_2x_20_24.png",
								"height": 12,
								"width": 12,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							},
							"upgrade_need_consume": 0,
							"next_privileges": "",
							"score": 0,
							"grade_banner": ""
						},
						"fans_club": {
							"data": {
								"club_name": "",
								"level": 0,
								"user_fans_club_status": 0,
								"badge": {
									"icons": [
										{
											"url_list": [],
											"uri": "",
											"height": 0,
											"width": 0,
											"avg_color": "",
											"image_type": 0,
											"open_web_url": "",
											"is_animated": false
										}
									],
									"title": ""
								},
								"available_gift_ids": [],
								"anchor_id": 0
							},
							"prefer_data": []
						},
						"special_id": "",
						"real_time_icons": [],
						"new_real_time_icons": [],
						"top_vip_no": 0,
						"pay_score": 0,
						"ticket_count": 0,
						"link_mic_stats": 0,
						"display_id": "ivanxia",
						"with_commerce_permission": false,
						"with_fusion_shop_entry": false,
						"total_recharge_diamond_count": 0,
						"verified_content": "",
						"top_fans": [],
						"sec_uid": "MS4wLjABAAAAYEGfEzvS2hR7RnEQMF7q8ihpC0C8CA0dgDuawFBhwtHlOBjR3pu4W0eYvAlVtfSD",
						"user_role": 0,
						"authorization_info": 3,
						"adversary_authorization_info": 0,
						"media_badge_image_list": [],
						"adversary_user_status": 0,
						"commerce_webcast_config_ids": [],
						"badge_image_list_v2": [
							{
								"url_list": [
									"http:\/\/p6-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image",
									"http:\/\/p3-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image",
									"http:\/\/p9-webcast.douyinpic.com\/img\/webcast\/user_grade_level_v5_20.png~tplv-obj.image"
								],
								"uri": "user_grade_level_v5_20.png",
								"height": 16,
								"width": 32,
								"avg_color": "",
								"image_type": 1,
								"open_web_url": "",
								"is_animated": false
							}
						],
						"location_city": "",
						"remark_name": "",
						"mystery_man": 1,
						"web_rid": "",
						"desensitized_nickname": "",
						"allow_be_located": false,
						"allow_find_by_contacts": false,
						"allow_others_download_video": false,
						"allow_others_download_when_sharing_video": false,
						"allow_share_show_profile": false,
						"allow_show_in_gossip": false,
						"allow_show_my_action": false,
						"allow_strange_comment": false,
						"allow_unfollower_comment": false,
						"allow_use_linkmic": false,
						"bg_img_url": "",
						"birthday_description": "",
						"birthday_valid": false,
						"block_status": 0,
						"comment_restrict": 0,
						"constellation": "",
						"disable_ichat": 0,
						"enable_ichat_img": 0,
						"exp": 0,
						"fan_ticket_count": 0,
						"fold_stranger_chat": false,
						"follow_status": 0,
						"hotsoon_verified": false,
						"hotsoon_verified_reason": "",
						"ichat_restrict_type": 0,
						"id_str": "2955104372400333",
						"is_follower": false,
						"is_following": false,
						"need_profile_guide": false,
						"pay_scores": 0,
						"push_comment_status": false,
						"push_digg": false,
						"push_follow": false,
						"push_friend_action": false,
						"push_ichat": false,
						"push_status": false,
						"push_video_post": false,
						"push_video_recommend": false,
						"verified_mobile": false,
						"verified_reason": "",
						"with_car_management_permission": false
					},
					"score": 1939,
					"rank": 2,
					"gap_description": "1939",
					"delta": 8062,
					"first_gift": false,
					"is_hidden": false,
					"score_description": "1939",
					"exactly_score": "1939"
				}
			],
			"seats": [],
			"self_info": {
				"score": 0,
				"rank": 0,
				"gap_description": "距离上榜还差\n15",
				"delta": 14,
				"first_gift": false,
				"is_hidden": false,
				"score_description": "",
				"exactly_score": "0"
			},
			"has_more": false,
			"music_wave": "",
			"total": 39847,
			"currency": "",
			"has_once_live": true,
			"rules_url": "",
			"user_count_desc": "3万+"
		},
		"extra": {
			"now": 1631843079980
		},
		"status_code": 0
	}
}
```
