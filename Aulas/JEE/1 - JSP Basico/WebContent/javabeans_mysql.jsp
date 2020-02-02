<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando no MySql com o JavaBeans</title>
</head>
<body>
<jsp:useBean id="user" scope="request" class="br.com.treinaweb.javaee.JavaBeans1"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<form action="" method="post">
<table>
<tr>
<td align="right">Nome: </td><td><input type="text" name="nome"></td>
<td align="right">Login: </td><td><input type="text" name="login"></td>
<td align="right">Senha: </td><td><input type="text" name="senha"></td>
<td></td><td><input type="submit" name="enviar" value="incluir"></td>
</tr>
</table>
</form>
<hr>
<br />
<%
if(request.getParameter("enviar") != null){
	user.Registro();
}
%>
<table><tr><td>Status: </td><td><jsp:getProperty property="status" name="user"/></tr></table>
</body>
</html>