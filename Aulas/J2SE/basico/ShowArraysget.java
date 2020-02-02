import java.util.ArrayList;
public class ShowArraysget{
	public static void main(String [] args){
		ArrayList<Integer> listmun = new ArrayList<>();
		listmun.add(1);
		System.out.println("O valor do Array começa com: "+listmun.get(0));
		System.out.println("A formula é: Array = Valor do Array + valor Array anterior + o numero no laço.\n");
		for(int i=1;i<10;i++){
		listmun.add(i + listmun.get(i-1));
		System.out.println("O Valor de "+i+" + Valor do Array anterior "+listmun.get(i-1)+" é: "+listmun.get(i));
	}
	}
}
