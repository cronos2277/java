<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exercicios JSTL.</title>
</head>
<body>
<jsp:useBean id= "Beans" class="br.com.treinaweb.javaee.JavaBeans1" scope="session" />
<jsp:setProperty property="nome" name="Beans" value="Seu nome"/>
<c:use var = "zero" value="zero"></c:use>
<c:out value="${zero}"></c:out>
</body>
</html>