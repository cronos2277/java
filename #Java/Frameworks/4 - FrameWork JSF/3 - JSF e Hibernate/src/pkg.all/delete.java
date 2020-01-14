package pkg.all;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class delete
 */
@WebServlet("/del/")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public delete() {
        super();
        
    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int idrem = Integer.parseInt(request.getParameter("idrem"));
			People person = new Methods().GetByID(idrem);
			new Methods().delete(person);					
			response.sendRedirect(request.getContextPath() + "/success.jsf");
		}catch(Exception e){
			response.sendRedirect(request.getContextPath() + "/error.jsf");
		}
	}

}
