package com.jokey.study.file;

import com.jokey.study.entity.ColumnClass;
import com.jokey.study.entity.GeneratorParam;
import com.jokey.study.utils.CodeGenerateUtils;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 22:03 2018/6/9.
 * Contact :976024396@qq.com
 * Description:实体类生成器
 */

public class ModelGenerator {

    private GeneratorParam generatorParam;

    public ModelGenerator(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    /**
     * 根据model.ftl生成实体类
     * @param resultSet
     * @throws Exception
     */
    public void generateModelFile(ResultSet resultSet) throws Exception {

        final String suffix = ".java";
        final String path = generatorParam.getPath()
                + CodeGenerateUtils.replaceUnderLineAndUpperCase(generatorParam.getTableName())
                + suffix;
        final String templateName = "model.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList();
        ColumnClass columnClass;
        while (resultSet.next()) {
            //id字段略过
            if (resultSet.getString("COLUMN_NAME").equals("id")) {
                continue;
            }
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(CodeGenerateUtils.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap();
        dataMap.put("model_column", columnClassList);

        CodeGenerateUtils.generateFileByTemplate(templateName, mapperFile, dataMap, generatorParam);
    }
}
