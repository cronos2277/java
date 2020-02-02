<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hibernate.*, pkg.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="logged.page"/></title>
</head>
<body>
<% Entidade entidade = new Gerente().Localizar(Gerente.id); %>
<h4 align="right"><s:text name="logged.logged"/></h4><hr>
<h2 align="center"><s:text name="logged.yours"/></h2><br />
<form method="post" action="editar.action">
<table align="center">
<tr><td><s:text name="logged.name"/></td><td><%= entidade.getNome() %></td></tr>
<tr><td><s:text name="logged.user"/></td><td><%= entidade.getLogin() %></td></tr>
<tr><td><s:text name="logged.pass"/></td><td><%= entidade.getSenha() %></td></tr>
<tr><td><s:text name="logged.sex"/></td><td><%= entidade.getGenero() %></td></tr>
<tr><td><s:text name="logged.func"/></td><td><%= entidade.getCargo() %></td></tr>
<tr><td><input type="submit" name="mdf" value=<s:text name="logged.edit"/>></td></tr>
</table>
</form>
<form action="delete.action" method="post"><br />
<hr>
<table align="right">
<tr><td><input type="submit" name="del" value=<s:text name="logged.del"/>></td></tr>
</table>
</form>
</body>
</html>