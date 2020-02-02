package br.com.treinaweb.javaee;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
  public static String status = "";
  public static Connection getConnection(){
	    Connection con = null;
	    try{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String url = "jdbc:mysql://127.0.0.1/java_ee?user=root&password=123456";
	      con = DriverManager.getConnection(url);
	      status = "Conex�o Aberta!";
	    }catch(SQLException e){
	      status = e.getMessage();
	    }catch (ClassNotFoundException e){
	      status =e.getMessage();
	    }catch (Exception e){
	      status = e.getMessage();
	    }
	    return con;
	  }
	}