package pkg.controle;
import java.util.List;
import pkg.entidade.*;

public class Gerente extends HibernateSession<Pessoa> {

	
	public Pessoa save(Pessoa pessoa) {
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
	public void delete(Pessoa pessoa) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(pessoa);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	
	public void edit(Pessoa pessoa) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(pessoa);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Pessoa GetByID(int id) {
		session = getSession();
		try{
			Pessoa pessoa = (Pessoa) session.createQuery("from Pessoa").list().get(id -1);
			return pessoa;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Pessoa> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Pessoa> Lista = session.createQuery("from Pessoa").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}
}
