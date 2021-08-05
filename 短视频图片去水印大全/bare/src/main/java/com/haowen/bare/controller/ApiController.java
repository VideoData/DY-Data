package com.haowen.bare.controller;

import com.haowen.bare.result.BareResult;
import com.haowen.bare.service.BareService;
import com.haowen.bare.utils.ResponseUtil;
import com.haowen.bare.utils.ReturnObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * 外部接口
 */
@Api(tags = "短视频/图片去水印")
@RestController
public class ApiController {

    @Resource
    private BareService bareService;

    /**
     * 获取无水印资源地址列表
     *
     * @param link 复制的链接
     */
    @ApiOperation(value = "聚合接口", response = BareResult.class)
    @PostMapping("/bare")
    private ReturnObject<BareResult> bare(
            @NotBlank(message = "请输入复制链接")
            @ApiParam("复制的链接")
            @RequestParam("link") String link) throws Exception {
        return ResponseUtil.ok(bareService.parse(link));
    }
}