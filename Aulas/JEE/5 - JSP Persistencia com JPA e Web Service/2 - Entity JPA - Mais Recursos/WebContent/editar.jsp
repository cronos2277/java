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
Long num = Long.parseLong(Integer.toString(0));
String Nome = "";
out.println("<html><body>");
if(request.getParameter("editar") == null){
out.println("<h1 align='center'>Edição de Clientes</h1>");
out.println("<a href='index.jsp' method='get'><h3 align='center'>Voltar para página de consulta de clientes.</h3></a><hr>");
out.println("<form method='post'><table align='center'>");
out.println("<tr><td width='190'>ID do Cliente a ser editado:</td><td width='20'><input type='text' name='num' size='3'></td>");
out.println("<td width='200'><input type='submit' name='editar' value='Editar Cliente desse ID!'></td>");
out.println("</tr></table></form><hr>");
}else{
	num = Long.parseLong(request.getParameter("num"));
	out.println("<h1 align='center'>Edição do Cliente ( "+num+" ).</h1>");
	out.println("<a href='index.jsp' method='post'><h3 align='center'>Voltar para página de consulta de clientes.</h3></a><hr>");
	out.println("<form method='post'><table align='center'><tr><td width='200'>Informe o novo nome:</td><td width='200'>Informe o novo login:</td><td width='200'>Informe a nova senha:</td></tr>");
	out.println("<tr><td width='200'><input type='text' name='NEWnome'></td>");
	out.println("<td width='200'><input type='text' name='NEWlogin'></td>");
	out.println("<td width='200'><input type='text' name='NEWsenha'></td>");
	out.println("<td width='200'><input type='hidden' name='NEWid' value="+num+"><input type='submit' name='new' value='Modificar!'></td>");
	out.println("</tr></table></form><hr>");
	out.println("</body></html>");
	
}
//Exibindo Clientes já cadastrados.
EntityManagerFactory factory;
factory = Persistence.createEntityManagerFactory("MySql_Linux");
EntityManager manager = factory.createEntityManager();
Query query = manager.createQuery("select x from MainEntity x");
List<MainEntity> entidade = query.getResultList();
out.println("<table align='center'><tr><td width='200'>Código</td><td width='200'>Nome</td><td width='200'>Login</td><td width='200'>Senha</td></tr><tr>");
for(MainEntity dado: entidade){
	if(request.getParameter("num") != null && num == dado.getPrimaryKey()){
		out.println("<td width='200' bgcolor='lightgray'>"+dado.getPrimaryKey()+"</td>");
		out.println("<td width='200' bgcolor='lightgray'>"+dado.getNome()+"</td>");
		out.println("<td width='200' bgcolor='lightgray'>"+dado.getLogin()+"</td>");
		out.println("<td width='200' bgcolor='lightgray'>"+dado.getSenha()+"</td>");
		out.println("</tr><tr>");}
	else{
		out.println("<td width='200'>"+dado.getPrimaryKey()+"</td>");
		out.println("<td width='200'>"+dado.getNome()+"</td>");
		out.println("<td width='200'>"+dado.getLogin()+"</td>");
		out.println("<td width='200'>"+dado.getSenha()+"</td>");	
		out.println("</tr><tr>");
	}
}
out.println("</tr></table</body></html>");
if(request.getParameter("new") != null){
	
		Long numF = Long.parseLong(request.getParameter("NEWid"));
		MainEntity ObjF = manager.find(MainEntity.class, numF);
		MainEntity Cliente = ObjF;
		Cliente.setNome(request.getParameter("NEWnome"));
		Cliente.setLogin(request.getParameter("NEWlogin"));
		Cliente.setSenha(request.getParameter("NEWsenha"));

		manager.getTransaction().begin();
		manager.persist(Cliente);
		manager.getTransaction().commit();
		manager.close();
		response.sendRedirect("editar.jsp");
	}
	
}catch(Exception e){response.sendRedirect("editar.jsp");}


%>
</body>
</html>