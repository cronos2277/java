<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>internacional</title>
</head>
<body>
<jsp:useBean id="data" class="java.util.Date"></jsp:useBean>
<fmt:setBundle basename="br.com.treinaweb.javaee.Recurso" var = "idioma" scope="page"/>
<jsp:useBean id="user" class="br.com.treinaweb.javaee.JavaBeans1"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<h2 align="center"><fmt:message key="login.apresentacao" bundle="${idioma}"></fmt:message></h2>
<br /> <br /><hr><hr>
<c:if test="${user.nome == null}">
<h2 align="center"> D�gite um nome:</h2>
<form method="post">
<table align="center">
<tr>
<td><fmt:message key="login.usuario" bundle="${idioma}"></fmt:message> </td><td><input type="text" name="nome"></td>
<td><input type="submit" name="enviar"></td>
</tr>
</table>
</form>
</c:if>

<c:if test="${user.nome != null}">
<h1 align="center"><fmt:message key="login.usuario" bundle="${idioma}"></fmt:message><c:out value="${user.nome}"></c:out></h1>
</c:if>
<br /> <hr>
<fmt:formatDate value="${data}" dateStyle="long"/><br />
<fmt:formatNumber value="123.50" type="currency"></fmt:formatNumber>
<hr>
<fmt:setLocale value="en_EN"/>
<fmt:formatDate value="${data}" dateStyle="long"/><br />
<fmt:formatNumber value="123.50" type="currency"></fmt:formatNumber>
<hr>
OBs: Deve ter os arquivos java Recurso_en, Recurso_fr, Recurso_pt, na pasta src. 
<hr>
No caso temos as tags fmt:Format data que aceita quatro par�metros. Primeiro o value, contendo o objeto
javabean instanciado apartir da classe Date, do Java Util. Segundo o modelo da data, podendo ser
short >> 05/02/2015 ou Long >> 5 de fevereiro de 2015. Est� oculto, mas tem tamb�m o pattern, que
recebe como par�metro, uma string indicando a ordem em que estar� dia m�s e ano. Por exemplo.
pattern="MM/dd/yyyy" o MM equivale ao m�s, dd o dia e yyyy ao ano, que ser� exibido nessa ordem.
<hr>
fmt:formatNumber aceita tr�s par�metros. value que ser� o valor a ser informado. type, que � o tipo
que ele ser� informado, no caso ali ser� em reais, e pattern que vao definir quantas casas decimais
ser�o exibidas, e aonde vai ter ponto ou v�rgula. 
</body>
</html>