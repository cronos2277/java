import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ClasseFilha")
@PrimaryKeyJoinColumn(name="idClasse")
public class SubClasse2 extends Classe{
	private String valor2;

	public String getValor() {
		return valor2;
	}

	public void setValor(String valor) {
		this.valor2 = valor;
	}
	
	public SubClasse2() {
		this.valor2 = "Meu Valor";
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
