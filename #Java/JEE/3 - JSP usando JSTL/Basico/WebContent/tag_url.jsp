<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag url - JSTL</title>
</head>
<body>
    <h2>Salvar Usuário</h2>
    <c:url value="/salvarusuario.jsp" var="url">
        <c:param name="nome" value="José Silva" />
        <c:param name="login" value="jose.silva@treinaweb.com.br" />
        <c:param name="senha" value="1234" />
    </c:url>
    <a href="${url}">Incluir</a>
    <hr>
    Valor da url:<c:out value="${url}" />
</body>
</html>