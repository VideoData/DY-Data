ffmpeg -i input.mp4 -i logo.png -filter_complex 'overlay=main_w-overlay_w-10:main_h-overlay_h-10' output.mp4

ffmpeg -i 1.mp4 -vf "drawtext=fontfile=simhei.ttf: text=@青菜家生活馆:x=490:y=1230:fontsize=30:fontcolor=white:shadowy=2" output.mp4

ffmpeg -i 1.mp4 -vf "drawtext=text=@青菜家生活馆:x=490:y=1230:fontsize=30:fontcolor=green" output.mp4

ffmpeg -filters

模糊 ffmpeg -i input.mp4 -vf "boxblur=2:1:cr=0:ar=0" output.mp4

ffmpeg -i input.mp4 -vf "blend=all_expr='A*(if(gte(T,10),1,T/10))+B*(1-(if(gte(T,10),1,T/10)))'" output.mp4

ffmpeg -i input.mp4 -h filter=bbox output.mp4    Compute bounding box for each frame  视频的每一个帧上计算边界框.


1.对比度 ffmpeg -i input.mp4 -vf "eq=contrast=1.3:brightness=0.1:saturation=1.6:gamma=466" mix.mp4
2.亮度
3.饱和度
4.伽马
5.模糊
6.vidstabtransform  平滑/反锐化处理视频.
7.noise  视频输入帧上添加噪声.
8.hue   调整输入视频的色相和饱和度.
9.erosion   侵蚀效果应用于视频,类似油画处理  ffmpeg -i input.mp4 -vf "erosion" erosion.mp4
10.dejudder 删除动作产生的部分颤抖.

视频
1.基本参数: 对比度 亮度 饱和度 伽马 红色 蓝色 绿色
2.片头片尾裁剪
3.边框裁剪
4.视频加速
5.模糊ee
6.加水印
7.抽帧
8.修改帧速率
9.分辨率
10.修改透明度
11.锐化
12.关键帧修改
ffmpeg -i 1.mp4 -vf select='eq(pict_type\,I)' -vsync 2 -f image2 core-%02d.jpeg
ffmpeg -i 1.mp4 -vf "select=eq(pict_type\,I)" -vsync vfr core-%04d.jpg
13.增加画中画

音频
1.变声


ffmpeg -ss 2 -to 0:16.123 -i .\in.ass -c copy .\out.ass

去logo
ffmpeg -ss 0:0.000 -to 0:5.000 -i 1.mp4 -vf "delogo=x=1:y=1:w=250:h=120:show=0" 去上边水印.mp4

ffmpeg -ss 0:5.000 -i 1.mp4 -vf "delogo=x=469:y=1159:w=250:h=120:show=0" 去除后面.mp4

ffmpeg -i 4.mp4 -i 5.mp4 -filter_complex "[0:v] [0:a] [1:v] [1:a] concat=n=2:v=1:a=1 [v] [a]" -map "[v]" -map "[a]" output.mp4

抽取帧
ffmpeg -ss 00:00:30 -i 666051400.mp4 -vframes 1 0.jpg


ffmpeg -i "concat:4.mp4|5.mp4" -c copy outlast.mp4

镜像，滑动，画中画，视频蒙版，图片蒙版，背景颜色，背景图片，背景视频，模糊拓边等等

裁边 ffmpeg -i 1.mp4 -vf crop=w:h:x:y 指定宽高裁剪.mp4 | ffmpeg -i 1.mp4 -vf crop=710:1260 居中裁剪.mp4
背景 
镜像 ffmpeg -i 1.mp4 -vf hflip 镜像.mp4
帧率调节
视频调速 0.7-1.3  ffmpeg -i 1.mp4 -vf "setpts=1.2*PTS" output.mp4
高级滤镜
添加文字水印 ffmpeg -i 1.mp4 -vf "drawtext=fontfile=simhei.ttf: text=@青菜家生活馆:x=490:y=1230:fontsize=30:fontcolor=white:shadowy=2" output.mp4
添加gif
深度处理
图片蒙层 ffmpeg -i 1.mp4 -i overlay/1.jpeg -filter_complex overlay 蒙层.mp4
元数据
伽马
颜色

改关键帧












