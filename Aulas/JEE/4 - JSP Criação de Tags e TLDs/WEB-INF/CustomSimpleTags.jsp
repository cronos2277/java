<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="simples" uri="WEB-INF/tlds/EstudoTagSimples.tld" %>
    <%@ taglib prefix="data" uri="WEB-INF/tlds/PrintData.tld" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="math" uri="WEB-INF/tlds/Matematica.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tags Customizadas sem corpo</title>
</head>
<body>
<h3 align="center"> Exemplo de Tags</h3><br />
<hr>
<i>Tag comum de texto em formato String: </i>&nbsp &nbsp &nbsp<b><simples:tsimple/></b>
<hr>
<i>Instanciado do objeto Date e transformado em String: </i>&nbsp &nbsp &nbsp<b><data:data/></b>
<hr>
<jsp:useBean id="user" class="pkg.tag.simple.CustomTagAndJavabeans" scope="page"/>
<jsp:setProperty property="*" name="user"/>
<br /><br /> <br />
<h3 align="right">JavaBeans em mescla com tags Customizada Jstl</h3>
<form method="post">
<table align="center">
<tr>
<td>Digite um valor para A: <input type="text" name="alpha"></td>
<td>Digite um valor para B: <input type="text" name="beta"></td>
<td><input type="submit" name="enviar" value="enviar"></td>
</tr>
</table>
</form>
<hr>
<c:if test="${user.enviar != null}">
<math:math/><hr>
A: <c:out value="${user.alpha}"></c:out>
B: <c:out value="${user.beta}"></c:out>
</c:if>
<hr> Verifique os arquivos dentro da pasta src, tags, tlds, para entender melhor. <hr>
</body>
</html>