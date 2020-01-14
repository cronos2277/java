package pkg.dao;
import java.util.List;
import pkg.entity.Cliente;

public class ClienteDao extends HibernateSession<Cliente> {

	@Override
	public Cliente save(Cliente cliente) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(cliente);
			session.getTransaction().commit();
			return cliente;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return cliente;}
		finally{session.close();}
	}

	@Override
	public void delete(Cliente cliente) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(cliente);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public void edit(Cliente cliente) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(cliente);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Cliente GetByID(int id) {
		session = getSession();
		try{
			Cliente cliente = (Cliente) session.createQuery("from Cliente").list().get(id -1);
			return cliente;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Cliente> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Cliente> Lista = session.createQuery("from Cliente").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}

	
	
}
