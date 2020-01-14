<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de clientes no MySql.</title>
</head>
<body>
<h3 align="right">Cadastros de clientes</h3>
<hr>
<form action="cadastro_mysql.jsp" method="post">
<table>
<tr bgcolor="lightblue">
<td>Nome: </td>
<td><input type="text" name="nome"></td>
</tr>
<tr bgcolor="lightyellow">
<td>Login: </td>
<td><input type="text" name="login"></td>
</tr>
<tr bgcolor="lightgreen">
<td>Senha: </td>
<td><input type="password" name="senha"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="registrar"></td>
</tr>
</table>
</form>
<br />
<hr>
<h3 align="center"> <%= new java.util.Date() %> </h3>
</body>
</html>