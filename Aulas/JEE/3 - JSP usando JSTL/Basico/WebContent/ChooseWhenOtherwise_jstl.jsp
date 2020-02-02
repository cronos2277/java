<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="br.treinaweb.javaee.Javabeans_PT"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<c:forEach var="id" begin="0" end="5">
<c:choose>
<c:when test="${id == 0}">Valor zero<br /></c:when>
<c:when test="${id < 4 }">Menor que 4<br /></c:when>
<c:otherwise>Maior igual a 4.<br /></c:otherwise>
</c:choose>
</c:forEach>
<br /><br /><hr>
No caso o laço em questão aqui é o c:choose. Ele funciona de maneira identica ao
switch case. when seria o case, e dentro das aspas dos test do when, as condições 
para determinada condição funcionar. Temos também o otherwise, que funciona de
maneira identica ao default do switch case. 
</body>
</html>