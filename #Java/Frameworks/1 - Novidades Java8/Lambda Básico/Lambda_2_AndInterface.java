//Requer o Java 8 ou superior para funcionar.

interface InterfaceSoma{
	public int FuncaoRetorno();
	
}

public class Lambda_2_AndInterface {

	public static void main(String[] args) {
		InterfaceSoma Soma = () -> 3+2; 
		int soma = Soma.FuncaoRetorno();
		System.out.println(soma);
	}

}

/*				Lambda e Interface.
 * 	Essa interface ela contém um método, que retorna um inteiro. No objeto lambda Soma,
 *  é colocado a expressão 3+2, após isso o int soma = ObjetoLambda.metodoCriadoNaInterface.
 *  o metodo inteiro pega e executa a soma e retorna um inteiro. A lambda originalmente
 *  trabalha com interfaces, mas também pode trabalhar com um Objeto.
 */
 
