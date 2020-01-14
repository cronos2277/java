<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando Clientes...</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
String nome = request.getParameter("nome");
String login = request.getParameter("login");
String senha = request.getParameter("senha");
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();	
String url = "jdbc:mysql://127.0.0.1/java_ee?user=root&password=123456";
Connection con = DriverManager.getConnection(url);
Statement st = con.createStatement();
String sql = "insert into usuarios(nome,login,senha) values('"+nome+"','"+login+"','"+senha+"');";
int rows = st.executeUpdate(sql);
if(rows > 0)
out.print("O usu�rio " + nome + " foi salvo com sucesso");
}catch(Exception e){out.println("Erro ao se conectar com o Banco de dados.");}

%>
</body>
</html>