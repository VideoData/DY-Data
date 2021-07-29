/*
 * @Author: your name
 * @Date: 2020-11-23 15:55:05
 * @LastEditTime: 2020-11-26 15:19:56
 * @LastEditors: Please set LastEditors
 * @Description: 快手
 * @FilePath: \electronVue\src\nodeModule\kuaishou.ts
 */
const got = require('got');
interface Option {
    userUrl?: String; // 用户主页分享地址
    saveDirectory?: string; // 视频保存地址
}
 export default class KuaiShou {
    // 条数
    count: number = 18
    path: string = 'https://c.kuaishou.com/rest/kd/feed/profile';
    shareUrl: string = 'https://v.kuaishou.com/7iQQ1n';
    // 用户id
    user_id: string = '';
    pcursor: string = '1.600662093E12';
    option: any;
    constructor(option?: Option) {
        this.option = option;
        this.getUserId();
    }

    getUserId(){
        got(this.shareUrl)
        .then((res: any) => {
            const params = res.req.path.split('?')[0].split('/');
            this.user_id = params[params.length - 1];
            this.getUserVideoList();
        })
        .catch((err: any) => {
            console.log(err)
            return {
                code: 1,
                err,
            };
        })
    }

    // 获取用户作品列表
    getUserVideoList() {
        if (!this.user_id) {
            return {
                code: 1,
                err: '没有用户id'
            }
        }
         got.post(this.path, {
            json: {
                count: this.count,
                eid: this.user_id,
                pcursor: this.pcursor,
            },
            headers: {
                'Content-Type': 'application/json; charset=UTF-8',
                'User-Agent': 'Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1',
                'Cookie': 'didv=1605681940000; clientid=3; client_key=65890b29; did=web_fde2ce540a15e1f17e8fc955e3c3f836; sid=572af189accd9dd90625ff5d; Hm_lvt_86a27b7db2c5c0ae37fee4a8a35033ee=1605852393,1606117648,1606187297,1606368771; Hm_lpvt_86a27b7db2c5c0ae37fee4a8a35033ee=1606371245'
            }
        })
        .then((res: any) => {
            console.log(res.body, '--')
        })
        .catch((err: any) => {
            console.log(err)
        });
    }

 }