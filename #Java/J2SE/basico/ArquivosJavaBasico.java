import java.io.File;

public class ArquivosJavaBasico{
public static void main(String [] args){
File file = new File("Novo_Dir"); //Instanciando a classe file. No construtor como parametro, o nome do diretório a ser criado.
file.mkdir();//Comando para criar diretório, usando o parâmetro na instanciação, como nome.

//file.delete();//Comando para apagar o arquivo ou diretório, criado pela função ".mkdir()".
//A função .delete, apaga também arquivos, serve tanto para arquivos como para diretórios.

File arquivo = new File("Novo_Dir/arquivo.txt"); //criando um arquivo dentro do diretório.
try{

arquivo.createNewFile();//Função para criar novo arquivo, o uso do try catch é obrigatório.
//O método acima, cria um arquivo.txt, como informado na instanciação.

}catch(Exception e){System.out.println("Erro na criação do arquivo");} 

}
}