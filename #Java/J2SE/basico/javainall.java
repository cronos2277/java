import java.util.*;
public class javainall{
public static void main(String [] args){
//Variáveis
TreeMap<Integer, String> cliente = new TreeMap<Integer, String>();
ArrayList<Integer> idade = new ArrayList<Integer>();	
HashSet<String> cidade = new HashSet<String>();
HashSet<String> estado = new HashSet<String>();	
Scanner enter = new Scanner(System.in);
int nfuncao = 0;
//Função	
try{
System.out.println("-------|Inicio de Programa|-------\n");
System.out.println("Quantos clientes, você quer registrar?");	
nfuncao += Integer.parseInt(enter.nextLine()); 	
	for(int i=1;i<=nfuncao;i++){	
	System.out.println("\n-------|Dados do cliente ("+i+")|-------");	
	System.out.println("Qual o nome do "+i+"º cliente? ");
	cliente.put(i,enter.nextLine());
	System.out.println("Qual é a idade do cliente "+cliente.get(i)+"?");
	idade.add(Integer.parseInt(enter.nextLine()));
	System.out.println("Qual é a cidade do cliente "+cliente.get(i)+"?");
	cidade.add(enter.nextLine());
	System.out.println("Qual é o Estado do cliente "+cliente.get(i)+"?");
	estado.add(enter.nextLine());
}//for	
}catch(Exception e){System.out.println("O último valor inserido, é inválido!");}finally{System.out.println("\n-------|Fim de Programa|-------");}	
}
}
