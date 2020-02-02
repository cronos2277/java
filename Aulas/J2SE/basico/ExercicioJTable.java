import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ExercicioJTable{
	public static void main(String [] args){
	JTable tabela = new JTable(); //Colocar qualquer objeto a ser instanciado, antes do JFrame para evitar bugs.
	String[][] lista = {{"João","12"},{"Lucas","13"},{"Alfredo","14"}};
	String[] cab = {"Números","Quadrados"};
	JFrame janela = new JFrame("Tabelas");
	janela.setVisible(true);
	janela.setLocationRelativeTo(null);
	janela.setSize(300, 400);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tabela.setModel(new DefaultTableModel(lista,cab));
	janela.add(new JScrollPane(tabela));
//JTable tem problemas com a função: JFrame.setDefaultLookAndFeelDecorated(true), setado em JScrollPane();
		}
}

	

