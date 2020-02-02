package pkg.connection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import pkg.main.Do;
import pkg.main.Main;

abstract class ConnectionFactory {	
	private final String[] persistance_name = {"mysql"};	
	protected EntityManagerFactory factory;
	protected EntityManager manager;
	public ConnectionFactory(){			
		this.openConnection();	
	}	
	
	protected void openConnection(){
		try{			
			System.out.println("Trying to connect to the database...");			
			this.factory = Persistence.createEntityManagerFactory(this.persistance_name[0],persistenceAtRun());
			this.manager = this.factory.createEntityManager();
			System.out.println("Connection succeeded!");			
		}catch(Exception error){
			System.out.println("Error when connecting to the database.");
			this.closeConnection();
			Do.logginError(error);			
		}
	}
	
	protected void closeConnection(){
		try{
			System.out.println("Closing connection to the database...");			
			this.manager.close();
			this.factory.close();
			System.out.println("Database closed!");
		}catch(Exception e){
			System.out.println("Error closing the database!");
		}
	}
	
	private Map<String,String> persistenceAtRun(){
		Map<String, String> persistenceMap = new HashMap<String, String>();		
		persistenceMap.put("javax.persistence.jdbc.user", Main.username);
		persistenceMap.put("javax.persistence.jdbc.password", Main.password);
		persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		persistenceMap.put("javax.persistence.jdbc.url", Main.url);
		persistenceMap.put("eclipselink.ddl-generation","create-tables");
		return persistenceMap;
	}
}


