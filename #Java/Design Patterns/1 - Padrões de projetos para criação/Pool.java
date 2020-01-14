import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;
public class Pool{
	
	//OBS: Se faz necessário criar um arquivo "File_0.txt", para não cair na IOException.
	public static void main(String args[]){
		System.out.println("User:~$ Criando o PoolObject.");
		FileReaderPool pool = new FileReaderPool();
		System.out.println("\nUser:~$ Criando o FileReader através do Pool.");
		FileReader reader1 = pool.poolNew();
		System.out.println("\nUser:~$ Devolvendo o PoolObject.");
		pool.poolRem(reader1);
		System.out.println("\nUser:~$ Pegando novamente o PoolObject.");
		FileReader reader2 = pool.poolNew();
		System.out.println("\nUser:~$ O Pool Object será negado a este FileReader, pois o mesmo já está em uso.");
		FileReader reader3 = pool.poolNew();
		
	}
	
}

abstract class AbstractFileReaderPool{
	protected final int maxInstance = 1; //Numero máximo de instancias de FileReader que o usuário pode pegar.
	//O nome que terá os arquivos criados pela classe, valido lembar que este número é seguido de numero.
	protected String FileName = "File_"; 
	
	//unlocked conterá o objeto livre e o locked o objeto em uso, caso não tenha nada em unlocked, nenhum objeto é retornado.
	protected Map<Integer,FileReader> unlocked = new HashMap<Integer,FileReader>();
	protected Map<Integer,FileReader> locked = new HashMap<Integer,FileReader>();
	protected AbstractFileReaderPool(){
		this.init(); //Neste método é feito o carregamento das instancias informado no maxInstance.
	}
	protected FileReader fileReaderThis(String name){
		/*
		 * Para criar um objeto do tipo fileReader, se faz obrigado a tratar
		 * da IOException, além disso esse método tem como parametro uma String
		 * que se refere ao local do arquivo + nome e extensão dele.
		 * */
		try{
			return new FileReader(name);
		}catch(IOException e){e.printStackTrace();return null;}
	}
	
	protected void init(){ 
		/*
		 * Aqui é criada a condição padrão da classe, assim que se inicia o chamamento dela, 
		 * assim sendo ela irá criar o número de objeto informado em maxInstace e colocar todas 
		 * dentro do HashMap unlocked, a medida que o usuário vai pegando os objetos o Map
		 * locked vai ficando carregada, quando a Map unlocked não tiver mais objetos, o
		 * usuário será impedido de pegar outro objeto até que devolva, algum que esteja em uso,
		 * caso o numero de maxInstance seja maior que 1.
		 * */
		for(int i=0;i < maxInstance;i++){		
			this.FileName += String.valueOf(i)+".txt";
			this.locked.put(i,null);
			this.unlocked.put(i, fileReaderThis(this.FileName));
			System.out.println(" JVM:~$ Valores iniciados.");
		}
	}
	
	protected FileReader poolNew(){
		/*
		 * caso tenha um objeto dentro do unlocked, essa classe ela retorna esse objeto para
		 * o usuário e depois põe na classe locked, informando assim que o objeto está ocupado.
		 * */
		for(int i=0; i < maxInstance; i++){
			if(this.locked.get(i) == null && this.unlocked.get(i) != null){
				this.locked.put(i,unlocked.get(i));
				this.unlocked.put(i,null);
				System.out.println(" JVM:~$ Objeto criado com Sucesso!");
				return this.locked.get(i);
			}
		}
		System.out.println(" JVM:~$ Objeto não criado!");		
		return null;
	}
	
	protected void poolRem(FileReader reader){
		/*
		 * Nesse Método será devolvida o objeto, ele faz o caminho inverso do previsto no método
		 * poolNew(), ele tira o objeto do Map locked e passa para o unlocked.
		 * */
		for(int i=0; i < maxInstance;i++){
			if(this.locked.get(i) == reader){
				this.unlocked.put(i,reader);
				this.locked.put(i,null);
				System.out.println(" JVM:~$ Objeto devolvido com sucesso!");
			}
		}
	}	
}

class FileReaderPool extends AbstractFileReaderPool{
	/*
	 * Aqui essa é a classe concreta, ela herda e chama os métodos
	 * da classe abstrata, ela se faz necessário, pois ela é que será
	 * instanciada para gerenciar os pools, sendo que com a abstrata você
	 * tem limitação
	 * */
	public FileReader getFileReader(){
		return poolNew();
	}
	
	public void setFileReader(FileReader reader){
		poolRem(reader);
	}
}
/*
 * O Object pool tem a utilidade de controlar o número de objetos a ser instanciado,
 * ele é útil, quando se é muito custoso em recursos de processamento de se instanciar
 * um objeto e você precisa exercer um controle de quantos objetos se pode ter no projeto.
 * Por exemplo ao se criar uma renca de objetos para se conectar ao SGBD se tem uma grande
 * perda de desempenho, sendo mais interessante ter uma quantidade de objetos maximos que se
 * faça isso, enfim se que controlar o número de objetos a ser instanciado, o Object Pool 
 * é o indicado
 * */
