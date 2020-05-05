import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SubClasse")
@PrimaryKeyJoinColumn(name="idClasse")
public class SubClasse1 extends Classe{
	
	private String valor1;

	public String getValor() {
		return valor1;
	}

	public void setValor(String valor) {
		this.valor1 = valor;
	}
	
	public SubClasse1() {
		this.valor1 = "Meu Valor";
	}
	
	/*
	 * @PrimaryKeyJoinColumn(
	 * 	 "name" => Aqui eh definido o nome da chave estrangeira,
	 *  que sera relacionada com a classe pai, esse valor nao precisar
	 *  existir, uma vez que essa fk existira apenas no bd e todo 
	 *  o relacionamento sera feito la.
	 *  Essa estrategia eh interessante caso voce queira normalizar 
	 *  as tabelas.
	 * )
	 * */
}
