<%@ page language="java" import="java.util.*,java.io.*"  
pageEncoding="ISO-8859-1"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme() + "://"  
    + request.getServerName() + ":" + request.getServerPort()  
    + path + "/";  
out.clear();
out = pageContext.pushBody();
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
   <base href="<%=basePath%>">  
</head>  
<body>  
   <br>  
</body>  
</html> 