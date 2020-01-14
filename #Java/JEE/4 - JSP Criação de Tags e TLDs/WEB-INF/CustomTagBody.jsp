<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="corpo" uri="/WEB-INF/tlds/Corpo.tld" %>  
  <%@ taglib prefix="raiz" uri="/WEB-INF/tlds/Raiz.tld" %>
  <%@ taglib prefix="FormaTexto" uri="/WEB-INF/tlds/Concatenar.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primeira tag com corpo</title>
</head>
<body>
<corpo:show>Olá Mundo</corpo:show>
<hr>
Raiz Quadrada:  <raiz:sqrt>16</raiz:sqrt>
<hr>
<FormaTexto:edit>O][l?á M!u#$%n|\/d;.,~^o ]</FormaTexto:edit>
<br /> <br />
<FormaTexto:edit>O texto entre essas tags, excluí os caracteres, que não são do alfabeto brasileíro, isso incluí acentos, como virgula, pontos, numeros,etc... Apenas as letras são impressas, Além disso os acentos não são afetados: Avô, joão, família, caçula, lingüiça</FormaTexto:edit>
<hr> Verifique os arquivos dentro da pasta src, tags, tlds, para entender melhor. <hr>
</body>
</html>