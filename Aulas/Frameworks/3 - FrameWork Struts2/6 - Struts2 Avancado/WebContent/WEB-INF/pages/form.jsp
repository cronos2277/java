<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="form.page"/></title>
</head>
<body>
<s:form action="persist.action" method="post">
<s:textfield key="form.name" name="nome" required="true" size="30"/>
<s:textfield key="form.user" name="login" required="true" size="30"/>
<s:password key="form.pass" name="senha" required="true" size="30"/>
<s:select key="form.func" list="cargo" name="selected_cargo" required="true" emptyOption="true"/>
<s:radio key="form.gene" list="sexo" name="selected_sex" required="true" size="30"/>
<!-- 
	Repare que botão submit, também tem um campo key, cujo o valor exibido nesse botão, é o valor
da chave.
-->
<s:submit key="form.new"/>

</s:form>
<hr>
<h4 align="right"><a href="main.action">Clique aqui para voltar para a página inicial.</a></h4>
</body>
</html>