<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Diretiva Include</title>
</head>
<body>
    <%@include file="barra.html" %>
    <hr>
    <%
       String mensagem = "";
       mensagem = "<h3>Uso da diretiva include </h3>";
       out.println(mensagem);
   %>
</body>
</html>