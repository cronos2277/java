package pkg.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="cliente_id", nullable=false)
private int id;
@Column(name="cliente_nome", nullable=false) //Explicado abaixo.
private String nome;
@Column(name="cliente_cadastro", nullable=false)
@Temporal(value = TemporalType.TIMESTAMP) //Explicado mais abaixo.
private Date cadastro;
@OneToOne(cascade=CascadeType.ALL) //Explicado em outra classe.
private Login login;
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
public Date getCadastro() {
	return cadastro;
}
public void setCadastro(Date cadastro) {
	this.cadastro = cadastro;
}
public Login getLogin() {
	return login;
}
public void setLogin(Login login) {
	this.login = login;
}
}
/*
*	A vantagem do @Column é clara, ele permite que você crie as colunas no banco de dados com
os atributos. Deixando o nullable em false, você está dando um atributo "not null", neste campo. 
o valor de name, refere-se ao nome da coluna no banco de dados.

*	@Temporal,é a formatação de dados do tipo Date. Existe três opções para essa anotação, sendo elas:
@Temporal(value = TemporalType.DATA), ele aceita apenas a data, por exemplo: 2015/03/14 por padrão -> Ano/Mês/Dia, podendo ser alterado.
@Temporal(value = TemporalType.TIME), ele aceita apenas a hora, por exemplo: "08:30:24" por padrão -> "Hora:Minutos:segundos"
@Temporal(value = TemporalType.TIMESTAMP), aqui ele aceita tanto a data quando a hora, por exemplo: 2015/03/14:08:30:24. Formato padrão do Java. 
*/