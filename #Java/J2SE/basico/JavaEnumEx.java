enum constantes{
	A(3.14), B(5.25); //Constantes sempre devem ter o nome em maiúsculo.
	
	private double num; //Variável criada para ser usada no construtor.
	
	constantes(double num){ //Padrão de um construtor de um enum, nome do enun mais tipo e varíavel.
		this.num = num;
		}
	public double getConstantes(){ //aqui o método pelo qual as classes recuperarão os valores dos Enum.
		return this.num;
	}
}
public class JavaEnumEx{
	public static void main(String [] args){
		System.out.println(constantes.A); //Função exibe o nome da enum.
		System.out.println(constantes.B.getConstantes()); //Exibe os valores das variáveis enums.
		
	}
}
