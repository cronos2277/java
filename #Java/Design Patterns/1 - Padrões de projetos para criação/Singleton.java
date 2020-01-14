import java.util.Scanner;
import java.util.Date;
public class Singleton{
	
	public static void main(String args[]){
		System.out.println(Synchronized_Singleton.getAcess());
		System.out.println("\nO valor armazenado na classe Synchronized_Singleton.simple (' "+Synchronized_Singleton.getAcess()+" ')\n");
		Simple_Object_Singleton.writeClass().setValue();
		String singleton = Simple_Object_Singleton.writeClass().getValue();
		System.out.println("Valor de Simple_Object_Singleton é: "+singleton);	
	}
	
}
abstract class Rules{
	
	//Classe Synchronized_Singleton.	
	protected static String simple = " ";
	protected static Scanner scanner = new Scanner(System.in);
	protected static synchronized String condition()
	{return " ";}	
	public static synchronized String getAcess()
	{return condition();}
	
	//Classe Simple_Object_Singleton
	protected String simp = " ";
	protected Scanner scan = new Scanner(System.in);	
	public String getValue(){return null;}
	public void setValue(){}
	public static Simple_Object_Singleton writeClass(){return null;} 	
}


class Synchronized_Singleton extends Rules{	
	private Synchronized_Singleton(){}			
	protected static synchronized String condition (){		
		System.out.println("Digite uma frase: ");
		Synchronized_Singleton.simple = scanner.nextLine();
		return Synchronized_Singleton.simple;
	}	
	public static synchronized String getAcess(){
		if(Synchronized_Singleton.simple != " ")
			return Synchronized_Singleton.simple;
		else
			return condition();
		}
	
}

class Simple_Object_Singleton extends Rules{
	private static Simple_Object_Singleton object;
	private Simple_Object_Singleton(){

		}
		
	public void setValue(){
		System.out.println("Insira uma frase para Simple_Object_Singleton: ");
			this.simp = scan.nextLine();					
	}
	
	public String getValue(){
		return this.simp;		
	}
	
	public static Simple_Object_Singleton writeClass(){
		if(Simple_Object_Singleton.object == null)
			Simple_Object_Singleton.object = new Simple_Object_Singleton();		
			return Simple_Object_Singleton.object;
	}
/* Definição "O padrão Singleton permite criar objetos únicos para os quais há apenas uma instância. "
 * Esse padrão de projeto permite o controle de numeros de instancias. Ai são dois exemplos,
 * ambos apesar de diferente correspondem ao padrão Singleton:
 * 
 * Synchronized_Singleton
 * Nessa classe você tem os atributos da classe e os métodos, todos estáticos. O construtor
 * setado como privado evita que o objeto seja instanciado fora do escopo da própria classe,
 * todos os métodos e atributos são protegidos, porém apenas um é público e de livre acesso.
 * Os metodos também tem o atributo sinchronyzed, que as obrigam executar em fila,
 * isso é interessante caso você esteja rodando mais de uma thread por vez, evitando assim
 * alguns comportamentos estranhos.
 * 
 * Simple_Object_Singleton
 * Nessa classe você tem quase todos os atributos sem o estático, exceto uma instancia da própria
 * classe, transformado em atributo dessa mesma classe, que é o conteúdo que essa classe vai conter,
 * além disso um método estatico para vericar se o objeto singleton está vazio, caso esteja vazio
 * uma nova instancia é criada, lembrando que é aqui, dentro desse método que será criadas as instancias "Classe.objetoInstanciadoDentroDela."
 * e em nenhum outro lugar mais, caso a Classe tenha um objeto com conteúdo dentro dela, ela retorna a própria classe.suaInstancia 
 * Toda vez que você for chamar classe singleton que esteja organizada como a Synchronized_Singleton , você deve chamar ela
 * da mesma forma que você chamaria um atributo estático, como pr exemplo "Classe.determinadoAtributo;" ou "Classe.determinadoMetodo();"
 * Com a Classe Simple_Object_Singleton, a coisa é um poquinho diferente, a coisa já funcionaria assim:
 * "Classe.MetodoEstatico().seuMetodoNaoEstaticoGet();" ou o "Classe.MetodoEstatico().seuAtributoNaoEstatico();"
 * 
 * Quando você ouvir falar do padrão Singleton, pense no JOptionPane, quando você usa ele, você o instancia? Não, você usa os
 * seus métodos sem precisar instanciar-lo, o JOPtionPane é o mesmo e o único para todo o escopo, e aqui vocês está criando
 * uma classe com essa estrutura, porém de duas formas diferentes. Cuidado com o padrão Singleton, o seu uso exagerado pode
 * acabar acarretando em problemas, ele é muito recomendado quando você lida com valores ou métodos globais, que poderá ser
 * acessado por qualquer parte da aplicação, como o próprio JOptionPane.
 * */
}













