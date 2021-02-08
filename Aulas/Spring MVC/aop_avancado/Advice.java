package Springann.aop.avancado;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advice {
	
	@Around(value = "execution (public void durante())")
	public void during(ProceedingJoinPoint point){		
		double loteria = Math.random();
		System.out.println("Loteria: "+loteria);
		if(loteria < 0.5)
			System.out.println("Executando o @Around, o durante esta sem parametros: Travou aqui");
		else
			try {
				System.out.println("Executando o @Around, o durante esta sem parametros: Avancando...");
				point.proceed();
			} catch (Throwable e) {				
				e.printStackTrace();
			}
	}
	
	@Around("execution(public void durante(boolean))")
	public void duringParam(ProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		boolean advance = false;
		for(Object arg: args) {
			advance = (Boolean) arg;
		}
		if(advance) {
			try {
				System.out.println("Executando o @Around, o durante esta com parametro verdadeiro: Avancando...");
				point.proceed();
			} catch (Throwable e) {				
				e.printStackTrace();
			}
		}else {
			System.out.println("Executando o @Around, o durante esta com parametro falso: Travou aqui");
		}
	}
	
	@Before(value = "@target(Springann.aop.avancado.Anotado)")
	public void annotation() {
		System.out.println("@Before: Executando o metodo com @target sem os argumentos.");
	}
	
	@After(value="target(Springann.aop.avancado.Classe)")
	public void target() {
		System.out.println("@After: Executando o método com 'target'");
	}
	
	@AfterReturning(pointcut = "args(param)",returning="java.lang.Double")
	public void returning(double param) {
		System.out.println("@AfterReturning, valor do parametro informado: "+param);
	}
	
	@AfterThrowing(pointcut="@target(Springann.aop.avancado.Anotado)", throwing="erro")
	public void throwing(Exception erro) {
		System.out.println("@AfterThrowing, Erro tratado: "+erro.getMessage());
	}
}
