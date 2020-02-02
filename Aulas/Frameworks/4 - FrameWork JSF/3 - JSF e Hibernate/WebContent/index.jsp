<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Inicial</title>
</head>
<body>
<!-- Todo cuidado para importar � pouco, se esquecer do /jsp/,
	tamb�m pode-se importar, no entanto as express�es EL n�o s�o reconhecidas. 
	A importa��o de: http://java.sun.com/jsp/jstl/core -> cont�m suporte a EL.
	A importa��o de: http://java.sun.com/jstl/core -> sem /jsp/ n�o contem suporte a EL.
	-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.List, pkg.all.*, java.util.List" %>
<c:catch var="hibernate">
<!-- A passagem de valores para as tags JSTL, s�o feitas por atributos. -->
<% request.setAttribute("ListPeople", new Methods().GetAll()); %>
<!-- Na classe JavaServerFacesBean repare que � usado mesmo bean, que o criado nesta classe. No caso aqui, esse bean criado, ele s� � usado quando edita-mos um contato. -->
<jsp:useBean id="bean" class="pkg.all.People"/>
<c:out value="${hibernate}"/>
</c:catch>
<table border="1px">
<tr>
<td width="500">C�digo</td>
<td width="500">Nome</td>
<td width="500">Nascimento</td>
<td width="500">Idade</td>
<td width="500">Cidade</td>
<td width="500">Endere�o</td>
<td width="500">Profiss�o</td>
<td width="500">Sal�rio</td>
<td width="500">Telefone</td>
<td width="500">Modificar?</td>
<td width="500">Apagar?</td>
</tr>
<c:forEach items="${ListPeople}" var="obj" end="${ListPeople.size()}"> <!-- Valores passados por atributos, s�o pegos por express�es EL. -->
<tr>
<td width="500"><c:out value="${obj.getCode()}"/></td> <!-- A express�o el de obj, corresponde ao obj do la�o. a men��o de vari�veis se faz via String, o uso de seu conte�do, se faz via express�o EL. -->
<td width="500"><c:out value="${obj.getName()}"/></td>
<td width="500"><c:out value="${obj.getBorn()}"/></td>
<td width="500"><c:out value="${obj.getAge()}"/></td>
<td width="500"><c:out value="${obj.getCity()}"/></td>
<td width="500"><c:out value="${obj.getAddress()}"/></td>
<td width="500"><c:out value="${obj.getFunction()}"/></td>
<td width="500"><c:out value="${obj.getSalary()}"/></td>
<td width="500"><c:out value="${obj.getPhone()}"/></td>
<td width="500">
<form method="post" action="preedit.jsp">
<input type="hidden" value="${obj.getCode()}" name="id">
<input type="submit" name="form" value="Alterar!">
</form>
</td>
<td width="500"><form method="post" action="del.jsf"><input type="hidden" value="${obj.getCode()}" name="idrem"><input type="submit" name="sbm" value="Excluir!"><input type="hidden" name="nomerem" value="${obj.getName()}"></form></td>
</tr>
</c:forEach>
</table>
<a href= "new.jsf">Novo Usu�rio</a>
</body>
</html>