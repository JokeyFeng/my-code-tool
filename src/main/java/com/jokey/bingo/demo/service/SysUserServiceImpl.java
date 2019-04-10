package com.jokey.bingo.demo.service;

import com.jokey.bingo.demo.entity.SysUser;
import com.jokey.bingo.demo.mapper.SysUserMapper;
import com.jokey.bingo.mvc.BaseServiceImpl;
import com.jokey.bingo.mvc.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Author jokey
* @Date 2019年4月10日
* @Version 1.0
*/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    protected MyMapper<SysUser> getMapper() {
        return sysUserMapper;
    }

    @Override
    public SysUser selectByKey(Object key) {
        return sysUserMapper.selectByPrimaryKey(key);
    }
}