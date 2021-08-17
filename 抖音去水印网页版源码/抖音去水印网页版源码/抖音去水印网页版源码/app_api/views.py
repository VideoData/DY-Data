from rest_framework.views import APIView
from rest_framework.response import Response
from utils.base_response import BaseResponse
from utils.vedio import get_video_url
from utils.my_log import logger


class TestMail(APIView):

    def post(self, request):
        res = BaseResponse()
        # 用序列化器做校验
        res_url, res_name, aweme_type = get_video_url(request.data.get('video_url_share'))
        # 视频类型
        if aweme_type == 4:
            video_url, video_url_web, video_name = res_url[0], res_url[1], res_name
            if not video_url_web:
                res.code = 1020
                res.error = "链接无效"
            else:
                res.data = {
                    'video_url_web': video_url_web,
                    'video_name': video_name,
                    'aweme_type': aweme_type,
                }
                logger.info(f'{video_url} {video_name}')
            return Response(res.dict)
        # 图集类型
        elif aweme_type == 2:
            image_url_list, image_name_list = res_url, res_name
            if not image_url_list:
                res.code = 1020
                res.error = "链接无效"
            else:
                res.data = {
                    'image_url_list': image_url_list,
                    'image_name_list': image_name_list,
                    'aweme_type': aweme_type,
                }
            return Response(res.dict)
        else:
            res.code = 1020
            res.error = "链接无效"
            return Response(res.dict)
