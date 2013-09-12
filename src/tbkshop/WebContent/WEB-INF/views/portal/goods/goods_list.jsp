<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/page" prefix="p"%>
<%@include file="../includes/config.jsp"%>
<body>
	<div class="row-fluid">
		<div class="span12">
			<!-- END THEME CUSTOMIZER-->
			<ul class="breadcrumb">
				<li><a href="/"><i class="icon-home"></i></a><span
					class="divider">&nbsp;</span></li>
				<li><a href="#">商品管理</a> <span class="divider">&nbsp;</span></li>
				<li><a href="#">商品列表</a><span class="divider-last">&nbsp;</span></li>
			</ul>
		</div>
	</div>
	<!-- BEGIN ADVANCED TABLE widget-->
	<div class="row-fluid">
		<div class="span12">
			<div class="widget">
				<div class="widget-header">
					<h5>商品列表</h5>
					<form:form id="searchForm" commandName="formParam" method="post" class="form-inline">
                    <form:hidden path="pageNum" id="pageNum"/>
                    <form:hidden path="startDate" id="search_start" />
                    <form:hidden path="endDate" id="search_end" />
					<ul class="widget-nav">
						<li id="reportrange">
						    <img src="/img/icon/14x14/light/calendar.png" alt=""> <span></span>
						</li>
						<li>
							<%@include file="../includes/pagesize.jsp" %>
						</li>
						<li class="search-col"><form:input path="goodsName" type="text" class="search-input" maxlength="20" placeholder="商品名称"/></li>
						<li class="search-col"><button type="submit" class="button button-turquoise small-button">查询</button></li>
						<li id="export-excel"><a href="javascript:;"><img src="/img/icon/14x14/light/download4.png" title="导出excel"></a></li>
					</ul>
					</form:form>
				</div>
				<div class="widget-body table-container">
					<div class="dataTables_wrapper">
						<table class="default-table stripped turquoise dataTable">
							<thead>
								<tr align="left" style="line-height: 37px;">
								   <th>#</th>
								   <th>Icon</th>
								   <th>商品编号</th>
			                       <th>商品名称</th>
			                       <th>显示名称</th>
			                       <th>商家</th>
			                       <th>品牌</th>
			                       <th>分类</th>
			                       <th>单价</th>
			                       <th>原价</th>
			                       <th>佣金</th>
			                       <th>购买数</th>
			                       <th>创建日期</th>
			                       <th>状态</th>
			                       <th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${goodsList}" var="item" varStatus="stat">
					            		<tr class="gradeX ${(stat.index%2) == 0 ? 'odd':'even' }">
					            			<td class="sorting_1">${stat.index+1}</td>
					                        <td><img width="100px" src="${item.sIcon}"/></td>
					                        <td>${item.goodsCode}</td>
					                        <td>${item.goodsName}</td>
					                        <td>${item.displayName}</td>
					                        <td>
												<c:forEach items="${shopList}" var="shop" >
						                        	<c:if test="${shop.id == item.shopId}">
						                        		${shop.shopName }
						                        	</c:if>
					                        	</c:forEach>
											</td>
											<td>
												<c:forEach items="${brandList}" var="brand" >
						                        	<c:if test="${brand.id == item.brandId}">
						                        		${brand.brandName }
						                        	</c:if>
					                        	</c:forEach>
											</td>
<%-- 											<td>
												<c:forEach items="${categoryList}" var="category" >
						                        	<c:if test="${category.id == item.cateId}">
						                        		${category.typeName }
						                        	</c:if>
					                        	</c:forEach>
											</td> --%>
					                        <td>${item.sellPrice }</td>
					                        <td>${item.costPrice }</td>
					                        <td>${item.commPrice }</td>
					                        <td>${item.buys }</td>
					                        <td><fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd" /></td>
					                        <td>
												<c:choose>
													<c:when test="${item.status}">
														<span class="label label-success">上架</span>
													</c:when>
													<c:otherwise>
														<span class="label label-warning">下架</span>
													</c:otherwise>
												</c:choose>
											</td>
					                        <td class=" ">
					                        	<a href="/goods/${item.id }/edit.html">编辑</a>
					                        	<a href="javascript:void(0)" onclick="deleteData('/goods/${item.id }/delete.html')">删除</a>
					                        </td>
					                    </tr>
					           </c:forEach>
							</tbody>
						</table>
						<div class="tableFooter">
							<p:page pageNum="${formParam.pageNum}" pageTotal="${formParam.pageTotal}"></p:page>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>