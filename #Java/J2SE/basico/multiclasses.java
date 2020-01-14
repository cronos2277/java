import java.util.*;

class primeiro{
String nome;
int numero;
}

public class multiclasses{
public static void main(String [] args){
primeiro p = new primeiro();
Scanner entra = new Scanner(System.in);

System.out.println("Digite o nome");
p.nome = entra.nextLine();
System.out.println("Dígite um número");
p.numero = Integer.parseInt(entra.nextLine());
}
}
