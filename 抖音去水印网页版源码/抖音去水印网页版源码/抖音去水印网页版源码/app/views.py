from django.shortcuts import render


def home(request):
    return render(request, 'home.html')


def download(request):
    video_url_web = request.GET.get('video_url_web')
    video_name = request.GET.get('video_name')
    if not video_url_web:
        return render(request, 'home.html', locals())
    return render(request, 'download.html', locals())
