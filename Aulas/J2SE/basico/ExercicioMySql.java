import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class ExercicioMySql{
	public static void main(String [] args){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection com;
		String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=senhadoroot";
		com = DriverManager.getConnection(url);
		JOptionPane.showMessageDialog(null, "Conectado ao Banco de dados");
		}catch(Exception e){JOptionPane.showMessageDialog(null, "Erro ao conectar-se ao banco de dados");}
	}
}