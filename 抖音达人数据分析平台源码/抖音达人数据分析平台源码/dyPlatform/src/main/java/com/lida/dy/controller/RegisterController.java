package com.lida.dy.controller;

import com.lida.dy.model.entity.UserEntity;
import com.lida.dy.service.UserSerivce;
import com.lida.dy.serviceImpl.RedisService;
import com.lida.dy.tool.Result;
import com.lida.dy.model.vo.RegisterUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/3 0003 14:34
 * @Version: 1.0
 */
@Controller
@RequestMapping("/register")
@Api(tags = "注册相关")
public class RegisterController {
    @Autowired
    UserSerivce userSerivce;
    @Autowired
    RedisService redisService;

    /*发送验证码*/
    @PostMapping("/sendEmialCheckCode")
    @ResponseBody
    @ApiOperation("向指定邮箱发送验证码")
    public Result sendEmialCheckCode(@RequestParam("email") String email) {
        System.out.println(email);
        if (email != null) {
            UserEntity userEntity = userSerivce.existEmail(email);
            if (userEntity != null) {
                return Result.fail("邮箱已经被注册！！");
            }
            if (redisService.sendEmailKeyByEmail(email)) {
                return Result.success();
            }
            return Result.fail("请勿频繁发送验证码！！");
        }
        return Result.fail("字段为空");
    }

    /*校验验证码*/
    @PostMapping("/register")
    @ResponseBody
    @ApiOperation("校验验证码并注册")
    public Result register(RegisterUserVO userVO) {
        System.out.println(userVO);
        if (userVO != null) {
            if (redisService.checkEmailKeyByEmail(userVO.getEmail(), userVO.getCode(), true)) {
                System.out.println("注册");
                if (userSerivce.insertUser(userVO)) {
                    return Result.success();
                }
            }

        }
        return Result.fail();
    }
}
