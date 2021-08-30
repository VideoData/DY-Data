import requests
import zlib
import gzip
# url ='https://aweme-eagle.snssdk.com/aweme/v2/feed/?type=0&max_cursor=0&min_cursor=-1&count=1&volume=0.2&pull_type=2&need_relieve_aweme=0&filter_warn=0&req_from&is_cold_start=0&longitude=0&latitude=0&address_book_access=2&gps_access=2&cached_item_num=3&last_ad_show_interval=-1&mac_address=F8%3A9A%3A78%3A11%3A14%3AEA&manifest_version_code=860&_rticket=1588137948827&ac=wifi&app_type=normal&device_id=71613991215&iid=395457251250605&mcc_mnc=46001&os_version=10&channel=wandoujia_aweme2&version_code=860&device_type=ELE-AL00&language=zh&resolution=1080*2265&openudid=eb5b54610b8eddc9&update_version_code=8602&app_name=aweme&version_name=8.6.0&os_api=29&device_brand=HUAWEI&ssmix=a&device_platform=android&dpi=480&aid=1128&ts=1588137948'

# url = 'https://api.amemv.com/aweme/v1/aweme/post/?max_cursor=0&sec_user_id=MS4wLjABAAAAEu7gotTaUzUxHuM0q88r_p0own6lxkcc7SSvqWFmtbg&count=20&retry_type=no_retry&iid=395457251250605&device_id=71613991215&ac=wifi&channel=wandoujia_aweme2&aid=1128&app_name=aweme&version_code=860&version_name=8.6.0&device_platform=android&ssmix=a&device_type=ELE-AL00&device_brand=HUAWEI&language=zh&os_api=29&os_version=10&openudid=eb5b54610b8eddc9&manifest_version_code=860&resolution=1080*2265&dpi=480&update_version_code=8602&_rticket=1588234975270&mcc_mnc=46001&app_type=normal&ts=1588234975'

url = 'https://aweme-eagle.snssdk.com/aweme/v1/user/?sec_user_id=MS4wLjABAAAAcQ11PPQqZ6ALKBay5BQVcm0frpi75_8VWH6-Qy-Rcwg&address_book_access=2&retry_type=no_retry&iid=395457251250605&device_id=71613991215&ac=wifi&channel=wandoujia_aweme2&aid=1128&app_name=aweme&version_code=860&version_name=8.6.0&device_platform=android&ssmix=a&device_type=ELE-AL00&device_brand=HUAWEI&language=zh&os_api=29&os_version=10&openudid=eb5b54610b8eddc9&manifest_version_code=860&resolution=1080*2265&dpi=480&update_version_code=8602&_rticket=1588235749288&mcc_mnc=46001&app_type=normal&ts=1588235749'

headers = {
    'Host': 'aweme-eagle.snssdk.com',
    'Connection': 'keep-alive',
    'Cookie': 'install_id=395457251250605; ttreq=1$a39bbdea11f79040b5339bc87ff497456460c842; odin_tt=f7b2fa833e9adf67bf332134140fb18677c419f7bdb992475cfb331e02872d9f5312cd65814fc51967baaa138933e03223a66d4678d2d39a56467a6328980599',
    'Accept-Encoding': 'gzip',
    'X-SS-REQ-TICKET': '1588137948825',
    'sdk-version': '1',
    'x-tt-trace-id': '00-639e0a5f7ec3728476c73359ec5894b1-639e0a5f7ec37284-01',
    'User-Agent': 'com.ss.android.ugc.aweme/860 (Linux; U; Android 10; zh_CN_#Hans; ELE-AL00; Build/HUAWEIELE-AL00; Cronet/58.0.2991.0)',
    'X-Khronos': '1588235964',
    'X-Gorgon': '0300e07f040568afd58959abdee2bc79888d31c0932002ba6d49',
}

# url1 = 'http://www.baidu.com'
res = requests.get(url, headers=headers, verify=False)

# data = gzipper.read()
try:
    print(res.json())
except:
    print(res.text)
