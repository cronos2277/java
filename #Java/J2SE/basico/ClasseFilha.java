import java.util.*;
class principal{
private String nome;
private int idade;

public void setNome(String nome){
this.nome = nome;
}
public void setIdade(int idade){
this.idade = idade;
}
public String getNome(){
return this.nome;
}
public int getIdade(){
return this.idade;
}
}
public class ClasseFilha extends principal{
public static void main(String [] args){
Scanner entra = new Scanner (System.in);
principal p = new principal();
System.out.println("Dígite um nome");
p.setNome(entra.nextLine());
System.out.println("Dígite a idade");
p.setIdade(Integer.parseInt(entra.nextLine()));
System.out.println("O nome é: "+p.getNome()+"\n A idade é: "+p.getIdade());
}

}
//Pelo amor de deus o eo set get tem a sintaxe de uma função, nunca esqueça isso.
//exemplo de herança, o extends, significa que a classe está herdadndo da outra.
//Classes filhas também, tem que se instanciar, seja como pai, seja como filha mesmo.