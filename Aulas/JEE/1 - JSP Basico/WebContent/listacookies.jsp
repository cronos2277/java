<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies</title>
</head>
<body>
  <h2>Cookies da página:</h2>
  <%
    String tabela = "";
    tabela +="<table>";
    tabela +="<tr><td>nome</td><td>valor</td></tr>";
    //Obtendo todos os cookies
    Cookie[] lista = request.getCookies();
    for(int i=0;i<lista.length;i++){
        String nome = lista[i].getName();
        String valor = lista[i].getValue();
        tabela += "<tr><td>" + nome + "</td><td>" + valor + "</td></tr>";
    }
    tabela += "</table>";
    out.println(tabela);
  %>
</body>
</html>