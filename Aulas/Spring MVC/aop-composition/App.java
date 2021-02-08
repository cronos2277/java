package Springann.aop.composicao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/composicao/spring.xml");
    	ApplicationContext app = classPath;
    	Contrato alvo = (Contrato) app.getBean("alvo");    	
    	if(Math.random() < 0.5)
			alvo.erro();
		else
			alvo.metodo();
    	classPath.close();    	
    }
}
