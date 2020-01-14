class tempo implements Runnable{
int cont;
public int contador(int num1){
return num1++;
}

	public void run(){
	try{
	while(true){	
	if(cont % 10 >= 0){	
	System.out.println(contador(cont++)+"s, ");
	Thread.sleep(1000);}
	else{
	System.out.println(contador(cont++)+"s, \n");
	Thread.sleep(1000);}}
	}catch(Exception e){System.out.println("ERRO!");}
	
}
}

public class ArquivoThread{
public static void main(String [] args){
tempo t = new tempo();
Thread thread = new Thread(t);
thread.start();
}
}