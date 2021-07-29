/*
 * @Author: your name
 * @Date: 2020-10-28 15:58:16
 * @LastEditTime: 2020-11-19 18:05:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \test\src\nodeModule\fluentFfmpeg.ts
 */

import { resolve } from "path";
const ffmpeg = require('fluent-ffmpeg');
const path = require('path');
let ffmpegPath = process.env.ffmpegStatic;
let ffprobePath = process.env.ffprobeStatic;
let basePath = resolve(__dirname, "./../core/");


// 更新打包后 ffmpeg、ffprobe 路径
if (process.env.NODE_ENV === "production") {
  ffmpegPath = path.join(basePath,'ffmpeg.exe');
  ffprobePath = path.join(basePath,'ffprobe.exe');
}

// console.log(ffmpegPath, ffprobePath, '******')

// 设置 fluent-ffmpeg 的 ffmpeg 、ffprobe路径
ffmpeg.setFfmpegPath(ffmpegPath);
ffmpeg.setFfprobePath(ffprobePath);

interface Option {
    absolutePath: string; // 绝对地址
    fileName: number; // 文件名字
}
export default class fluentFfmpeg{
    option: Option;
    constructor(option: any) {
        this.option = option;
    }
    init() {
        process.chdir(this.option.absolutePath)
        return new Promise((resolve, reject) => {
            ffmpeg('1.mp4')
            .inputOptions(
                '-ss', '00:00:02',
                '-i', '1.mp4',  '-r', '1', '-q:v', 
                '100', '-vframes', '50',  '-f', 'image2', 'image-%d.png'
            ).on('error', function (err: any) {
                console.log('处理发生错误: ' + err.message);
                reject({
                    code: 1,
                    err: err.message,
                })
            }).on('end', function () {
                resolve({
                    code: 0,
                })
                console.timeEnd()
            }).save('../output.mp4');
        })
    }
}