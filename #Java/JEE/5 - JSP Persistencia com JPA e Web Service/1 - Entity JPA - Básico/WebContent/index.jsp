<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pkg.persistence.Cliente,javax.persistence.Persistence,javax.persistence.EntityManager,javax.persistence.Query,javax.persistence.EntityManagerFactory,java.util.List" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persistencia Java Web.</title>
</head>
<body>
<%
	EntityManagerFactory factory;
factory = Persistence.createEntityManagerFactory("Cliente"); //Aqui é efetivamente criado a entidade, ou melhor fabricada. Aqui é usada a Classe Persistence.createEntityManagerfactory("Aqui no campo de string o valor definido <persistence-unit> campo nome,no arquivo persistence.xml");  
EntityManager manager = factory.createEntityManager(); //Aqui é criado o EntityManager. O mesmo serve para gerenciar ação no banco de dados. Esse Objeto e os seus métodos, iram manipular o seu banco de dados.
Query query = manager.createQuery("select x from Cliente x"); //Aqui é criado uma query, ou seja o comando JQSL, que é bem diferente a o sql puro, pois aqui o banco de dados foi convertido em Objeto. No caso o retorna todos os valores da entidade.
//A query acima, uma coisa você deve saber, ali é "select x from ENTIDADE x", e não da tabela sql, se acontecer da entidade tiver nome diferente da tabela, vale o nome da entidade. O x é um parametro que pode ser configurado, usando as regras do JQSL.
//em relação ao x temos ele como parametro, ali ele tem o valor de um caracter coringa, mais poderia ser "select x from Cliente x:nome ", no exemplo ele retornaria apenas o conteúdo da coluna nome, pois x vale nome.
//Com relação a Linux a coisa é muita mais chata, pois a filesystem do linux é sensetive case, recomenda-se nome de tabelas em letras de caixa alta.
List<Cliente> lista = query.getResultList(); //Lembram do ArrayList? Pois bem aqui a query JQSL, vai carregar esse array de objetos com os seus valores. O mesmo usa o nome da Classe como parâmetro, pois a classe não instanciada é o tipo de objeto que vai conter nessa list, e a função query, vai retornar valores até carregar esse objeto com todos os dados do SGBD.
out.println("<h1 align='center'>Dados de Clientes</h1><hr><br />"); //Não é segredo que o out faz impressão na página, Entretanto essa impressão será aos moldes do HTML. Acompanhe o código e confira.
out.println("<table border='1px' align='center'><tr><td width='200' align='middle'>ID</td><td width='200' align='middle'>Nome</td><td width='200' align='middle'>Login</td><td width='200' align='middle'>Senha</td></tr>");
for(Cliente cliente: lista){ //esse é um for each, ele só para quando não tiver clientes, ele varre a lista do tipo Cliente em busca de valores.
//repare que abaixo é feito o uso do método get, dos atributos da classe Cliente.
out.println("<tr><td width='200' align='middle'>"+cliente.getId()+"</td>");	
out.println("<td width='200' align='middle'>"+cliente.getNome()+"</td>");
out.println("<td width='200' align='middle'>"+cliente.getLogin()+"</td>");
out.println("<td width='200' align='middle'>"+cliente.getSenha()+"</td>");
out.println("</tr>");
}
out.println("</table>");
out.println("<br /><hr><h3 align='center'>Adicionando Clientes:</h3>");
out.println("<table border='1px' align='center'><tr><td width='180' align='middle'>Informe o Nome: </td><td width='180' align='middle'>Informe o Login: </td><td width='180' align='middle'>Informe a Senha: </td></tr></table>");
out.println("<form method='post'><table border='1px' align='center'><tr><td width='150' align='middle'><input type='text' name='nome'></td><td width='150' align='middle'><input type='text' name='login'></td><td width='150' align='middle'><input type='text' name='senha'></td><td><input type='submit' name='registrar' value='Resgistrar!'</td></tr></table></form>");

out.println("<hr><h3 align='center'>Removendo Clientes:</h3>");
out.println("<form method='post'><table border='1px' align='center'><tr><td width='180' align='middle'>Informe o ID do cliente: </td><td width='150' align='middle'><input type='text' name='id'></td><td><input type='submit' name='apagar' value='Apagar!'</td</tr></table></form>");

