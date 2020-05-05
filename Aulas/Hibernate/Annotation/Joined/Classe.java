import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity //Apesar de ser filha, isso eh necessario.
@Table(name="Classe")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Classe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	/*
	 * @Inheritance(strategy = InheritanceType.JOINED)
	 * Nessa estrategia sao criada uma tabela para cada
	 * classe, tanto a classe pai como as todas as filhas,
	 * todas essas tabelas sao unidas por uma chave estrangeira
	 * No caso a classe mais abstrata cria um valor de ID
	 * e esse ID eh passado para as outras tabelas, essa
	 * seria uma forma de fazer um relacionamento 1 para N.
	 * Cada Entidade tem a sua tabela e as entidades filhas
	 * tem uma chave estrangeira que liga a classe Pai.
	 * Tirando a anotacao @Inheritance de resto eh tudo igual
	 * nessa classe.
	 * Nas classes filhas devem ter a anotacao:
	 * @PrimaryKeyJoinColumn(name) com o nome do campo que 
	 * sera a chave estrangeira la no banco de dados, 
	 * essa coluna definida nessa anotacao, nao precisa existir,
	 * essa chave estrangeira existe apenas la no banco de dados.
	 * */
}
