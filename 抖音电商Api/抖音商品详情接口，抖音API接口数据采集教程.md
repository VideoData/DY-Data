# 抖音商品详情接口，抖音API接口数据采集教程



## 抖音带货商品详情

### 请求Api
```http
http://主机地址/douyin/promotion/detail?token=xxx&pid=61088777146700

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
| pid	 | int | 商品的promotion_id |
 


### 返回示例
```json

{
  "code": 200,
  "data": {
    "extra": {
      "fatal_item_ids": [
      ],
      "logid": "202009142312040101440611633128EFDF",
      "now": 1600096324000
    },
    "log_pb": {
      "impr_id": "202009142312040101440611633128EFDF"
    },
    "page_style": {
      "comment_page_tag_max": 0,
      "detail_page_stats_show": true,
      "detail_page_tag_max": 3,
      "detail_page_tag_show": false
    },
    "promotions": [
      {
        "base_info": {
          "images": [
            {
              "height": 720,
              "uri": "cmp-ecom-alliance/FrchgUilgiPUABAlgrhBP7dHpbdM.jpg",
              "url_list": [
                "http://p9.pstatp.com/obj/cmp-ecom-alliance/FrchgUilgiPUABAlgrhBP7dHpbdM.jpg",
                "http://pb1.pstatp.com/obj/cmp-ecom-alliance/FrchgUilgiPUABAlgrhBP7dHpbdM.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/FrchgUilgiPUABAlgrhBP7dHpbdM.jpg"
              ],
              "width": 720
            },
            {
              "height": 720,
              "uri": "cmp-ecom-alliance/FrY8LkT_UB641SxMNh7iEoqBizyt.jpg",
              "url_list": [
                "http://p1.pstatp.com/obj/cmp-ecom-alliance/FrY8LkT_UB641SxMNh7iEoqBizyt.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/FrY8LkT_UB641SxMNh7iEoqBizyt.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/FrY8LkT_UB641SxMNh7iEoqBizyt.jpg"
              ],
              "width": 720
            },
            {
              "height": 720,
              "uri": "cmp-ecom-alliance/FiUJxCUkpyatcpQ6K3-7q84_sJNv.jpg",
              "url_list": [
                "http://p3.pstatp.com/obj/cmp-ecom-alliance/FiUJxCUkpyatcpQ6K3-7q84_sJNv.jpg",
                "http://pb9.pstatp.com/obj/cmp-ecom-alliance/FiUJxCUkpyatcpQ6K3-7q84_sJNv.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/FiUJxCUkpyatcpQ6K3-7q84_sJNv.jpg"
              ],
              "width": 720
            },
            {
              "height": 720,
              "uri": "cmp-ecom-alliance/FtTMbV5XjNQzu32mQgi2hcWWhRHt.jpg",
              "url_list": [
                "http://p3.pstatp.com/obj/cmp-ecom-alliance/FtTMbV5XjNQzu32mQgi2hcWWhRHt.jpg",
                "http://pb9.pstatp.com/obj/cmp-ecom-alliance/FtTMbV5XjNQzu32mQgi2hcWWhRHt.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/FtTMbV5XjNQzu32mQgi2hcWWhRHt.jpg"
              ],
              "width": 720
            },
            {
              "height": 720,
              "uri": "cmp-ecom-alliance/Fpte4oGTdlmtk0tai4uUmNCLDPyP.jpg",
              "url_list": [
                "http://p3.pstatp.com/obj/cmp-ecom-alliance/Fpte4oGTdlmtk0tai4uUmNCLDPyP.jpg",
                "http://pb9.pstatp.com/obj/cmp-ecom-alliance/Fpte4oGTdlmtk0tai4uUmNCLDPyP.jpg",
                "http://pb3.pstatp.com/obj/cmp-ecom-alliance/Fpte4oGTdlmtk0tai4uUmNCLDPyP.jpg"
              ],
              "width": 720
            }
          ],
          "links": {
            "h5_url": "https://item.taobao.com/item.htm?id=610887771467"
          },
          "price": {
            "market_price": 32800,
            "min_price": 30520
          },
          "product_id": "610887771467",
          "promotion_id": "61088777146700",
          "promotion_source": 7,
          "promotion_source_text": "商品来自淘宝",
          "sales": 291,
          "sold_out": false,
          "status": 4,
          "title": "MIUCO设计感复古系带收腰中长款黑色休闲西装外套女2020春装新款k"
        },
        "entry_info": {
        },
        "extra_info": {
          "buy_button": {
            "links": {
              "h5_url": "https://item.taobao.com/item.htm?id=610887771467"
            },
            "order_status": 0,
            "text": "去淘宝看看"
          },
          "favorited": false,
          "pay_type": 0,
          "shop_id": "0",
          "visitor_count": 513173
        },
        "page_coms_config": {
          "display_gyl": false,
          "display_want": true,
          "store_icon": false
        },
        "privilege_info": {
          "activities": {
          }
        }
      }
    ],
    "status_code": 0
  },
  "msg": "success"
}
```


