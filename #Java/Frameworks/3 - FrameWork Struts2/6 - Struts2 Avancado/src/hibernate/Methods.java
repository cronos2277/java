package hibernate;
import java.util.List;

import org.hibernate.Session;

import pkg.Entidade;
public abstract class Methods extends Hibernate<Entidade> {

	@Override
	protected Entidade save(Entidade ObjectHibernate) {
		Session session = getSessao();
		try{
			session.beginTransaction();
			session.persist(ObjectHibernate);
			session.getTransaction().commit();
			return ObjectHibernate;
		}catch(Exception e){
			Status = "Ocorreu o seguinte erro, ao salvar: "+e.toString();
			return null;
		}finally{session.close();}
	}

	@Override
	protected void delete(Entidade ObjectHibernate) {
		Session session = getSessao();
		try{
			session.beginTransaction();
			session.delete(ObjectHibernate);
			session.getTransaction().commit();
		}catch(Exception e){
			Status = "Ocorreu o seguinte erro, ao deletar: "+e.toString();
		}finally{session.close();}
	}

	@Override
	protected void edit(Entidade ObjectHibernate) {
		Session session = getSessao();
		try{
			session.beginTransaction();
			session.merge(ObjectHibernate);
			session.getTransaction().commit();
		}catch(Exception e){
			Status = "Ocorreu o seguinte erro, ao editar: "+e.toString();
		}finally{session.close();}	
	}

	@Override
	protected Entidade findById(int id) {		
		Session session = getSessao();
		try{			
			Entidade entidade = (Entidade) session.createQuery("from Entidade").list().get(id -1);
			return entidade;
		}catch(Exception e){
			Status = "Ocorreu o seguinte erro, ao procurar: "+e.toString();
			return null;
		}finally{session.close();}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Entidade> returnList() {
		Session session = getSessao();
		try{
			List<Entidade> Lista = (List<Entidade>) session.createQuery("from Entidade").list();
			return Lista;
		}catch(Exception e){
			Status = "Ocorreu o seguinte erro, ao Listar: "+e.toString();
			return null;
		}finally{session.close();}
	}

}
