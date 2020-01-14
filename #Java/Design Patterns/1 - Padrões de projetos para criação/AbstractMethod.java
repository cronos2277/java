public class AbstractMethod{ //Método principal
	public static void main(String args[]){
		Program program = new Program("MySql","Java");
		System.out.println(program.solution);
	}
	
}
abstract class Solutions{
	/*Essa Classe abstrata será extendida por uma classe concreta
	 * Repare que esta classe trabalha com duas classes abstratas diferentes.
	 * No padrão Abstract factory, você tem 2 ou mais fábricas de métodos (Factory Method) e 
	 * uma superclasse abstrata que comanda tudo via Simple method, essa classe servirá
	 * de base para criação da classe abstrata.
	 * */
	public String solution = "Contem: ";
	public Sgbd sgbd; 
	public Lang lang;
	public abstract Sgbd SolveSgbd(String var);
	public abstract Lang SolveLang(String var);
}

class Program extends Solutions{
	/*Pois bem essa é a classe concreta como dito acima, essa classe ela trabalha com o simple method,
	 * ela manipula as outras classes com base nos argmentos de seu construtor.*/
	
	public Program(String DatabaseName, String LanguageName){
		this.sgbd = SolveSgbd(DatabaseName);
		this.lang = SolveLang(LanguageName);
	}
	public Sgbd SolveSgbd(String var){
		switch(var){
				case "Oracle":{
					Sgbd oracle = new Oracle().Bank();
					solution +=  oracle.info;
					return oracle;
				}
				case "SqlServer":{
					Sgbd sql = new SqlServer().Bank();
					solution +=  sql.info;
					return sql;
				}
				case "MySql":{
					Sgbd mysql = new Mysql().Bank();
					solution += mysql.info;
					return mysql;
				}
				default: throw new IllegalArgumentException("Banco de dados informado, não existe em nosso sistema");
			}
		}
	public Lang SolveLang(String var){
		switch(var){
			case "Java":{
				Lang java = new Java().Language();
				solution += java.lang;
				return java;
			}
			case "Asp":{
				Lang asp = new Asp().Language();
				solution += asp.lang;
				return asp;
			}
			case "Php":{
				Lang php = new Php().Language();
				solution += php.lang;
				return php;
			}
			default: throw new IllegalArgumentException("A linguagem de programação informada, não existe em nosso sistema.");
		}
	}	

}



abstract class Sgbd{
	/*Classe abstrata que retorna classes extendidas dela, com base na instanciação. 
	 * Essa classe trabalha como uma method factory.
	 * */
	public abstract Sgbd Bank();
	public String info;	
		}
		
class Oracle extends Sgbd{		
		public Sgbd Bank(){
			Oracle oracle = new Oracle();
			oracle.info = "Banco de dados Oracle, ";
			return oracle;
		}
	}
	
class SqlServer extends Sgbd{	
	public Sgbd Bank(){
		SqlServer sql = new SqlServer();
		sql.info = "Banco de dados SqlServer, ";
		return sql;
		}
	}
	
class Mysql extends Sgbd{
	public Sgbd Bank(){
		Mysql mysql = new Mysql();
		mysql.info = "Banco de dados MySql, ";
		return mysql;
		}	
	}

abstract class Lang {
	/*Classe abstrata que retorna classes extendidas dela, com base na instanciação. 
	 * Essa classe trabalha como uma method factory.
	 * */
	public abstract Lang Language();
	public String lang;
	}
	
class Java extends Lang{
	public Lang Language(){
		Java java = new Java();
		java.lang = "Programado em Java.";
		return java;
		}
	}
	
class Php extends Lang{
	public Lang Language(){
		Php php = new Php();
		php.lang = "Programado em PHP.";
		return php;
		}
	}
	
class Asp extends Lang{
	public Lang Language(){
		Asp asp = new Asp();
		asp.lang = "Programado em ASP.";
		return asp;
		}
	}
	/*No Padrão de projeto "Abstract Method" você tem um "Simple Method", que manipula duas ou mais
	 * classes abstradas organizadas no padrão Factory Method, esse padrão de projeto seria uma mistura dos dois.
	 * Nesse padrão de objeto você vê uma classe criando outras de maneira mais dinâmica. Primeiro você tem dois
	 * ou mais Factory Method, no caso aqui o factory méthod irá trabalhar como uma fábrica objetos, como sugere
	 * o próprio nome, porém existe um diferencial, existe uma classe abstrata que gerencia tudo, e nessa classe
	 * que gerencia tudo, será feita as instancia dos objetos criados por essas classe, ordenadas em forma de Factory
	 * Method e por fim essa classe ela será organizada em modo simple factory e retornará os resultados conforme os 
	 * argumentos.
	 * Nesse exemplo temos a Classe abstrata "Lang()", ela herda atributos e métodos para três classes abstratas,
	 * que são "Java()", "Asp()" e "Php()", as três classes têm os mesmos métodos e os mesmos atributos, porém com
	 * conteúdos dentro desses atributos e métodos diferente, repare que apenas a estrutura é herdada e não os métodos,
	 * e os atributos, ou seja é o Method Factory em essencia, ao qual você instancia um objeto de uma classe abstrata 
	 * com base em uma classe concreta, é algo do tipo "Lang lang = new Asp().Language();", repare que o tipo de dado que
	 * o método retorna é um objeto do tipo Lang. Você também percebe a mesma estrutura com relação a classe "Sgbd()", 
	 * que é uma classe abstrata herdada por Sqlserver(), Mysql() e Oracle() e o método que retorna o objeto do tipo
	 * da classe abstrata Sgbd é o método "Bank()".
	 * Agora vem o pulo do gato, existe uma terceira classe que é abstrata e o seu nome é "Solution()", essa classe ela
	 * herda os seus métodos e atributos para uma classe chamada Program(). A classe abstrata Solution() contém dois atributos,
	 * um do tipo "Lang()" e outro do tipo "Sgbd()", sendo "Lang()" e "Sgbd()" duas classes abstratas no topo da hierarquia
	 * daquele método factory anteriormente descritos, além disso existe dois métodos cada um retornando objetos desse tipo.
	 * Na classe "Program()" você vê que ela toma uma decisão com dois laços "switch" e ela faz isso com base em um argumento
	 * passado em uma String, essa forma de organização, de se instanciar classes diferentes com base em argumentos,
	 * é basicamente o Simple Method posto em prática. Em resumo: o Abstract Method são uma série de Factory Method 
	 * sendo instanciadas através de uma classe organizada pelo method Simple. O Abstract Method é muito útil para um 
	 * programa com um número muito grande de classe. 
	 * 
	 * 
	 * */
