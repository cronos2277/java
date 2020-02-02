<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tlds/diasem.tld" prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplo de criação de tag</title>
</head>
<body>
Semana de hoje: <t:semana />
<br /><br />
Semana de 20/03/2017: <t:semana data="20/03/2017" />
</body>
</html>