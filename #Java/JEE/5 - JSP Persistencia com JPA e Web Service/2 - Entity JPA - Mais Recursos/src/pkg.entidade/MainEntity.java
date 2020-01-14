package pkg.entidade;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
//Para criar esse exemplo foi necessário o uso de 3 bibliotecas: eclipselink.jar, javax.persistence_2.1.0.v201304241213.jar, mysql-connector-java-5.1.34-bin.jar
//A importação foi tanto na pasta /WebContent/WEB-INF/lib do projeto, como no caso do eclipse, Project > properties > JavaBild Path, na Aba Libries.
//---------------------------------------------------------------------------------------------------------------------------------
@Entity //Anotação obrigatória, para a JVM saber que é uma entidade.
@Table(name="CLIENTE") //Aqui é especificado a tabela a ser carregado no banco de dados, nesse exemplo a entidade terá um nome diferente da tabela.
public class MainEntity {
//É importante Frisar que essas anotações, vem antes dos atributos.	
@Id //Anotação obrigatória. A variável, logo abaixo dessa é a chave primária.
//--------------------------------------------------------------------------------------------------------------------------------
	//@GeneratedValue()
//strategy, aqui é a estratégia usada na criação de chaves primária. No caso a GenerationType é uma Enum. Seus valores são: AUTO, IDENTITY, SEQUENCE ou TABLE.
//@GeneratedValue(strategy = GenerationType.AUTO) --> Indica que o provedor de persistência deve escolher uma estratégia adequada para o banco de dados particular.
//@GeneratedValue(strategy = GenerationType.IDENTITY) --> Indica que o provedor de persistência deve atribuir chaves primárias para a entidade usando uma coluna de identidade de banco de dados.
//@GeneratedValue(strategy = GenerationType.SEQUENCE) --> Indica que o provedor de persistência deve atribuir chaves primárias para a entidade através de uma seqüência de banco de dados.
//@GeneratedValue(strategy = GenerationType.TABLE) --> Indica que o provedor de persistência deve atribuir chaves primárias para a entidade que utiliza uma tabela de banco de dados subjacente para garantir a exclusividade.
@GeneratedValue(strategy = GenerationType.IDENTITY )
//---------------------------------------------------------------------------------------------------------------------------------
	//@Column()
//@Column(name="String") O campo nome se faz necessario, caso a variavel tenha um nome diferente, do atributo no SGBD. Por padrão a entidade supõe, que tem o mesmo nome. O seu valor é o nome da variável no SGBD.
//@Column(table="String") O Campo se faz necessário, caso o atributo dessa variável, esteja em outra tabela, diferente da que essa entidade trabalha.
//@Column(nullable=boolean) Especifica se esse atributo aceita valores nulos. True = sim, False = não.
//@Column(lenght=Integer) Especifica o tamanho máximo da coluna, padrão 255.
//Tem tambem o scale, que serve para formatação de numeros Doubles, no caso quantos numeros após a vírgula serão exibidos.
//Tem tambem o unique que é usado caso tenha mais de uma chave primária.
//Para mais informação Site: http://www.universidadejava.com.br/docs/jpa20-identificareusarasanotacoescomunsdajavapersistenceapitalcomoentityidtableecolumn
@Column(name="id", table="CLIENTE", nullable=false, length = 255)
//-----------------------------------------------------------------------------------------------------------------------------------
	//Criando variável primária.
private Long primaryKey; //Apenas para questão de didática, apenas essa variável terá nome diferente ao atributo no SGBD.
public Long getPrimaryKey(){ //Método get do primaryKey.
	return primaryKey;
}
public void setPrimaryKey(Long primaryKey){ //set do primary key.
	this.primaryKey = primaryKey;
}

//-------------------------------------------------------------------------------------------------------------------------------------
//Criando as demais variáveis, referente a tabela CLIENTE. Válido lembrar, que se você estiver no linux o FileSystem do linux é sensetive case, talvez o @Column seja necessário.
	private String nome;
	private String login;
	private String senha;

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
}
