import java.util.HashMap;
public class hashmapex2{
	public static void main(String [] args){
		HashMap <Integer,Double> mapa = new HashMap <Integer,Double> ();
		int chave = 10;
		double valor[] = new double[chave];
			for(int i=0;i<=chave;i++){
			mapa.put(i,Math.sqrt(i));	
			}
			mapa.remove(9);
			--chave;
			for(int i=0;i<chave;i++){
			valor[i] = mapa.get(i);
			System.out.println("O valor do Array "+i+", HashMap é: "+valor[i]);
			}
	}
}
//O HashMap é uma alternativa ao TreeSet e ao ArrayList, com a diferença que ele tem uma chave e um valor previamente definido.
//O HashMap ele trabalha com dois valores, ao mesmo tempo, ele serve mais para o mapeamento dos dados.
//".put(primeiro parametro, segundo parametro)" impõe um valor,para a chave e dentro da chave.
//".remove", remove a chave.
//".get(primeiro parametro)", recupera o valor da chave, essa operação diferente do TreeSet e do ArrayList, retorna um valor, definido pelo dado do segundo parâmetro.
