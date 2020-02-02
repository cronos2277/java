
class process implements Runnable{
int num1 = 0;

public int contador(int num2){ 
return num2;
} 

public void run(){
try{
while(true){
if(num1 % 10 != 0){
System.out.print(contador(num1++)+"s, ");
Thread.sleep(1000);
}else{System.out.print(contador(num1++)+"s, \n");}}
}catch(Exception e){}
}}

public class Contador{
public static void main(String [] args){
process processo = new process();
Thread tempo = new Thread(processo);
tempo.start();
}
}