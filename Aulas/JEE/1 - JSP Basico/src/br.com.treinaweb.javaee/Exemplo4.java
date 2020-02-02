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
 * Servlet implementation class Exemplo4
 */
@WebServlet("/Ex4")
public class Exemplo4 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ServletConfig configuracao = null;
  /**
   * @see Servlet#init(ServletConfig)
   */
  public void init(ServletConfig config) throws ServletException {
    configuracao = config;
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String nome = request.getParameter("nome");
    ServletContext contexto = configuracao.getServletContext();
    contexto.setAttribute("nome",nome);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Gravando no Contexto</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h4>Gravando no Contexto</h4><br>");
    out.println("Gravando no contexto:" + contexto.getAttribute("nome"));
    out.println("<br><a href='Ex5'>Verificar</a>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

}