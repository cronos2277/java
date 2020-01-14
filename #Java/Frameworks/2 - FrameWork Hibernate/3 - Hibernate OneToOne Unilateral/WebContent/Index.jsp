<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "pkg.entity.*"%>
<%@ page import="pkg.dao.*" %>
<%@ page import= "java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mapeamento OneToOne Unidirecional</title>
</head>
<body bgcolor='lightgray'>
<br /><h1 align='center'>Relacionamento OneToOne Unidirecional</h1>
<% if(request.getParameter("del") != null){request.getSession().setAttribute("this_id", request.getParameter("id"));response.sendRedirect("del");} %>
<% if(request.getParameter("editar") != null){request.getSession().setAttribute("this_id", request.getParameter("id"));request.getSession().setAttribute("this_nome", request.getParameter("this_nome"));request.getSession().setAttribute("this_salario", request.getParameter("this_salario"));response.sendRedirect("edt");}%>
<%
List<Pessoas> pessoas = new Gerente().GetAll();
out.println("<table border='1px' align='center'><tr><td width='200'>ID</td><td width='200'>Nome</td><td width='200'>Salario</td></tr></tr>");
for(Pessoas pessoa: pessoas){
	out.println("<form method='get'><table border='1px' align='center'><tr><td width='200'>"+pessoa.getIdpessoa()+"<input type='hidden' name='id' value='"+pessoa.getIdpessoa()+"'></td>");
	out.println("<td width='200'><input type='text' name='this_nome' value='"+pessoa.getNome()+"'></td><td width='200'><input type='text' name='this_salario' value='"+pessoa.getSalario().getSalario()+"'></td>");
	out.println("<td><input type='submit' name='editar' value='Editar!'><td><input type='submit' name='del' value='Excluir!'></tr>");
	out.println("</table></form>");
}
%>
<form action="new" method="post">
<table align="center" border='1px'>
<tr>
<td>Novo Nome: <input type="text" name="nome"></td>
<td>Novo Salario: <input type="text" name="salario"></td>
<td><input type="reset" name="limpar" value="Limpar!">
<input type="submit" name="nome" value="cadastrar"></td>
</tr>
</table>
</form>


</body>
</html>