<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastros de clientes.</title>
</head>
<body>
<%@ page import="java.util.*" %>
<h2 align="left">Cadastro de clientes</h2>
<hr>
<form action="resposta_rev3.jsp" method="post">
<table>
<tr bgcolor="lightblue">
<td align="left">Nome: </td>
<td align="left"><input type="text" name="nome"></td>
</tr>
<tr bgcolor="lightgreen">
<td align="left">Login:</td>
<td><input type="text" name="login"></td>
</tr>
<tr bgcolor="pink">
<td align="left">Senha:</td>
<td><input type="password" name="senha"></td>
</tr>
<tr bgcolor="white">
<td align="left"><input type="submit" name="enviar"></td>
<td align="right"><input type="reset" name="default" value="Limpar Formulário!"></td>
</tr>
</table>
<hr>
<h2 align="left"><%= new java.util.Date() %></h2>
</form>
</body>
</html>