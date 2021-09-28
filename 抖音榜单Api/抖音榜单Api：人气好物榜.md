# 抖音榜单Api：人气好物榜

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


## 抖音榜单：人气好物榜

### 请求Api
```http
http://主机地址/douyin/board/goods?token=xxx

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
    "code": 0,
    "data": {
      "rank_list": [
        {
          "author": {
            "avatar": "https://p9-dy.byteimg.com/aweme/100x100/2e1960006db158c85c09d.jpeg?from=4010531038",
            "id": 628520101353603,
            "name": "吃货阿诗",
            "shop_url": "snssdk1128://goods/shop/?uid=628520101353603"
          },
          "goods": {
            "commodity_type": 4,
            "cover": "temai/FtQ4bmyLdVsmHi2u95w8uR_HQimSwww800-800",
            "detail_url": "",
            "id": "3434519033431626431",
            "market_price": 4290,
            "price": 3690,
            "product_id": "3434318250152965428",
            "sales": 29270,
            "score": 75539,
            "title": "【7件套】广东晨爽牌肠粉送工具套装家用装蒸盘酱汁专用拉肠粉",
            "up_or_down": 0
          },
          "is_recommended": 0,
          "item_id": "6871774430327033096",
          "item_img": "tos-cn-p-0015/25b39d8a7b6c4d02b018c0137c54cd98_1599959699",
          "item_type": 4,
          "item_url": "aweme://aweme/detail/6871774430327033096"
        },
        {
          "author": {
            "avatar": "https://p29-dy.byteimg.com/aweme/100x100/310ec000271943dfe24f0.jpeg?from=4010531038",
            "id": 2150298885563934,
            "name": "骆王宇",
            "shop_url": "snssdk1128://goods/shop/?uid=2150298885563934"
          },
          "goods": {
            "commodity_type": 7,
            "cover": "cmp-ecom-alliance/FuL8Q80_5Chj_9GLo6oG1xMqxUYY.jpg",
            "detail_url": "",
            "id": "62704449428700",
            "market_price": 19800,
            "price": 12800,
            "product_id": "627044494287",
            "sales": 37999,
            "score": 68374,
            "title": "【骆王宇推荐】米蓓尔修护固态闪释冻干面膜女熬夜补水舒缓敏感肌",
            "up_or_down": -1
          },
          "is_recommended": 0,
          "item_id": "6871137170531355918",
          "item_img": "tos-cn-p-0015/392a9fc2c8514501ad7c1e46624a9fc6_1599811314",
          "item_type": 4,
          "item_url": "aweme://aweme/detail/6871137170531355918"
        },
        {
          "author": {
            "avatar": "https://p3-dy-ipv6.byteimg.com/img/tos-cn-avt-0015/0aa0f475c73557a8b9636a8c440373a6~c5_100x100.jpeg?from=4010531038",
            "id": 102107524550,
            "name": "GGhouse郭郭定制",
            "shop_url": "snssdk1128://goods/shop/?uid=102107524550"
          },
          "goods": {
            "commodity_type": 7,
            "cover": "cmp-ecom-alliance/Fr3YHqQQckfMZkYoEt-oaX31ZBXJ.jpg",
            "detail_url": "",
            "id": "62662038108600",
            "market_price": 15990,
            "price": 15990,
            "product_id": "626620381086",
            "sales": 0,
            "score": 68317,
            "title": "郭郭定制秋装2020年新款针织连衣裙女长袖polo裙百搭显瘦中长裙",
            "up_or_down": -1
          },
          "is_recommended": 0,
          "item_id": "6871104250806619405",
          "item_img": "tos-cn-p-0015/bd7959760dbe45a49a2cca949ddf38e7_1599803631",
          "item_type": 4,
          "item_url": "aweme://aweme/detail/6871104250806619405"
        },
        {
          "author": {
            "avatar": "https://p29-dy.byteimg.com/aweme/100x100/30e2c0006cdc6d6495bef.jpeg?from=4010531038",
            "id": 96106104768,
            "name": "年糕妈妈挑辅食",
            "shop_url": "snssdk1128://goods/shop/?uid=96106104768"
          },
          "goods": {
            "commodity_type": 4,
            "cover": "temai/f1c89c3f90dfed402c2cb76afa473e72www800-800",
            "detail_url": "",
            "id": "3435584584752978871",
            "market_price": 9800,
            "price": 8800,
            "product_id": "3435547611527034939",
            "sales": 76,
            "score": 13527,
            "title": "小面包幼儿护脚学步鞋",
            "up_or_down": -22
          },
          "is_recommended": 0,
          "item_id": "6871550527449173260",
          "item_img": "tos-cn-p-0015/48b9a743e8614ffaa93a85108b3cb944_1599907572",
          "item_type": 4,
          "item_url": "aweme://aweme/detail/6871550527449173260"
        }
      ],
      "special": null,
      "total": 50,
      "update_time": "更新于: 9月14日 12:00"
    },
    "error": false,
    "message": "success"
  },
  "msg": "success"
}
```


