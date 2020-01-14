<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Olá Mundo.</title>
</head>
<body>
<s:form action="print.action" method="post">
<table border="2px">
<tr><td>
<!-- O 'label' corresponde ao nome a ser impresso na tela. 'list' é um array privado de String,
 no formulário do Struts, 'name' = o nome da String a receber o valor informar o seu valor. -->
<!--  Caso 'required' seja 'true', se torna obrigatorio que o usuário escolha uma opção -->
<s:radio label="Radio Botão" list="radiobutton" name="radio" required="true"/>
</td></tr>
<tr><td>
<s:checkboxlist list="CheckBoxList" label="CheckBoxList" name="SelectedCheckBoxList"/>
</td></tr>
<tr><td>
<!-- 'size' corresponde ao tamanho do campo. -->
<s:file label="Um campo File" name="file1" size="30"/>
</td></tr>
<tr><td>
<s:select list="select" name="sel" label="Primeiro Select" size="2"/>
</td></tr>
<tr><td>
<!-- emptyOption se verdadeiro, por padrão a opção fica vazia, se falso é selecionado a primeira opção. -->
<s:select list="select2" name="sel2" label="Segundo Select" size="1" emptyOption="true"/>
</td></tr>
<tr><td>
<s:password label="Campo PassWord" name="pass" size="10"/>
</td></tr>
<tr><td>
<!-- fieldValue é o valor a ser passado, para a String check. Caso fieldValue seja omitido é passado a String o valor True. -->
<s:checkbox name="check" fieldValue="CheckOk!" label="CheckBox Simples" />
</td></tr>

<tr><td>
<s:submit value="Continuar!"/>
</td></tr>
</table>
</s:form>
</body>
</html>