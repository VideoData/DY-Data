

import requests
from bs4 import BeautifulSoup
import re
import os
from ThreadPool import ThreadPool
from functools import partial
from tqdm import tqdm
from selenium import webdriver
import redis

redis_pool = redis.ConnectionPool(host='0.0.0.0', port=6379, decode_responses=True)
# pool = redis.ConnectionPool(host=conf.REDIS_IP, port=6379, decode_responses=True)
redis_client = redis.Redis(connection_pool=redis_pool)
name_url = {}

user_agent = [
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36",
    "Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)",
    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
    "Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
    "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
    "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
    "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
    "Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
    "Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
    "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
    "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52"
]

get_HEADER = {
    'User-Agent': user_agent[2],  # 浏览器头部
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
    # 客户端能够接收的内容类型
    'Accept-Language': 'en-US,en;q=0.5',  # 浏览器可接受的语言
    'Connection': 'keep-alive',  # 表示是否需要持久连接
    'Host': 'v26.douyinvod.com'

}

down_HEADER = {
    'User-Agent': user_agent[0],  # 浏览器头部
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9',
    # 客户端能够接收的内容类型
    'Accept-Language': 'en-US,en;q=0.5',  # 浏览器可接受的语言
    'Connection': 'keep-alive',  # 表示是否需要持久连接
    'Host': 'v26.douyinvod.com'

}

option = webdriver.ChromeOptions()
option.add_argument('--headless')
driver = webdriver.Chrome(options=option)

pool = ThreadPool(max_workers=8)
pool.start()
#cookie = {i.split("=")[0]: i.split("=")[1] for i in c.split(";")}
print("初始化爬虫")

save_path_prefix = '../douyin_videos'


def up_is_exist(name):
    folder = os.path.exists(os.path.join(save_path_prefix, name))
    if not folder:
        return False
    return True


def download(url, dirname, file_name='a.mp4', prefix=save_path_prefix):
    r = requests.get(url, down_HEADER)
    if r.status_code == 200:
        path = os.path.join('', prefix, dirname)
        folder = os.path.exists(path)
        if not folder:
            os.makedirs(path)
        # print("下载 "+ url)
        with open(os.path.join('', prefix, dirname, file_name), "wb") as code:
            code.write(r.content)
        #         code = '200'
        return "200"
    else:
        print('\n http error : ', r.status_code)
        #         code = '404'
        return "404"


def getHTMLText(url):
    r = requests.get(url, get_HEADER)
    #     print("status_code: ", r.status_code)
    #         r.raise_for_status()
    #         r.encoding = r.apparent_encoding
    r.encoding = "utf-8"
    return r.text, r.status_code


def down_one_video(url, name, index):
    try:
        html, code = getHTMLText(url)
        # html = driver.get(url)
        soup = BeautifulSoup(html, 'html.parser')
        # video = soup.find(name='video',attrs={'class':'mtz-vlc-klfbf'})
        title = soup.find(name='title').text
        # print(html)
        import re
        base_url = 'https://v26.douyinvod.com{}'
        base_url = 'https://v3-web.douyinvod.com{}'
        prefix = 'v3-web.douyinvod.com'

        res = re.findall(r"v3-web.douyinvod.com(.+?)%2F%3F", html)
        if res == None:
            print("没有检索到视频url")
            return
        res = res[0]
        res = str(res).replace('%2F', '/')
        # print('download ', title, base_url.format(res) + '/')
        download(base_url.format(res) + '/', name, file_name='{}.mp4'.format(title))
    except Exception as e:
        print('ERROR', e, url)
        pass


def down_up_by_appshare(url):
    print('开始下载 ', url)
    try:
        html, code = getHTMLText(url)
        # html = driver.get(url)
        soup = BeautifulSoup(html, 'html.parser')
        title = soup.find(name='title').text
        # print(html)
        import re
        base_url = 'https://v3-web.douyinvod.com{}'
        res = re.findall(r"v3-web.douyinvod.com(.+?)%2F%3F", html)[0]
        up_div = soup.find(name='div', attrs={'class': '_976c31c5a089c1b1b6d8809f82aa9a7a-scss'})
        up_url = up_div.find(name='a')
        print('up 主页url: ', up_url['href'])
        res = str(res).replace('%2F', '/')
        # print('download ', title, base_url.format(res) + '/')
        down_one_user(up_url['href'], url)
        # download(base_url.format(res) + '/', name, file_name='{}.mp4'.format(title))
    except Exception as e:
        print('ERROR', e)
        pass


