package ${package_name}.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.ImmutableMap;
import ${package_name}.entity.${table_name};
import ${package_name}.service.${table_name}Service;
import com.jokey.bingo.entity.RestResponse;
import com.jokey.bingo.mvc.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ${author}
 * Date ${date?string('yyyy年M月d日')}
 * Version 1.0
 */
@CrossOrigin("*")
@RestController
@Api(tags = "${resource_name}")
@RequestMapping(value = "/v1/${table_name?uncap_first}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ${table_name}Controller extends BaseController<${table_name}> {

    @Autowired
    private ${table_name}Service ${table_name?uncap_first}Service;

    @GetMapping("/id")
    @ApiOperation("根据ID查询")
    @ApiImplicitParam(name = "id", value = "主键ID", paramType = "query", dataType = "String")
    public RestResponse<${table_name}> find(@RequestParam String id) {
        return RestResponse.success(${table_name?uncap_first}Service.selectByKey(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public RestResponse<PageInfo<${table_name}>> page(Page page) {
    return RestResponse.success(${table_name?uncap_first}Service.selectByPage(page));
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @ApiImplicitParam(name = "${table_name?uncap_first}", value = "${resource_name}", paramType = "body", dataType = "${table_name}")
    public RestResponse insert(@RequestBody ${table_name} ${table_name?uncap_first}) {
        ${table_name?uncap_first}.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return RestResponse.success(${table_name?uncap_first}Service.save(${table_name?uncap_first}));
    }

    @DeleteMapping("/ids")
    @ApiOperation("根据主键ID批量删除")
    @ApiImplicitParam(name = "ids", value = "主键ID集合", paramType = "query", dataType = "String", allowMultiple = true)
    public RestResponse delete(@RequestParam List<String> ids) {
       return RestResponse.success(${table_name?uncap_first}Service.batchDelete(ids, "id", ${table_name}.class));
    }

    @PutMapping("/put")
    @ApiOperation("修改")
    @ApiImplicitParam(name = "${table_name?uncap_first}", value = "${resource_name}", paramType = "body", dataType = "${table_name}")
    public RestResponse update(@RequestBody ${table_name} ${table_name?uncap_first}) {
       return RestResponse.success(${table_name?uncap_first}Service.updateNotNull(${table_name?uncap_first}));
    }
}