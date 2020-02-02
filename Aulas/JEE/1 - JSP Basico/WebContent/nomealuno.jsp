<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action e JavaBean</title>
</head>
<body>
  <jsp:useBean id="alun" class="br.com.treinaweb.javaee.Alunos" />
  <jsp:setProperty name="alun" property="*" />
    <form method="POST">
        <table style="border:0px; width:300px">
            <tr bgcolor="whitesmoke"><td width="100"></td><td width="200"></td></tr>
            <tr><td align="right">Nome: </td><td><input type="text" name="nome"></td></tr>
            <tr><td align="right">Endereço: </td><td><input type="text" name="endereco"></td></tr>
            <tr><td align="right">Cep: </td><td><input type="text" name="cep"></td></tr>
            <tr><td align="right">Cidade: </td><td><input type="text" name="cidade"></td></tr>
            <tr><td align="right">Estado: </td><td><input type="text" name="estado"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="Incluir"></td></tr>
        </table>
    </form>
    <table style="border:0px; width:300px">
        <tr bgcolor="whitesmoke"><td width="100"></td><td width="200"></td></tr>
        <tr><td align="right">Nome: </td><td><jsp:getProperty name="alun" property="nome" /></td></tr>
        <tr><td align="right">Endereço: </td><td><jsp:getProperty name="alun" property="endereco" /></td></tr>
        <tr><td align="right">Cep: </td><td><jsp:getProperty name="alun" property="cep" /></td></tr>
        <tr><td align="right">Cidade: </td><td><jsp:getProperty name="alun" property="cidade" /></td></tr>
        <tr><td align="right">Estado: </td><td><jsp:getProperty name="alun" property="estado" /></td></tr>
    </table>
</body>
</html>