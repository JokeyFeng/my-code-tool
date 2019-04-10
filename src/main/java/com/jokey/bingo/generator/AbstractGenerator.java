package com.jokey.bingo.generator;

import com.jokey.bingo.entity.GeneratorParam;

import java.sql.ResultSet;

/**
 * @author Zhengjingfeng
 * @created 2019/4/10 12:21
 * @comment 模板生成器抽象类
 */
public abstract class AbstractGenerator {

    /**
     * 代码生成器参数
     */
    protected GeneratorParam generatorParam;


    public AbstractGenerator(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    public GeneratorParam getGeneratorParam() {
        return generatorParam;
    }

    public void setGeneratorParam(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    /**
     * 生成代码文件
     *
     * @param resultSet
     * @throws Exception
     */
    public abstract void generateCodeFile(ResultSet resultSet) throws Exception;
}
