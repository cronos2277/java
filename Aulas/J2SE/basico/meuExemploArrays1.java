import java.util.Arrays;
public class meuExemploArrays1{
	public static void main(String [] args){
		int num1[] = new int[10];
		int num2[] = new int[10];
		int num3[] = new int[10];
		Arrays.fill(num3, 1);
			for(int i=0;i<10;i++){
			num1[i] = -1*(i*i + num1[i]*num1[i]);
			num2[i] = num1[i];
			System.out.println("Valor do array num1["+i+"] :"+num1[i]);
			if(i == 9)System.out.println("\n");
			}
		System.out.println(Arrays.equals(num1,num2));
		Arrays.sort(num1);
		System.out.println(Arrays.equals(num1,num2)+"\n");
			for(int i=0;i<10;i++){
			System.out.println("Valor do array num1["+i+"] :"+num1[i]);if(i == 9)System.out.println("\n");}
			for(int i=0;i<10;i++)
			System.out.println("Valor do array, num3["+i+"]: "+num3[i]);
	}
}
