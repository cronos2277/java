<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.*, org.hibernate.cfg.*, org.hibernate.service.*" %> 
<%@ page import="java.util.List"%>  
<%@ page import="hibernate.Pessoas" %>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hibernate Cadastro.</title>
</head>
<body>
<%! String status; %>
<%
out.println("<body bgcolor='lightgray'><h4 align='center'>Projeto Hibernate</h4>");	
out.println("<form method='post'><table align='center'><tr>");
out.println("<td><input type='submit' name='novo' value='Adicionar Pessoa!'></td>");
out.println("<td><input type='submit' name='editar' value='Modificar Pessoa!'></td>");
out.println("<td><input type='submit' name='excluir' value='remover Pessoa!'></td>");
out.println("</tr></table></form>");
out.println("<hr>");

try{//Abaixo os códigos referentes ao Hibernate.
//--------------------------------------------------------------------	
Configuration cfg = new Configuration();	
cfg.configure("hibernate.cfg.xml");
ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
SessionFactory factory = cfg.buildSessionFactory(service);
Session sessao = factory.openSession();
sessao.beginTransaction();
List lista = sessao.createQuery("from Pessoas").list();
sessao.getTransaction().commit();
/* Primeira explicação sobre o FrameWork Hibernate. Lembrando que essa configuração é diferente, quando o mesmo é usado por anotações, ao invés do xml.
* Objeto do tipo Configuration. Esse objeto vai carregar as definições, do arquivo de configuração do hibernate, aqui no caso o hibernate.cfg.xml,recomenda-se o uso desse nome para o xml.
*					xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
* Objeto do tipo ServiceRegistry. No caso nele, foi carregado um valor padrão para a construção de um serviço de registro, foi pego o valor padrão dele e aplicado com as propriedades do objeto Configuration,
* nesse ponto, foi setadas as configurações do hibernate.cfg.xml, foi pegas as suas propriedades e construídas um construtor com ele. Por isso que é bom criar um construtor na entidade, pois ele será requerido nesse processo.
*					xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*Objeto do tipo SessionFactory. Esse objeto pega o um objeto do tipo configure e cria uma sessão usando um objeto ServiceRegistry como parâmetro do método buildSessionFactory. O objeto SessionFactory ele é usado como atributo,
*para a criação de uma Session. Você pode criar várias sessões, usando uma mesma SessionFactory, isso se torna algo interessante, quando você tem mais de uma entidade e elas são destintas entre si. Pois te permite escrever em mais de uma ao mesmo tempo.
*					xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
*Objeto do tipo Session. ela lida com sessões, usa um objeto do tipo SessionFactory para abrir uma sessão, uma vez aberta uma sessão, este objeto de permite salvar, apagar, editar e localizar e carregar dados em uma List.Cada sessão se conecta a uma entidade.
*getTrasaction() te permite comitar, que nada mais é que uma expressão para salvar dados no SGBD, tudo que é feito nesse método, é feito no banco de dados. Como comitar abrir transação e fechar transação, o Session com esse método tem funcionamento idêntico ao Objeto do tipo Transaction. 
*					xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
* Objeto do tipo List.Esse objeto pega valores da Session, a session tem um funcionamento semelhante de um Objeto Statement no JDBC. O List ali, funcionaria como uma espécie de um Objeto ResultSet. só o "from pessoas" carrega todos os valores indexados do banco de dados que está setado na entidade. 
* "from Pessoas", equivale ao select * from Pessoas. A sintaxe é um pouco diferente para evitar uma SQL injection e para criar uma padronização entre os bancos de dados compatíveis com o hibernate, mas muito difente em sintaxe ao bancos de dados como MySql, PostGree, SQL Server, Oracle, etc...   
*/
//---------------------------------------------------------------------
status = "Nenhum";	
if(request.getParameter("novo") != null){//Cadastro de Pessoas.
out.println("<form method='post'><table border='1px'><tr>");
out.println("<td width = '90'>Novo nome: </td><td width = '150'><input type='text' name='nome'></td>");
out.println("<td width = '90'>Novo Login:</td><td width = '150'><input type='text' name='login'></td>");
out.println("<td width = '90'>Nova Senha:</td><td width = '150'><input type='text' name='senha'></td>");
out.println("<td width = '50'><input type='reset' name='limpar' value='Limpar!'></td><td width='80'><input type='submit' name='cadastrar' value='Cadastrar!'</td>");
out.println("</tr></table></form>");
}

if(request.getParameter("excluir") != null){//Exclusão de Pessoas.
out.println("<form method='post'><table align='center' border='1px'>");
out.println("<tr><td width = '200'>Informe o ID a ser excluído: </td><td width = '200'><input type='text' name='id'></td>");
out.println("<td width = '90'><input type='submit' name='deletar' value='Excluir!'></td></tr>");
out.println("</table></form>");
}

if(request.getParameter("editar") != null){
	out.println("<form method='post'><table align='center' border='1px'>");	
	out.println("<tr><td width = '200'>Informe o ID a ser modificado: </td><td width = '200'><input type='text' name='idEditar'></td>");
	out.println("<td width = '90'><input type='submit' name='edicao' value='Editar'></td></tr>");
	out.println("</table></form>");
}
out.println("<hr><table>");
out.println("<tr><td>ID</td><td>Nome</td><td>Login</td><td>Senha</td><td>Registrado</td></tr><tr>");
for(int i=0;i<lista.size();i++){
	Pessoas pessoa = (Pessoas) lista.get(i);
	out.println("<td width='200'>"+pessoa.getId()+"</td>");	
	out.println("<td width='200'>"+pessoa.getNome()+"</td>");
	out.println("<td width='200'>"+pessoa.getLogin()+"</td>");
	out.println("<td width='200'>"+pessoa.getSenha()+"</td>");
	out.println("<td width='300'>"+pessoa.getRegistrado()+"</td>");
	out.println("</tr><tr>");
}
out.println("</tr></table>");
if(request.getParameter("cadastrar") != null){
	Session Sessao = factory.openSession(); //Aqui é criada um sessão própria para manipular estes dados.
	Transaction transacao = Sessao.beginTransaction(); //O transaction pega valor de um método do Objeto Sessao, esse objeto irá escrever no banco de dados.
	Pessoas pessoa = new Pessoas();
	pessoa.setId(lista.size() + 1);
	pessoa.setNome(request.getParameter("nome"));
	pessoa.setLogin(request.getParameter("login"));
	pessoa.setSenha(request.getParameter("senha"));
	pessoa.setRegistrado(String.valueOf(new java.util.Date()));
	Sessao.save(pessoa); //aqui o Objeto pessoa é salvo na entidade.
	transacao.commit(); //Aqui é escrito no banco de dados.
	Sessao.close(); //Fechar sessão.
	/*
	* Válido resaltar que o Objeto Session lida com dados de entidades,
	* o Objeto Transaction com os dados dos bancos de dados. Primeiro se salva
	* os dados na entidade, depois escreve a entidade no banco de dados. Isso 
	* dá mais segurança e pode permitir a reedição dos dados, ou o seu cancelamento
	* antes de escrever no banco de dados.
	*/
	response.sendRedirect("index.jsp");
}
if(request.getParameter("deletar") != null){
	int id = Integer.parseInt(request.getParameter("id"));
	Session Sessao = factory.openSession();
	Transaction transacao = Sessao.beginTransaction();
	/* Abaixo temos uma lista, criada pela clausula where. A mesma usa o id, 
	* Essa lista obterá apenas um valor para cada campo. Ou seja nessa lista
	* existirá apenas um índice, contendo o código, nome, login, senha, data
	* Esse dado escrito na lista apagar é passado pelo método get, devidamente 
	* casteado para o Objeto pessoa, o índice zero, corresponde a o único índice 
	* da lista, pois como sabemos os índices de um array começa no zero, e como
	* só tem um índice...
	* O Casteamento só é recomendado o seu uso, quando o problema com o dado é
	* apenas a formatação, pois tudo que o casteamento faz é modelar ele, para 
	* o tipo do seu destino. Por exemplo, "double A = (double) integer B".
	* No caso acima, um integer pode ser escrito em um atributo do tipo double,
	* mas o seu problema é o seu formato, no caso o casteamento, coloca os zeros extra
	* e a vírgula, ou seja ele é rescrito em forma decimal.
	*/
	List apagar = Sessao.createQuery("from Pessoas where id = "+id).list();
	Pessoas pessoa = (Pessoas) apagar.get(0);
	Sessao.delete(pessoa);
	transacao.commit();
	Sessao.close();
	response.sendRedirect("index.jsp");
}
if(request.getParameter("edicao") != null){
	out.println("<form method='post'><table border='1px'><tr>");
	out.println("<td width = '90'>Novo nome: </td><td width = '150'><input type='text' name='nome'></td>");
	out.println("<td width = '90'>Novo Login:</td><td width = '150'><input type='text' name='login'></td>");
	out.println("<td width = '90'>Nova Senha:</td><td width = '150'><input type='text' name='senha'></td>");
	out.println("<td width = '50'><input type='reset' name='limpar' value='Limpar!'></td><td><input type='hidden' name='ide' value='"+request.getParameter("idEditar")+"'</td>");
	out.println("<td width='80'><input type='submit' name='redit' value='Concluir!'</td></tr></table></form>");	

}
if(request.getParameter("redit") != null){
	int id = Integer.parseInt(request.getParameter("ide"));
	Session Sessao = factory.openSession();
	Transaction transacao = Sessao.beginTransaction(); //Poderia ser usado tambem o Sessao.beginTransaction(), no lugar desse objeto.
	List apagar = Sessao.createQuery("from Pessoas where id = "+id).list();
	Pessoas pessoa = (Pessoas) apagar.get(0);
	pessoa.setNome(request.getParameter("nome"));
	pessoa.setLogin(request.getParameter("login"));
	pessoa.setSenha(request.getParameter("senha"));
	pessoa.setRegistrado(String.valueOf(new java.util.Date()));
	Sessao.save(pessoa);
	transacao.commit(); //corresponde ao Sessao.getTransaction().commit()
	Sessao.close();
	response.sendRedirect("index.jsp");
}


}catch(Exception e){status = e.toString();}
out.println("<hr><h4 align='right'>Erro: "+status+"</h4 <br />");
out.println("</body>");
%>
</body>
</html>