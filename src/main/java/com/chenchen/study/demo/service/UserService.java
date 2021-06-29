package com.chenchen.study.demo.service;

import com.chenchen.study.demo.dao.UserEntity;
import com.chenchen.study.demo.dao.mapper.UserMapper;
import com.chenchen.study.demo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2819:03
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    List<UserInfo> getInfos(){
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserEntity userEntity =userMapper.selectById("1112");
        return userInfos;
    }
}
