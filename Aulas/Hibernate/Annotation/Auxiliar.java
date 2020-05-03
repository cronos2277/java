import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.query.Query;

@Entity
	@Table(name="AUXILIAR")
@NamedQuery(name="query_simples",query="from Auxiliar")
@NamedQuery(name="query_parametro",query="from Auxiliar where valor = :param")
	public class Auxiliar {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="auxiliar_id")
		public int codigo;
		
		@Column(name="valor")
		public String valor;
		
		/*
				
		@OneToOne //Aqui eh feito a anotacao 1-1, Explica nos comentarios da classe OneOne
		@Cascade(value = { CascadeType.ALL })
		@JoinColumn(name="id_onetoone") //Aqui eh definido a FK da relacao 1x1
		public OneOne oneone;
		
		*/
		
		/*
		//mappedBy eh o nome dado a instancia dessa entidade, na entidade alvo.
		@OneToMany(mappedBy="auxiliar",fetch=FetchType.LAZY) //Explicado abaixo.
		@Cascade(value = { CascadeType.ALL })	
		public Collection<ManyOneMany> list_manyonemany;		
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="manyonemany_id",updatable=true, insertable=true)
		@Fetch(FetchMode.JOIN)
		@Cascade(CascadeType.SAVE_UPDATE)
		public ManyOneMany manyonemany;
		
		*/
		
		/*
		@ManyToMany(fetch=FetchType.EAGER) //Anotacao para ManyToMany, explicado melhor na classe ManyMany
		@JoinTable(
				name="manymany_auxiliar", //O Nome da Tabela intermediaria 
				joinColumns=@JoinColumn(name="id_auxiliar"), //ID dessa entidade
				inverseJoinColumns=@JoinColumn(name="id_manymany"))	 //ID da outra entidade.
		@Cascade(CascadeType.ALL) 
		public Collection<Auxiliar> manymany;
		*/
		
		@Override
		public String toString() {
			return "Auxiliar [codigo=" + codigo + ", valor=" + valor + "]";
		}
		
		
		/*
		 * Sem a anotacao cascade, na insercao
		 * a entidade OneOne deve ser instanciada, a Entidade Auxiliar tambem, apos preencher
		 * todos os dados, a classe auxiliar dever ser passada ao atributo auxiliar,
		 * uma vez que tudo esteja pronto, se faz necessario quando for rodar a transacao
		 * executar o metodo "save" ou o "saveOrUpdate" em ambas as instancias antes de comitar.	 * 
		 * A atribuicao da instancia do OneOne, eh a que faz a marcacao do campo id_auxiliar
		 * com o primary da entidade.
		 *  @Cascade(value = { CascadeType.ALL }) com a cascade voce tem a sincronia entre as
		 *  entidades, ou seja no caso de uma anotacao onetoone por exemplo, qualquer uma das
		 *  duas que voce manda salvar, ja salva a outra, voce nao precisara fazer duas operacoes
		 *  de insercoes, isso funciona tambem com exclusao e atualizacao dependendo do tipo
		 *  de cascade que voce colocar em value. Aqui tambem temos o cascade no update:
		 *  @Cascade(CascadeType.SAVE_UPDATE) => Significa sincroniza na insercao e update e
		 *  nao exclua, caso o outro campo seja excluido.
		 *  
		 *  Fetch
		 *  fetch=FetchType.LAZY => (Padrao se omitido) Atualiza apenas os dados dessa entidade e das outras apenas 
		 *  quando for solicitado algum acesso aos dados das entidades anexadas a ela.
		 *  
		 *  fetch=FetchType.EAGER => Atualiza todas as entidades, tanto a entidade que esta sendo acessada,
		 *  assim como as que estao lincadas a elas, a cada atualizacao atualiza tudo.
		 *  
		 *  Por exemplo se existe duas Entidades a Entidades relacionadas A e B, no lazy se a A for atualizada,
		 *  a B so sera atualizada quando for tentar pegar os dados relacionados a B, ja no Eager
		 *  a atualizacao dos dados tanto de A e B ocorrem independente se o usuario so requisita a Entidade A.
		 *  
		 *  @Fetch: Aqui fiz como o hibernate deve trabalhar, quando for criar os relacionamentos entre as entidades{
		 *  SÓ FARA DIFERENCA ISSO SE A ENTIDADE TIVER ALGUM RELACIONAMENTO!
		 *  	Se Join = Isso significa que no banco de dados a consulta por dados deve ser feita utilizado Joins,
		 *  	por exemplo, quando for pegar dados no banco de dados as entidades devem usar Joins quando for
		 *  	pegar dados.
		 *  
		 *   	Se Select = Isso significa que o Hibernate deve usar o select, no caso, ao inves de usar Joins
		 *   	o banco de dados fara 2 ou mais selects para preencher os dados das Entidades, primeiro da entidade
		 *   	que esta requisitando dados e depois da(s) entidades relacionadas.
		 *   
		 *   	Se subselected = Ele usara de consultas aninhadas, ou seja ele usara o select, porem apenas 1 unico
		 *   	select e nao varios como o select (Pouco usual)
		 *   
		 *   	Isso pode melhorar o desempenho da aplicacao, uma vez que o acesso ao banco de dados excessivo pode
		 *   	representar um gargalo.
		 *  }
		 *  @NamedQuery => Aqui voce pode criar querys costumizaveis envolvendo essa entidade {
		 *  	Para usar uma query simples voce deve criar  uma instancia de Query, como nesse exemplo: 
		 *  			Query query = session.getNamedQuery("query_simples");
		 *  	Uma vez feito isso, voce pode resgatar o resultado, convertendo-o para uma lista, com o metodo list():
		 *  			List<Auxiliar>auxs = query.list();
		 *  	Ja nas query com parametros, voce precisaria, colocar o parametro, antes de converter para list e 
		 *  	depois de criar o objeto Query, assim sendo, ficaria: 
			 *  	Query query = session.getNamedQuery("query_parametro");
					query = query.setParameter("param", "a");
					List<Auxiliar>auxs = query.list();
				Isso eh claro usando os dois exemplos de NamedQuery criado aqui nessa entidade. No campo name
				voce deve colocar o nome da query, ao qual o metodo getNamedQuery vai usar, e no campo query
				voce deve colocar a query a ser executada. Esse pode ser uma otima forma de criar uma query
				customizada para essa entidade. Importante, as referencias deve ser da entidade e nao da tabela
				no banco de dados, por exemplo: from <SuaEntidade> where valor = :<parametro>", voce usa a 
				entidade no lugar da tabela e nos ":" voces informa(s) parametros que voce passara no metodo
				getNamedQuery, lembrando que todos os parametros devem ser substituidos antes de voce transformar
				a Query em List. 
		 *  }
		 * */
		
	}