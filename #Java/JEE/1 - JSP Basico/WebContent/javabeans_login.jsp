<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaBeans</title>
</head>
<body>
<jsp:useBean id="cliente" class="br.com.treinaweb.javaee.JavaBeans1"></jsp:useBean>
<jsp:setProperty property="*" name="cliente"/>
<form method="POST">
<table>
<tr>
<td>Nome: </td><td><input type="text" name="nome"></td>
<td>login: </td><td><input type="text" name="login"></td>
<td>senha: </td><td><input type="text" name="senha"></td>
<td><input type="submit" name="enviar"></td>
</tr>
</table>
</form>
<hr>
<br />
<table>
<tr><td></td>
<td>Nome: </td><td><jsp:getProperty property="nome" name="cliente"/></td><td></td>
<td>login: </td><td><jsp:getProperty property="login" name="cliente"/></td><td></td>
<td>Senha: </td><td><jsp:getProperty property="senha" name="cliente"/></td><td></td>
</tr>
</table>
<hr>
</body>
</html>