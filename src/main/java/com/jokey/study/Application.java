package com.jokey.study;

import com.jokey.study.entity.GeneratorParam;
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

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        //设置表参数
        GeneratorParam generatorParam = new GeneratorParam();
        generatorParam.setAuthor("jokey");
        generatorParam.setBasePackage("com.jokey.sys");
        generatorParam.setTableName("sys_user");
        generatorParam.setPath("D://generate");
        generatorParam.setResourceDescription("系统用户管理表");
    }
}
