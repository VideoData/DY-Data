package com.lida.dy.serviceImpl;

import com.lida.dy.dao.FanChangeRepostitory;
import com.lida.dy.dao.VideoRepostitory;
import com.lida.dy.model.entity.FanChangeEntity;
import com.lida.dy.model.entity.VideoEntity;
import com.lida.dy.model.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/6 0006 21:35
 * @Version: 1.0
 */
@Service
public class ProfileService {
    @Autowired
    VideoRepostitory videoRepostitory;
    @Autowired
    FanChangeRepostitory fanChangeRepostitory;

    /**
     * 获得最近几个的视频
     *
     * @param id
     * @param size
     * @return
     */
    public VideoVo getLastVideoInfoByNum(int id, int size) {
        List<VideoEntity> videoEntities = videoRepostitory.getLastVideoInfoByNum(id, size);
        if (videoEntities != null) {
            VideoVo videoVo = new VideoVo();
            int allPlayNum = 0;
            for (VideoEntity videoEntity : videoEntities) {
                allPlayNum += videoEntity.getPlayNum();
            }
            if (videoEntities.size() == 0) {
                videoVo.setMid(0);
            } else {
                videoVo.setMid(allPlayNum / videoEntities.size());
            }
            videoEntities.sort(new Comparator<VideoEntity>() {
                @Override
                public int compare(VideoEntity o1, VideoEntity o2) {
                    return (int) (o1.getCreateTime() - o2.getCreateTime());
                }
            });
            videoVo.setVideoEntities(videoEntities);
            return videoVo;
        } else {
            return null;
        }
    }

    public List<FanChangeEntity> getLastFanChangeByNum(int id, int size) {
        List<FanChangeEntity> lastFanChangeByNum = fanChangeRepostitory.getLastFanChangeByNum(id, size);
        lastFanChangeByNum.sort(new Comparator<FanChangeEntity>() {
            @Override
            public int compare(FanChangeEntity o1, FanChangeEntity o2) {
                return (int) (o1.getCheckTime() - o2.getCheckTime());
            }
        });
        return lastFanChangeByNum;
    }
}
