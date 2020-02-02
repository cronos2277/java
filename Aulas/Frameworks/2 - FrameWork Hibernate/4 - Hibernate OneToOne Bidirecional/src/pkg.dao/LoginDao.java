package pkg.dao;
import java.util.List;
import pkg.entity.Login;

public class LoginDao extends HibernateSession<Login> {

	@Override
	public Login save(Login login) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(login);
			session.getTransaction().commit();
			return login;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return login;}
		finally{session.close();}
	}

	@Override
	public void delete(Login login) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(login);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public void edit(Login login) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(login);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Login GetByID(int id) {
		session = getSession();
		try{
			Login login = (Login) session.createQuery("from Login").list().get(id -1);
			return login;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Login> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Login> Lista = session.createQuery("from Login").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}

	
	
}
