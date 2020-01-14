//Requer o Java 8 ou superior para funcionar.

interface Multipla{
	String NumeroTexto(int a);
}


public class Lambda_4_ParametrosDiferenteRetorno {

	public static void main(String[] args) {
	Multipla lambda = (a) -> { return "Agora o número "+String.valueOf(a)+", foi convertido para texto.";};	 
	System.out.println(lambda.NumeroTexto(5));
	}

}
/* 				Lambda com Parâmetros diferente do retorno.
 * 	No caso aqui temos uma função que recebe um inteiro e devolve um String. Nesse caso
 * 	não se tem grandes novidades, apenas a palavra reservada return. Pois a regra é a 
 *  mesma, pois é como se um método fosse. 
 */