from django.db import models


# Create your models here.

class Video(models.Model):
    video_name = models.CharField(max_length=32)
    video_id = models.CharField(max_length=32)
