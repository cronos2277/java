import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JOptionPane;
public class ConsumerFunction {

	public static void main(String[] args) {
		Function<Integer,Double> raizq = (Integer a) -> {return Math.sqrt(a);};  
		Consumer<Double> imprimir = (Double b) -> JOptionPane.showMessageDialog(null, "O resultado é: "+b);
		int var = Integer.parseInt(JOptionPane.showInputDialog("Informe o número a ser extraído a raiz: "));
		double resultado = raizq.apply(var);
		imprimir.accept(resultado);
		
	}

}/* 
*	Sobre o Function, uma coisa deve ficar bem clara. o return só deve ser declaro na expressão lambda function
* 	quando o mesmo estiver dentro de chaves"{}", válido lembrar, que no caso de duas ou mais expressões, 
* 	deve-se ser usado as chaves. Nesse caso o Funcion poderia ser escrito como informado abaixo:
*   Function<Integer,Double> raizq = (Integer a) -> Math.sqrt(a); //Isso ocorre porque existe, apenas uma expressão. 
*   No caso de mais expressões, use a sintaxe que foi usada no código. Agora vamos ao Consumer, que poderia ser escrita assim:
*   Consumer<Double> imprimir = (Double b) -> {JOptionPane.showMessageDialog(null, "O resultado é: "+b);};
*   BiConsumer e o Consumer é executado, pelo método .accept(), que executa o método usando o conteúdo dentro dos parênteses, como parâmetro.
*   Já o Function, usa o método .apply, mas com a diferença de que esse método tem um retorno.
*/
