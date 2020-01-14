<%@ taglib prefix="s" uri="/struts-tags" %> <!-- Se faz necess�rio importar esta biblioteca! -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo com a��es.</title>
</head>
<body>
<h3 align="center"><s:property value="mensagem"/></h3>
<!-- 
	No caso voc� deve colocar o nome da v�riavel, contida na classe referenciada no "struts.xml".
Repare que no struts.xml existe uma action, com um campo class. A class al� � o par�metro, ou seja
a classe que � usada como par�metro. "<action name="String" class="String">", o class corresponde a
classe a ser usada aqui, e o name o nome da a��o, ou seja a classe definida no campo class, ela est�
setada para ser usada aqui. Dentro dessa classe existe um atributo, uma vari�vel do tipo string chamado
mensagem. Essa vari�vel ela � usada como par�metro do "<s:property value="o nome da variavel"/>".
Essa classe ela est� referenciada a Actions.java, dentro dessa classe tem uma String com o nome de mensagem,
como � o conte�do dessa mensagem que queremos ler, � ela vamos informar como par�metro do <s:property value="String"/>.
	No caso todas as vari�veis a ser usada segue o mesmo padr�o do JavaBeans, elas devem ser do tipo privada,
e se acaso for resgatado o seu valor, as mesmas devem ter um m�todo ".get()". Como aqui o par�metro � a mensagem,
ser� liga n�o a vari�vel privada e sim o m�todo "getMensagem()". Fique atento a isso. N�o precisei importar
aquela classe, pois quem lida com a sua importa��o � o struts.xml, pois ela � usada como par�metro na action.	 
 -->
</body>
</html>