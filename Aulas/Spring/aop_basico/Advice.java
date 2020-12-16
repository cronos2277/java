package Springann.aop;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Advice {
	
	@Before("execution(public void antes())")
	public void before() {
		System.out.println("Executando o metodo referente ao @Before");
	}
	
	@After("execution(public * dep*())")
	public void after() {
		System.out.println("Executando o metodo referente ao @After");
	}
	
	@AfterReturning("execution(public void depois(boolean))")
	public void afterReturning() {
		System.out.println("Executando o metodo referente ao @AfterReturning");
	}
	
	@AfterThrowing("execution( * * (..))")
	public void afterErrors() {
		System.out.println("Executando o metodo referente ao @AfterThrowing");
	}	
	
}
