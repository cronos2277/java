<%@ tag language="java" pageEncoding="UTF-8"%> <!-- Codificação -->
<%@ attribute name="init" required ="false" %> <!-- Criação do atributo, é com ele que a página vai interagir. -->
<jsp:doBody var="param" /> <!-- doBody serve para ser usado como parametro, quando for passado valor para a variável criada no atributo. -->
<FormatText> <!-- Aqui é criada a tag. -->
<% //Scriptlets
init = (String) jspContext.getAttribute("param"); // Aqui a variável, pega o valor casteado do context JSP, usando o doBody como parâmetro.
out.println("<h1 align='center'>"+init+"</h1>"); //Imprimir o valor da variavel criado no atributo, usando a tag h1 no centro.
%> <!-- Fim de Scriplet -->
</FormatText> <!-- Aqui é fechada a tag. -->