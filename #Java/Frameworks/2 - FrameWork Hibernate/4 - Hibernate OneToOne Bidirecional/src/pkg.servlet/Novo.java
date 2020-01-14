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
			Cliente cliente = new Cliente();
			Login login = new Login();
			cliente.setNome(request.getParameter("nome"));
			cliente.setCadastro(new java.util.Date());
			login.setUser(request.getParameter("login"));
			login.setPass(request.getParameter("senha"));
			cliente.setLogin(login);
			login.setCliente(cliente);
			new LoginDao().save(login); //O método pode ser acessao pelo ClienteDao() ou pelo LoginDao().
			out.println("<body bgcolor='lightgray'><h1 align='center'>Cadastrado com sucesso!</h1></body>");
		}catch(Exception e){out.println("<body bgcolor='lightgray'><h1 align='center'>Deu Errado! Servlet: "+e.toString()+", Hibernate: "+HibernateSession.Status+".</h1></body>");}
	}
	
}
