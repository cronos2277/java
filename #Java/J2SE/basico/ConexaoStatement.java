import java.sql.*;
import java.util.Scanner;
public class ConexaoStatement{
	public static void main(String [] args){
		String comando;
		Scanner entra = new Scanner(System.in);
		System.out.println("D�gite um nome para colocar no Banco de dados: ");
		comando = entra.nextLine();
		try{ Class.forName("com.mysql.jdbc.Driver"); 
	String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=123456"; 
	Connection com = DriverManager.getConnection(url); 
	Statement st = com.createStatement(); //criando e passando valor para o Statement.
	String q; //Essa String ira enviar comando para o mysql.
	q = "insert into categoria(nome) values('"+comando+"')";
	st.executeUpdate(q); //Aqui o Objeto Statement envia o conte�do da String para o banco de dados.
	System.out.println("Dados escritos com sucesso no banco de dados."); 
		}catch(Exception e){System.out.println("Erro ao conectar-se ao banco de dados!");}
	}
}