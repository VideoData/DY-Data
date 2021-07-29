/*
 * @Author: your name
 * @Date: 2020-11-25 11:46:45
 * @LastEditTime: 2020-11-27 17:40:34
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\src\nodeModule\huoshan.ts
 */

const got = require('got');
const qs = require('qs');
interface Option {
    userUrl?: String; // 用户主页分享地址
    saveDirectory?: string; // 视频保存地址
}
 export default class KuaiShou {
    // 条数
    count: number = 18
    max_cursor: number = 0
    option: any;
    shareUrl: string = 'https://share.huoshan.com/hotsoon/s/eOvnCiybBd8/';
    getListUrl: string = ' https://share.huoshan.com/api/user/video?';
    // 用id换回无水印video_id
    noVideoUrl: string = 'https://share.huoshan.com/api/item/info?item_id=';
    // 无水印地址
    videoUrl: string = 'https://api.huoshan.com/hotsoon/item/video/_source/?video_id=';
    constructor(option?: Option) {
        this.option = option;
        return this.getUrl(this.shareUrl);
    }

    getUrl(shareUrl: string) {
        return got(shareUrl).then((res: any) => {
            const to_user_id = qs.parse(res.req.path.split('?')[1]).to_user_id;
            return this.getVideoList(to_user_id);
        })
        .catch((err:any) => {
            return {
                code: 1,
                err,
            };
        })
    }

    // 获取视频列表（有水印）
    getVideoList(to_user_id: string){
        const params = {
            encrypted_id: to_user_id,
            offset: 0,
            count: 30,
        };
        return got(this.getListUrl + qs.stringify(params))
        .then(async (res: any) => {
            const body = JSON.parse(res.body);
            const videoArr: any = [];
            if (+body.status_code === 0) {
                for (let item of body.data) {
                    await got(this.noVideoUrl + item.item_id)
                    .then((res: any) => {
                        const body = JSON.parse(res.body);
                        if (+body.status_code === 0) {
                            const video_id = qs.parse(body.data.item_info.url.split('?')[1]).video_id;
                            videoArr.push({
                                videoUrl: this.videoUrl + video_id,
                                cover: body.data.item_info.cover
                            })
                        }
                    })
                    .catch((err: any) => {
                        console.log(err)
                    })
                }
                    return {
                        code: 0,
                        content: videoArr
                    };
            } else {
                return {
                    code: 1,
                    err: '请求失败',
                };
            }
        })
        .catch((err: any) => {
            console.log(err)
            return {
                code: 1,
                err,
            };
        })
    }
    
 }