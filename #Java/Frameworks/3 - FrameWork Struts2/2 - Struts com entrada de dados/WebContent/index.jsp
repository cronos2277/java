<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecionando...</title>
</head>
<body>
<% response.sendRedirect(request.getContextPath()+"/math!input.action"); %>
</body>
</html>
<!-- 
A novidade ai � a inclus�o do par�metro input, no caso o redirecionamento ocorre com a inser��o deste
par�metro, o mesmo � decidido dentro do atributo result, dentro de action no struts.xml

 -->