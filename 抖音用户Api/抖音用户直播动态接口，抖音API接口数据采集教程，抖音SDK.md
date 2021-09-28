# 抖音用户直播动态接口，抖音API接口数据采集教程，抖音SDK


## 抖音用户直播动态Api：

### 请求Api
```http
http://主机地址/douyin/user/show?token=xxx&uid=88706529168&max_time=0

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
| uid | int | 用户id|
| max_time | int | 翻页游标，初始为0，根据结果返回的max_time传入作为下一页翻页参数 |
 
### 返回示例
```json

{
	"code": 200,
	"msg": "成功",
	"data": {
		"data": {
			"max_time": 1622880074,
			"has_more": true,
			"announcement_data": [
				{
					"nick_name": "黑码科技",
					"avatar": {
						"url_list": [
							"https:\/\/p6.douyinpic.com\/img\/tos-cn-avt-0015\/2a1276d3b2eec4e506a07c54449f6339~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p9.douyinpic.com\/img\/tos-cn-avt-0015\/2a1276d3b2eec4e506a07c54449f6339~c5_100x100.jpeg?from=4010531038",
							"https:\/\/p3.douyinpic.com\/img\/tos-cn-avt-0015\/2a1276d3b2eec4e506a07c54449f6339~c5_100x100.jpeg?from=4010531038"
						],
						"uri": "100x100\/tos-cn-avt-0015\/2a1276d3b2eec4e506a07c54449f6339",
						"height": 0,
						"width": 0,
						"avg_color": "",
						"image_type": 0,
						"open_web_url": "",
						"is_animated": false
					},
					"content": "每天都会开播哦",
					"release_time": 1618022890,
					"is_subscribed": false,
					"subscribe_count": 2285,
					"audit_status": 0,
					"scheduled_time_text": "每天18:00",
					"id": 6949117882794005545,
					"switch": false
				}
			],
			"preview_data": [],
			"history_data": [
				{
					"start_time": 1623138986,
					"end_time": 1623176220,
					"room_id": 6971328457150139140,
					"title": "黑码618宠粉专场送送送",
					"is_hide": false,
					"moment_list": [],
					"record_list": [],
					"replay_list": []
				},
				{
					"start_time": 1623052590,
					"end_time": 1623092377,
					"room_id": 6970957442784267020,
					"title": "黑码618宠粉专场送送送",
					"is_hide": false,
					"moment_list": [],
					"record_list": [],
					"replay_list": []
				},
				{
					"start_time": 1622968222,
					"end_time": 1623000064,
					"room_id": 6970595191388457761,
					"title": "黑码618宠粉专场送送送",
					"is_hide": false,
					"moment_list": [],
					"record_list": [],
					"replay_list": []
				},
				{
					"start_time": 1622909013,
					"end_time": 1622964868,
					"room_id": 6970340860844444428,
					"title": "黑码618宠粉专场送送送",
					"is_hide": false,
					"moment_list": [],
					"record_list": [],
					"replay_list": []
				},
				{
					"start_time": 1622880075,
					"end_time": 1622908999,
					"room_id": 6970216563668519691,
					"title": "黑码618宠粉专场送送送",
					"is_hide": false,
					"moment_list": [],
					"record_list": [],
					"replay_list": []
				}
			]
		},
		"extra": {
			"now": 1623295710684
		},
		"status_code": 0
	}
}

```


