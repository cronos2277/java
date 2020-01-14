package br.com.treinaweb.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class Math
 */
@WebServlet("/math")
public class Math extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  num = Integer.parseInt(request.getParameter("texto"));
		int x = 0;
		PrintWriter saida = response.getWriter();
		saida.println("<html><head><title>Resposta:</title></head><body>");
		for(int i=1;i<=num;i++){
		if(num % i == 0){saida.println("O número "+i+" é divisível por: "+num+" || ");x++;}}
		if(x<3){saida.println("<h3>O número é primo!</h3>");}
		saida.println("</body></html>");
		saida.close();

}
}
