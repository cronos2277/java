import javax.swing.*;
public class Ternario{
	public static String verdadeiro = "Verdadeiro.";
	public static String falso = "Falso.";
	public static void main(String args[]){
		int valor = JOptionPane.showConfirmDialog(null,"Você deseja que o valor seja verdadeiro? ");
		if(valor < 2) //Se você clicar em cancelar a janela não é exibida.
		JOptionPane.showMessageDialog(null,"O valor é: "+(valor == 0 ? verdadeiro : falso));
	}
}

/*
 * Repare nisso: (valor == 0 ? verdadeiro : falso); 
 * Temos ai um operador ternario, o que está antes do ponto de interrogação
 * é avaliado, no caso a expressão deve ser uma expressão booleana, uma
 * vez avaliado a expressão booleana, temos a primeira expressão para
 * caso que será executado se verdadeiro, caso a expressão seja falsa
 * é executada o valor falso, Resumindo:
 * (Boolean ? True : False);
 * O interessante é usar esse tipo de expressão para colocar dentro de 
 * métodos, porém no operador ternário nós não temos um "else if".
 * 
 * JOptionPane.showConfirmDialog -> Esse valor retorna um inteiro,
 * "0" se você clicar em sim, "1" se clicar em não e "2" se você clicar
 * em cancelar.
 * */
