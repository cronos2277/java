<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="data" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
    <c:if test="${idioma == null}">
        <fmt:setBundle basename="br.com.treinaweb.javaee.Recurso" var="idioma" scope="page" />
    </c:if>
    <form>
        <table border="0" align="center">
            <tr><td colspan="2" align="center"><font size="3" color="blue">
                <fmt:message key="login.apresentacao" bundle="${idioma}" />
                </font>
            </td></tr>
            <tr>
                <td align="right"><fmt:message key="login.usuario" bundle="${idioma}" /></td>
                <td align="left"><input type="text" name="login" size="25"></td>
            </tr>
            <tr>
                <td align="right"><fmt:message key="login.senha" bundle="${idioma}" /></td>
                <td align="left"><input type="password" name="senha" size="15"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="OK"></td>
            </tr>
            <tr>
            <td colspan="2" align="center">
                <font color="blue">
                <fmt:formatDate value="${data}" timeStyle="long" dateStyle="long" />
                </font>
            </td>
          </tr>
        </table>
    </form>
    <%//No caso essa jsp, ela procura por uma classe chamada Recurso. Note que nos pacotes, tem _en, _fr, _pt %>
    <%//Nessas classes, cada uma vai ser rodada, de acordo com a configuração de idiomas do navegador. %>
</body>
</html>