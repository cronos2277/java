package pkg.dao;
import java.util.List;
import pkg.entity.Pessoas;

public class Gerente extends HibernateSession<Pessoas> {

	@Override
	public Pessoas save(Pessoas pessoa) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(pessoa);
			session.getTransaction().commit();
			return pessoa;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return pessoa;}
		finally{session.close();}
	}

	@Override
	public void delete(Pessoas pessoa) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(pessoa);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public void edit(Pessoas pessoa) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(pessoa);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Pessoas GetByID(int id) {
		session = getSession();
		try{
			Pessoas pessoa = (Pessoas) session.createQuery("from Pessoas").list().get(id -1);
			return pessoa;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Pessoas> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Pessoas> Lista = session.createQuery("from Pessoas").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}

	
	
}
