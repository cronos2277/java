package pkg.entidade;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String cargo;
@OneToMany(mappedBy = "cargoInstanciado", targetEntity = Pessoa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Pessoa> pessoas;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
public Set<Pessoa> getPessoas() {
	return pessoas;
}
public void setPessoas(Set<Pessoa> pessoas) {
	this.pessoas = pessoas;
}
}
/*
*	Em geral é o OneToMany, que recebe mais argumentos. Aqui um cargo pode ter várias pessoas, o que 
no caso explica o Set de pessoas abaixo. O Set tem o mesmo uso que o List, mas com a diferença de que
o mesmo é baseado na estrutura do HashSet e não no ArrayList, com é o List<Classe>.
*	@OneToMany(mappedBy="String"). O mappedBy, ele recebe como parâmetro a classe instanciada, na entidade
ao qual ele se referencia. Analise a outra entidade, você vai pereber que existe um objeto do tipo Cargo lá
esse objeto faz referencia a esta entidade, e é justamente isso que o mappedBy aceita como parâmetro.

*	@OneToMany(targetEntity= ArquivoDeClasse.class). Alí informa a entidade que está sendo usado como alvo.
no caso você informa a classe, aonde a entidade está contida. Isso é interessante, em casos que você tem 
mais de uma classe em um arquivo jar, ou melhor mais de uma entidade. Não é obrigatório o seu uso, mas 
o seu uso facilita.

*	@OneToMany(fetch = "ENUM"). Este campo se refere a forma, que será feita a conexão com os dados. Existe
dois valores que são aceitos neste campo do fetch. "fetch = FetchType.EAGLE". Aqui os dados associados são,
carregados em conjunto com a entidade. Ou seja, todos os dados da entidade Cargo, são carregados quando a 
entidade pessoa requisita qualquer dado referente a esta entidade. Uma vez que um dado dela seja carregado
a entidade inteira é carregada. Isso não é muito interessante em entidades com muitos dados, mas é em entidades pequenas.
"fetch = fetchType.LAZY"(é o padrão, quando este campo é omitido), aqui os dados são carregados, quando requeridos
no entanto se faz necessário que a Session esteja aberta.
* 	@OneToMany(cascade = cascade.ALL) -> Já foi explicado.
* 	Agora repare que existe um Set<Pessoa> chamado pessoas. Este é uma interface, que é implementada no HashSet<>. 
recomenda-se o seu uso, ao invés da interface List<>. e do objeto do tipo ArrayList<>.
*/