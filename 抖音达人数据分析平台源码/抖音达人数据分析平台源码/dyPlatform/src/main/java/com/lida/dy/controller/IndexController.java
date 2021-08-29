package com.lida.dy.controller;

import com.alibaba.fastjson.JSON;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.model.vo.MutilSearchVo;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.utils.ToolUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/15 0015 16:33
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @Autowired
    TalentUserService talentUserService;
    @Autowired
    ToolUtil toolUtil;
    @ApiOperation(value = "多条件搜索")
    @ApiImplicitParam(name = "data", defaultValue = "{\"keyWord:\":null,\"sortWord\":null,\"isDESC\":true,\"page\":1,\"size\":10,\"type\":[],\"value\":[],\"fans\":[\"0.2w\"],\"platform\":1}", required = true)
    @RequestMapping(value = "/index/mutilSearch", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String mutilSearch(Model model, @RequestParam String data) {
        System.out.println(data);
        MutilSearchVo mutilSearchVo = JSON.parseObject(data, MutilSearchVo.class);
        System.out.println(mutilSearchVo.toString());
        Page<TalentUserInfoEntity> page = talentUserService.multiSearch(mutilSearchVo);
        toolUtil.dealDieFor(page);
        System.out.println(page.getSize());
        toolUtil.wrapperTanlentUserInfo(page);
        model.addAttribute("userlist", page);
        return "component/indexComponent::userlist";
    }
}
