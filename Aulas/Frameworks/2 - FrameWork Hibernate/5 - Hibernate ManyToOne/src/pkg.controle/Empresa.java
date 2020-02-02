package pkg.controle;
import java.util.List;
import pkg.entidade.*;

public class Empresa extends HibernateSession<Cargo> {

	@Override
	public void delete(Cargo cargo) {
		session = getSession();
		try{
			session.beginTransaction();
			session.delete(cargo);
			session.getTransaction().commit();
		}catch(Exception e ){Status = "Erro ao excluir, "+e.toString();}
		finally{session.close();}
	}

	
	public void EditOrNew(Cargo cargo) {
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(cargo);
			session.getTransaction().commit();
		}catch(Exception e){Status = "Erro ao modificar, "+e.toString();}
		finally{session.close();}
	}

	@Override
	public Cargo GetByID(int id) {
		session = getSession();
		try{
			Cargo cargo = (Cargo) session.createQuery("from Cargo").list().get(id -1);
			return cargo;
		}catch(Exception e){Status = "Erro ao procurar ID, "+e.toString();return null;}
		finally{session.close();}
		
	}

	@Override
	public List<Cargo> GetAll() {
		session = getSession();
		try{
			@SuppressWarnings("unchecked")
			List<Cargo> Lista = session.createQuery("from Cargo").list();
			return Lista;
		}catch(Exception e){Status = "Erro ao criar uma Lista, "+e.toString();return null;}
		finally{session.close();}
	}
	public Cargo CargoNewEdit(Cargo cargo) { //Esse método cria ou edita o cargo.
		session = getSession();
		try{
			session.beginTransaction();
			session.merge(cargo);
			session.getTransaction().commit();
			return cargo;
		}catch(Exception e){Status = "Erro ao crud cargo, "+e.toString();return null;}
		finally{session.close();}
	}
	
	
}
