package pkg.controle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		
		try{ //Repare que neste servlet, deve-se fazer a alteração em dois DAO. Isso é consequência do relacionamento Bi-direcional.
			Usuario usuario = new Usuario();
			 Grupo grupo = new Grupo();
			 List<Usuario> usuarios = new ArrayList<Usuario>();			 
			if(request.getParameter("edit") != null && request.getParameter("del") == null && request.getParameter("novo") == null){
				//Desvio de ediÃ§Ã£o.	
				int user_id = Integer.parseInt(request.getParameter("usuario_id"));
				int group_id = Integer.parseInt(request.getParameter("grupo_id"));
				usuario = new UserDao().GetByID(user_id);
				grupo = new UserGroup().GetByID(group_id);
				usuario.setNome(request.getParameter("nome"));
				grupo.setNome(request.getParameter("grupo"));
				new UserGroup().edit(grupo);
				new UserDao().edit(usuario);
			}else if(request.getParameter("edit") == null && request.getParameter("del") != null && request.getParameter("novo") == null){
				//Desvio de exclusÃ£o.
				int user_id = Integer.parseInt(request.getParameter("usuario_id"));
				int group_id = Integer.parseInt(request.getParameter("grupo_id"));
				usuario = new UserDao().GetByID(user_id);
				grupo = new UserGroup().GetByID(group_id);
				new UserDao().delete(usuario);				
				
			}else if(request.getParameter("edit") == null && request.getParameter("del") == null && request.getParameter("novo") != null){
				//Desvio de criaÃ§Ã£o.		
				usuario.setNome(request.getParameter("nome"));
				grupo.setNome(request.getParameter("grupo"));				
				//primeiro adicionando os grupos
				usuarios.add(usuario);
				grupo.setUsuario(usuarios);
				new UserGroup().save(grupo);	
				
			}else{out.println("\n Erro de parametros. \n");}			
			if(HibernateSession.Status != null){out.print("Erro: "+HibernateSession.Status+"</h1></body>");}			
			else{out.print("Operação concluída com Sucesso!</h1></body>");}						
		}catch(Exception e){out.print("Servlet error: "+e.toString()+"</h1></body>");}
	}

}
