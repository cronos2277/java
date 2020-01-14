<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBeans</title>
</head>
<body bgcolor="lightgray">
<jsp:useBean id="user" class = "br.treinaweb.javaee.Javabeans_PT" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<c:if test="${user.enviar == null}">
<hr>
<h2 align="center"> Formulário para cadastro.</h2>
<form>
<table align="center">
<tr>
<td>Nome: </td><td><input type="text" name="nome"></td>
</tr>
<tr>
<td>Login: </td><td> <input type="text" name="login"></td>
</tr>
<tr>
<td>Senha: </td><td><input type="text" name="senha"></td></tr>
<tr><td><input type="submit" name="enviar" value="enviar"></td></tr>
</table>
</form>
</c:if>

<c:if test="${user.enviar != null}">
<hr>
<h2 align = "center">Os dados abaixo estão corretos?</h2>
<form action="servlet" method="post">
<table align="center">
<tr>
<td>Nome: </td><td><input type="text" name="nome" value ="${user.nome}"></td>
</tr>
<tr>
<td>Login: </td><td> <input type="text" name="login" value="${user.login}"></td>
</tr>
<tr>
<td>Senha: </td><td><input type="text" name="senha" value="${user.senha}"></td></tr>
<tr><td><input type="submit" name="confirmar" value="confirmar"></td></tr>
</table>
</form>
</c:if>

</body>
</html>