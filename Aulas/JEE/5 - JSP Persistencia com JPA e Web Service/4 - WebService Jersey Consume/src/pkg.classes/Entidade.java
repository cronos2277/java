package pkg.classes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CLIENTE")
public class Entidade {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
@Column(nullable=false)
private Long id;	
private String nome;
private String login;
private String senha;

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
public void setId(Long id){
	this.id = id;
}
public Long getId(){
	return id;
}
}
