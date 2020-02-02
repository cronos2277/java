
enum val {
	ALPHA(1,1.23,"Olá Mundo",true), BETA(2,2.25,"Foda-se",false); //constantes e os valores que as enuns contém.

//declaração das variáveis a serem usadas, reparem que são todas privadas.
	private int num;
	private double real;
	private String texto;
	private boolean opcao;

//construtor, aqui as variáveis são relacionadas as variáveis do tipo ENum.
	val(int num, double real, String texto, boolean opcao){
	this.num = num;
	this.real = real;
	this.texto = texto;
	this.opcao = opcao;
	}

//metodos para recuperar valores das Enuns, todos os gets.
	public int getNum(){
	return this.num;
	}

	public double getReal(){
	return this.real;
	}

	public String getTexto(){
	return this.texto;
	}

	public boolean getOpcao(){
	return this.opcao;
	}
	
	}
	class pai{
		public pai(){
			System.out.println(val.ALPHA);
			System.out.println(val.ALPHA.getNum());
			System.out.println(val.ALPHA.getReal());
			System.out.println(val.ALPHA.getTexto());
			System.out.println(val.ALPHA.getOpcao());
		}
}
	
	class mae{
		public mae(){
			System.out.println(val.BETA);
			System.out.println(val.BETA.getNum());
			System.out.println(val.BETA.getReal());
			System.out.println(val.BETA.getTexto());
			System.out.println(val.BETA.getOpcao());
			System.out.println();
		}
	}
public class TesteEnum{
	public static void main(String [] args){
	pai Pai = new pai();
	System.out.println("\n\n");
	mae Mae = new mae();
	}}
