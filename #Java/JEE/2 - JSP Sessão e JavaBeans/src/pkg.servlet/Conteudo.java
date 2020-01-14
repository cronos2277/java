package pkg.servlet;
import pkg.java.MySQL;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;


@WebServlet("/cont")
public class Conteudo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Conteudo() {
        super();
        
    }
 //Essa variável, é utiliza para definir o tempo de vida da sessão e do cookies.  
int tempo = 3*60;    
    
public void init(ServletConfig config) throws ServletException {
	//Aqui são carregas os parâmetros iniciais do servlet.	
	}
// método doGet, acessado por cookies apenas.
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		Cookie cookie = new Cookie("login",request.getParameter("tmp")); //Aqui o cookie é criado. Detalhes sobre sua cração, é explicado nos comentários do index.jsp
		try{ //O try-catch é feito em função da variável dar nulo, em caso de NullPointerException, isso pode dar erro caso o erro não seja tratado. 
			if(cookie.getValue().equals(null)) //aqui é feito uma verificação com o equals(). 
			{cookie.setMaxAge(1);response.sendRedirect("index.html");}
		}catch(Exception e){cookie.setMaxAge(1);response.sendRedirect("index.html");}
		//seja no else, ou no catch o destino do cliente é o mesmo, o index.html
		Dentro(request, response); //Aqui é carregado o conteúdo do site.
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //criado o objeto PrintWriter, melhor esplicado no cadastro.java		
		MySQL sql = new MySQL(); //Objeto instanciado do pacote "pkg.java" classe MySQL, o mesmo é importado no ínicio deste servlet.
		if(sql.Consulta(request.getParameter("login"),request.getParameter("senha"))){
		//Criando cookies.
		Cookie cookie = new Cookie("login",request.getParameter("login"));
		cookie.setMaxAge(tempo); //Aqui é definido o tempo de vida desse objeto criado.
		response.addCookie(cookie); //Aqui o servidor cria de fato o cookie.
		Dentro(request, response); //Aqui é carregado o site.
		
		}else{ //caso o usuario digite um usuário o senha errado ele cai aqui.
			out.println("Não Entrou");
			out.println(request.getParameter("login"));
			out.println(request.getParameter("Senha"));
			response.sendRedirect("index.jsp"); //aqui ele é redirecionado.
	}
		
		}
	
protected String Sessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nesse método quando chamado se cria a sessão.
		String Valor; //Essa String inicialmente vazia, é melhor explicada abaixo.
		HttpSession session = request.getSession(); // Aqui o objeto HTTPSession, pega a requisição da sessão como valor.
		session.setMaxInactiveInterval(tempo); //aqui é definido o tempo de vida da sessão.
		session.setAttribute("login", request.getParameter("login")); //aqui é definido o atributo da sessão.
		Valor = (String) session.getAttribute("login"); // Nessa String é passado o nome da sessão, moldado em String.
		return Valor;
	}
protected void Dentro (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			String Valor = Sessao(request, response); //O metodo sessão retorna o nome da sessão.
			
			//Menu do usuário.
			out.print("<html><head><title>"+request.getParameter("login")+"</title></head>");	
			out.print("<body><table><tr'>");
			out.print("<td align='left'>User:</td><td align='center'>"+request.getParameter("login"));
			out.print("</td>");
			for(int i=0;i<=150;i++){out.print("<td></td>");}
			out.println("<td align='center'><a href='sair' method='post'> sair</a></td>");
			for(int i=0;i<=100;i++){out.print("<td></td>");}
			out.println("<td align='right'>Sessão: "+Valor+"</td></tr></table><hr>");
			
			//Começo da página
			out.println("</body></html>");
			
	}
}