package pkg.all;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Methods extends Hibernate<People>{
	@Override
	public People save(People person) {
		Session session = getSession();
		try{
			session.beginTransaction();
			session.persist(person);
			session.getTransaction().commit();
			return person;
		}catch(Exception e){Status += "\nErro ao salvar, "+e.toString();return person;}
		finally{session.close();}
		
	}

	@Override
	public void delete(People person) {
		Session session = getSession();
		try{
			session.beginTransaction();
			session.delete(person);
			session.getTransaction().commit();			
		}catch(Exception e){Status += "\nErro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public void edit(People person) {
		Session session = getSession();
		try{
			session.beginTransaction();
			session.merge(person);
			session.getTransaction().commit();
		}catch(Exception e){Status += "\nErro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public People GetByID(int id) {
		session = getSession();
		People person = null;
		try{
			session.getTransaction().begin();
			//A definição de query por parametro, é o mais indicado para evitar sql injection.
			//o parametro é "p.id=:id", nesse caso ele substitui tudo que tiver p, por id.
			Query query = session.createQuery("from Person as p where p.id=:id");
			//aqui é setado um valor para o parâmetro ID, no caso um inteiro.
			query.setInteger("id",id);
			person = (People) query.uniqueResult();
			session.getTransaction().commit();
			return person;
		}catch(Exception e){Status += "\nErro ao procurar ID, "+e.toString();return person;}
		finally{session.close();}
	}

	@Override
	public List<People> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked") 
			List<People> TodosOsDadosCadastrados = session.createQuery("from Person").list();
			return TodosOsDadosCadastrados;
		}catch(Exception erro){Status += "\nErro ao criar uma Lista, "+erro.toString();return null;}
		finally{session.close();}
	}

	public List<Integer> GetCodes(){
		session = getSession();
		try{
			@SuppressWarnings("unchecked") 
			List<Integer> TodosOsDadosCadastrados = session.createQuery("select code from Person").list();
			return TodosOsDadosCadastrados;
		}catch(Exception erro){Status += "\nErro ao criar uma Lista, "+erro.toString();return null;}
		finally{session.close();}
	}

}
