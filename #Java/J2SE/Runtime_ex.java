public class Runtime_ex{
	
	public static void main(String args[]){
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Sistema operacional: "+System.getProperty("os.name"));
		System.out.println("Números de núcleos de processamento: "+runtime.availableProcessors());
		System.out.println("Memoria total: "+runtime.totalMemory()+" em Bytes");
		System.out.println("Memória livre: "+runtime.freeMemory()+" Bytes");
	}
	
}
