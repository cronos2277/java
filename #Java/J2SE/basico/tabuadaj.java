import java.util.ArrayList;
public class tabuadaj{
	public static void main(String [] args){
	ArrayList <Integer> numl = new ArrayList <>();
		//criando Arrays para a tabuada.
		for(int i=0;i<11;i++)
		numl.add(i+1);	
		
		//Preparando para exibir na tela.
		for(int j=1;j<101;j++){
		System.out.print("Tabuada do "+j+" ==> :");	
		for(int i=0;i<11;i++){
		numl.set(i,i*j);
		if(numl.get(i) != 0)
		System.out.print(""+numl.get(i)+", ");
		if(i==10)System.out.println("\n");
	}}
	}
}
