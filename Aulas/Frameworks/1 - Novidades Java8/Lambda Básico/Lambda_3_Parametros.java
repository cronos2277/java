//Requer o Java 8 ou superior para funcionar.

interface Interface{
	public int Funcao(int a, int b);
}


public class Lambda_3_Parametros {

	public static void main(String[] args) {
		//a = 5;
		Interface multiplicacaoAB = (a,b) -> a*b; //Criando a lambda, com parametros.
		Interface somaAB = (a,b) -> a+b; //aqui é usado as variaveis a e b;
		int c = multiplicacaoAB.Funcao(2, 2);
		int b = somaAB.Funcao(3, 3);
		System.out.println("A multiplicação de A e B é:"+c);
		System.out.println("A soma de A e B: "+b);
		
	}

}
/*							Lambda com Parâmetros.
 *	Para se criar uma lambda apartir de um método abstrado, que se exige parâmetros, segue-se
 *  o procedimento acima. Primeiro trate a interface, como se objeto fosse. após o igual
 *  dentro dos parenteses coloque uma variável, para ser usada como referencia. Veja que a
 *  variavel b foi usada como parametro tanto na soma, quanto na multiplicação AB, como um
 *  Integer que recebe o valor da função. é importante, quando for definir uma variavel para
 *  ser usada como parãmetro para lambda, que a mesma não seja usada, antes da criação da
 *  lambda. Pois acusará erro. A int b não deu erro ali, porque foi declarado após a lambda.
 *  Descomente a variavel "a" acima e entenda na pratica, o que eu digo. o b não deu esse problema
 *  porque foi delarada depois. Após a indicação da lambda, prosseguimos com o método. No
 *  somaAB, estamos dizendo que queremos a soma de a e b, em multiplicacaoAB a sua multiplicacao.
 *  A operação matematica ocorre, quando o "objeto da interface" criado pela lambda executa a função.
 *  Quando ele executa a função, ele segue os procedimentos declarados na lambda.
*/
