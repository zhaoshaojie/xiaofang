package com.chenchen.study.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenchen.study.demo.dao.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/28 18:40
 */
@Mapper
public interface UserMapper  extends BaseMapper<UserEntity> {
}
