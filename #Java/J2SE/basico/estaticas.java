class funcao{
	static int codigo = 0;
	private String nome;
	public String cidade;
	
	void setNome(String nome){
	this.nome = nome;
	}
	String getNome(){
		return this.nome;
	}
	void func(){
		this.codigo +=1;
		System.out.println("\n\nO nome �: "+this.nome);
		System.out.println("A cidade �:"+this.cidade);
		System.out.println("O n�mero de clientes �:"+this.codigo);
	}
}

public class estaticas{
	public static void main(String [] args){
		funcao funk = new funcao();
		funk.setNome("Jos�");
		funk.cidade = "Guarapuava";
		funk.func();
		funcao fnk = new funcao();
		fnk.setNome("Lucas");
		fnk.cidade = "Curitiba";
		fnk.func();
		
	}
}
//As vari�veis est�ticas n�o precisam ser instanciadas, para que se possa fazer uso delas.
//As o uso das vari�veis est�ticas, pode ser feito em qualquer parte do c�digo. 

