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
<c:out value="Tag para imprimir na página jsp."></c:out>
c:out value="algo para ser impresso na tela." Essa tag Jstl imprime o que for digitado na tela.
<hr>
<c:set var="mensagem" value="Variável criada"></c:set>
c:set var="o nome da variável." value="Seu conteúdo". Aqui foi criado uma varivel, e dado um valor para ela.
a tag c:set, aceita mais dois parâmetros, uma se refere a property="" 
que é a variável do beans, target="o none instanciado no javabeans." scope="o tipo de escopo e a durabilidade dos dados"
<hr>
<c:out value="${mensagem}"></c:out>
Aqui a c:out está imprimindo o valor de uma variável, o que estiver dentro do colchetes no cifrão é variável. Tudo dentro de aspas duplas.
<hr>
<c:remove var="mensagem" /> 
c:remove="o nome da variavel", apaga a variavel e todo o seu conteúdo.
<hr>
<c:catch var="erro">
<%
out.println(5/0);
%>
</c:catch><c:out value="${erro}"></c:out>
<br /> a tag c:catch var="a variavel para receber a mensagem do catch." funciona de maneira identica ao try catch. basta colocar a expressão entre essas tags.
assim que identificado um erro o mesmo será escrito na variável informada ao chamar a tag.
<hr>
<c:if test="${mensagem} == Variável criada">
Olá mundo.
</c:if>
O c:if test="Expressão a ver avaliada" é um desvio condicional, assim como o if. se o conteúdo do test=""
for verdadeiro, entra-se no desvio condicional, caso contrário é ignorado.
<hr>

</body>
</html>