def down(lis, name):
    redis_client.hdel('pending', name_url[name])
    # redis_client.hset('fi', name, " [{}/{}]".format(index, len(lis)))
    for index, li in enumerate(tqdm(lis, desc=name,ncols=100)):
        try:
            a = li.find(name='a')['href']
            # print('download',a)
            down_one_video(a, name, index)
            redis_client.hset('in', name,
                              str(round((index + 1) / len(lis), 2) * 100) + '%' + " [{}/{}]".format(index, len(lis)))
        except Exception as e:
            print('ERROR', e)
            pass
    redis_client.hset('fi', name, " [{}/{}]".format(index, len(lis)))
    redis_client.hdel('in', name)



def down_one_user(url, shared_url=''):
    global name_url
    option.add_argument('--headless')
    driver = webdriver.Chrome(options=option)
    # driver = webdriver.Chrome()
    # global driver
    print(url)
    if '##end##' in url:
        print('-' * 20, ' download finished ', '-' * 20)
        driver.quit()
        import sys

    import time
    count = 0
    num_of_video = 0
    times = 0
    driver.get(url)
    name = ''
    _lis = None
    _up_is_exist = False
    while True:
        html = driver.page_source
        soup = BeautifulSoup(html, 'html.parser')
        title = soup.find(name='title')
        # print(description['content'].split('：')[0])
        import string, random
        ba = ''.join(random.sample(string.ascii_letters + string.digits, 8))
        name = title.text.split('的个人主页')[0]
        name_url[str(name)] = str(shared_url)
        if up_is_exist(name):
            _up_is_exist = True
            break;
        if count == 0:
            print(name)
        count += 1
        lis = soup.findAll(name='li', attrs={"class": 'e0fe394964bbd9fef7d310c80353afdd-scss'})
        # print(li)
        _lis = lis
        for li in lis:
            a = li.find(name='a')
            # print(a['href'])
        print('=' * 15, '>', name, ' len:', len(lis))
        if len(lis) == num_of_video:
            times += 1
        if len(lis) == num_of_video and times > 2:
            # print("所有视频检索完毕", name, len(lis))
            # down(lis,name)
            break
        num_of_video = len(lis)
        # e0fe394964bbd9fef7d310c80353afdd - scss
        # print(html)
        js = "var q=document.documentElement.scrollTop=100000"
        for i in range(0, 5):
            driver.execute_script(js)
            time.sleep(1)
        time.sleep(1)
    if _up_is_exist:
        print(name, ' 已存在')
        redis_client.hdel('pending', name_url[name])
        redis_client.hset('fi', name, '已存在')
    else:
        print("所有视频检索完毕", name, len(lis))
        pool.submit(partial(down, lis, name))
    # down(lis, name)
    driver.quit()


def down_list():
    global driver
    option.add_argument('--headless')
    driver = webdriver.Chrome(options=option)
    for url in open("douyin_urls.txt"):
        down_one_user(url)


def down_by_search(key_word, filename):
    # global driver
    # option.add_argument('--headless')
    # driver = webdriver.Chrome(options=option)
    urls = []
    for url in open(filename):
        urls.append(url)
    for index, url in enumerate(tqdm(urls)):
        down_one_video(url, key_word, index)
    # driver.quit()


import time


def down_by_keyword(key_word, filename):
    global driver
    driver = webdriver.Chrome()
    # a3cc5072a10a34f3d46c4e722ef788c1 - scss
    base = 'https://www.douyin.com/search/{}?publish_time=0&sort_type=1&source=normal_search&type=video'
    # base = 'https://www.douyin.com/search/%E5%A4%A7%E9%95%BF%E8%85%BF?publish_time=0&sort_type=0&source=normal_search&type=video'
    driver.get(base.format(key_word))
    js = "var q=document.documentElement.scrollTop=100000"
    time.sleep(20)
    for i in range(0, 2):
        driver.execute_script(js)
        time.sleep(0.5)
    html = driver.page_source
    # print(html)
    soup = BeautifulSoup(html, 'html.parser')
    # users = soup.findAll(name='li',attrs={"class":'be642325476cd60928ab49ab10619761-scss'})
    users = soup.findAll(name='li', attrs={"class": 'a3cc5072a10a34f3d46c4e722ef788c1-scss'})
    print(len(users))
    users_url = []
    for user in users:
        # print(user)
        # url = user.find(name='a',attrs='caa4fd3df2607e91340989a2e41628d8-scss cfe2ef83d29eb6b3f56d991142d5e56e-scss _05b3a1a1aef60a7f51ee7a015550c6b4-scss')
        url = user.find(name='a')
        print(url['href'])
        users_url.append(url['href'])
        print('-' * 60)
        # print(user)
        # print('-'*60)
    # for user in users_url:
    with open(filename, 'a+') as f:
        for user in users_url:
            f.write(str(user) + '\n')  # 加\n换行显示
    driver.quit()


def _down_by_keyword():
    for key_word in ['海贼王']:
        url_file_name = key_word + '.txt'
        down_by_keyword(key_word, url_file_name)
        # down_list()
        down_by_search(key_word, url_file_name)
    driver.quit()

# driver.quit()
# pool.stop()


