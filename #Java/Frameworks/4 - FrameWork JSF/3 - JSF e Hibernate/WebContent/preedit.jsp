<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pkg.all.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>redirecionando...</title>
</head>
<body>
<!-- 
	Aqui o bean ele é preenchido com os métodos, usando como parâmetro o id vindo do index.jsp. 
	Após que o bean seja reescrito, com base no id clicado, a pagina redireciona para a página
	edit.jsf, ou em caso de erro, redirecione para error.jsf.
-->
<jsp:useBean id="bean" class= "pkg.all.JavaServerFacesBean" scope="session"/>
<% 
try{
bean.setThis_id(Integer.parseInt(request.getParameter("id")));
bean.setThis_name(new Methods().GetByID(bean.getThis_id()).getName());
bean.setThis_born(new Methods().GetByID(bean.getThis_id()).getBorn());
bean.setThis_age(new Methods().GetByID(bean.getThis_id()).getAge());
bean.setThis_address(new Methods().GetByID(bean.getThis_id()).getAddress());
bean.setThis_city(new Methods().GetByID(bean.getThis_id()).getCity());
bean.setThis_function(new Methods().GetByID(bean.getThis_id()).getFunction());
bean.setThis_salary(new Methods().GetByID(bean.getThis_id()).getSalary());
bean.setThis_phone(new Methods().GetByID(bean.getThis_id()).getPhone());
response.sendRedirect("edit.jsf");
}catch(Exception e){Hibernate.Status += "\nErro ao pré-editar: "+e.toString();response.sendRedirect("error.jsf");}
%>

</body>
</html>