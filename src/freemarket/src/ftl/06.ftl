<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
  
<body>  
${user.id}-------${user.name}------${user.group!}  <#-- !后为空就不输出  -->  
<#--${user.group.name!}--><#-- 按照以上的方式加! freemarker仅仅只会判断group.name是不是空值 -->  
${(user.group.name)!"没有任何值存在"} <#-- 处理空值加上（）,否则只会判断最后一个属性 -->  
  
${(a.b)!"没有a.b元素"}  
  
<#if (a.b)??> <#--if后不用加$-->  
    不为空  
<#else>  
    为空  
</#if>  
</body>  
</html>  