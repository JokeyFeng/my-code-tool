package com.jokey.bingo.generator;

import com.jokey.bingo.entity.ColumnClass;
import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.utils.CodeGenerateUtil;
import lombok.Data;

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
@Data
public class ModelGenerator extends AbstractGenerator {

    public ModelGenerator(GeneratorParam generatorParam) {
        super(generatorParam);
    }

    /**
     * 根据model.ftl生成实体类
     *
     * @param resultSet
     * @throws Exception
     */
    @Override
    public void generateCodeFile(ResultSet resultSet) throws Exception {

        final String suffix = ".java";
        final String path = super.generatorParam.getPath()
                + CodeGenerateUtil.replaceUnderLineAndUpperCase(super.generatorParam.getTableName())
                + suffix;
        final String templateName = "model.ftl";
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>(50);
        ColumnClass columnClass;
        while (resultSet.next()) {
            //id字段略过
          /*  if (resultSet.getString("COLUMN_NAME").equals("id")) {
                continue;
            }*/
            columnClass = new ColumnClass();
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
    }
}
