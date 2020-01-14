package pkg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkg.java.MySQL;
/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/new")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MySQL sql = new MySQL();
	PrintWriter out = response.getWriter();
	out.print("<html><head><title>Cadastrando"+request.getParameter("nome")+"</title></head><body>");
	
		if(sql.Cadastro(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"))){
			out.println("<h1> Cadastro efetuado com sucesso. </h1><br />");
		}else{out.println("<h1> "+MySQL.Status+" </h1><br />");}
		out.println("</body></html>");
	}

}
//Servlet para cadastro, aqui não existe método doGet, só post. Isso aumenta a 
//segurança, pois o doGet exibe os valores na barra de títulos. Veja que é instanciado
// a classe MySql e a classe PrintWriter. A primeira é usado para se conectar ao
//SGBD, a segunda é para imprimir dados na página. o objeto PrintWrite pega o valor
//response.getWriter(), "que é a resposta do servidor"."pegar atributos do getter Write()"
//Se o cadastro for efetuado o objeto out, explicado a sua criação acima, exibe uma
//mensagem de sucesso na tela, caso não é exibido o motivo. Todos os erros que decorrentes
//dos métodos da classe MySQL são informados, em uma String estática chamada Status.