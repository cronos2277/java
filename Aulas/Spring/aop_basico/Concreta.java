package Springann.aop;

public class Concreta implements Contrato{
	
	public Concreta() {
		System.out.println("Executando o construtor");
	}
	
	public void antes() {
		System.out.println("Executando o metodo antes");		
	}

	public void depois() {
		System.out.println("Executando o metodo depois");		
	}

	public void erro() {
		System.out.println("Executando o metodo de erro");		
		throw new java.lang.RuntimeException("Erro provocado pelo metodo de erro");
	}

	public void depois(boolean b) {
		System.out.println("Executando o metodo depois");		
	}	
}
