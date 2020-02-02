import java.sql.*;
public class ResultsetExercicioBasico{
	public static void main(String [] args){
	try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	String url = "jdbc:mysql://127.0.0.1/cliente?user=root&password=123456";
	Connection conexao = DriverManager.getConnection(url);
	Statement st = conexao.createStatement();
	String comando = "select nome from c_cli;";
	
	ResultSet rs = st.executeQuery(comando); //Dados ao ser passado para o ResultSet. No caso o resultSet recebe, 
	//o retorno do comando where. Para comandos com retorno, � recomend�vel o uso do m�todo .executeQuery(String com o comando).
	
	if(rs.next()){ //Desvio if. Aqui � executado, at� encontrar um campo nulo, lembrando que o resultset, s� funciona dentro de try{}catch.
    String exibir = rs.getString("nome"); //A get .getString("String com o valor do nome do campo, referente no banco de dados"). convertendo
    //o retorno do resultset em uma String.
    
    System.out.println(exibir);
    }
	}catch(Exception e){System.out.println("Erro!");}		
	
	}
}