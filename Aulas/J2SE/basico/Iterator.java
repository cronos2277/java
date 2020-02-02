package br.com.treinaweb.part1;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
public class exemplo1{
	public static void main(String [] args){
		TreeSet <Integer> tree = new TreeSet<Integer> ();
		for(int i=0;i<11;i++){
		tree.add(i);	
		}
		Iterator treel = tree.iterator();
		while(treel.hasNext()){
			Object objeto = treel.next();
			System.out.println("O valor atual é: "+objeto);
		}
	}
		
}
			 
	

  
  
    
  
