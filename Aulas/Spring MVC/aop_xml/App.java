package Spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Spring/aop/spring.xml");
    	ApplicationContext app = classPath;
    	Clazz clazz = (Clazz) app.getBean("clazz");    
    	clazz.metodo();
    	classPath.close();    

	}

}
