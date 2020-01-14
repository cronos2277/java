<%@page import="hibernate.Hibernate"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="error.page"/></title>
</head>
<body>
<h1 align="center"> <%= Hibernate.Status %></h1>
<h1 align="center"><a href="main.action"><s:text name="error.back"/></a></h1>
<!-- 
	o "error.back" se refere a chave do arquivo properties_linguagem, que está sendo usada de
	acordo, com a configuração do Browser do cliente.
 -->
</body>
</html>