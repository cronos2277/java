<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplos de Tag JSTL</title>
</head>
<body>
<c:out value="Tag para imprimir na p�gina jsp."></c:out>
c:out value="algo para ser impresso na tela." Essa tag Jstl imprime o que for digitado na tela.
<hr>
<c:set var="mensagem" value="Vari�vel criada"></c:set>
c:set var="o nome da vari�vel." value="Seu conte�do". Aqui foi criado uma varivel, e dado um valor para ela.
a tag c:set, aceita mais dois par�metros, uma se refere a property="" 
que � a vari�vel do beans, target="o none instanciado no javabeans." scope="o tipo de escopo e a durabilidade dos dados"
<hr>
<c:out value="${mensagem}"></c:out>
Aqui a c:out est� imprimindo o valor de uma vari�vel, o que estiver dentro do colchetes no cifr�o � vari�vel. Tudo dentro de aspas duplas.
<hr>
<c:remove var="mensagem" /> 
c:remove="o nome da variavel", apaga a variavel e todo o seu conte�do.
<hr>
<c:catch var="erro">
<%
out.println(5/0);
%>
</c:catch><c:out value="${erro}"></c:out>
<br /> a tag c:catch var="a variavel para receber a mensagem do catch." funciona de maneira identica ao try catch. basta colocar a express�o entre essas tags.
assim que identificado um erro o mesmo ser� escrito na vari�vel informada ao chamar a tag.
<hr>
<c:if test="${mensagem} == Vari�vel criada">
Ol� mundo.
</c:if>
O c:if test="Express�o a ver avaliada" � um desvio condicional, assim como o if. se o conte�do do test=""
for verdadeiro, entra-se no desvio condicional, caso contr�rio � ignorado.
<hr>

</body>
</html>