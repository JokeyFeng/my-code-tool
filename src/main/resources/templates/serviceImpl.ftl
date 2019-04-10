package ${package_name}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jokey.bingo.mvc.BaseServiceImpl;
import com.jokey.bingo.mvc.MyMapper;
import com.yiheni.framework.mvc.service.impl.BaseServiceImpl;
import ${package_name}.entity.${table_name};
import ${package_name}.mapper.${table_name}Mapper;
import ${package_name}.service.${table_name}Service;

/**
* @Author ${author}
* @Date ${date?string('yyyy年M月d日')}
* @Version 1.0
*/
@Service
public class ${table_name}ServiceImpl extends BaseServiceImpl<${table_name}> implements ${table_name}Service {

    @Autowired
    private ${table_name}Mapper ${table_name?uncap_first}Mapper;

    @Override
    protected MyMapper<${table_name}> getMapper() {
        return ${table_name?uncap_first}Mapper;
    }
}