import java.io.*;
public class EscrevendoArquivosJava{
public static void main(String [] args){

String nome = "arquivos.txt"; //String contendo o nome do arquivo.
File file = new File(nome);//criando um novo arquivo, em base ao conteúdo da String nome.

try{
file.createNewFile();}catch(IOException ex){System.out.println("Erro! Ao criar arquivos");}
//aqui é criado um novo arquivo. O uso do try-catch é obrigatório. A função cria, um arquivo,
//em base no parâmetro informado pela instanciação do objeto, perceba que a funcão createNewFile(),
//não recebe argumentos.

try{
FileWriter esc = new FileWriter(nome); //Aqui cria um objeto para escrever no arquivo.
BufferedWriter escrever = new BufferedWriter(esc); //Esse objeto escreve no arquivo, usando como
//parametro, o objeto acima.

escrever.write("Escrevendo... \nTeste java!"); // esse é o método que escreve, no arquivo. 
 
//as funções abaixo é para encerrar, o objeto. Esse processo é necessário, pois do contrário
//o arquivo não é salvo.
 
escrever.close(); 
esc.close();

}catch(IOException ex){System.out.println("Erro ao escrever, no arquivos");}
//toda a função deve ser feito dentro de um try catch.
}
}
//veja que dentro dos catch, tem o "IOException ex". Bom para usar esse tratamento de erro tem que importar
//o Java.io.IOException;