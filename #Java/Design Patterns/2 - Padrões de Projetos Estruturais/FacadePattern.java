import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
public class FacadePattern{
	
	public static void main(String args[]){
		Facade facade = new Facade();
		facade.insert(1,"João","Estudante",26);
		facade.commit(); //método que escreve o atributo privado register.
	}
	
}
//Pense no facade como uma espécie de Classe DAO.
class Facade{ 
//seu objetivo aqui é unificar a classe Macro e People colocando assim mais ordem.
	private HashMap<Macro,People> register = new HashMap<Macro,People>();
//Se faz necessário se ter uma instancia das classes que o facade vai trabalhar.
	private People person;
	private Macro macro;
	
//Você pode adicionar os objetos contendo os atributos
	public void insert(Macro macro, People people){ 
		register.put(macro,people);
	}
	
//Ou você pode apenas informar os atributos e deixar o facade, 
// lidar com objetos da classe Macro e People.	
	public void insert(int index, String name, String func, int age){
		People person = new People(name,age,func);
		Macro macro = new Macro(index);
		this.person = person;
		this.macro = macro;
	}
//Se não tiver valores nulos em nenhum dos campos, ele escreve no registro.
	public void commit(){
		if(this.check(this.person,this.macro)){
			register.put(this.macro,this.person);
			System.out.println("Registro criado com sucesso!");
		}
		else //caso falte alguma coisa, lance essa exceção.
			throw new NullPointerException("Erro ao comitar, verique se existe valores nulos.");
	}
//Esse método irá fazer as verificações necessária e certificar de que não haja valores nulos.
	private boolean check(People person, Macro macro){
		if(person != null){
			if(person.getAge() < 1)
				return false;
			if(person.getName() == null)
				return false;
			if(person.getFunc() == null)
				return false;
		}
		if(macro.getCode() < 1)
			return false;
		return true;
	}	
}
//As duas classes abaixo, são as classes que o facade irá trabalhar.
class People{
	private int age;
	private String name;
	private String function;	
	public People(String n, int a, String f){
		this.name = n;
		this.age = a;
		this.function = f;
	}
	
	public void modifyAge(int a){
		this.age = a;
	}
	
	public void modifyName(String n){
		this.name = n;
	}
	
	public void modifyFunc(String f){
		this.function = f;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFunc(){
		return this.function;
	}
}

class Macro{
	private int code;
	private Date created = new Date();	
	private ArrayList<Date> acess = new ArrayList<Date>();
	
	public Macro(int usr){
		this.code = usr;		
		this.acess.add(created);
	}
	
	public Date getCreated(){
		acess.add(new Date());
		return this.created;
	}
	
	public int getCode(){
		acess.add(new Date());
		return this.code;
	}
	
	public ArrayList<Date> getListAcess(){
		return this.acess;
	}
	
	public void modifyCode(int newcode){
		this.code = newcode;
		acess.add(new Date());
	}
}

/*Facade significa fachada, porém diferente de um adapter, isso aqui não
 * é uma central de gambiarra, por isso tenha mais respeito com ela.
 * Esse padrão ele visa criar uma interface mais amigável para o programador.
 * um ótimo exemplo de facade são os DAO, que são classes que visam organizar
 * as outras classes e tornar-las mais organizadas. Lembra que no começo do curso,
 * quando você ia mexer com entidades e com o componente java de mysql, você
 * criava uma classe DAO, dai nessa classe DAO você instanciava as classes
 * que tinham contato com o banco de dados, criando assim uma interface mais amigável,
 * é justamente essa a proposta do facade, criar uma interface mais amigável.
 * Ela é útil quando você tem centenas de classes e você quer implementar uma organização nelas.
 * Existe três classes nesse projeto além da classe com o Main(), você tem uma classe Pessoa
 * que registra uma pessoa, e você tem uma classe Macro que registra os acessos
 * das pessoas, e por fim uma classe facade. Essa classe facade ela trabalha com os
 * dois objetos, anteriormente mencionado, porém ela aceita como parametro, um objeto macro com
 * um objeto pessoa, ou os valores correspondente aos atributos contidos pelas duas classes.
 * Uma vez que você informa os valores, esse objeto ele tem um "commit()" que salva esses
 * valores em um registro. O padrão facade é útil quando o assunto é organização, pois assim
 * você tem todos os valores que necessita em uma só classe.
 * */
