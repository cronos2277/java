<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="pkg.java.JavaBeans" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body bgcolor="lightgray">
<br /><br /> <br /> <br />
<br /><br /> <br /> <br />
<h1 align="center"> Página de Login</h1>
<hr>
<form method="post" action="cont">
<table align="center">
<tr>
<td>Login: <input type="text" name="login"></td>
</tr>
<tr>
<td>Senha: <input type="password" name="senha"></td>
<td><input type="submit" name="enviar" value="enviar"></td>
</tr>
</table>
</form>
<hr>
<h3 align="center"><a href="new.jsp"> Clique aqui para cadastrar. </a></h3> 
<hr>
<%
String tmp = "null";
Cookie[] cookieL = request.getCookies();
	for(Cookie ck: cookieL){
			if(ck.getName().equals("login"))
			{tmp = ck.getValue();}	
	}
	
if(tmp != null){response.sendRedirect("cont");}
%>
</body>
</html>
<!-- 
	Página de login padrão. O segredo da página está no funcionamento dos Cookies
	primeiro é criado um objeto array do tipo Cookie, junto de uma String com valor
	nulo. Depois o for each varre o array de objetos cookie, uma vez que ele ache o
	cookie.getName() == login, ele cai em um desvio condicional. o getName, é o nome
	do cookie criado pelo servlet. Quando você cria um cookie, você deve informar 
	dois parâmetros, um é o nome e o outro é o valor, o valor no caso é o 
	request.getParameter("login"), que é justamente o valor informado no campo login
	do formulario acima. Primeiro ocorre um acesso pelo método post e nesse método
	se é criado o cookie. No desvio condicional, é passado o valor para a String 
	através da função .getValue().
	Após isso caímos em um outro desvio condicional. Esse desvio condicional remete
	o usuário para o método post do servlet, através de uma resposta do servidor.
	Assim é executado o response.sendRedirect("a tag de identificação do servlet");

 -->
