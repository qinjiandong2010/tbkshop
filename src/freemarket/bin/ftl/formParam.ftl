package ${bean.domain}.form;
/**
 * ${bean.comment}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.name}FormParam extends PublicFormParam{
<#list bean.columns as column>
	private ${column.dataType} ${column.name};
</#list>  

	public ${bean.name}FormParam() {
	}

<#list bean.columns as column>
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
}
