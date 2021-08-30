# -*- coding:utf-8 -*

import requests
from google.protobuf import json_format
import gzip
import brotli
import os
import re
url = "https://webcast3-normal-c-hl.amemv.com/webcast/room/6831775107220769536/_fetch_message_polling/?webcast_sdk_version=1530&webcast_language=zh&webcast_locale=zh_CN_%23Hans&manifest_version_code=110201&_rticket=1590652825343&app_type=normal&iid=2594490530661252&channel=huawei_1&device_type=ELE-AL00&language=zh&cpu_support64=false&host_abi=armeabi-v7a&resolution=1080*2265&openudid=7d44cf91a2319007&update_version_code=11209900&cdid=f21bff26-f6d1-4511-8065-5d9a0597e0c4&os_api=29&mac_address=F8%3A9A%3A78%3A11%3A14%3AEA&dpi=480&oaid=f9e77fc9-f69b-fa59-4ffb-f7dfdf9fedfb&ac=wifi&device_id=68398751762&mcc_mnc=46001&os_version=10&version_code=110200&app_name=aweme&version_name=11.2.0&device_brand=HUAWEI&ssmix=a&device_platform=android&aid=1128&ts=1590652826"
body = {
    'cursor': '0',
    'last_rtt': '0',
    'live_id': '1',
    'parse_cnt': '0',
    'recv_cnt': '0',
    'resp_content_type': 'protobuf',
    'user_id': '0',
    'identity': 'audience'
}
headers = {
    'Host': 'webcast3-normal-c-hl.amemv.com',
    'Connection': 'keep-alive',
    'Content-Length': '287',
    'Cookie': 'install_id=1468587743394043; ttreq=1$5a82619ffdd6eadfcb11b44e9c996f497d8a3cdc; install_id=1468587743394043; ttreq=1$5a82619ffdd6eadfcb11b44e9c996f497d8a3cdc; passport_csrf_token=8dd87a42aefa71550018693b86991e31; odin_tt=63ff22c19bc332ee6744163838f9c3373029e32190e7f35b28e4db49e55be1e0a24e7ce13c36f27b7ba9c5a09dbed05196d9864cb1939dc0dd98c798228aac46; odin_tt=63ff22c19bc332ee6744163838f9c3373029e32190e7f35b28e4db49e55be1e0a24e7ce13c36f27b7ba9c5a09dbed05196d9864cb1939dc0dd98c798228aac46',
    'sdk-version': '1',
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'X-SS-STUB': 'FA6191F54E649F9CC585897F510BE6B4',
    'X-SS-DP': '1128',
    'x-tt-trace-id': '00-5462d14e09fece22012e4f3767500468-5462d14e09fece22-01',
    'User-Agent': 'com.ss.android.ugc.aweme/110101 (Linux; U; Android 10; zh_CN_#Hans; ELE-AL00; Build/HUAWEIELE-AL00; Cronet/TTNetVersion:b4d74d15 2020-04-23 QuicVersion:0144d358 2020-03-24)',
    'Accept-Encoding': 'gzip, deflate, br',
    'X-Khronos': '1590553661',
    'X-Gorgon': '0404c09f0000c2ee085d0b335a98039a133ca4a532aaaaac7a15',
}

# res = requests.post(url=url, data=body, headers=headers, verify=False)
# print(res.headers['Content-Type'])
# print(res.headers.get('content-encoding'))
#
# res.encoding='utf-8'
# print(res.text)
# print(res.content)

# print(brotli.decompress(res.content))

# with open('a.bin', 'wb') as f:
#     f.write(res.content)

os.system('chcp 65001')
r = os.popen("protoc --decode_raw < a.bin")
basestr = r.read()
# print(basestr)


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        pass

    try:
        import unicodedata
        unicodedata.numeric(s)
        return True
    except (TypeError, ValueError):
        pass

    return False


def replace_str(s):
    s = s.group()
    if '\\' in s:
        clist = re.split(r'[" \\]', s)
        clistg = []
        for i in clist:
            if i != '':
                if len(i) > 3:
                    clistg.append(i[0:3])
                    clistg.append(i[3:])
                else:
                    clistg.append(i)
        ad = []
        t = ''
        for i in range(len(clistg)):
            if is_number(clistg[i]):
                ad.append(clistg[i])
            else:
                pr = bytes([int(i, 8) for i in ad]).decode('utf-8')
                t = t + pr + clistg[i]
                ad.clear()
        t = t + bytes([int(i, 8) for i in ad]).decode('utf-8')
        return t
    else:
        return s


restr = re.sub(r'\"\S.*\"', replace_str, basestr, 0)

print(restr)