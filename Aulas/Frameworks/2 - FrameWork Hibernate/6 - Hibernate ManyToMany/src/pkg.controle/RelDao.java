package pkg.controle;
import java.util.List;
import pkg.entidade.*;
public class RelDao extends HibernateSession<Relacionamento> {

	
	public Relacionamento save(Relacionamento rel) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(rel);
			session.getTransaction().commit();
			return rel;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return rel;}
		finally{session.close();}
	}

	@Override
	public void delete(Relacionamento rel) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(rel);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	
	public void edit(Relacionamento rel) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(rel);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Relacionamento GetByID(int id) {
		session = getSession();
		try{
			Relacionamento rel = (Relacionamento) session.createQuery("from Relacionamento").list().get(id -1);
			return rel;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Relacionamento> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Relacionamento> Lista = session.createQuery("from Relacionamento").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}
	
}
