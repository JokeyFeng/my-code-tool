package com.jokey.bingo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.jokey.bingo.demo.entity.SysUser;
import com.jokey.bingo.demo.service.SysUserService;
import com.jokey.bingo.entity.Page;
import com.jokey.bingo.entity.RestResponse;
import com.jokey.bingo.mvc.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author jokey
 * @Date 2019年4月10日
 * @Version 1.0
 */
@RestController
@Api(tags = "系统用户管理")
@RequestMapping(value = "/v1/sysUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SysUserController extends BaseController<SysUser> {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<SysUser> find(@RequestParam String id) {
        return RestResponse.success(sysUserService.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<SysUser>> page(Page page) {
        return RestResponse.success(sysUserService.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "sysUser", value = "系统用户管理", paramType = "body", dataType = "SysUser")
    public RestResponse insert(@RequestBody SysUser sysUser) {
        sysUser.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return RestResponse.success(sysUserService.save(sysUser));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
        return RestResponse.success(sysUserService.batchDelete(ids, "id", SysUser.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "sysUser", value = "系统用户管理", paramType = "body", dataType = "SysUser")
    public RestResponse update(@RequestBody SysUser sysUser) {
        return RestResponse.success(sysUserService.updateNotNull(sysUser));
    }
}