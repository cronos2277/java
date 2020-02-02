package pkg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sair")
public class Saida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Saida() {
        super();
        
    }

	public void destroy() {
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sair(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sair(request, response);
		
	}
	
	protected void Sair (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("login",request.getParameter("tmp"));
		cookie.setMaxAge(1);
		session.removeAttribute("login");
		destroy();
		response.sendRedirect("index.html");
	}
}
//Seja feita a entrada por get ou por post, ambos executam o método sair, no sair
//é setado um tempo de vida em segundos diferente para o cookie, no método 
//setMaxAge(o numero de segundos em integer); Abaixo a sessão é removido o atributo
// da sessao, depois todos os dados são destruídos, na função void destroy.
//por fim o cliente é redirecionado para a página html, pois essa não tem código
//scriptlet para redirecionamento.

