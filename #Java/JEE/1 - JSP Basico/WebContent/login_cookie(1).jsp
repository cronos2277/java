<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Cookie</title>
</head>
<body bgcolor="lightgray">
<br /> <br /> <br /><br /> <br /> <br /><br /> <br /> <br />
<h3 align="center">P�gina de login</h3>
<hr>
<br />
<form action="L_C_S" method = "post">
<table align="center">
<tr>
<td align="left">Login: </td>
<td><input type="text" name="login"></td>
<td></td>
<td align="right">Senha: </td>
<td><input type="password" name="pwd"></td>
<td><input type="submit" name="enviar" value="Entrar!"></td>
</tr>
</table>
</form>
<br />
<hr>
<center><%= new java.util.Date() %></center>
<%
String Name = null; //Aqui a String auxiliar do objeto cookie inicia vazia.
Cookie[] cookie = request.getCookies(); //nesta linha � pego os valores de todos os cookies,
//salvo na m�quina do cliente. e � insirido cada valor dentro de um array objeto do tipo cookie.

if(cookie != null){ //caso o array do tipo objeto cookie n�o esteja vazio.
	for(Cookie cookies: cookie){ //ForEach do objeto cookie.
	if(cookies.getName().equals("user")) //Aqui � feita uma compara��o, se algum cookie da m�quina
	//do cliente for igual ao usu�rio criado pelo servlet, ent�o o valor � escrito na string abaixo.
	{Name = cookies.getValue();}	
	}
}
//No if, se a String tiver algum valor � redirecionado ao servlet. Vale lembrar que no servlet, deve ter
//um m�todo get para que possa ser feito o login no servlet. Para entender bem o funcionamento de um
//Cookie entenda a camada 5 do modelo OSI, a camada de sess�o, assim voc� entender� como o servidor
//identifica cada usu�rio por meio de um cookie.
if(Name != null){response.sendRedirect("L_C_S");}
%>
</body>
</html>