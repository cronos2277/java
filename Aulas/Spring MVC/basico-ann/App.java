package Springann.annotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/annotations/spring-ann-basico.xml");
    	ApplicationContext app = classPath;
    	Bean1 bean = (Bean1) app.getBean("bean1");    	
    	System.out.println(bean);    	
    	classPath.close();    	
    }
}
