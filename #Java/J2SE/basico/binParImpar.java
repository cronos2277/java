
public class binParImpar{
public static void main(String [] args){
int [][]nota = new int[5][5];
String binario;
int lgt;
for(int i=0;i<5;i++){
	System.out.println("Linha "+i);
 for(int j=0;j<5;j++){
	 nota[i][j] = i + j;
	 binario = Integer.toBinaryString(nota[i][j]);
	 System.out.print(nota[i][j]+" ==> ");
	 System.out.print("("+binario+"): ");
	 if(nota[i][j] == 0){System.out.println(" NNull, ");} 
	 else if(nota[i][j]%2==0) {System.out.print("NmPar, ");}
	 else {System.out.println(" Impar, ");}
	  if(j == 4){System.out.print("\n");}
 } 

}
}
}

