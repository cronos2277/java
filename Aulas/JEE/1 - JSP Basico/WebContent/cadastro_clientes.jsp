<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
</head>
<body bgcolor="lightgray">
<br /><br /><br /><br /><br /><br />
<h3 align="center">Cadastro de clientes: Projeto Java Enterprise Edition</h3>
<hr>
<form action="c_c1" method="post">
<table bgcolor="lightgray" align="center">
<tr bgcolor="lightblue">
<td>Nome: </td>
<td><input type="text" name="nome"></td>
</tr>
<tr bgcolor="lightyellow">
<td>Login: </td>
<td><input type="text" name="login"></td>
</tr>
<tr bgcolor = "lightgreen">
<td>Senha: </td>
<td><input type="password" name="senha"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="enviar"></td>
</tr>
</table>
</form>
<hr>
<center><%= new java.util.Date() %></center>
</body>
</html>