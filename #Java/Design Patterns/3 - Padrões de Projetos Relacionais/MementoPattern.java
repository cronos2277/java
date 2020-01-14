public class MementoPattern{
	
	public static void main(String args[]){
		Worker worker = new Worker();
		Bean old = new Bean();
		old.setName("João Paulo");
		old.setIdade(26);
		//Objeto Old salvo no memento. Agora um novo objeto para testar edição
		worker.setMemento(old.saveThisConcrete()); 
		//Imprimindo o objeto salvo no memento.
		worker.getMemento().objectSaved().sysout("old");
		Bean new_usr = new Bean();
		new_usr.setName("Paulo");
		new_usr.setIdade(14);
		//substituindo o usuário registrado no memento sistema.
		worker.setMemento(new_usr.saveThisConcrete());
		//imprimindo o novo usuário salvo no memento.
		worker.getMemento().objectSaved().sysout("new");
		
	}
	
}
//Esse é o Bean, o memento salvará as alterações feitas em objetos desse tipo.
class Bean{
	protected String name;
	protected int idade;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getIdade(){
		return this.idade;
	}
//Esse método ele retorna o Memento com o objeto salvo.	
	public Memento saveThisConcrete(){
		return new Memento(this);
	}
	
	public void sysout(String str){
		System.out.println("Objeto Nome:"+str+" |Nome: "+this.name+" |Idade: "+this.idade);
	}
}

//A classe memento, é a classe que salva o estado dos objetos.
//Detalhe: nesse padrão de projeto o Memento não é usado diretamente.
//Existe uma classe que trabalha com ele.
class Memento{
//Você tem um ou mais instancia do objeto que você pretende salvar.
	private Bean bean;
//Além disso você tem também o mesmo conteúdo equivalente ao do objeto
//que você quer salvar, repare que o Bean tem um nome e uma idade também.
//Você poderia ao invés de ter os mesmos atributos que o Bean, criar duas
//instancias do Bean, uma para quando o usuário comitar e a outra apenas
//para salvamento temporário.
	private String name;
	private int idade;
	
	public Memento(Bean bean){
//ao chamar um Memento pela primeira vez, você escreve a instancia e todos
//os atributos do Memento de modo que ele fique com a informação duplicada.
		this.bean = bean;
		this.name = bean.getName();
		this.idade = bean.getIdade();
	}
//Esse método salva, repare que quando você salva, você apenas escreve
//nos atributos do memento e não na instancia que ele tem, esse é o pulo do gato.	
	public void saveAlter(Bean bean){
		this.name = bean.getName();
		this.idade = bean.getIdade();
	}
//Esse é o desfazer, aqui ele ajusta os atributos para ser igual aos valores das instancias.
//Ou seja se o usúario fez a modificação ele fez nos atributos e não na instancia.	
	public void undo(){
		this.name = this.bean.getName();
		this.idade = this.bean.getIdade();
	}
//Essa opção é a inversa do desfazer, aqui ele salva as alterações, no caso
//ele define a instancia com base nos valores dos atributos.	
	public void commit(){
		this.bean.setName(this.name);
		this.bean.setIdade(this.idade);
	}
//Aqui ele retorna o valor salvo do memento, ou seja ele retorna os valores
//salvos na instancia, e não as últimas modificações que ficam salvas nos atributos.	
	public Bean objectSaved(){
		return this.bean;
	}
	
}

class Worker{
	private Memento memento;
	public void setMemento(Memento memento){
		this.memento = memento;
	}
	
	public Memento getMemento(){
		return this.memento;
	}
}
/*
 * O Memento ele salva estado de classes, ele permite que você dê aquela
 * opção de undo, ou seja você cria um objeto edita ele e salva, se acontecer
 * de você modificar o objeto, você pode voltar o objeto com os dados
 * no momento que o salvou pela ultima vez, como eu disse seria a opção
 * undo ou desfazer de um objeto.
 * */ 
