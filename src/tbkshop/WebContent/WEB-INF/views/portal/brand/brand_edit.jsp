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
		<li><a href="#">品牌管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="/brand/list.html">品牌列表</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">修改品牌</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="brandForm" method="POST" class="form-horizontal form-wizard" enctype="multipart/form-data">
			<div class="widget-header">
				<h5>修改品牌</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${success != null}">
                <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">×</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${success}">
                    		修改品牌成功。
                    	</c:when>
                    	<c:otherwise>
                    		未知操作。
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
				<div class="form-row">
					<label class="field-name" for="brandName">品牌名称：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="brandName" class="span12"  maxlength="40" /> 
							<span class="add-on">不能超过40个字符</span>
						</div>
						<form:errors path="brandName" cssClass="error"/>
					</div>
				</div>
			    <div class="form-row">
					<label class="field-name" for="cateId">品牌分类：</label>
					<div class="field">
					    <form:select path="cateId" class="chosen" tabindex="-1">
                        <c:forEach var="category" items="${categoryList }">
                            <form:option value="${category.id }">${category.typeName }</form:option>
                        </c:forEach>
                        </form:select>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="iconFile">Icon图片：</label>
					<div class="field">
						<img width="50px" src="${imgServer}${brandForm.brandIcon}"/>
						<input type="file" name="iconFile" id="iconFile">
						<form:errors path="iconFile" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="sort">排序：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="sort" class="span12" maxlength="10" /> 
						</div>
						<form:errors path="sort" cssClass="error"/>
					</div>
				</div>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">修改品牌</button>
				</div>
			</div>
		</form:form>
	</div>
</body>