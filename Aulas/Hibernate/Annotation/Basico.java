package Runner;

//Voce pode importar as bibliotecas do org.hibernate, mas ai a sua aplicacao fica preso a essa tecnologia.
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
//import javax.persistence.GenerationType; //USE SE PRECISAR

@Entity //Toda a Entidade deve ter essa anotacao. (Obrigatorio).
/*
 * Essa anotacao Table serve caso voce queira que o nome da tabela no BD 
 * seja diferente diferente da Entity, nesse caso a Classe 'Basico'
 * esta relacionada a Table "Tabela" la no banco de dados. 
 * */
@Table(name="Tabela") //(Opcional)
public class Basico {
	/*
	 * @Column funciona como a Table, mas a nivel de atributo. No caso,
	 * essa anotacao pode ser util caso voce queira definir o comportamento
	 * do atributo na tabela ou caso voce queira que o atributo tenha um nome
	 * diferente la na tabela, inclusive voce pode ou nao usa-lo no ID, no
	 * caso se voce quise mudar alguma coisa no ID, voce pode usar o colunm 
	 * tambem para isso, ou para alterar um atributo qualquer no Banco de dados
	 * */
	
	@Column //Identifica o atributo (Opcional). 
	public String str;
	
	@Id //Com essa anotacao, que eh identificado um ID (Obrigatorio).
	@SequenceGenerator(name="sequencia", sequenceName="nome_no_banco_de_dados")
	@GeneratedValue(generator="sequencia") //Dessa forma a aplicacao cria as id.
	//@GeneratedValue(strategy = GenerationType.AUTO) //Estrategia para criacao de ID, seque a mesma logica que o XML.
	@Column(name="codigo", nullable=false, length=40, unique=true) 
	public int id;	// nullable=false e unique=true eh o padrao dos IDs e falso para qualquer outro campo por padrao.

	@Transient //Essa anotacao avisa que esse campo nao deve estar no banco de dados.
	public boolean transiente;
	
	@Column(length=80, precision=2) //Precision = 2, significa que o numero podera ter 2 algorismos apos a virgula.
	public double valor;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP) //TimeStamp eh a data com: dia, mes, ano, hora, minuto, segundos.
	public Date data;

	@Override
	public String toString() {
		return "Basico [str=" + str + ", id=" + id + ", transiente=" + transiente + ", valor=" + valor + ", data="
				+ data + "]";
	}
	
	public Basico() {
		this.data = new Date();
		this.transiente = true;
		this.valor = 123.54;
		this.str = "TEXTO";
	}
}

/*
 * "name" => Aonde estiver name significa que voce quer que no banco de dados o nome seja diferente. 
 * "nullable" => Significa que aceita valores nulos se for "true", ou será um campo not null no Banco de dados se for "false".
 * "length" => O Tamanho no campo la no banco de dados.
 * "unique" => se aceita ou nao repeticoes.
 * "precision" => Indica a precisao do numero, no caso indica a quantidade de casa decimal, se eh 2, 3 ou mais. 
 * "SequenceGenerator" => Caso voce queira que a aplicacao gere o ID, voce pode usar esse recurso.
 * 	"GeneratedValue" = "strategy" => {
 * 		"strategy = GenerationType.SEQUENCE" => A criacao de ID fica sob responsabilidade do Banco de dados. (Faz usando Trigger).
 * 		"strategy = GenerationType.IDENTITY" => A criacao de ID fica sob responsabilidade do Banco de dados. (Usa uma coluna de identidade)
 * 
 *		*No caso as duas estrategias acima tem banco que eh compativel ao identity e tem banco que eh compativel com sequence. Nem
 *		todos os bancos tem compatibilidade com o Identity, ou seja uma coluna para auto-incremento, entao cuidado. Recomenda-se
 *		usar SEQUENCE para aplicacoes concorrentes ou o AUTO caso nao haja concorrencia e voce queira deixar a aplicacao lidar com isso.
 *
 * 		"strategy = GenerationType.AUTO" => Deixa com o provedor de persistência a escolha da estratégia mais adequada de acordo com o banco de dados.
 * 		"strategy = GenerationType.TABLE" => Usa uma tabela para gerar um novo ID, apenas use se tiver um bom motivo.
 * 	}
 * "GeneratedValue" (generator = "nome da sua sequencia) => Caso você use o SequenceGenerator, voce deve informar o "generator".
 * 	"Temporal" => {
 * 		"javax.persistence.TemporalType.TIMESTAMP" => Data completa: ano,mes,dia,hora,minutos,segundos.
 * 		"javax.persistence.TemporalType.TIME" => Horario: hora,minutos,segundos.
 * 		"javax.persistence.TemporalType.DATE" => Dia: ano,mes,dia.
 * 		*use-o quando for trabalhar com datas.
 * 	}
 * Repare que todas as anotacoes pode ou nao ter valores dentro dos parentes, no caso os valores dentro dos parenteses tem os mesmos campos
 * que os atributos que existe nas tags xml.
 * 
 * Geralmente voce cria valores privados com getter e setter, mas como a ideia eh simplificar o codigo eu deixei a visibilidade para a publica mesmo.
 * 
 */
 