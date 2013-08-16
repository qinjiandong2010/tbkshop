<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body>
<div class="row-fluid">
   <div class="span12">
       <!-- END THEME CUSTOMIZER-->
       <ul class="breadcrumb">
           <li>
               <a href="/"><i class="icon-home"></i></a><span class="divider">&nbsp;</span>
           </li>
           <li>
               <a href="#">帐户管理</a> <span class="divider">&nbsp;</span>
           </li>
           <li><a href="#"><fmt:message key="change_profile_title"/></a><span class="divider-last">&nbsp;</span></li>
       </ul>
   </div>
</div>
<div class="widget">
	 <div class="widget-header">
		<h5><fmt:message key="change_profile_title"/></h5>
	 </div>
	  <div class="widget-body form" style="display: block;">
		<c:if test="${not empty updated}">
		<div class="protip success">
			<strong><fmt:message key="tips"/></strong> <fmt:message key="change_email_success"/>
		</div>
		</c:if>
		<c:if test="${not empty error}">
		<div class="protip warn">
			<strong><fmt:message key="tips"/></strong> <fmt:message key="change_email_failed"/>
		</div>
		</c:if>
	    <!-- BEGIN FORM-->
	    <form:form commandName="profileForm" method="POST" class="form-horizontal">
	       <div class="control-group">
	          <label class="control-label" for="email"> <fmt:message key="label.account_type"/> </label>
	          <div class="controls">
	               <form:select path="type" id="accountType">
						<option value="3" ${user.roleId == 3 ? "selected=\"selected\"":"" }><fmt:message key="option.individual"/></option>
						<option value="4" ${user.roleId == 4 ? "selected=\"selected\"":"" }><fmt:message key="option.company"/></option>
					</form:select>
	          </div>
	       </div>
	       <div class="control-group">
	          <label class="control-label" for="company"> <fmt:message key="label.company_name"/> </label>
	          <div class="controls">
	               <form:input path="company" value="${user.company }" autocomplete="off" id="company"/> 
				   <form:errors path="company" cssClass="error" />
	          </div>
	       </div>
	       <div class="control-group">
	          <label class="control-label" for="contactName"> <fmt:message key="label.contact_name"/> </label>
	          <div class="controls">
					<form:input path="contactName" value="${user.contactName }" autocomplete="off"/> 
					<form:errors path="contactName" cssClass="error" />
	          </div>
	       </div>
	       <div class="control-group">
	          <label class="control-label" for="contactTel"> <fmt:message key="label.contact_tel"/> </label>
	          <div class="controls">
	               <form:input path="contactTel" value="${user.contactTel }" autocomplete="off"/> 
			 	   <form:errors path="contactTel" cssClass="error" />
	          </div>
	       </div>
	       <div class="control-group">
	          <label class="control-label" for="qq"> <fmt:message key="label.qq"/> </label>
	          <div class="controls">
	               <form:input path="qq" value="${user.qq }" autocomplete="off"/> 
                   <form:errors path="qq" cssClass="error" />
	          </div>
	       </div>
	       <div class="form-actions">
	          <button type="submit" class="btn btn-success"><fmt:message key="change_my_profile"/></button>
	       </div>
	    </form:form>
	    <!-- END FORM-->
	 </div>
</div>
 </body>