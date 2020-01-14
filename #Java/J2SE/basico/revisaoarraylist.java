import java.util.ArrayList;
public class revisaoarraylist{
public static void main(String args[]){
	ArrayList <Integer> numi = new ArrayList <Integer>();
	ArrayList <Double> numd = new ArrayList <Double>();
	for(int i=0;i<100;i++){
		numi.add((i+1)*(i+1));
		numd.add(Math.sqrt(i+1));
	 }
	 for(int i=0;i<numi.size();i++){
	System.out.print("O Número "+(i+1)+": Elevado ao quadrado é: "+numi.get(i)+"\nA raiz quadrada de "+(i+1)+" é: "+numd.get(i)+"\n\n");	 
	}
}
}
// A função Math.sqrt é como se obtem a raiz quadrada de um determinado numero.
//ArrayList, cria Arrays de maneira dinamica. o método ".get", retorna o valor de um Array.
// Para remover ".remove(indice do array), editar ".set(indice do array, o valor novo).
// ".toString()" exibe todo o valor do Array, ".contains(o que procura)" retorna um booleano, caso ache o valor dos parenteses.
//".size()" retorna o tamanho do array, a função trabalha com inteiro, mais não retorna positivos, é uma função vazia.
//".add()" adiciona valor ao array, quando antecedido por um inteiro, empurra os valores abaixo, como por exemplo ".add(int,mais o que vc quer)".
// No caso ".add(int, valor)" O valor do indice referenciado pelo inteiro, ocupa o proximo espaço do vetor, e isso ocorrem em cascata. 
//".indexOf(o que vc procura)", retorna um valor inteiro, que representa a posição no array do valor que você busca.
//O ArrayList trabalha com genéricos também.
