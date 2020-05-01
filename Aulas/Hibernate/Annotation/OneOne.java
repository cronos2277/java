import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	
	//"targetEntity": é a classe da entidade que é o destino da associação(Opcional). 
	@OneToOne(targetEntity=Auxiliar.class) //Use apenas em entidades essa anotacao. 
	@Cascade(value = { CascadeType.ALL }) //Explicado nos comentarios da classe Auxiliar
	@JoinColumn(name="id_auxiliar")	//Aqui eh definido os parametros do FK da auxiliar.
	public Auxiliar auxiliar;

	@Override
	public String toString() {
		return "Unico [codigo=" + codigo + ", valor=" + valor + ", auxiliar=" + auxiliar + "]";
	}	
	
	
	
	
}
