package Springann.aop.avancado;

@Anotado
public class Classe{
	
	public Classe() {
		System.out.println("Executando Construtor");		
	}
	
	public void erro(){
		System.out.println("Executando o metodo de erro");		
		throw new java.lang.RuntimeException("Erro provocado pelo metodo de erro");
	}	

	public void durante() {
		System.out.println("Executando o durante sem parametros");
	}	
	
	public void durante(boolean b) {
		System.out.println("Executando o durante com parametros");
	}
	
	public double retorno(double arg) {
		double random = Math.random() * arg;
		System.out.println("Metodo retorno: "+random);
		return random;
	}	
			
}
