package com.jokey.bingo.mvc;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author :JokeyFeng
 * Date: 21:52 2018/6/9.
 * Contact :976024396@qq.com
 * Description: mapper层接口
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
