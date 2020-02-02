<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecionando...</title>
</head>
<body>
<!--  
Aqui é feito o redirecionamento para a página "context.xhtml". 
O nome JSF, ele é direcionado segundo as configurações do web.xml
 -->
<jsp:forward page="context.jsf"/>
</body>
</html>
<!-- O projeto em questão, tem as seguintes bibliotecas extras, para o seu funcionamento:
javax.faces-api-2.2.jar
jsf-api-2.2.9.jar
jsf-impl-2.2.9.jar
 -->