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
/**
 * Servlet implementation class Gravar
 */
@WebServlet("/gravar")
public class Gravar extends HttpServlet {
	private static final long serialVersionUID = 1L;
//Deve-se criar o ServletConfig aqui, e setar os seus dados iniciais como null.	
	private ServletConfig configuracao_inicial = null; 

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		configuracao_inicial = config; //Dando valores para o objeto ServletConfig.
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//O método deve ser o doPost, fique atento a isso o doPost, é mais usado para escrever dados usando o servlet.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String resposta = request.getParameter("texto"); //Pegando o valor do formulario do gravando.jsp
		PrintWriter out = response.getWriter();
		//Aqui é criado o objeto contexto, e passado os valores do ServletConfig.
		ServletContext contexto = configuracao_inicial.getServletContext();
		//Aqui é setado um valor para o ServletConfig, usando uma chave texto com a String resposta como parametro.
		contexto.setAttribute("texto", resposta);
		out.println("<html><head><title>Gravado!</title></head><body>");
		//contexto.getAttribute() serve para recuperar o valor e exibir o conteúdo salvo pelo servlet.
		out.println("Você digitou: "+resposta+"<br>Foi gravado, "+contexto.getAttribute("texto")+"<br>Clique aqui para confirmar: <a href='ler'>Verificar </a>'");
		out.println("</body></html>");
		out.close();
	}

}
