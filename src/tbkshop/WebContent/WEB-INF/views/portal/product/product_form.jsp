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
		<li><a href="#">商品管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="/category/list.html">商品分类列表</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">添加商品分类</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="categoryForm" method="POST" class="form-horizontal form-wizard">
			<div class="widget-header">
				<h5>添加商品分类</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${success != null}">
                <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">×</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${success}">
                    		添加商品分类成功。
                    	</c:when>
                    	<c:otherwise>
                    		未知操作。
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
				<div class="form-row">
					<label class="field-name" for="typeName">分类名称：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="typeName" class="span12"  maxlength="20" /> 
							<span class="add-on">不能超过20个字符</span>
						</div>
						<form:errors path="typeName" cssClass="error"/>
					</div>
				</div>
			    <div class="form-row">
					<label class="field-name" for="parent">上级分类：</label>
					<div class="field">
					    <form:select path="parent" data-placeholder="一级分类" class="chosen" tabindex="-1">
                        <c:forEach var="category" items="${categoryList }">
                            <optgroup label="${category.typeName }">
                            <c:forEach var="category2" items="${category.sunTypeList }">
                                <option value="${category2.id }">${category2.typeName }</option>
                            </c:forEach>
                            </optgroup>
                        </c:forEach>
                        </form:select>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="description">描述：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="description" class="span12" maxlength="100" /> 
						</div>
						<form:errors path="description" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="orderNo">排序编号：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="orderNo" class="span12" maxlength="20" /> 
						</div>
						<form:errors path="orderNo" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
                    <label class="field-name">是否显示：</label>
                    <div class="field">
                        <input type="checkbox" name="visible" class="toggle" value="true"/>
                    </div>
                </div>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">添加分类</button>
				</div>
			</div>
		</form:form>
	</div>
</body>