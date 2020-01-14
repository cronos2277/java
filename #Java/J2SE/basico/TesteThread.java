class processo implements Runnable{
	int x;
	public String mensagem(int num){
		num += 1;
		String mensagem = Integer.toString(num);
		return mensagem;
	}//entra inteiro, sai String.
	
	public void run(){
		try{
		while(true){
		System.out.print(mensagem(x++)+"s, ");
		Thread.sleep(1000);}}catch(Exception e){}
		
	}
}
public class TesteThread{
	public static void main(String [] args){
	processo tempo = new processo(); //instanciando a classe processo.
	Thread TTempo = new Thread(tempo); //instanciando o objeto da classe Thread. 
	Thread TTTempo = new Thread(tempo);
	TTempo.start(); //função da classe Thread que executa tudo dentro da função run.
	TTTempo.start();//Com o diferencial, de permitir o uso de processo paralelo.
	}//Repare que a contagem de tempo ocorrerá de dois em dois segundos, pois o processo da classe tread esté dividido em dois processos.
}
//Existem duas formas de se usar uma classe Thread, uma delas implentando o runnables, e a outra extendendo da classe Thread.
//A classe implementada pela runnables ou extendida, deve obrigatóriamente ter a função "public void run()", aonde tudo dentro
//dela será executada paralelamente, essa função, é como se fosse o "public static void main(String [] args)", dessa classe.
//A função Thread.sleep(Milisegundos), ela espera um tempo estipulado, antes de executar de novo o laço. com o seu uso, se faz
//obrigatório o uso do try catch, para lidar com uma exceção.
 