<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Internacional</title>
</head>
<body>
<jsp:useBean id="beans" class="br.treinaweb.javaee.javabeans"></jsp:useBean>
<jsp:setProperty property="*" name="beans"/>
<jsp:useBean id="data" class="java.util.Date"></jsp:useBean>
<h3 align="center">Internacional - Package: br.treinaweb.javaee</h3>
<fmt:setBundle basename="br.treinaweb.javaee.Internacional" var="idioma" scope="page"/>

<h3 align="center"><fmt:message key="login.apresentacao" bundle="${idioma}"></fmt:message></h3>
<br />

<c:if test="${beans.enviar == null}">
<form action="" method="post">
<table align="center">
<tr>
<td><fmt:message key="login.usuario" bundle="${idioma}"></fmt:message></td>
<td><input type="text" name="user"></td></tr>
<tr>
<td><fmt:message key="login.senha" bundle="${idioma}"></fmt:message>
<td><input type="text" name="pwd"></td>
</tr>
<tr>
<td><input type="submit" name="enviar" value="enviar"></td>
</tr>
</table>
</form>
</c:if>

<c:if test="${beans.enviar != null}">
<hr>
<table align="center">
<tr>
<td><fmt:message key="login.usuario" bundle="${idioma}"></fmt:message></td>
<td>${beans.user}</td>
</tr>

<tr>
<td><fmt:message key="login.senha" bundle="${idioma}"></fmt:message></td>
<td>${beans.pwd}</td>
</tr>
</table>
</c:if>

<br />
<fmt:formatDate value="${data}" timeStyle="long" dateStyle="long"/>
 <br />
 <fmt:formatDate value="${data}" timeStyle="short" dateStyle="short"/>
 <br /><hr><hr>
No inicio temos o fmt:setBundle. Primeiro parametro a receber é o nome da classe,
sem o underline com o idioma. Você cria as classes com os idiomas, como por exemplo
Internacional_pt, ou Internacional_en. Entretanto será definido nas configurações
do Browser qual idioma vai ser usado, o mecanismo de uso é semelhante ao JavaBeans.
Depois tempo a var que será uma string ao qual será referenciado o objeto instanciado.
Por fim o escopo, no caso setado como page.
<hr>
No decorrer no corpo da página temos a tag fmt:message. A key representa os valores
criados no objetos da classe java, na pasta src. Veja que dentro dessas classe, contem
uma matriz bi-dimensional. Seu conteudo é o nome dos atributos, ou as chaves como são
chamados aqui, e o segundo o seu valor propriamente dito. O conteúdo de seu valor
varia conforme o idioma configurado no browser. O valor do bundle, é o mesmo nome
da variavel criada de maneira semelhante ao javabeans do fmt:setBundle.
<hr>
Por fim temos o Objeto bean data. No ínicio é criado um objeto bean da classe java,
util,Date. O fmt:formatDate recebe tres parametros, o value que será informado a
ID do javabean usando o Expression Language, após isso temos o timeStyle e o dateStyle
ambos recebem os parametros, ou short ou long, que significa curto ou longo.
No exemplo acima é usado as duas formas.
<hr><hr>
</body>
</html>