package com.lida.dy.controller;

import com.alibaba.fastjson.JSON;
import com.lida.dy.conf.SessionKey;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.serviceImpl.OverlapService;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.tool.Result;
import com.lida.dy.utils.ToolUtil;
import com.lida.dy.model.vo.CandidateSearchMutiVO;
import com.lida.dy.model.vo.OverlapVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:45
 * @Version: 1.0
 */
@Controller()
@RequestMapping("/userinfo")
@Log
@Api(tags = "达人相关接口")
public class UserController {
    @Autowired
    TalentUserService talentUserService;
    @Autowired
    OverlapService overlapService;
    @Autowired
    ToolUtil toolUtil;


    /**
     * 查询所有
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/getall")
    @ApiOperation("分页获取所有达人")
    public List<TalentUserInfoEntity> getAll() {
        return talentUserService.getAll();
    }



    @PostMapping("/getOverlap")
    @ResponseBody
    @ApiOperation("上传达人id，计算达人之间的重合度")
    @ApiImplicitParam(value = "达人id",required = true,defaultValue = "1,2")
    public Result getOverlap(@RequestParam String data) {
        String[] ids = data.split(",");
        OverlapVo overlap = overlapService.getOverlap(Integer.parseInt(ids[0]), Integer.parseInt(ids[1]));

        System.out.println(overlap);
        return Result.success(overlap);
    }

//    /**
//     * 添加重合度
//     */
//    @GetMapping("/addOverlap/{id}")
//    @ResponseBody
//    @ApiOperation("添加达人到重合度")
//    public Result addOverlap(HttpSession session, @PathVariable int id) {
//        Set<Integer> chongid = (Set<Integer>) session.getAttribute(SessionKey.chonghe);
//        if (chongid != null) {
//            if (chongid.size() < 2) {
//                if (chongid.add(id)) {
//                    session.removeAttribute(SessionKey.chonghe);
//                    session.setAttribute(SessionKey.chonghe, chongid);
//                    return Result.success(null);
//                } else {
//                    return Result.fail("已选择达人");
//                }
//            } else {
//                return Result.fail("最多选择2位达人");
//            }
//        } else {
//            chongid = new HashSet<>();
//            chongid.add(id);
//            System.out.println("adddfgfg===" + chongid.size());
//            session.setAttribute(SessionKey.chonghe, chongid);
//            return Result.success(null);
//        }
//    }
//
//    /**
//     * 取消添加重合度
//     */
//    @GetMapping("/removeOverlap/{id}")
//    @ResponseBody
//    public Result removeOverlap(HttpSession session, @PathVariable int id) {
//        Set<Integer> chongid = (Set<Integer>) session.getAttribute(SessionKey.chonghe);
//        if (chongid != null) {
//            if (chongid.remove(id)) {
//                session.removeAttribute(SessionKey.chonghe);
//                System.out.println("removedddd===" + chongid.size());
//                session.setAttribute(SessionKey.chonghe, chongid);
//                return Result.success(null);
//            }
//        }
//        return Result.fail("未查找到");
//    }

}
