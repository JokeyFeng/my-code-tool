package com.jokey.study.file;

import com.jokey.study.entity.GeneratorParam;
import com.jokey.study.utils.CodeGenerateUtils;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 22:28 2018/6/9.
 * Contact :976024396@qq.com
 * Description:SQL文件生成器
 */

public class MappingGenerator {

    private GeneratorParam generatorParam;

    public MappingGenerator(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    public void generateMapperFile(ResultSet resultSet) throws Exception {
        final String suffix = "Mapper.xml";
        final String path = generatorParam.getPath()
                + CodeGenerateUtils.replaceUnderLineAndUpperCase(generatorParam.getTableName())
                + suffix;
        final String templateName = "mapping.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap();
        CodeGenerateUtils.generateFileByTemplate(templateName, mapperFile, dataMap, generatorParam);

    }
}
