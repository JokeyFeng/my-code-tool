package com.jokey.bingo.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author :jokey
* Date:2019年4月10日
* Description:系统用户管理
*/

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键ID
    */
    @Id
    @ApiModelProperty("主键ID")
    private String id;

    /**
    * 名字
    */
    @ApiModelProperty("名字")
    private String name;

    /**
    * 密码
    */
    @ApiModelProperty("密码")
    private String password;

    /**
    * 年龄
    */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
    * 性别。1->男 0->女
    */
    @ApiModelProperty("性别。1->男 0->女")
    private Boolean sex;

    /**
    * 工作年限
    */
    @ApiModelProperty("工作年限")
    private Integer workAge;

    /**
    * 上次登录时间
    */
    @ApiModelProperty("上次登录时间")
    private Timestamp lastLogin;

}