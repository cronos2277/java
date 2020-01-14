import java.util.Scanner;
interface Sql{
	public String sequel(); // O Objeto será criado usando esta interface como parâmetro.
}

class Oracle implements Sql{
	@Override
	public String sequel(){
		return "Banco escolhido Oracle";
	}
}

class Mysql implements Sql{
	@Override
	public String sequel(){
		return "Banco escolhido MySql";
	}
}

class Postgree implements Sql{
	@Override
	public String sequel(){
		return "Banco escolhido PostGreeSQL";
	}
}

class Sqlserver implements Sql{
	@Override
	public String sequel(){
		return "Banco escolhido SQL Servcer";
	}
}

class Firebird implements Sql{
	@Override
	public String sequel(){
		return "Banco escolhido FireBird";
	}
}
class Bank{	 //Essa Classe será usada para chamar um dos objetos acima, com base no inteiro que o usuário irá informar.
	
	public Sql getBank(int var){
		switch(var){
		case 1: return new Oracle();
		case 2: return new Mysql();
		case 3: return new Postgree();	
		case 4: return new Sqlserver();	
		case 5: return new Firebird();
		default: throw new IllegalArgumentException("valor inválido");
		}
}
}
public class SimpleFactory{	
	public static void main(String args[]){	
		Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("	Pressione: \n 1 -> Oracle \n 2 -> MySql \n 3 -> PostGreeSql \n 4 -> SqlServer \n 5 -> FireBird \n --------- \n");	
		int var = scanner.nextInt();
		Bank bank = new Bank(); //Instanciando o Objeto Bank vazio.
		/*
		 * Na expressão abaixo, se pede para o objeto bank, via método getBank() retornar o objeto 
		 * usando um número informado pelo usuário como parametro. Repare que é a Classe Bank que decide
		 * qual objeto será retornado, com base nos argumentos informado pelo usuário.
		*/
		Sql sql = bank.getBank(var); //Perceba que o Sql é uma interface, talvez isso não funcione muito bem nas versões anteriores do java 8.
		System.out.println(sql.sequel());
		
	}
}
/* 
											Comentários.
	No padrão Simple Factory é retornado uma classe de acordo com os argumentos definido pelo usuário.
	[Bank bank = new Bank();]: Aqui é criado o objeto que contém os métodos que irá intermediar o acesso do usuário com as outras classes.
 *
	[Sql sql = bank.getBank(var);]: Aqui é chamado o método dentro do objeto criado, que irá analisar os argumentos do usuário e dar um retorno
	de acordo com que o usuário informar. O parâmetro pode ser qualquer coisa, mas o que mais marca esse padrão
	é o retorno de uma classe mediante um argumento do usuário, nesse caso o argumento do usuário é o "var".
 *											Características:
	Você tem as classes operacionais padronizada por uma interface, por fim você tem uma classe que irá gerenciar e retornar a classe desejada
	com base nos parâmetros que o usuário informar. No exemplo as classes com os nomes dos SGBD são as classes operacionais, elas serão usadas
	mediante a necessidade informada pelo usuário, a Classe Bank no caso é a classe gerente, ela com base nos parametros informado pelo usuário
	irá retornar a classe desejada, nesse tipo de padrão de projeto o programador não faz uso direto de todos as classes, existe uma classe que
	fará a intermediação, porém todas as classes operacionais devem ter a implementação de uma interface para que a JVM reconhece que as classes
	obtenham a mesma assinatura, ou isso também pode ser feito extendendo uma classe abstrata, vai da necessidade.
  */
