import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ExercicioMouseSetTextJTable{
	public static void main(String [] args){
	Componentes comp = new Componentes();
	JFrame janela = new JFrame("Eventos no Mouse Exercícios");
	JotaTable.JotaTableModel(); //Aqui carrega o cabeçalho da JTable.
	JotaTable.tabela.addMouseListener(comp.acao);
	janela.addMouseListener(comp.acao); //Aqui prepara o JFrame para receber eventos do mouse.
	janela.setVisible(true);
	janela.setLocationRelativeTo(null);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setSize(800, 600);
	janela.getContentPane().setLayout(new BorderLayout()); //Layout do JFrame.
	janela.getContentPane().add(Componentes.painel, BorderLayout.NORTH);
	Componentes.painel.setLayout(new GridLayout(1,2)); //Layout do Painel, um componente Estático.
	Componentes.painel.setBackground(Color.GRAY); //Setando a cor do Painel.
	Componentes.painel.add(comp.label1); //Adicionando componentes ao painel.
	Componentes.painel.add(Componentes.texto1);
	janela.getContentPane().add(new JScrollPane(JotaTable.tabela),BorderLayout.CENTER); //Aqui é adicionado a tabela no JFrame.
	//para insirir a tabela no JFrame, é bom que se faça dentro de um JScrollPane, se não o cabeçalho não aparece.
	JotaTable.AdicionarValores("João Paulo", "24", "Guaratuba"); //função estática que adiciona valores na JTable.
	JotaTable.AdicionarValores("José", "21", "Ponta Grossa");
	}
}
class Componentes{
	Acao acao = new Acao();
	static JPanel painel = new JPanel();
	JLabel label1 = new JLabel("No MouseListener Clicked: ");
	static JTextField texto1 = new JTextField();
	
	class Acao implements MouseListener,ActionListener{

		
		public void mouseClicked(MouseEvent e) {
		
		}

		
		public void mousePressed(MouseEvent e) { //Esse evento diz respeito quando o mouse é pressionado
			if(e.getSource()==JotaTable.tabela){ //Quando a origem do evento for a JTable.
//Os Métodos .getSelectedRow, .getSelectedColumn, .getValueAt só funciona com a JTable, e não com o modelo dela				
				
int row	= JotaTable.tabela.getSelectedRow(); 
//Esse inteiro vai receber a linha, ou seja x, do plano cartesiano,
//e vai a retorna a posição x da aonde foi clicado. Favor não confundir .getSelectedColumnCount()
//-----------------------------------------------------------------------------------------------
int column = JotaTable.tabela.getSelectedColumn(); 
//Esse inteiro vai receber a coluna, ou seja o y
//do plano cartesiano. funciona de modo idêntico ao .getSelectedRow().	
//------------------------------------------------------------------------------------------------
Object obj = JotaTable.tabela.getValueAt(row, column);
//O método .getValueAt(Integer,Integer); recebe como parâmetro dois inteiro e retorna um objeto, com o valor
//contido dentro do JTable clicado.
//-----------------------------------------------------------------------------------------------			
String Obj = String.valueOf(obj); //Convertendo objeto para String.
texto1.setText(Obj); //.setText, impõe um valor para um TextField e o atualiza em tempo real.
//Esse método trabalha apenas com String, por isso a conversão acima.
			}
		}

		
		public void mouseReleased(MouseEvent e) {
		
			
		}

		
		public void mouseEntered(MouseEvent e) {
			
			
		}

		
		public void mouseExited(MouseEvent e) {
			
			
		}


		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
}

class JotaTable{
	
	static DefaultTableModel modelo = new DefaultTableModel();
	//DefaultTableModel é o modelo a ser usado na tabela, que será usado como parâmetro no JTable.
	static JTable tabela = new JTable(modelo);
	//Aqui o JTable é instanciado usando o objeto modelo, como parâmetro.
	public static void JotaTableModel(){ //Essa função void acerta o cabeçalho da minha JTable.
		modelo.addColumn("Nome"); //Aqui adiciona o cabeçalho nome na tabela.
		modelo.addColumn("Idade"); //É válido lembrar que você adiciona no objeto modelo, e não no JTable.
		modelo.addColumn("Cidade"); //O tipo de dado aceito é a String.
	}
	public static void AdicionarValores(String nome, String idade, String cidade){
		//Essa função estática, põe valores na tabela.
		String [] lista = {nome,idade,cidade}; 
		//Aqui um array, aceitando três valores strings. Como tem apenas três cabeçalhos, 
		//apenas três valores serão visualizados na JTable.  
		modelo.addRow(lista); //comando para adicionar dados no modelo da JTable.
	}
	
}
