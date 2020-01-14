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
<br /><h1 align='center'>Relacionamento OneToOne Bidirecional</h1>
<% if(request.getParameter("del") != null){request.getSession().setAttribute("this_id", request.getParameter("id"));response.sendRedirect("del");} %>
<% if(request.getParameter("editar") != null){request.getSession().setAttribute("this_id", request.getParameter("id"));request.getSession().setAttribute("this_nome", request.getParameter("this_nome"));request.getSession().setAttribute("this_user", request.getParameter("this_user"));request.getSession().setAttribute("this_senha", request.getParameter("this_senha"));response.sendRedirect("edt");}%>
<%
List<Cliente> clientes = new ClienteDao().GetAll();
out.println("<table border='1px' align='center'><tr><td width='200'>ID</td><td width='200'>Nome</td><td width='200'>Data</td><td width='200'>Usuário</td><td width='200'>Senha</td><td width='200'>Operações</td></tr></table>");
for(Cliente cliente: clientes){
	out.println("<form method='get'><table border='1px' align='center'><tr><td width='200'>"+cliente.getId()+"<input type='hidden' name='id' value='"+cliente.getId()+"'></td>");
	out.println("<td width='200'><input type='text' name='this_nome' value='"+cliente.getNome()+"'></td><td width='200'><input type='text' name='this_data' value='"+cliente.getCadastro()+"'></td>");
	out.println("<td width='200'><input type='text' name='this_user' value='"+cliente.getLogin().getUser()+"'></td><td width='200'><input type='text' name='this_senha' value='"+cliente.getLogin().getPass()+"'></td>");
	out.println("<td><input type='submit' name='editar' value='Editar!'></td><td><input type='submit' name='del' value='Excluir!'></td></tr></table></form>");
}
%>
<form action="new" method="post">
<table align="center" border='1px'>
<tr>
<td>Novo Nome: <input type="text" name="nome"></td>
<td>Novo Login: <input type="text" name="login"></td>
<td>Nova Senha: <input type="text" name="senha"></td>
<td><input type="reset" name="limpar" value="Limpar!">
<input type="submit" name="nome" value="cadastrar"></td>
</tr>
</table>
</form>


</body>
</html>