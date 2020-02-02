import java.util.*;
class variaveis{
private String nome;
private int idade;


public String getNome(String nome){
return this.nome;}

public void setNome(String nome){
this.nome = nome;}

public int getIdade(int idade){
return this.idade;}

public void setIdade(int idade){
this.idade = idade;}
}


public class privado{
public static void main(String [] args){
variaveis val = new variaveis();
Scanner entra = new Scanner(System.in);

System.out.println("Digite um nome");
val.getNome(entra.nextLine());
System.out.println("Dígite a idade");
val.getIdade(Integer.parseInt(entra.nextLine()));

}
}
//Quando for usar o get eo set, o padrão é CamelCase, que é quando o get ou o set
//ou o is é concatenado com o nome da variável iniciada com a primeira letra em maíuscula.
//por exemplo, a variavel "padrao" ficaria "getPadrao e/ou setPadrao".
// Ao declarar a variável, a ser tratada pelo get ou set, a mesma deve ser privada.
//Para lidar com booleanos, ao que tudo indica é dirente, tem o "is" ainda.
