#!/usr/bin/python
# -*- coding: utf-8 -*- 
# 抖音去水印，抖音爬虫

import json
import requests
import re
import urllib3
urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

print("===>抖音去水印")
print("===>请输入抖音视频分享链接,例如：https://v.douyin.com/ePTLB68")
input_url = input("===>")
preurl = re.findall(r'(?<=douyin.com/)\w+', input_url, re.I | re.M)


url = "https://v.douyin.com/" + preurl[0]
headers = {
    'Connection': 'keep-alive',
    'sec-ch-ua': '" Not A;Brand";v="99", "Chromium";v="90", "Microsoft Edge";v="90"',
    'Accept': '*/*',
    'X-Requested-With': 'XMLHttpRequest',
    'sec-ch-ua-mobile': '?0',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36 Edg/90.0.818.66',
    'Sec-Fetch-Site': 'same-origin',
    'Sec-Fetch-Mode': 'cors',
    'Sec-Fetch-Dest': 'empty',
    'Referer': 'https://www.iesdouyin.com/share/video/6561991332561161476/?region=CN&mid=6561671254439365390&u_code=0&titleType=title&did=MS4wLjABAAAA2Cy8LTQsppRk4gci9RcF18kdcuNyaQRtZcZt0BGbylg&iid=MS4wLjABAAAAWHQavP6vURszBFMcxNrThBB0wrNEDWNzLdTKiuW5cI_cOJvn7h0u20Uz8R292pd2&with_sec_did=1&utm_source=copy_link&utm_campaign=client_share&utm_medium=android&app=aweme&scheme_type=1',
    # 'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6',
    'Cookie': 'MONITOR_WEB_ID=4843f090-b627-46db-bbe2-f757b4ea21a0; _tea_utm_cache_1243={%22utm_source%22:%22copy_link%22%2C%22utm_medium%22:%22android%22%2C%22utm_campaign%22:%22client_share%22}'
}

# get请求短链接（关闭302重定向）
res = requests.get(url, headers=headers, allow_redirects=False)
html = res.text
# print(html)
# html = '<a href="https://www.iesdouyin.com/share/video/6561991332561161476/?region=CN&amp;mid=6561671254439365390&amp;u_code=0&amp;titleType=title&amp;did=MS4wLjABAAAA2Cy8LTQsppRk4gci9RcF18kdcuNyaQRtZcZt0BGbylg&amp;iid=MS4wLjABAAAAWHQavP6vURszBFMcxNrThBB0wrNEDWNzLdTKiuW5cI_cOJvn7h0u20Uz8R292pd2&amp;with_sec_did=1&amp;utm_source=copy_link&amp;utm_campaign=client_share&amp;utm_medium=android&amp;app=aweme&amp;scheme_type=1">Found</a>.'

# 正则匹配获得item_ids
item_ids = re.findall(r"video/(\d+)/", html)[0]

# 获取play_url
video_url = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=" + item_ids
# video_url = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=6561991332561161476"
res2 = requests.get(video_url, headers=headers, verify=False)
json_data = json.loads(res2.text)
item_list = json_data['item_list'][0]
video = item_list['video']
play_addr = video['play_addr']
playwm = play_addr['url_list'][0]
play_url = playwm.replace("playwm", "play")

# 获取标题
desc = item_list['desc']
print("===>解析成功~")
print("===>"+desc)

# 视频下载
print("===>下载中~")
video = requests.get(url=play_url, headers=headers)
with open(desc + ".mp4", 'wb')as file:
    file.write(video.content)
    file.close()
    print("===>视频下载完成！")


