package com.lida.dy.controller;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.model.entity.PlatformPropertyAnalyseEntity;
import com.lida.dy.model.entity.PlatformPropertyEntity;
import com.lida.dy.model.entity.TalentTypeEntity;
import com.lida.dy.serviceImpl.PlatformService;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.serviceImpl.TypeService;
import com.lida.dy.tool.Result;
import com.lida.dy.model.vo.MutilSearchVo;
import com.lida.dy.model.vo.TypeDataVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 10:29
 * @Version: 1.0
 */
@Controller
public class PlatformController {
    @Autowired
    TypeService typeService;
    @Autowired
    PlatformService platformService;
    @Autowired
    TalentUserService talentUserService;

    /*多条件搜索关键字*/
    @GetMapping("/multiSearch/getall")
    @ResponseBody
    public Result getall() {
        TypeDataVo typeDataVo = typeService.getType();
        if (typeDataVo != null) {
            return Result.success(typeDataVo);
        } else {
            return Result.fail();
        }
    }

    @GetMapping("/multiSearch/getTypeId/{name}")
    @ResponseBody
    @ApiOperation("根据达人类型名字获取类型数据")
    public Result getTypeId(@PathVariable String name) {
        List<TalentTypeEntity> talentTypeEntity = typeService.getTalentTypeEntityByName(name);
        if (talentTypeEntity != null) {
            return Result.success(talentTypeEntity);
        } else {
            return Result.fail();
        }
    }

    @GetMapping("/platform/getAllPlatformData/{platformId}")
    @ResponseBody
    @ApiOperation("获取平台指标数据")
    public Result getAllPlatformData(@PathVariable int platformId) {
        List<PlatformPropertyAnalyseEntity> allPlatformData = platformService.getAllPlatformData(platformId, DefaultConfig.defaultPlatformDataSize);
        return Result.success(allPlatformData);
    }

    @GetMapping("/platform/getAllPlatformTypeUserData/{platformId}/{typeName}")
    @ResponseBody
    public Result getAllPlatformTypeUserData(@PathVariable int platformId, @PathVariable String typeName) {
        List<TalentTypeEntity> talentTypeEntityByName = typeService.getTalentTypeEntityByName(typeName);
        ArrayList<Integer> ids = new ArrayList<>();
        for (TalentTypeEntity talentTypeEntity : talentTypeEntityByName) {
            ids.add(talentTypeEntity.getId());
        }
        List<PlatformPropertyEntity> allPlatformTypeUserData = platformService.getAllPlatformTypeUserData(platformId, ids, DefaultConfig.defaultPlatformDataTypeUserSize);
        return Result.success(allPlatformTypeUserData);
    }

    @PostMapping("/multiSearch")
    @ApiOperation("多条件搜索")
    public String multiSearch(MutilSearchVo mutilSearchVo) {
        talentUserService.multiSearch(mutilSearchVo);
        return null;
    }
}
