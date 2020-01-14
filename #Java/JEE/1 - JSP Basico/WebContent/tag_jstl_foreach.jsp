<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo da tag forEach - JSTL</title>
</head>
<body>
        <h2>Lista de cursos</h2>
        <c:set var="cursos" value="Java SE, Java EE, Java ME, EJB" scope="page" />
        <c:forEach var="curso" items="${cursos}">
            <c:out value="${curso}" /><br />
        </c:forEach>
        <hr>
        <c:forEach var="i" begin="1" end="5">
            <c:out value="${i}" /><br />
        </c:forEach>
</body>
</html>