<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplos de Scripts JSP</title>
</head>
<body>
<%!//Declaraçõe:. Aqui são declaradas funções ou qualquer outra coisa, que não poderia ser declarada dentro de uma funcao static, no java SE.
double a = 1; double b = 1; double c = 0;
public double soma(double d, double e){ double f = d + e; return f;}
public double subt(double d, double e){ double f = d - e; return f;}
public double mult(double d, double e){ double f = d * e; return f;}
public double divi(double d, double e){ double f = d / e; return f;}
%>

<center><h2> Valor de A: <%= a %> || Valor de B: <%= b //Expressões: Tudo declarado dentro dessas tags
//tem o seu valor automaticamente processadas nas páginas.
%></h2></center>
<center>
<table border="1px">
<tr>
<%//ScriptLets: Aqui são colocados os códigos java. A forma de funcionamento é semelhante as Expressões,
 //no entanto aqui é mais focado para ler códigos java ao invés de substituir e printar os dados. %>
<td>Operação = A + B:</td>
<td><% c = soma(a,b);out.println(c); %></td></tr>
<tr><td>Operação = A - B:</td>
<td><% c = subt(a,b);out.println(c); %></td></tr>
<tr><td>Operação = A x B:</td>
<td><% c = mult(a,b);out.println(c); %></td></tr>
<tr><td>Operação = A / B:</td>
<td><% c = divi(a,b);out.println(c); %></td></tr>
</table>
</center>
</body>
</html>