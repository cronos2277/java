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
  <fieldset>
    <legend>Cadastro Categoria</legend>
      <form method="post">
          <table border="0">
              <tr><td>Categoria:</td><td><input type="text" name="txtnome"></td></tr>
              <tr><td colspan="2"><input type="submit" name="cmdincluir" value="Incluir"></td></tr>
          </table>
      </form>
  </fieldset>
  <sql:setDataSource var="conexao" dataSource="jdbc:mysql://127.0.0.1/loja,com.mysql.jdbc.Driver,root,123456" />
  <c:if test="${!empty param.cmdincluir}">
      <sql:update dataSource="${conexao}" var="alteracao">
          insert loja.categoria (categoria) values(?)
          <sql:param value="${param.txtnome}" />
      </sql:update>
      <c:if test="${alteracao > 0}">
        <c:out value="${'Incluido com sucesso'}" />
      </c:if>
  </c:if>
  <sql:query dataSource="${conexao}" var="consulta">
    select idcategoria,categoria from categoria order by categoria
  </sql:query>
  <h4>Categorias:</h4>
  <table>
    <c:forEach var="linha" items="${consulta.rows}">
      <tr>
        <td><c:out value="${linha.idcategoria}" /></td>
        <td><c:out value="${linha.categoria}" /></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>