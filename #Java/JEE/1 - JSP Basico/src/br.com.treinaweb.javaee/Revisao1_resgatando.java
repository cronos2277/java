package br.com.treinaweb.javaee;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet("/ref11")
public class Revisao1_resgatando extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig conf1 = null;
	private ServletConfig conf2 = null;
	private ServletConfig conf3 = null;
	
	public void init(ServletConfig config) throws ServletException {
		conf1 = config;
		conf2 = config;
		conf3 = config;
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext contexto = conf1.getServletContext();
		String nome = (String) contexto.getAttribute("Nome"); 
		contexto = conf2.getServletContext();
		String idade = (String) contexto.getAttribute("Idade");
		contexto = conf3.getServletContext();
		String cidade = (String) contexto.getAttribute("Cidade");
		out.println("<html><head><title> Dados do cliente </title></head><h2>Dados do cliente "+nome+"</h2><body>");
		out.println("<table border='1px'<tr><td>Nome:</td><td>"+nome+"</td></tr>");
		out.println("<tr><td>Idade:</td><td>"+idade+"</td></tr>");
		out.println("<tr><td>Cidade:</td><td>"+cidade+"</td></tr>");
		out.println("</table><center><a href='http://localhost:8080/TreinaWeb/revisao1.jsp'> Voltar para a página de cadastro</a></center></body></html>");
		out.close();
	}

}
