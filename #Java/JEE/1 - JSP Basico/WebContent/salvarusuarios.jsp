<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Statement,java.sql.DriverManager,java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usu�rio salvo</title>
</head>
<body>
  <%
    String nome = request.getParameter("nome");
    String login= request.getParameter("login");
    String senha = request.getParameter("senha");
    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      String url = "jdbc:mysql://127.0.0.1/java_ee?user=root&password=123456";
      Connection con = DriverManager.getConnection(url);
      Statement st = con.createStatement();
      String q = "";
      q += " insert into usuarios (nome,login,senha) ";
      q += " values ('" + nome + "',";
      q += "'" + login + "',";
      q += "'" + senha + "')";
      int rows = st.executeUpdate(q);
      if(rows > 0)
        out.print("O usu�rio " + nome + " foi salvo com sucesso");
    }catch(Exception ex){
      ex.printStackTrace();
    }
  %>
</body>
</html>