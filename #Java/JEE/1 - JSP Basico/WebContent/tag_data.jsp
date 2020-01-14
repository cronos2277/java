<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="data" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabalhando com formatação</title>
</head>
<body>
  <hr />Padrão do Navegador<br />
  <fmt:formatNumber value="123.45" type="currency" /><br />
  <fmt:formatNumber value="32.1" pattern=".000" /><br />
  <fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
  <fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
  <fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />
  <hr />Inglês<br />
  <fmt:setLocale value="en_US" />
  <fmt:formatNumber value="123.45" type="currency" /><br />
  <fmt:formatNumber value="32.1" pattern=".000" /><br />
  <fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
  <fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
  <fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />
  <hr />Francês<br />
  <fmt:setLocale value="fr_FR" />
  <fmt:formatNumber value="123.45" type="currency" /><br />
  <fmt:formatNumber value="32.1" pattern=".000" /><br />
  <fmt:formatNumber value="123456.789" pattern="#,#00.0#" /><br />
  <fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" /><br />
  <fmt:formatDate value="${data}" pattern="dd.MM.yyyy" /><br />
</body>
</html>