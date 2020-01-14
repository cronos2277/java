<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.persistence.EntityManagerFactory, javax.persistence.EntityManager, javax.persistence.Persistence, javax.persistence.Query, java.util.List, pkg.entidade.MainEntity" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo de Persistência Java 2: Excluíndo Clientes</title>
</head>
<body>
<%
try{
out.println("<html><body>");
out.println("<h1 align='center'>Exclusão de Clientes</h1>");
out.println("<a href='index.jsp' method='post'><h3 align='center'>Voltar para página de consulta de clientes.</h3></a><hr>");
out.println("<form method='post'><table align='center'>");
out.println("<tr><td width='190'>ID do Cliente a ser excluído:</td><td width='20'><input type='text' name='num' size='3'></td>");
out.println("<td width='200'><input type='submit' name='excluir' value='Excluir Cliente pelo ID!'></td>");
out.println("</tr></table></form><hr>");

//Exibindo Clientes já cadastrados.
EntityManagerFactory factory;
factory = Persistence.createEntityManagerFactory("MySql_Linux");
EntityManager manager = factory.createEntityManager();
Query query = manager.createQuery("select x from MainEntity x");
List<MainEntity> entidade = query.getResultList();
out.println("<table align='center'><tr><td width='200'>Código</td><td width='200'>Nome</td><td width='200'>Login</td><td width='200'>Senha</td></tr><tr>");
for(MainEntity dado: entidade){
	out.println("<td width='200'>"+dado.getPrimaryKey()+"</td>");
	out.println("<td width='200'>"+dado.getNome()+"</td>");
	out.println("<td width='200'>"+dado.getLogin()+"</td>");
	out.println("<td width='200'>"+dado.getSenha()+"</td>");
	out.println("</tr><tr>");
}
out.println("</tr></table</body></html>");
if(request.getParameter("excluir") != null){
	Long num = Long.parseLong(request.getParameter("num"));
	MainEntity find = manager.find(MainEntity.class, num);
	MainEntity Cliente = find;
	manager.getTransaction().begin();
	manager.remove(Cliente);
	manager.getTransaction().commit();
	manager.close();
	response.sendRedirect("excluir.jsp");
}
}catch(Exception e){response.sendRedirect("excluir.jsp");}
%>
</body>
</html>