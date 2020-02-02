import java.util.*;
class tempo implements Runnable{
static int num;

public int contador(int numx){
return numx;
}

public void run(){
try{
while(num < 60 && num > 0){
System.out.println(contador(num++)+"s, ");
Thread.sleep(1000);
}
}catch(Exception e){System.out.println("Erro");}//Função run.

}//Classe tempo.
}

public class ContadorTempo{
public static void main(String [] args){
tempo t = new tempo();
Thread tmp = new Thread(t);
Scanner entra = new Scanner(System.in);
System.out.println("Dígíte o tempo inicial, em segundos. Limite máximo 60 segundos, digite um número maior que zero");
tempo.num = Integer.parseInt(entra.nextLine());
tmp.start();
}
}