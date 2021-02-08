package Springann.aop.avancado;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/avancado/config.xml");
    	ApplicationContext app = classPath;
    	Classe bean = (Classe) app.getBean("classe");  	
    	bean.erro();
    	classPath.close();    	
    }
}
