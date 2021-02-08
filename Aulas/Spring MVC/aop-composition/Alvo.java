package Springann.aop.composicao;

@Anotacao
public class Alvo implements Contrato{
	
	public void metodo() {		
		System.out.println("Executando Metodo sem parametros e sem retorno");
	}
	
	public void erro() {
		throw new RuntimeException("Erro provocado!");
	}	

}
