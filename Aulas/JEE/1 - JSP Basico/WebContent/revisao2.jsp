<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Revisão 2.</title>
</head>
<body>
<br /> 
<%@ page import = "java.util.*"%>
<%@ include file ="barra.html" %>
<%! TreeMap<Integer,Double> Beta = new TreeMap<Integer,Double>();int b=101;%>
<%! public void funcao(int a){for(int i=0;i<a;i++){Beta.put(i,Math.sqrt(i));}} %>
<hr>
<% funcao(b);%>
<% for(int i=0;i<b;i++){out.println("Número "+i+", Raiz Quadrada: ");out.println(Beta.get(i));if(i%4==0 && i != 0){out.println("<br /><hr>");} else {out.println("|&nbsp;&nbsp;&nbsp;&nbsp;|");}} %>
<hr>
<p align = "right">
Hora Atual:
<%= new java.util.Date()%>
</p>
</body>
</html>