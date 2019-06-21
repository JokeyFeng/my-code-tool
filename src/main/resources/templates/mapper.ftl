package ${package_name}.mapper;

import com.jokey.bingo.mvc.MyMapper;
import ${package_name}.entity.${table_name};
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ${author}
 * Date ${date?string('yyyy年M月d日')}
 */
@Mapper
@Component
public interface ${table_name}Mapper extends MyMapper<${table_name}> {
}