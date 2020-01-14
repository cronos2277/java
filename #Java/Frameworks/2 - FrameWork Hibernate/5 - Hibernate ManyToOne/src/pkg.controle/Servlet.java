package pkg.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.entidade.*;
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Servlet() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<body bgcolor='lightgray'><h1>");
		Pessoa pessoa = new Pessoa();
		Cargo cargo = new Cargo();
		
		try{
			 Set<Pessoa> pessoas = new HashSet<Pessoa>();
			if(request.getParameter("edit") != null && request.getParameter("del") == null && request.getParameter("novo") == null){
				//Desvio de edição.	
				int id = Integer.parseInt(request.getParameter("id")); //Aqui � convertido um par�metro oculto na tabela com o nome de ID. Esse parametro recebe o id do dado persistido no banco de dados.
				pessoa = new Gerente().GetByID(id);
				pessoa.setNome(request.getParameter("nome"));
				new Gerente().edit(pessoa);
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") != null && request.getParameter("novo") == null){
				//Desvio de exclusão.
				int id = Integer.parseInt(request.getParameter("id"));
				pessoa = new Gerente().GetByID(id);
				new Gerente().delete(pessoa);
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") == null && request.getParameter("novo") != null){
				//Desvio de criação.				
				pessoa.setNome(request.getParameter("nome"));				
				 //Existir� apenas um cargo. No caso isso � o suficiente para demontrar um relacionamento muitos para um.
				cargo.setCargo("Auxiliar"); //Neste relacionamento, existe n pessoas para um cargo. Uma pessoa s� pode ter um �nico cargo, mas um cargo tem v�rias pessoas. 
				pessoas.add(pessoa);							
				cargo.setPessoas(pessoas);						
				pessoa.setCargoInstanciado(cargo);		
				new Empresa().CargoNewEdit(cargo);
			}else{out.println("\n Erro de parametros. \n");}	
			
			if(HibernateSession.Status != null){out.print("Erro: "+HibernateSession.Status+"</h1></body>");}			
			else{out.print("Opera��o conclu�da com Sucesso!</h1></body>");}						
		}catch(Exception e){out.print("Servlet error: "+e.toString()+"</h1></body>");}
	}

}
