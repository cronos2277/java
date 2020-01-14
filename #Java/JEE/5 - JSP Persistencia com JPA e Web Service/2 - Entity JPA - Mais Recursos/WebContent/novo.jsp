<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.persistence.EntityManagerFactory, javax.persistence.EntityManager, javax.persistence.Persistence, javax.persistence.Query, java.util.List, pkg.entidade.MainEntity" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo de Persistência Java 2: Adicionando Cliente</title>
</head>
<body>
<%
try{
out.println("<html><body>");
out.println("<h1 align='center'>Cadastro de Clientes</h1>");
out.println("<a href='index.jsp' method='post'><h3 align='center'>Voltar para página de consulta de clientes.</h3></a><hr>");
out.println("<form method='post'><table align='center'><tr><td width='200'>Informe o nome:</td><td width='200'>Informe o login:</td><td width='200'>Informe a senha:</td></tr>");
out.println("<tr><td width='200'><input type='text' name='nome'></td>");
out.println("<td width='200'><input type='text' name='login'></td>");
out.println("<td width='200'><input type='text' name='senha'></td>");
out.println("<td width='200'><input type='submit' name='novo' value='Cadastrar!'></td>");
out.println("</tr></table></form><br /><hr>");


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
if(request.getParameter("novo") != null){
	MainEntity cliente = new MainEntity();
	cliente.setNome(request.getParameter("nome"));
	cliente.setLogin(request.getParameter("login"));
	cliente.setSenha(request.getParameter("senha"));
	manager.getTransaction().begin();
	manager.persist(cliente);
	manager.getTransaction().commit();
	manager.close();
	response.sendRedirect("novo.jsp");
}
}catch(Exception e){response.sendRedirect("novo.jsp");}
%>
</body>
</html>