package ${bean.packagePath}bean;
/**
 * ${bean.businessName}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.className}{
	<#list bean.attributes as attribute>
	//${attribute.description}
	private ${attribute.dataType} ${attribute.name};
	</#list>  

	public ${bean.className}() {
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