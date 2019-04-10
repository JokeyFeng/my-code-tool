package com.jokey.bingo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Zhengjingfeng
 * @created 2019/4/10 13:34
 * @comment
 */
@Data
public class RestResponse<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态码说明")
    private String message;

    @ApiModelProperty("结果集")
    private T data;

    public RestResponse(T data) {
        this.code = 200;
        this.message = "成功";
        this.data = data;
    }
}
