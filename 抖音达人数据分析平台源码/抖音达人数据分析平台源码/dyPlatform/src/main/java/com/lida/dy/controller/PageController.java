package com.lida.dy.controller;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.conf.SessionKey;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.model.entity.UserEntity;
import com.lida.dy.serviceImpl.TalentUserService;
import com.lida.dy.serviceImpl.UserSerivceImpl;
import com.lida.dy.tool.Result;
import com.lida.dy.utils.MD5Util;
import com.lida.dy.utils.ToolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 页面跳转
 *
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 15:20
 * @Version: 1.0
 */
@Controller
@Api(tags = "页面跳转相关")
public class PageController {
    @Autowired
    TalentUserService talentUserService;
    @Autowired
    CalculateController calculateController;
    @Autowired
    UserSerivceImpl userSerivce;
    @Autowired
    ToolUtil toolUtil;

    @GetMapping("/")
    public String index() {
        return "page/login";
    }
    @ApiOperation("登录页面")
    @PostMapping("/login")
    public String login(Model model, HttpSession session, UserEntity userEntity) {
        String password = userEntity.getPasswd().trim();
        System.out.println(password);
        int mid = password.length() / 2;
        if (password.charAt(mid) == ',') {
            password = password.substring(0, mid);
        }
        if (password.charAt(password.length() - 1) == ',') {
            password = password.substring(0, password.length() - 1);
        }
        userEntity.setPasswd(password);
        System.out.println(userEntity.getPasswd());
        System.out.println(MD5Util.getMD5(userEntity.getPasswd()));
        UserEntity userEntity1 = userSerivce.checkByAccountPasswd(userEntity.getAccountNumber(), userEntity.getPasswd());
        if (userEntity1 != null) {
            if (userEntity1.getAccountNumber().equals(userEntity.getAccountNumber()) && userEntity1.getPasswd().equals(MD5Util.getMD5(userEntity.getPasswd()))) {
                session.setAttribute(SessionKey.loginUserField, userEntity1);
                String goal = "redirect:/index";
                return goal;
            }
        }
        model.addAttribute("login", false);
        return "page/login";
    }
    @ApiOperation("注销")
    @GetMapping("/logout")
    public String login(Model model, HttpSession session) {
        session.removeAttribute(SessionKey.loginUserField);
        return "page/login";
    }
    @ApiOperation("注册页面")
    @GetMapping("/register")
    public String login() {
        return "page/register";
    }

    /**
     * 重定向首页
     */
    @ApiOperation("首页")
    @RequestMapping("/index")
    public String toindex() {
        return "page/index";
    }

//    @RequestMapping("/index/{page}/{size}")
//    public String index(HttpSession session, Model model, @PathVariable int page, @PathVariable int size) {
//        CandidateSearchVo candidateSearchVo = (CandidateSearchVo) session.getAttribute(SessionKey.searchByCandidateDataField);
//        Page<TalentUserInfoEntity> page1 = null;
//        if (candidateSearchVo != null) {
//            page1 = talentUserService.searchByCandidate(candidateSearchVo);
//        } else {
//            CandidateSearchVo candidateSearchVo1 = new CandidateSearchVo();
//            candidateSearchVo1.setPage(page);
//            candidateSearchVo1.setSize(size);
//            page1 = talentUserService.searchByCandidate(candidateSearchVo1);
//        }
//
//        model.addAttribute("userlist", page1);
//        return "page/index";
//    }

    @ApiOperation("达人信息页面")
    @GetMapping("/talentInfo/{id}")
    public String talentInfo(Model model, HttpSession session, @PathVariable int id) {
        TalentUserInfoEntity talentUserInfoEntity = talentUserService.findById(id);
        toolUtil.wrapperTanlentUserInfo(talentUserInfoEntity);
        model.addAttribute("talentUser", talentUserInfoEntity);
        session.setAttribute(SessionKey.saveProfileField, id);
        return "page/profile";
    }
    @ApiOperation("达人信息页面")
    @GetMapping("/talentInfo")
    public String talentInfoNoId(Model model, HttpSession session) {
        Integer id = (Integer) session.getAttribute(SessionKey.saveProfileField);
        if (id != null) {
            TalentUserInfoEntity talentUserInfoEntity = talentUserService.findById(id);
            toolUtil.wrapperTanlentUserInfo(talentUserInfoEntity);
            model.addAttribute("talentUser", talentUserInfoEntity);
        } else {
            Page<TalentUserInfoEntity> talentUserInfoEntities = talentUserService.getAll(0, 1);
            TalentUserInfoEntity talentUserInfoEntity = talentUserInfoEntities.getContent().get(0);
            toolUtil.wrapperTanlentUserInfo(talentUserInfoEntity);
            model.addAttribute("talentUser", talentUserInfoEntity);
            session.setAttribute(SessionKey.saveProfileField, talentUserInfoEntity.getId());
        }
        return "page/profile";
    }
    @ApiOperation("结算页面")
    @GetMapping("/calculate")
    public String talentInfo(Model model, HttpSession session) {
        calculateController.getCandidate(session, model);
        calculateController.getLastCandidate(session, model);
        return "page/settlement";
    }


}
