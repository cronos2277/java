import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Collections{
	public static void main(String args[]){
		Integer[] valores = {1,2,3,4,5,5,6,0};
		final Integer excluirIndice = 2;
		final Integer adicionar = 7;
		final Integer substituir_indice = 2;
		final Integer substituir_valor = 10;
		Collection collection = new Collection();
		System.out.print("\n\nRepare que o Set<Integer> não aceita valor 5 repetido, e ainda ordena os valores\n\t----\n");		
		collection.setValue(valores);
		collection.run();
		System.out.println("\n\nAgora que vem a parte interessante, foi excluído o valor do índice "+excluirIndice+" das listas.");
		System.out.print("O list mantém a mesma estrutura. o Queue moveu para a esquerda todos os seus Elementos, em fila.");
		System.out.print("Repare que o Set definiu do menor para o maior automaticamente.\n\t----\n");
		collection.remValue(excluirIndice);
		collection.run();
		System.out.print("\n\nAgora será adicionado o número "+adicionar+".");
		collection.setValue(adicionar);
		collection.run();
	}
}


class Collection{
	private List<Integer> list;
	private Set<Integer> set;
	private Queue<Integer> queue;
	public Collection(){
		this.list = new ArrayList<Integer>();
		this.set = new HashSet<Integer>();
		this.queue = new LinkedList<Integer>();
	}
	
	public void setValue(Integer[] value){
		for(Integer str: value){
			list.add(str);
			set.add(str);
			queue.add(str);
		}
	}
	
	public void setValue(Integer nt){
		list.add(nt);
		set.add(nt);
		queue.add(nt);
	}
		
	public void remValue(Integer index){
		list.remove(index);
		set.remove(index);
		queue.remove(index);
		}		
	
	private void sysoutList(){
		System.out.print("\nValores do List  <Integer> -> ");
		for(Integer l: list)
			System.out.print(" "+l);
	}
	
	private void sysoutSet(){
		System.out.print("\nValores do Set   <Integer> -> ");
		for(Integer s: set)
			System.out.print(" "+s);
	}
	
	private void sysoutQueue(){
		System.out.print("\nValores do Queue <Integer> -> ");
		for(Integer q: queue)
			System.out.print(" "+q);
	}
	
	public void run(){
		this.sysoutList();
		this.sysoutSet();
		this.sysoutQueue();
	}	
}
	
/*
 * Essas são as Collections em java, execute o código para entender melhor.
 * ----
 * List<Generic> List é interface, ArrayList a classe que foi instanciado.
 * O List<> Permite a edição dos dados, o seja ele permita que você substitua
 * valores e os ordena na medida que vai sendo ordenado, ele apenas adiciona
 * a lista, sem ordenalos.
 * ----
 * Set<Generic> Set é interface, HashSet a classe que foi instanciado.
 * O Set<> ele ordena os valores, do maior para o menor quando for um 
 * Inteiro e seguindo ordem alfabética quando for String. Ele não permite
 * edição, você apenas adiciona e exclui o que quer.
 * ----
 * Queue<Generic> é interface, LinkedList a classe usada. 
 * O Queue<> trabalha com filas, difente dos dois você pode colocar um 
 * no topo e definir prioridades para a thread trabalhar e tem método que
 * retorna false quando a fila acaba. A medida que você exclui que está no
 * topo esse valor é ocupado pelo próximo da fila.
 * */

