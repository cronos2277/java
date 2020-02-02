package javapackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class Componentes {
static int id = -1;
static String Nome_new = null;	
static String Email_new = null;
static String Tel_new = null;
static String Nome_old = null;
static String Email_old = null;
static String Tel_old = null;
static JPanel painel = new JPanel();
static JPanel Painelt = new JPanel();
Acao escuta = new Acao();
JLabel nome_l = new JLabel("Dígite o nome do cliente: ");
JLabel email_l = new JLabel("Dígite o e-mail do cliente: ");
JLabel tel_l = new JLabel("Dígite o telefone do cliente: ");
static JTextField nome_t = new JTextField(null);
static JTextField email_t= new JTextField(null);
static JTextField tel_t = new JTextField(null);
JButton cadastrar = new JButton("Cadastrar Cliente");
JButton deletar = new JButton("Deletar Cliente");
JButton editar = new JButton("Editar Cliente");
JButton limpar = new JButton("Limpar Dados");
static JPanel Paineb = new JPanel();

	
	class Acao implements ActionListener,MouseListener{
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource()==deletar){ClasseSQL.DeletarContato();}
				if(evento.getSource()==cadastrar){
					if(Nome_new != null && Email_new != null && Tel_new != null)ClasseSQL.CriarContato(Nome_new, Email_new, Tel_new);
					else{JOptionPane.showMessageDialog(null,"Todos os campos deve estar preenchidos!");}
				}
				if(evento.getSource()==nome_t){Nome_new = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Nome: "+Nome_new);}		
				if(evento.getSource()==email_t){Email_new = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Email: "+Email_new);}
				if(evento.getSource()==tel_t){Tel_new = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Telefone: "+Tel_new);}
				if(evento.getSource()==limpar){nome_t.setText(null);email_t.setText(null);tel_t.setText(null);Nome_new = null;Email_new=null;Tel_new=null;}
				if(evento.getSource()==editar){
					if(Nome_new == null){Nome_new = Nome_old;}
					if(Email_new == null){Email_new = Email_old;}
					if(Tel_new == null){Tel_new = Tel_old;}
					if(Nome_new != null && Email_new != null && Tel_new != null){ClasseSQL.EditarContato();}
					
					}
			}

			
			public void mouseClicked(MouseEvent evento) {
			int row = JotaTable.tabela.getSelectedRow();
			id = Integer.parseInt(String.valueOf(JotaTable.tabela.getValueAt(row, 0)));
			nome_t.setText(String.valueOf(JotaTable.tabela.getValueAt(row, 1)));
			Nome_old = String.valueOf(JotaTable.tabela.getValueAt(row, 1));
			email_t.setText(String.valueOf(JotaTable.tabela.getValueAt(row, 2)));
			Email_old = String.valueOf(JotaTable.tabela.getValueAt(row, 2));
			tel_t.setText(String.valueOf(JotaTable.tabela.getValueAt(row, 3)));
			Tel_old = String.valueOf(JotaTable.tabela.getValueAt(row, 3));
			}

			
			public void mouseEntered(MouseEvent arg0) {
				
				
			}

			
			public void mouseExited(MouseEvent arg0) {
				
				
			}

			
			public void mousePressed(MouseEvent evento) {
					
				
			}

			
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
	
}
}
