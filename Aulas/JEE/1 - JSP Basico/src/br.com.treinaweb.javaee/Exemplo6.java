package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exemplo6
 */
@WebServlet(name = "Exemplo6", urlPatterns = {"/Ex6"})
public class Exemplo6 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Enumeration<String> enumeracao = request.getHeaderNames();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet Exemplo6</title>");
    out.println("</head>");
    out.println("<body>");
    while(enumeracao.hasMoreElements()){
      String header = (String) enumeracao.nextElement();
      out.println("<b>" + header + "</b>:" + request.getHeader(header) + "<hr>");
    }
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}