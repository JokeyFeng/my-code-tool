package ${package_name}.model;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

public class ${table_name} {

<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    private String ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'TIMESTAMP' >
    private Date ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'INTEGER' >
    private Integer ${model.changeColumnName?uncap_first};
    </#if>
    </#list>
</#if>
<#if model_column?exists>
    <#list model_column as model>
    <#if (model.columnType = 'INTEGER')>
    public String get${model.changeColumnName}() {
    return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
    this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>

    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT')>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>
    <#if model.columnType = 'TIMESTAMP' >
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
    </#if>
    </#list>
</#if>
}