package Spring.rmi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Importando a interface do pacote servidor
import Spring.rmi.server.Contrato;

public class ClientInit {

	public static void main(String args[]) {
		try {
			ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/rmi/client/client.xml");    
	    	Contrato bean = (Contrato) app1.getBean("identificador");	
	    	System.out.println(bean.getDate());
	    	System.out.println("Cliente acessando:" +bean.getDate());
	    	System.out.println("Numero aleatorio: "+bean.aleatorio());
		}catch(org.springframework.beans.factory.BeanCreationException error) {
			System.out.printf("Ocorreu o seguinte erro: %s, certifique-se que o servidor esteja escutando no Target correto",error.getMessage());
		}
		
	}
}
