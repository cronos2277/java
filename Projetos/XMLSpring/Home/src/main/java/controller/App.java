package controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	
    public static void main( String[] args )    {
		ApplicationContext spring = new ClassPathXmlApplicationContext("model/spring.xml");    	
    }
}
