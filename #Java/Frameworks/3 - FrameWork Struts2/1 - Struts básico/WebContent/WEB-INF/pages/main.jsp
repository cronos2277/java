<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Struts Exemplo</title>
</head>
<body>
<h1>Seja bem Vindo.</h1>
Nome do projeto =  <%= request.getContextPath() %>
<!-- 
	O método "request.getContextPath()", retorna o nome do projeto. Por exemplo se o projeto se chamar
 "NovoProjeto", ele irá retornar a seguinte String "/NovoProjeto". Isso é interessante quando,
 você faz redirecionamento pelo método get, ou precise direcionar o usuario para uma url dentro
 desse mesmo projeto. 
 -->
 <hr>
<h2><a href ="mensagem.action">Clique aqui para ver o exemplo</a></h2>
<!-- 
	Perceba que o sistema não está redirecionando para a página actions.jsp, mas que ao clicar no link
é o conteúdo dela que você verá. Isso acontece, pois quando você clica no link, é executado uma action
no struts.xml, que redireciona o cliente para a página "actions.jsp". O ponto action, está definido como
para executar uma ação no filtro, sendo o que o reconhecimento do struts é identificado assim que o usuario
entra no sistema, pois o filtro está específicado no arquivo "web.xml".
 -->
</body>
</html>