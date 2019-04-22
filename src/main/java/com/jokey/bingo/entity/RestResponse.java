package com.jokey.bingo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhengjingfeng
 * @created 2019/4/10 13:34
 * @comment 请求响应数据封装实体
 */
@Data
@NoArgsConstructor
public class RestResponse<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("状态码说明")
    private String message;

    @ApiModelProperty("数据集")
    private T data;

    public RestResponse(T data) {
        this.code = 200;
        this.message = "成功";
        this.data = data;
    }

    public static <T> RestResponse<T> success(T data) {
        RestResponse<T> response = new RestResponse<>();
        response.setCode(200);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }
}
