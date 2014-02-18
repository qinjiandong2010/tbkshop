package bean;

import java.io.Serializable;

public class ${tableName}{
	<#list columnList as column>
	//${column.description}
	private ${column.dataType} ${column.name};
	</#list>  

	public ${tableName}() {
	}

 	<#list columnList as column>
	/*
	 *${column.description}
	 */
	public ${column.dataType} get${column.name}() {
		return ${column.name};
	}
	/*
	 *${column.description}
	 */
	public void set${column.name}(${column.dataType} ${column.name}) {
		this.${column.name} = ${column.name};
	}
	</#list>  

}