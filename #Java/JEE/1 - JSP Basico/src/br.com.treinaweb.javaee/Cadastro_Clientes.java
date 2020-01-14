package br.com.treinaweb.javaee;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class Cadastro_Clientes
 */
@WebServlet("/c_c1")
public class Cadastro_Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String Nome = request.getParameter("nome");
		String Login = request.getParameter("login");
		String Senha = request.getParameter("senha");
		ClasseMysql Sql = new ClasseMysql();
		if(Sql.Cadastro(Nome, Login, Senha)){
			out.println("<html><head><title>Cadastro feito com sucesso!</title></head><body><h1>Cadastro feito com sucesso!</h1></body></html>");
		}else{out.println("<html><head><title>Problemas com o cadastro!</title></head><body><h1>"+ClasseMysql.Status+"</h1></body></html>");};
		
	}

}
