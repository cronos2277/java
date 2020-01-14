import java.util.Arrays;
public class revisao2{
public static void main(String [] args){
	int num1[] = new int[10];
	int num2[] = new int[10];
	int num3[] = new int[10];
	int num4[] = new int[10];
	Arrays.fill(num4,1);
		for(int i=0;i<10;i++){
		num1[i] = -2*(i);
		num2[i] = -2*(i);
		System.out.println(num2[i]);
			}
	System.out.println("\n"+Arrays.equals(num1,num2));
	Arrays.sort(num2);
	System.out.println(Arrays.equals(num1,num2)+"\n");
		
		for(int i=0;i<10;i++){
		System.out.println("Array num2: "+num2[i]);
		//System.out.println("Array num4: "+num4[i]);
		}
}
	}