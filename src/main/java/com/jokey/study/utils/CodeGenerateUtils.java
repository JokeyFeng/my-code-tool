package com.jokey.study.utils;

import com.jokey.study.entity.GeneratorParam;
import com.jokey.study.file.ModelGenerator;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 21:57 2018/6/9.
 * Contact :976024396@qq.com
 * Description:代码生成工具
 */

public class CodeGenerateUtils {

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection(GeneratorParam generatorParam) throws Exception {
        Class.forName(generatorParam.getDriverClass());
        Connection connection= DriverManager.getConnection(generatorParam.getUrl(), generatorParam.getUserName(), generatorParam.getPassword());
        return connection;
    }

    public static void generate(ModelGenerator modelGenerator) throws Exception {
        Connection connection = getConnection(modelGenerator.getGeneratorParam());
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getColumns(null,"%", modelGenerator.getGeneratorParam().getTableName(),"%");
        modelGenerator.generateModelFile(resultSet);
    }
    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    /**
     * 根据模板生成文件
     *
     * @param templateName
     * @param file
     * @param dataMap
     * @param generatorParam
     * @throws Exception
     */
    public static void generateFileByTemplate(final String templateName,
                                              File file, Map<String, Object> dataMap,
                                              GeneratorParam generatorParam) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", generatorParam.getTableName());
        dataMap.put("table_name", replaceUnderLineAndUpperCase(generatorParam.getTableName()));
        dataMap.put("author", generatorParam.getAuthor());
        dataMap.put("package_name", generatorParam.getBasePackage());
        dataMap.put("table_annotation", generatorParam.getResourceDescription());
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }
}
