package ${bean.domain}.form;
/**
 * ${bean.businessName}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.className}Form {
<#list bean.attributes as attribute>
	//${attribute.description}
	<#if !attribute.isNull>
	@NotEmpty
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
}
