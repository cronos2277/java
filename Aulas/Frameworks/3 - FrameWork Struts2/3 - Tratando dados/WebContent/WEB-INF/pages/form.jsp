<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de novo cliente.</title>
</head>
<body>
<h4 align="right"><i>Cadastro de novo cliente</i></h4><hr>
<s:form action="print.action" method="post"> <!-- Um sform ele tem que ter uma action, para aonde vai ser envado os dados, e o method que é como vai ser enviado. -->
<s:textfield label="Nome " name="nome"/><!-- textfield é um campo para entrada de dados, o textfield é semelhante ao textfield do swing. -->
<s:textfield label="Função " name="funcao"/>
<s:textfield label="Salário " name="salario"/>
<s:submit/> <!-- submit é um botão para envio de dados -->
</s:form>
</body>
</html>