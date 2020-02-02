package pkg.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import pkg.entity.*;
import pkg.dao.*;

@WebServlet("/new")
public class Novo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public Novo() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			double num = Double.parseDouble(request.getParameter("salario"));
			Salario salario = new Salario();
			salario.setSalario(num);
			Pessoas pessoa = new Pessoas();
			pessoa.setNome(request.getParameter("nome"));
			salario.setIdsalario(pessoa.getIdpessoa());
			pessoa.setSalario(salario);
			new Gerente().save(pessoa);
			out.println("<body bgcolor='lightgray'><h1 align='center'>Cadastrado com sucesso!</h1></body>");
		}catch(Exception e){out.println("<body bgcolor='lightgray'><h1 align='center'>Deu Errado! Servlet: "+e.toString()+", Hibernate: "+HibernateSession.Status+".</h1></body>");}
	}
	
}
