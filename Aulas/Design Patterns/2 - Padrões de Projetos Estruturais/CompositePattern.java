import java.util.ArrayList;
public class CompositePattern{
	
	public static void main(String args[]){
//Repare que a classe pai Composite tipifica e as filhas instanciam.
//É válido lembrar que a execução de cada método é exclusivo, não pode
//existir duas classes que permitem executar o mesmo método, por isso
// são lançadas exceptions.
		Composite people = new People("João",26);		
		Composite local = new Locale("Ponta Grossa", "Paraná");
		Composite manager = new Manager(people, local);
		manager.show();
	}
	
}

//Essa é a classe que irá conter todos os métodos e atributos que todas as suas filhas têm.
abstract class Composite{
	protected ArrayList<Composite> register = new ArrayList<Composite>();	
	protected String name =" ";
	protected int age = 0;
	protected String city =" ";
	protected String state = " ";	
	
//É lançado uma exception para as operações que não são executadas em objetos desse tipo	
	public void setAge(int setage){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public void setName(String setname){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public void setCity(String setname){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public void setState(String setname){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public int getAge(){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public String getName(){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public String getCity(){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public String getState(){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public boolean check(Composite people,Composite local){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public Composite auxiliar(Composite a, Composite b){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
	
	public void show(){
		throw new IllegalArgumentException("JVM:~$ Função incompatível.");
	}
//As operações que essa classe executa, não é lançada exceptions, 
//porém esse método só pode ser executado aqui, caso outra classe executa
// é lançado uma exception. A classe Composite tipifica o objeto, mas não
//instancia, além disso os métodos a ser executados só podem ser executados
//por uma das classes, ou essa ou apenas uma de suas filhas, se não o padrão
//perde o sentido de existir.
	
	public Composite getByIndex(int i){
		return this.register.get(i);
	}	
}
//Essa classe filha é um bean, porém os seus métodos e todo o seu conteúdo
//tem na classe pai, nesse padrão apenas a classe pai pode ter métodos
//ou atributos exclusivos as filhas não, as filhas devem ser uma cópia
//parcial da classe pai.
class People extends Composite{
	
	public People(){}
	
	public People(String name, int age){
		this.name = name;
		this.age = age;
	}	
	
	@Override
	public void setName(String nm){
		this.name = nm;
	}
	
	@Override
	public void setAge(int nt){
		this.age = nt;
	}
	
	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public int getAge(){
		return this.age;
	}
	
}
//Nessa classe é trabalhada os objetos do tipo Locale.
class Locale extends Composite{
	
	public Locale(){}
	
	public Locale(String city, String state){
		this.city = city;
		this.state = state;
	}		
	
	@Override
	public void setCity(String city){
		this.city = city;
	}
	
	@Override
	public void setState(String state){
		this.state = state;
	}
	
	@Override
	public String getCity(){
		return this.city;
	}
	
	@Override
	public String getState(){
		return this.state;
	}
	
}
//Aqui é feito uma verificação em busca de valores nulos, é feito também
//o afunilamento de Objetos Composite, transformando 2 em 1 e por fim
//exibido todos os valores na tela.
class Manager extends Composite{	
	public Manager(Composite person, Composite local){
		if(this.check(person, local))
			this.register.add(this.auxiliar(person,local));
		this.name = person.getName();
		this.age = person.getAge();
		this.city = local.getCity();
		this.state = local.getState();		
	}
	
	@Override
	public boolean check(Composite person, Composite local){
		if(person.getName() == " " || person.getAge() == 0)		
			throw new NullPointerException("Objeto People contém pelo menos um valor nulo.");
		if(local.getCity() == " " || local.getState() == " ")
			throw new NullPointerException("Objeto Locale contém pelo menos um valor nulo.");			
		return true;
	}
	
	@Override
	public Composite auxiliar(Composite a, Composite b){
		Composite composite = a;
		composite = b;
		return composite;
	}
	
	@Override
	public void show(){
		System.out.println("Dados <----------------->");
		System.out.println("Nome  : <"+this.name+">");
		System.out.println("Idade : <"+this.age+">");
		System.out.println("Cidade: <"+this.city+">");
		System.out.println("Estado: <"+this.state+">");
	}	
}

/*
 * Composite: Ele deixa tudo padronizado, nesse padrão você tem uma classe
 * abstrata que tem todos os métodos e atributos que servirá de modelo e
 * várias classes filhas que implementam a classe paí e executa parte
 * de seus métodos cada uma. Ela é muito útil quando o assunto é unir
 * vários projetos diferentes em um só.
*/
