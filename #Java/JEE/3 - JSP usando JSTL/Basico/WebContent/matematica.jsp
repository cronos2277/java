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
<jsp:useBean id="user" class="br.treinaweb.javaee.Javabeans_PT" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<c:if test ="${user.enviar == null}">

<form action="" method="post">
<table>
<tr><td>Informe um numero inteiro: </td><td><input type="text" size="8" name="id"></td></tr>

<tr><td><input type="submit" name="enviar" value="enviar"></td></tr>
</table>
</form>

</c:if>

<c:if test="${user.enviar != null}">
<c:set var="pot" value="${user.id*user.id}"></c:set>
<c:set var="raiz" value="${Math.sqrt(user.id)}"></c:set>
<c:out value="Em relação ao número ${user.id} temos:"></c:out>
<hr><br />
<c:out value="A potenciação do número é: ${pot}"></c:out>
<br /><br />
<c:out value="A Raiz quadrada do número é: ${raiz}"></c:out>
<br /> <br />
<c:out value="O número é divisível por: "></c:out>
<c:forEach var="i" begin="1" end="${user.id}">
<c:if test="${user.id % i == 0}">
<c:out value="${i},"></c:out>
</c:if>
</c:forEach>
<br /><br />
<c:choose>
<c:when test="${user.id % 2 == 0 }">
<c:out value="O número ${user.id} é par."></c:out>
</c:when>
<c:otherwise>
<c:out value="O número ${user.id} é impar."></c:out>
</c:otherwise>
</c:choose>
</c:if>
</body>
</html>