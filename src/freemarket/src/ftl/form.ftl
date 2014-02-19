package ${bean.domain}.form;

import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;
import com.stomato.domain.${bean.className};
/**
 * ${bean.businessName}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.className}Form {
<#list bean.attributes as attribute>
	//${attribute.description}
	<#if attribute.dataType == "String">
		<#if !attribute.isNull>@NotEmpty</#if>
		<#if attribute.size > 0 >@Size(min=1, max=${attribute.size}) </#if>
	</#if>
	private ${attribute.dataType} ${attribute.name};
</#list>  

	public ${bean.className}Form() {
	}

<#list bean.attributes as attribute>
	/*
	 *${attribute.description}
	 */
	public ${attribute.dataType} get${attribute.initcapName}() {
		return ${attribute.name};
	}
	
	/*
	 *${attribute.description}
	 */
	public void set${attribute.initcapName}(${attribute.dataType} ${attribute.name}) {
		this.${attribute.name} = ${attribute.name};
	}
</#list>  

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public ${bean.className} asPojo() {
		${bean.className} param = new ${bean.className}();
		BeanUtils.copyProperties(this, param);
		return param;
	}
}
