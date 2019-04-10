package ${package_name}.model;

import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.Serializable;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

/**
* @author :${author}
* Date:${date?string('yyyy年M月d日')}
* Description:${resource_name}
*/

@Data
public class ${table_name} implements Serializable {

    private static final long serialVersionUID = 1L;

<#if model_column?exists>
<#list model_column as model>
    /**
    * ${model.columnComment!}
    */
    @ApiModelProperty("${model.columnComment!}")
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'TEXT' || model.columnType = 'CHAR')>
    <#if model.changeColumnName = 'Id'>
    @Id
    </#if>
    private String ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'TIMESTAMP' >
    private Timestamp ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'DATETIME' >
    private Timestamp ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'DATE' >
    private Date ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'TIME' >
    private Time ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'BIT' >
    private Boolean ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'TINYINT' || model.columnType = 'SMALLINT' || model.columnType = 'MEDIUMINT' || model.columnType = 'INT'>
    private Integer ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'INTEGER'>
    private Long ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'BIGINT'>
    private BigInteger ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'FLOAT'>
    private Float ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'DOUBLE'>
    private Double ${model.changeColumnName?uncap_first};
    </#if>
    <#if model.columnType = 'DECIMAL'>
    private BigDecimal ${model.changeColumnName?uncap_first};
    </#if>

</#list>
</#if>
<#--<#if model_column?exists>
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
</#if>-->
}