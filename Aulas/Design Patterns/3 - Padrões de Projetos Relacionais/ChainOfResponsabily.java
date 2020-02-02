public class ChainOfResponsabily{
	
	public static void main(String args[]){
		//Setando valores e criando os objetos.
		Person person = new Person();
		person.setName("João");
		person.setFunction("Gerente");
		Order manager = new Manager();		
		Order operator = new Operator();
//Aqui o Operador se relaciona com o gerente, chamando-o se for necessário
		operator.setOrder(manager);
//Aqui o Gerente se relaciona com o operador, chamando-o se for necessário
		manager.setOrder(operator);
//Gerente recebe pessoa.		
		manager.make(person);
//Operador recebe pessoa.
		operator.make(person);
		
		System.out.println("Gerente: "+ manager.getResult()+"\nOperator: "+operator.getResult());
	}
	
}
//Esse é o objeto que será usado como parâmetro.
class Person{
	private String name;
	private String function;	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setFunction(String func){
		this.function = func;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFunction(){
		return this.function;
	}	
}

//Nesse objeto é estabelecido a ordem e os atributos em comum entre os
//Objetos que trabalharam no padrão da corrente de responsabilidade,
//Vamos pensar nele como sendo a corrente, que amarra todos os seus filhos. 
abstract class Order{
//Esse tributo abaixo vai receber o valor do parametro, caso o objeto em
//questão seja inapto para lidar com ele.
	protected Order order;
	protected String result;
//Esse método abaixo irá receber o Objeto que ele irá chamar, caso esse
//Objeto instanciado seja inapto para lidar com o parametro em questão.
//No caso o Order pode ser Gerente ou Operador, se a classe em questão
//For gerente, ele terá uma instancia do operador, para fazer as funções
//de operador se necessário, se for o Operador terá a de Gerente.
//Lembre-se de passar algum objeto, pois se acontecer do Gerente ter
//que lidar com o operador, ou vice versa, irá dar NullPointerException,
//caso nao seja relacionado por aqui essas duas atividades.
	public void setOrder(Order order){
		this.order = order;
	}
	
	public String getResult(){
		if(this.result != null)
			return this.result;
		else	
			return this.order.getResult()+", Através da corrente de responsabilidade, pois esse objeto não lida com isso.";
	}
	//Esse será o método que irá julgar a competencia de um objeto.
	public abstract void make(Person person); 
}

//Se o melhor profissional para lidar com um problema for um gerente,
//Então os objetos dessa classe irão atender a solicitação.
class Manager extends Order{
	@Override
	public void make(Person person){
		if(person.getFunction() != "Gerente")	
			this.order.make(person);
		else
			this.result = "Processado pela classe Gerente";		
	}
}

//Agora se o melhor profissional para lidar com um problema for um 
//operador, Então os objetos dessa classe irão atender a solicitação.
class Operator extends Order{
	@Override
	public void make(Person person){
		if(person.getFunction() != "Operador")	
			this.order.make(person);
		else
			this.result = "Processado pela classe Operador";		
	}
}
/*
 * Esse é o padrão de projeto Chain Of responsabily, na prática ele é 
 * programado para adotar o comportamento de outros objetos, caso não 
 * siga determinada normal. Vamos supor que você quer criar
 * um objeto Pessoa e um objeto Cidade, Nesse caso o Objeto pessoa tem
 * atributos diferentes de cidades, a solução que o Chain of Responsabily
 * dá, é de fazer o objeto Cidade ser tratado como cidade, mesmo que seja
 * usado como pessoa. Se acontecer de você receber um parametro
 * diferente ou um objeto ou atributo diferente do esperado, você chama
 * o objeto da classe competente, para lidar com esse que você usou como 
 * parametro. O Raciocínio é o seguinte, acima você tem o Operador e o
 * Gerente, o operador trabalha com a parte de produção e o Gerente com
 * gerenciamento de pessoas, seguindo a lógica do Chain of Responsabily
 * se você mandar um gerente operar alguma coisa, ele ao invés de operar,
 * ele irá chamar um operador para fazer isso, veja que na classe pai
 * tem um atributo do tipo Order que pode receber um Objeto com atributos
 * de Gerente ou do Operador, pois ambos extende dele. Agora se mandar
 * um operador fazer o papel de Gerente, o Operador também irá chamar o
 * gerente ao invés de fazer alguma coisa, esse é um padrão de projeto
 * interessante, caso você queira que um objeto conclua um serviço, mesmo
 * sendo inapto para ele, assim sendo ele irá chamar outro objeto até 
 * encontrar algum objeto que seja capaz de lidar com os seus parametros.
 */ 
