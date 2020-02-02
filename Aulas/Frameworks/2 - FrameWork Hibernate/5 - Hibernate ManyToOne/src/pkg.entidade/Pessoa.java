package pkg.entidade;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int codigo;
private String nome;
@ManyToOne 
@JoinColumn(name="codCargo") //Explicado mais abaixo.
private Cargo cargoInstanciado; //Este objeto aqui é o parâmetro do @OneToMany(mappedBy="")
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Cargo getCargoInstanciado() {
	return cargoInstanciado;
}
public void setCargoInstanciado(Cargo cargoInstanciado) {
	this.cargoInstanciado = cargoInstanciado;
}
}
/*
@JoinColumn(name="String"). Esta coluna é usada como referencia, para com a entidade Cargo.
Nesta coluna, que será criada o codCargo, nela conterá o valor correspondente da relação entre
esta entidade e a entidade Cargo. Por exemplo: Pessoa (1,"fulano") estará relacionado com o (3,"cargox").
No caso a pessoa 1 está relacionada com o cargo 3 da tabela. Quem vai fazer este relacionamento é este JoinColumn().
Ou seja é essa coluna que está ali, vai fazer o relacionamento entre o valor de uma entidade com o valor de outra.

*/