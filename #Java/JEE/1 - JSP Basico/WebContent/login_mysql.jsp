<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dentro da p�gina</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<h2 align="right"><%= request.getParameter("user") %></h2><hr><br />
<%
Class.forName("com.mysql.jdbc.Driver").newInstance();
try{
String url = "jdbc:mysql://127.0.0.1/java_ee?user=root&password=123456";
Connection com = DriverManager.getConnection(url);
Statement st = com.createStatement();
String sql = "select * from usuarios where login = '"+request.getParameter("user")+"';";
ResultSet rs = st.executeQuery(sql);
out.println(rs);
if (rs.next()){
	String Nome = String.format("%s", rs.getObject("nome"));
	String Senha = String.format("%s", rs.getObject("senha"));
	String Login = String.format("%s", rs.getObject("login"));
	out.println("Nome: "+Nome+"<br /> Usu�rio: "+Login+"<br /> Senha: "+Senha);
}
}catch(Exception e){out.println("Erro ao conectar-se ao banco de dados.");}
%>
<br /><hr>
<h2 align="right"><%= new java.util.Date() %></h2>
</body>
</html>