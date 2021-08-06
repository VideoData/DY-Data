#!/usr/bin/python3
# -*- coding: utf-8 -*-
import requests
from flask import Flask,make_response,render_template,request

def get_link(share_link):
    temp = share_link.split("com/")[1].split("/")[0]
    share_url = "https://v.douyin.com/"+temp
    headers={
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36"
    }
    r = requests.get(share_url,headers)
    # 获取ID
    item_ids =r.url.split("?")[0].split("video/")[1]
    base_url='https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids='+item_ids

    res=requests.get(base_url,headers)
    # 获取无水印下载链接
    play_addr = res.json()["item_list"][0]["video"]["play_addr"]["url_list"][0].replace("playwm","play")

    video = requests.get(play_addr,headers)
    # print(video.headers)
    # with open(item_ids+".mp4","wb") as f:
    #     f.write(video.content)

    return video.content,item_ids

app = Flask(__name__)

@app.route("/douyin",methods=["POST","GET"])
def douyin():
    if request.method=="POST":
        result=request.form

    video,filename=get_link(result["share_link"])
    print(filename)
    response = make_response(video) #将video字节流封装成response对象

    # 添加响应头部信息
    response.headers['Content-Type'] = "video/mp4"
    # attachment表示以附件形式下载
    response.headers['Content-Disposition'] = 'attachment; filename='+filename+'.mp4'
    return response

@app.route("/",methods=["POST","GET"])
def index():
    return render_template("index.html")


if __name__ == "__main__":
    app.run(debug=False, host="0.0.0.0",port=3000)