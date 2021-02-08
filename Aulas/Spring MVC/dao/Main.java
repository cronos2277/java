package Spring.dao;
import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/dao/persistence.xml");
		Actions jdbc = (Actions) app.getBean("bean");		
		Bean bean = new Bean();
		//bean.setName(JOptionPane.showInputDialog("Novo nome"));
		//jdbc.saveOrUpdate(bean);		
		System.out.println(jdbc.getOne(2));
	}

}
