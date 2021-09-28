# 抖音直播弹幕接口，弹幕、关注、送礼、点赞、来了 实时获取


### 请求Api
```http
http://主机地址/douyin/liveroom/chat?token=xxx&room_id=6843198199583378191
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
| room_id | int | 直播间id |

 

### 返回示例
```json
{
    "code": 200,
    "msg": "成功",
    "data": {
        "messages": [
            {
                "method": "WebcastRoomIntroMessage",
                "msg_id": 6888847779519534083,
                "payload": {
                    "room_id": 0,
                    "content": "这里是TeenieWeenie官方直播间，欢迎熊粉们常来玩，主播在这里等你们哟～",
                    "user": {
                        "uid": 8401565526815,
                        "nickname": "TeenieWeenie女装官方旗舰店",
                        "unique_id": "teenieweenie_",
                        "sec_uid": "MS4wLjABAAAAGYEe4uJArJ3uYEmO7dNXrbRBVmuRWG7a1PGtI7E9W9Q"
                    }
                }
            },
            {
                "method": "WebcastChatMessage",
                "msg_id": 6922636275858098944,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "想要长款连衣裙",
                    "user": {
                        "uid": 61152922824,
                        "nickname": "若他",
                        "unique_id": "834508049",
                        "sec_uid": "MS4wLjABAAAAofSXImUFD30Qi7j1fV66kn0U7VinMZwzVkAfQnHZFvg"
                    }
                }
            },
            {
                "method": "WebcastChatMessage",
                "msg_id": 6922636320099633933,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "23号大衣还有吗 可以回复一下吗",
                    "user": {
                        "uid": 60722721614,
                        "nickname": "妞儿小念",
                        "unique_id": "103191973",
                        "sec_uid": "MS4wLjABAAAA0TFnVB4zTu3wFzhiiSOJ3EnZy4zey4XcFTgvkAAtMh8"
                    }
                }
            },
            {
                "method": "WebcastChatMessage",
                "msg_id": 6922636312495606535,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "我买了十多件，不想要不能退吗",
                    "user": {
                        "uid": 107986518524,
                        "nickname": "娥子",
                        "unique_id": "1784059460",
                        "sec_uid": "MS4wLjABAAAA7l8_XLtA8c3FRMGoVabe7tagHNjkPhaLNhmumtVDx4Y"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636419634629379,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 88621488902,
                        "nickname": "L@",
                        "unique_id": "1123271264",
                        "sec_uid": "MS4wLjABAAAAEkGEcrpL8ulIZZ7mF0JQvMMHcSmTQho4QUedUtWCftA"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636420838837000,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 52698179946,
                        "nickname": "美好明天",
                        "unique_id": "hxp99901",
                        "sec_uid": "MS4wLjABAAAAkXJLP99bv_4Jkh9KzSZEzAvqRFfLPmODrMLWX0ADsoM"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636422784764686,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 51923147039,
                        "nickname": "冬冬",
                        "unique_id": "1041741043",
                        "sec_uid": "MS4wLjABAAAAXkhMk7r1p83SkWRFgpwvpd6ASlB3I-YMDl2JZW66eeQ"
                    }
                }
            },
            {
                "method": "WebcastLikeMessage",
                "msg_id": 6922636425427503886,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "点赞",
                    "user": {
                        "uid": 105308683391,
                        "nickname": "☀️太阳 Angel",
                        "unique_id": "Angel2020168",
                        "sec_uid": "MS4wLjABAAAAnkvgZhcaRKRppWqyuUWamJuRtipXMlSHscyB-eS9wE0"
                    }
                }
            },
            {
                "method": "WebcastChatMessage",
                "msg_id": 6922636332913199880,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "23号大衣可以回复一下吗",
                    "user": {
                        "uid": 60722721614,
                        "nickname": "妞儿小念",
                        "unique_id": "103191973",
                        "sec_uid": "MS4wLjABAAAA0TFnVB4zTu3wFzhiiSOJ3EnZy4zey4XcFTgvkAAtMh8"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636426312370957,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 78218887998,
                        "nickname": "媛媛(●—●)",
                        "unique_id": "366527366",
                        "sec_uid": "MS4wLjABAAAAYpZ-oieBEOjLtIRAbyiuV9ehmrQd1p1GYkT-uzVDBNk"
                    }
                }
            },
            {
                "method": "WebcastSocialMessage",
                "msg_id": 6922636431550679822,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "关注了主播",
                    "user": {
                        "uid": 1543327509393740,
                        "nickname": "安好…",
                        "unique_id": "dyl5gnds85en",
                        "sec_uid": "MS4wLjABAAAApHPePKMI-9rxbC_ZXW-8Lp-uPmGywJlDFgsX1O_MMKrin6E5AKmEtTfLkzwDIcrS"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636429608733454,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 62480612210,
                        "nickname": "是花花啊🥨",
                        "unique_id": "Meng1025_",
                        "sec_uid": "MS4wLjABAAAAtK3lUOvcyvQW-zD6MZiqXDDN5AyLDDRwamW4dZ3TCi0"
                    }
                }
            },
            {
                "method": "WebcastGiftMessage",
                "msg_id": 6922631970493106951,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "用户6403941818064:送给主播 1个小心心",
                    "user": {
                        "uid": 3729150495435053,
                        "nickname": "用户6403941818064",
                        "unique_id": "dynxkkjzy929",
                        "sec_uid": "MS4wLjABAAAAeDzhQtIcCnVSxRh31oUXC6hfi92Eg0MfLH1-XaOm6DHjbIczVjcEnowr2Y6XIEaZ"
                    }
                }
            },
            {
                "method": "WebcastMemberMessage",
                "msg_id": 6922636428334205700,
                "payload": {
                    "room_id": 6922580638159719176,
                    "content": "来了",
                    "user": {
                        "uid": 68489185854,
                        "nickname": "可爱再多一点😋",
                        "unique_id": "93804960",
                        "sec_uid": "MS4wLjABAAAARQgcmfArG31g_4RteEaMGjbPmnUAu5FKNzKUoGX9TUw"
                    }
                }
            }
        ],
        "cursor": "1611801897133_6922636435245915553_1_1",
        "fetch_interval": 1000,
        "now": 1611801897133,
        "internal_ext": "fetch_time:1611801897133|start_time:1611801885555|ack_ids:6922636386029931272_107c,6922636383869831944_107c,6922636381571664647_107c,6922636382708468494_107e,6922636384503188235_1080,6922636392137624328_1082,6922636391746702084_1082,6922636391746718468_1082,6922636396302486280_1084,6922636401926228747_1086,6922636398407305987_1086,6922636399431093006_1086,6922636403406981899_1088,6922636406481373959_108a,6922636239049132800_108a,6922636408494689028_108a,6922636417961052935_108e,6922636416887704331_108e,6922636426312387341_1092,6922636427234822919_1092,6922636427368975111_1092,6922631970493106951_1094|flag:1|seq:1|next_cursor:1611801897133_6922636435245915553_1_1|door:6-n3",
        "ignores": [
            "WebcastRoomMessage",
            "WebcastLiveEcomMessage",
            "WebcastRoomUserSeqMessage"
        ]
    }
}
```
