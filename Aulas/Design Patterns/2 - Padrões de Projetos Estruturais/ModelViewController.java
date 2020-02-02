import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelViewController{
	
	public static void main(String args[]){		
		Controller.setModel(new Model("João",26,"Ponta Grossa","Paraná"));
		Controller.setModel(new Model("Pedro",37,"São Paulo","São Paulo"));
		View.sysout();
	}
	
}
/*
 * É importante frisar, elas não pode se extender uma da outra classe
 * Model é autonoma assim como a Controller e a View também são, veja
 * que no projeto as 3 classes são interdependentes entre si.*/

//Abaixo a classe Modelo, ela serve para tipificar um objeto.
class Model{
	protected String name;
	protected int age;
	protected String state;
	protected String city;
	public Model(){}
	public Model(String nome, int idade, String cidade, String estado){
		this.name = nome;
		this.age = idade;
		this.city = cidade;
		this.state = estado;
	}
	
	public void setName(String nome){
		this.name = nome;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getState(){
		return this.state;
	}
	
	public int getAge(){
		return this.age;
	}
}

//Aqui será feito manipulações com as Models.
class Controller{
	private Controller(){}
	private static ArrayList<Model> Register = new ArrayList<Model>();
	public static synchronized void setModel(Model model){
		Register.add(model);
	}
	
	public static synchronized Model getUnique(String name){
		for(Model model: Register){
			if(model.getName() == name)
				return model;
		}
		throw new IllegalArgumentException("Não existe esse registro.");		
	}
	
	public static synchronized ArrayList<Model> getAll(){
		return Register;
	}
	
}

//Aqui corresponde a os métodos de interação com o cliente.
class View{
	private View(){}
	public static View method;
	private static synchronized void sysout_func(Model client){		
		System.out.println("Nome  : "+client.getName());
		System.out.println("Idade : "+client.getAge());
		System.out.println("Cidade: "+client.getCity());
		System.out.println("Estado: "+client.getState()+"\n");
		fwrite(client.getName(),client.getAge(),client.getCity(), client.getState());
	}
	
	public static synchronized void sysout(){
		for(Model client: Controller.getAll())
			sysout_func(client);
	
	}
	
	protected static synchronized void fwrite(String name, int age, String city, String state){
		try{
			FileWriter file = new FileWriter(name);
			file.write("Nome  : "+name);
			file.write("\nIdade : "+age);
			file.write("\nCidade: "+city);
			file.write("\nEstado: "+state);
			file.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	static{
		method = new View();
	}
}
/*
 * MVC: Ele separa o modelo do controle e e controle da visualização, 
 * o primeiro será um modelo, que poderá ser um bean por exemplo, 
 * o segundo é o controle ao qual será usado para manipular os valores do 
 * modelo e por fim temos a parte visível ao usuário que é o view. 
 * Seu foco é a modularização, ou seja deixar o código mais modular 
 * e permitir que ele possa ser editado com mais facilidade, 
 * além disso ele permite a separação de model view e controller o que 
 * pode ter um aumento de performace na aplicação, pois você pode deixar
 * a parte model e controller na mão do servidor e a parte view na mão 
 * do cliente em alguns casos economizando processamento em servidores.*/
