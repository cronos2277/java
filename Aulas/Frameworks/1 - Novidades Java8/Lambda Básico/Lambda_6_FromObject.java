//Requer o Java 8 ou superior para funcionar.

class Classe{
	int a;
	String b;
	public void MetodoClasse(int a, String b){
		System.out.println("Número: "+a+"\nTexto: "+b);
	}
}
interface Lambda{
	public Classe MetodoInterface(int a, String b);
}


public class Lambda_6_FromObject {
	public static void main(String args[]){
	Lambda lambda = (numero,texto) ->{Classe Objeto = new Classe();Objeto.a = numero;Objeto.b = texto;Objeto.MetodoClasse(Objeto.a, Objeto.b);return Objeto;};
	lambda.MetodoInterface(15, "oi");
	}
}
/*				Criando Lambda usando um Objeto.
 * Primeiramente uma coisa deve ficar clara. Inicialmente só se pode fazer esse procedimento, se a Interface
 * tiver apenas um método. Se acontecesse da Interface Lambda, por exemplo ter mais de um método, dai já não daria certo.
 * No exemplo anterior isso só funcionou, porque a interface ActionListener, tem apenas um único método, o ActionPerformed.
 * Essa regra a princípio se aplica, apenas para interfaces, no caso de criar lambda com Classes, essa limitação pode ser superada.
 * Então criamos uma lambda aos moldes da interface. Quando você cria uma lambda, você está "instanciado" aqui no caso uma interface,
 * no caso foi informado dois parâmetros, seguindo a interface lambda como espelho, e após a seta a direita, temos o objeto sendo instanciado
 * a definição de valores, e a execução de um método da própria classe, após tudo isso o retorno do valor do objeto.
 * Repare também, que quando foi executado a função que exibe o inteiro e o texto na tela, não foi chamado o método da classe, e sim da Interface.
 * O metodo da interface, tem a sua estrutura espelhada na interface, entretanto a mesma consegue exibir os valores do Objeto na tela.
 * isso ocorre porque ao executar o método da interface, após a instanciação do objeto, a definição de valores, é executado o método da Classe,
 * e tudo que o método da interface faz, é executar tudo em ordem.
 */


