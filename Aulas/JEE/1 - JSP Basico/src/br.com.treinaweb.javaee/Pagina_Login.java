package br.com.treinaweb.javaee;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
@WebServlet("/p_l")
public class Pagina_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ClasseMysql classe = new ClasseMysql();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(classe.Consulta(login,senha)){
			out.println("<html><head><title>Login feito com sucesso!</title></head><body><h1>Login Feito com sucesso!</h1></body></html>");
		}else{out.println("<html><head><title>Usuário ou senha inválido!</title></head><body><h1>"+ClasseMysql.Status+"<br />Usuário: "+login+"<br />Senha: "+senha+"</h1></body></html>");}
	}	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ClasseMysql classe = new ClasseMysql();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if(classe.Consulta(login,senha)){
			out.println("<html><head><title>Login feito com sucesso!</title></head><body><h1>Login Feito com sucesso!</h1></body></html>");
			}else{out.println("<html><head><title>Usuário ou senha inválido!</title></head><body><h1>"+ClasseMysql.Status+"</h1></body></html>");}
	}

}
