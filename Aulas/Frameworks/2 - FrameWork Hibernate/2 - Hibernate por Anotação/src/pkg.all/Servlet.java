package pkg.all;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor='lightgray'><h1>");		
		Classe objeto = new Classe(); //Aqui a entidade é instanciada, em base nos dados contidos nela, que as operações de crud vão se suceder.
		MetodosDao operacao = new MetodosDao(); //O método Dao da classe acima. Os seus métodos, faz a execução das operações de crud, ela serve para organizar e evitar a repetição de código.
		try{
			if(request.getParameter("edit") != null && request.getParameter("del") == null && request.getParameter("novo") == null){
				//Desvio de ediÃ§Ã£o.	
				int id = Integer.parseInt(request.getParameter("id")); //Aqui é convertido um parâmetro oculto na tabela com o nome de ID. Esse parametro recebe o id do dado persistido no banco de dados.
				objeto = operacao.GetByID(id); //Esse id criado acima, é usado como parâmetro na localização dos dados persistido, esse objeto é inscrito com dados do banco, para depois ser modifiado e persistido.
				objeto.setTexto(request.getParameter("texto"));//Aqui é feito a edição, uma vez que o dado seja carregado, o mesmo é substítuido bem aqui.
				operacao.edit(objeto); //aqui é executado a edição no banco de dados.
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") != null && request.getParameter("novo") == null){
				//Desvio de exclusÃ£o.
				int id = Integer.parseInt(request.getParameter("id"));
				objeto = operacao.GetByID(id);
				operacao.delete(objeto); //Se executa a exclusão no banco de dados, por aqui.
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") == null && request.getParameter("novo") != null){
				//Desvio de criaÃ§Ã£o.				
				objeto.setTexto(request.getParameter("texto")); //aqui o objeto é carregado com novas informações.
				operacao.save(objeto); //Com o objeto carregado, com os dados. O dado é persestido bem aqui.				
				
			}else{out.println("\n Erro de parametros. \n");}			
			
			if(MetodosDao.Status != null){out.print("Erro: "+MetodosDao.Status+"</h1></body>");}			
			else{out.print("Operação concluída com Sucesso!</h1></body>");}						
		}catch(Exception e){out.print("Erro: "+e.toString()+"</h1></body>");}
	}

}
