package controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static ApplicationContext spring = new ClassPathXmlApplicationContext("model/spring.xml"); 
    public static void main( String[] args )    {
    	if(args.length == 0) {
    		System.out.println("Initiallizing... ");    		
    	}else {
    		for(String arg:args) {
    			System.out.println(arg);
    		}
    		
    	}
		
    }
}
