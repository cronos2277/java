package pkg.entidade;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupo")
public class Grupo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private int codigo;
private String nome;
@ManyToMany(cascade = CascadeType.ALL) //Explicado mais abaixo.
@JoinTable(name="usergroup", joinColumns = @JoinColumn(name="grupo_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
private List<Usuario>usuario;
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
public List<Usuario> getUsuario() {
	return usuario;
}
public void setUsuario(List<Usuario> usuario) {
	this.usuario = usuario;
}
}
/*
*	@ManyToMany(cascade = CascadeType.ALL) -> Pense no cascade como uma trigger. Alí você define o que acontece na tabela ao qual
*o se exerce o relacionamento. No caso o cascade ali é ALL, mas tem "CascadeType.PERSIST" que na prática só altera a outra tabela ao qual
*está tem uma relação, quando inserido dados. "CascadeType.MERGE" quando editado, "CascadeType.REMOVE" ao deletar, etc... 
*/