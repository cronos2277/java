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



@WebServlet("/del")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Excluir() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		try{
			int id = Integer.parseInt((String) request.getSession().getAttribute("this_id"));
			Cliente pessoa = new ClienteDao().GetByID(id);
			new ClienteDao().delete(pessoa); //O método pode ser acessao pelo ClienteDao() ou pelo LoginDao().
			out.println("<body bgcolor='lightgray'><h1 align='center'>Deletado com sucesso!</h1></body>");
		}catch(Exception e){out.println("<body bgcolor='lightgray'><h1 align='center'>Deu Errado! Servlet: "+e.toString()+", Hibernate: "+HibernateSession.Status+".</h1></body>");}
	}

}
