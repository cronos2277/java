package Spring.rmi.server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerInit 
{
    public static void main( String[] args )
    {
    	ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/rmi/server/server.xml");    
    	Contrato bean = (Contrato) app1.getBean("identificador");	
    	System.out.println("Data: "+bean.getDate());
    	System.out.println("Aleatorio: " + bean.aleatorio());
    	System.out.println("Servidor está ouvindo...");
    }
}