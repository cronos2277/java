import java.util.HashMap;
public class hashmapex1{
	public static void main(String [] args){
		HashMap <Integer, String> lista = new HashMap <Integer, String> ();
		lista.put(0,"Número 01");
		lista.put(1,"Número 02");
		lista.put(2,"Número 03");
		lista.put(3,"Número 04");
		
		String num[] = new String[lista.size()];
		for(int i=0;i<4;i++){
		num[i] = lista.get(i);
		System.out.println(num[i]);
	}
	}
	
	
}
