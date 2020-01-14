<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo utilizando declarações</title>
</head>
<body>
  <%! String site = "www.treinaweb.com.br"; %>
  <%! public String getSite() { return site; } %>
  <%
   out.write("Curso de Java EE disponível em: " + getSite());
   %>
</body>
</html>