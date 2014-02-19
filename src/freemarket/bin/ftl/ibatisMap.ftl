<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${bean.domain}dao.${bean.className}Dao">

	<resultMap type="${bean.domain}.domain.${bean.className}" id="${bean.className}">
		<#list bean.attributes as attribute>
	 	<result property="${attribute.name}" column="${attribute.metaData.name}" />
		</#list>  
	</resultMap>
	
	<insert id="add" parameterType="${bean.domain}.domain.${bean.className}">
		insert into ${bean.metaData.name}(
				<#list bean.attributes as attribute>
	 		 	${attribute.metaData.name}<#if (attribute_index+1) != (bean.attributes?size)>,</#if>
				</#list>  
		)
		values(
			   <#list bean.attributes as attribute>
	 		 	${attribute.name}<#if (attribute_index+1) != (bean.attributes?size)>,</#if>
			   </#list>  
			 )
	</insert>
</mapper>