package pkg.controle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;

public abstract class HibernateSession <T> {
protected Session session;
public static String Status;
	protected Session getSession(){
		try{
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			SessionFactory factory = conf.buildSessionFactory(builder.build());
			session = factory.openSession();
			return session;
		}catch(Exception e)
			{Status = "Erro ao criar uma Session, "+e.toString();return session;}
	}
	
	public abstract void delete(T pessoa);
	public abstract T GetByID(int id);
	public abstract List<T> GetAll();
}
