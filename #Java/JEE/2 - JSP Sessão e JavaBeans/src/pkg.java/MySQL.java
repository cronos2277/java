package pkg.java;
import java.sql.*;
import java.util.HashMap;
public class MySQL {
public static String Status = ""; 

public static HashMap<String,String> BancoD = new HashMap<String,String>();
public Connection Conexao (Connection Con){ //Criando conexão com o banco de dados.
	try{
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	 String url = "jdbc:mysql://127.0.0.1/java_ee?user=root&password=123456";
	Con = DriverManager.getConnection(url);	
	}catch(Exception e){Status = "Erro na conexão com o banco de dados!";}
	return Con;
}

public Statement Conexao (Connection con, Statement st){ //Criando o Statement
	con = this.Conexao(con);
	try{
	st = con.createStatement();
	Status = "Conectado ao banco de dados com sucesso.";
	}catch(Exception e){Status = "Erro na criação do Statement!";}
	return st;
}
//Aqui o método consulta retorna um booleano. Bom isso facilita as coisas,
//se o servlet se conectou e achou determinado usuário e senha retorna true,
//em qualquer outro caso, um False.
public boolean Consulta (String login, String password){ //Use esse m�todo quando for consultar no Mysql.
	boolean status = false;
	try{ 
	Connection Con = null;Statement St = null;
	Con = this.Conexao(Con); 
	St = (this.Conexao(Con, St));
	ResultSet rs = St.executeQuery("select * from Java");
	while(rs.next()){
	BancoD.put(rs.getString("login"), rs.getString("senha"));}
	if(BancoD.get(login).equals(password)){status = true;}else{Status = "Senha incorreta!";}
	return status;
	}catch(Exception e){Status = "Usuário inexistente!";return status;}
	
}

//Aqui é feito o cadastro, o método Cadastro também retorna um boolean.
//Muito simples, se o cadastro foi feito no SGBD, retorna um true, qualquer outro
//caso, seja por problema de cliente ou servidor, o mesmo retorna falso.
public boolean Cadastro(String nome, String login, String senha){
	boolean c;
	try{
	Connection Con = null;
	Statement St = null;
	Con = this.Conexao(Con);
	St = this.Conexao(Con, St);
	String sql = "insert into Java (nome, login, senha) values('"+nome+"','"+login+"', '"+senha+"');";
	St.execute(sql);
	return c = true;
	}catch(Exception e){Status= "Erro ao criar o cadastro!";return c = false;}
}

}//Fim da Classe.
