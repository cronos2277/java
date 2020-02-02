<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="numero" type = "Double" required="false" %>
<jsp:doBody var="tmp"/>
<math>
<%
numero = Double.parseDouble((String) jspContext.getAttribute("tmp"));
numero = Math.sqrt(numero);
out.println("A raiz quadrada de "+(String) jspContext.getAttribute("tmp")+", é: "+numero);
%>
</math>
<!-- 
Muito bem, inicialmente temos o cabeçalho na linha 1, informando o cabeçalho e a
codificação dos caractéres da página.

Na linha 2 temos o atributo, com um nome, um tipo, que por padrão é String, caso 
não seja específicado um tipo e o required que está setado falso. Se o required
fosse verdadeiro o valor seria obrigatório, no caso não é obrigado a ter valor
entre as tags, evitando de acontecer erros quando isso acontece.

Na linha 3 temos, o jsp:doBody, contendo apenas a var. No eclipse por padrão, essa
tag tem corpo, mais assim também é válido. O valor de var será usado como parâmetro
quando for pegar um dado casteado do jspContext.

Na linha 4 a tag própriamente dita. No jsp é informado a tagdir, que vai ter um prefixo
no jsp a coisa funcionará mais ou menos assim. 
<prefixo:o que estiver aqui> Dados a serem processados </prefixo:o que estiver aqui>
No nosso exemplo, se por um acaso o prefix fosse tag, seria <tag:math></tag:math>

Na linha 5 temos o processamento dos valores dentro das tags. Na linha 6, temos o
Objeto jspContext, sendo casteado para um String. Ou seja o seu valor em jspContext
é convertido para texto simples. Depois temos uma transformação desse String para
um valor double. Alí o texto x, cuja o valor númerico é zero, sendo x qualquer numero,
foi convertido para um double, ou seja x passou a ter um valor. Esse processo se difere
de castear. Castear vem de Casting, que significa modelar.

Na linha 7 é extraída a raiz quadrada e na linha 8 os dados são exibidos, pelo 
out.print(); Esse método só trabalha com Strings.
 --> 

