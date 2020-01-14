package hibernate;
public class Pessoas {

private int Id;
private String nome;
private String login;
private String senha;
private String registrado;
public int getId() {
	return Id;
}
public void setId(int id) {
	this.Id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getRegistrado() {
	return registrado;
}
public void setRegistrado(String registrado) {
	this.registrado = registrado;
}
}