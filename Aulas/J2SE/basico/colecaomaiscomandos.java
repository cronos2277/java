import java.util.ArrayList;
public class colecaomaiscomandos{
public static void main(String [] args){
ArrayList lista = new ArrayList();
	lista.add("Olá mundo");
	lista.add(Math.sqrt(3));
	lista.add((int)'A');
	lista.add((char)66);
	lista.add(1,"Olá Mundo de Novo");
	lista.add("====>");
for(int i=0;i<lista.size();i++)
System.out.println(lista.get(i));
System.out.println("\n");

	if(lista.contains("====>")){
		int num1 = lista.indexOf("====>");
		lista.remove(num1);
		for(int i=0;i<lista.size();i++)
			System.out.println(lista.get(i));
}



	
}
}