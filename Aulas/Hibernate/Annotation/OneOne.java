import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="principal")
public class OneOne {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_unico")
	public int codigo;
	
	@Column(name="valor")
	public String valor;
	
	/*
	 * Notacao Um para um, caso voce queira uma notacao 1 para 1 
	 * biderecional essa anotacao deve estar do outro lado tambem, 
	 * no exemplo que temos abaixo, seria na classe Auxiliar.
	 * */
	
	@OneToOne //Use apenas em entidades essa anotacao.
	@JoinColumn(name="id_auxiliar")	//Aqui eh definido os parametros do FK da auxiliar.
	public Auxiliar auxiliar;

	@Override
	public String toString() {
		return "Unico [codigo=" + codigo + ", valor=" + valor + ", auxiliar=" + auxiliar + "]";
	}	
	
	/*
	 * Essa entidade deve ser instanciada, a Entidade Auxiliar tambem, apos preencher
	 * todos os dados, a classe auxiliar dever ser passada ao atributo auxiliar,
	 * uma vez que tudo esteja pronto, se faz necessario quando for rodar a transacao
	 * executar o metodo "save" ou o "saveOrUpdate" em ambas as instancias antes de comitar.
	 * 
	 * A atribuicao da instancia do auxiliar com essa, eh a que faz a marcacao do campo id_auxiliar
	 * com o 
	 * */
	
	
}
