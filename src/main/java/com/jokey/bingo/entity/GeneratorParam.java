package com.jokey.bingo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :JokeyFeng
 * Date: 21:42 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */
@Data
public class GeneratorParam implements Serializable {

    private static final long serialVersionUID = 5140007298285767140L;

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
     * 代码生成时间
     */
    private Date generateDate;

    /**
     * 生成代码保存的路径
     */
    private String path;

    private String driverClass = "com.mysql.jdbc.Driver";

    private String userName = "root";

    private String password = "123456";

    private String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
}
