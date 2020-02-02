import java.util.ArrayList;

public class MediatorPattern{
	public static void main(String args[]){
		final int codigo = 10;
//Você deve chamar primeiro a classe concreta, pois ela servirá de parametro.
		Concrete concrete = new Concrete();
		People person = new People(concrete);
		Worker worker = new Worker(concrete);
		person.setter("João");
		worker.setter("Estudante");		
		concrete.addNew(person);
		concrete.addNew(worker);
		try{
		//A parte que interessa é abaixo. Se você colocar Worker o people recebe o código 10.
		//Se colocar People, é o worker que recebe o código 10.
		//Esse projeto ele serve para enviar um comando via integer para algum objeto.
		System.out.println("Primeiro envio.");
		concrete.send(codigo,worker);
		System.out.println("\nSegundo envio.");
		concrete.send(codigo + 1,person);		
		}catch(Exception e){}
		finally{
			System.out.println("\n"+person.getCode()+" e "+worker.getCode()+" <- Valores de Person e Worker respectivamente.");
		}
	}
}
//Eis aqui o nosso "Pacote IP"
interface Mediator{
//Esse nosso pacote IP, contém a mensagem, que nesse caso são o(s) atributo(s)
//que você quer mandar, um objeto do tipo College, que nesse caso seria
//o resto da parte de um datagrama IP, que o cabeçalho e talz.
	public void send(int num, College college);
}
//Eis Aqui o nosso "switch".
abstract class College{
//Todos os Atributos e métodos será definidos aqui, a classes que extendem
//dessa apenas irá incrementar algum valor ou reescrever algum método,
//porém a estrutura dessas classes devem ser essa.
	protected int code;
	protected String name;
	protected String function;
	protected Mediator mediator;
//Para que o nosso "switch" possa trabalhar, você deve enviar um pacote IP pra ele.
//e ele localizará o destinatário da mensagem.
	public College(Mediator mediator){
		this.mediator = mediator;
	}
//Repare que o nosso "switch", ele reescreve o método da interface mediator
//logo ele não implementa essa interface, porém ele é o único a não usa-la.
//Quando você instala uma rede Tolking Ring, você não instala nada no switch,
//apenas nos computadores que irão se conectar a essa rede, não é mesmo?	
	public void send(int id){
//Lembrando que as classes filhas irão enviar a mensagem + o conteúdo de college.
//Repare que o College reescreve o método da interface, ou na nossa analogia
//o switch executa o envio com base na política de rede do próprio switch.
//Essa "política" seria uma instancia dessa própria classe, que é carregada
//quando criada uma classe filha.
		this.mediator.send(id,this);
	}
//Esses são os métodos que as classes filhas irão reescrever.
//*######
//O received é a classe que irá lidar com o recebimento do código, ou seja
//o que a filha irá fazer quando receber o código?
	public abstract void received(int id);
//O Setter na people adiciona valor ao nome, no worker adiciona valor a função.
	public abstract void setter(String str);
//Retorna o valor de nome se for a Classe People, retorna a função de for worker.
	public abstract String getter();
//Retorna o código em questão, ou na nossa analogia o conteúdo do "Pacote IP."
	public abstract int getCode();
}

//Esse é um dos nossos "computadores".
class People extends College{	
//Repare que ela não define atributos e nem nada, ela apenas reescreve
//métodos, ela também poderia adicionar valores aos atributos, porém
//ela não deve ter a estrutura alterada de maneira nenhuma.
	@Override
	public void received(int code){
		this.code = code;
	}
//O construtor deve chamar a super classe passando um mediator como parametro.
//Usando a analogia, aqui você ou habilitaria o DHCP, ou você atribuiria
//um IP a ele na rede, permitindo assim que esse "computador" possa se 
//comunicar na rede.
	public People(Mediator mediator){
		super(mediator);
	}
//O setter nessa classe é reescrito para reescrever o name.	
	@Override
	public void setter(String name){
		this.name = name;
	}
//O getter é reescrito para retornar name.	
	@Override
	public String getter(){
		return this.name;
	}
	
	@Override
	public int getCode(){
		return this.code;
	}
}
//Esse é outro dos nossos "computadores".
class Worker extends College{	
//Repare que ela não define atributos e nem nada, ela apenas reescreve
//métodos, ela também poderia adicionar valores aos atributos, porém
//ela não deve ter a estrutura alterada de maneira nenhuma.		
	@Override
	public void received(int code){
		this.code = code;
	}
//O construtor deve chamar a super classe passando um mediator como parametro.
//Usando a analogia, aqui você ou habilitaria o DHCP, ou você atribuiria
//um IP a ele na rede, permitindo assim que esse "computador" possa se 
//comunicar na rede.
	public Worker(Mediator mediator){
		super(mediator);
	}
//Aqui é atribuido valor a função.	
	@Override
	public void setter(String func){
		this.function = func;
	}
	
//Aqui retorna o valor da função.
	@Override
	public String getter(){
		return this.function;
	}
//retorna o conteúdo do "pacote IP".	
	@Override
	public int getCode(){
		return this.code;
	}
}

