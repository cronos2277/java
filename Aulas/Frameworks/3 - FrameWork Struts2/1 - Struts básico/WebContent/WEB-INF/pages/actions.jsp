<%@ taglib prefix="s" uri="/struts-tags" %> <!-- Se faz necessário importar esta biblioteca! -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo com ações.</title>
</head>
<body>
<h3 align="center"><s:property value="mensagem"/></h3>
<!-- 
	No caso você deve colocar o nome da váriavel, contida na classe referenciada no "struts.xml".
Repare que no struts.xml existe uma action, com um campo class. A class alí é o parâmetro, ou seja
a classe que é usada como parâmetro. "<action name="String" class="String">", o class corresponde a
classe a ser usada aqui, e o name o nome da ação, ou seja a classe definida no campo class, ela está
setada para ser usada aqui. Dentro dessa classe existe um atributo, uma variável do tipo string chamado
mensagem. Essa variável ela é usada como parâmetro do "<s:property value="o nome da variavel"/>".
Essa classe ela está referenciada a Actions.java, dentro dessa classe tem uma String com o nome de mensagem,
como é o conteúdo dessa mensagem que queremos ler, é ela vamos informar como parâmetro do <s:property value="String"/>.
	No caso todas as variáveis a ser usada segue o mesmo padrão do JavaBeans, elas devem ser do tipo privada,
e se acaso for resgatado o seu valor, as mesmas devem ter um método ".get()". Como aqui o parâmetro é a mensagem,
será liga não a variável privada e sim o método "getMensagem()". Fique atento a isso. Não precisei importar
aquela classe, pois quem lida com a sua importação é o struts.xml, pois ela é usada como parâmetro na action.	 
 -->
</body>
</html>