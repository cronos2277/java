import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="manymany")
public class ManyMany {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="manymany_id")
	public int id;
	
	@Column(name="valor")
	public String valor;
	
	//A Anotacao ManyToMany eh obrigatoria para essa relacao, mas os atributos nao.
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL) 
	@JoinTable( //Opcional, Aqui definiremos as configuracoes da tabela intermediaria.
			name="manymany_auxiliar", //Nome da tabela intermediaria.
			joinColumns=@JoinColumn(name="id_manymany"),  //Configuracao desse ID na tabela intermediaria.
			inverseJoinColumns=@JoinColumn(name="id_auxiliar"))	 //Configuracao do ID da outra tabela na intermediaria.
	public Collection<Auxiliar> auxiliares; //N para N exige uma colecao nas duas pontas.
}
/* @ManyToMany => Essa eh a anotacao de muitos para muitos. Fetch e cascade explicado melhor no Auxiliar.
 * @JoinTable => { Essa anotacao criara a tabela intermediaria, se omitido, usa os nomes padroes.
 * 		"name" => indica o nome da tabela intermediaria.
 * 		"joinColumns=@JoinColumn("coluna1")" => Aqui voce estipula o id da tabela intermediaria, do seu lado da relacao.
 * 		"inverseJoinColumns=@JoinColumn(name="id_auxiliar")" => Aqui voce estipula o ID do outro lado da relacao.
 * 
 *  	@JoinTable usa uma tabela que apenas não mapeada e apenas existe no banco de dados. Ou seja essa solucao
 *  pode ser interessante, caso voce queira uma tabela intermediaria que tenha apenas o ID dessa tabela e o ID
 *  da outra tabela, mas se quiser uma tabela mais complexa como intermediaria, voce pode colocar no atributo name
 *  o nome da tabela no banco de dados e ai criar uma entidade que aponte para essa tabela em questao.  
 *  
 *  Seja cauteloso, essa mesma anotacao pode servir para as duas pontas da relacao, mas o joinColumns e o inverseJoinColumns
 *  deve estar dentro do contexto correto. joinColumns se refere a essa entidade aqui, no caso ao ID(s) dessa entidade aqui.
 *  O inverseJoinColunms o ID da outra entidade, quando for configurado a outra entidade as referencias devem ser invertidas
 *  uma vez que a inversaJoinColumns da outra se refere aqui e a JoinColumns la, esse campo eh opcional, se omitido
 *  sera criada uma tabela com o nome das duas tabelas que as entidades se referem e serao criados dois campos com
 *  o nome das ID, ambas sendo chave primaria e estrangeira nessa tabela intermediaria. 
 *  }
 * 
 * */
 