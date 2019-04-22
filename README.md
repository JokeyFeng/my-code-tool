# my-code-tool
代码生成工具，生成增删查改对应的controller、service、mapper、mapper.xml文件

### 集成插件框架
持久层 mybatis
通用mapper
分页助手 PageHelper
接口文档在线生成 Swagger-UI

### 对表设计的要求
1、字段驼峰命名
2、主键ID是varchar类型。如果选择int类型，controller层个别方法的返回值需要修改返回类型

### 注意事项
生成的代码里面集成了swagger、lombok、pagehelper、通用mapper等插件，因此在进行代码文件移植的时候，请确保工程有相应的依赖。
依赖如下：

### Swagger依赖
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```
### lombok插件依赖
```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.14</version>
</dependency>
```

### 通用mapper依赖
```
<dependency>
    <groupId>tk.mybatis</groupId>
    <artifactId>mapper-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>
```

### pagehelper依赖
```
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.2.10</version>
</dependency>
```

### 演示案例
该com.jokey.bingo.demo包下的代码，都是来自本工程模板生成的.
在Application启动类中运行项目后，可访问接口文档 http://127.0.0.1:8000/swagger-ui.html
