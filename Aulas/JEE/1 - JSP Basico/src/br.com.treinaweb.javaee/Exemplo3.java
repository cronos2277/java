package br.com.treinaweb.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        name = "Exemplo3",
        urlPatterns = { "/Ex3"},
        initParams = {
            @WebInitParam(name = "empresa", value = "Treinaweb Cursos"),
            @WebInitParam(name = "autor", value = "Aluno"),
            @WebInitParam(name = "data", value = "20/10/2016")
        })
public class Exemplo3 implements Servlet {
    private String empresa;
    private String autor;
    private String dataCriacao;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // TODO Auto-generated method stub
        empresa = servletConfig.getInitParameter("empresa");
        autor = servletConfig.getInitParameter("autor");
        dataCriacao = servletConfig.getInitParameter("data");

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Informações do sistema</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Informações do sistema:</h2>");
        out.println("<h4>Empresa:" + empresa + "</h4>");
        out.println("<h4>Autor: " + autor + "</h4>");
        out.println("<h4>Data criação: " + dataCriacao + "</h4>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}