<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco de dados</title>
</head>
<body>
  <sql:setDataSource var="conexao" dataSource="jdbc:mysql://127.0.0.1/java_ee,com.mysql.jdbc.Driver,root,123456" />
  <sql:query dataSource="${conexao}" var="consulta">
    select * from usuarios order by idusuarios
  </sql:query>
  <h4>Categorias:</h4>
  <table>
    <c:forEach var="linha" items="${consulta.rows}">
      <tr>
        <td><c:out value="${linha.idusuarios}" /></td>
        <td><c:out value="${linha.nome}" /></td>
        <td><c:out value="${linha.login}" /></td>
        <td><c:out value="${linha.senha}" /></td>
        </tr>
    </c:forEach>
  </table>
</body>
</html>