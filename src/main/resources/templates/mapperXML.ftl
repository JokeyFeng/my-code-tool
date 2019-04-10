<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.mapper.${table_name}Mapper">
    <resultMap id="BaseResultMap" type="${package_name}.entity.${table_name}">
    <#if model_column?exists>
    <#list model_column as model>
        <result column="${model.columnName}" property="${model.changeColumnName?uncap_first}"<#if model.columnType = 'INT'> jdbcType="INTEGER"<#elseif model.columnType = 'DATETIME'><#elseif model.columnType = 'TEXT'><#else> jdbcType="${model.columnType}"</#if>/>
    </#list>
    </#if>
    </resultMap>
    <sql id="Base_Column_List">
        <#if model_column?exists>
        <#list model_column as model>${model.columnName}<#if model_has_next>, </#if></#list>
        </#if>
    </sql>
</mapper>