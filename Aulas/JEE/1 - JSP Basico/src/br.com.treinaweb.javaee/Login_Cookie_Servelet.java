package br.com.treinaweb.javaee;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;
@WebServlet("/L_C_S")
public class Login_Cookie_Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	//O método get foi criado para o login via cookies. o response.redirect do jsp, apontará para esse método do servlet.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Logado: "+request.getParameter("login")+"</title></head><body>");
		out.println("<h1> Login feito com sucesso, via método GET, com auxílio de um Cookie. </h1>");
		out.println("</body></html>");
	}
//Método Post recebe como parametro o request e o response. O request vem do form html, e o response um comando do jsp.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClasseMysql Sql = new ClasseMysql(); //Instanciado o objeto para o acesso ao banco de dados.
		PrintWriter out = response.getWriter(); //Instanciando o Objeto PrintWriter do java.util
		//os objetos PrintWriter eles tem a propriedade de imprimir tudo em uma pagina html.
		
		if(Sql.Consulta(request.getParameter("login"), request.getParameter("pwd"))){
			out.println("<html><head><title>Logado: "+request.getParameter("login")+"</title></head><body>");
			out.println("<h1> Login feito com sucesso, via método POST. </h1>");
			Cookie cookie = new Cookie("user",request.getParameter("login")); //criando o objeto cookie.
			//Ao criar o objeto cookie, o nome é a String user e o login é o conteudo que terá dentro do arquivo
			//criado com o nome user, na maquina do usuario. Depois será requisitado ao fazer login denovo.
			//Quando requisitado será feito uma comparação entre a String User e o conteúdo que será o login.
			cookie.setMaxAge(3*60); // a vida máxima do cookie. No caso 3 x 60 segundos.
			response.addCookie(cookie); // a criação do Cookie propriamente dita.
			out.println("</body></html>");
		}else{ //caso o usuário não exista.
			out.println("<html><head><title>Login Inválido</title></head><body>");
			out.println("<h1>"+ClasseMysql.Status+"</h1>");
			out.println("</body></html>");
		}
		
	}

}
