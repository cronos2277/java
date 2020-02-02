package pkg.java;

public class JavaBeans {
private String login;
private String senha;
private String nome;
private Object Enviar;
public static String user = null;
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
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Object getEnviar() {
	return Enviar;
}
public void setEnviar(Object enviar) {
	Enviar = enviar;
}

	
}
// Em um JavaBeans, como é o caso dessa classe, todos os atributos de uma
// classe devem ser privados, acessados por um getter e um setter. Isso é
// uma padronização do Java Beans, caso não seja respeitado isso a página
//pode apresentar erros.