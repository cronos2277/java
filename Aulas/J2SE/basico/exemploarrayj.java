import java.util.ArrayList;
public class exemploarrayj{
	public static void main(String [] args){
		ArrayList <Integer> lista = new ArrayList <Integer> ();
		for(int j=0;j<2;j++){
			if(j==0)
		for(int i=0;i<10;i++){
			lista.add(2*(i*i));
			System.out.println("O valor do Array, e: "+i+" O valor e: "+lista.get(i));
		}
		System.out.println("\n");
			if(j==1)
		for(int i=0;i<10;i++){
			lista.set(i,i+i);
			System.out.println("A raiz quadrada de "+i+" e: "+lista.get(i));
		}
	}
	}
}
