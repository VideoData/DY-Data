/*
 * @Author: your name
 * @Date: 2020-10-28 15:55:54
 * @LastEditTime: 2020-11-20 13:21:06
 * @LastEditors: Please set LastEditors
 * @Description: 执行命令行 命令是空格需要双引号包裹，不然报错
 * @FilePath: \test\src\nodeModule\ffmpegCmd.ts
 */
import path from "path";
const { exec, spawn } = require('child_process');
let ffmpegPath = process.env.ffmpegStatic;
let ffprobePath = process.env.ffprobeStatic;
let basePath = path.resolve(__dirname, "./../core/");
// 更新打包后 ffmpeg、ffprobe 路径
if (process.env.NODE_ENV === "production") {
  ffmpegPath = path.join(basePath,'ffmpeg.exe');
  ffprobePath = path.join(basePath,'ffprobe.exe');
}
let ffmpegPathStr = `"${ffmpegPath}"`;
ffprobePath = `"${ffprobePath}"`;
interface Option {
    absolutePath: string; // 下载地址
    fileName: number; // 文件名字
}
export default class ffmpegCmd {
    option: Option;
    constructor(option: Option) {
        this.option = option;
    }
    // 合并视频
    merge() {
        return new Promise((resolve, reject) => {
            exec(`${ffmpegPathStr} -h`, (err: string) => {
                if (err) {
                    return reject({
                        code: 1,
                        err: err.toString(),
                    })
                }
                console.log(process.cwd(), '---', this.option.absolutePath);
                const mergeVideo = spawn(ffmpegPathStr, ['-y', '-f', 'concat', '-safe', 0, '-i', '1.txt', '-c', 'copy', `${this.option.fileName}.mp4`],
                {
                    cwd: this.option.absolutePath,
                    windowsVerbatimArguments: true,
                    shell: true
                });
                console.log(process.cwd(), '---');
                mergeVideo.stdout.on('data', (data: any) => {
                    console.log(`stdout--------: ${data}`);
                });
                mergeVideo.stderr.on('data', (data: any) => {
                    console.error(`stderr: ${data}`);
                });
                mergeVideo.on('error', (err: any) => {
                    console.error('启动子进程失败', err);
                  });
                mergeVideo.on('close', (code: number) => {
                    if (code !== 0) {
                        console.log(`ps 进程退出，退出码 ${code}`);
                        return reject({
                            code: 1,
                            err: '程序错误',
                        })
                    } else {
                        resolve({
                            code: 0,
                            content: this.option.absolutePath + '\\' + this.option.fileName + '.mp4'
                        })
                    }
                });
            })
        })
    }
}