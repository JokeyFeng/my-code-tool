package com.jokey.bingo.mvc;

import com.github.pagehelper.PageInfo;
import com.jokey.bingo.entity.Page;

import java.util.List;

/**
 * @author :JokeyFeng
 * Date: 21:51 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */

public interface BaseService<T> {

    /**
     * 获取所有
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 主键查询
     *
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    PageInfo<T> selectByPage(Page page);

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    int batchSave(List<T> list);

    /**
     * 主键删除
     *
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 批量删除
     *
     * @param list
     * @param property
     * @param clazz
     * @return
     */
    int batchDelete(List<String> list, String property, Class<T> clazz);

    /**
     * 更新全部字段
     *
     * @param entity
     * @return
     */
    int updateAll(T entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 根据条件查询
     *
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);
}
