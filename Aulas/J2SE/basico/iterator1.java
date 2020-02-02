import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
public class iterator1{
	public static void main(String [] args){
		TreeSet <Integer> tree = new TreeSet<Integer> ();
		for(int i=0;i<11;i++){
		tree.add(i);	
		}
		Iterator treel = tree.iterator();
		while(treel.hasNext()){
			Object objeto = treel.next();
			System.out.println("O valor atual �: "+objeto);
		}
	}
		
}
			 
	

  
  
    
  
