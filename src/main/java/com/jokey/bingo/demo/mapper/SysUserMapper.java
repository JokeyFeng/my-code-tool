package com.jokey.bingo.demo.mapper;

import com.jokey.bingo.demo.entity.SysUser;
import com.jokey.bingo.mvc.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @Author jokey
* @Date 2019年4月10日
*/
@Mapper
@Component
public interface SysUserMapper extends MyMapper<SysUser> {
}