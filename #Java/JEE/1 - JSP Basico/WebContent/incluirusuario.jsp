<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Usuário</title>
</head>
<body>
  <fieldset style="width: 150px">
    <legend>Usuário</legend>
    <form action="salvarusuario.jsp" method="POST">
       <div style="font-weight: bold;">Nome:</div>
       <div>
          <input type="text" name="nome" value="" />
       </div>
       <div style="font-weight: bold;">Login:</div>
       <div>
          <input type="text" name="login" value="" />
       </div>
       <div style="font-weight: bold;">Senha:</div>
       <div>
          <input type="password" name="senha" value="" />
       </div>
       <div>
          <input type="submit" value="Incluir" name="incluir" />
       </div>
    </form>
  </fieldset>
</body>
</html>