<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag choose - JSTL</title>
</head>
<body>
  <c:catch var="erro">
    <c:set var="mesAtual" value="10" />
  </c:catch>
  <c:if test="${erro != null }">
    <c:out value="Ocorreu o erro: ${erro}" />
  </c:if>
  <c:choose>
    <c:when test="${mesAtual == 1}">
      <c:out value="Estamos em Janeiro" />
    </c:when>
    <c:when test="${mesAtual == 2}">
      <c:out value="Estamos em Feveiro" />
    </c:when>
    <c:when test="${mesAtual == 3}">
      <c:out value="Estamos em Março" />
    </c:when>
    <c:when test="${mesAtual == 4}">
      <c:out value="Estamos em Abril" />
    </c:when>
    <c:when test="${mesAtual == 5}">
      <c:out value="Estamos em Maio" />
    </c:when>
    <c:when test="${mesAtual == 6}">
      <c:out value="Estamos em Junho" />
    </c:when>
    <c:when test="${mesAtual == 7}">
      <c:out value="Estamos em Julho" />
    </c:when>
    <c:when test="${mesAtual == 8}">
      <c:out value="Estamos em Agosto" />
    </c:when>
    <c:when test="${mesAtual == 9}">
      <c:out value="Estamos em Setembro" />
    </c:when>
    <c:when test="${mesAtual == 10}">
      <c:out value="Estamos em Outubro" />
    </c:when>
    <c:when test="${mesAtual == 11}">
      <c:out value="Estamos em Novembro" />
    </c:when>
    <c:when test="${mesAtual == 12}">
      <c:out value="Estamos em Dezembro" />
    </c:when>
    <c:otherwise>
      <c:out value="Mês desconhecido" />
    </c:otherwise>
  </c:choose>
  <hr>
  A tag c:chose test="Expressão a ser avaliada" funciona de forma identica ao switch, when semelhante as expressões case
  e o otherwise o default do switch case.
</body>
</html>