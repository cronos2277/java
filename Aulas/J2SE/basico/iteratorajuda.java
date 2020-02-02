import java.util.*;
public class iteratorajuda{
public static void main(String [] args){
HashSet<String>cliente = new HashSet<String>();
Scanner enter = new Scanner(System.in);
System.out.println("Quantos nomes você quer registrar? ");
int nlista = Integer.parseInt(enter.nextLine());
for(int i=0;i<nlista;i++){
System.out.println("Qual é o nome do cliente ("+i+")?");
cliente.add(enter.nextLine());
}
Iterator iterator = cliente.iterator();
while(iterator.hasNext()){
Object obj = iterator.next();
System.out.println("O valor é: "+obj);
}
}
}
//O iterator, só trabalha com Sets, pelo menos essa não é a sintaxe para mapas.
//Iterator (maiúsculo, significa tipo) iterator (o nome do objeto sendo instanciado)
// = cliente.iterator() <<--- aqui no caso é passado o valor da coleção para o iterator.
//.hasNext() <<---- Essa função retorna um booleano, não tendo mais valor no array, ela vai pra False.
//Object <--- é o tipo de valor que a variável "obj" vai receber, no caso ela é do tipo objeto.
//iterator.next() <---- Essa função ela retorna o valor do array.
//Em resumo, esta é a sintaxe para coleções ---> Iterator iterator = cliente.iterator();
//Enquanto o laço encontrar valor ele roda ---> while(iterator.hasNext())
//Aqui ele passa o valor encontrado no array, para uma variável do tipo objeto ---> Object obj = iterator.next();
