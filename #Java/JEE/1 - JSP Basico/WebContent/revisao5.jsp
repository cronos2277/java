<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3 align="center">Página de Login.</h3><hr>
<form action="login_mysql.jsp" method="post">
<table bgcolor="white" align="center">
<tr bgcolor="lightblue">
<td>Usuário: </td>
<td><input type="text" name="user"></td>
</tr>
<tr bgcolor="lightyellow">
<td>Senha: </td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="comando"></td>
</tr>
</table>
</form>
<hr>
<h3 align="center"><%= new java.util.Date() %></h3>
</body>
</html>