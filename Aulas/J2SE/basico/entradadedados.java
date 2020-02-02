import java.util.Scanner;
import java.util.TreeMap;
public class entradadedados{
public static void main(String [] args){
TreeMap<Integer, String> lista = new TreeMap<Integer, String>();
   Scanner dados = new Scanner(System.in);
System.out.println("Digite um texto: ");
     String texto = dados.nextLine();
     lista.put(1,texto);
     System.out.println("Seu nome é: "+lista.get(1));
}	
}
// A classe Scanner, trabalha com Strings apenas, se for usar ela com outros tipos
//de dados tem que fazer a conversão com o Parse. Ao instanciar-la é necessario
//estipular um valor no construtor na hora de instanciar. Para usar tem importar a 
//classe Scanner. Recomenda-se o uso do try catch, para evitar erros com entrada,
//de dados.