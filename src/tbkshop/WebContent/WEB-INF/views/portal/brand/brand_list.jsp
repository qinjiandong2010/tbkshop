<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/page" prefix="p"%>
<body>
	<div class="row-fluid">
		<div class="span12">
			<!-- END THEME CUSTOMIZER-->
			<ul class="breadcrumb">
				<li><a href="/"><i class="icon-home"></i></a><span
					class="divider">&nbsp;</span></li>
				<li><a href="javascript;,">品牌管理</a> <span class="divider">&nbsp;</span></li>
				<li><a href="javascript;,">品牌列表</a> <span class="divider">&nbsp;</span></li>
			</ul>
		</div>
	</div>
	<!-- BEGIN ADVANCED TABLE widget-->
	<div class="row-fluid">
		<div class="span12">
			<div class="widget">
				<div class="widget-header">
					<h5>品牌列表</h5>
					<form:form id="searchForm" commandName="formParam" method="post" class="form-inline">
                    <form:hidden path="pageNum" id="pageNum"/>
					<ul class="widget-nav">
						<li>
							<%@include file="../includes/pagesize.jsp" %>
						</li>
						<li class="search-col"><form:input path="brandName" type="text" class="search-input" maxlength="20" placeholder="品牌名称"/></li>
						<li class="search-col"><button type="submit" class="button button-turquoise small-button">查询</button></li>
					</ul>
					</form:form>
				</div>
				<c:if test="${success != null}">
		           <div class="note ${success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
		               <button type="button" class="close note-remove">×</button>
		               <strong><fmt:message key="tips"/></strong> 
		               <c:choose>
		               	<c:when test="${success=='del'}">
		               		删除类成功。
		               	</c:when>
		               	<c:otherwise>
		               		未知操作结果。
		               	</c:otherwise>
		               </c:choose>
		           </div>
		        </c:if>
				<div class="widget-body table-container">
					<div class="dataTables_wrapper">
						<table class="default-table stripped turquoise dataTable">
							<thead>
								<tr align="left">
								   <th>#</th>
			                       <th>品牌名称</th>
			                       <th>Icon图片</th>
			                       <th>品牌分类</th>
			                       <th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${brandList}" var="item" varStatus="stat">
					            		<tr class="gradeX ${(stat.index%2) == 0 ? 'odd':'even' }">
					            			
					            			<td class="sorting_1">${stat.index+1}</td>
					                        <td>${item.brandName }</td>
					                        <td><img width="50px" src="${imgServer}${item.brandIcon}"/></td>
					                         <th>${item.cateId}</th>
					                        <td class=" ">
					                        	<a href="/brand/${item.id }/edit.html">编辑</a>
					                        	<a href="javascript:void(0)" onclick="deleteData('/brand/${item.id }/delete.html')">删除</a>
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