out.println("<hr><h3 align='center'>Editando Clientes:</h3>");
out.println("<table border='1px' align='center'><tr><td width='180' align='middle'>ID do cliente a ser editado:</td><td width='180' align='middle'>Novo nome: </td><td width='180' align='middle'>Novo login: </td><td width='180' align='middle'>nova senha: </td></tr></table>");
out.println("<form method='post'><table border='1px' align='center'><tr><td width='150' align='middle'><input type='text' name='id_editar'></td><td><input type='text' name='nome_editar'></td><td><input type='text' name='login_editar'></td><td><input type='text' name='senha_editar'></td><td><input type='submit' name='editar' value='Editar!'</td</tr></table></form>");

//Registrando novo usuário.
if(request.getParameter("registrar") != null){
	Cliente novo = new Cliente(); // criando Objeto do tipo cliente.
	
	//Esse rolo abaixo, pega o tamanho da lista que é um inteiro, soma mais um,
	//e transforma em String e depois em um formato long. Qual é a lógica?
	//Bom se tem 15 clientes e fosse para registrar mais um o próximo seria o 16
	//logo o valor do Id do tipo long a ser criado seria 16.
	Long ID_new = Long.parseLong(Integer.toString(lista.size() + 1));
	
	novo.setId(ID_new);//aqui é usado o método set, para fazer alterações no banco de dados
	novo.setNome(request.getParameter("nome")); //O request.getParameter retorna os valores do formulário html, reparem que eles tem um nome em um tipo, pois bem o nome é o parâmetro.
	novo.setLogin(request.getParameter("login"));
	novo.setSenha(request.getParameter("senha"));
	manager.getTransaction().begin(); //Início de transação, aqui vamos preparar a entidade e o banco de dados para receber esse valor.
	manager.persist(novo); //aqui é usado o método persist, ele usa como parametro o objeto criado nesse laço if, após as alterações dos setters. O dado aqui é adicionado a entidade e ao banco de dados.
	manager.getTransaction().commit(); //commit é um comando usado nos SGBDs, para salvar as alterações feitas. sem esse método o seu dado não é escrito.
	manager.close(); //Aqui é fechada a conexão.
	response.sendRedirect("index.jsp"); //Aqui o cliente é redirecionado para a página index.jsp, ou seja é atualizada a página.
}

//Apagando usuário.
if(request.getParameter("apagar") != null){
	try{ //Foi colocado um try-catch porque o método de apagar dados tem problemas com pontos nulos.
	Long ID = Long.parseLong(request.getParameter("id")); //Aqui é criado uma variavel do tipo long, que recebe convertido de String o conteúdo do formulário html.
	Cliente remCliente = manager.find(Cliente.class, ID); //Ao instanciar objeto aqui é usado um método do EntityManager, o find(). Nele você informa a o nome da Classe.class para ele usar como parâmetro de busca e o valor a ser buscado, lembrando que o valor a ser buscado é o da chave primária.
	//Feito isso, o método carrega o objeto com todas as informações, com base na chave primaria e no padrão da entidade. 
		if(remCliente != null){ //Ele tem problema com dados nulos. No caso o NullPointException
			manager.getTransaction().begin();
			manager.remove(remCliente); //esse método remove depois de comitado os valores contido nele no banco de dados e na entidade.
			manager.getTransaction().commit();
			manager.close();
			response.sendRedirect("index.jsp");
		}
	}catch(Exception e){response.sendRedirect("index.jsp");}//Por bem ou por mal a página será atualizada. O Catch evita erros.
	
}

//Editando usuário.
if(request.getParameter("editar") != null){
try{
	Long editarID = Long.parseLong(request.getParameter("id_editar")); //Aqui o ID é convertido para o formato long.	
	Cliente findCliente = manager.find(Cliente.class, editarID); //Aqui é procurado os dados do objeto cliente, em base no id e nos padrões da Classe Cliente.
	Cliente editarCliente = new Cliente(); //Aqui é criado um objeto, que vai receber os dados do cliente a ser editado.
	editarCliente = findCliente; //O cliente a ser editado, acha os dados do cliente a ser editado.
	editarCliente.setNome(request.getParameter("nome_editar")); //Aqui são setados novos valores para os clientes.
	editarCliente.setLogin(request.getParameter("login_editar"));
	editarCliente.setSenha(request.getParameter("senha_editar"));
	if(editarCliente != null){ //Se o cliente a ser editado existir e não for nulo.
		manager.getTransaction().begin();
		manager.persist(editarCliente); //registrando a alteração
		manager.getTransaction().commit(); //comitando.
		manager.close();
		response.sendRedirect("index.jsp"); //atualizando página.
	}
	
}catch(Exception e){response.sendRedirect("index.jsp");}
}

%>

</body>
</html>