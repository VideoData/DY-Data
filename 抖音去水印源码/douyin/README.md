# 抖音爬虫
本项目支持通过分享链接去水印以及获取某用户发布的所有视频
## 去水印
去水印主要由[static](./static),[templates](./templates),[Douyin.py](./Douyin.py),[single_video_test.py](./single_video_test.py)四个部分组成。
`single_video_test.py`是本地调试所写的代码，如果本地有`Python`环境可以直接运行该文件进行单个文件去水印下载。
`static` `templates` `Douyin.py`是使用`requests`和`flask`部署服务器上的程序，在输入框内输入复制的抖音分享链接（全部复制进去，程序会自动获取网址链接），稍等片刻浏览器就开始下载去水印视频了。
演示demo：https://dy.0941314.xyz/
## 下载用户所有视频
~~这部分主要由[douyin_signature](./douyin_signature),[user_video_test.py](./user_video_test.py)两个文件组成。
`douyin_signature`文件夹有详细说明，主要是本地要安装`node`环境，参见里面的[README.md](./douyin_signature/README.md)。该文件夹内的程序来自[skygongque](https://github.com/skygongque/douyin_signature)。这部分是用于计算`signature`参数的程序，这个参数在`user_video_test.py`里面会用到，所以要先运行这个程序再执行`user_video_test.py`。~~
这部分主要功能实现主要在这个文件中[user_video_test.py](./user_video_test.py)。由于最近抖音网页版增加了很多功能和B站风格差不多，对于 `signature` 参数，经测试可以不要这个参数。