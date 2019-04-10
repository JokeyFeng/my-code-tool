package com.jokey.bingo.generator;

import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.utils.CodeGenerateUtil;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 22:32 2018/6/9.
 * Contact :976024396@qq.com
 * Description:Service接口层生成器
 */

public class ServiceGenerator extends AbstractGenerator {

    public ServiceGenerator(GeneratorParam generatorParam) {
        super(generatorParam);
    }

    @Override
    public void generateCodeFile(ResultSet resultSet) throws Exception {
        final String suffix = "Service.java";
        final String path = generatorParam.getPath()
                + CodeGenerateUtil.replaceUnderLineAndUpperCase(generatorParam.getTableName())
                + suffix;
        final String templateName = "service.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(50);
        CodeGenerateUtil.generateFileByTemplate(templateName, mapperFile, dataMap, generatorParam);
        logger.info("{}service层java代码已生成.....", generatorParam.getResourceDescription());
    }
}
