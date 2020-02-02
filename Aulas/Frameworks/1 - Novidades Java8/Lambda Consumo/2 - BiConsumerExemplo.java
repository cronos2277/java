import java.util.function.*;
import javax.swing.JOptionPane;
public class BiConsumerExemplo {

	public static void main(String[] args) {
		int alpha;int beta;
		try{alpha = Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para A: "));}catch(Exception e){alpha = 0;}
		try{beta =  Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para B: "));}catch(Exception e){beta  = 0;}
		BiConsumer<Integer,Integer> Soma = (Integer a,Integer b) -> JOptionPane.showMessageDialog(null,"A soma de "+a+", mais "+b+" = "+(a+b)); 
		Soma.accept(alpha, beta);
	}

} 
/*			BiConsumer<tipo de dados de entrada, tipo de dados de saida> Expressão Lambdas = (Parâmetros,Parâmetros) -> expressão.
 * Essa expressão diferente da Consumer, ela trabalha com duas entradas de dados. Válido lembrar que se houvesse mais de uma função
 * dentro da expressão lambda, é necessária por a mesma dentro de chaves. Tanto a BiConsumer, quanto a consumer, não retornam valores.
*/
