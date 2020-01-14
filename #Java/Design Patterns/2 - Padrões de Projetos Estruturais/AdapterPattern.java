import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class AdapterPattern{
	
	public static void main(String args[]){
		String leia = "file.txt";
		String escreva = "bck.txt";
		Adapter exemple = new Adapter();
		exemple.backup(leia,escreva);
	}
	
}
//Nas linha abaixos está a classe e a sua interface, responsável pela leitura do arquivo.
interface ReadInterface<Class>{
	public Class readFile(String dir_name);
	public void fileShow();
}

class ReadClass implements ReadInterface<ReadClass>{
	public ArrayList<String> str = new ArrayList<String>();		
	public ReadClass readFile(String dir_name){
		try{			
			String line = null;			
			FileReader file = new FileReader(dir_name);
			BufferedReader buffer = new BufferedReader(file);
			/*O método readLine do objeto BufferedReader é dor de cabeça garantida.
			 * esse método ao ser vericado através de uma expressão booleana, ela já
			 * muda o seu valor, por isso que o line abaixo já recebe valor ao ser
			 * analisa pelo laço while.
			 * */
			while((line = buffer.readLine()) != null)
				this.str.add(line);			
			file.close();
			System.out.println("JVM:~$ List de String criado com sucesso. Tamanho: "+str.size());	
			return this;		
		}catch(IOException e){System.out.println("\nJVM:~$ Arquivo '"+dir_name+"' não foi Localizado");return null;}
	}
	
	public void fileShow(){
		int x = 1;
		System.out.println("\n");
		for(String s: this.str)
			System.out.println("usr(User file line ["+(x++)+"]):~$ "+s);
		System.out.println("\nJVM:~$ Conteúdo do arquivo do usúario exibido com sucesso!\n");
	}
	
}

//Aqui nas linhas abaixo, está a classe original que escreve arquivos e a sua interface.
interface WriteInteface<Class>{
	public Class writeFile(String path, ArrayList<String> lista);
}

class WriteClass implements WriteInteface<WriteClass>{
	public WriteClass writeFile(String dir_name,ArrayList<String> toWriter){
		try{						
			FileWriter file = new FileWriter(dir_name);
			for(String line: toWriter)
				file.write(line+"\n");
			System.out.println("\nJVM:~$ Arquivo reescrito com sucesso!");
			file.close();
			return this;
		}catch(IOException e){System.out.println("\nJVM:~$ Arquivo a ser reescrito, não localizado!\n");return this;}
	}
}

//Classe adaptada, matéria de estudo nesse padrão de projeto, ela adapta as duas classes acima.
class Adapter implements ReadInterface<Adapter>, WriteInteface<Adapter>{
	/*Repare que essa classe a implementação da mesma interface acima e ela instancia dois objetos
	 * um de cada classe, e os métodos são uma gambiarra feita com os objetos instanciado, em essencia
	 * o projeto adapter, é uma classe de gambiarra, porém organizada.
	 * */
	private ArrayList<String> str = new ArrayList<String>();		
	private WriteClass write;
	private ReadClass read;	
	public Adapter(){
		System.out.println("JVM:~$ Classe Adapter instanciada!");
		this.write = new WriteClass();
		this.read = new ReadClass();
	}
	
	public Adapter backup(String fileToRead, String fileToWrite){
		System.out.println("JVM:~$ Iniciando o método backup do adaptador...");
		this.read.readFile(fileToRead);		
		this.write.writeFile(fileToWrite,this.str);
		System.out.println("JVM:~$ Finalizando o método backup do adaptador...");
		return this;
	}
	
	public Adapter readFile(String dir_name){ 
	//O mesmo método exigido pelas interfaces, mas executados pelos objetos instanciados
		this.read.readFile(dir_name);
		return this;
	}
	
	public void fileShow(){
		this.read.fileShow();
	}
	
	public Adapter writeFile(String dir_name,ArrayList<String> toWriter){
		this.writeFile(dir_name,toWriter);
		return this;
	}
	
	public void setToWrite(ArrayList<String>lista){		
		this.str = lista;
		System.out.println("JVM:~$ Lista inserida pelo usuário!");
	}
	
	public ArrayList<String> getSavedHere(){		
		System.out.println("JVM:~$ Lista recuperada pelo usuário!");
		return this.str;
	} 
		
}

/*
 * O padrão adapter é nada mais que uma classe que adptação, se usarmos a seguinte analogia:
 * Temos uma classe Tomada e uma classe cabo de Energia, nessa analogia o adapter
 * seria o adaptador para a tomada de três pinos, ou aquele T que pode colocar
 * uma renca de eletronicos na tomada, proporcionando para nós um grande risco de 
 * incendio. No exemplo existe duas classes, uma que lê arquivos e a outra que escreve arquivos,
 * no caso a adpter nesse exemplo, faz com que as duas classes diferentes, trabalhem juntas.
 * Tanto a classe que escreve e a classe que lê são instanciadas na classe adapter e os seus métodos e as suas
 * interface são adaptadas para a classe que está fazendo a adptação.
 * */
