package br.com.treinaweb.javaee;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
/**
 * Servlet implementation class Lendo
 */
@WebServlet("/ler")
public class Lendo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ServletConfig configuracao = null; //criando objeto vazio. 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lendo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		configuracao = config;
		super.init(config); //Com essa função, é pego o valor do servlet superior, aonde está salvo os dados do servlet gravando.
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//doGet esse é melhor para leitura e recuperação de dados.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//Objeto contexto pegou o Servlet config do servlet gravar
		ServletContext contexto = configuracao.getServletContext(); 
		//Aqui é casteado para String o valor do objeto contexto com o método getAttribute.
		String nome = (String) contexto.getAttribute("texto");
		out.println("<html><head><title>Lendo dados</title></head><body>");
		out.println("Dados para leitura:"+nome);
		out.println("</body></html>");
		out.close();
	}

}
