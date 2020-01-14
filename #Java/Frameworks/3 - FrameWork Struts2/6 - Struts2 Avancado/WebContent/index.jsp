<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="hibernate.*, pkg.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="index.page"/></title>
</head>
<body>
<s:form action="enter.action" method="post">
<table align="center">
<tr><td width="100"><s:textfield name="login" key="user.index" required="true"/></td></tr>
<tr><td width="100"><s:password name="senha" key="pass.index" required="true"/></td></tr>
<tr><td><s:submit key="submit.index"/></td></tr>
</table>
</s:form>
<hr>
<h4 align="center"><a href="form.action"><s:text name="msn.index"/></a></h4><br />
<h4 align="center"><s:text name="language"/></h4>
</body>
</html>