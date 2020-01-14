package pkg.classes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

@Path("/Produce")
public class JerseyProduce {
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces("Text/Html")
public String consulta(@FormParam("nome")String nome,@FormParam("login")String login,@FormParam("senha")String senha){
	try{
	EntityManagerFactory factory;
	factory = Persistence.createEntityManagerFactory("cliente");
	EntityManager manager = factory.createEntityManager();
	Entidade cliente = new Entidade();
	cliente.setNome(nome);
	cliente.setLogin(login);
	cliente.setSenha(senha);
	manager.getTransaction().begin();
	manager.persist(cliente);
	manager.getTransaction().commit();
	manager.close();
	return "<h1>Cliente "+nome+", registrado com sucesso!</h1>";
	}catch(Exception e){return "<h2>Erro: "+e+"</h2>";}
	
}
}
//Se dar um erro:  javax.persistence.PersistenceException: No Persistence provider for EntityManager named cliente