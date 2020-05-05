import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity //Apesar de ser filha, isso eh necessario.
//Essa eh a anotacao que a classe pai deve ter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="parentesco", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Avo")
public abstract class Avo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * Essa eh a classe Pai, essa tabela ira compor junto com
	 * todas as classes filhas uma unica tabela, esse eh o que 
	 * faz a estrategia de SINGLE_TABLE, que eh tabela simples.
	 * Essa classe tem a anotacao @Entity, mas nao eh mapeada no
	 * hibernate.cfg.xml.
	 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	 * Essa estrategia visa unir todas as entidades filhas e
	 * essa entidade em uma so tabela, sendo diferenciada pelos
	 * valores do @DiscriminatorColumn. Os atributos especificos
	 * das classes filhas tambem seram encorporadas a tabela,
	 * assim como os que estao aqui.
	 * @DiscriminatorColumn{
	 * 	"name" =Indica o nome do atributo que identifica cada filho no BD.
	 * 	"discriminatorType" = Aqui voce define o tipo do valor desse atributo.
	 * }
	 * @DiscriminatorValue("Avo"){
	 * 		Aqui definimos o valor que cada Entidade vai ter, no caso cada
	 *  Entidade vai ser identificado por esse atributo aqui. No caso
	 *  quando for persistido essa classe seria colocado o valor "Avo"
	 *  no campo parentesco.
	 * }
	 * */
}
