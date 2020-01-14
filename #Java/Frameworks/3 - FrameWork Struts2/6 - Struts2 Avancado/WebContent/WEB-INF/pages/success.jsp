<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="success.page"/></title>
</head>
<body>
<h1><s:text name="success.client"/> <s:property value="nome"/> <s:text name="success.message"/> </h1>
<h1 align="center"><a href="main.action"><s:text name="success.link"/></a></h1>
</body>
</html>