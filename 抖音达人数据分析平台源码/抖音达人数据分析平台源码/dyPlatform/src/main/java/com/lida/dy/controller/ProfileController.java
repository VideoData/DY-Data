package com.lida.dy.controller;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.model.entity.FanChangeEntity;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.model.vo.VideoVo;
import com.lida.dy.serviceImpl.CoreService;
import com.lida.dy.serviceImpl.ProfileService;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.tool.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/6 0006 20:48
 * @Version: 1.0
 */
@Controller
@Api("达人信息页面相关")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    TalentUserService talentUserService;
    @Autowired
    CoreService coreService;

    @GetMapping("/profile/getVideoNum/{id}")
    @ResponseBody
    @ApiOperation("获取达人的视频数量")
    public Result getVideoNum(@PathVariable int id) {
        VideoVo videoVo = profileService.getLastVideoInfoByNum(id, DefaultConfig.defaultProfileVideoNum);
        if (videoVo != null) {
            double standardDeviation = coreService.calcStandardDeviation(videoVo.getVideoEntities());
            videoVo.setStandardDeviation(standardDeviation);
            return Result.success(videoVo);
        } else {
            return Result.fail();
        }
    }

    @GetMapping("/profile/getFansChange/{id}")
    @ResponseBody
    @ApiOperation("获得粉丝变化数据")
    public Result getFansChange(@PathVariable int id) {
        List<FanChangeEntity> lastFanChangeByNum = profileService.getLastFanChangeByNum(id, DefaultConfig.defaultFanChangeNum);
        lastFanChangeByNum = filterMiniTimeInterval(lastFanChangeByNum);
        if (lastFanChangeByNum != null) {
            return Result.success(lastFanChangeByNum);
        } else {
            return Result.fail();
        }
    }

    //过滤采集间隔时间过少的记录
    private List<FanChangeEntity> filterMiniTimeInterval(List<FanChangeEntity> lastFanChangeByNum) {
        if (lastFanChangeByNum == null || lastFanChangeByNum.size() < 2) {
            return lastFanChangeByNum;
        }
        ArrayList<FanChangeEntity> fanChangeEntities = new ArrayList<>();
        fanChangeEntities.add(lastFanChangeByNum.get(0));
        for (int i = 1; i < lastFanChangeByNum.size(); i++) {
            if(lastFanChangeByNum.get(i-1).getCheckTime()+1000*3600*24<lastFanChangeByNum.get(i).getCheckTime()){
                fanChangeEntities.add(lastFanChangeByNum.get(i));
            }
        }
        return fanChangeEntities;
    }

    @GetMapping("/profile/getActiveValue/{id}")
    @ResponseBody
    @ApiOperation("获得真假粉粉丝比例")
    public Result getActiveValue(@PathVariable int id) {
        TalentUserInfoEntity talentUserInfoEntity = talentUserService.findById(id);
        if (talentUserInfoEntity != null) {
            HashMap<String, Integer> result = new HashMap<>();
            result.put("fansCount", talentUserInfoEntity.getFansCount());
            result.put("realFansCount", talentUserInfoEntity.getRealFansCount());
            return Result.success(result);
        } else {
            return Result.fail();
        }
    }
}
