package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exemplo5
 */
@WebServlet("/Ex5")
public class Exemplo5 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ServletConfig configuracao = null;

  /**
   * @see Servlet#init(ServletConfig)
   */
  public void init(ServletConfig config) throws ServletException {
    configuracao = config;
    super.init(config);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    ServletContext contexto = configuracao.getServletContext();
    String nome = (String) contexto.getAttribute("nome");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Lendo do Contexto</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h4>Lendo do Contexto</h4><br />");
    out.println("nome: " + nome);
    out.println("<br /><a href='visitantes.jsp'>voltar</a>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}