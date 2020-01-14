import java.util.TreeSet;
public class Meutree{
	public static void main(String [] args){
		TreeSet <Integer> tree = new TreeSet<Integer> ();
			for(int i=0;i<10;i++){
		tree.add(-2*(i*i));
	}
	System.out.println(tree.toString());
	if(tree.contains(-128)){
	tree.remove(-128);
	tree.remove(0);
	tree.add(4564);
	}
	System.out.println(tree.toString());
}
}
// O método TreeSet ele é organizado e ordeiro, a classe procura e remove o valor, sem precisar de especificação, 
// e todos os valores inseridos em seus valores, são ordenados do menor para o maior automaticamente. Muito interessante para trabalhar com números.
// para exibir todo o valor, dentro da fnção System.out.println(), coloque o .toString() .
