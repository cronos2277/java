package Springann.aop.composicao;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {

	@Pointcut(value="target(Springann.aop.composicao.Contrato)")
	public boolean contrato() {
		System.out.println("Esse metodo nao sera chamado");
		return false;
	}
	
	@Pointcut("@target(Springann.aop.composicao.Anotacao)")
	public boolean anotacao() {
		System.out.println("Esse metodo nao sera chamado");
		return true;
	}
	
	@Before("contrato()")
	public void before() {
		System.out.println("Executando o metodo com @Before");
	}
	
	@AfterReturning("anotacao() && contrato()")
	public void afterReturning() {
		System.out.println("Executando o metodo com @AfterReturning");
	}
	
	@AfterThrowing(pointcut="anotacao() || !anotacao()", throwing="erro")
	public void afterThrowing(Exception erro) {
		System.out.println("@AfterThrowing: Erro provocado com o:"+erro.getMessage());
	}
	
}
