import java.util.*;
class file{
	int num;
	String nome;
	
}
public class classes {

	public static void main(String[] args) {
	Scanner enter = new Scanner(System.in);
	file f = new file();
	System.out.println("Insira um número");
	f.num = Integer.parseInt(enter.nextLine());
	System.out.println("Insira um nome: ");
	f.nome = enter.nextLine();
	}

}
// Todos os arquivos ".java", tem que ter o nome da Classe pública.
//Todas as classes usadas no código deve ser instanciadas, não se esqueça.
//Na hora de compilar, será criado dois arquivos, um para cada classe.