package com.chenchen.study.demo.controller;

import com.chenchen.study.demo.domain.UserInfo;
import com.chenchen.study.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2818:41
 */
@RequestMapping(value = "/user")
@RestController
@Api(tags = "用户controller")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/info")
    @ApiOperation(value = "获取用户信息",notes = "姓名不能为空")
    //一般用于表达一个错误的响应信息
    @ApiResponses({
            @ApiResponse(code=404,message = "请求路径不正确或者页面跳转不对"),
            @ApiResponse(code=400,message = "请求参数没填好")})

    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="姓名",required=true,paramType="form"),
            @ApiImplicitParam(name="phone",value="手机号",required=true,paramType="body"),
            @ApiImplicitParam(name="address",value="地址",required=true,paramType="header",dataType="Integer")})
    List<UserInfo> getInfos(
            @ApiParam(name = "name", value = "username", required = true)String name ,
            @ApiParam(name = "phone", value = "userPhone", required = true)String phone,
            @ApiParam(name = "address", value = "address")String address){
        return new ArrayList<UserInfo>();
    }

}
