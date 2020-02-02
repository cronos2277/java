package br.com.treinaweb.javaee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
  public Usuario verificar(Usuario usuario){
    String q = "";
    q += " select idusuarios from usuarios ";
    q += " where login= '" + usuario.getLogin() + "' ";
    q += " and senha= '" + usuario.getSenha() + "' ";
    Connection con = Conexao.getConnection();
    try{
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(q);
      if(rs.next()){
        usuario.setIdUsuarios(rs.getInt("idusuarios"));
      }
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }
    return usuario;
  }

  public boolean salvar(Usuario usuario){
    try{
      Connection con = Conexao.getConnection();
      Statement st = con.createStatement();
      String q = "";
      q += " insert into usuarios (nome,login,senha) ";
      q += " values ('" + usuario.getNome() + "',";
      q += "'" + usuario.getLogin() + "',";
      q += "'" + usuario.getSenha() + "')";
      int rows = st.executeUpdate(q);
      if(rows > 0)
        return true;
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return false;
  }
}