import java.sql.*;
public class ConexaoMySqlBasico {

	public static void main(String[] args) {
	try{	
		Class.forName("com.mysql.jdbc.Driver").newInstance(); //Aqui é carregado o driver.
		Connection con; //Aqui é criado uma variável do tipo Connection, para ser usada na conexão.
		String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=senhadoroot"; //Aqui é a String contendo todos os dados para a conexão.
		con = DriverManager.getConnection(url); //Aqui o Connection se conecta ao banco de dados usando como parametro uma String.
	     System.out.println("Conexão Aberta!"); //Mensagem exibida quando tem sucesso na conexão.
	}catch(Exception e){System.out.println("Erro ao conectar ao mysql");} //em Caso de Fracasso.
	}

}