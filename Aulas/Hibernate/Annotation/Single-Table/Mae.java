import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity //Apesar de ser filha, isso eh necessario.
//Todas as tabelas filhas precisam ter esse valor definido
@DiscriminatorValue("Mae") 
public class Mae extends Avo{
	private String nomeMae;

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public Mae() {
		this.nomeMae = "Nome da Mae";
	}
	
	/*
	 * Essa eh a classe que extende hierarquicamente de uma superior.
	 * O unico valor de diferente aqui, eh o "@DiscriminatorValue"
	 * Algumas coisas devem ser atentada para essa anotacao.
	 * 1 -) O tipo deve ser compativel com o informado aqui:
	 * @DiscriminatorColumn(
	 * 						name="parentesco", 
	 * 						discriminatorType=DiscriminatorType.STRING
	 * 						)
	 * No caso o tipo aqui eh string, mas poderia ser integer ou char, 
	 * No caso quando essa Entidade for persistida o valor "Mae" 
	 * vai ser colocado como valor no atributo "parentesco"
	 * Esse campo de descriminator eh o atributo que identifica
	 * cada classe filha.
	 * Todas as classes sao unidas em uma so, ou seja a classe
	 * Pai e todas as classes Filhas dessa pai constituem uma so
	 * tabela, contendo todos os atributos da classe Pai e de 
	 * todas as classes filhas, No caso o unico campo que varia
	 * eh justamente esse campo definido no @DiscriminatorColumn, 
	 * ao qual deve ter uma @DiscriminatorValue diferente para cada
	 * tabela filha, uma vez que esse sera o campo que identificara
	 * o valor que difere em cada Entidade filha. 
	 * Esse modelo visa atender as necessidades por hirarquia, aonde
	 * todos os campos obrigatorios devem estar na classe pai, ficando
	 * as classes filhas apenas os atributos opcionais. 
	 * */
}
