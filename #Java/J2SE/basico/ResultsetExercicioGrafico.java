import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class ResultsetExercicioGrafico{
	public static void main(String [] args){
	Componentes comp = new Componentes();
	JFrame janela = new JFrame("Exerc�cio ResultSet");
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(700, 100);
	janela.addKeyListener(comp.acao);
	comp.submit.addActionListener(comp.acao);
	comp.campo.addActionListener(comp.acao);
	janela.getContentPane().setLayout(new GridLayout(1,3));
	janela.getContentPane().add(comp.tarja1);
	janela.getContentPane().add(comp.campo);
	janela.getContentPane().add(comp.submit);
	}
}
class Componentes{
	Acao acao = new Acao();
	JLabel tarja1 = new JLabel("Digite o campo a ser consultado.");
	JTextField campo = new JTextField();
	JButton submit = new JButton("Submit!");
	class Acao implements ActionListener, KeyListener{
		String Campo;
		@Override
		public void keyPressed(KeyEvent arg0) {
			String tecla = arg0.getKeyText(arg0.getKeyCode());
			if(tecla=="F1"){
				JOptionPane.showMessageDialog(null,"Menu de ajuda");
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==campo){
				Campo = String.format("%s", arg0.getActionCommand());
				JOptionPane.showMessageDialog(null, "Setado");
			}
			if(arg0.getSource()==submit){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://127.0.0.1/cliente?user=root&password=123456";
					Connection com = DriverManager.getConnection(url); 
					Statement st = com.createStatement();
					String q = "select "+Campo+" from c_cli";
					ResultSet rs = st.executeQuery(q);
					while(rs.next()){
						String exibir = rs.getString(Campo);
						JOptionPane.showMessageDialog(null, exibir);
					}
				}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro!");}
			}
		}
		
	}
}