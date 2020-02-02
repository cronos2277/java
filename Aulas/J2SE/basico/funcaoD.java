import java.util.*;
class basica{
	public double raizq(double num1){
	double raizq;
	raizq = Math.sqrt(num1);
	return raizq;
	} 

}

public class funcaoD{
	public static void main(String [] args){
	Scanner entra = new Scanner(System.in);
	basica bas = new basica();
	System.out.println("Insira um valor real");
	double num2 = bas.raizq(Double.parseDouble(entra.nextLine()));
	System.out.println("O valor é: "+num2);
}
}
//Double.parseDouble(), essa função converte Strings para valores reais.
//Para criar uma função com retorno de valores, tomar cuidado para não,
//tipificar uma variável duas vezes, uma dentro do parenteses, e outra dentro
//da função.

