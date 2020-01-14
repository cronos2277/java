<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Server Page Revisão 1</title>
</head>
<body>
<h3>Cadastros de Clientes</h3>
<form action="rev1" method="post">
<table border="1px">
<tr>
<td>Dígite o nome do cliente: </td>
<td> <input type="text" name="nome"> </td></tr>
<tr>
<td>Dígite a idade do cliente: </td>
<td> <input type="text" name="idade"></td></tr>
<tr>
<td>Dígite a cidade do cliente: </td>
<td><input type="text" name="cidade"> </td></tr>
<tr>
<td>Clique em Enviar: </td> 
<td><input type="submit" value="Enviar!">
<input type="reset" value="Limpar!"></td></tr>
</table></form><center>
<a href='http://localhost:8080/TreinaWeb/ref11'>Consultar dados gravados no Servlet</a></center> 
</body>
</html>