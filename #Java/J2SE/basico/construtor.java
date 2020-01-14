import java.util.*;
class classe1{
	private String nome;
	private int idade;
	String cidade;
	static int cli_num = 0;
	
	void setNome(String nome){
		this.nome = nome;
	}
	String getNome(){
		return this.nome;
	}
	
	void setIdade(int idade){
		this.idade = idade;
	}
	
	int getIdade(){
		return this.idade;
	}
	public classe1(){
		System.out.println("\nIniciando o Sistema de cadastramento de clientes\n");
	}
	void funcao(){
		System.out.println(" O nome do cliente �: "+this.nome);
		System.out.println("A idade do cliente �: "+this.idade);
		System.out.println("A cidade do cliente �: "+this.cidade);
		++this.cli_num;
	}
}

public class construtor{
	public static void main(String [] args){
	 Scanner entra = new Scanner(System.in);
	 int num;
	 try{
	 System.out.printf("Quantos clientes voc� quer cadastrar?\n");
	 num = Integer.parseInt(entra.nextLine());
	 classe1 classe = new classe1();
	 
	 for(int i=1;i<=num;i++){
	 System.out.println("\nDigite um nome para o "+i+"� cliente:");
	 classe.setNome(entra.nextLine());
	 System.out.println("Digite a idade de "+classe.getNome()+":");
	 classe.setIdade(Integer.parseInt(entra.nextLine()));
	 System.out.println("Digite a cidade de "+classe.getNome()+":\n");
	 classe.cidade = entra.nextLine();
	 System.out.printf("\nO Seguinte cliente foi cadastrado\n");
	 classe.funcao();
	 }
	 System.out.println("\n\n"+classe.cli_num+" clientes cadastrados!");
	}catch(Exception e){System.out.println("O Valor inserido � invalido!");}finally{System.out.println("O programa foi encerrado!");}
	}
}
// a fun��o iniciada por publica na frente, e que n�o retorna valor � o constructor,
//no java o constructor sempre � iniciado quando uma classe � instanciada.
//O construtor pode retornar valor, mais dai o parametro, tem que ser informado nos parenteses.
