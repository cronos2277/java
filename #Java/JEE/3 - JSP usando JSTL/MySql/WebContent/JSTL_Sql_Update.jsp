<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>  
 <%@ page import="pkgs.JavaServerPagesVar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL With SQL update like</title>
</head>
<body>
<jsp:useBean id="bean" class="pkgs.JavaServerPagesVar"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://127.0.0.1:3306/java_ee" 
user="root" password="123456" var="conection"/>
<h3 align="right">Clientes Cadastrados: </h3>
<hr>
<sql:query var="check" dataSource="${conection}"> select * from cliente </sql:query>

<table align="center" border="1px">
<tr><td>Nome: </td><td>Login: </td><td>Senha: </td></tr>
<c:forEach var="line" items="${check.rows}">
<tr>
<td><c:out value="${line.nome}"></c:out></td>
<td><c:out value="${line.login}"></c:out></td>
<td><c:out value="${line.senha}"></c:out></td>
</tr>

</c:forEach>
</table>
<hr>
<h3>Cadastro de clientes:</h3>
<c:if test="${bean.enviar == null}">
<form method="post">
<table align="center" border="1px">
<tr><td>Nome: <input type="text" name="nome"></td>
<td>Login: <input type="text" name="login"></td>
<td>Senha: <input type="text" name="senha"></td>
<td><input type="submit" name="enviar" value="enviar"></td></tr>
</table>
</form>
</c:if>

<c:if test="${bean.enviar != null }">
<sql:update dataSource="${conection}" var="update">
insert into cliente values ("${bean.nome}","${bean.login}","${bean.senha}");
</sql:update>
</c:if>
<hr>
Por fim a tag update. Na tag sql:update tem o dataSource, que é a variável criada,
pela sql:setDataSource. e a var, que é a variável aonde se guarda os dados resultante
do comando update,como por exemplo o número de colunas afetadas. Dentro de suas tags
você coloca o código sql, os valores você coloca usando as Expression Language. Sendo
que até o ponto e vírgula são colocados.
</body>
</html>