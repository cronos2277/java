<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela de Login</title>
</head>
<body>
      <form action="verificarlogin.jsp" method="post">
        <div style="text-align:center">
            <div>
              <table style="border:0px">
                  <tr>
                      <td align="right">Login:</td>
                      <td align="left"><input type="text" name="login"></td>
                  </tr>
                  <tr>
                      <td align="right">Senha:</td>
                      <td align="left"><input type="password" name="senha"></td>
                  </tr>
                  <tr>
                      <td colspan="2" align="center"><input type="submit" value="Entrar"></td>
                  </tr>
              </table>
              </div>
        </div>
      </form>
</body>
</html>