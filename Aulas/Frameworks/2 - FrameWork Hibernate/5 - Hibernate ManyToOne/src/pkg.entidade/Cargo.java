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
*	Em geral � o OneToMany, que recebe mais argumentos. Aqui um cargo pode ter v�rias pessoas, o que 
no caso explica o Set de pessoas abaixo. O Set tem o mesmo uso que o List, mas com a diferen�a de que
o mesmo � baseado na estrutura do HashSet e n�o no ArrayList, com � o List<Classe>.
*	@OneToMany(mappedBy="String"). O mappedBy, ele recebe como par�metro a classe instanciada, na entidade
ao qual ele se referencia. Analise a outra entidade, voc� vai pereber que existe um objeto do tipo Cargo l�
esse objeto faz referencia a esta entidade, e � justamente isso que o mappedBy aceita como par�metro.

*	@OneToMany(targetEntity= ArquivoDeClasse.class). Al� informa a entidade que est� sendo usado como alvo.
no caso voc� informa a classe, aonde a entidade est� contida. Isso � interessante, em casos que voc� tem 
mais de uma classe em um arquivo jar, ou melhor mais de uma entidade. N�o � obrigat�rio o seu uso, mas 
o seu uso facilita.

*	@OneToMany(fetch = "ENUM"). Este campo se refere a forma, que ser� feita a conex�o com os dados. Existe
dois valores que s�o aceitos neste campo do fetch. "fetch = FetchType.EAGLE". Aqui os dados associados s�o,
carregados em conjunto com a entidade. Ou seja, todos os dados da entidade Cargo, s�o carregados quando a 
entidade pessoa requisita qualquer dado referente a esta entidade. Uma vez que um dado dela seja carregado
a entidade inteira � carregada. Isso n�o � muito interessante em entidades com muitos dados, mas � em entidades pequenas.
"fetch = fetchType.LAZY"(� o padr�o, quando este campo � omitido), aqui os dados s�o carregados, quando requeridos
no entanto se faz necess�rio que a Session esteja aberta.
* 	@OneToMany(cascade = cascade.ALL) -> J� foi explicado.
* 	Agora repare que existe um Set<Pessoa> chamado pessoas. Este � uma interface, que � implementada no HashSet<>. 
recomenda-se o seu uso, ao inv�s da interface List<>. e do objeto do tipo ArrayList<>.
*/