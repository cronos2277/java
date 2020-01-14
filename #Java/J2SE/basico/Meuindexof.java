import java.util.ArrayList;
public class Meuindexof{
	public static void main(String [] args){
	ArrayList <Integer> numl = new ArrayList <>();	
    for(int i=0;i<11;i++){
    numl.add(i*i+i); 
	System.out.println(numl.get(i));}
	System.out.println("\n");
	numl.remove((numl.size()) - 1);
	int numi = numl.indexOf(12);
	for(int i =0;i<numl.size();i++)
	System.out.println(numl.get(i));
	System.out.println("\n"+numi+"\n"+numl.contains(12));
}

}
//.indexOf(O valor a ser procurado). O mesmo retorna um inteiro com a posição, do objeto a ser encontrado. O mesmo retorna negativo quando não acha nada.
