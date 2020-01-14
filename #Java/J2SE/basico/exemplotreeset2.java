import java.util.TreeSet;
public class exemplotreeset2{
	public static void main(String [] args){
		TreeSet <Integer> tree = new TreeSet <Integer> ();
		for(int i=0;i<10;i++){
			if(i==9) System.out.println(tree.toString());
			tree.add(-2*(i*i));
			}
	}
}
