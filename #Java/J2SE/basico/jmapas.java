import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Iterator;
public class jmapas{
	public static void main(String [] args){
		ArrayList <String> binario = new ArrayList <String>();
		TreeSet <Integer> potencia = new TreeSet<Integer>();
		HashMap <Integer, Double> mapa = new HashMap<Integer, Double>();
		//ArrayList ==> Instanciando.
		int num = 10; //Essa vai ser a variavel, para controle dos laços.
		for(int i=0;i<num;i++){
			binario.add(Integer.toBinaryString(i));
			potencia.add(i * i);
			mapa.put(i,Math.sqrt(i));
		}
		
		for(int i=0;i<num;i++){
			double j = mapa.get(i); 
			System.out.println("O Valor binário de "+i+" é: "+binario.get(i));
			System.out.println("A raiz quadrada de "+i+" é: "+j);
			System.out.println("\n");
			
		}
		System.out.println("Lista dos quadrados: "+potencia);
	}
}
