<!--
 * @Author: your name
 * @Date: 2020-10-28 10:53:30
 * @LastEditTime: 2020-11-30 14:52:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \electronVue\README.md
-->
# test

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
https://v.douyin.com/JPU6cfJ/
https://www.amemv.com/web/api/v2/aweme/post/?u_code=3cc1kl0ldef9&sec_uid=MS4wLjABAAAATr4HTJGO4XQ4kOVd0_QkU9EauV1uPu7RWdKt-zd0lzuew9RT_ydkDOv8ASATZa-C&app=aweme&utm_campaign=client_share&utm_medium=ios&tt_from=copy&utm_source=copy&count=2&max_cursor=0&aid=1128

视频合并
ffmpeg -y -f concat -safe 0 -i 1.txt -c copy out.mp4

ffmpeg -f concat -i 1.txt -c copy output

ffmpeg -i 2.mp4 -c:v libx264 -strict -2 3.mp4

ffmpeg -i 1.mp4 -t 10 -s 320x240 -pix_fmt rgb24 jidu1.gif



注意：
视频保存地址不能存在空格 修复

ffmpeg 合成视频 1.txt路径用单引号包裹

转码
ffmpeg -i out.ogv -vcodec h264 out.mp4
附加选项：
        -r 指定帧率，
        -s 指定分辨率，
        -b 指定比特率；于此同时可以对声道进行转码，
        -acodec 指定音频编码，
        -ab 指定音频比特率，
        -ac 指定声道数
ffmpeg -i out.ogv -s 640x480 -b 500k -vcodec h264 -r 29.97 -acodec libfaac -ab 48k -ac 2 out.mp4


转换格式
   1.ffmpeg -i D:/temp1.avi -f mpeg D:/result1.mpg
   2.copy /b "D:/result1.mpg"+"D:/result1.mpg" "D:/result.mpge"
   3.ffmpeg -i "D:/result.mpge" -f mp4 "D:/result.mp4"