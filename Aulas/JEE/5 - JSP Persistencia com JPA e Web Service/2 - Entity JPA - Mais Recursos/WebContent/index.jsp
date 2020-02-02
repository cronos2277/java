<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 	Importando biblioteca java, todas devidamente comentada. 
 		Informações a respeito do EntityManager, consulta os códigos do JPA1,
 		lá está tudo comentado as funções dessa classe.  
 -->   
    				<!-- Importando as Classes. -->
<%@ page import="javax.persistence.EntityManagerFactory" %> <!-- Essa biblioteca importa o EntityManagerFactory, os objetos criados aqui, criarão as entidades na página JSP. -->   
<%@ page import="javax.persistence.Persistence" %> <!-- Classe usada como parâmetro, na criação do objeto EntityManagerFactory -->   
<%@ page import="javax.persistence.EntityManager"%> <!-- O Objeto criado apartir da Classe EntityManager, fará o gerenciamento dos dados, ele que irá excluir, criar consultar ou editar os dados da entidade.  -->
<%@ page import="javax.persistence.Query" %> <!-- Essa Classe é usada na criação do Objeto, que fará a consulta utilizando o JQSL, vale lembrar que uma entidade é um banco de dado transformado em Objeto, "JQSL != SQL" -->
<%@ page import="java.util.List" %><!-- Aqui é importada a classe para a criação de um objeto do tipo List. o Query.getresultlist(), retorna valores no formato list,e este array de Objetos, criados dessa classe, vai ser preenchido com este método. -->
<%@ page import="pkg.entidade.MainEntity" %> <!-- Essa classe será usada como parâmetro na criação de uma list, e na busca de dados pelo método EntityManager.find() -->
					
					<!-- Início da Página -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo de Persistência Java 2: Lista de Clientes</title>
</head>
<body>
<% //tudo será feito em scriplet, o que deixará a página, um pouco lenta.
//Início de código.
//---------------------------------------------------------------------------------------------------
try{
EntityManagerFactory factory;
factory = Persistence.createEntityManagerFactory("MySql_Linux");
EntityManager manager = factory.createEntityManager();
Query query = manager.createQuery("select x from MainEntity x");
List<MainEntity> entidade = query.getResultList();
out.println("<html><body><h1 align='center'>Lista de Clientes</h1><hr><table align='center'><tr><td width='200'>Código</td><td width='200'>Nome</td><td width='200'>Login</td><td width='200'>Senha</td></tr><tr>");
for(MainEntity dado: entidade){
	out.println("<td width='200'>"+dado.getPrimaryKey()+"</td>");
	out.println("<td width='200'>"+dado.getNome()+"</td>");
	out.println("<td width='200'>"+dado.getLogin()+"</td>");
	out.println("<td width='200'>"+dado.getSenha()+"</td>");
	out.println("</tr><tr>");
}
out.println("</tr></table><hr><table><tr>");
out.println("<td width='200'></td>");
out.println("<td width='200'><a href='novo.jsp' method='post'>Adicionar Cliente</a></td>");
out.println("<td width='200'></td>");
out.println("<td width='200'><a href='editar.jsp' method='post'>Modificar Cliente</a></td>");
out.println("<td width='200'></td>");
out.println("<td width='200'><a href='excluir.jsp' method='post'>Remover Cliente</a></td>");
out.println("</tr></table></body></html>");
}catch(Exception e){out.println("Ocorreu um erro na página. Código: "+e);}
%>
</body>
</html>