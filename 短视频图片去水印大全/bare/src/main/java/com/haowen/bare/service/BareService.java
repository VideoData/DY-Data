package com.haowen.bare.service;


import com.haowen.bare.parse.BareParser;
import com.haowen.bare.parse.ParserFactory;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.utils.BizException;
import com.haowen.bare.utils.ErrorCode;
import com.haowen.bare.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BareService {

    @Resource
    private ParserFactory parserFactory;

    /**
     * 获取无水印资源地址列表
     *
     * @param link 复制的链接
     */
    public BareResult parse(String link) throws Exception {
        BareParser parser = parserFactory.getParser(link);
        if (parser == null) {
            throw new BizException(ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.value(), ErrorCode.NOT_SUPPORTED_PLATFORM_ERROR.msg());
        }
        return parser.parse(StringUtil.filterUrl(link));
    }
}