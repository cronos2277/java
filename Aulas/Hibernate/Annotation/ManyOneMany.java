import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="manyonemany")
public class ManyOneMany {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="manyonemany_id")
	public int id;
	
	@Column(name="valor")
	public String valor;	
	
	//Aqui temos uma colecao de Auxiliares.
	@OneToMany(mappedBy="manyonemany",fetch=FetchType.LAZY) //O tipo de Fetch eh opcional 
	@Cascade(value = { CascadeType.ALL }) //Tipo de cascata
	public Collection<Auxiliar> list_auxilires; //O lado one da relacao fica com uma colecao da entidade alvo
	
	//Aqui temos uma instancia de Auxiliar, que tera muitas Instancia dessa classe.
	@ManyToOne(fetch=FetchType.EAGER) //O Fetch eh opcional.
	@JoinColumn(name="auxiliar_id",updatable=true, insertable=true) //Opcional
	@Fetch(FetchMode.JOIN) //Tipo do fetch, aqui define como o hibernate trabalhara (Opcional).
	@Cascade(CascadeType.SAVE_UPDATE) //Tipo de cascata.
	public Auxiliar auxiliar; //O Lado Many tem apenas uma instancia simples mesmo.
	
	//Obs: Fetch e Cascade estao explicado na Auxiliar.java
	
	/*
	 * @OneToMany(mappedBy="manyonemany") => {
	 * 		O mappedBy faz referencia a instancia dessa entidade, na entidade alvo (Sim a classe alvo deve ter uma instancia).
	 * 		O Hibernate ira procurar na entidade alvo, que tambem devera estar devidamente anotada,
	 * 		essa instancia, e sera essa instancia que sera o elo da relacao entre essas duas entidades.
	 * 		A classe alvo tera uma instancia, no caso a classe que estiver com a anotacao @ManyToOne da relacao.
	 * 		Resumindo voce tera uma collection e o elo de ligacao entre a classe alvo e essa classe, sera a collection,
	 * 		e o caminho inverso, que seria da classe alvo com essa se dara pela instancia devidamente sinalizada no "mappedBy".
	 * 		Lembre-se o lado que recebera a anotacao @One, tera muitas instancia da outra entidade, logo essa sera a que usara
	 * 		alguma colecao, ou alguma filha da classe Collection (Set, List, etc...), na relacao 1 para N, essa anotacao lida
	 * 		com o lado 1 da historia.
	 * }
	 * 
	 * 	@ManyToOne =>{
	 * 		Essa eh a entidade cuja a entidade alvo tem uma colecao dela, em uma relacao 1 para N, essa aqui seria o lado N.
	 * 		A anotacao eh feita pelo lado 1 da historia, entao a anotacao eh o suficiente, exceto que queira mais ajustes.
	 * 		Diferente da outra anotacao, essa deve ter uma instancia da classe com o exato mesmo nome que esta no mappedBy
	 * 		da entidade que tem a outra anotacao.
	 * }
	 * 
	 * @JoinColumn(name="auxiliar_id",updatable=true, insertable=true) => {
	 * 		Aqui caso voce queira ter mais controle sobre o fk gerado pelo hibernate. O name, eh o nome da chave estrangeira,
	 * 		e os valores subsequentes, significa as alteracoes que voce pode fazer do seu lado da relacao.
	 * 		No caso essa entidade vai pode inserir e atualizar dados na entidade forte.
	 *  }
	 * */
}
