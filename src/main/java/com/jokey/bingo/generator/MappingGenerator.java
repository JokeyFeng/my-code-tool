package com.jokey.bingo.generator;

import com.jokey.bingo.entity.ColumnClass;
import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.utils.CodeGenerateUtil;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 22:28 2018/6/9.
 * Contact :976024396@qq.com
 * Description:SQL文件生成器
 */

public class MappingGenerator extends AbstractGenerator {

    public MappingGenerator(GeneratorParam generatorParam) {
        super(generatorParam);
    }

    @Override
    public void generateCodeFile(ResultSet resultSet) throws Exception {
        final String suffix = "Mapper.xml";
        final String path = generatorParam.getPath()
                + CodeGenerateUtil.replaceUnderLineAndUpperCase(generatorParam.getTableName())
                + suffix;
        final String templateName = "mapperXML.ftl";
        File mapperFile = new File(path);

        List<ColumnClass> columnClassList = new ArrayList<>(50);
        while (resultSet.next()) {
            ColumnClass columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(CodeGenerateUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }

        Map<String, Object> dataMap = new HashMap<>(50);
        dataMap.put("model_column", columnClassList);

        CodeGenerateUtil.generateFileByTemplate(templateName, mapperFile, dataMap, generatorParam);
        logger.info("{}mapperXML文件已生成.....", generatorParam.getResourceDescription());
    }
}
