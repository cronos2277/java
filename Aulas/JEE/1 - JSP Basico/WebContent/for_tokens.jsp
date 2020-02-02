<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag forTokens - JSTL</title>
</head>
<body>
        <h2>Lista de cursos</h2>
        <c:set var="cursos" value="Java SE, Java EE, Java ME, EJB" scope="page" />
        <c:forTokens var="curso" delims="," items="${cursos}">
            <c:out value="${curso}" /><br />
        </c:forTokens>
</body>
</html>