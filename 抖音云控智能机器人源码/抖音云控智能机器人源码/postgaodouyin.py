import requests
import zlib
import gzip
import fridar


def urlparse(data):
    if isinstance(data, dict):
        params = ''
        for k, v in data.items():
            params += k + '=' + v + '&'
        return params[0:-1]
    else:
        raise ValueError('Need a Dect')


def unurlparse(s):
    if isinstance(s, str):
        data = {}
        for i in s.split('&'):
            sin = i.split('=')
            data[sin[0]] = sin[1]
        return data
    else:
        raise ValueError('Need a String')


def enter_room(room_id):

    url = 'https://webcast3-normal-c-lf.amemv.com/webcast/room/enter/'
    param_str = 'webcast_sdk_version=1270&webcast_language=zh&webcast_locale=zh_CN_%23Hans&manifest_version_code=860&_rticket=1588240199831&ac=wifi&app_type=normal&device_id=71613991215&iid=395457251250605&mcc_mnc=46001&os_version=10&channel=wandoujia_aweme2&version_code=860&device_type=ELE-AL00&language=zh&resolution=1080*2265&openudid=eb5b54610b8eddc9&update_version_code=8602&app_name=aweme&version_name=8.6.0&os_api=29&device_brand=HUAWEI&ssmix=a&device_platform=android&dpi=480&aid=1128&ts=1588240199'
    params = unurlparse(param_str)

    # do something
    print(params)

    params = urlparse(params)
    url = url + '?' + params
    headers = {
        'Accept-Encoding': 'gzip',
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
        'User-Agent': 'com.ss.android.ugc.aweme/860 (Linux; U; Android 10; zh_CN_#Hans; ELE-AL00; Build/HUAWEIELE-AL00; Cronet/58.0.2991.0)',
        'Cookie': 'install_id=395457251250605; ttreq=1$a39bbdea11f79040b5339bc87ff497456460c842; install_id=395457251250605; ttreq=1$a39bbdea11f79040b5339bc87ff497456460c842; passport_csrf_token=2fbb2a8607eed1131b1619dec916eac1; passport_csrf_token=2fbb2a8607eed1131b1619dec916eac1; d_ticket=6eae8df6d6f98adf8fe6befdb0539401fa74f; odin_tt=74bae2d6fe87ae5d112e757d15b9e5b3dd41feeb6d70530c004946a53c3919f8b5cdcb7c89f9564493282f17f80c2c9266452c4fc526080d51236038d03b1091; sid_guard=32355e16bf63634f7c0f5796f0e5fc2c%7C1588236100%7C5184000%7CMon%2C+29-Jun-2020+08%3A41%3A40+GMT; uid_tt=c93b445d00c461eef0b61337dbe91fc8; uid_tt_ss=c93b445d00c461eef0b61337dbe91fc8; sid_tt=32355e16bf63634f7c0f5796f0e5fc2c; sessionid=32355e16bf63634f7c0f5796f0e5fc2c; sessionid_ss=32355e16bf63634f7c0f5796f0e5fc2c; d_ticket=6eae8df6d6f98adf8fe6befdb0539401fa74f; odin_tt=74bae2d6fe87ae5d112e757d15b9e5b3dd41feeb6d70530c004946a53c3919f8b5cdcb7c89f9564493282f17f80c2c9266452c4fc526080d51236038d03b1091; sid_guard=32355e16bf63634f7c0f5796f0e5fc2c%7C1588236100%7C5184000%7CMon%2C+29-Jun-2020+08%3A41%3A40+GMT; uid_tt=c93b445d00c461eef0b61337dbe91fc8; sid_tt=32355e16bf63634f7c0f5796f0e5fc2c; sessionid=32355e16bf63634f7c0f5796f0e5fc2c'
    }
    headers = fridar.get_headers(url, headers)
    data = {
        'room_id': room_id,
        'hold_living_room': '1',
        'is_login': '1',
        'enter_type': 'click',
        'enter_source': 'homepage_fresh-live_cover',
        'request_id': '202004301721400100140460191507E3F6',
    }
    res = requests.post(url, headers=headers, data=data)
    try:
        print(res.json())
    except:
        print(res.text)


enter_room(6821470275415051008)

