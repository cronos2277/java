package pkg;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="struts_hibernate")
public class Entidade {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(nullable=false)
private int id;
@Column(name="name", nullable=false)
private String nome;
@Column(name="user", nullable=false)
private String login;
@Column(name="pass", nullable=false)
private String senha;
@Column(name="function", nullable=false)
private String cargo;
@Column(name="genre", nullable=false)
private String genero;
public Entidade(){}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}

}
