package Springann.datasource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerData {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/datasource/persistence.xml");
    	ApplicationContext app = classPath;   	
    	JdbcTemplate jdbc = app.getBean(JdbcTemplate.class);
    	List<Object> list = jdbc.queryForList("Select name from cliente", Object.class);    
    	System.out.println("\nLista de nomes:\n");
    	for(Object obj: list) {
    		System.out.println(obj);
    	}
    	classPath.close();    

	}

}
