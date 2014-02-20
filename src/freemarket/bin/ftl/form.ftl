package ${bean.domain}.form;

import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.stomato.domain.${bean.name};
/**
 * ${bean.comment}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.name}Form {
<#list bean.columns as column>
	//${column.comment}
	<#if column.dataType == "String">
		<#if !column.isNull>@NotEmpty</#if>
		<#if column.size > 0 >@Size(min=1, max=${column.size}) </#if>
	</#if>
	private ${column.dataType} ${column.name};
</#list>  

	public ${bean.name}Form() {
	}

<#list bean.columns as column>
	/*
	 *${column.comment}
	 */
	public ${column.dataType} get${column.name}() {
		return ${column.name};
	}
	
	/*
	 *${column.comment}
	 */
	public void set${column.name}(${column.dataType} ${column.name}) {
		this.${column.name} = ${column.name};
	}
</#list>  

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public ${bean.name} asPojo() {
		${bean.name} param = new ${bean.name}();
		BeanUtils.copyProperties(this, param);
		return param;
	}
}
