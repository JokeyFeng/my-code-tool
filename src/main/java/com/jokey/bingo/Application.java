package com.jokey.bingo;

import com.jokey.bingo.entity.GeneratorParam;
import com.jokey.bingo.generator.*;
import com.jokey.bingo.utils.CodeGenerateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Date;

/**
 * @author :JokeyFeng
 * Date: 21:41 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        //设置表参数
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setUrl("jdbc:mysql://192.168.102.147:3306/test?useSSL=false");
        generatorParam.setAuthor("jokey");
        generatorParam.setBasePackage("com.jokey.bingo.demo");
        generatorParam.setTableName("sys_user");
        generatorParam.setPath("D://generate//");
        generatorParam.setGenerateDate(new Date());
        generatorParam.setResourceDescription("系统用户管理");
        createDir(generatorParam.getPath());
        CodeGenerateUtil.generate(new ModelGenerator(generatorParam));
        CodeGenerateUtil.generate(new MapperGenerator(generatorParam));
        CodeGenerateUtil.generate(new MappingGenerator(generatorParam));
        CodeGenerateUtil.generate(new ServiceGenerator(generatorParam));
        CodeGenerateUtil.generate(new ServiceImplGenerator(generatorParam));
        CodeGenerateUtil.generate(new ControllerGenerator(generatorParam));
    }

    /**
     * 创建文件夹
     *
     * @param path
     */
    private static void createDir(String path) {
        final File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
