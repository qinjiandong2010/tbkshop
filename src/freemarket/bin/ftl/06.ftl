<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
  
<body>  
${user.id}-------${user.name}------${user.group!}  <#-- !��Ϊ�վͲ����  -->  
<#--${user.group.name!}--><#-- �������ϵķ�ʽ��! freemarker����ֻ���ж�group.name�ǲ��ǿ�ֵ -->  
${(user.group.name)!"û���κ�ֵ����"} <#-- �����ֵ���ϣ���,����ֻ���ж����һ������ -->  
  
${(a.b)!"û��a.bԪ��"}  
  
<#if (a.b)??> <#--if���ü�$-->  
    ��Ϊ��  
<#else>  
    Ϊ��  
</#if>  
</body>  
</html>  