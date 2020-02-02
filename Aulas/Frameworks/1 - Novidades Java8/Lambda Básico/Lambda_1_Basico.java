//Requer o Java 8 ou superior para funcionar.

interface Padrao{
	public  void funcao();
	
}
public class Lambda_1_Basico {
	public static void main(String args []){
	//Lambda com função abstrata. 
	Padrao padrao = () -> System.out.println("Olá Mundo!");
	padrao.funcao(); //Chamando método da "interface instanciada".
	

	}
}

/* 							Sobre Lambda:
Temos ai um exemplo do uso de uma lambda. Em princípio a lambda serveria, para a criação
de um função anonima. Você pode usar uma interface, semelhante a uma classe, com este 
recurso. Veja, que a interface foi instanciado de maneira semelhante a uma classe
Padrao padrao = 
-> A seta indica, que se trata de uma lambda. A JVM sabe que se trata de uma lambda pelo
símbolo da seta.
Após a seta temos o conteúdo de um método. Seria como se o System.out.println("String")
funcionasse dentro do método funcao. Ou seja, tudo que está a direita da seta, seria o
conteúdo do método da interface. Após isso na linha abaixo,é chamado o método usando o
objeto instanciado. Resumindo.
 Classe Objeto () -> Conteudo do método;
 Objeto.o metodo que você quer. 	
  	
*/