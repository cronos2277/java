package Spring.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/persistence/persistence.xml");
		JdbcTemplate jdbc = (JdbcTemplate) app.getBean("dao");	
		jdbc.execute("create table if not exists valor (id serial primary key,numero decimal(10,2) not null)");

		int rowAffected = jdbc.update("insert into valor(numero) values (?)",Math.random());
		System.out.println(rowAffected);
		
		List<Map<String,Object>> listas = jdbc.queryForList("Select * from valor");
		System.out.println(listas);
		

	}

}
