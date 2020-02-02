
import java.util.function.Function;

import javax.swing.JOptionPane;
public class FunctionExemplo {
	public static void main(String[] args) {
		Function<Integer,Double> Matematica = (Integer num1) ->  {return Math.sqrt(num1);};
		try{
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número a ser extraído a raiz quadrada."));
		JOptionPane.showMessageDialog(null, "A raiz quadrada de "+numero+" é: "+Matematica.apply(numero));
		}catch(Exception e){JOptionPane.showMessageDialog(null, e);};
	}

}/*		Function<Tipo de Entrada, Tipo de retorno> Matematica = (Parâmetros) -> return do tipo especificado no ripo de retorno.
*	A Funcion é semelhante a Consumer, no entanto a sua diferença é que essa função retorna um valor.
* 	o método .apply(), é justamente o método que executa todos as funções dentro da expressão da lambda. 
*/
