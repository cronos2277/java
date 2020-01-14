
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class CrudTudoEmbutidoExercicio {
static Componentes comp = new Componentes();
static JFrame janela = new JFrame("Exemplo Crud");
	
public static void main(String[] args) {
	
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(400, 200);
	comp.submit.addActionListener(comp.acao);
	comp.nome.addActionListener(comp.acao);
	comp.email.addActionListener(comp.acao);
	comp.telefone.addActionListener(comp.acao);
	comp.view.addActionListener(comp.acao);
	janela.getContentPane().setLayout(new GridLayout(4,4));
	janela.getContentPane().add(comp.nome_aviso);
	janela.getContentPane().add(comp.nome);
	janela.getContentPane().add(comp.email_aviso);
	janela.getContentPane().add(comp.email);
	janela.getContentPane().add(comp.telefone_aviso);
	janela.getContentPane().add(comp.telefone);
	janela.getContentPane().add(comp.view);
	janela.getContentPane().add(comp.submit);
	}

}

class Componentes {
static String Nome_f;
static String Email_f;
static String Tel_f;	
Acao acao = new Acao();
JLabel nome_aviso = new JLabel("D�gite o nome: ");
JLabel email_aviso = new JLabel("D�gite o E-mail: ");
JLabel telefone_aviso = new JLabel("D�gite o Telefone: ");
JTextField nome = new JTextField();
JTextField email = new JTextField();
JTextField telefone = new JTextField();
JButton submit = new JButton("Cadastrar!");
JButton view = new JButton("Consultar");
	class Acao implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			
			if(evento.getSource()==nome){Nome_f = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Definido: "+Nome_f);}
			if(evento.getSource()==email){Email_f = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Definido: "+Email_f);}
			if(evento.getSource()==telefone){Tel_f = String.format("%s", evento.getActionCommand());JOptionPane.showMessageDialog(null,"Definido: "+Tel_f);}
			if(evento.getSource()==view){ContatoDao.consultar();}
			if(evento.getSource()==submit){
				if(Nome_f!=null && Email_f!=null && Tel_f!=null){ContatoDao.inserir();}
			else{JOptionPane.showMessageDialog(null, "Para cadastrar todos os campos, devem estrar preenchidos!");}}
			}
		}
		
	}

class ContatoDao extends JotaTable{
static int Cod_c;
static String Nome_c;
static String Email_c;
static String Tel_c;
public static void inserir(){
try{
Connection com = SQLConnection.getConnection();
Statement stat = com.createStatement();	
String q = "insert into cliente(nome,email,telefone) values ('"+Componentes.Nome_f+"','"+Componentes.Email_f+"','"+Componentes.Tel_f+"');";
stat.executeUpdate(q);
JOptionPane.showMessageDialog(null, "Cliente cadastrado com Exito!");
SQLConnection.close(com, stat);
}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Cliente.");}
}

public static void consultar(){
try{
Connection com = SQLConnection.getConnection();
Statement stat = com.createStatement();
String q = "select * from cliente;";
ResultSet rs = stat.executeQuery(q);
CrudTudoEmbutidoExercicio.janela.dispose();
JotaTable.JotaF();
while(rs.next()){
Cod_c = rs.getInt("codigo"); 	
Nome_c = rs.getString("nome");
Email_c = rs.getString("email");
Tel_c = rs.getString("telefone");
JotaTable.table_f(Cod_c, Nome_c, Email_c, Tel_c);

}

}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro ao consultar o banco dados.");}
}

}
class JotaTable{
static DefaultTableModel model = new DefaultTableModel();



public static void table_f(int codigo, String Nome, String email, String tel){
		String [] valor = {Integer.toString(codigo),Nome,email,tel};
		model.addRow(valor);
		
	}

	public static void JotaF(){
	model.addColumn("C�digo");
	model.addColumn("Nome");
	model.addColumn("E-mail");
	model.addColumn("Telefone");
	JTable tabela = new JTable(model);
	JFrame janela = new JFrame("Janela");
	janela.setVisible(true);
	janela.setSize(800, 600);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.add(new JScrollPane(tabela));
 
 }
	}


class SQLConnection { 
static final String DRIVER = "com.mysql.jdbc.Driver";
static final String URL_CON = "jdbc:mysql://127.0.0.1/treinaweb_crud?user=root&password=123456";
	
	public static Connection getConnection(){//Esse m�todo carrega a fun��o com o banco de dados, retornando um valor do tipo Connection.
		Connection com = null;
		try{ Class.forName(DRIVER); 
		com = DriverManager.getConnection(URL_CON); 
		}catch(Exception e){e.printStackTrace();}
		return com;
		
}   /*Esses tr�s m�todos abaixo, fecha a conex�o com Mysql em forma de overload. Primeiro se conter s� o objeto Connection, segundo se conter o connection e o statement
	� fechado o statemente e depois, � executado o m�todo para fechar o Connection, por ultimo se tiver o Connection, ResultSet, e Statement, � fechado o Resulset
	Depois executa a fun��o para fechar o Statement e por fim o Connection.*/
	
	public static void close(Connection com){try{if(com != null){com.close();}}catch(Exception e){e.printStackTrace();}}
	public static void close(Connection com, Statement stat){try{if(stat != null){stat.close();close(com);}}catch(Exception e){e.printStackTrace();}}
	public static void close(Connection com, Statement stat, ResultSet rs){try{if(rs != null){rs.close();close(com,stat);}}catch(Exception e){e.printStackTrace();}}
}



