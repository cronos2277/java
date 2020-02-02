import java.util.*;
import java.io.*;
class clienteScreen{

//variaveis de classe.

protected String nome;
protected int idade;
protected String cidade;

//variáveis Globais.

static int codigo;
static String empresa;
static int cli;
//Construtor.

public clienteScreen(){
System.out.println("Iniciando o programa.\n");
}

public void imprimir(){
	System.out.println("\n\ncliente código ("+this.cli+")");
	System.out.println("O nome é: "+this.nome);
	System.out.println("Empresa: "+ clienteScreen.empresa);
	if(this.idade > 0)
	System.out.println("A idade é: "+this.idade);
	else
	System.out.println("Idade: Não informado!");	
	System.out.println("A cidade é: "+this.cidade+"\n\n\n\n");
}
}


public class ClientesInputOutput{
public static void main(String [] args){
clienteScreen cliente = new clienteScreen();
Scanner entra = new Scanner(System.in);
System.out.println("Informe o nome da empresa.");
clienteScreen.empresa = entra.nextLine();
//Dados iniciais.
try{
//informando o número de clientes, a ser cadastrado.	
System.out.println("Quantos clientes, você deseja cadastrar?");
 clienteScreen.codigo = Integer.parseInt(entra.nextLine());}catch(Exception e){System.out.println("Valor inserido é inválido!");} 

//caso o valor seja menor igual a 0.
if(clienteScreen.codigo < 1)
System.out.println("Nenhum cliente foi cadastrado!");
for(int i=1;i<=clienteScreen.codigo;i++){
	clienteScreen.cli = i;
System.out.println("Dígite o nome do cliente");
cliente.nome = entra.nextLine();
//criando arquivo, com o nome do cliente.
File file = new File(cliente.nome);
//criando arquivo.
try {
	file.createNewFile();
} catch (IOException e) {
		e.printStackTrace();
}
try {
	FileWriter esc = new FileWriter(cliente.nome);
	BufferedWriter escreva = new BufferedWriter(esc);
	escreva.write("Nome: "+cliente.nome+"\n");
	try{
	System.out.println("Informe a idade do cliente: "+cliente.nome);
	cliente.idade = Integer.parseInt(entra.nextLine());
	escreva.write("Idade: "+cliente.idade+"\n");}catch(Exception e){
		System.out.println("Valor inserido para idade é inválido");
		escreva.write("Idade: Não informado!\n");
	}
	
	System.out.println("Qual é a cidade do cliente: "+cliente.nome);
	cliente.cidade = entra.nextLine();
	escreva.write("Cidade: "+cliente.cidade+"\n");
	escreva.write("Empresa: "+clienteScreen.empresa);
	escreva.close();
	esc.close();
	cliente.imprimir();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
}