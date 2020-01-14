<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informe os valores.</title>
</head>
<body>
<h3 align="right">Informe um valor para A e B respectivamente</h3><hr>
<s:form action="math.action" method="post">
<s:textfield label="Informe um valor para A" name="num1"></s:textfield>
<s:textfield label="Informe um valor para B" name="num2"></s:textfield>
<s:submit value="Realizar opera��es!"/>
</s:form>
</body>
</html>
<!-- 
Pois bem este � um formul�rio criado pelo pr�prio Struts, ele funciona de maneira semelhante,
ao JavaBeans. 
------------------------------------------------------------------------------------------------
s:textfield label="String" name="Vari�vel referente ao set no Objeto informado no struts.xml"
No caso do textfield, � criado um campo de entrada no formul�rio. no caso ao num1
e num2 se refere aos m�todos setNum1() e setNum2(), no textfield, submit o bot�o com a entrada de 
valores.
------------------------------------------------------------------------------------------------
s:form action="nome da a��o definida no struts.xml" method="O m�todo a ser passado os dados".
 -->