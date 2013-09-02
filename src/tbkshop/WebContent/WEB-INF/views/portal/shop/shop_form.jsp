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
		<li><a href="#">商家管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">添加商家</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="shopForm" method="POST" class="form-horizontal form-wizard" enctype="multipart/form-data">
			<div class="widget-header">
				<h5>添加商家</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${success != null}">
                <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">×</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${success}">
                    		添加商家成功。
                    	</c:when>
                    	<c:otherwise>
                    		未知操作。
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
				<div class="form-row">
					<label class="field-name" for="shopName">商家名称：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="shopName" class="span12"  maxlength="50" /> 
							<span class="add-on">不能超过50个字符</span>
						</div>
						<form:errors path="shopName" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="shopLogoFile">商家Logo：</label>
					<div class="field">
						<input type="file" name="shopLogoFile" id="file">
						<form:errors path="shopLogoFile" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="shopUrl">商家连接：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="shopUrl" class="span12"/> 
						</div>
						<form:errors path="shopUrl" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="remark">商家介绍：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:textarea path="remark" rows="5" cols="100" maxlength="300"/> 
						</div>
						<form:errors path="remark" cssClass="error"/>
					</div>
				</div>
			    <div class="form-row">
					<label class="field-name" for="couponsUse">优惠券教程：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:textarea path="couponsUse" rows="5" cols="100" maxlength="3000"/> 
						</div>
						<form:errors path="couponsUse" cssClass="error"/>
					</div>
				</div>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">添加商家</button>
				</div>
			</div>
		</form:form>
	</div>
</body>