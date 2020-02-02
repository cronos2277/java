<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="br.com.treinaweb.javaee.Usuario" />
    <jsp:setProperty name="user" property="*" />
    <form method="POST">
        <table style="border:0px; width:300px" >
            <tr bgcolor="whitesmoke"><td width="100"></td><td width="200"></td></tr>
            <tr><td align="right">Nome: </td><td><input type="text" name="nome"></td></tr>
            <tr><td align="right">Login: </td><td><input type="text" name="login"></td></tr>
            <tr><td align="right">Senha: </td><td><input type="password" name="senha"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" name="incluir" value="Incluir"></td></tr>
        </table>
    </form>
    <%
         if(request.getParameter("incluir") != null){
           user.save();
         }
    %>
    <table style="border:0px; width:300px; background:whitesmoke">
        <tr><td>Status:</td><td><jsp:getProperty name="user" property="status" /></td></tr>
    </table>
</body>
</html>