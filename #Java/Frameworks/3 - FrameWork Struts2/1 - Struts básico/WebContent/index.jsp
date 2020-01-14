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
	Aqui ocorre o redirecionamento, em verdade é a única coisa que esta página faz. Veja que existe,
uma .action depois do main. Se você for olhar dentro da pasta "WebContent", verá que existe uma página
"main.jsp", esse action é um comando padrão do Struts, claro que isso pode ser configurado. Então ao
ser executado o "main.action", existe dentro do "struts.xml", localizado na pasta src, lá existe um
campo no xml chamado de "<action name="main">", veja bem lá existe uma ação com o nome de main, então
ao ser executado o main.action, esta ação é executada. Dentro desse campo existe o "<result>", que é a
ação propriamente dita, ou seja o resultado dessa ação. Nesse caso o "<result>", ele retorna a seguinte
String = "/WEB-INF/pages/main.jsp", ao colocar o nome o diretório raiz do projeto, mais o resultado do
retorno do main.action, você a url completa, precisando fazer apenas o redirecionamento.
Obs: O método: "request.getContextPath()", é melhor explicado nos comentários do index.jsp.
Obs: Para entender melhor o struts, de uma olhada nos comentários do "struts.xml".
 -->
</body>
</html>