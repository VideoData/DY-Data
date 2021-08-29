package com.lida.dy.cal.track;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.dao.TalentUserRepository;
import com.lida.dy.cal.dao.VideoChangeRepository;
import com.lida.dy.cal.entity.TalentUserInfoEntity;
import com.lida.dy.cal.entity.VideoChangeEntity;
import com.lida.dy.cal.interfaces.DYInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TrackVideo {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    DYInterface dyInterface;
    @Autowired
    VideoChangeRepository videoChangeRepository;

    public void track(boolean isFirst) {
        dyInterface.init();
        if (isFirst) {
            initVideoPool();
        } else {
            spiderOnce();
        }
    }

    int totalFailTime = 0;

    private void spiderOnce() {
        List<String> vids = videoChangeRepository.findvid();
        for (String vid : vids) {
            VideoChangeEntity videoChangeEntitySource = videoChangeRepository.findFirstByVid(vid);
            try {
                Thread.sleep(1000);
                String video_list = dyInterface.get_video_list(0, videoChangeEntitySource.getUid(), "", "");
                int failTime = 0;
                while (video_list.equals("false") && failTime < 5) {
                    Thread.sleep(1000);
                    video_list = dyInterface.get_video_list(0,  videoChangeEntitySource.getUid(), "", "");
                    failTime++;
                }
                if (video_list.equals("false")) {
                    totalFailTime++;
                    if (totalFailTime > 5) {
                        break;
                    } else {
                        continue;
                    }
                }
                JSONObject jsonObject = JSONObject.parseObject(video_list);
                JSONArray videos = jsonObject.getJSONArray("aweme_list");
                for (int i = 0; i < videos.size(); i++) {
                    JSONObject video = videos.getJSONObject(i);
                    if (video.getString("aweme_id").equals(videoChangeEntitySource.getVid())) {
                        VideoChangeEntity videoChangeEntity = new VideoChangeEntity();
                        JSONObject statistics = video.getJSONObject("statistics");
                        videoChangeEntity.setCommentNum(statistics.getIntValue("comment_count"));
                        videoChangeEntity.setCreateTime(video.getString("create_time"));
                        videoChangeEntity.setRecordTime(System.currentTimeMillis() + "");
                        videoChangeEntity.setVid(statistics.getString("aweme_id"));
                        videoChangeEntity.setUid(videoChangeEntitySource.getUid());
                        videoChangeEntity.setMyuid(videoChangeEntitySource.getMyuid());
                        videoChangeEntity.setVideoTitle(video.getString("desc"));
                        videoChangeEntity.setShareNum(statistics.getIntValue("share_count"));
                        videoChangeEntity.setFavoritedNum(statistics.getIntValue("digg_count"));
                        videoChangeEntity.setDownloadCount(statistics.getIntValue("download_count"));
                        videoChangeRepository.save(videoChangeEntity);
                        System.out.println(videoChangeEntity.toString());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initVideoPool() {
        int videoNum = 0;
        int page = 0;
        while (videoNum < 50) {
            PageRequest of = PageRequest.of(page, 20, Sort.by(Sort.Direction.DESC, "avg_play_num"));
            List<TalentUserInfoEntity> talentUserInfoEntities = talentUserRepository.findAllByuidNotnull(of);
//            List<String> uids = videoChangeRepository.finduid();
            for (TalentUserInfoEntity talentUserInfoEntity : talentUserInfoEntities) {
                String uid = talentUserInfoEntity.getUid();
//                if(uids.contains(uid)){
//                    continue;
//                }
                if (!uid.isEmpty()) {
                    try {
                        Thread.sleep(1000);
                        String video_list = dyInterface.get_video_list(0, uid, "", "");
                        int failTime = 0;
                        while (video_list.equals("false") && failTime < 5) {
                            Thread.sleep(1000);
                            video_list = dyInterface.get_video_list(0, uid, "", "");
                            failTime++;
                        }
                        if (video_list.equals("false")) {
                            totalFailTime++;
                            if (totalFailTime > 5) {
                                break;
                            } else {
                                continue;
                            }
                        }
                        JSONObject jsonObject = JSONObject.parseObject(video_list);
                        JSONArray videos = jsonObject.getJSONArray("aweme_list");
                        for (int i = 0; i < videos.size(); i++) {
                            JSONObject video = videos.getJSONObject(i);
                            long create_time = video.getLongValue("create_time");
                            long now = System.currentTimeMillis() / 1000;
                            System.out.println("create_time:" + create_time + "now:" + now + " 差：" + (now - create_time));
                            if (now - create_time < 18000) {
                                videoNum++;
                                VideoChangeEntity videoChangeEntity = new VideoChangeEntity();
                                JSONObject statistics = video.getJSONObject("statistics");
                                videoChangeEntity.setCommentNum(statistics.getIntValue("comment_count"));
                                videoChangeEntity.setRecordTime(System.currentTimeMillis() + "");
                                videoChangeEntity.setCreateTime(create_time + "");
                                videoChangeEntity.setVid(statistics.getString("aweme_id"));
                                videoChangeEntity.setUid(uid);
                                videoChangeEntity.setMyuid(talentUserInfoEntity.getId());
                                videoChangeEntity.setVideoTitle(video.getString("desc"));
                                videoChangeEntity.setShareNum(statistics.getIntValue("share_count"));
                                videoChangeEntity.setFavoritedNum(statistics.getIntValue("digg_count"));
                                videoChangeEntity.setDownloadCount(statistics.getIntValue("download_count"));
                                videoChangeRepository.save(videoChangeEntity);
                                System.out.println("videoNum:" + videoNum);
                                System.out.println("videoChangeEntity:" + videoChangeEntity.toString());
                                break;
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            page++;
        }
    }
}
