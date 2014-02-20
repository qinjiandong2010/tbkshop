package ${bean.domain}.domain;
/**
 * ${bean.comment}
 * 
 * @author ${bean.authorName}
 */
public class ${bean.name}{
	<#list bean.columns as column>
	//${column.comment}
	private ${column.dataType} ${column.nameI};
	</#list>  

	public ${bean.name}() {
	}

 	<#list bean.columns as column>
	/*
	 *${column.comment}
	 */
	public ${column.dataType} get${column.name}() {
		return ${column.nameI};
	}
	
	/*
	 *${column.comment}
	 */
	public void set${column.name}(${column.dataType} ${column.nameI}) {
		this.${column.nameI} = ${column.nameI};
	}
	</#list>  

}