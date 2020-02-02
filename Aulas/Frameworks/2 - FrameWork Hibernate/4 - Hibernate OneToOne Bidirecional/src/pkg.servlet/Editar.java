package pkg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.dao.ClienteDao;
import pkg.dao.HibernateSession;
import pkg.entity.Cliente;
import pkg.entity.Login;

@WebServlet("/edt")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Editar() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter(); 
		try{
			int id = Integer.parseInt((String) request.getSession().getAttribute("this_id"));
			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setNome((String) request.getSession().getAttribute("this_nome"));
			cliente.setCadastro(new java.util.Date());
			Login login = new Login();
			login.setId(id);
			login.setPass((String) request.getSession().getAttribute("this_senha"));
			login.setUser((String) request.getSession().getAttribute("this_user"));
			cliente.setLogin(login);
			new ClienteDao().edit(cliente); //O método pode ser acessao pelo ClienteDao() ou pelo LoginDao().
			out.println("<body bgcolor='lightgray'><h1 align='center'>Editado com sucesso! </h1></body>");
		}catch(Exception e){out.println("<body bgcolor='lightgray'><h1 align='center'>Deu Errado! Servlet: "+e.toString()+", Hibernate: "+HibernateSession.Status+".</h1></body>");}
	}

}
