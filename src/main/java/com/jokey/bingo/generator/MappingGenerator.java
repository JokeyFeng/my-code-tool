package com.jokey.bingo.generator;

import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.utils.CodeGenerateUtil;

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
        final String templateName = "mapping.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(50);
        CodeGenerateUtil.generateFileByTemplate(templateName, mapperFile, dataMap, generatorParam);

    }
}
