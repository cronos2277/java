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
		Classe objeto = new Classe(); //Aqui a entidade � instanciada, em base nos dados contidos nela, que as opera��es de crud v�o se suceder.
		MetodosDao operacao = new MetodosDao(); //O m�todo Dao da classe acima. Os seus m�todos, faz a execu��o das opera��es de crud, ela serve para organizar e evitar a repeti��o de c�digo.
		try{
			if(request.getParameter("edit") != null && request.getParameter("del") == null && request.getParameter("novo") == null){
				//Desvio de edição.	
				int id = Integer.parseInt(request.getParameter("id")); //Aqui � convertido um par�metro oculto na tabela com o nome de ID. Esse parametro recebe o id do dado persistido no banco de dados.
				objeto = operacao.GetByID(id); //Esse id criado acima, � usado como par�metro na localiza��o dos dados persistido, esse objeto � inscrito com dados do banco, para depois ser modifiado e persistido.
				objeto.setTexto(request.getParameter("texto"));//Aqui � feito a edi��o, uma vez que o dado seja carregado, o mesmo � subst�tuido bem aqui.
				operacao.edit(objeto); //aqui � executado a edi��o no banco de dados.
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") != null && request.getParameter("novo") == null){
				//Desvio de exclusão.
				int id = Integer.parseInt(request.getParameter("id"));
				objeto = operacao.GetByID(id);
				operacao.delete(objeto); //Se executa a exclus�o no banco de dados, por aqui.
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") == null && request.getParameter("novo") != null){
				//Desvio de criação.				
				objeto.setTexto(request.getParameter("texto")); //aqui o objeto � carregado com novas informa��es.
				operacao.save(objeto); //Com o objeto carregado, com os dados. O dado � persestido bem aqui.				
				
			}else{out.println("\n Erro de parametros. \n");}			
			
			if(MetodosDao.Status != null){out.print("Erro: "+MetodosDao.Status+"</h1></body>");}			
			else{out.print("Opera��o conclu�da com Sucesso!</h1></body>");}						
		}catch(Exception e){out.print("Erro: "+e.toString()+"</h1></body>");}
	}

}
