package javapackage;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class ExercicioStatement{
	public static void main(String [] args){
		Componentes comp = new Componentes();
		JFrame janela = new JFrame("Statement Grafico");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 150);
		janela.setLocationRelativeTo(null);
		janela.addKeyListener(comp.comando);
		comp.texto.addActionListener(comp.comando);
		comp.idade.addActionListener(comp.comando);
		comp.botao.addActionListener(comp.comando);
		janela.getContentPane().setLayout(new GridLayout(3,2));
		janela.getContentPane().add(comp.tarja1);
		janela.getContentPane().add(comp.texto);
		janela.getContentPane().add(comp.tarja2);
		janela.getContentPane().add(comp.idade);
		janela.getContentPane().add(comp.tarja3);
		janela.getContentPane().add(comp.botao);
	}
}
class Componentes{
Comando comando = new Comando();

JLabel tarja1 = new JLabel("Informe o nome: ");
JLabel tarja2 = new JLabel("Informe a idade: ");
JLabel tarja3 = new JLabel("Clique aqui para adicionar: ");
JTextField texto = new JTextField(50);
JTextField idade = new JTextField(3);
JButton botao = new JButton ("Registrar!");

	class Comando implements KeyListener, ActionListener{
		String message = "Dado cadastrado.";
		String Texto;
		String id = "";
		int Idade = 0;
		public void actionPerformed(ActionEvent evento){
		if(evento.getSource()==texto){Texto = String.format("%s",evento.getActionCommand());JOptionPane.showMessageDialog(null, message);}
		if(evento.getSource()==idade){id = String.format("%s",evento.getActionCommand());
		try{Idade = Integer.parseInt(id);
		JOptionPane.showMessageDialog(null, message);			
		}catch(Exception e){JOptionPane.showMessageDialog(null, "Valor inv�lido para idade");}
		}
		if(evento.getSource()==botao){
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://127.0.0.1:3306/cliente?user=root&password=123456";
		Connection com = DriverManager.getConnection(url);
		Statement st = com.createStatement();
		JOptionPane.showMessageDialog(null, "conectado");
		String sql = "insert into c_cli(nome,idade) values ('"+Texto+"',"+Idade+");";
		st.executeUpdate(sql);
		
		}catch(Exception e){JOptionPane.showMessageDialog(null, "N�Oconectado");}}
		}
		public void keyPressed(KeyEvent key){if(key.getKeyText(key.getKeyCode())=="F1"){JOptionPane.showMessageDialog(null, "Esse programa, se conecta a um banco de dados MySql.");}}
		public void keyTyped(KeyEvent key){}
		public void keyReleased(KeyEvent key){}
	}
}