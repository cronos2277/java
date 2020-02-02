import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;
public class ConexaoMySqlExercicioGrafico{
	public static void main(String [] args){
	Componentes comp = new Componentes();
	Tarjas tarja = new Tarjas();
	JFrame janela = new JFrame("Conectando ao Mysql: F1 Ajuda");
	janela.addKeyListener(comp.acao);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setVisible(true);
	janela.setLocationRelativeTo(null);
	janela.setSize(500, 200);
	comp.conect.addActionListener(comp.acao);
	comp.banco.addActionListener(comp.acao);
	comp.user.addActionListener(comp.acao);
	comp.pass.addActionListener(comp.acao);
	janela.getContentPane().setLayout(new GridLayout(4,2));
	janela.getContentPane().add(tarja.label0);
	janela.getContentPane().add(comp.banco);
	janela.getContentPane().add(tarja.label1);
	janela.getContentPane().add(comp.user);
	janela.getContentPane().add(tarja.label2);
	janela.getContentPane().add(comp.pass);
	janela.getContentPane().add(tarja.label3);
	janela.getContentPane().add(comp.conect);
	}
}

class Componentes{
	Acao acao = new Acao();
	JTextField banco = new JTextField(30);
	JTextField user = new JTextField(30);
	JTextField pass = new JTextField(30);
	JButton conect = new JButton("Conectar");
	

class Acao implements ActionListener, KeyListener{
	String tecla;
	String Banco;
	String User = "";
	String Pass = "";
	public void actionPerformed(ActionEvent evento){
	if(evento.getSource()==banco){
	Banco = String.format("%s", evento.getActionCommand());
	JOptionPane.showMessageDialog(null, "Acessar o banco de dados: "+Banco);
	}
	if(evento.getSource()==user){
	User = String.format("%s",evento.getActionCommand());	
	JOptionPane.showMessageDialog(null, "Usuário: "+User);
	}
	if(evento.getSource()==pass){
	Pass = String.format("%s",evento.getActionCommand());	
	JOptionPane.showMessageDialog(null, "Senha: "+Pass);	
	}
	if(evento.getSource()==conect){	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://127.0.0.1/"+Banco+"?user="+User+"&password="+Pass;
	Connection com = DriverManager.getConnection(url);
	JOptionPane.showMessageDialog(null,"Conectado ao Banco de dados");
	}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados. Verifique os dados digitados");}
	}
}
	public void keyPressed(KeyEvent key){
		tecla = key.getKeyText(key.getKeyCode());
		if(tecla=="F1"){JOptionPane.showMessageDialog(null, "Digite um login e uma senha e o nome de uma banco de dados, para se conectar ao banco de dados do MySql:");}
	}
	public void keyTyped(KeyEvent key){}
	public void keyReleased(KeyEvent key){}
}
}
class Tarjas{
	 JLabel label0 = new JLabel("Informe o banco de dados.");
	 JLabel label1 = new JLabel("Informe o nome do Usuário.");
	 JLabel label2 = new JLabel("Informe a senha do usuário.");
	 JLabel label3 = new JLabel("Clique aqui, para conectar.");
	}