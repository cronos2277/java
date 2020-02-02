<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pkg.all.*" %>
<%@ page import= "java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mapeamento OneToOne Unidirecional</title>
</head>
<body bgcolor='lightgray'>
<br /><h1 align='center'>Exemplo do uso do Hibernate</h1>
<%
List<Classe> TodosOsDadosPersistidos = new MetodosDao().GetAll();
out.println("<table border='1px' align='center'><tr><td width='200'>ID</td><td width='200'>Texto</td></tr></table>");
for(Classe EstaPersistenciaEspecifica: TodosOsDadosPersistidos){
	out.println("<form method='post' action='servlet'><table border='1px' align='center'><tr><td width='200'>"+EstaPersistenciaEspecifica.getId()+"<input type='hidden' name='id' value='"+EstaPersistenciaEspecifica.getId()+"'></td>");
	out.println("<td width='200'><input type='text' name='texto' value='"+EstaPersistenciaEspecifica.getTexto()+"'></td>");
	out.println("<td><input type='submit' name='edit' value='Editar!'></td><td><input type='submit' name='del' value='Excluir!'></td></tr></table></form>");
}
%>
<form action="servlet" method="post">
<table align="center" border='1px'>
<tr>
<td>Novo Texo: <input type="text" name="texto"></td>
<td><input type="reset" name="limpar" value="Limpar!">
<input type="submit" name="novo" value="cadastrar"></td>
</tr>
</table>
</form>
</body>
</html>