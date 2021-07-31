from flask import Flask, request, jsonify,render_template
from douyin import *
from concurrent.futures import ThreadPoolExecutor
import json
executor =ThreadPoolExecutor(8)
app = Flask(__name__)
import redis
redis_pool = redis.ConnectionPool(host='127.0.0.1',port=6379, decode_responses=True)
redis_client = redis.Redis(connection_pool=redis_pool)

pro = redis_client.hgetall('in')
for key in pro:
    redis_client.hdel('in',key)
fi = redis_client.hgetall('fi')
for key in fi:
    redis_client.hdel('fi',key)
pending = redis_client.hgetall('pending')
for key in pending:
    redis_client.hdel('pending',key)

@app.route('/')
def index():
    return render_template('index.html')

def Find(string):
    # findall() 查找匹配正则表达式的字符串
    pattern = re.compile(r'http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\(\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+')  # 匹配模式
    url = re.findall(pattern,string)
    return url

@app.route('/down/',methods=['post'])
def download():
    # print('request.data ',request.data)
    if not request.data:   #检测是否有数据
        print('fail')
        return 'fail'
    dy = request.data.decode('utf-8')
    shared_url = Find(str(dy))
    if len(shared_url) == 0:
        return "无效链接"
    else:
        redis_client.hset('pending',str(shared_url[0]),'0')
        executor.submit(down_up_by_appshare, str(shared_url[0]))
    # down_up_by_appshare()
    return "yes"
    #返回JSON数据。

@app.route('/q')
def q():
    # for key in redis_client.hscan_iter('in'):
    #     print(key)
    pro = redis_client.hgetall('in')
    fi = redis_client.hgetall('fi')
    pending = redis_client.hgetall('pending')
    res = "<h1>进度监控</h1><br>"
    for key in pro:
        data = key + '    ' + pro[str(key)] + '<br>'
        res+=data
    fi_res = "<br><h1>已完成</h1><br>"
    for key in fi:
        data = key + '    ' + fi[str(key)] + '<br>'
        fi_res+=data
    pending_res = "<br><h1>排队中</h1><br>"
    for key in pending:
        data = key + '    ' + pending[str(key)] + '<br>'
        pending_res+=data

    return '<meta http-equiv="refresh" content="2"> '+pending_res+res+fi_res
    #返回JSON数据。

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8888, debug=True)
