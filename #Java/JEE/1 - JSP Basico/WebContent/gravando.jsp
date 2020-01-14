<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
//A passagem dos dados ao servlet, deve ser pelo método post, quando se passar dados para ser gravado
<form action="gravar" name="formulario" method="post">
<input type="text" name="texto">
<input type="submit">
</form>
</body>
</html>