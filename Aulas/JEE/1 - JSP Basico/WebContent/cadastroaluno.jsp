<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag out - JSTL</title>
</head>
<body>
    <h2>Propriedades do Java Beans</h2>
    <form method="post">
        <table style="border: 0px">
            <tr><td>Nome:</td><td><input type="text" name="txtnome"></td></tr>
            <tr><td>Endereco:</td><td><input type="text" name="txtendereco"></td></tr>
            <tr><td>Cep:</td><td><input type="text" name="txtcep"></td></tr>
          <tr><td>Cidade:</td><td><input type="text" name="txtcidade"></td></tr>
          <tr><td>Estado:</td><td><input type="text" name="txtestado"></td></tr>
          <tr><td colspan="2"><input type="submit" name="cmdincluir" value="Incluir"></td></tr>
        </table>
    </form>
    <c:if test="${param.cmdincluir == 'Incluir'}" >
        <table style="border: 1px">
            <tr><td>nome:</td><td><c:out value="${param.txtnome}" /></td></tr>
            <tr><td>endereco:</td><td><c:out value="${param.txtendereco}" /></td></tr>
            <tr><td>cep:</td><td><c:out value="${param.txtcep}" /></td></tr>
            <tr><td>cidade:</td><td><c:out value="${param.txtcidade}" /></td></tr>
            <tr><td>estado:</td><td><c:out value="${param.txtestado}" /></td></tr>
        </table>
    </c:if>
</body>
</html>