public class primos{
	public static void main(String [] args){
		int num1 = 144;
		int div = 0;
for(int i = 1;i<=num1;i++){
	if( num1 % i == 0){System.out.println("O número "+i+", é divisível por:"+num1);++div;};
	if(i == num1 && div <=2){System.out.println("O número é primo");};
	if(i == num1 && div > 2){System.out.println("O número não é primo");};
}
			
}
}
