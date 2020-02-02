<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.treinaweb.javaee.Usuario, br.com.treinaweb.javaee.UsuarioDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verificar usuário</title>
</head>
<body>
  <%
    Usuario usuario = new Usuario();
    usuario.setLogin(request.getParameter("login"));
    usuario.setSenha(request.getParameter("senha"));
    UsuarioDAO dao = new UsuarioDAO();
    usuario = dao.verificar(usuario);
    if (usuario.getIdUsuarios() > 0){
        out.println("Login correto para o usuário com o idusuario: " + usuario.getIdUsuarios());
        Cookie c1 = new Cookie("login", request.getParameter("login"));
            c1.setMaxAge(60*60); //1 Hora
            response.addCookie(c1);
    }else{
        out.println("Login incorreto ");
    }
  %>
</body>
</html>