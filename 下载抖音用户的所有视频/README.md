# 下载指定的抖音号的所有视频、下载某个抖音账号下所有视频


# 项目功能
#### 爬取指定用户的所有视频
#### 根据指定搜索关键词的前1k个热门视频
#### 根据指定搜索关键词的前1k个热门用户
#### 通过手机app分享链接直接爬取单个视频或者全部视频
#### 新增web端，一键爬取所有视频

# 项目环境依赖
```
python
selenium
BeautifulSoup
redis
```

# 本地爬虫使用方法
### 1)爬取指定用户的所有视频

打开抖音，搜索你需要下载的up主，将up主主页链接粘贴至douyin_url.txt文件中，      
可以同时粘贴多个up，每个up的链接独占一行， 文件最后一行用 ##end## 结尾

### 2)根据指定关键词爬取
直接修改_down_by_keyword 函数中间的 key_word 变量即可



# web版爬虫使用方法  
```
python http_server.py
爬虫首页: ip:8888
监控页面: ip:8888/q
```


# 项目原理
1、抖音web版的html是由js生成，如果直接用requests获取html是没法获取到有效数据的,  
     故而用selenium模拟浏览器获取html，然后再用BeautifulSoup解析url  

2、抖音web版的数据是通过下滑鼠标刷新得到的，所以只用webdriver获取一次的话只能拿到前面十几条视频  
     所以此处用 js="var q=document.documentElement.scrollTop=100000"模拟鼠标下滑,  
     循环多次直到url的数量不再发生变化即视为已经获取到了所有视频播放页面的url  

3、拿到播放页面的url之后，通过正则 v26.douyinvod.com(.+?)%2F%3F html拿到最终的视频链接（此处用selenium也可以实现）


## [作者源码](https://github.com/Mrhs121/Douyin-DownloadAllVideo)  

#  免责声明
```
有任何问题可交流学习  
请勿使用本服务于商用  
请勿使用本服务大量抓取  
若因使用本服务与平台造成不必要的纠纷，本人盖不负责  
本人纯粹技术爱好，若侵犯贵公司的权益，请告知  
```
