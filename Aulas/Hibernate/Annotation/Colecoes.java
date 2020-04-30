/*
 * Novamente a classe estara com atributos publicos, 
 * justamente para a reducao de linhas codigos, 
 * getter e setter ocupam muitas linhas.
 */ 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.MapKeyType;

@Entity
//Tambem eh possivel definir aqui o esquema ao qual a tabela pertence, no caso estamos usando o Public do PostGres
@Table(name="Principal",schema="Public") 
public class Colecoes {
	@Id
	/*
	  "GeneratedValue" = "strategy"
  			"strategy = GenerationType.SEQUENCE" => A criacao de ID fica sob responsabilidade do Banco de dados. (Faz usando Trigger).
  			"strategy = GenerationType.IDENTITY" => A criacao de ID fica sob responsabilidade do Banco de dados. (Usa uma coluna de identidade)		
  			"strategy = GenerationType.AUTO" => Deixa com o provedor de persistência a escolha da estratégia mais adequada de acordo com o banco de dados.
  			"strategy = GenerationType.TABLE" => Usa uma tabela para gerar um novo ID, apenas use se tiver um bom motivo.
 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int codigo;	
	@ElementCollection //Detalhe muito importante, essa anotacao apenas funciona para os tipos simples ou embutido, nao eh possivel usar com outra entidade.
	/*
	 * Apenas colocando a anotacao "@ElementCollection", o hibernate criara uma tabela no banco de dados 1 para N, sendo essa lista o N dessa anotacao. 
	 * Essa eh a sintaxe basica para a acriacao de uma relacao 1 - N, sendo esse atributo o lado N do relacionamento, mas com apenas essa anotacao,
	 * o nome dessa tabela sera: "NomeDaClasse_NomeDoAtributo", com o id "NomeDaClasse_NomeDoAtributoID, nesse caso ficaria "Composto_lista_automatica"
	 * contendo como id Composto_codigo que estara dentro dessa tabela. Detalhe como aqui nao tem nenhuma anotacao, ela pegara o nome da entidade e do atributo
	 * com base na classe e nao com base nas anotacoes. Essa seria a sintaxe minima para voce criar um atributo desses. Por fim tambem eh criado um 
	 * constraint entre a chave primaria da tabela criada com base nesse atributo e como chave estrangeira o ID da Entidade ao qual ela compoe. Essa
	 * estrategia so funciona com Classes Wrapper, ou seja: String, Double, Integer, etc... Resumindo com as classes referente a volares primitivos.	 
	 */
	//SET
	public Set<String> lista_automatica; //Aqui temos um exemplo do uso @ElementCollection com uma classe Wrapper.	
	
	@ElementCollection
	//com o @JoinTable voce conseque criar uma nova tabela apenas no banco de dado.
	@JoinTable(name="numeros",joinColumns= {@JoinColumn(name="fkComposto")}) //Definimos aqui o nome da tabela e da FK.
	@Column(name="numero") //Aqui definmos o nome do campo na tabela numeros.	
	@OrderColumn(name="numero_id") //Aqui se cria o ID, no name voce coloca o nome que o ID tera na tabela numeros.
	//LIST
	public List<Long> numeros_listas;	//Essa tabela tem uma chave composta, com base no ID dela mesma e no FK.
	
	@ElementCollection
	@JoinTable(name="bag",joinColumns= {@JoinColumn(name="fkBag")}) //Definido a tabela
	@SequenceGenerator(name="sequencia", sequenceName="nome_da_sequencia_banco_dados") //Aqui cria a sequencia para a Bag
	@CollectionId(columns=@Column(name="idBag"), generator = "sequencia", type = @Type(type = "integer")) //Explicado abaixo.
	//Estrutura BAG (Um List com ID gerado por uma sequencia independente)
	public List<String> bagValue;
	
	
	@ElementCollection
	@JoinTable(name="mapa",joinColumns= {@JoinColumn(name="mapa_fk")}) //Criando Chave Estrangeira
	@MapKeyType(value = @Type(type = "integer")) //Aqui definimos o tipo da chave.
	@Column(name="mapa_value") //Aqui define o nome do atributo ao qual recebera o valor desse MAP.
	//Uma Colection Usando um MAP.
	public Map<Integer,String> mapa; //Eh criado um nome do artibuto_key para representar a chave desse MAP no BD, ficando: mapa_key.
	
	//Construtor, as listas precisam ser inicializadas primeiro para depois comecar a funcionar, do contrario: NullPointerException
	public Colecoes() {
		this.lista_automatica = new HashSet<String>(); //Inicializando o Set
		this.numeros_listas = new ArrayList<Long>(); //Inicializando o List
		this.bagValue = new ArrayList<String>(); //Inicializando o List(Bag)
		this.mapa = new HashMap<Integer,String>(); //Inicializando o Map.
	}
		
}
/*
 * 	@JoinTable => Cria uma tabela intermediaria no banco de dados {
 * 		name="NOME_DA_TABELA" => Dentro desse contexto, o valor aqui sera correspondente ao nome da tabela.
 * 		joinColumns=@JoinColumn(name="idComposto")) => Nesse "name" voce define o nome da chave estrangeira que 
 * 		estara relacionada ao ID da classe que a contem. * 
 * 		@Column => Dentro desse contexto, voce definira o nome do atributo no banco de dados
 * Assim sendo temos:
 * 		* Sera criado uma nova tabela, essa tabela se chamara "numero".
 * 		* Essa tabela tera uma chave estrangeira, o nome dessa chave sera idComposto, ao qual se relacionara com o ID da classe.
 * 		* Os atributos estaram contidos da linha numero da tabela numeros.
 * 	}
 * 	@OrderColumn => Cria um campo para ordernar os dados, no caso um ID, no atributo name voce define o nome que o ID tera na tabela intermediaria.
 * No SET nao se faz necessario, uma vez que essa lista evita duplicacoes, mas caso voce use o List, seria muito interessante ter um ID associado,
 * uma vez que permite repeticoes, lembrando que sem esse atributo, sem ID na tabela.
 * 
 * @CollectionId => {
 * 		Essa estrutura cria uma Bag, ou seja um List que tem um ID criado atraves de uma sequencia, para isso algumas coisas deve ser observadas:
 * 		"columns" => Cria a coluna que sera gerado o ID, @Column(name="idBag"), aonde esta o idBag deve ser trocado pelo nome do ID na tabela.
 * 		"generator" => Aqui voce informa o nome da sequencia, no caso deve bater com o atributo name do decorador SequenceGenerator.
 * 		"type" => Aqui voce pode definir o tipo de dados com que a sequencia trabalha, @Type(type = "integer") substua o integer pelo tipo de dado requerido,
 * 		como por exemplo: string, integer, double, boolean, float,  etc.. Lembre-se o Java eh sensitive case entao informe o tipo em lowercase.
 * }
 * */

