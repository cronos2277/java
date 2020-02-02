import java.util.*;
public class iteratorjava{
	public static void main(String [] args){
	TreeSet<Integer>lista = new TreeSet<Integer>();
	
		for(int i=0;i<11;i++){
		lista.add(i*i);
			
}
	        Iterator tree = lista.iterator();
		while(tree.hasNext()){
		Object obj = tree.next();
		System.out.println("\nValores dentrodo array,são: "+obj);
		}
		System.out.println("Fim de Programa.");
	}
}
//o IIterator,tem que ser colocado, após preenchida a lista,
// pois ele vai carregar a lista, assim que envocado.
