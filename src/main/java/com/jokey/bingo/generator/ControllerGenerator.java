package com.jokey.bingo.generator;

import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.utils.CodeGenerateUtil;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :JokeyFeng
 * Date: 22:39 2018/6/9.
 * Contact :976024396@qq.com
 * Description:controller层生成器
 */

public class ControllerGenerator extends AbstractGenerator {

    public ControllerGenerator(GeneratorParam generatorParam) {
        super(generatorParam);
    }

    @Override
    public void generateCodeFile(ResultSet resultSet) throws Exception {
        final String suffix = "Controller.java";
        final String path = super.generatorParam.getPath()
                + CodeGenerateUtil.replaceUnderLineAndUpperCase(super.generatorParam.getTableName())
                + suffix;
        final String templateName = "controller.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>(50);

        CodeGenerateUtil.generateFileByTemplate(templateName, mapperFile, dataMap, super.generatorParam);
    }
}
