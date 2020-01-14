<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilizando JSTL - forEach com JavaBeans</title>
</head>
  <body>
    <h2>Lista de cursos</h2>
    <jsp:useBean id="curso" class="br.com.treinaweb.javaee.Cursos" />
    <c:set var="cursos" value="${curso.listaCursos}" scope="session" />
    <c:forEach var="nome" items="${cursos}">
        <c:out value="${nome} <br />" escapeXml="false" />
    </c:forEach>
  </body>
</html>