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
@Table(name="usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="cod")
private int codigo;
private String nome;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name="usergroup", joinColumns = @JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
private List<Grupo>grupos;
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
public List<Grupo> getGrupos() {
	return grupos;
}
public void setGrupos(List<Grupo> grupos) {
	this.grupos = grupos;
}
}
/*
*	@JoinTable() -> Aqui uma tabela é criada automaticamente. No caso essa tabela criada aqui, é tratada na classe de relacionamento.
*joinColumns = @JoinColumn(name="String) -> Aqui é criada uma tabela, cuja a coluna definida como String, se refere a esta ID. Esta dessa entidade.
*inverseJoinColumns =@JoinColumn se refere a tabela, ao qual esta entidade possui um relacionamento. 
*/