package javapackage;
import java.sql.*;

import javax.swing.JOptionPane;
public class ClasseSQL {

static int codigo_sql;	
static String nome_sql;
static String email_sql;
static String tel_sql;

public static void CriarContato(String nomE, String emaiL, String telF){
Connection com = ConectarSQL.AbrirConexao();
try{	
	Statement st = com.createStatement();
	String query = "insert into cliente (nome,email,telefone) values ('"+nomE+"','"+emaiL+"','"+telF+"');";
	st.executeUpdate(query);
	JotaTable.limparTabela();
	ConsultarContato();
	}catch(Exception e ){JOptionPane.showMessageDialog(null, "Erro ao cadastar!");}
}
public static void DeletarContato(){
	Connection com = ConectarSQL.AbrirConexao();
	try{	
		Statement st = com.createStatement();
		String query = "delete from cliente where codigo = '"+Componentes.id+"';";
		st.executeUpdate(query);
		JotaTable.limparTabela();
		ConsultarContato();
		}catch(Exception e ){JOptionPane.showMessageDialog(null, "Erro ao deletar!");}
}

public static void ConsultarContato(){
	Connection com = ConectarSQL.AbrirConexao();
	try{	
		Statement st = com.createStatement();
		String query = "select * from cliente;";
		ResultSet rs = st.executeQuery(query);
		while(rs.next()){
		codigo_sql = rs.getInt("codigo");
		nome_sql = rs.getString("nome");
		email_sql = rs.getString("email");
		tel_sql = rs.getString("telefone");
		JotaTable.TableDados(codigo_sql, nome_sql, email_sql, tel_sql);
		}
		}catch(Exception e ){JOptionPane.showMessageDialog(null, "Erro ao consultar banco de dados!");}	
}
public static void EditarContato(){
	Connection com = ConectarSQL.AbrirConexao();
	try{
		Statement st = com.createStatement();
		String query_n = "update cliente set nome = '"+Componentes.Nome_new+"' where nome = '"+Componentes.Nome_old+"';";
		String query_e = "update cliente set email = '"+Componentes.Email_new+"' where email = '"+Componentes.Email_old+"';";
		String query_t = "update cliente set telefone = '"+Componentes.Tel_new+"' where telefone = '"+Componentes.Tel_old+"';";
		st.executeUpdate(query_n);
		st.executeUpdate(query_e);
		st.executeUpdate(query_t);
		ConectarSQL.FecharConexao(com, st);
		JotaTable.limparTabela();
		ConsultarContato();
	}catch(Exception e){e.printStackTrace();}
	}


}
