package pkg.connection;
import java.util.ArrayList;
import java.util.List;
import pkg.entity.Attachments;
import pkg.entity.References;
import pkg.entity.User;
import pkg.main.Do;

abstract class ConnectionManager extends ConnectionFactory {	
	protected List<User> lists;
	protected List<References> references;
	protected List<Attachments> attachments;
	protected User user;
	public ConnectionManager(){		
		super();
		if(super.factory.isOpen()){
			this.getAllUser();
			this.getAllRefs();
			this.getAllAtts();
			super.closeConnection();			
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public List<User> getList(){
		return this.lists;
	}
	
	protected void persistUser(User user){
			this.user = user;			
			try{			
				super.openConnection();				
				System.out.println("Beginning transaction ...");
				super.manager.getTransaction().begin();
				super.manager.persist(this.user);
				System.out.println("Recording changes...");
				super.manager.getTransaction().commit();				
			}catch(Exception e){
				System.out.println("There was an error, undoing operations...");
				super.manager.getTransaction().rollback();			
			}finally{
				super.closeConnection();
				
			}
		}
	
	protected void editUser(Long id, User user){		
		try{
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the record to be changed");
			User change_this = super.manager.find(User.class, id);
			change_this = this.user;
			super.manager.merge(change_this);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();			
		}finally{			
			super.closeConnection();
			
		}
	}
	
	public void removeUser(Long id){			
		try{
			super.openConnection();
			
			System.out.println("Beginning transaction ...");
			super.manager.getTransaction().begin();
			System.out.println("Looking for the record to be deleted...");
			this.user = super.manager.find(User.class, id);
			super.manager.remove(this.user);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();			
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();			
		}finally{			
			super.closeConnection();			
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public void getAllUser(){
		this.lists = new ArrayList<User>();
		System.out.println("Getting list of database users...");		
			try{
				if(pkg.components.OrderByMenu.value == 0){ //Ordena por ordem de criação
					javax.persistence.Query query = super.manager.createQuery("select x from User x");
					this.lists = query.getResultList();
					System.out.println("List of users uploaded successfully!");
				}else if(pkg.components.OrderByMenu.value == 1){ //Ordena por nome de A-Z.
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.name");
					this.lists = query.getResultList();
					System.out.println("List of users uploaded successfully!");
				}else if(pkg.components.OrderByMenu.value == 2){//Ordena por nome de Z-A
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.name desc");					
					this.lists = query.getResultList();
					System.out.println("List of users uploaded successfully!");
				}else if(pkg.components.OrderByMenu.value == 3){//Ordena do menor número de notebook para o maior.
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.BrazilLaptop");
					this.lists = query.getResultList();
				}else if(pkg.components.OrderByMenu.value == 4){ //Ordena do maior número de notebook para o menor.
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.BrazilLaptop desc");
					this.lists = query.getResultList();
				}else if(pkg.components.OrderByMenu.value == 5){//Ordena por data de pagamento.
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.payment.payment_date");
					this.lists = query.getResultList();
				}else if(pkg.components.OrderByMenu.value == 6){
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.client.account_holder");
					this.lists = query.getResultList();
				}else if(pkg.components.OrderByMenu.value == 7){
					javax.persistence.Query query = super.manager.createQuery("select x from User x order by x.client.dob");
					this.lists = query.getResultList();
				}
				
			}catch(Exception e){
				System.out.println("Error loading user list!");
			}
	}	
	
		public void refreshList(){
			super.openConnection();
			this.getAllUser();
			super.closeConnection();
			Do.clearScreen();
		}
	
	
	@SuppressWarnings("unchecked")
	public void getAllRefs(){
		this.references = new ArrayList<References>();
		System.out.println("Getting list of database users...");
		try{			
			javax.persistence.Query query = super.manager.createQuery("select x from References x");
			this.references = query.getResultList();
			System.out.println("returning all the references!");			
		}catch(Exception e){
			System.out.println("Error loading references list!");			
		}
	}	
	
	@SuppressWarnings("unchecked")
	public void getAllAtts(){
		this.attachments = new ArrayList<Attachments>();
		System.out.println("Getting list of database users...");
		try{			
			javax.persistence.Query query = super.manager.createQuery("select x from Attachments x");
			this.attachments = query.getResultList();
			System.out.println("returning all the attachments!");			
		}catch(Exception e){
			System.out.println("Error loading attachments list!");			
		}
	}	
	
	protected void addReferences(Long userID, References ref){		
		try{			
			System.out.println("Adding references...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.printf("User: "+this.user.getName()+" found!");			
			ref.setUser(this.user);			
			super.manager.persist(ref);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();			
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();
		}finally{
			if(super.manager.isOpen()){
				super.closeConnection();
			}
		}
	}
	
	protected void addAttachments(Long userID,Attachments att){
		try{
			System.out.println("Adding references...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.printf("User: "+this.user.getName()+" found!");
			att.setUser(this.user);			
			super.manager.persist(att);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();	
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();
		}finally{
			if(super.manager.isOpen()){
				super.closeConnection();
			}
		}
	}
	
	protected void removeReference(Long userID, Long refID){		
		try{
			System.out.println("Adding references...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.printf("User: "+this.user.getName()+" found!");
			References ref = super.manager.find(References.class, refID);
			ref.setUser(this.user);
			super.manager.remove(ref);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();
		}finally{			
			super.closeConnection();			
		}
	}
	
	protected void removeAttachment(Long userID, Long attID){
		try{
			System.out.println("Adding attachments...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.printf("User: "+this.user.getName()+" found!");
			Attachments att = super.manager.find(Attachments.class, attID);
			att.setUser(this.user);
			super.manager.remove(att);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			super.manager.getTransaction().rollback();
		}finally{			
			super.closeConnection();			
		}
	}
	
	protected void editReference(Long userID, Long refID, References refnew){
		try{
			System.out.println("Editing references...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.printf("User: "+this.user.getName()+" found!");
			System.out.println("Looking for the reference...");
			refnew.setId(refID);
			refnew.setUser(this.user);			
			super.manager.merge(refnew);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();								
		}catch(Exception e){
			System.out.println("There was an error, undoing operations..."+e.toString());
			super.manager.getTransaction().rollback();
		}finally{			
			super.closeConnection();			
		}
	}
	
	protected void editAttachment(Long userID, Long attID, Attachments attnew){
		try{
			System.out.println("Editing attachments...");			
			super.openConnection();
			System.out.println("Beginning transaction ...");			
			super.manager.getTransaction().begin();
			System.out.println("Looking for the user...");
			this.user  = super.manager.find(User.class, userID);
			System.out.println("Looking for the attachment...");
			System.out.printf("User: "+this.user.getName()+" found!");			
			System.out.println(attID);
			attnew.setId(attID);
			attnew.setUser(this.user);					
			super.manager.merge(attnew);
			System.out.println("Recording changes...");
			super.manager.getTransaction().commit();								
		}catch(Exception e){
			System.out.println("There was an error, undoing operations...");
			e.printStackTrace();
			super.manager.getTransaction().rollback();
		}finally{			
			super.closeConnection();			
		}
	}	
}
