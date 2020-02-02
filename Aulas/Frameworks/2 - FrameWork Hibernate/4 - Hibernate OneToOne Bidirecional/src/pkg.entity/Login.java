package pkg.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "login_id",nullable=false)
private int id;
@Column(name="login_user", nullable=false) //Explicado em outra classe.
private String user;
@Column(name="login_pass", nullable=false)
private String pass;
@OneToOne(cascade = CascadeType.ALL) //Explicado abaixo.
private Cliente cliente;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPass() {
	return pass;
}
public void setPass(String password) {
	this.pass = password;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}	
}
/*
*	Temos uma relação de um para um. Neste caso um cliente contem um login e um login contem um cliente.
Uma relação dessa não é muito recomendado. Você pode cadastar um um login tanto escrevendo ele dentro do
objeto instanciado dentro da classe cliente, como o processo inverso também é permitido. Ou seja Instancia
objeto do tipo cliente dentro de um Login depois escreva dentro do objeto instanciado, contido dentro de login. 
Ambos os objetos instanciados devem ser privados.A unica diferença do bidirecional para o onedirecional é que no
bi você pode fazer via as duas entidades. Vale lembrar que existe duas chaves estrangeira no banco de dados, uma para
cada relacionamento.
*/