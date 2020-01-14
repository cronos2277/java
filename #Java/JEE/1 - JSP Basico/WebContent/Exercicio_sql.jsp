<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplos com mysql</title>
</head>
<body>
<sql:setDataSource var="conexao" dataSource="jdbc:mysql//127.0.0.1/java_ee,com.mysql.jdbc.Driver,root,123456"/>
<sql:query var="consulta" dataSource="${conexao}"> select * from usuarios</sql:query>
</body>
</html>