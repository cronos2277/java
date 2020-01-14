<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% for(int i=0;i<=6;i++){out.println("<br />");} %>
<form method="post" action="http://localhost:8080/Treinaweb/usr/Produce">
<table align="center" border='2px'>
<tr><td>Cadastro de Clientes</td></tr>
<tr><td> Nome: </td><td><input type="text" name="nome"></td></tr>
<tr><td>Login: </td><td><input type="text" name="login"></td></tr>
<tr><td>Senha: </td><td><input type="text" name="senha"></td></tr>
<tr><td><input type="submit" name="enviar" value="Enviar!"></td></tr>
</table>
</form>
</body>
</html>