package com.chenchen.sysroley.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenchen.sysroley.entity.TSysRole;
import com.chenchen.sysroley.mapper.TSysRoleMapper;
import com.chenchen.sysroley.service.TSysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author sjzhao
 * @since 2021-06-29
 */
@Service
public class TSysRoleServiceImpl extends ServiceImpl<TSysRoleMapper, TSysRole> implements TSysRoleService {

    @Resource
    private TSysRoleMapper tSysRoleMapper;
    public String getInfo(){
        LambdaQueryWrapper<TSysRole> lambdaQueryWrapper =new LambdaQueryWrapper();
        List<TSysRole> CommunityCodeEntityList = tSysRoleMapper.selectList(lambdaQueryWrapper);
        return null;
    }

}
