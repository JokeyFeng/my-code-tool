package com.jokey.study.entity;

import lombok.Data;

/**
 * @author :JokeyFeng
 * Date: 21:42 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */
@Data
public class GeneratorParam {
    /**
     * 表名称
     */
    private String tableName;

    /**
     * 资源说明
     */
    private String resourceDescription;

    /**
     * 作者
     */
    private String author;

    /**
     * 包路径
     */
    private String basePackage;

    /**
     * 生成代码保存的路径
     */
    private String path;


}
