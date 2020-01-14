import java.util.ArrayList;
import java.util.Iterator;

public class ObserverPattern{
	public static void main(String args[]){
		//Aqui são setados os números e ordenados do menor para o maior.
		Numbers numbers = new Make(12,-20,1).bubbleSort();
		System.out.println("\nOs primeiros Valores!\n");
		numbers.sysout();
		numbers.output();	
		//Adcionando todas as operações que serão feito.
		numbers.addOperation(new SumAll(numbers));
		numbers.addOperation(new MultAll(numbers));
		numbers.addOperation(new SubtAll(numbers));
		numbers.addOperation(new DivAll(numbers));
		//Imprimindo valores na tela.
		numbers.output();
		//Alterando valores.
		numbers.setNumers(0,1);
		numbers.setNumers(1,2);
		numbers.setNumers(2,3);
		//Exibindo os novos valores na tela.
		System.out.println("\nOs novos Valores!\n");
		numbers.sysout();
		numbers.output();
	}
}
//Essa classe abstrata trabalha com os números informado pelo usuário.
//Porém ela é extendida e a sua extensão é tratada na classe filha.
abstract class  Numbers{
//Aqui é armazenado as operações matematica que essa classe irá operar.
	protected ArrayList<Observer> operations;
//Esse atributo serve como parametro, que aumenta o seu valor a medida
//que você vai adicionando valores.
	public int x = 0;
	private ArrayList<Double> numers;
	
	protected void update(){
//Esse método ele atualiza os valores para todas as operações contidas dentro dela.
//Aqui está o verdadeiro "Observer".
		for(Observer obs: operations)
			obs.update(this);		
	}
//Repare que quando você adiciona, altera, ou exclui um numero o método
//update é chamado e com isso todos os valores das operações são atualizados.	
	public Numbers(double... num){
//Aqui é o construtor, como ao instanciar os valores não nulos, então
//Esse é o único que não chama o método update.
		operations = new ArrayList<Observer>();
		numers = new ArrayList<Double>();		
		for(Double db: num)
		numers.add(x++,db);
	}
	
	public void addNumers(double... num){
		for(Double db: num){
			numers.add(x++,db);
		}
		update(); //Aqui ele adiciona a posteriori, logo é dado um update.
	}
	
	public void setNumers(int index, double value){
		numers.set(index,value);
		update(); //Esse método edita os valores, logo chama o método update.
	}
	
	public void remNumers(int index){
		numers.remove(index);
		--x;
		update(); //Esse método excluí os números, logo chama o update.
	}
	
	public Numbers bubbleSort(){
		double db = 0.0;
		for(int i = 0;i < numers.size() - 1;i++)
			for(int j = i+1; j < numers.size(); j++)
				if(numers.get(i) > numers.get(j)){
					db = numers.get(i);
					numers.set(i,numers.get(j));
					numers.set(j,db);
				}
		update(); 
//Esse método ordena do menor para o maior os valores contidos, chama o update.
//Em soma ou multiplicação chamar ou não o update aqui não faria diferença,
//mas para divisão e subtração faz muita diferença.
		return this;				
	}
	
	
	public void sysout(){
		Iterator iterator = numers.iterator();
		System.out.print("\t|");
		while(iterator.hasNext())
		System.out.print(iterator.next()+"|");
		System.out.print("\n");
//Esse método ele mostra os numeros informados pelos resultados.
	}
	
	public ArrayList<Double> allNumbers(){
		return numers;
	}
	
	public abstract void addOperation(Observer observer);
	public abstract void remOperation(Observer observer);
	public abstract void changeOperation(Observer old_observer, Observer new_observer);
	public abstract boolean existOperation(Observer observer);
	public abstract void output();
	
}
//Essa classe trabalha com operações matemática. Ela herda todo conteúdo
//da classe abstrata acima. Enfim essa classe ela gerencia as operações
//matematicas, você adiciona soma, subtração, ou qualquer outra operação
//na hora que desejar, Além disso ela é a parte concreta da classe acima,
//para chama-la, você deve informar alguns double, para que se possa iniciar
//com algum valor. 
class Make extends Numbers{
	public Make(double... db){
		super(db);
//Construtor exige doubles e esses valores serão passados para cima.
	}
//Aqui uma operação é adicionada.	
	@Override
	public void addOperation(Observer observer){
		operations.add(observer);
		
	}
//Aqui trata da exclusão de uma determinada operação matemática.	
	@Override
	public void remOperation(Observer observer){
		operations.remove(observer);
	}
//Aqui você troca uma operação matemática por outra.
	@Override
	public void changeOperation(Observer old_obs, Observer new_obs){
//Esse método indexOf dos List<> retornam o indice de determinada lista,
//Retornando -1 quando não acha, sempre lembrando que o List começa no -1.
		int tmp = operations.indexOf(old_obs);
		if(tmp > -1)
			operations.set(tmp,new_obs);
		else //Quando não acha, lança um NullPointerException.
			throw new NullPointerException("Operation does not exists!");
	}
	
	@Override
	public boolean existOperation(Observer observer){
//Esse método abaixo, procura na list, um objeto Observer retornando se achou ou não.
		return operations.contains(observer);
	}
	
