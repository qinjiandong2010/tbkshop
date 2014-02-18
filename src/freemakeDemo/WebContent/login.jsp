<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:form action="getVediosByCategory">  
        登录名：<s:textfield name="username"/><br>   
       密码：<s:textfield name="password"/>   
        <s:submit value="登录" />   
</s:form> 