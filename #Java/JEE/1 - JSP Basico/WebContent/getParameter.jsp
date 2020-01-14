<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrado: <%= request.getParameter("nome") %></title>
</head>
<body>
<%@ page import="java.util.Enumeration" %>
<hr>
<p align="left" style=font-size:30px>Nome: <%= request.getParameter("nome") %> </p>
<p align="left" style=font-size:30px>login: <%= request.getParameter("login") %> </p>
<p align="left" style=font-size:30px>Senha: <%= request.getParameter("senha") %> </p>  
<hr>
<% Enumeration<String> Nomes = request.getParameterNames(); //Esse Objeto recebe como parametro, todos os campos de um formulário. 
while(Nomes.hasMoreElements()){ //Faz uma varredura buscando por todos os componentes de um formulário.
	String campo = Nomes.nextElement(); //Aqui pega o nome dos campos do formulário HTML.
	String valor = request.getParameter(campo); //Aqui pega o valor dos dados dos valores de um formulário, usando como parâmetro a função acima.
	out.println("Campo: "+campo+" = Tem o valor: "+valor+"<hr>");
}
%> 

</body>
</html>