//Eis ai a nossa "porta Ethernet".
//A Nossa porta Ethernet ela envia pacotes IP pela rede, e
//ela não é um computador e sim uma placa de rede que faz a comunicação
//computador e switch, por ela trabalhar com o IP, ela deve implementar
//a interface, mas pelo fato dela não ser um computador e sim uma peça
//então ela não usa uma porta no exclusiva switch, logo não extende nada.
//Repare que ela é que irá fazer a comunicação entre os outros "computadores" 
//e o switch. Essa classe fará o envio dos atributos para todas as classes
//exceto a sí mesmo. Em outras palavras ela fará um "Broadcasting".
//Concrete Não extende College, mais implementa Mediator.
class Concrete implements Mediator{
//Esse Nesse registro é armazenado todos os objetos que será o destinatário
//das mesagens. No caso aqui é equivalente a aquela tabela que tem dentro
//dos switchs que guarda todas as relações de endereços MAC e endereço IP.
	protected ArrayList<College> college;
//O List ele é carregado ao ser instanciado.	
	public Concrete(){
		college = new ArrayList<College>();		
	}
//Adiciona valores ao registro de college.	
	public void addNew(College college){
		this.college.add(college);
	}	
//Abaixo nós temos o método send do método mediator. Aqui é passado
//um valor como parametro e o objeto do tipo college remetente, como
//a Estrutura de People e Worker são identicas ao College, eles podem
//ser usado como parametro, por isso não se pode alterar a estrutura deles.
//Usando a Analogia, esse método ele enviaria um broadcasting para toda a rede.
	public void send(int id, College college){
		this.sysout(id,college);	
//O for varre todos os elementos do List.	
		for(College coll: this.college){
//Aqui são definidos as condição de envio. Usando a analogia issoa aqui é um broadcasting.
			if(coll != college){
//Aqui você ativa o método de recebimento dos objetos, é esse método de
//recebimento que vai atribuir o valor a um atributo ou mais da classe.				
				coll.received(id);
			}
		}
	}
//Aqui é verificado de que tipo é o objeto. É válido ressaltar que o
//instanceof só funciona sem acionar exception, se e somente os objetos
//analizados tiverem a mesma interface ou a mesma linhagem. Se você
//usar college instaceof Double, vai dar erro pois as duas classes não
//tem a mesma interface ou a mesma linhagem, agora nesse caso funciona, pois
//tanto College como People e Worker possuem a mesma linhagem.	
	private void sysout(int id, College college){
		if(college instanceof People){ //True se for do tipo verificado
			System.out.println("O Objeto remetente do tipo People, envia: "+id);
			System.out.println("O Objeto destinatario do tipo Worker, recebe: "+id);
		}
		
		if(college instanceof Worker){//False se não for desse tipo.
			System.out.println("O Objeto remetente do tipo Worker, envia: "+id);
			System.out.println("O Objeto destinatario do tipo People, recebe: "+id);
		}
			
		
	}
	
}
/*
 * Mediator: O padrão mediator é um padrão que centraliza a comunicação
 * de todas as classes em uma só. Você tem um ou mais atributo e quer 
 * mandar para todas as classes, porém para que aconteça o envio para 
 * essas outras classes, você precisa que determinadas políticas de envio
 * sejam definidas, então nós temos o Padrão mediator. O mediator é
 * dividido em duas partes, na primeira tem a interface com o método de 
 * envio a interface do método de envio tem dois parametros e retorna nada,
 * um dos parametros é a classe College e o outro o(s) atributos que a
 * sua política permite que seja enviado para todas as classes. Quando
 * te falarem do mediator, lembre-se de Redes Toking Ring, aonde você
 * tem um monte de computadores ligados a um switch, no caso esse switch
 * seria o College, pois é nele que são definidos as regras, e os pacotes
 * IP seriam o Mediator, assim fica mais fácil de entender. O mediator 
 * seria nessa analogia o pacote IP, ele leva dados de um computador 
 * para outro, ou seja ele é o responsável por levar a mensagem, já o
 * College seria o switch ele faz a ligação entre os computadores, e na
 * nossa analogia o Concrete seria a porta Ethernet, a porta Ethernet é a
 * porta de entrada ou saída, é por essa porta que o seu "sistema"
 * vai enviar e receber um pacote.  
 * o switch ele é um hardware que faz a ligação entre dois ou mais computadores
 * e eles se comunicam enviando pacotes um para o outro, nessa analogia
 * os switchs dessa rede seria o college. Por fim nós temos os computadores
 * propriamente dito, que na analogia são as classes que extendem de college,
 * repare que em uma rede de computadores, o computador deve ser membro
 * de uma rede e pertencer a essa rede. Nesse caso a classe People e 
 * Worker seriam dois computadores, se comunicando através de um switch
 * que seria a college, mandando pacotes IP um para o outro que seria o
 * Mediator, porém esses "computadores" eles precisam ter instalado os
 * protocolos de rede, ou seja implementado o Mediator e por fim eles devem
 * ser conectados ao switch, em outras palavras extender de college,
 * para que a comunicação entre eles possa ser feita, por fim nós temos
 * a Concrete. O concrete é a Ethernet, ele é o que faz a comunicação
 * entre o computador e o switch, é por essa porta que será feito o
 * envio de pacotes ip pelo nosso switch até chegar ao computador de destino.
 * */
