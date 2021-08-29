package com.lida.dy.serviceImpl;

import com.lida.dy.dao.PlatformPropertyAnalyseRepostitory;
import com.lida.dy.dao.PlatformPropertyRepostitory;
import com.lida.dy.model.entity.PlatformPropertyAnalyseEntity;
import com.lida.dy.model.entity.PlatformPropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/7 0007 23:13
 * @Version: 1.0
 */
@Service
public class PlatformService {
    @Autowired
    PlatformPropertyAnalyseRepostitory platformPropertyAnalyseRepostitory;
    @Autowired
    PlatformPropertyRepostitory platformPropertyRepostitory;

    public List<PlatformPropertyAnalyseEntity> getAllPlatformData(int platformId, int size) {
        List<PlatformPropertyAnalyseEntity> platformDatas = platformPropertyAnalyseRepostitory.findByPlatformId(platformId, size);
        platformDatas.sort(new Comparator<PlatformPropertyAnalyseEntity>() {
            @Override
            public int compare(PlatformPropertyAnalyseEntity o1, PlatformPropertyAnalyseEntity o2) {
                return o1.getAllFansNum() - o2.getAllFansNum();
            }
        });
        return platformDatas;
    }

    public List<PlatformPropertyEntity> getAllPlatformTypeUserData(int platformId, List<Integer> typeIds, int size) {
        List<PlatformPropertyEntity> allPlatformTypeUserData = new ArrayList<>();
        for (Integer typeid : typeIds) {
            allPlatformTypeUserData.addAll(platformPropertyRepostitory.getAllPlatformTypeUserData(platformId, typeid, size));
        }
        allPlatformTypeUserData.sort(new Comparator<PlatformPropertyEntity>() {
            @Override
            public int compare(PlatformPropertyEntity o1, PlatformPropertyEntity o2) {
                return (int) (o1.getCheckTime() - o2.getCheckTime());
            }
        });
        return allPlatformTypeUserData;
    }
}
