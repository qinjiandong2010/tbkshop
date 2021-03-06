<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><style type="text/css">.navbar .span2{width:14%;}</style></head>
<body>
	<ul class="breadcrumb">
		<li><a href="/"><i class="icon-home"></i></a><span
			class="divider">&nbsp;</span></li>
		<li><a href="#">${bean.comment}管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">编辑${bean.comment}</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="beanForm" method="POST" class="form-horizontal form-wizard">
			<div class="widget-header">
				<h5>编辑༭${bean.comment}</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${'$'}{success != null}">
                <div class="note ${'$'}{success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">x</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${'$'}{success}">
                    		修改${bean.comment}成功。
                    	</c:when>
                    	<c:otherwise>
                    		修改${bean.comment}失败。
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
                <#list bean.columns as column>
                <#if !column.priKey>
                <div class="form-row">
					<label class="field-name" for="${column.nameI}">${column.comment}：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="${column.nameI}" maxlength="50" /> 
							<span class="add-on">*</span>
						</div>
						<form:errors path="${column.nameI}" cssClass="error"/>
					</div>
				</div>
				</#if>
				</#list>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">保存修改</button>
				</div>
			</div>
		</form:form>
	</div>
</body>