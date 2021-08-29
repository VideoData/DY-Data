package com.lida.dy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.tool.Result;
import com.lida.dy.utils.AESUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前后端数据交互
 * @Auther: lida
 * @Description:
 * @Date 2020/1/17 0017 12:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/data")
public class InteractionController {
    @ApiOperation(value = "获取前后端加密通信秘钥")
    @GetMapping("/getAesdata")
    public Result getAesdata() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", DefaultConfig.KEY);
        jsonObject.put("iv", DefaultConfig.IV);
        return Result.success(jsonObject);
    }

}
