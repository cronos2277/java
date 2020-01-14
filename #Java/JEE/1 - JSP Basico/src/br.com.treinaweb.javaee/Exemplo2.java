package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exemplo2
 */
@WebServlet("/Ex2")
public class Exemplo2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tela de Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h4>Obtendo dados do formulário</h4>");
        out.println("Login: " + login + "<br>");
        out.println("Senha: " + senha + "<br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}