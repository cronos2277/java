import java.util.Scanner;

abstract class pai{
protected String texto;
protected Boolean bol;
protected char x;
protected int inum;
protected double dnum;
}
interface padrao{ 
	static int y = 1;
	void qtd ();
}

class filha extends pai{
	Scanner entra = new Scanner(System.in);
	public String ttexto(String texto){
		System.out.println("Dígite um texto");
		String txt = entra.nextLine();
		return txt;
	}
	
	public boolean bbol(Boolean bol){
		System.out.println("Digite true, caso queira que o Booleano seja verdadeiro");
		Boolean b = Boolean.parseBoolean(entra.nextLine()); return b;
	}
	
	public char xx(char xx){
		System.out.println("Dígite uma letra\n");
		String palavra = entra.nextLine();
		xx = palavra.charAt(0);
		if(Character.isDigit(xx))
			System.out.println("É um número");
		if(Character.isLetter(xx))
			System.out.println("É uma letra");
		return xx;
	}
	
	public int numero(int num){
		System.out.println("Digite um número: \n");
		num = Integer.parseInt(entra.nextLine());
		System.out.println("Você digitou "+num+", tipo real");
		String sd = Integer.toString(num);
		System.out.println("Você digitou "+sd+", tipo String");
		return num;
	}
	public double real(double real){
		System.out.println("Dígite um número, qualquer\n");
		real = Double.parseDouble(entra.nextLine());
		String treal = Double.toString(real);
		System.out.println("O número que você digitou, em formato real"+real);
		System.out.println("O número que você digitou em formato String"+treal);
		return real;
	}
	public void imprimir(){
		System.out.println("O valor da, String texto :"+super.texto);
		System.out.println("O valor do, Booleano bol :"+super.bol);
		System.out.println("O valor do, Charácter x:"+super.x);
		System.out.println("O valor do, Inteiro inum:"+super.inum);
		System.out.println("O valor do, Double dnum :"+super.dnum);
	}
	public filha(){System.out.println("Instanciando classe...");}
	private String nome;
	public void setNome(String nome){this.nome = nome;}
	public String getNome(){return this.nome;}
	}
public class objetos1 extends filha implements padrao{
	public static void main(String [] args){
		
		Scanner f = new Scanner(System.in);
		filha classe = new filha();
		classe.texto = classe.ttexto(classe.texto);
		classe.bol = classe.bbol(classe.bol);
		classe.x = classe.xx(classe.x);
		classe.inum = classe.numero(classe.inum);
		classe.dnum = classe.real(classe.dnum);
		System.out.println("Dígite um nome, para a variável privada: ");
		classe.setNome(f.nextLine());
		System.out.println("O valor da varíavel protegida é: "+classe.getNome());
		classe.imprimir();
		
	}

	//@Override
	public void qtd(){System.out.println("Interface detectada");}
 //Implementação de interface sempre fica no final, pois se trata de uma assinatura.

	
}
