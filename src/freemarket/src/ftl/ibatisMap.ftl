<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${bean.domain}.dao.${bean.name}Dao">

	<resultMap type="${bean.domain}.domain.${bean.name}" id="${bean.nameI}">
		<#list bean.columns as column>
	 	<result property="${column.nameI}" column="${column.nameZ}" />
		</#list>  
	</resultMap>
	
	<insert id="add" parameterType="${bean.domain}.domain.${bean.name}">
		insert into ${bean.nameZ}(
				<#list bean.columns as column>
	 		 	${column.nameZ}<#if (column_index+1) != (bean.columns?size)>,</#if>
				</#list>  
		)
		values(
			   <#list bean.columns as column>
	 		 	${column.nameI}<#if (column_index+1) != (bean.columns?size)>,</#if>
			   </#list>  
			 )
	</insert>
	
	<delete id="delete" parameterType="int">
		delete from ${bean.nameZ} where id = ${'#{'}id${'}'}
	</delete>
	
	<update id ="update" parameterType="${bean.domain}.domain.${bean.name}">
	    update ${bean.nameZ}
	    <set>
	    	<#list bean.columns as column>
	    	<if test="${column.nameI} != null">${column.nameZ}=${'#{'}${column.nameI}${'}'}</if><#if (column_index+1) != (bean.columns?size)>,</#if>
			</#list>
	    </set>
	     where id=${'#{'}id${'}'}
	</update>
	
	<select id="get" parameterType="int" resultMap="${bean.nameI}" >
		select 
			   <#list bean.columns as column>
	 		   ${column.nameZ}<#if (column_index+1) != (bean.columns?size)>,</#if>
			  </#list>  
		from ${bean.nameZ} where id= ${'#{'}id${'}'}
	</select>
	
	<select id="listTotal" parameterType="com.stomato.form.${bean.name}FormParam" resultType="int">
		select count(1) from ${bean.nameZ} where 1=1
		<#list bean.columns as column>
	    <if test="${column.nameI} != null">and ${column.nameZ}=${'#{'}${column.nameI}${'}'}</if>
		</#list>
	</select>
	
	<select id="list" parameterType="com.stomato.form.${bean.name}FormParam" resultMap="${bean.nameI}" >
		select  
			<#list bean.columns as column>
	 		 ${column.nameZ}<#if (column_index+1) != (bean.columns?size)>,</#if>
			</#list>  
		from ${bean.nameZ} where 1=1 
			<#list bean.columns as column>
	   		<if test="${column.nameI} != null">and ${column.nameZ}=${'#{'}${column.nameI}${'}'}</if>
			</#list>
		<if test="offset != null">limit  ${'#{'}offset${'}'},#${'#{'}pageSize${'}'}</if>
	</select>
	
</mapper>