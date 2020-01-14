package pkg.controle;
import java.util.List;
import pkg.entidade.*;
public class UserDao extends HibernateSession<Usuario> {

	
	public Usuario save(Usuario usuario) {
		session = getSession();
		try{
			session.beginTransaction();
			session.persist(usuario);
			session.getTransaction().commit();
			return usuario;
		}catch(Exception e){Status = "Erro ao salvar, "+e.toString();return usuario;}
		finally{session.close();}
	}

	@Override
	public void delete(Usuario usuario) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	
	public void edit(Usuario usuario) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(usuario);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Usuario GetByID(int id) {
		session = getSession();
		try{
			Usuario usuario = (Usuario) session.createQuery("from Usuario").list().get(id -1);
			return usuario;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Usuario> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Usuario> Lista = session.createQuery("from Usuario").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}
	
}
