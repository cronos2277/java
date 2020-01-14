import java.util.HashMap;
public class exemplotreeset{
	public static void main(String [] args){
		HashMap <Integer, Double> mapa = new HashMap <Integer, Double> ();
		for(int i=0;i<10;i++){
			mapa.put(i,Math.sqrt(i));
			System.out.println("O valor de "+i+" eh: "+mapa.get(i));
		}
	}
}
