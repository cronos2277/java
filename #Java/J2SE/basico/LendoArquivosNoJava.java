import java.io.BufferedReader; //Para ler arquivos;
import java.io.File;
import java.io.FileReader;
public class LendoArquivosNoJava{
public static void main(String [] args){

//Instanciando o objeto e criando arquivo, sempre dentro de um try, catch.
File file = new File("arquivo.txt"); 
try{file.createNewFile();}catch(Exception e){System.out.println("Erro! arquivo não encontrado");} 

//Lendo objetos, também sempre dentro de um try catch.
try{

	String arquivo = "arquivo.txt"; //essa string contém o nome do arquivo a ser lido.
	
	FileReader ler = new FileReader(arquivo); //Aqui é instanciado, o arquivo a ser lido.

BufferedReader lerb = new BufferedReader(ler); //Aqui é instanciado um objeto para ler o arquivo,
//como parâmetro é usado o objeto instanciado do FileReader.

String linha = lerb.readLine();//Essa função uma linha, e retorna uma em uma String.


while(linha != null){
System.out.println(linha);
linha = lerb.readLine(); 
//o laço while só para quando encontrar uma linha nula.
}
}catch(Exception e){System.out.println("Erro! ao ler arquivo.");}
}
}
//Esse programa ele lê um arquivo chamado, "arquivo.txt" e exibe o seu conteúdo.