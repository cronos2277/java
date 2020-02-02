import java.util.TreeSet;
import java.util.ArrayList;
public class MeuTreeset{
	public static void main(String [] args){
		TreeSet <Integer> tree = new TreeSet <Integer> ();
		ArrayList<Integer> numl = new ArrayList <Integer> ();
		for(int i=0;i<10;i++){
		tree.add(-2*(i*i));
		numl.add(-2*(i*i));
		}
		System.out.println("Método TreeSet: "+tree.toString());	
		System.out.println("Método ArrayList: "+numl.toString());
	}
}
