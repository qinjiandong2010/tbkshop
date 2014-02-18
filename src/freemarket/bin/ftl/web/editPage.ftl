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
		<li><a href="#">${bean.businessName}����</a> <span class="divider">&nbsp;</span></li>
		<li><a href="#">�༭${bean.businessName}</a><span class="divider-last">&nbsp;</span></li>
	</ul>

	<div class="widget">
		<form:form commandName="adPushForm" method="POST" class="form-horizontal form-wizard">
			<div class="widget-header">
				<h5>�༭${bean.businessName}</h5>
			</div>
			<div class="widget-content no-padding">
				<c:if test="${'$'}{success != null}">
                <div class="note ${'$'}{success ? 'note-success' :'note-danger'}" style="margin: 20px 30px;">
                    <button type="button" class="close note-remove">��</button>
                    <strong><fmt:message key="tips"/></strong> 
                    <c:choose>
                    	<c:when test="${'$'}{success}">
                    		�޸�${bean.businessName}�ɹ���
                    	</c:when>
                    	<c:otherwise>
                    		�޸�${bean.businessName}ʧ�ܡ�
                    	</c:otherwise>
                    </c:choose>
                </div>
                </c:if>
                <#list bean.attributes as attribute>
				<div class="form-row">
					<label class="field-name" for="topPush">${attribute.description}��</label>
					<div class="field">
						<div class="input-prepend input-append">
							<form:input path="${attribute.name}" class="span12"/>
						</div>
						<form:errors path="${attribute.name}" cssClass="error"/>
					</div>
				</div>
				</#list>
				<div class="form-row" style="padding-left: 180px;">
					<button type="submit" class="button button-blue">�����޸�</button>
				</div>
			</div>
		</form:form>
	</div>
</body>