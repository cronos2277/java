import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
//É importante adicionar essa biblioteca,para usar o modelo padrão do JTbale.

public class ExemploJtable{
	public static void main(String [] args){
	String Dados[][] = {{null,null},{"1","Um"},{"2","Dois"},{"3","Três"},{"4","Quatro"}};
	String head[] = {"Número","Nome"};	
	//Para criar uma tabela DefaultTableModel no Java, um Array e uma Matriz são necessários.
	//Na Matriz vai conter os valores a serem exibidos na tabela.
	//No Array fica o cabeçalho.
	
	
	JTable tabela = new JTable();                        //Aqui instanciamos um Objeto do tipo JTable.
	tabela.setModel(new DefaultTableModel(Dados,head));  //Aqui é o parâmetro para a tabela ser exibida.
	//tabela.setModel(new DefaultTableModel(Matriz,Array));
	
	JFrame janela = new JFrame("Tabela");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(400, 200);
	janela.getContentPane().setLayout(new BorderLayout());
	janela.getContentPane().add(new JScrollPane(tabela));
	//Por fim, nesta ultima linha, colocamos um objeto dentro de um JScrollPane(JTable);	
	//Se não for colocado dentro de um JScrollPane(), o cabeçalho não aparece.
	
	}
}