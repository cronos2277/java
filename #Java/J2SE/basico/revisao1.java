import java.util.*;
public class revisao1{
 public static void main(String [] args){
 TreeSet <Character> binario = new TreeSet <Character>();
 ArrayList <Double> raiz = new ArrayList <Double>();
 HashMap <Integer, String> chaves = new HashMap <Integer, String> ();
 	String aux = "";
        for(int i=0;i<10;i++){
 	 int aux2 = i;
         binario.add((char)aux2);
 	 raiz.add(Math.sqrt(i));
 	 aux = Integer.toBinaryString(i);
 	chaves.put(i,aux);}
        int j = 0;
 	Iterator iterator = binario.iterator();
 	while(iterator.hasNext()){
 		Object valor = iterator.next();
 		System.out.println("De "+j+": ");
 		System.out.println("A Raiz quadrada é: "+raiz.get(j));
 		System.out.println("Em números binários,fica: "+chaves.get(j));
 		System.out.println("Seu valor na tabela Ascii é: "+valor+"\n");
 		j++;
 		
 	}
 	
 }
}


