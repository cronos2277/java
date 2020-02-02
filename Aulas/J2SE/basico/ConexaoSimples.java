import java.sql.*;
public class ConexaoSimples{
	public static void main(String [] args){
		try{ Class.forName("com.mysql.jdbc.Driver"); //chamando o driver
	 String url = "jdbc:mysql://127.0.0.1/loja?user=root&password=123456"; 
	 //informando o local do banco de dados (jdbc:mysql://127.0.0.1/)
	 //Informando parametros(SeuBancoDeDados?user=Usu�rioAserConectado&password=SenhaDesseUsu�rio")
	 
		Connection com = DriverManager.getConnection(url); //comando para se conectar ao banco de dados usando a String url como par�metro.
		System.out.println("Conectado ao banco de dados "); //O que fazer quando se conectar ao banco de dados.
		}catch(Exception e){System.out.println("Erro ao conectar-se ao banco de dados!");}
	}
}