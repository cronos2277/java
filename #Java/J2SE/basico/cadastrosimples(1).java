import java.util.*;
public class cadastrosimples{
	public static void main(String [] args){
	//Iniciando cole��es;
	TreeSet<Integer> idade = new TreeSet<Integer> ();
	ArrayList<String> nome = new ArrayList<String>();
	ArrayList<String> cidade = new ArrayList<String>();
	ArrayList<String> estado = new ArrayList<String>();
	Scanner clientes = new Scanner(System.in);
			try{
					
			
					System.out.println("Digite um nome para o cliente: ");
					String nome1 = clientes.nextLine();
					nome.add(nome1);
					
					System.out.println("Digite a idade do cliente: ");
					String idadet = clientes.nextLine();
					idade.add(Integer.parseInt(idadet));
					
					System.out.println("Digite uma cidade: ");
					cidade.add(clientes.nextLine());
					
					System.out.println("D�gite os Dois D�gitos do seu estado. Ex: Bras�lia, digite DF");
					estado.add(clientes.nextLine());
					
				
	}catch(Exception e){System.out.println("Valor digitado � inv�lido.");}finally{System.out.println("Progama encerrado!");
	}
}
}