# 抖音榜单Api：明星榜

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


## 抖音榜单：明星榜Api：

### 请求Api
```http
http://主机地址/douyin/board/star?token=xxx

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
    "active_time": "09月14日 23:00",
    "banner_url": {
      "uri": "209c30000d4a8cf2f9370",
      "url_list": [
        "https://p9-dy.byteimg.com/obj/209c30000d4a8cf2f9370?from=568394430",
        "https://p1-dy-ipv6.byteimg.com/obj/209c30000d4a8cf2f9370?from=568394430",
        "https://p6-dy-ipv6.byteimg.com/obj/209c30000d4a8cf2f9370?from=568394430"
      ]
    },
    "extra": {
      "fatal_item_ids": [
      ],
      "logid": "202009142324410101980650392E32B7C7",
      "now": 1600097081000
    },
    "is_activity_online": false,
    "log_pb": {
      "impr_id": "202009142324410101980650392E32B7C7"
    },
    "share_info": {
      "share_link_desc": "我在看抖音明星爱DOU榜，发现最火的明星，赶快来看！戳这里>>",
      "share_title": "我在看抖音明星爱DOU榜，发现最火的明星，赶快来看！",
      "share_url": "https://www.iesdouyin.com/share/billboard/star/"
    },
    "status_code": 0,
    "user_list": [
      {
        "factor_hot_value": 28884,
        "factor_interact_value": 2153663,
        "honor_tags": [
          2
        ],
        "hot_value": 2182550,
        "hot_value_bar": 95,
        "is_new": false,
        "rank_diff": 0,
        "sprint": {
          "followers": null,
          "sprint": 0
        },
        "user_info": {
          "avatar_larger": {
            "uri": "1080x1080/2ddc5000133f9b3c2d273",
            "url_list": [
              "https://p6-dy-ipv6.byteimg.com/aweme/1080x1080/2ddc5000133f9b3c2d273.jpeg?from=4010531038",
              "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/2ddc5000133f9b3c2d273.jpeg?from=4010531038",
              "https://p1-dy-ipv6.byteimg.com/aweme/1080x1080/2ddc5000133f9b3c2d273.jpeg?from=4010531038"
            ]
          },
          "avatar_thumb": {
            "uri": "100x100/2ddc5000133f9b3c2d273",
            "url_list": [
              "https://p3-dy-ipv6.byteimg.com/aweme/100x100/2ddc5000133f9b3c2d273.jpeg?from=4010531038",
              "https://p29-dy.byteimg.com/aweme/100x100/2ddc5000133f9b3c2d273.jpeg?from=4010531038",
              "https://p6-dy-ipv6.byteimg.com/aweme/100x100/2ddc5000133f9b3c2d273.jpeg?from=4010531038"
            ]
          },
          "nickname": "张庭",
          "sec_uid": "MS4wLjABAAAAmvx03_4dmvU4IouLcpVqVvabF3rgKym0WjOjLoVqPos",
          "signature": "📢9月27日晚直播\n\n工作联系：\n1469651851@qq.com",
          "status": 1,
          "uid": "98282802298",
          "user_rate": 1
        }
      },
      {
        "factor_hot_value": 13512,
        "factor_interact_value": 146081,
        "honor_tags": [
        ],
        "hot_value": 239996,
        "hot_value_bar": 50,
        "is_new": false,
        "rank_diff": -3,
        "sprint": {
          "followers": null,
          "sprint": 0
        },
        "user_info": {
          "avatar_larger": {
            "uri": "1080x1080/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7",
            "url_list": [
              "https://p26-dy.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_1080x1080.jpeg?from=4010531038",
              "https://p9-dy.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_1080x1080.jpeg?from=4010531038",
              "https://p29-dy.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_1080x1080.jpeg?from=4010531038"
            ]
          },
          "avatar_thumb": {
            "uri": "100x100/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7",
            "url_list": [
              "https://p29-dy.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_100x100.jpeg?from=4010531038",
              "https://p3-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_100x100.jpeg?from=4010531038",
              "https://p26-dy.byteimg.com/img/tos-cn-avt-0015/6206f9c4fd4344d3935432ea4ce83ce7~c5_100x100.jpeg?from=4010531038"
            ]
          },
          "nickname": "白鹿my",
          "sec_uid": "MS4wLjABAAAAORCDztC7TcHbBDZ4e6JwLx6CfMzl-OIOLx6YKrcIA-U",
          "signature": "",
          "status": 1,
          "uid": "67262082771",
          "user_rate": 1
        }
      },
      {
        "factor_hot_value": 113818,
        "factor_interact_value": 121685,
        "honor_tags": [
        ],
        "hot_value": 235506,
        "hot_value_bar": 50,
        "is_new": false,
        "rank_diff": 0,
        "sprint": {
          "followers": null,
          "sprint": 0
        },
        "user_info": {
          "avatar_larger": {
            "uri": "1080x1080/26d9d000415a2b01fe8ac",
            "url_list": [
              "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/26d9d000415a2b01fe8ac.jpeg?from=4010531038",
              "https://p6-dy-ipv6.byteimg.com/aweme/1080x1080/26d9d000415a2b01fe8ac.jpeg?from=4010531038",
              "https://p9-dy.byteimg.com/aweme/1080x1080/26d9d000415a2b01fe8ac.jpeg?from=4010531038"
            ]
          },
          "avatar_thumb": {
            "uri": "100x100/26d9d000415a2b01fe8ac",
            "url_list": [
              "https://p29-dy.byteimg.com/aweme/100x100/26d9d000415a2b01fe8ac.jpeg?from=4010531038",
              "https://p6-dy-ipv6.byteimg.com/aweme/100x100/26d9d000415a2b01fe8ac.jpeg?from=4010531038",
              "https://p3-dy-ipv6.byteimg.com/aweme/100x100/26d9d000415a2b01fe8ac.jpeg?from=4010531038"
            ]
          },
          "nickname": "李心艾",
          "sec_uid": "MS4wLjABAAAAJucHt6_uDmIcUlyCwlV-4yXRqZvB1lzNbhk0M8x4rhA",
          "signature": "周杰伦电影《天台》女主角\n《锦绣未央》—李长乐\n《花谢花飞花满天》—倾城公主\n《班淑传奇》、《彼岸花》\n商务联系 vx 17600031565",
          "status": 1,
          "uid": "111617580562",
          "user_rate": 1
        }
      },
      {
        "factor_hot_value": 4620,
        "factor_interact_value": 213789,
        "honor_tags": [
        ],
        "hot_value": 218412,
        "hot_value_bar": 50,
        "is_new": false,
        "rank_diff": 0,
        "sprint": {
          "followers": null,
          "sprint": 0
        },
        "user_info": {
          "avatar_larger": {
            "uri": "1080x1080/add000005414f2e6a5e0",
            "url_list": [
              "https://p3-dy-ipv6.byteimg.com/aweme/1080x1080/add000005414f2e6a5e0.jpeg?from=4010531038",
              "https://p9-dy.byteimg.com/aweme/1080x1080/add000005414f2e6a5e0.jpeg?from=4010531038",
              "https://p26-dy.byteimg.com/aweme/1080x1080/add000005414f2e6a5e0.jpeg?from=4010531038"
            ]
          },
          "avatar_thumb": {
            "uri": "100x100/add000005414f2e6a5e0",
            "url_list": [
              "https://p9-dy.byteimg.com/aweme/100x100/add000005414f2e6a5e0.jpeg?from=4010531038",
              "https://p1-dy-ipv6.byteimg.com/aweme/100x100/add000005414f2e6a5e0.jpeg?from=4010531038",
              "https://p6-dy-ipv6.byteimg.com/aweme/100x100/add000005414f2e6a5e0.jpeg?from=4010531038"
            ]
          },
          "nickname": "张子萱",
          "sec_uid": "MS4wLjABAAAAHpcZPHEpljmz4p9MhxkMpMx5-idEHEi2bqYnPXtUrHc",
          "signature": "一直抽风 偶尔正常的我",
          "status": 1,
          "uid": "87269012777",
          "user_rate": 1
        }
      }
    ]
  },
  "msg": "success"
}
```


