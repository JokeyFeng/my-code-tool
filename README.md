# generate-code-tool
代码生成工具，生成增删查改对应的controller、service、mapper、mapper.xml文件

#集成插件框架
持久层 mybatis
通用mapper
分页助手 PageHelper
接口文档在线生成 Swagger-UI

#对表设计的要求
1、字段驼峰命名
2、主键ID是varchar类型。如果选择int类型，controller层个别方法的返回值需要修改返回类型