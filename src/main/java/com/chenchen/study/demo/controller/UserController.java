package com.chenchen.study.demo.controller;

import com.chenchen.study.demo.domain.UserInfo;
import com.chenchen.study.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2818:41
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/info")
    List<UserInfo> getInfos(){
        return null;
    }

}
