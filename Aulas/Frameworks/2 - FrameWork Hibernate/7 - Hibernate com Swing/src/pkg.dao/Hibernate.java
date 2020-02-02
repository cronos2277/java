package pkg.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public abstract class Hibernate<T> {
public static String Status;
protected Session sessao;
protected Session getSessao(){
	try{		
		Configuration conf = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory factory = conf.buildSessionFactory(builder.build());
		sessao = factory.openSession();
		return sessao;	
	}catch(Exception e){Status = "Erro ao criar uma sessão. "+e.toString();return null;}
}
public abstract T save(T entidade);	
public abstract void update(T entidade);	
public abstract void delete(T entidade);
public abstract T GetById(int id);
public abstract List<T> GetAll();
}
