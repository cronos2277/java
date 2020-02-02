<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java.util.*; Exercícios com a diretiva Include.</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%! //Declarações, aqui é declarada funções e instanciado objetos.
HashSet<Integer> Alpha = new HashSet<Integer>();
int e = 1;
public void funcao(int num){while(e<=num){Alpha.add(e);e++;}}
%>

<% funcao(13); //Scriptlet: Aqui o código é processsado.%>
<center><h1>Exercícios com a biblioteca Java util</h1></center>
<center><h3>Logo abaixo o resultado de uma Expressão, que substitui o código pelo resultado dele.</h3></center>
<hr>
<center> <h2>Conteúdo do Array: <%= Alpha.toString()%></h2> </center>


</body>
</html>