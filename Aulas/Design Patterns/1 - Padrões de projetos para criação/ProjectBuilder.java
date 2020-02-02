public class ProjectBuilder{
	
	public static void main(String args[]){
		Concrete concrete = new Concrete();
		Person person1 = concrete.buildPerson(1,"César");
		Person person2 = concrete.buildPersonNick(2,"Júlia","Augustina");
		concrete.showIt(person1);
		concrete.showIt(person2);
	}
	
}

interface Builder{ //Construtor Builder
	public Person buildPerson(int id, String name);
	public Person buildPersonNick(int id, String name, String nick);
}

	class Person{ //Conteúdo da Classe que o Builder vai construir.
	protected Person(){}
	protected int id;
	protected String name;
	protected String nick;
	
	protected void setName(String str_name){
		this.name = str_name;
	}
	
	protected void setNick(String str_nick){
		this.nick = str_nick;
	}
	
	protected void setId(int num){
		this.id = num;
	}	
	
}

class Concrete extends Person implements Builder{ //aqui é feito a inserção de dados
	public Person buildPerson(int id, String name){
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		return person;
	}
	
	public Person buildPersonNick(int id, String name, String nick){
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setNick(nick);
		return person;
	}	
	
	public void showIt(Person person){
		System.out.println("Dados do ID: "+person.id+"\nNome: "+person.name+" |Nick: "+person.nick+"\n");
	}
}
/*
 * O padrão de projeto Buider trabalha quando a classe tem parâmetros opcionais. Toda a implementação do padrão é feita em uma
 * classe abstrata. Veja que o objeto aceita o id ou o nome apenas, caso seja usado o método buildPerson, ou ele
 * aceita um apelido também, caso seja usado o BuildPersonNick, é Válido lebrar que deve-se ter uma interface contendo
 * os métodos a serem usado pelo cliente, que será implementado na classe concreta e uma classe abstrata, ao qual a
 * classe concreta vai herdar valores, essa classe abstrata deve ser organizada em um javabean.
 * 
 * */
