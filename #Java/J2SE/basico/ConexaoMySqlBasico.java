import java.sql.*;
public class ConexaoMySqlBasico {

	public static void main(String[] args) {
	try{	
		Class.forName("com.mysql.jdbc.Driver").newInstance(); //Aqui � carregado o driver.
		Connection con; //Aqui � criado uma vari�vel do tipo Connection, para ser usada na conex�o.
		String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=senhadoroot"; //Aqui � a String contendo todos os dados para a conex�o.
		con = DriverManager.getConnection(url); //Aqui o Connection se conecta ao banco de dados usando como parametro uma String.
	     System.out.println("Conex�o Aberta!"); //Mensagem exibida quando tem sucesso na conex�o.
	}catch(Exception e){System.out.println("Erro ao conectar ao mysql");} //em Caso de Fracasso.
	}

}