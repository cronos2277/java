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
A Express�o EL pega o valor do JavaBeans. No caso usa o cifr�o e coloca a express�o entre colchetes.<br />
<hr>
No caso do javabens voc� chama o mesmo atrav�s da tag jsp:useBean. <br />
O valor id, � o nome ao qual o objeto do framework javabeans � conhecido. <br />
O valor de class funciona de maneira semalhante ao import, informando o local da classe java. <br />
<hr>
jsp:setProperty nessa tag � informado a vari�vel privada da classe java, no caso os valores adicionado ali, s�o enviadas a classe 
java expecificada no class, a variavel da classe sempre deve ser uma vari�vel privada, pois o JavaBeans
acessa usando o m�todo getter e setter. Value o valor a ser enviado.<br />
<hr>
jsp:getProperty aqui � recuperado um valor da vari�vel privada, da classe especificada no jsp:useBean
funciona de maneira contr�ria ao jsp:setProperty. No property voc� especifica o nome da vari�vel da classe,
o name o � a id do objeto criado pelo javabeans.<br />
<hr>
Falando um pouco mais sobre a tag jsp:useBean. o scope � a forma ao qual o javabeans vai tratar os dados no formul�rio.
o Page significa que os dados serao esquecidos quando o usu�rio sair da p�gina, tem o session que funciona para sess�o
o application que funciona para todos os usuarios que estiverem no servidor(N�o aconselh�vel), request � valido durante
a requisi��o dos dados <br />
<hr>
Observa��o, se os name dos componentes de um formul�rio n�o tiver o nome igual a vari�vel privada
da classe chamada pelo javabeans, n�o funcionar�. Tanto o nome do componente html, quanto da vari�vel
deve ser identicos.
</body>
</html>