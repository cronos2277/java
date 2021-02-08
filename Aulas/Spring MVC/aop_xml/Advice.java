package Spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	
	public void before() {
		System.out.println("Executando método BEFORE de Advice");
	}
	
	public void after() {
		System.out.println("Executando método AFTER de Advice");
	}
	
	public void around(ProceedingJoinPoint point) throws Throwable{
		System.out.println("Executando método AROUND de Advice");
		point.proceed();
	}
	
	public boolean after_returning() {
		System.out.println("Executando método AFTER_RETURNING de Advice");
		return true;
	}
	
	public void after_throwing(Exception erro) {
		System.out.println("Executando método AFTER_THROWING de Advice: "+erro.getMessage());
	}

}
