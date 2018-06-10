package com.jokey.study.mvc;

/**
 * @author :JokeyFeng
 * Date: 21:52 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */

public interface BaseMapper<T> {

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 新增操作
     *
     * @param entity
     * @return
     */
    Integer insert(T entity);

    /**
     * 更新操作
     *
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 根据主键ID删除
     *
     * @param id
     * @return
     */
    Integer deleteById(Integer id);
}
