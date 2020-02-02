//Requer o Java 8, ou superior.
import java.util.function.Consumer; //Importando a classe para ser usado no Consumer.
import javax.swing.JOptionPane; //Importando a biblioteca JOptionPane do javax.sing
public class ConsumerExemplo {
	public static void main(String[] args) {
		//Criando um consumer.
		Consumer<String> Funcao = (String ParametroDaFuncao) ->{JOptionPane.showMessageDialog(null, ParametroDaFuncao);};
		String temp = JOptionPane.showInputDialog("Informe um texto a ser exibido: ");
		if(!temp.isEmpty()) //Caso o valor seja nulo, não é executado o Consumer.
		Funcao.accept(temp);

	}

}/*									Entendendo o Consumer.
 * Consumer no caso, é uma função do pacote function. O consumer deve ser indicado ali, pois
 * existem outras formas de consumo de dado, como o Biconsumer por exemplo, por isso a necessidade
 * de especificar. Além disso é expecificado, que tipo de dado que será consumido pela expressão lambda, Consumer
 * <O tipo de dado que entra na expressão> 
 * Após isso temos o Funcao, que será o nome dado a expressão Lambda, que poderia ser escolhido qualquer um.
 * Esse nome será usado quando for necessário chamar o método lambda. Após temos o igual, que tem o parenteses,
 * dentro deles a variavel e o tipo dela, o mesmo sera usada como parametro, semelhante ao uso de métodos.
 * Bom repare na linha Funcao.accept(temp). Bom tem a Funcao que foi criado acima, além disso tem o método
 * accept, que executa a expressão labda criada acima, ela usa o mesmo tipo de parametro que o definido após o igual.
 */
