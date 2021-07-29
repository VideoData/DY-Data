/*
 * @Author: your name
 * @Date: 2020-10-27 14:40:54
 * @LastEditTime: 2021-06-02 10:28:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-electron\src\node\douYiVideo.js
 */
const got = require('got');
const qs = require('qs');
interface Option {
    userUrl?: String; // 用户主页分享地址
    saveDirectory?: string; // 视频保存地址
}

let maxCursor: number = 0;
let minCursor: number = 0;
export default class downVideo  {
    // sec_user_id=MS4wLjABAAAASIgaZVqDUhCG4u3ifEf4cbdoIT-EiSIHP9Xh-1AHgu0
    // .replace(/\s+/g, '')
    videoListUrl: string = 'https://aweme.snssdk.com/aweme/v1/aweme/post/?';
    // 视频地址
    videoUrl: string = 'https://aweme.snssdk.com/aweme/v1/play/?video_id='
    option: any;
    constructor(option?: Option) {
        this.option = option;
        return this.shareCodeParsing();
    }
    /**
     * 抖音短链接解析
     */
    shareCodeParsing() {
        if (this.option.userUrl.match(/v.douyin.com/g)) {
            return got(this.option.userUrl, {
                timeout: 10000
                }).then((response: any) => {
                    console.log(response.url);
                    this.option.userUrl = response.url;
                    return this.getUserId();
                }).catch((err: any) => {
                    return {
                        code: 1,
                        err,
                    }
                })
        } else {
            return this.getUserId()
        }
    }
    /**
     * 通过url获取用户id
     */
    getUserId() {
        const { sec_uid } = qs.parse(this.option.userUrl.split('?')[1]);
        let params = {
            sec_user_id: sec_uid,
            count: 21,
            max_cursor: maxCursor,
            min_cursor: minCursor,
        }
        console.log(this.videoListUrl + qs.stringify(params))
        return this.init(this.videoListUrl + qs.stringify(params));
    }

    init(url: string) {
        return got(url, {
            timeout: 10000,
            headers: {
                'User-Agent': 'AwemeLite 12.9.0 rv:129005 (iPhone; iOS 13.5.1; zh_CN) Cronet',
                'x-common-params-v2': `os_api=18&device_platform=iphone&device_type=iPhone9,1&iid=1107947072792078&version_code=12.9.0&app_name=douyin_lite&openudid=57ee12cbcb7c09cf1f4563b87d6f016f1f3a9ec8&device_id=${Math.ceil(Math.random()*10000)}&os_version=13.5.1&aid=2329&channel=App%20Store&cdid=A91D75B8-D570-441F-A80A-E3C20C0D07F5&ac=WIFI`
            }
        })
        .then((res: any) => {
            const {aweme_list, max_cursor, min_cursor } = JSON.parse(res.body);
            maxCursor = max_cursor;
            minCursor = min_cursor;
            // 视频地址
            const videoArr = [];
            for (let item of aweme_list) {
                videoArr.push({
                    videoUrl: this.videoUrl + item.video.play_addr.uri,
                    desc: item.desc,
                    cover: item.video.animated_cover.url_list[0],
                    select: false,
                    id: item.aweme_id,
                });
            }
            return {
                code: 0,
                content: videoArr
            };
        })
        .catch((err: any) => {
            return {
                code: 1,
                err,
            }
        })
    }

}