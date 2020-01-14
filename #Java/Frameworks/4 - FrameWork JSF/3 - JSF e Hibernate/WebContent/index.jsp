<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Inicial</title>
</head>
<body>
<!-- Todo cuidado para importar é pouco, se esquecer do /jsp/,
	também pode-se importar, no entanto as expressões EL não são reconhecidas. 
	A importação de: http://java.sun.com/jsp/jstl/core -> contém suporte a EL.
	A importação de: http://java.sun.com/jstl/core -> sem /jsp/ não contem suporte a EL.
	-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.List, pkg.all.*, java.util.List" %>
<c:catch var="hibernate">
<!-- A passagem de valores para as tags JSTL, são feitas por atributos. -->
<% request.setAttribute("ListPeople", new Methods().GetAll()); %>
<!-- Na classe JavaServerFacesBean repare que é usado mesmo bean, que o criado nesta classe. No caso aqui, esse bean criado, ele só é usado quando edita-mos um contato. -->
<jsp:useBean id="bean" class="pkg.all.People"/>
<c:out value="${hibernate}"/>
</c:catch>
<table border="1px">
<tr>
<td width="500">Código</td>
<td width="500">Nome</td>
<td width="500">Nascimento</td>
<td width="500">Idade</td>
<td width="500">Cidade</td>
<td width="500">Endereço</td>
<td width="500">Profissão</td>
<td width="500">Salário</td>
<td width="500">Telefone</td>
<td width="500">Modificar?</td>
<td width="500">Apagar?</td>
</tr>
<c:forEach items="${ListPeople}" var="obj" end="${ListPeople.size()}"> <!-- Valores passados por atributos, são pegos por expressões EL. -->
<tr>
<td width="500"><c:out value="${obj.getCode()}"/></td> <!-- A expressão el de obj, corresponde ao obj do laço. a menção de variáveis se faz via String, o uso de seu conteúdo, se faz via expressão EL. -->
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
<a href= "new.jsf">Novo Usuário</a>
</body>
</html>