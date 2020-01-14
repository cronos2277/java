class basica{
public double soma(double ... var1){
double total = 0;
for(double e: var1){
total += e;
}
return total;
}
}

public class foreeachandindefvarargs{
public static void main(String [] args){
basica bas = new basica();	
double num = bas.soma(15,12,14,10);
System.out.println(num);

}
}//Uma função pode receber parametros indefinidos. basta colocar "o tipo ... nome da variável".
//pode se colocar mais um argumento de entrada de dados na função, mais a variável indefinida,
//como a descrita acima, tem que ficar por ultimo. Ex: (int a, int b, int ... c) Essa seria a forma
//correta.
//Entendendo o for each: for(double e: var1). ou for((double) o tipo, (e) o nome da variavel,
//ao qual será retornado o valor de cada array, (var1) o array a ser farejado). O foreach é um for
// focado em trabalhar com arrays. ele indentifica o tamanho do array sozinho, e enquanto estiver array
//para ser analizado, ele vai executando as operações. Obs o ForEach só funciona com Arrays.