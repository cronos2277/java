import java.util.HashMap;
public class FlyweightPattern{
	
	public static void main(String args[]){
		Client client = new ClassFlyweight();
		client.setName("João");
		client.setAge(26);
		client.setLocate(Flyweight.getLocal("pg")); // Exemplo de Flyweight aplicado.
		client.sysout();
	}
	
}

interface Client{
	public String getName();
	public int getAge();
	public void setName(String str);
	public void setAge(int age);
	public void setLocate(StatesAndCities sc);
	public String getState();
	public String getCity();
	public void sysout();
}


class ClassFlyweight implements Client{
	private String name;
	private int age;
	private StatesAndCities locale;
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setName(String str){
		this.name = str;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setLocate(StatesAndCities sc){
		this.locale = sc;
	}
	
	public String getCity(){
		return locale.getCity();
	}
	
	public String getState(){
		return locale.getState();
	}
	public void sysout(){
		System.out.println("Dados cadastrado:");
		System.out.println("Nome: "+this.name);
		System.out.println("Idade: "+this.age);
		System.out.println("Cidade: "+this.locale.getCity());
		System.out.println("Estado: "+this.locale.getState());
	}
}
//Classes referentes ao padrão Flyweight.
class StatesAndCities{
	private String state;
	private String city;
	protected StatesAndCities(){
		
	}	
	
	protected StatesAndCities(String cit, String st){
		this.city = cit;
		this.state = st;
	}
	
	
	public void setState(String st){
		this.state = st;
	}
	
	public void setCity(String ct){
		this.city = ct;
	}
	
	public String getState(){
		return this.state;
	}
	
	public String getCity(){
		return this.city;
	}	
}

class Flyweight extends StatesAndCities{
	private Flyweight(){
//Não pode ser intanciada.
	}
	
	//O atributo é estático, mais não é acessível a todos, só se pode
	//pegar os seus valores via métodos.
	private static HashMap<String,StatesAndCities> local = new HashMap<String,StatesAndCities>();
	//Por aqui que o usuário  fará contato com o atributo acima.
	//O sincronizado é para evitar problemas com threads().
	public static synchronized StatesAndCities getLocal(String nickOfCity){
		return local.get(nickOfCity);
	}
	
	static{ //Esse é o conteúdo do Map local.
	//local.put(palavra chave, new StatesAndCities ("Nome de sua cidade", "Nome de seu estado");
		local.put("pg",new StatesAndCities("Ponta Grossa","Paraná"));
		local.put("sp_capital",new StatesAndCities("São Paulo", "São Paulo"));
		local.put("ctba", new StatesAndCities("Curitiba", "Paraná"));
	}	
}

/*
 * Pense no Flyweight como uma enum que pode ter os seus valores modificados.
 * O fleweight apenas contém os métodos de acesso, ela é uma classe que não
 * pode ser instanciada, mais pode ter o seu método acessados de maneira estática,
 * se nesse exemplo você quiser ter acesso as cidades você chama a classe 
 * Flyweight.metodoDesejado(), ela é semelhante ao singleton e ao multiton, mas
 * a diferença está no fato de que ela não guarda uma instância de si mesmo, 
 * ela é uma excelente alternativa as Enuns, caso necessite de algo um pouco
 * mais arrojado. O seu funcionamento é identico a uma enum, mas diferente de 
 * uma enum ela não trabalha com valores constantes, ou seja caso precise de uma
 * "enum" de varíaveis use esse padrão, caso seja apenas com constantes mesmo, use a enum.
 * */
