<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL And MySQL</title>
</head>
<body>
<jsp:useBean id="user" class="pkgs.JavaServerPagesVar"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<jsp:useBean id="data" class="java.util.Date"></jsp:useBean>
<sql:setDataSource var="conexao" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/java_ee"
user="root"  password="123456"/>
 <sql:query var="consulta" dataSource="${conexao}"> select * from cliente</sql:query>
<h3 align="center">Página com JSTL e SQL: </h3>

<table border="2px" align="center">
<c:forEach var="linha"  items="${consulta.rows}">
<tr><td>ID:	</td><td>Nome: </td><td>Login: </td><td>Senha: </td></tr>
<tr>
<td><c:out value="${linha.id}"></c:out></td>
<td><c:out value="${linha.nome}"></c:out></td>
<td><c:out value="${linha.login}"></c:out></td>
<td><c:out value="${linha.senha}"></c:out></td>
</tr>
</c:forEach>
</table><p align="right">
<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long"/></p>
<hr><hr><br />
Preste a atenção, aqui nós temos a tag sql: o que na verdade é uma tag muito complexa.
sql:setDataSource aceita de dois a cinco parametros. No var="" você coloca um nome
para a conexao, que essa tag vai tentar fazer. O segundo seria o dataSource, que ou
você poderia colocar o diver="" + url="" +user="" + password em um campo só, ou
informar esses valores citados, com um campo para cada, como foi feito aqui, no caso
até é o recomendado. O que você tem que saber, que caso tenha alguma coisa de errado
aqui vai dar merda em todas as outras tags. No linux você deve especificar a porta
no campo url, ali no caso o 3306, no windows não se especifica a porta. PRESTE A ATENÇÃO.
<hr><br />
A segunda tag é a sql:query. Ela necessita de dois parâmetos. O var="" será o nome 
dado a consulta ao SGBD, após isso tem o dataSource, que vai conter em EL a variavel
de conexão. É importante que o corpo dessa tag tenha um expressão em sql, pois do
contrário dará erro.
<hr> <br />
No table foi usado um forEach. No consulta está todas os resultados da expressão sql.
no consulta.rows é verificado cada coluna e cada uma delas é exibida dentro da tag td.
O forEach está acima da tag tr, ao terminar o laço a tag tr também é concluída.


</body>
</html>