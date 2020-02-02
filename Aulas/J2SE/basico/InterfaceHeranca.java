import java.util.*;
interface forma{
public String nome1(String nom);
public int idade1(int id);
public String cidade1(String cid);
}

class cadastro implements forma{
protected String nome;
protected int idade;
protected String cidade;
Scanner entra = new Scanner(System.in);

public String nome1(String nom){
System.out.println("Dígite o nome: ");
this.nome = entra.nextLine();
return this.nome;
}

public int idade1(int id){
System.out.println("Dígite a idade: ");
this.idade = Integer.parseInt(entra.nextLine());
return this.idade;
}
public String cidade1(String cid){
System.out.println("Dígite a cidade: ");
this.cidade = entra.nextLine();
return this.cidade;
}
public void imprimir1(){
System.out.println("O nome é: "+this.nome);
System.out.println("A idade é: "+this.idade);
System.out.println("A cidade é: "+this.cidade);
}
}

public class InterfaceHeranca extends cadastro{
public static void main(String [] args){
cadastro cliente = new cadastro();
cliente.nome1(cliente.nome);
cliente.idade1(cliente.idade);
cliente.cidade1(cliente.cidade);
cliente.imprimir1();
}
}
