<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuário salvo</title>
</head>
<body>
  <%
    String nome="";
    String login="";
    String senha="";
    nome = request.getParameter("nome");
    login= request.getParameter("login");
    senha = request.getParameter("senha");
    out.println("Nome: " + nome + "<br>");
    out.println("Login: " + login + "<br>");
    out.println("Senha: " + senha + "<br>");
  %>
</body>
</html>