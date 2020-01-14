<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
<h2 align="center"> Acessado pela página</h2>
<hr>
Pelo property.
<s:property value="getText('hello')"/>
<hr>
Pelo text.
 <s:text name = "hello" /> 
 <hr>
 Pela chave 
 <s:textfield key = "hello" />
 <hr> 
 Pela Tag s:i18n
 <s:i18n name = "pkg.package.properties">
      <s:text name = "hello" />
 </s:i18n>
 <hr> <br />
 <h2 align="center"> Acessado pela Classe.</h2>
 <hr>
 <!-- No caso aqui é exibida o conteúdo do método getMensagem, como já explicado anteriormente. -->
 <s:property value="mensagem"/> 
 <hr>
 * Observação, os campos que mostram a tag com 's' mostra, porque trabalha com texto plano.
</body>
</html>