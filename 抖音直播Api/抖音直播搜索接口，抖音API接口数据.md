# 抖音直播搜索接口，抖音API接口数据




## 抖音直播搜索列表Api：

### 请求Api
```http
http://主机地址/douyin/search/lives?token=xxx&keyword=热巴&cursor=20
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
 

### 返回示例
```json
{
  "code": 200,
  "data": {
    "cursor": 12,
    "data": [
      {
        "lives": {
          "anchors": null,
          "author": {
            "ad_cover_url": null,
            "avatar_larger": {
              "uri": "1080x1080/318820007c435e3fd4696",
              "url_list": [
                "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p9-dy.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p1-dy-ipv6.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038"
              ]
            },
            "avatar_medium": {
              "uri": "720x720/318820007c435e3fd4696",
              "url_list": [
                "https://p1-dy-ipv6.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p29-dy.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p3-dy-ipv6.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038"
              ]
            },
            "avatar_thumb": {
              "uri": "100x100/318820007c435e3fd4696",
              "url_list": [
                "https://p9-dy.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p3-dy-ipv6.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038",
                "https://p6-dy-ipv6.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038"
              ]
            },
            "can_set_geofencing": null,
            "cha_list": null,
            "cover_url": null,
            "custom_verify": "",
            "enterprise_verify_reason": "",
            "followers_detail": null,
            "geofencing": null,
            "homepage_bottom_toast": null,
            "item_list": null,
            "need_points": null,
            "new_story_cover": null,
            "nickname": "南京迪丽热巴💚",
            "platform_sync_info": null,
            "relative_users": null,
            "room_cover": {
              "uri": "webcast/6761373873079569163",
              "url_list": [
                "http://p3-webcast-dycdn.byteimg.com/img/webcast/6761373873079569163~tplv-obj.image",
                "http://p6-webcast-dycdn.byteimg.com/img/webcast/6761373873079569163~tplv-obj.image"
              ]
            },
            "room_id": 6872334082282359552,
            "room_id_str": "6872334082282359552",
            "sec_uid": "MS4wLjABAAAAnGiirU7x9pMMMEdIqHn4ItxrggQ1G87HeWRX7GXWd_c",
            "short_id": "27648787",
            "type_label": null,
            "uid": "62256671560",
            "user_tags": null,
            "white_cover_url": null
          },
          "aweme_id": "6872334082282359552",
          "aweme_type": 101,
          "cha_list": null,
          "challenge_position": null,
          "comment_list": null,
          "commerce_config_data": null,
          "cover_labels": null,
          "geofencing": null,
          "geofencing_regions": null,
          "group_id": "6872333965101960463",
          "hybrid_label": null,
          "image_infos": null,
          "interaction_stickers": null,
          "label_top_text": null,
          "long_video": null,
          "nickname_position": null,
          "origin_comment_ids": null,
          "position": null,
          "promotions": null,
          "rawdata": "{\"id\":6872334082282359552,\"id_str\":\"6872334082282359552\",\"status\":2,\"owner_user_id\":62256671560,\"title\":\"南京古力那扎💚正在直\",\"user_count\":2,\"create_time\":1600089968,\"linkmic_layout\":1,\"cover\":{\"url_list\":[\"http://p3-webcast-dycdn.byteimg.com/img/webcast/6761373873079569163~tplv-obj.image\",\"http://p6-webcast-dycdn.byteimg.com/img/webcast/6761373873079569163~tplv-obj.image\"],\"uri\":\"webcast/6761373873079569163\",\"avg_color\":\"#DCF4FA\"},\"stream_url\":{\"id\":683840967322632337,\"id_str\":\"683840967322632337\",\"resolution_name\":{\"FULL_HD1\":\"蓝光\",\"HD1\":\"超清\",\"ORIGION\":\"原画\",\"SD1\":\"标清\",\"SD2\":\"高清\"},\"default_resolution\":\"ORIGION\",\"extra\":{\"height\":864,\"width\":480,\"fps\":15,\"max_bitrate\":900,\"min_bitrate\":300,\"default_bitrate\":800},\"rtmp_pull_url\":\"http://pull-flv-l11.douyincdn.com/stage/stream-683840967322632337.flv\",\"live_core_sdk_data\":{\"pull_data\":{\"stream_data\":\"{\\\"common\\\":{\\\"session_id\\\":\\\"000-202009142143070101450190863D1B7651\\\"},\\\"data\\\":{\\\"origin\\\":{\\\"main\\\":{\\\"flv\\\":\\\"http: //pull-flv-l11.douyincdn.com/stage/stream-683840967322632337.flv\\\",\\\"hls\\\":\\\"http: //pull-hls-l11.douyincdn.com/stage/stream-683840967322632337.m3u8\\\",\\\"cmaf\\\":\\\"\\\",\\\"dash\\\":\\\"\\\",\\\"sdk_params\\\":\\\"{
            \\\\\\\"VCodec\\\\\\\": \\\\\\\"h265\\\\\\\",
            \\\\\\\"gop\\\\\\\": 4,
            \\\\\\\"resolution\\\\\\\": \\\\\\\"720x1280\\\\\\\",
            \\\\\\\"vbitrate\\\\\\\": 800000
          }\\\"}}}}\",\"options\":{\"default_quality\":{\"name\":\"超清\",\"sdk_key\":\"origin\"}}}}},\"stats\":{\"total_user\":29},\"owner\":{\"id\":62256671560,\"short_id\":27648787,\"nickname\":\"南京迪丽热巴💚\",\"gender\":2,\"signature\":\"想成为你的例外和偏爱\\n直播时间 晚上9点半\\n微博：叫我么么\",\"level\":1,\"avatar_thumb\":{\"url_list\":[\"https://p9-dy.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p3-dy-ipv6.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p6-dy-ipv6.byteimg.com/aweme/100x100/318820007c435e3fd4696.jpeg?from=4010531038\"],\"uri\":\"100x100/318820007c435e3fd4696\"},\"avatar_medium\":{\"url_list\":[\"https://p1-dy-ipv6.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p29-dy.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p3-dy-ipv6.byteimg.com/aweme/720x720/318820007c435e3fd4696.jpeg?from=4010531038\"],\"uri\":\"720x720/318820007c435e3fd4696\"},\"avatar_large\":{\"url_list\":[\"https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p9-dy.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038\",\"https://p1-dy-ipv6.byteimg.com/aweme/1080x1080/318820007c435e3fd4696.jpeg?from=4010531038\"],\"uri\":\"1080x1080/318820007c435e3fd4696\"},\"verified\":true,\"city\":\"南京\",\"status\":1,\"modify_time\":1600004002,\"share_qrcode_uri\":\"24a200425361734ca144\",\"badge_image_list\":[{\"url_list\":[\"http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_22.png~tplv-obj.image\",\"http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_22.png~tplv-obj.image\"],\"uri\":\"webcast/aweme_honor_level_icon_new_22.png\",\"height\":16,\"width\":32,\"image_type\":1}],\"follow_info\":{\"following_count\":51,\"follower_count\":70186},\"pay_grade\":{\"total_diamond_count\":7324,\"level\":22,\"this_grade_min_diamond\":6600,\"this_grade_max_diamond\":8600,\"grade_describe\":\"距离23级还差1276抖币\",\"new_im_icon_with_level\":{\"url_list\":[\"http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_22.png~tplv-obj.image\",\"http://p1-webcast-dycdn.byteimg.com/img/webcast/aweme_honor_level_icon_new_22.png~tplv-obj.image\"],\"uri\":\"webcast/aweme_honor_level_icon_new_22.png\",\"height\":16,\"width\":32,\"image_type\":1},\"new_live_icon\":{\"url_list\":[\"http://p6-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_20_24.png~tplv-obj.image\",\"http://p9-webcast-dycdn.byteimg.com/img/webcast/aweme_pay_grade_2x_20_24.png~tplv-obj.image\"],\"uri\":\"webcast/aweme_pay_grade_2x_20_24.png\",\"height\":12,\"width\":12,\"image_type\":1},\"score\":7324},\"fans_club\":{\"data\":{\"badge\":{\"icons\":{\"0\":{}}}}},\"user_attr\":{},\"own_room\":{\"room_ids\":[6872334082282359552],\"room_ids_str\":[\"6872334082282359552\"]},\"pay_score\":7324,\"ticket_count\":1131426,\"link_mic_stats\":1,\"display_id\":\"TBB20\",\"sec_uid\":\"MS4wLjABAAAAnGiirU7x9pMMMEdIqHn4ItxrggQ1G87HeWRX7GXWd_c\",\"authorization_info\":3,\"id_str\":\"62256671560\"},\"video_feed_tag\":\"直播中\",\"content_tag\":\"语音互动\"}",
          "search_extra": {
            "current_time": 1600090987
          },
          "text_extra": null,
          "uniqid_position": null,
          "video_labels": null,
          "video_text": null
        },
        "type": 1
      }
    ],
    "extra": {
      "fatal_item_ids": [
      ],
      "logid": "202009142143070101450190863D1B7651",
      "now": 1600090987000,
      "search_request_id": ""
    },
    "guide_search_words": null,
    "has_more": 0,
    "log_pb": {
      "impr_id": "202009142143070101450190863D1B7651"
    },
    "status_code": 0
  },
  "msg": "success"
}
```


