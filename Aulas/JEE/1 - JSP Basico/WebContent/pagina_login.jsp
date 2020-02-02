<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de Login</title>
</head>
<body bgcolor="lightgray">
<br /><br /><br /><br /><br /><br /><br /><br /><br />
<h3 align="center">Página de login: Projeto Java Enterprise Edition</h3>
<hr>
<form action="p_l" method="post">
<table align="center" bgcolor="lightgray">
<tr bgcolor="lightblue">
<td>Login: </td>
<td><input type="text" name="login"></td>
</tr>
<tr bgcolor="lightyellow">
<td>Senha: </td>
<td><input type="password" name="senha"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="enviar" value="Entrar no site!"></td>
</tr>
</table>
</form>
<hr>
<center><%= new java.util.Date() %></center>
</body>
</html>