/*
 * @Author: your name
 * @Date: 2020-10-27 14:40:54
 * @LastEditTime: 2020-11-30 11:37:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-electron\src\node\douYiVideo.js
 */


const got = require('got');
const express = require('express');
const bodyParser = require('body-parser');
const https = require('https');
const os = require('os');
const qs = require('qs');

const http = require('http');
const path = require('path');
const fs = require('fs');
const app = express();

interface Option {
    userUrl?: String; // 用户主页分享地址
    saveDirectory?: string; // 视频保存地址
}
app.use(bodyParser.urlencoded({ extended: false }));

export default class downVideo  {
    // 条数
    count: number = 20
    max_cursor: number = 0
    aid: number = 1128
    // 视频地址
    videoUrl: string = 'https://aweme.snssdk.com/aweme/v1/playwm/?video_id='
    // 用户列表
    baseUrl: string = 'https://www.amemv.com/web/api/v2/aweme/post/?';
    option: any;
    constructor(option?: Option) {
        this.option = option;
    }
    init () {
        app.listen(8001, () => {
            console.log('Example app listening on port 3000!');
        });
    }


    // 下载文件
    downFile(url: string, name: string) {
        // const homeDir = __dirname || os.homedir()   //获取用户主目录地址
        const filename = path.join(this.option.saveDirectory, name)  //组装文件存放地址
        const file = fs.createWriteStream(filename)   //生成一个写入文件的流
        let httpType: any
        if (url.split('://')[0] === 'http') {   //判断是什么类型的请求
            httpType = http
        } else {
            httpType = https
        }
        return new Promise((resolve,reject) => {
            httpType.get(url, (response: any) => {
                response.pipe(file)    //将文件流写入
                response.on('end', () => {
                    resolve({
                        code: 0,
                        err: filename
                    })
                })
                response.on('error', (err: any) => {
                    console.log(err)
                    reject({
                        code: 1,
                        err: filename
                    })
                })
            })
        })

    }

    // 视频地址解析
    videoParsing(path: string, name: string) {
        return got(path).then((res: any) => {
            return this.downFile(res.url, `${name}${+new Date()}.mp4`)
        }).catch((err: any) => {
            console.log('视频地址解析', err)
        })
    }

}