import fridar
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
}

res = fridar.get_headers(url, headers)
print(type(res))
