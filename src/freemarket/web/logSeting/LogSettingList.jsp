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
				<li><a href="#">日志配置管理</a> <span class="divider">&nbsp;</span></li>
				<li><a href="#">日志配置</a><span class="divider-last">&nbsp;</span></li>
			</ul>
		</div>
	</div>
	<!-- BEGIN ADVANCED TABLE widget-->
	<div class="row-fluid">
		<div class="span12">
			<div class="widget">
				<div class="widget-header">
					<h5>日志配置列表</h5>
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
						<li class="search-col"><form:input path="id" type="text" class="search-input" maxlength="20" placeholder="日志ID"/></li>
						<li class="search-col"><form:input path="tableName" type="text" class="search-input" maxlength="20" placeholder="表名"/></li>
						<li class="search-col"><form:input path="businessName" type="text" class="search-input" maxlength="20" placeholder="业务名称"/></li>
						<li class="search-col"><form:input path="createUserId" type="text" class="search-input" maxlength="20" placeholder="创建用户ID"/></li>
						<li class="search-col"><form:input path="createTime" type="text" class="search-input" maxlength="20" placeholder="创建时间"/></li>
						<li class="search-col"><button type="submit" class="button button-turquoise small-button">查询</button></li>
					</ul>
					</form:form>
				</div>
				<div class="widget-body table-container">
					<div class="dataTables_wrapper">
						<table class="default-table stripped turquoise dataTable">
							<thead>
								<tr align="left">
									<th class="sorting">#</th>
									<th class="sorting">id</th>
									<th class="sorting">tableName</th>
									<th class="sorting">businessName</th>
									<th class="sorting">createUserId</th>
									<th class="sorting">createTime</th>
									<th class="sorting">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${adPushList}" var="item" varStatus="stat">
									<tr class="${(stat.index%2) == 0 ? 'odd':'even' }">
										<td>${stat.index+1}</td>
										<td>id</td>
										<td>tableName</td>
										<td>businessName</td>
										<td>createUserId</td>
										<td>createTime</td>
				                        <td class=" ">
				                        	<a href="/LogSetting/${item.id }/edit.html">编辑</a>
				                        	<a href="/LogSetting/${item.id }/delete.html">删除</a>
				                        	<a href="/LogSetting/${item.id }/detail.html">详细</a>
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