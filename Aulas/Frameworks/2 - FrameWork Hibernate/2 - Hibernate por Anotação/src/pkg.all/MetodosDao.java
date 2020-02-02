package pkg.all;
import java.util.List;


public class MetodosDao extends HibernateSession<Classe> {

	@Override //Essa anotação indica, que o método está sendo reescrito.
	public Classe save(Classe objeto) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(objeto);
			session.getTransaction().commit();
			return objeto;
		}catch(Exception erro){Status = "Erro ao salvar, "+erro.toString();return objeto;}
		finally{session.close();} //A sessão deve ser fechada, do contrário pode acontecer um DDOS no banco de dados.
	}

	@Override
	public void delete(Classe objeto) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(objeto);
			session.getTransaction().commit();
		}catch(Exception erro){Status = "Erro ao excluir, "+erro.toString();}
		finally{session.close();}
	}

	@Override
	public void edit(Classe objeto) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(objeto); //Semelhante ao método persist. Caso não tenha ele não cria, caso tenha ele apenas modifica.
			session.getTransaction().commit();
		}catch(Exception erro){Status = "Erro ao modificar, "+erro.toString();}
		finally{session.close();}
	}

	@Override
	public Classe GetByID(int id) {
		session = getSession();
		try{
			Classe objeto = (Classe) session.createQuery("from Entidade").list().get(id -1);
			return objeto;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Classe> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked") //Essa anotação remove os avisos abaixos de triangolo amarelo, tanto aqui no Eclipse, quanto no javac que não acusa nada.
			List<Classe> TodosOsDadosCadastrados = session.createQuery("from Entidade").list();
			return TodosOsDadosCadastrados;
		}catch(Exception erro){Status = "Erro ao criar uma Lista, "+erro.toString();return null;}
		finally{session.close();}
	}

	
	
}
