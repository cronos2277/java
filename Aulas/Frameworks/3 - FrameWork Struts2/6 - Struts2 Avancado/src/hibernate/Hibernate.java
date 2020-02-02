package hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class Hibernate<ClassHibernate> {
public static String Status;	
protected Session getSessao(){
	try{
	Configuration conf = new Configuration().configure();
	StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
	SessionFactory factory = conf.buildSessionFactory(ssrb.build());
	Session session = factory.openSession();
	return session;
	}catch(Exception e)
	{Status = "Ocorreu o seguinte erro, ao criar uma sessão: "+e.toString();return null;}
}
protected abstract ClassHibernate save(ClassHibernate ObjectHibernate);
protected abstract void delete (ClassHibernate ObjectHibernate);
protected abstract void edit (ClassHibernate ObjectHibernate);
protected abstract ClassHibernate findById(int number);
protected abstract List<ClassHibernate> returnList();

}
