package Spring.persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/persistence/persistence.xml");
		JdbcTemplate jdbc = (JdbcTemplate) app.getBean("dao");	
		System.out.println(jdbc);

	}

}