	@Override
//Exibe na tela a operação, trando-o conforme o seu tipo.  
	public void output(){
		for(Observer observer: operations){
			if(observer instanceof SumAll)
				System.out.println("A soma de todos os valores: "+observer.value());
			if(observer instanceof SubtAll)
				System.out.println("A subtracao de todos os valores: "+observer.value());
			if(observer instanceof MultAll)
				System.out.println("A multiplicacao de todos os valores: "+observer.value());
			if(observer instanceof DivAll)
				System.out.println("A divisao de todos os valores: "+observer.value());
		}
			
	}
}
//---------------------CONFIGURAÇÃO DAS OPERAÇÕES-----------------------
//Essa interface serve para padronizar as operações matemática.
//Se faz obrigado a ter ela, para que a classe number e Make, possam
//tratar com as classes que a implementam de maneira uniforme.
interface Observer{
//O update(), serve para adicionar numeros dentro do objeto, esse método
//todas as operações matemáticas devem ter, para que possa ser alterado os
//numeros caso, sejam alterados.
	public void update(Numbers numbers);
//retorna o valor de determinado objeto.
	public double value();		
}

//Essa classe soma todos os valores em sequencia, contidos no objeto numbers.
class SumAll implements Observer{
//aqui o valor das soma começa sempre em zero, somando-se em sequancia.
	private double sum_var = 0; 
	public SumAll(Numbers numbers){
		this.process(numbers.allNumbers());
//O construtor carrega todos os valores do Objeto tipo number.
	}
	
	@Override
	public void update(Numbers numbers){
//Quando se atualiza, soma-se os novos valores, apartir do zero.
		this.sum_var = 0; 
		this.process(numbers.allNumbers());
	}	
	
	private void process(ArrayList<Double> list){
//aqui são feitas as somas.
		for(Double db: list)
			this.sum_var += db;
	}
	
	@Override
	public double value(){
//Retorna todos os valores somados.
		return this.sum_var;
	}
}

//Essa classe subtrai todos os valores em sequencia, contidos no objeto numbers.
class SubtAll implements Observer{
//aqui o valor das subtrações começa sempre em zero, subtraindo em sequancia.	
	private double subt_var = 0;
	public SubtAll(Numbers numbers){
		this.process(numbers.allNumbers());
//O construtor carrega todos os valores do Objeto tipo number.
	}
	
	@Override
	public void update(Numbers numbers){
//Quando se atualiza, subtrai os novos valores, apartir do zero.
		this.subt_var = 0;
		this.process(numbers.allNumbers());
	}	
	
	private void process(ArrayList<Double> list){
	//Aqui são feitos as subtrações.
		for(Double db: list)
			this.subt_var -= db;
	}
	
	@Override
	public double value(){
//Retorna todos os valores subtraídos.
		return this.subt_var;
	}
}

//Essa classe divide todos os valores em sequencia, contidos no objeto numbers.
class DivAll implements Observer{
//aqui o valor das multiplicações começa sempre em um. Caso zero o valor sempre será zero.
	private double div_var = 1;
	public DivAll(Numbers numbers){
		this.process(numbers.allNumbers());
//O construtor carrega todos os valores do Objeto tipo number.
	}
	
	@Override
	public void update(Numbers numbers){
//Quando se atualiza, divide-se os novos valores, apartir do um.
		this.div_var = 1;
		this.process(numbers.allNumbers());
	}	
	
	private void process(ArrayList<Double> list){
	//Aqui são feitas as divisões.
		for(Double db: list)
			this.div_var /= db;
	}
	
	@Override
	public double value(){
//Retorna todos os valores divididos.
		return this.div_var;
	}
} 

//Essa classe multiplica todos os valores em sequencia, contidos no objeto numbers.
class MultAll implements Observer{
//aqui o valor das divisões começa sempre em um. Caso zero o valor sempre será zero.
	private double mlt_var = 1;
	public MultAll(Numbers numbers){
		this.process(numbers.allNumbers());
//O construtor carrega todos os valores do Objeto tipo number.
	}
	
	@Override
	public void update(Numbers numbers){
//Quando se atualiza, multiplica-se os novos valores, apartir do um.
		this.mlt_var = 1;
		this.process(numbers.allNumbers());
	}
		
	private void process(ArrayList<Double> list){
	//Aqui são feitas as multiplicações.
		for(Double db: list)
			this.mlt_var *= db;
	}
	
	@Override
	public double value(){
//Retorna todos os valores multiplicados.
		return this.mlt_var;
	}
}

/*
 * O padrão Observer, consiste em alterar os objetos em cascata, ou
 * seja se você altera um objeto, outros relacionado a eles também se
 * altera, seria o equivalente ao update do SQL, ou seja se você altera
 * um objeto, isso impacta nos outros.
 * 
 * Nesse caso você tem duas categorias de classes, uma relacionadas
 * aos valores e outro o gerenciamento das operações e quatro classes sendo
 * cada um uma operação matemática. Perceba que quando você altera um
 * valor numérico, você altera o valor de uma operação matemática, e é
 * isso que esse método faz, se você muda um numero, as operações
 * dentro dos numeros são refeitas novamente e esse refazer novamente, 
 * no momento que altera um valor, é o padrão Observer posto em prática.
 * */

