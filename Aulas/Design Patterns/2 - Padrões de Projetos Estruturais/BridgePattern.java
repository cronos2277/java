import java.util.HashMap;
import java.util.ArrayList;
public class BridgePattern{
	
	public static void main(String args[]){
		People person = new Properties(); //Objeto do tipo interface, olha que coisa linda.
		person.setPerson("João",26,1000.50,true);
		person.show();
	}
	
}
//Essa é a interface<Aqui é o espaço para uma classe>
interface People<Class>{
	public Class setPerson(String name, int age, double salary, boolean genre);
	public ArrayList<Object> getPerson(int index);
	public void show();		
}

//Classe abstrata, ela ordena e implementa os métodos básicos para lidar com o List e o Map.
//Aqui contém os métodos protegidos e que seram usados pelo seu herdeiro.
//Sua criação não é obrigatória, exceto que seja importante colocar métodos ou 
//atributos que a interface não pode ter, para dar mais funcionalidades a ela.
abstract class Property{			
	protected ArrayList<Object> person;
	protected HashMap<Integer,ArrayList<Object>> register;
	protected Property(){
		person = new ArrayList<Object>();
		register = new HashMap<Integer,ArrayList<Object>>();
	}
	protected void setPersonName(String name){
		this.person.add(name);		
	}
	
	protected void setPersonAge(int age){
		this.person.add(age);		
	}
	
	protected void setPersonSalary(Double db){
		this.person.add(db);
	}
	
	protected void setPersonGenre(boolean bool){
		this.person.add(bool);
	}	
}
//A classe concreta, a qual faz o trabalho duro. Ela extende os métodos
//da classe pai e os usa, além disso ela apenas tem declarado os métodos
// da interface apesar de extender funcionalidades da classe abstrata, isso
//é importante ressaltar, pois se ela tiver atributos declarados ou mais
//métodos além dos declarados na interface, fica impossível criar um 
//objeto com a estrutura dessa classe do tipo interface, siga essa regra.
class Properties extends Property implements People<Properties>{
	public Properties setPerson(String name, int age, double salary, boolean genre){
		setPersonName(name);
		setPersonAge(age);
		setPersonSalary(salary);
		setPersonGenre(genre);
		register.put(register.size(), this.person);
		return this;
	}
	
	public ArrayList<Object> getPerson(int index){
		 return this.register.get(index);
	}
	
	public void show(){
		for(int i=0;i < person.size(); i++)
			if(register.get(i) != null)
				System.out.println(register.get(i));
	}
}

/*
 * A primeira vista essa ponte leva a confusão, mas o seu princípio não é dificil de entender.
 * Temos uma interface "People", uma classe abstrata "Property()" e uma classe concreta "Properties()",
 *  repare que no método main(), que deus o tenha, é instanciada um objeto do tipo Interface,
 *  e não do tipo de uma das classe repare que toda a manipulação é feita com base no arquivo tipo interface,
 *  além disso o objetodo tipo interface, usa os seus próprio métodos. 
 * Em suma o padrão bridge trabalha com uma classe abstrata, podendo ser interface e uma classe concreta, 
 * sendo essa última, a classe concreta que vai fazer todo o trabalha duro. Esse padrão é útil quando você tem 
 * uma série de métodos parecidos que possuem a mesma interface, assim você pode instanciar objetos diferentes e 
 * usar-lo da mesma forma, pois independente da classe concreta que você usar, o objeto em si será do tipo da interface,
 *  porém é importante que a interface tenha o mesmo conteúdo que a classe concreta para evitar problemas,
 * caso seja necessário criar atributos e definir valores, use uma classe abstrata como intermediário
 * da interface e da classe concreta, e apenas coloque na classe concreta o que estiver na interface,
 * qualquer outra coisa coloque na classe intermediária, que nesse caso é a classe abstrata Property, na interface você
 * põe todos os métodos públicos.
 * */
