<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente cadastrado.</title>
</head>
<body>
<h4 align="right"><i>O seguinte cliente foi cadastrado.</i></h4><hr>
<table>
<tr><td>Nome: </td><td><s:property value="nome"/></td></tr> <!-- Essa tag imprime o valor do método .getNome() -->
<tr><td>Função: </td><td><s:property value="funcao"/></td></tr>
<tr><td>Salário: </td><td><s:property value="salario"/></td></tr>
<tr><td>Data: </td><td><s:property value="cadastrado"/></td></tr>
</table>
<br /> <hr>
<h4 align="right"> <a href="index.action">Voltar a página de cadastro</a></h4> <!-- Para ir para um link, é chamado uma action, no arquivo struts.xml -->
</body>
</html>