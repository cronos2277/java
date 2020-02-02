import java.util.*;
public class convertendoBooleanString{
public static void main(String [] args){
String var1;
boolean var2;
String var3;
boolean var4;
Scanner entra = new Scanner(System.in);
System.out.println("Digite uma valor, para a variavél String");
var1 = entra.nextLine();
var2 = Boolean.parseBoolean(var1);
System.out.println("Valor da variável String, convertida para booleana: "+var2);
System.out.println("\n\n\n\n\n\n\n");
var4 = true;
var3 = Boolean.toString(var4);
System.out.println("O valor do booleano, convertido para String: "+var3);
}
}
//A função Boolean.parseBoolean(), é uma função que recebe uma string e retorna um valor booleano. Essa função,
//só fica verdadeira, se o conteúdo da String for true(sendo qualquer letra maíuscula ou minuscula, 
//se tiver qualquer outra palavra junto, é false também).
//A função Boolean.toString(), é uma função que recebe uma valor booleano e retorna uma String. As Strings,
//retornada por essa função são "false" ou "true", do jeito que escrevi.