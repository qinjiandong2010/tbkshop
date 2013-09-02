<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<style type="text/css">
.navbar .span2{width:14%;}
.input-append input{width: 235px;}
select{width:250px;}
textarea {width:600px;}
.add-on{color: red;}
</style>
</head>
<body>
	<ul class="breadcrumb">
		<li><a href="/"><i class="icon-home"></i></a><span
			class="divider">&nbsp;</span></li>
		<li><a href="#">商品管理</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">修改商品</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="goodsForm" method="POST" class="form-horizontal form-wizard" enctype="multipart/form-data">
			<div class="widget-header">
				<h5>修改商品</h5>
			</div>
			<c:if test="${success != null}">
                <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">×</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${success}">
                    		修改商品成功。
                    	</c:when>
                    	<c:otherwise>
                    		修改商品失败。
                    	</c:otherwise>
                    </c:choose>
                </div>
            </c:if>
			<div class="widget-content no-padding">
				<div class="form-row">
					<label class="field-name" for="goodsCode">商品编码：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="goodsCode" maxlength="50" /> 
							<span class="add-on">*</span>
						</div>
						<form:errors path="goodsCode" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="goodsName">商品名称：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="goodsName" maxlength="100" /> 
							<span class="add-on">*</span>
						</div>
						<form:errors path="goodsName" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="shopId">商家：</label>
					<div class="field">
						<form:select path="shopId" class="chosen">
							<c:forEach var="shop" items="${shopList }">
	                            <form:option value="${shop.id }">${shop.shopName }</form:option>
	                        </c:forEach>
						</form:select>
						<form:errors path="shopId" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="brandId">选择品牌：</label>
					<div class="field">
						<form:select path="brandId" class="chosen">
							<c:forEach var="brand" items="${brandList }">
	                            <form:option value="${brand.id }">${brand.brandName }</form:option>
	                        </c:forEach>
						</form:select>
						<form:errors path="brandId" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="cateId">商品分类：</label>
					<div class="field">
						<form:select path="cateId" data-placeholder="请选择一个分类" class="chosen" tabindex="-1">
                        <c:forEach var="category" items="${categoryList }">
                            <optgroup label="${category.typeName }">
                            <c:forEach var="childCate" items="${category.listNode }">
                                <option value="${childCate.id }">${childCate.typeName }</option>
                            </c:forEach>
                            </optgroup>
                        </c:forEach>
                        </form:select>
						<form:errors path="cateId" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="shopPrice">商品价格：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="shopPrice" maxlength="20" /> 
							<span class="add-on">* 单位（元）</span>
						</div>
						<form:errors path="shopPrice" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="marketPrice">市场价：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="marketPrice" maxlength="20" /> 
							<span class="add-on">* 单位（元）</span>
						</div>
						<form:errors path="marketPrice" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="commission">佣金：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="commission" maxlength="20" /> 
							<span class="add-on">* 单位（元）</span>
						</div>
						<form:errors path="commission" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="linkUrl">推广URL：</label>
					<div class="field">
						<form:input path="linkUrl" maxlength="500" /> 
					</div>
					<form:errors path="linkUrl" cssClass="error"/>
				</div>
				<div class="form-row">
					<label class="field-name" for="goodsIcon">商品图标：</label>
					<div class="field">
						<form:input path="goodsIcon" maxlength="200" /> 
						<form:errors path="goodsIcon" cssClass="error"/>
					</div>
				</div>
			    <c:forEach var="imgUrl" items="${goodsForm.goodsPics }" varStatus="status">
					<div class="form-row">
						<label class="field-name" for="goodsPics">商品图片${status.index }：</label>
						<div class="field">
							<form:input path="goodsPics" value="${imgUrl}" /> 
						</div>
					</div>
				</c:forEach>
				<div class="form-row">
					<label class="field-name" for="keyword">商品关键字：</label>
					<div class="field">
						<form:input path="keyword" maxlength="100" /> 
						<form:errors path="keyword" cssClass="error"/>
					</div>
				</div>
				<div class="form-row">
					<label class="field-name" for="brief">概要描述：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:textarea path="brief" rows="5" cols="70" maxlength="300"/> 
						</div>
						<form:errors path="brief" cssClass="error"/>
					</div>
				</div>
			    <div class="form-row">
					<label class="field-name" for="content">商品描述：</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:textarea path="content" rows="5" cols="70" maxlength="3000"/> 
						</div>
						<form:errors path="content" cssClass="error"/>
					</div>
				</div>
				<div class="form-row" style="padding-left: 208px;">
					<button type="submit" class="button button-blue">修改商品</button>
				</div>
			</div>
		</form:form>
	</div>
</body>