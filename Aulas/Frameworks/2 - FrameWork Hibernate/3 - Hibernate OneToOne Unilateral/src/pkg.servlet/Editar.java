package pkg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.dao.Gerente;
import pkg.dao.HibernateSession;
import pkg.entity.Pessoas;
import pkg.entity.Salario;

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
			double sal = Double.parseDouble((String) request.getSession().getAttribute("this_salario"));
			Pessoas pessoa = new Gerente().GetByID(id);
			pessoa.setNome((String) request.getSession().getAttribute("this_nome"));
			Salario salario = new Salario();
			salario.setIdsalario(id);
			salario.setSalario(sal);
			pessoa.setSalario(salario);
			new Gerente().edit(pessoa);
			out.println("<body bgcolor='lightgray'><h1 align='center'>Editado com sucesso!</h1></body>");
		}catch(Exception e){out.println("<body bgcolor='lightgray'><h1 align='center'>Deu Errado! Servlet: "+e.toString()+", Hibernate: "+HibernateSession.Status+".</h1></body>");}
	}

}
