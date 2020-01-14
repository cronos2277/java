<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "hibernate.*, pkg.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="edit.page"/></title>
</head>
<body>
<% Entidade entidade = new Gerente().Localizar(Gerente.id); %>
<s:form action="edt.action" method="post">
<s:textfield key="edit.nome" name="nome" size="30"/>
<s:textfield key="edit.login" name="login" required="true" size="30"/>
<s:password key="edit.pass" name="senha" size="30" required="true"/>
<s:select key="edit.func" list="cargo" name="selected_cargo" emptyOption="true"/>
<s:radio key="edit.gen" list="sexo" name="selected_sex" size="30"/>
<s:submit key="edit.submit"/>
</s:form>
<hr>
<h4 align="right"><a href="enter.action"><s:text name="edit.link"/></a></h4>
</body>
</html>
<!--
	 Veja que ao invés do Label, tem o campo key. O campo key, se refere a chave, no arquivo properties,
	 no caso desse arquivo temos, "chave=valor". No caso essa chave, se refere ao arquivo properties
	 
-->