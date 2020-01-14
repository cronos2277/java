public class Interpreter{
	
	public static void main(String args[]){
		Message msg = new Message("Olá mundo - Impressão original.");
		System.out.println(msg.output()+"\n");
//Repare que foi adicionado a magicword "<command>".
		msg.input("<Command> Olá mundo - Após a classe interpreter");
//Aqui é instanciada a classe de Gramatica, ela herda de tradução porém,
//Você poderia criar mais Grammar ou nonGrammar, herdadndo de tradução
		Grammar convert = new Grammar();
		convert.interpreter(msg);
		System.out.println(msg.output());
	}
	
}

//Este bean trabalha com as mensagens, esse bean é a cobaia.
class Message{
	private String message;
	public Message(String str){
		this.message = str;
	} 
	
	public void input(String str){
		this.message = str;
	}
	
	public String output(){
		return this.message;
	}	
}

//Aqui são feitas as traduções, o método interpreter ele analisa
// o conteúdo da string e com base nisso ele executa uma ação ou conversão.
abstract class Translate{
	//O método principal da classe tradutora, que analisa e trata as strings
	//No caso ele não trabalha com Strings diretamente, você terá que por
	//O comando String dentro do Bean Message e passalo como parametro.
	public void interpreter(Message msg){
//A verificação abaixo: "Se começar com a palavra igual ao retorno da String do magicWord()"
//O Padrão é esse, você não faz uma verificação com base em uma string e sim com base
//em um método que retorno uma STring, pois isso deixa o código mais modular.
//Essa classe é abstrata, não instancia, porém o magicWord não ficará vazio
//como está aqui, quando estiver em tempo de execução, pois a mesma quando
//for dado um new será carregada por outra classe concreta, veja isso no main().
		if(msg.output().startsWith(magicWord())){
//Caso a condição acima seja verdadeira, a String será alterada
			msg.input(init()+space()+msg.output()+space()+end());
		}
	}
//Esse método define a palavra que o Tradutor entenderá como uma palavra de comando.
//Caso o tradutor encontre a palavra, ou a expressão que esse método retornar,
//ele entrará dentro do desvio condicional do método interpreter.
	public abstract String magicWord();
//Aqui define como será tratado os espaços entre a expressão final inicial e o corpo da mensagem.
	public abstract String space();
//Aqui define a expressão a ser adicionada ao início da mensagem.
	public abstract String init();
//aqui define a expressão a ser adionada ao final da mensagem.
	public abstract String end();
}

class Grammar extends Translate{
//Aqui é definido qual é a palavra de comando, no caso a magicword.
 private String magicword = "<Command>";
//Aqui os espaçõs entre a expressão inicial e final.
 private String space_char = "_";
 //Aqui a expressão adionada ao inicio da mensagem.
 private String init_word = "JVM:~$ ";
//Expressão adicionada ao fim da mensagem.
 private String end_char = " , By João P.";
 
 //Repare que a Classe de Gramática reescreve a classe abstrata de tradução,
 //Nesse exemplo quando for dado o new, a classe abstrata irá receber esses
 //dados como parametro.
 //Os métodos abaixos retornam os conteúdos das strings privadas acima.
 @Override	
 public String magicWord(){
	 return this.magicword;
 }
 
 @Override
 public String space(){
	 return this.space_char;
 }
 
 @Override
 public String init(){
	 return this.init_word;
 }
 
 @Override
 public String end(){
	 return this.end_char;
 }	
	
}
/*
 * Esse padrão de projeto executa instruções com base em sintaxes, você
 * coloca uma série de instruções dentro de uma String, a classe de 
 * tradução faz a verificação e converte um comando de String em uma ação,
 * além dessa classe tem a classe de Gramática ela trabalha com retorno
 * de caracter, no caso você tem métodos e a classe de Gramática apenas
 * converte um caracter, uma letra ou uma expressão em outra, apenas isso.
 * A classe Gramática trabalha com String, você poderia usar esse
 * padrão e a Classe de gramatica dentro do padrão interpreter, para 
 * traduzir textos para outros idiomas por exemplo, no caso a classe gra
 * matica só serveria para modificação de STrings, a classe de Gramatica,
 * e nonGramar devem ser separadas.
 * Temos também uma classe nonGramar, que separado da primeira, executa
 * uma ação com base na gramática, por exemplo se tiver o comando faça
 * dentro da STring de parametro, ela irá executar um método por exemplo.
 * O Padrão interpreter como o próprio nome diz, ele interpreta um comando
 * dentro de uma String, que permite ele, ou executar um comando, ou
 * retornar um STring com conteúdo alterado, como é o caso desse exemplo.
 * Um exemplo de Interpreter para ser usado com Grammar é o um projeto i18n
 *  do java, que lida exatamente com tradução, e do nonGramar, seria o
 * Hibernate por exemplo, repare que o Hibernate ele usa uma sintaxe para
 * se conectar ao banco de dados, que dentro do próprio framework através
 * desse padrão é convertido para comandos sql.
 * */


