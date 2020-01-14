<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@Produces com GET e POST</title>
</head>
<body>
<%
String IP = "localhost"; //Defina aqui o IP aonde está localizado o recurso Webservice
String TCP = "8080"; //Defina aqui a porta TCP do mesmo.
String NomeProjeto = "Treinaweb"; //Define aqui o nome do seu projeto.
String WebXML = "usr"; //Define aqui o conteúdo da tag <url-pattern>/"Você vai digita o que tem entre as barras"/</urlpattern> do seu arquivo "web.xml".Obs devido a formatação abaixo, exclua as barras ao definir o valor aqui.
String Path[] = {"/Jersey/Get/Produces","/Jesey/Post/Produces"};

//Primeiro Formulário, O método é Get e a Classe é o JerseyGetProduces.java. O mesmo está formatado para exibir dados em HTML.
out.println("<br /> <hr><h1 align='center'>Formulario: @Path("+Path[0]+")</h1><hr>");
out.println("<form action='http://"+IP+":"+TCP+"/"+NomeProjeto+"/"+WebXML+""+Path[0]+"'><table align='center'>");
out.println("<tr><td>Digite um texto: </td>");
out.println("<td><input type='text' name='textoGet'</td>"); //o valor do parâmetro name aqui, deve ser identico ao usado pelo @QueryParam, na classe java.
out.println("<td><input type='submit' name='enviar' value='Enviar!'></td></tr>");
out.println("</table></form>");

//Segundo Formulário. O método é POST e a Classe é a JerseyPostProduces.java. O mesmo está formatado para exibir acentos.
out.println("<br /> <hr><h1 align='center'>Formulario: @Path("+Path[1]+")</h1><hr>");
out.println("<form action='http://"+IP+":"+TCP+"/"+NomeProjeto+"/"+WebXML+""+Path[1]+"' method='post'><table align='center'>");
out.println("<tr><td>Digite um Nome: </td><td>Digite uma Frase: </td></tr><tr>");
//o valor do parâmetro name aqui, deve ser identico ao usado pelo @FormParam, na classe java.
out.println("<td><input type='text' name='nome'</td> <td><input type='text' name='frase'</td>");
out.println("<td><input type='submit' name='enviar' value='Enviar!'>");
out.println("</tr></table></form>");
%> 
</body>
</html>