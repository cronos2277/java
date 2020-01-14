import java.util.Arrays;
public class jarrays{
	public static void main(String[] args){
	int num1[] = new int[10];
	int num2[] = new int[10];
	int num3[] = new int[10];
	for(int i=0;i<10;i++){
	num1[i] = -1*(i*i+num1[i]*num1[i]);
	num2[i] = num1[i];
	System.out.println("Array["+i+"]: "+num1[i]);
}
  System.out.println("\nSão iguais agora, os Arrays? ==> "+Arrays.equals(num1,num2));
  Arrays.sort(num2);
  System.out.println("São iguais agora, os Arrays? ==> "+Arrays.equals(num1,num2)+"\n");
  for(int i=0;i<10;i++)
  System.out.println("Array["+i+"]: "+num1[i]);
  Arrays.fill(num3,-12);
  System.out.println("Agora o num3 \n");
  for(int i=0;i<10;i++)
  System.out.println(num3[i]);
	}
}
		
	

