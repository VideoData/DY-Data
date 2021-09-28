# 抖音榜单Api：热点榜

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


## 抖音榜单：热点榜

### 请求Api
```http
http://主机地址/douyin/board/hot?token=xxx

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


### 

### 返回示例
```json

{
  "code": 200,
  "data": {
    "ad_search_list": null,
    "data": {
      "active_time": "2020-09-14 23:20:13",
      "recommend_list": null,
      "share_info": {
        "share_link_desc": "我在看抖音热榜，发现最火的内容，赶快来看！戳这里>>",
        "share_title": "我在看抖音热榜，发现最火的内容，赶快来看！",
        "share_url": "https://www.iesdouyin.com/share/billboard/?id=0"
      },
      "trending_desc": "实时上升热点",
      "trending_list": [
        {
          "group_id": "6871001533455996173",
          "label": 0,
          "related_words": null,
          "sentence_id": "0xc04d280e90",
          "video_count": 1,
          "word": "美警察追捕搞错地址砸错门",
          "word_cover": {
            "uri": "tos-cn-p-0015/ce4cba031210468f95bb6a3c9f192193_1600067077",
            "url_list": [
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/ce4cba031210468f95bb6a3c9f192193_1600067077~noop.jpeg?from=3218412987",
              "https://p6-dy-ipv6.byteimg.com/img/tos-cn-p-0015/ce4cba031210468f95bb6a3c9f192193_1600067077~noop.jpeg?from=3218412987",
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/ce4cba031210468f95bb6a3c9f192193_1600067077~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 3
        },
        {
          "group_id": "6870862304994874632",
          "label": 0,
          "related_words": null,
          "sentence_id": "0xc04d280f20",
          "video_count": 2,
          "word": "男子好心救援被困房车反遭拒绝",
          "word_cover": {
            "uri": "tos-cn-p-0015/bc0610a7f6934b5f92575ca90a129338",
            "url_list": [
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/bc0610a7f6934b5f92575ca90a129338~noop.jpeg?from=3218412987",
              "https://p6-dy-ipv6.byteimg.com/img/tos-cn-p-0015/bc0610a7f6934b5f92575ca90a129338~noop.jpeg?from=3218412987",
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/bc0610a7f6934b5f92575ca90a129338~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 3
        },
        {
          "group_id": "6870335832144712972",
          "label": 0,
          "related_words": null,
          "sentence_id": "0xc04d280fb0",
          "video_count": 1,
          "word": "这就是街舞3决赛夜神秘嘉宾",
          "word_cover": {
            "uri": "tos-cn-p-0015/4ded911d77ff4072855bbd2698931c33",
            "url_list": [
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/4ded911d77ff4072855bbd2698931c33~noop.jpeg?from=3218412987",
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/4ded911d77ff4072855bbd2698931c33~noop.jpeg?from=3218412987",
              "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/4ded911d77ff4072855bbd2698931c33~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 3
        },
        {
          "group_id": "6870978388007621901",
          "label": 0,
          "related_words": null,
          "sentence_id": "0xc04d281040",
          "video_count": 1,
          "word": "近1000家景区实行免费打折政策",
          "word_cover": {
            "uri": "tos-cn-p-0015/2ec676a6778441a0aa84b3b9ed97f38e",
            "url_list": [
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/2ec676a6778441a0aa84b3b9ed97f38e~noop.jpeg?from=3218412987",
              "https://p9-dy.byteimg.com/img/tos-cn-p-0015/2ec676a6778441a0aa84b3b9ed97f38e~noop.jpeg?from=3218412987",
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/2ec676a6778441a0aa84b3b9ed97f38e~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 3
        },
        {
          "group_id": "6870948419101463816",
          "label": 0,
          "related_words": null,
          "sentence_id": "0xc04d2810d0",
          "video_count": 1,
          "word": "焦作举办第三季度消防比武竞赛",
          "word_cover": {
            "uri": "tos-cn-p-0015/9cbc76a4e79a4df5ae47390d68a61367_1600069460",
            "url_list": [
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/9cbc76a4e79a4df5ae47390d68a61367_1600069460~noop.jpeg?from=3218412987",
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/9cbc76a4e79a4df5ae47390d68a61367_1600069460~noop.jpeg?from=3218412987",
              "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/9cbc76a4e79a4df5ae47390d68a61367_1600069460~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 3
        }
      ],
      "word_list": [
        {
          "can_extend_detail": false,
          "challenge_id": "",
          "event_time": 1599993150,
          "group_id": "6870421703589549319",
          "hot_value": 8782523,
          "label": 5,
          "position": 1,
          "related_words": null,
          "sentence_id": "123223",
          "video_count": 3,
          "word": "李心艾回应胖了",
          "word_cover": {
            "uri": "tos-cn-p-0015/7004540786d54652932bd083ceaf5048_1599992729",
            "url_list": [
              "https://p9-dy.byteimg.com/img/tos-cn-p-0015/7004540786d54652932bd083ceaf5048_1599992729~noop.jpeg?from=3218412987",
              "https://p1-dy-ipv6.byteimg.com/img/tos-cn-p-0015/7004540786d54652932bd083ceaf5048_1599992729~noop.jpeg?from=3218412987",
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/7004540786d54652932bd083ceaf5048_1599992729~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 1
        },
        {
          "challenge_id": "",
          "event_time": 1600073839,
          "group_id": "6727600448598971661",
          "hot_value": 8671307,
          "label": 0,
          "position": 2,
          "related_words": null,
          "sentence_id": "123795",
          "video_count": 4,
          "word": "我喜欢你定档",
          "word_cover": {
            "uri": "tos-cn-p-0015/a74429fb1595415182651b508ea4a3ff",
            "url_list": [
              "https://p26-dy.byteimg.com/img/tos-cn-p-0015/a74429fb1595415182651b508ea4a3ff~noop.jpeg?from=3218412987",
              "https://p1-dy-ipv6.byteimg.com/img/tos-cn-p-0015/a74429fb1595415182651b508ea4a3ff~noop.jpeg?from=3218412987",
              "https://p9-dy.byteimg.com/img/tos-cn-p-0015/a74429fb1595415182651b508ea4a3ff~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 1
        },
        {
          "can_extend_detail": true,
          "challenge_id": "",
          "event_time": 1600052975,
          "group_id": "6860030767771178248",
          "hot_value": 7701067,
          "label": 3,
          "position": 3,
          "related_words": null,
          "sentence_id": "123319",
          "video_count": 12,
          "word": "首部抗疫题材电视剧",
          "word_cover": {
            "uri": "tos-cn-p-0015/9bdb877e31b444c78bdb58cbc96c3a45_1599996711",
            "url_list": [
              "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/9bdb877e31b444c78bdb58cbc96c3a45_1599996711~noop.jpeg?from=3218412987",
              "https://p1-dy-ipv6.byteimg.com/img/tos-cn-p-0015/9bdb877e31b444c78bdb58cbc96c3a45_1599996711~noop.jpeg?from=3218412987",
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/9bdb877e31b444c78bdb58cbc96c3a45_1599996711~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 1
        },
        {
          "challenge_id": "",
          "event_time": 1600077890,
          "group_id": "6872193892844360971",
          "hot_value": 3409690,
          "label": 0,
          "position": 50,
          "related_words": null,
          "sentence_id": "123879",
          "video_count": 2,
          "word": "钟美美上GQ封面",
          "word_cover": {
            "uri": "tos-cn-p-0015/02ea9569c3894f93827aea37103adb9d",
            "url_list": [
              "https://p3-dy-ipv6.byteimg.com/img/tos-cn-p-0015/02ea9569c3894f93827aea37103adb9d~noop.jpeg?from=3218412987",
              "https://p1-dy-ipv6.byteimg.com/img/tos-cn-p-0015/02ea9569c3894f93827aea37103adb9d~noop.jpeg?from=3218412987",
              "https://p29-dy.byteimg.com/img/tos-cn-p-0015/02ea9569c3894f93827aea37103adb9d~noop.jpeg?from=3218412987"
            ]
          },
          "word_type": 1
        }
      ]
    },
    "extra": {
      "fatal_item_ids": [
      ],
      "logid": "202009142327000101980582070932F9A4",
      "now": 1600097220000
    },
    "log_pb": {
      "impr_id": "202009142327000101980582070932F9A4"
    },
    "status_code": 0
  },
  "msg": "success"
}
```


