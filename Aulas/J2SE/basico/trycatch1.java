public class trycatch1{
public static void main(String [] args){
try{
int num1 = 0;
int num2 = 0;
int num3 = num1/num2;
	}catch(Exception e){ System.out.println("Mensagem de Erro Personalizado!!!");}finally{
	System.out.println("\nO programa está sendo encerrado...");	
}
}	
}
//Tudo que está entre Try e catch, a caso de erro cai em catch, e são seguidos os
//logaritimos dentro da chave de catch. O Try e catch, serve para tratamentos de erros,
//ou exceções que são erros previstos, como a entrada de dados incompatíveis com,
//variaveis, etc...
// O que está entre as chaves do finally, é executado, independente se dá erro ou
//não.