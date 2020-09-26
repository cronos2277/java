package Spring.verification;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;


public class Runner {

	public static void main(String[] args) {		
		    	ApplicationContext app1 = new ClassPathXmlApplicationContext("Spring/verification/verification.xml");
		    	Check bean1 = (Check) app1.getBean("check");		    	
		    	System.out.println(bean1);
		    	Errors erros = new BeanPropertyBindingResult(bean1,"check");
		    	bean1.validate(bean1, erros);
		    	for(Object erro: erros.getAllErrors()) {
		    		System.out.println(erro);
		    	}
	}

}
