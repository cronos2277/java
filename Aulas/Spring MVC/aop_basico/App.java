package Springann.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
    	ApplicationContext app = classPath;
    	Contrato bean = (Contrato) app.getBean("concreta");    	
    	System.out.println(bean); 
    	//bean.erro();    	
    	classPath.close();    	
    }
}
