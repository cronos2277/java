package br.treinaweb.javaee;

public class Javabeans_PT {
private String nome;
private String login;
private String senha;
private String generico;
private int id;
private Object enviar;

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
public Object getEnviar() {
	return enviar;
}
public void setEnviar(Object enviar) {
	this.enviar = enviar;
}
public String getGenerico() {
	return generico;
}
public void setGenerico(String generico) {
	this.generico = generico;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = Math.abs(id);
	
}
}
