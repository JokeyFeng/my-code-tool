package com.jokey.bingo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhengjingfeng
 * @created 2019/4/10 15:47
 * @comment
 */
@Configuration
@EnableSwagger2
public class SwaggerUI {

    @Bean
    public Docket createRestfulApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("我的接口文档")
                .description("联系方式：15626152363")
                .termsOfServiceUrl("")
                .contact(new Contact("JokeyZheng", "https://github.com/JokeyFeng", "976024396@qq.com"))
                .version("1.0")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jokey.bingo"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(this.setHeaderParameters());
    }

    /**
     * 设置固定的请求头参数
     *
     * @return
     */
    private List<Parameter> setHeaderParameters() {
        Map<String, String> map = new HashMap<>(5);
        map.put("authentication", "token令牌");
        List<Parameter> list = new ArrayList<>(5);
        for (Map.Entry<String, String> entry :map.entrySet()) {
            ParameterBuilder param = new ParameterBuilder();
            param.name(entry.getKey()).description(entry.getValue()).modelRef(new ModelRef("string"))
                    .parameterType("header").required(false).build();
            list.add(param.build());
        }
        return list;
    }
}
