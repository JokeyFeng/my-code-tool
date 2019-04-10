package com.jokey.bingo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Zhengjingfeng
 * @created 2019/4/10 16:54
 * @comment 分页对象设置
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = -6393039696117299637L;

    /**
     * 页码，从1开始
     */
    @ApiModelProperty("页码")
    private Integer pageNum = 1;
    /**
     * 每页的数量,默认10
     */
    @ApiModelProperty("每页的数量")
    private Integer pageSize = 10;
    /**
     * 查询条件的参数
     *//*
    @ApiModelProperty("查询条件的参数")
    private Map<String, Object> params = new HashMap<>();*/

   /**
     * 排序
     *//*
    @ApiModelProperty("排序")
    private Map<String, Integer> sort = new LinkedHashMap<>();*/

    /**
     * 排序
     */
    private String orderBy;

}
