import frida, sys
import json

def on_message(message, data):
    if message['type'] == 'send':
        print("[============] {0}".format(message['payload']), message)
    else:
        print(message)


process = frida.get_usb_device().attach('com.ss.android.ugc.aweme')
jscode = open('./js/code.js', 'r', encoding='utf8').read()
script = process.create_script(jscode)
script.on('message', on_message)
print('开始 Running CTF')
script.load()


url = 'https://webcast3-normal-c-lf.amemv.com/webcast/room/enter/?webcast_sdk_version=1270&webcast_language=zh&webcast_locale=zh_CN_%23Hans&manifest_version_code=860&_rticket=1588240199831&ac=wifi&app_type=normal&device_id=71613991215&iid=395457251250605&mcc_mnc=46001&os_version=10&channel=wandoujia_aweme2&version_code=860&device_type=ELE-AL00&language=zh&resolution=1080*2265&openudid=eb5b54610b8eddc9&update_version_code=8602&app_name=aweme&version_name=8.6.0&os_api=29&device_brand=HUAWEI&ssmix=a&device_platform=android&dpi=480&aid=1128&ts=1588240199'
headers = {
    'Accept-Encoding': 'gzip',
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'User-Agent': 'com.ss.android.ugc.aweme/860 (Linux; U; Android 10; zh_CN_#Hans; ELE-AL00; Build/HUAWEIELE-AL00; Cronet/58.0.2991.0)',
    'X-Khronos': '1588240199',
    'X-Gorgon': '0300a0df0604cdb9ba9f6d6d94b2cb8dbfd6e310ad5ad8bf190f',
    'Cookie': 'install_id=395457251250605; ttreq=1$a39bbdea11f79040b5339bc87ff497456460c842; install_id=395457251250605; ttreq=1$a39bbdea11f79040b5339bc87ff497456460c842; passport_csrf_token=2fbb2a8607eed1131b1619dec916eac1; passport_csrf_token=2fbb2a8607eed1131b1619dec916eac1; d_ticket=6eae8df6d6f98adf8fe6befdb0539401fa74f; odin_tt=74bae2d6fe87ae5d112e757d15b9e5b3dd41feeb6d70530c004946a53c3919f8b5cdcb7c89f9564493282f17f80c2c9266452c4fc526080d51236038d03b1091; sid_guard=32355e16bf63634f7c0f5796f0e5fc2c%7C1588236100%7C5184000%7CMon%2C+29-Jun-2020+08%3A41%3A40+GMT; uid_tt=c93b445d00c461eef0b61337dbe91fc8; uid_tt_ss=c93b445d00c461eef0b61337dbe91fc8; sid_tt=32355e16bf63634f7c0f5796f0e5fc2c; sessionid=32355e16bf63634f7c0f5796f0e5fc2c; sessionid_ss=32355e16bf63634f7c0f5796f0e5fc2c; d_ticket=6eae8df6d6f98adf8fe6befdb0539401fa74f; odin_tt=74bae2d6fe87ae5d112e757d15b9e5b3dd41feeb6d70530c004946a53c3919f8b5cdcb7c89f9564493282f17f80c2c9266452c4fc526080d51236038d03b1091; sid_guard=32355e16bf63634f7c0f5796f0e5fc2c%7C1588236100%7C5184000%7CMon%2C+29-Jun-2020+08%3A41%3A40+GMT; uid_tt=c93b445d00c461eef0b61337dbe91fc8; sid_tt=32355e16bf63634f7c0f5796f0e5fc2c; sessionid=32355e16bf63634f7c0f5796f0e5fc2c'

}


print(script.exports.xgorgon(url, headers))

sys.stdin.read()