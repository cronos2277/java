<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body bgcolor="lightgray">
<jsp:useBean id="bean" class="pkg.java.JavaBeans" />
<jsp:setProperty property="*" name="bean"/>
<br /><br /> <br /> <br />
<br /><br /> <br /> <br />
<h1 align="center"> Cadastro de Clientes</h1>
<form action="ask.jsp" method="post">
<table align = "center">
<tr><td>Informe um  Nome: <input type="text" name="nome" value="${bean.nome}"></td></tr>
<tr><td>Informe um  Login: <input type="text" name="login" value="${bean.login}"></td></tr>
<tr><td>Informe uma Senha: <input type="password" name="senha" value="${bean.senha}"></td></tr>
<tr><td><input type="submit" name="enviar" value="enviar"></td></tr>
</table>
</form>
</body>
</html>
<!-- 
		Na linha 10, é criado um objeto javabean. com uma id, que seria o nome do
     Objeto instanciado e o parâmetro class com a finalidade de informar o local 
     da classe
     
     	Na linha 11 é setado uma propriedade a este objeto. O nome é a ID do objeto
     beans. em property é setado um caracter coringa setando assim, valor a todos
     os atributos. Em casos que não seja necessário o uso de todos os atributos,
     informe o property no próprio formulario criando assim um campo a mais.
     
     	Da Linha 17 até a 20, temos o formulário. Repare que em value, está setado
     um expressão em EL. no caso do EL, temos o objeto bean ponto o atributo
     do objeto. No caso essa expressão EL, vai carregar os valores armazenados
     no objeto bean, caso esteja vazia, nada é exibido.
      
 -->