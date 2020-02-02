import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
public class escanear{
	public static void main(String [] args){
	TreeMap<Integer, String> dados = new TreeMap<Integer, String>();
	ArrayList<Integer> idade = new ArrayList<Integer>();
	Scanner valor1 = new Scanner(System.in);
	Scanner valor2 = new Scanner(System.in);

	System.out.println("Digite um nome: ");
	String nome = valor1.nextLine();
	dados.put(1,nome);
	
		try{
			int num = 0;
			System.out.println("Informe a idade: ");
			String temp = valor2.nextLine();
			num = Integer.parseInt(temp);
			idade.add(num);	
		}catch(Exception e){
	System.out.println("Valor informado, não é valido");}
		
	System.out.println("O nome é: "+dados.get(1));
	System.out.println("A idade é: "+idade.get(0));	
}	
}
//Em relação a a função .next e .nextLine. A função .next() não escreve valor,
//a pós pressionado a barra de espaço. Em relação a o nextLine(), isso já 
//se torna possível.