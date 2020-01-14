<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo do uso do Try Catch no JSTL</title>
</head>
<body>
<c:catch var="erro">
${5/0}
<c:out value="${erro}"></c:out>
</c:catch>
<br /><hr>
Um exemplo do uso do try catch. A var é aonde é armazendado a mensagem de erro.
</body>
</html>