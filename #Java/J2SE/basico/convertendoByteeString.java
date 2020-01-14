import java.util.*;
public class convertendoByteeString{
public static void main(String [] args){
byte var1b = Byte.MAX_VALUE;
byte var2b = Byte.MIN_VALUE;
System.out.println("\nVariável Byte, valor mínimo: "+var1b+"\nVariável Byte, valor máximo: "+var2b);
Scanner entra = new Scanner(System.in);
System.out.println("Insira um valor String, para ser convertido ao tipo Byte: ");
String var1s = entra.nextLine();
byte var3b = Byte.parseByte(var1s);
System.out.println("Valor da String, convertido para byte: "+var3b);
String var2s = Byte.toString(var1b);
String var3s = Byte.toString(var2b);
System.out.println("Valor mínimo de um Byte, convertido para uma String: "+var2s+"\nValor máximo de um Byte, convertido para uma String: "+var3s);
}
}
//No que se refere a função "Byte.parseByte() "para converter um numero para Byte, 
//o mesmo deve se encontrar entre o número -128 e 127, números fora desse intervalo, 
//ou qualquer outro caracter já dá problemas. Em uma função como essa, o Trye Catch se faz,
//muito necessário.
//Byte.toString(variável tipo Byte), não tem segredos, tem a mesma lógica do Integer.toString(),ou Boolean.toString().
//Ao que parece, tudo pode ser convertido, ao tipo String.
//A Função Byte.MAX_VALUE (retorna o valor máximo suportado, por varíavel desse tipo).
//A Função Byte.MIN_VALUE (retorna o valor mínimo suportado, por varíavel desse tipo).