# Douyin-DownloadAllVideo
Easily download all the videos from TikTok.下载指定的抖音号的所有视频，爬虫

# 特别声明
# 本项目仅供学习使用，不用做任何其他商业用途！


# Requirement
  * python
  * selenium
  * BeautifulSoup
  * redis

## v2.0新增功能
* 通过手机app分享链接直接爬取单个视频或者全部视频
* 新增web端，一键爬爬爬爬

<center class="half">
 <img src="https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/s.jpeg" width="320"/>
 
 <img src="https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/q.jpeg" width="320"/>
</center>

<!-- ![](https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/s.jpeg)
![](https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/q.jpeg) -->

# 功能
  * 爬取指定用户的所有视频
  * 爬取包含指定搜索关键词的前1k个热门视频
  * 爬取包含指定搜索关键词的前1k个热门用户

# 本地爬虫用法
## 爬取指定up
打开 `https://www.douyin.com` ，搜索你需要下载的up主，将up主主页链接粘贴至`douyin_url.txt`文件中，可以同时下载多个up，每个up的链接独占一行，
文件最后一行用`##end##`结尾

此处用冯提莫作为例子：

https://www.douyin.com/user/MS4wLjABAAAAbgCnupO_NGaTAmzWnXSivCeHWrOe0wC2ZcpNvVoQfEk?extra_params=%7B%22search_id%22%3A%22202107072151000102121640354914D12F%22%2C%22search_result_id%22%3A%2258958068057%22%2C%22search_keyword%22%3A%22%E5%86%AF%E6%8F%90%E8%8E%AB%22%2C%22search_type%22%3A%22video%22%7D&enter_method=search_result&enter_from=search_result

 然后直接运行 python douyin.py 即可开始下载
 
![](https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/ftm_f.png)
![](https://github.com/Mrhs121/Douyin-DownloadAllVideo/blob/main/ftm_video.png)
 
 ## 爬取指定关键词
 直接修改`_down_by_keyword`函数中间的`key_word`变量即可
 
 
 # web版爬虫
 * `python http_server.py`
 * 爬虫首页: ip:8888 
 * 监控页面: ip:8888/q
 
 # 原理
 
 1. 抖音web版的html是由js生成，如果直接用requests获取html是没法获取到有效数据的，故而用selenium模拟浏览器获取html，然后再用BeautifulSoup解析url
 2. 抖音web版的数据是通过下滑鼠标刷新得到的，所以只用webdriver获取一次的话只能拿到前面十几条视频，所以此处用 `js="var q=document.documentElement.scrollTop=100000"`模拟鼠标下滑，循环多次直到url的数量不再发生变化即视为已经获取到了所有视频播放页面的url
 3. 拿到播放页面的url之后，通过正则 `v26.douyinvod.com(.+?)%2F%3F` html拿到最终的视频链接（此处用selenium也可以实现）
 
 
