package pkg.controle;
import java.util.List;
import pkg.entidade.*;
public class UserGroup extends HibernateSession<Grupo> {	
	public Grupo save(Grupo grupo) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(grupo);
			session.getTransaction().commit();
			return grupo;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return grupo;}
		finally{session.close();}
	}

	@Override
	public void delete(Grupo grupo) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(grupo);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	
	public void edit(Grupo grupo) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(grupo);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Grupo GetByID(int id) {
		session = getSession();
		try{
			Grupo grupo = (Grupo) session.createQuery("from Grupo").list().get(id -1);
			return grupo;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Grupo> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Grupo> Lista = session.createQuery("from Grupo").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}
}
