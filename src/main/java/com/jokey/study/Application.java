package com.jokey.study;

import com.jokey.study.entity.GeneratorParam;
import com.jokey.study.file.ModelGenerator;
import com.jokey.study.utils.CodeGenerateUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author :JokeyFeng
 * Date: 21:41 2018/6/9.
 * Contact :976024396@qq.com
 * Description:
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class,args);
        //设置表参数
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        generatorParam.setAuthor("jokey");
        generatorParam.setBasePackage("com.jokey.sys");
        generatorParam.setTableName("sys_user");
        generatorParam.setPath("D://generate//");
        generatorParam.setResourceDescription("系统用户管理表");

        CodeGenerateUtils.generate(new ModelGenerator(generatorParam));
    }
}
