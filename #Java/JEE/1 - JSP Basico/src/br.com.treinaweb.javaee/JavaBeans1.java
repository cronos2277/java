package br.com.treinaweb.javaee;

public class JavaBeans1 {
ClasseMysql sql = new ClasseMysql();	
private String nome;
private String login;
private String senha;
private String status = "Javabeans";

public String getStatus(){
	return this.status;
}
public String getNome(){
	return this.nome;
}
public String getLogin(){
	return this.login;
}
public String getSenha(){
	return this.senha;
}
public void setStatus(String status){
	this.status = status;
}
public void setNome(String nome){
	this.nome = nome;
}
public void setLogin(String login){
	this.login = login;
}
public void setSenha(String senha){
	this.senha = senha;
}
public void Registro(){
	boolean Booleano = false;
	Booleano = sql.Cadastro(this.nome,this.login,this.senha);
	if(Booleano){this.status = "Cliente Cadastrado";}else{this.status = ClasseMysql.Status;}
}
}
