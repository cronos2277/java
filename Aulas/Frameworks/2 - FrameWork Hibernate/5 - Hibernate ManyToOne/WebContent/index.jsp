<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="pkg.controle.*, java.util.List, pkg.entidade.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relacionamento ManyToOne</title>
</head>
<body bgcolor='lightgray'>
<h1 align='center'>Relacionamento ManyToOne</h1><hr><br />
<% 
try{List<Pessoa> pessoas = new Gerente().GetAll(); 
for(Pessoa pessoa: pessoas){
out.println("<form action='servlet' method='post'><table border='1px' align='center'><tr>");
out.println("<td width='150'><input type='text' name='id' value='"+pessoa.getCodigo()+"'></td>");
out.println("<td width='150'><input type='text' name='nome' value='"+pessoa.getNome()+"'></td>");
out.println("<td width='150'><input type='text' name='cargo' value='"+pessoa.getCargoInstanciado().getCargo()+"'></td>");
out.println("<td width='50'><input type='submit' name='edit' value='Editar!'></td>");
out.println("<td width='50'><input type='submit' name='del' value='Excluir!'></td>");
out.println("</tr></table></form>");
}}catch(Exception e){out.println("JSP Error: "+e.toString());}
%>
<form action="servlet" method="post">
<table border="1px" align="center">
<tr><td>Novo Nome: <input type="text" name="nome"></td>
<td><input type="submit" name="novo" value=Cadastar!></td>
</tr>
</table>
</form>
</body>
</html>