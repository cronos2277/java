public class DecoratorPattern{	
	public static void main(String args[]){		
		Decorator decorator = new Decorator(); //Instanciando o decorador
//Setando algumas configurações do decorador.
		decorator.setName("João");
		decorator.setAge(26);
		decorator.setCity("Ponta Grossa");
		decorator.setFunc("Estudante");
//Aqui instanciamos um objeto de Concrete, repare que a estrutura dele
//é bem mais simples que a do decorador.
		Interface object = new Concrete();
//É exatamente aqui que ocorre a mudança de comportamento, e o objeto muda
//o seu comportamento, mais sem perder a estrutura.
		object = decorator;
//Esse método abaixo é o mesmo que se tem em todas as classe assinadas pela
//Interface, caso você chame algum método que não tenha na interface ou na
//concrete() dará erro na compilação, pois a estrutura se mantém.
		object.run();	
		
	}
	
}

interface Interface{	
//Esse é o método em comum entre todos os objetos acima instanciado.
	public void run();
}
//Primeiro você cria uma classe concreta, para implementar os métodos
//da interface, ela deve ser concreta, ou herdar uma concreta, pois ela,
//será a primeira classe que daremos new. Ou seja um objeto do tipo Interface
//nesse exemplo, terá a estrutura dessa classe concreta abaixo.
class Concrete implements Interface{
//Essa classe trabalha apenas com indice, é o único atributo dela.
	private int index;
	public Concrete(){
		++index;
	}	
	
	public void run(){
//Método implementado da interface, veja que ele não foi reescrito.		
	}
	
	public int getIndex(){
		return this.index;
	}
}
//Classe abstrata, ela herda a concreta acima e tem a mesma interface,
//perceba que ela é mais robusta. Por ser uma classe abstrata, ela não
//precisou implementar o método da interface, sendo a sua implementação
//facultativa, mais nem por isso ela deixa de pertencer do mesmo padrão 
//que as classes que implementam a Interface. 
abstract class Abstract extends Concrete implements Interface{	
	private String name;
	private int age;
	private String city;
	private String func;		
//Essa classe é um bean.
	public void setName(String setname){
		this.name = setname;		
	}
	
	public void setAge(int setage){
		this.age = setage;
	}
	
	public void setCity(String setcity){
		this.city = setcity;
	}
	
	public void setFunc(String setfunc){
		this.func = setfunc;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getFunc(){
		return this.func;
	}
}


class Decorator extends Abstract implements Interface{
	@Override
	public void run(){	
//Veja que o decorador ele reescreve o método da interface, nesse caso
//o decorator irá reescrever o comportamento do método run e chamar os 
//"novos" atributos da classe bean acima, ao qual esta extende, para exibir 
//o seu valor, o decorador irá mudar o comportamento do objeto.
		System.out.println("Nome: "+this.getIndex());
		System.out.println("Nome: "+this.getName());
		System.out.println("Idade: "+this.getAge());
		System.out.println("Cidade: "+this.getCity());
		System.out.println("Função: "+this.getFunc());
	}
}
/*	Atenção: Esse padrão de projeto é dor de cabeça garantida!
 *  Esse padrão ele requer uma certa atenção, o decorator ele muda o
 * comportamento de um objeto em tempo de execução, sem alterar a sua
 * estrutura. Você tem o objeto do "TipoA" com determinados atributos, 
 * mas em um determinado tempo ele se comporta como um objeto do TipoB, 
 * mas sem deixar de ser um objeto do TipoA. Isso é possível por conta 
 * da interface ou da classe pai, que tanto o objeto do TipoA e TipoB,
 * possuem em comum.
 * Inicialmente você cria um objeto com determinados atributos, faz tudo
 * o que você quer nele, dai depois você cria um segundo objeto de uma outra
 * classe, mais com o mesmo pai, ou com a mesma interface, esse segundo objeto
 * será o decorador, ele poderá ter atributos adicionais ou métodos adicionais
 * uma vez feito setado os valores do segundo objeto, subscreva o primeiro objeto
 * com o segundo, mas lembre-se para isso não dar pau, eles devem ter o mesmo pai
 * ou a mesma interface, e o tipo do objeto a ser reescrito, isso é importante, 
 * deve ser do tipo da interface ou do tipo classe abstrata pai. Veja abaixo a sequencia.
 * 
 * Interface(Ou Classe abstrata) seuObjeto = new ObjetoA();
 * seuObjeto.setSuasCOnfiguracoes();
 * SuaClasseDecoradora seuObjetoDecorador = new ObjetoB();
 * seuObjetoDecorador.setSuasCOnfiguracoes();
 * seuObjeto = seuObjetoDecorador;
 * ------------------------ OU DEPENDENDO DA ESTRUTURA. -------------------------------
 * seuObjeto.setAdd(seuObjetoDecorador);
 * Seguindo os passos acima a sua classa terá sido devidamente decorada. *
 * */
