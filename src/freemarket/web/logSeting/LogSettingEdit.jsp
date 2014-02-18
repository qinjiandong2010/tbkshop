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
		<li><a href="#">日志配置管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">编辑日志配置</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="adPushForm" method="POST" class="form-horizontal form-wizard">
			<div class="widget-header">
				<h5>编辑日志配置</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${success != null}">
                <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">×</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${success}">
                    		修改日志配置成功。
                    	</c:when>
                    	<c:otherwise>
                    		修改日志配置失败。
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
				<div class="form-row">
					<label class="field-name" for="topPush">日志ID：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="id" class="span12"/>
						</div>
						<form:errors path="id" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="topPush">表名：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="tableName" class="span12"/>
						</div>
						<form:errors path="tableName" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="topPush">业务名称：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="businessName" class="span12"/>
						</div>
						<form:errors path="businessName" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="topPush">创建用户ID：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="createUserId" class="span12"/>
						</div>
						<form:errors path="createUserId" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="topPush">创建时间：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="createTime" class="span12"/>
						</div>
						<form:errors path="createTime" cssClass="error"/>
					</div>
				</div>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">保存修改</button>
				</div>
			</div>
		</form:form>
	</div>
</body>