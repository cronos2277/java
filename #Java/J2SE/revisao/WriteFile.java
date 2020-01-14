import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class WriteFile{
//Nome do arquivo.
public static String FileName="Saved.object";

	public static void main(String args[]){
		Bean bean = new Bean();
		bean = bean.readFile();
		bean.showValue("Nome", bean.getName());
		bean.showValue("Idade", bean.getAge());
		bean.showValue("Cidade", bean.getCity());
		bean.showValue("Variável",bean.getVar());
		bean.setName(bean.getPane("Nome"));
		bean.setAge(bean.castString(bean.getPane("idade")));
		bean.setCity(bean.getPane("cidade"));
		bean.setVar(bean.getPane("valor variável"));
		new Writer(bean);
	}
}

class Bean implements Serializable{
	private transient Bean instance;
	private transient FileInputStream file_read;		
	private transient ObjectInputStream objectInput;
	private String name;
	private String city;
	private int age;
	private transient String variable;
	public void setName(String name){
		this.name = name;
	}	
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setVar(String set){
		this.variable = set;
	}
		
	public Bean readFile(){
		try{
			this.file_read = new FileInputStream(WriteFile.FileName);
			this.objectInput = new ObjectInputStream(file_read);
			this.instance = (Bean) this.objectInput.readObject();
			this.objectInput.close();
			return this.instance;
		}catch(Exception ioe){new Writer(this);ioe.printStackTrace();return null;}		
	}
	
	public String getPane(String str){		
		return JOptionPane.showInputDialog(null, "Informe "+str+": ");			
	}
	
	public int castString(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){e.printStackTrace();return 0;}
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getVar(){
		return this.variable;
	}
	
	public void showValue(String param, Object value){
		JOptionPane.showMessageDialog(null,"O "+param+", é: "+value);
	}
}

class Writer{	
	private FileOutputStream file_write;
	private ObjectOutputStream objectOutput;
	
public Writer(Bean bean){
	try{
		file_write = new FileOutputStream(WriteFile.FileName);
		objectOutput = new ObjectOutputStream(file_write);
		objectOutput.writeObject(bean);
		objectOutput.close();
	}catch(IOException ioe){System.out.println("Error on write!");}
}	
	
}

/*
 * Primeiro os dados do Bean são salvos em um arquivo definido em:
 * public static String FileName="Saved.object";
 * A classe write escreve o conteúdo de um objeto no disco usando bytecode
 * para isso a classe que será gravada deve implementar a interface
 * Serializable. É válido lembrar que a serialização é o salvamento de 
 * um objeto como arquivos.
 * 
 * FileOutputStream. Esse tipo de Objeto cria um arquivo em disco, usando uma
 * STring como parametro, nessa string deve conter o local, nome do arquivo
 * e extensão. A classe dele se encontra em java.io.FileOutputStream;
 * 
 * ObjectOutputStream. Esse tipo de objeto ele escreve no arquivo criado
 * pelo FileOutputStream, tanto que recebe um parametro do tipo FileOutputStream
 * Por exemplo: new ObjectOutputStream(FileOutputStream);
 * Ele contém dois métodos um que escreve no objeto, que é o método
 * .writeObject(bean) alé disso depois do uso o objeto deve ser fechado
 * com o método close(). java.io.ObjectOutputStream;
 * 
 * FileInputStream. ele le um arquivo criado pelo FileOutputStream, sendo
 * que o mesmo requer como parametro uma String contendo nome, local e
 * a extensão do mesmo. java.io.FileInputStream;
 * 
 * ObjectInputStream. Ele le um objeto aberto pelo FileInputStream, no
 * caso ele usa um objeto FileInputStream como paramentro como o exemplo
 * abaixo: new ObjectInputStream(FileInputStream).
 * java.io.ObjectInputStream;
 * 
 * Além disso você tem que tratar algumas exceções como a ClassNotFound
 * e a IOException.
 * 
 * */
