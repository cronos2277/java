<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo da tag JSTL For Token.</title>

</head>
<body>
<jsp:useBean id= "user" class= "br.treinaweb.javaee.Javabeans_PT" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<c:if test="${user.enviar == null}">
<form action="" method="post">
<table>
<tr><td>Digite uma frase: </td>
<td><input type="text" name="generico"></td>
<td><input type="submit" name="enviar" value="enviar"></td>
</tr>
</table>
</form>
</c:if>

<c:if test="${user.enviar != null}">
<c:forTokens items="${user.generico}" delims="," var="out">
<c:out value="${out}"></c:out>
</c:forTokens>
</c:if>
<br />
<hr>
A função JSTL acima, primeiro verifica se o objeto privado enviar está vazio,
tanto o primeiro if, quanto o segundo. O primeiro é o oposto do segundo if.
jsp:useBean, alí é instanciado o Objeto, no caso ele está instanciado como user.
todos os atributos do javabeans devem ser privados, isso é uma regra. O scope=page
diz que os dados são válidos apenas para a página e não para a sessão ou aplicação.
<br /><hr>
Após temos o jsp:setProprety. O carácter coringa habilita o uso de todos os atributos
da classe instanciada acima, o user informa de qual método beans está sendo habilitada.
<br /><hr>
Após isso temos um formulário normal em html como qualquer outro, as referencias ao
atributo do beans já foram feitas antes de chegarmos aos formulários.
<br /> <hr>
agora preste a atenção no c:if. Temos o "c" que é um prefixo referenciado no taglib
acima no cabeçalho da página. O uri é aonde está a biblioteca de dados do mesmo.
Nos if temos o parâmetro test="" alí dentro é colocado o valor a ser comparado, como
em um if normal. Dentro das aspas, temos uma tag EL(Expression Language), alí é
referenciado o objeto criado no jsp:useBean, ponto o seu atributo sucedido de uma 
expressão que retornará um booleano. A sintaxe é aquela mesma, qualquer coisa diferente
o código vai dar erro, caso o dado a ser comparado seja um string ou um char,
use aspas simples.
<br /> <hr>
o laço "prefixo:forTokens" tem três ajustes que devem ser feitos. No "items", é 
inserido o array ou a string. O delims"", é o delimitador, no caso é uma virgula,
em todas as strings avaliadas o delimitador "," será apagado e o seu valor após
 a virgula será apagada. var"" a variável de saida formata
 pelo prefixo forTokens. 
</body>
</html>