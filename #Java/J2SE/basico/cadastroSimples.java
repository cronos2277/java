import java.util.*;
class zero{
static int y;
static int x;
String [] nome = new String [x];
int [] idade = new int[x];
String [] cidade = new String [x];
	public zero(int x){
	System.out.println("\nIniciando o cadastramento de Clientes");
	System.out.println(x+" Clientes serão cadastrados\n");y=0;}
	public void nomef(String nome1){
	this.nome[y] = nome1;}

	public void idadef(int idade1){
	this.idade[y] = idade1;}

	public void cidadef(String cidade1){	
	this.cidade[y] = cidade1;}

	public void imprimir(){
		for(int i=0;i<x;i++){
		System.out.println("\n--------------------------------------------");
		int j = i+1;		
		System.out.println("Ficha do cliente: "+j);
		System.out.println("--------------------------------------------");			
		System.out.println("O nome do Cliente "+j+" é: "+this.nome[i]);
		if(this.idade[i] > 0)
		System.out.println("A idade do Cliente "+j+" é: "+this.idade[i]);
		else
		System.out.println("A idade de "+this.nome[i]+" Não foi cadastrada.");
		System.out.println("A cidade do Cliente "+j+" é: "+this.cidade[i]+"\n");
		}
	}
}
public class cadastroSimples{
public static void main(String [] args){
Scanner entra = new Scanner(System.in);
try{
System.out.println("Quantos clientes você quer cadastrar?");
zero.x = Integer.parseInt(entra.nextLine());
}catch(Exception e){System.out.println("O valor inserído, é invalido!");}
zero z = new zero(zero.x);
//Cadastrando
	for(int i=0;i<zero.x;i++){
	int j = i+1;
	System.out.println("Dígite o nome do cliente "+j);
	z.nome[i] = entra.nextLine();
	System.out.println("\n\n");
	try{
	System.out.print("Qual é a idade do "+z.nome[i]+" ?\n");
	z.idade[i] = Integer.parseInt(entra.nextLine());System.out.println("\n\n");}catch(Exception e){System.out.println("Apenas são válidos, numeros inteiros maiores que zero!");}
	System.out.println("\nQual é a cidade do "+z.nome[i]+" ?");
	z.cidade[i] = entra.nextLine();
	System.out.println("\n\n\n\n");
	}
//Exibindo os resultados.
	System.out.println("\n\n\n\n");
	z.imprimir();
}
}
