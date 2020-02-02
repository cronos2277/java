package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exemplo1
 */
@WebServlet(
        name = "Exemplo1",
        urlPatterns = { "/Ex1"},
        initParams = {
            @WebInitParam(name = "mensagem", value = "Servlet Exemplo1")
        })
public class Exemplo1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String mensagem;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        this.mensagem = config.getInitParameter("mensagem");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Exemplo1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Primeiro exemplo de Servlet</h1>");
        out.println("<h3>" + mensagem + "</h3>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}