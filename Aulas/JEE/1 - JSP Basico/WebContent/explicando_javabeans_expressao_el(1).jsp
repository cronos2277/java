<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" scope="page" class="br.com.treinaweb.javaee.JavaBeans1" />
<jsp:setProperty property="nome" name="user" value="Seu nome"/>
<table><input type="text" name="nome" value="${user.nome}"></table>
<hr>
<jsp:getProperty property="status" name="user"/>
<hr>
<br />
A Expressão EL pega o valor do JavaBeans. No caso usa o cifrão e coloca a expressão entre colchetes.<br />
<hr>
No caso do javabens você chama o mesmo através da tag jsp:useBean. <br />
O valor id, é o nome ao qual o objeto do framework javabeans é conhecido. <br />
O valor de class funciona de maneira semalhante ao import, informando o local da classe java. <br />
<hr>
jsp:setProperty nessa tag é informado a variável privada da classe java, no caso os valores adicionado ali, são enviadas a classe 
java expecificada no class, a variavel da classe sempre deve ser uma variável privada, pois o JavaBeans
acessa usando o método getter e setter. Value o valor a ser enviado.<br />
<hr>
jsp:getProperty aqui é recuperado um valor da variável privada, da classe especificada no jsp:useBean
funciona de maneira contrária ao jsp:setProperty. No property você especifica o nome da variável da classe,
o name o é a id do objeto criado pelo javabeans.<br />
<hr>
Falando um pouco mais sobre a tag jsp:useBean. o scope é a forma ao qual o javabeans vai tratar os dados no formulário.
o Page significa que os dados serao esquecidos quando o usuário sair da página, tem o session que funciona para sessão
o application que funciona para todos os usuarios que estiverem no servidor(Não aconselhável), request é valido durante
a requisição dos dados <br />
<hr>
Observação, se os name dos componentes de um formulário não tiver o nome igual a variável privada
da classe chamada pelo javabeans, não funcionará. Tanto o nome do componente html, quanto da variável
deve ser identicos.
</body>
</html>