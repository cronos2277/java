import java.util.Scanner;
public class Prototype{	
	public static void main(String args[]){
		Exemple original = new Exemple().enterName();
		Exemple clone = original.clone();
		clone.showName();
	}
	
}

abstract class Rules<Class>{
	public int id = 0;	
	protected String name = " ";	
	public abstract Class enterName();	
	public abstract void showName();
}

class Exemple extends Rules<Exemple> implements Cloneable{
	@Override
	public Exemple clone(){
		++id;
		return this;
		}
		
	@Override
	public void showName(){
		System.out.println("Objeto ID("+this.id+") > O nome digitado é: "+this.name);
		}
		
	@Override
	public Exemple enterName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Objeto ID("+this.id+") > Digite um nome\n");
		this.name = scan.nextLine();		
		return this;
		}	
}
/* Definição: "“Especificar tipos de objetos a serem criados usando uma instância 
 * protótipo e criar novos objetos pela cópia desse protótipo.” 
 * 
 * O padrão prototype nada mais é, que um padrão que permite a clonagem de objetos
 * a partir de uma instancia protótipo, pense nisso como sendo uma clonagem com enfoque 
 * no que nos interessa, podendo ser fiel ao objeto clonado ou não, tudo com base em um protótipo.
 * Repare que o objeto que recebe os dados digitados é o original eo objeto que
 * exibe os dados é o objeto clone, porém é valido ressaltar que o objeto clone
 * foi clonado do objeto original, porém a única diferença entre os seus objetos é o valor de ID, 
 * ou seja cada objeto clonado desse protótipo terá os mesmos atributos exceto o mesmo ID.
 * A grande dúvida é da onde que vem a interface Cloneable, essa interface vem da API do Java, 
 * porém o seu uso para fazer a clonagem é facultativo, você pode criar um método que faça isso no braço 
 * se quiser, basta mandar ele retornar a própria classe, ou "this" e fazer ali as alterações entre os protótipos, 
 * caso não deseje uma clonagem em 100% fiel.
 * 
 **/
 
