#  直播间监控弹幕实时获取评论、关注、来了、点赞、送礼、粉丝团


#  请求Api：
```java
http://主机地址/dy/***/?token=xxx&room_id=67431981995834577
```
#  请求方式：
```java
Get
```

#  参数 
| 参数名      | 类型     | 说明     |
| ---------- | :-----------:  | :-----------: |
| token     | string     | 接口授权码     |
| room_id     | int     | 直播间room_id     | 


#  部分返回示例：
```
{
    "code":200,
    "msg":"成功",
    "data":{
        "messages":[
            {
                "msg_id":6922636420838837000,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"来了",
                    "user":{
                        "uid":52698179946,
                        "nickname":"美好明天",
                        "unique_id":"hxp99901",
                        "sec_uid":"MS4wLjABAAAAkXJLP99bv_4Jkh9KzSZEzAvqRFfLPmODrMLWX0ADsoM"
                    }
                }
            },
            {
                "msg_id":6922636422784764686,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"来了",
                    "user":{
                        "uid":51923147039,
                        "nickname":"冬冬",
                        "unique_id":"1041741043",
                        "sec_uid":"MS4wLjABAAAAXkhMk7r1p83SkWRFgpwvpd6ASlB3I-YMDl2JZW66eeQ"
                    }
                }
            },
            {
                "msg_id":6922636425427503886,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"点赞",
                    "user":{
                        "uid":105308683391,
                        "nickname":"☀️太阳 Angel",
                        "unique_id":"Angel2020168",
                        "sec_uid":"MS4wLjABAAAAnkvgZhcaRKRppWqyuUWamJuRtipXMlSHscyB-eS9wE0"
                    }
                }
            },
            {
                "msg_id":6922636332913199880,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"23号大衣可以回复一下吗",
                    "user":{
                        "uid":60722721614,
                        "nickname":"妞儿小念",
                        "unique_id":"103191973",
                        "sec_uid":"MS4wLjABAAAA0TFnVB4zTu3wFzhiiSOJ3EnZy4zey4XcFTgvkAAtMh8"
                    }
                }
            },
            {
                "msg_id":6922636426312370957,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"来了",
                    "user":{
                        "uid":78218887998,
                        "nickname":"媛媛(●—●)",
                        "unique_id":"366527366",
                        "sec_uid":"MS4wLjABAAAAYpZ-oieBEOjLtIRAbyiuV9ehmrQd1p1GYkT-uzVDBNk"
                    }
                }
            },
            {
                "msg_id":6922636431550679822,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"关注了主播",
                    "user":{
                        "uid":1543327509393740,
                        "nickname":"安好…",
                        "unique_id":"dyl5gnds85en",
                        "sec_uid":"MS4wLjABAAAApHPePKMI-9rxbC_ZXW-8Lp-uPmGywJlDFgsX1O_MMKrin6E5AKmEtTfLkzwDIcrS"
                    }
                }
            },
            {
                "msg_id":6922636429608733454,
                "payload":{
                    "room_id":6922580638159719176,
                    "content":"来了",
                    "user":{
                        "uid":62480612210,
                        "nickname":"是花花啊🥨",
                        "unique_id":"Meng1025_",
                        "sec_uid":"MS4wLjABAAAAtK3lUOvcyvQW-zD6MZiqXDDN5AyLDDRwamW4dZ3TCi0"
                    }
                }
            }
        ]
    }
}
```



#  免责声明
    有任何问题可交流学习  
    请勿使用本服务于商用  
    请勿使用本服务大量抓取  
    若因使用本服务与平台造成不必要的纠纷，本人盖不负责  
    本人纯粹技术爱好，若侵犯贵公司的权益，请告知
