import java.util.*;
abstract class pai{
protected String nome;
protected int idade;
protected String cidade;
}

interface padrao{
public void assinar(int ass);
}

class basica extends pai{
Scanner entra = new Scanner(System.in);

public String nnome(String nome){
System.out.println("Dígite um nome:");
super.nome = entra.nextLine();
return super.nome;
}
public int iidade(int idade){
	System.out.println("Dígite a idade:\n");
	super.idade = Integer.parseInt(entra.nextLine());
	return super.idade;
}
public String ccidade(String cidade){
	System.out.println("Dígite o nome de uma cidade:");
	super.cidade = entra.nextLine();
	return super.cidade;
}
public void imprimir(){
	System.out.println("\n\nO nome é: "+super.nome);
	System.out.println("A idade é: "+super.idade);
	System.out.println("A cidade é: "+super.cidade);

}
public basica(){
	System.out.println("\nIniciando cadastramento de clientes\n");
}
}

public class polimorfismo extends basica implements padrao{
public static void main(String [] args){

basica b = new basica(); 
b.nnome(b.nome);
b.iidade(b.idade);
b.ccidade(b.cidade);
b.imprimir();
}
public void assinar(int ass){}
}
//A palavra super, é usada para ter acesso a classe superior.
//Classes abstradas não pode ser instanciadas, e o seu uso impõe uma padronização, as classes filhas.
//diferente do private, o protected não tem frescura para ser lido. "public" são varáveis globais, 
//"protected" variáveis que podem ser acessadas pelas classes filhas, "private" classes que só podem,
//ser acessada dentro da própria classe.
