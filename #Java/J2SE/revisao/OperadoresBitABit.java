public class OperadoresBitABit{
	public static void main(String args[]){		
		int num1 = 7;
		int num2 = 6;
		int num3 = num1 | num2; // <- Or bit a bit;
		int num4 = num1 & num2; // <- And bit a bit;
		int num7 = num2 ^ num1;//<- Xor bit a bit;
		int num5 = num2 >> num1;//Elimina num1 algorismos de num2.
		int num6 = num2 << num1;//Adiciona num1 algorismos em num2.
		
		System.out.printf("Decimal num 1 = %d%n",num1);
		System.out.printf("Binário: %s%n%n ",Integer.toBinaryString(num1));
		
		System.out.printf("Decimal num 2 = %d%n",num2);
		System.out.printf("Binário: %s%n%n",Integer.toBinaryString(num2));
		
		
		System.out.printf("(%d | %d) = %d%n",num1,num2,num3);
		System.out.printf("(%s OU %s) = %s%n",Integer.toBinaryString(num1),Integer.toBinaryString(num2),Integer.toBinaryString(num3));
		System.out.printf("Binário: %s%n%n ",Integer.toBinaryString(num3));
		
		
		System.out.printf("(%d & %d) = %d%n",num1,num2,num4);
		System.out.printf("(%s E %s) = %s%n",Integer.toBinaryString(num1),Integer.toBinaryString(num2),Integer.toBinaryString(num4));
		System.out.printf("Binário: %s%n%n", Integer.toBinaryString(num4));
		
		
		System.out.printf("(%d ^ %d) = %d%n",num1,num2,num7);
		System.out.printf("(%s OU Exclusivo %s) = %s%n",Integer.toBinaryString(num1),Integer.toBinaryString(num2),Integer.toBinaryString(num7));
		System.out.printf("Binário: %s%n%n",Integer.toBinaryString(num7));
		
		
		System.out.printf("%nRepare que aqui são tirados %d algarismos dos número binário %d %n.",num2,num1);
		System.out.printf("%s >> %s = %s%n%n",Integer.toBinaryString(num2),Integer.toBinaryString(num1),Integer.toBinaryString(num5));
		System.out.printf("Repare que aqui são colocados %d zeros do número binário %d %n.",num2,num1);
		System.out.printf("%s << %s = %s%n: ",Integer.toBinaryString(num2),Integer.toBinaryString(num1),Integer.toBinaryString(num6));		
		
		
	}
}
/*
 * Todos esses operadores lógicos trabalham com numeros inteiros apenas,
 * e além disso eles trabalham com esses números inteiros de forma binária
 * e não decimal, para entendermos o que se passa aqui, temos que conhecer
 * as propriedades dos números binários, além disso nós temos que conhecer
 * também a lógica booleana. 
 * No caso do número decimal 7, o seu valor em binário é 111, nesse caso
 * dependendo da operação booleana que será feita esse 1 pode variar, como
 * veremos abaixo. 
 * No caso nós temos o número 3, que seu valor binario é 11.
 * Também temos o número 6, que seu valor binário é 110, vamos as operações
 * por exemplo 7 e 6.
 * 7 = 111; 6 = 110;
 *  caso do & nós analizariamos cada algorismos, colocaríamos o valor de
 * zero, caso um dos valores a ser analizados seja diferente de 0.
 * 
 *   111   Aqui trata-se de uma conjunção e por tanto segue essa regra,
 * & 110   e nesse caso a conjunção só será verdadeira quando o todo for
 * ------- verdadeiro, e um é verdadeiro e zero é falso.
 * 	 110  
 * 
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * 
 *   111   Aqui trata-se de uma disjunção e por tanto segue essa regra,
 * | 110   e nesse caso a disjunção só será falso quando o todo for falso.
 * ------- 1 - é verdadeiro 0 Falso.
 * 	 111
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * 
 * 	 111	Aqui trata-se de uma disjunção exclusiva, por tanto segue 
 * ^ 110	essa regra, os valores só serão verdadeiros quando os valores
 * -------  lógicos forem diferentes, senão será falso, caso o primeiro
 *   001	algorismo seja igual ao que está sendo analizado falso, senão
 * 			verdadeiro.
 * 
 */
