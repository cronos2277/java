<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body bgcolor="lightgray">
<jsp:useBean id="bean" class="pkg.java.JavaBeans" />
<jsp:setProperty property="*" name="bean"/>
<br /><br /> <br /> <br />
<br /><br /> <br /> <br />
<h1 align="center"> Verifique se os dados estão certos.</h1>
<form action="new" method="post">
<table align = "center">
<tr><td>Informe um  Nome: <input type="text" name="nome" value="${bean.nome}"></td></tr>
<tr><td>Informe um  Login: <input type="text" name="login" value="${bean.login}"></td></tr>
<tr><td>Informe uma Senha: <input type="password" name="senha" value="${bean.senha}"></td></tr>
<tr><td><input type="submit" name="enviar" value="Sim Estão certos!"></td></tr>
</table>
</form>
</body>
</html>
<!-- 
		Essa é a página para a confirmação dos cadastros, essa página pega os valores
 	 da classe instanciada de JavaBeans.java. Quando confirmado os dados sao enviados
 	 via post para o servlet Cadastro.
-->