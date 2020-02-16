import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateManager<Entity> {	
	private String query = "";
	private Configuration configuration;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private List<Entity> entity;
	private List<String> errors;
	private Iterator<Entity> iterator;	
	//No primeiro construtor voce precisa passar a query: "from Aluno order by alu_codigo"
	public HibernateManager(String query) {				
		this.query = query;		
		this.configuration = new Configuration().configure("hibernate.cfg.xml");
		this.init();
	}
	
	@SuppressWarnings("rawtypes")
	public HibernateManager(boolean isAnnotatedClass,String user, String password, String host, String driver, String dialect, String query,Class ...Entities) {		
			this.query = query;		
			this.configuration = new Configuration();
			this.configuration.setProperty("hibernate.connection.driver_class", driver);
			this.configuration.setProperty("hibernate.connection.url", host);
			this.configuration.setProperty("hibernate.connection.username", user);
			this.configuration.setProperty("hibernate.connection.password", password);
			this.configuration.setProperty("hibernate.connection.dialect", dialect);
			for(Class Ent: Entities) {
				if(isAnnotatedClass) {
					this.configuration.addAnnotatedClass(Ent);
				}else {
					this.configuration.addClass(Ent);
				}
			}	
			this.init();
		
	}
	
	
	public HibernateManager<Entity> setQuery(String query){
		this.query = query;
		return this;
	}	
	
	private void init() {
		this.sessionFactory();
		this.entity = new ArrayList<Entity>();
		this.errors = new ArrayList<String>();	
		this.refresh();
		this.iterator = this.entity.iterator();
	}
	
	private void sessionFactory() {
		try {			
			this.factory = this.configuration.buildSessionFactory();			
		}catch(Exception e) {			
			this.errors.add("sessionFactory: "+e.toString());
		}
	}
	
	private void getSession() {
		try {
			if(this.factory.isClosed()) {
				this.sessionFactory();
			}
			this.session = factory.openSession();
		}catch(Exception e) {
			this.errors.add("getSession: "+e.toString());
		}
	}
	
	private void closeSession() {
		try {
			this.session.close();
			this.factory.close();
		}catch(Exception e) {
			this.errors.add("closeSession: "+e.toString());
		}
	}	
	
	private void transactionManager(int operation, Entity entity) {
		try {			
			if(!this.session.isOpen()) {
				this.getSession();			
			}
			this.transaction = this.session.beginTransaction();
			switch(operation) {
				case 1: {this.session.save(entity);break;}
				case 2: {this.session.update(entity);break;}
				case 3: {this.session.delete(entity);break;}
			}
			this.transaction.commit();								
			this.closeSession();			
							
			
		}catch(Exception e) {
			this.transaction.rollback();
			this.closeSession();
			this.errors.add("transactionManager: "+e.toString());
		}
	}
	
	public HibernateManager<Entity> insert(Entity entity) {
		this.transactionManager(1, entity);
		return this;
	}
	
	public HibernateManager<Entity> update(Entity entity) {
		this.transactionManager(2, entity);
		return this;
	}
	
	public HibernateManager<Entity> delete(Entity entity) {
		this.transactionManager(3, entity);
		return this;
	}
	
	public List<Entity> getAll(boolean isUpdate){
		try {
			if(this.entity.isEmpty() || isUpdate) {
				this.fillAlunos();				
			}
			return this.entity;			
		}catch(Exception e) {
			this.errors.add("getAll: "+e.toString());
			return null;
		}
	}
	public List<Entity> getAll(){
		try {
			if(this.entity.isEmpty()) {
				this.fillAlunos();
			}			
			return this.entity;			
		}catch(Exception e) {		
			this.errors.add("getAll: "+e.toString());
			return null;
		}
	}
	
	public HibernateManager<Entity> refresh(){
		try {
			if(this.entity.isEmpty()) {
				this.fillAlunos();
			}			
			return this;			
		}catch(Exception e) {	
			this.errors.add("refresh: "+e.toString());
			return this;
		}
	}
	
	@Override
	public String toString() {
		return "This object contains "+this.entity.size()+" records from database and "+this.errors.size()+" errors.";
	}
	

	
	@SuppressWarnings("unchecked")
	private void fillAlunos() {
		this.getSession();
		this.entity = session.createQuery(query).list();
		this.closeSession();
	}
	
	@Override
	public boolean equals(Object obj) {	    
		try {
	    if(this == obj) return true;	          
	    if(obj == null || obj.getClass()!= this.getClass()) return false;	    
	    return true;
		}catch(Exception e) {
			this.errors.add("equals: "+e.toString());
			return false;
		}
	}
	
	public String errorsCaught() {
		try {
			String errors = "";
			if(!this.hasErrors()) return errors;
			for(String str: this.errors) {
				errors = errors + "\n"+str;
			}
			return errors;
		}catch(Exception e) {
			this.errors.add("errorsCaught: "+e.toString());
			return null;
		}
	}
	
	public boolean hasErrors() {
		try {
			return this.errors.size() > 0;
		}catch(Exception e) {
			this.errors.add("hasErrors: "+e.toString());
			return true;
		}
	}
	
	public boolean hasNext(){
		try {
			return this.iterator.hasNext();
		}catch(Exception e) {
			this.errors.add("hasNext: "+e.toString());
			return false;
		}
	}	
	
	public Entity next(){
		try {
			return this.iterator.next();
		}catch(Exception e) {
			this.errors.add("next: "+e.toString());
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Iterator iterator() {
		try {
			return this.iterator;
		}catch(Exception e) {
			this.errors.add("iterator: "+e.toString());
			return null;
		}
	}
	
	public int size() {
		try {
			return this.entity.size();
		}catch(Exception e) {
			this.errors.add("size: "+e.toString());
			return 0;
		}
	}
	
	public Entity getRecord(int queryPosition) {
		try {
			return this.entity.get(queryPosition);
		}catch(Exception e) {
			this.errors.add("getRecord: "+e.toString());
			return null;
		}
	}
	
	public Entity firstRecord() {
		try {
			return this.entity.get(0);
		}catch(Exception e) {
			this.errors.add("firstRecord: "+e.toString());
			return null;
		}	
	}
	
	public Entity lastRecord() {
		try {
			return this.entity.get(this.size() - 1);
		}catch(Exception e) {
			this.errors.add("lastRecord: "+e.toString());
			return null;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public Entity[] toArray() {
		try {
		return (Entity[]) this.entity.toArray();
		}catch(Exception e) {
			this.errors.add("toArray: "+e.toString());
			return null;
		}
	}
	
	
}
