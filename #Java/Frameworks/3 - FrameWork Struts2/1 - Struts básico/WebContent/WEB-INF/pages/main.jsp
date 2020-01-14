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
	O m�todo "request.getContextPath()", retorna o nome do projeto. Por exemplo se o projeto se chamar
 "NovoProjeto", ele ir� retornar a seguinte String "/NovoProjeto". Isso � interessante quando,
 voc� faz redirecionamento pelo m�todo get, ou precise direcionar o usuario para uma url dentro
 desse mesmo projeto. 
 -->
 <hr>
<h2><a href ="mensagem.action">Clique aqui para ver o exemplo</a></h2>
<!-- 
	Perceba que o sistema n�o est� redirecionando para a p�gina actions.jsp, mas que ao clicar no link
� o conte�do dela que voc� ver�. Isso acontece, pois quando voc� clica no link, � executado uma action
no struts.xml, que redireciona o cliente para a p�gina "actions.jsp". O ponto action, est� definido como
para executar uma a��o no filtro, sendo o que o reconhecimento do struts � identificado assim que o usuario
entra no sistema, pois o filtro est� espec�ficado no arquivo "web.xml".
 -->
</body>
</html>