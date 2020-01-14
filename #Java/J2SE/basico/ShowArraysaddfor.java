import java.util.ArrayList;
public class ShowArraysaddfor{
	public static void main(String [] args){
		ArrayList <Integer> numl = new ArrayList <> ();
		int num1 = 10;
		for(int i=0;i<10;i++){
			numl.add(-1*(i*i + num1*num1));
			--num1;
			System.out.println("Array numl["+i+"], é: "+numl.get(i));
		}
		
		}
}
