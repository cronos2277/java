import java.util.HashMap;
public class ProxyPattern{
	public static void main(String args[]){
//Tanto a classe que vai receber os valores quanto o proxy, são do mesmo
//tipo na hora de instanciar.
		Client instance = new Instance();
		instance.setName("João");
		instance.setAge(26);
		instance.setLocal(Locale.getLocale("pg"));		
		instance.method();
		Client proxy = new Proxy(instance);
		proxy.method();
	}
}

class BeanLocale{ //Esse bean tratará da localidades.
	private String city;
	private String state;
	
	public void setCity(String cit){
		this.city = cit;
	}
	
	public void setState(String st){
		this.state = st;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getState(){
		return this.state;
	}
//ele pode ou não receber parâmetros, na hora de sua instanciação.	
	protected BeanLocale(){}
	protected BeanLocale(String cit, String st){
		this.city = cit;
		this.state = st;
	}
}

//Essa é a classe que fornece dados para preencher o bean acima.
class Locale extends BeanLocale{
	//Locale não pode ser instanciada.
	private Locale(){}
	//O atributo aonde ficará cadastradas as localidades usadas pela aplicação.	
	private static HashMap<String,BeanLocale> local = new HashMap<String,BeanLocale>();	
	//Esse método retorna com base em argumentos o Objeto bean acima devidamente preenchido.
	public static synchronized BeanLocale getLocale(String nicklocal){
		return local.get(nicklocal);
	}
	//Abaixo o método estático, aqui é informado as localidades válidas pela aplicação,
	//esse método é estático e é carregado quando o aplicativo é iniciado, mas apenas
	//aqui abaixo pode-se adicionar as localidades. Segue abaixo um exemplo do padrão usado aqui.
	//local.put("uma chave para retorno da localidade", newBeanLocale("Cidade", "Estado));
	static{
		local.put("pg",new BeanLocale("Ponta Grossa","Paraná"));
	}
}

interface Client{	//Todos os Objetos serão do tipo dessa interface.
	public int getAge();
	public String getName();	
	public String getCity();
	public String getState();	
	public void method();
	
	public void setName(String name);
	public void setAge(int age);
	public void setLocal(BeanLocale bean);	
}

//Esse será o objeto que receberá os dados do cliente.
class Instance implements Client{ 
	private String name = " ";
	private int age = 0;
	private BeanLocale local;
	
	@Override
	public int getAge(){
		return this.age;
	}
	
	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public String getCity(){
		return this.local.getCity();
	}
	
	@Override
	public String getState(){
		return this.local.getState();
	}
	
	public void setName(String setname){
		this.name = setname;
	}
	
	public void setAge(int setage){
		this.age = setage;
	}
	
	public void setLocal(BeanLocale bean){
		this.local = bean;
	}	
	
	@Override
	public void method(){
		if(this.name == " " || this.age < 1 || this.local == null)
			throw new NullPointerException("Existe campos nulo no objeto cliente");
		}
}

//Esse é o Proxy, a classe invisível ao cliente.
class Proxy implements Client{
	private Client client;	
	public Proxy(Client tmp){
		this.client = tmp;
	}
	
	@Override
	public int getAge(){
		return this.client.getAge();
	}
	
	@Override
	public String getName(){
		return this.client.getName();
	}
	
	@Override
	public String getCity(){
		return this.client.getCity();
	}
	
	@Override
	public String getState(){
		return this.client.getState();
	}
	
	@Override
	public void method(){
		System.out.println("Cliente cadastado.");
		System.out.println("Nome: "+client.getName());
		System.out.println("Idade: "+client.getAge());
		System.out.println("Cidade: "+client.getCity());
		System.out.println("Estado: "+client.getState());
	}
	
	@Override
	public void setName(String name){
		throw new IllegalArgumentException("Operação ilegal.");
	}
	
	@Override
	public void setAge(int age){
		throw new IllegalArgumentException("Operação ilegal.");
	}
	
	@Override
	public void setLocal(BeanLocale bean){
		throw new IllegalArgumentException("Operação ilegal.");
	}
}
/*
 * O Proxy Pattern visa a segurança. Ele substitui o objeto orinal pelo
 * objeto clone dele, ou seja você escreve em um objeto e ele é passado
 * a outro como parâmetro, com isso a sua aplicação ganha mais segurança.
 * Nesse exemplo você seta as propriedades no objeto Instance, e uma vez feito 
 * isso você passa esse objeto instance, como parâmetro para o objeto Proxy,
 * e o objeto proxy contém um método que é diferente do objeto instance,
 * no caso ele exibe os dados informados pelo usuário. Esse método é interessante,
 * pois você pode criar um objeto aberto para a edição de dados e um outro
 * mais restrito, aumentando assim a segurança, porém é valido lembrar que
 * a estrutura dos dois objetos é identica, o proxy recebe o outro como parâmetro.
 * */
