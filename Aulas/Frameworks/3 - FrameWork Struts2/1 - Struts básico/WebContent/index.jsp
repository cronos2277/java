<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.sendRedirect(request.getContextPath() + "/main.action"); %>
<!-- 
	Aqui ocorre o redirecionamento, em verdade � a �nica coisa que esta p�gina faz. Veja que existe,
uma .action depois do main. Se voc� for olhar dentro da pasta "WebContent", ver� que existe uma p�gina
"main.jsp", esse action � um comando padr�o do Struts, claro que isso pode ser configurado. Ent�o ao
ser executado o "main.action", existe dentro do "struts.xml", localizado na pasta src, l� existe um
campo no xml chamado de "<action name="main">", veja bem l� existe uma a��o com o nome de main, ent�o
ao ser executado o main.action, esta a��o � executada. Dentro desse campo existe o "<result>", que � a
a��o propriamente dita, ou seja o resultado dessa a��o. Nesse caso o "<result>", ele retorna a seguinte
String = "/WEB-INF/pages/main.jsp", ao colocar o nome o diret�rio raiz do projeto, mais o resultado do
retorno do main.action, voc� a url completa, precisando fazer apenas o redirecionamento.
Obs: O m�todo: "request.getContextPath()", � melhor explicado nos coment�rios do index.jsp.
Obs: Para entender melhor o struts, de uma olhada nos coment�rios do "struts.xml".
 -->
</body>
</html>