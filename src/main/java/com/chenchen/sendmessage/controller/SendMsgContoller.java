package com.chenchen.sendmessage.controller;

import com.chenchen.sendmessage.domain.SendMsgVo;
import com.chenchen.sendmessage.service.SendMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/7/139:44
 */
@RestController
@RequestMapping(value = "/test/sendmsg")
@Api(tags = "发送信息API")
public class SendMsgContoller {

    @Autowired
    private SendMsgService sendMsgService;

    @PostMapping("/securitycode")
    @ApiModelProperty(value = "发送验证码")
    public void sendcode(@RequestBody SendMsgVo sendMsgVo){
        sendMsgService.sendcode(sendMsgVo);
    }

    @ApiOperation("获取验证码")
    @PostMapping(value = "/jeectboot/{key}")
    public String randomImage(HttpServletResponse response, @PathVariable String key){

        return null;
    }

}
