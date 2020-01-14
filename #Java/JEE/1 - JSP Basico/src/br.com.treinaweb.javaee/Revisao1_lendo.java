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


@WebServlet("/rev1")
public class Revisao1_lendo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig conf1 = null;
	private ServletConfig conf2 = null;
	private ServletConfig conf3 = null;
	public void init(ServletConfig config) throws ServletException {
	conf1 = config;	
	conf2 = config;
	conf3 = config;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String nome = request.getParameter("nome");
	int Idade = 0;
	try{Idade = Integer.parseInt(request.getParameter("idade"));}catch(Exception e){out.println("Valor para idade inválido");}
	String idade = Integer.toString(Idade);
	String cidade = request.getParameter("cidade");
	ServletContext nome_f = conf1.getServletContext();
	ServletContext idade_f = conf2.getServletContext();
	ServletContext cidade_f = conf3.getServletContext();
	nome_f.setAttribute("Nome", nome);
	idade_f.setAttribute("Idade", idade);
	cidade_f.setAttribute("Cidade", cidade);
	out.println("<html><head><title>Dados gravados.</title></head><body><h1><a href = 'http://localhost:8080/TreinaWeb/ref11'><center><b> Clique aqui para continuar</b></center></h1></body></html>");
	out.close();
	}

}
