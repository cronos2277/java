import java.util.ArrayList;
public class Command{
	
	public static void main(String args[]){
		People person = new People();
		person.setName("João");
		person.setAge(26);
		person.setFunction("Estudante");
		Manager manager = new Manager();
		manager.add(person);
		manager.commit();
		manager.print();
	}
	
}

//Um bean como qualquer outro.
class People{	
	private String name;
	private int age;
	private String function;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setFunction(String function){
		this.function = function;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getFunction(){
		return this.function;
	}
}

//Este é a interface que todas as classes do padrão Command 
interface Cmd{	
//Uma interface COmmando só pode ter um método na interface,
//No caso é um método para cada interface Comando, com uma classe
//exclusiva para tratar de cada método de cada interface.
//exclusiva para trabalhar com ele.
	public void commit();	
}

//Essa é a classe operacional desse projeto.
class Execute{
//Essa classe não implementa o CMD, essa classe serve para registrar
//Essa classe ela lida com registros
//Abaixo é criado um registro.
	private static ArrayList<People> register = new ArrayList<People>();
//Esse método adiciona um registro
	private static void setRegister(People person){
		register.add(person);
	}
//Esse método ele exibe os dados do registro na tela, usa-se o laço foreach.	
	private static void show(){
		for(People person: register){
			System.out.println("Nome  : "+person.getName());
			System.out.println("Idade : "+person.getAge());
			System.out.println("Função: "+person.getFunction());
			System.out.println("\n----------------------------\n");
		}
	}
//Como o método setTegister é privado, é por esse método que o usuário irá
//adicionar um novo valor.	
	public void save(People person){
		setRegister(person);
	}
//Ele chama o método privado show().	
	public void print(){
		show();
	}
}

//Essa classe é a destinada ao usuário final. Ela sim implementa a interface
//command.
class Manager implements Cmd{
//Repare que essa classe usa a Classe execute para operar, ela é uma
//classe que implementa o CMD e que ao mesmo tempo faz uso dos métodos 
//do execute.
	private Execute execute = new Execute();
	private People person = new People();
	public void add(People people){		
		this.person = people;		
	}	
	
	public void print(){
		this.execute.print();
	}
//Nessa classe é implentado o método do command. Ao acionar o commit
//é executado o Comando, nesse o comando faz com que o registro do
//execute seja preenchido.
	public void commit(){
		this.execute.save(person);
	}
}
/*
 * O Command ele serve para encapsular solicitações. No padrão Command
 * você tem uma interface e uma classe ou mais para tratar dela, normalmente
 * existe apenas um método dentro das interfaces, porém pode se ter mais.
 * Cada método dessa interface terá que ter uma ou mais classe para lidar
 * com ele e por fim uma classe que será usada pelo usuário final. No caso
 * nós temos a classe Execute, ela contém toda a estrutura e é nela que 
 * são definidos os funcionamentos dos métodos, no caso a manager apenas
 * os ordena e dá um sentido ao commit() que é o método da interface, 
 * o trabalho em sí é feito pela classe de auxílio, esse é o pulo do gato 
 * para o encapsulamento. No padrão Command você tem uma interface, 
 * ou classe abstrata, além disso você tem uma classe que faz todo o trabalho,
 * ou seja que irá servir de auxilio, e por fim você vai criar uma terceira
 * classe para implementar o método da interface de comando e para trabalhar
 * com a classe de auxílio. Lembre-se essa classe que vai implementar 
 * ou extender esse método, ela não vai definir funcionalidades aos métodos,
 * ela apenas vai usar uma instancia da classe de auxílio e criar uma uma
 * espécie de "facade" entre a classe de auxílio e o usuário desse objeto, 
 * além de adaptar as funcionalidades do método implementado ou extendido.
 * Resumindo uma interface ou classe abstrata, uma classe concreta de auxílio
 * que irá definir funcionalidades aos métodos e valores aos atributos, e por
 * fim uma terceira classe que será uma espécie de facade que irá implementar
 * e definir funcionalidades para os métodos, usando uma instancia da classe
 * de auxílio, para trabalhar. Esse padrão é usado no actionListener, Keyboard
 * Lister, Mouse Listener e no Action Event também.
 * 
 * Estrutura do Command
 * -> Uma interface ou classe abstrata com um ou mais métodos.
 * -> Uma classe concreta que servirá de auxílio, ou seja que vai fazer o trabalho.
 * -> Uma classe que implementa a interface, ou extende a classe abstrata
 * e use essa classe de auxílio, é importante nesse padrão que o processamento
 * das instruções seja feito na classe de auxílio, pois isso se faz necessário
 * uma vez que a proposta do Commando é encapsular as solicitações, e quando
 * você usa um outro objeto e não o próprio para fazer isso, você está encapsulando,
 * as solicitações dentro de um outro objeto, além disso a finalidade dessa
 * classe é dar funcionalidade apenas ao método da interface ou da classe abstrata.
 * */




