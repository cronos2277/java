package javapackage;
import java.sql.*;
import javax.swing.*;
public class ConectarSQL {
public static final String DRIVER = "com.mysql.jdbc.Driver";
public static final String URL_COM = "jdbc:mysql://localhost:3306/treinaweb_crud?user=root&password=123456";

public static Connection AbrirConexao(){
	Connection com = null;
	try{
		Class.forName(DRIVER).newInstance();
		com = DriverManager.getConnection(URL_COM);
		 }catch(Exception e){JOptionPane.showMessageDialog(null,"Erro ao se conectar ao Banco de dados");}
	return com;
}
public static void FecharConexao(Connection com){
	try{com.close();}catch(Exception e){JOptionPane.showMessageDialog(null,"Erro ao fechar conex�o com banco de dados!");}
}
public static void FecharConexao(Connection com, Statement st){
try{st.close();
}catch(Exception e){JOptionPane.showMessageDialog(null,"Erro ao fechar conex�o com Statement!");}
}
public static void FecharConexao(Connection com, Statement st,ResultSet rs){
try{rs.close();
}catch(Exception e){JOptionPane.showMessageDialog(null,"Erro ao fechar conex�o com ResultSet!");}
}

}
