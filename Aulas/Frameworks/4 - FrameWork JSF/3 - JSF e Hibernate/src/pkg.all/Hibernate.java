package pkg.all;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

public abstract class Hibernate <T>{
public static String Status = " ";
protected Session session;
public Session getSession() {
	try{
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory factory = conf.buildSessionFactory(builder.build());
		session = factory.openSession();		
		return session;
	}catch(Exception e){Status = "Erro ao criar uma Session, "+e.toString();return session;}	
	
}
public abstract T save (T person);
public abstract void delete(T person);
public abstract void edit (T person);
public abstract T GetByID(int id);
public abstract List<T> GetAll();

}
