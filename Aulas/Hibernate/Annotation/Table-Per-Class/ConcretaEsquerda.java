package Heranca;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;


@Entity
@Table(name="Esquerda_tabela_por_classe")
//Para herencas voce precisa dessa anotacao abaixo.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ConcretaEsquerda extends Abstrata{ //Deve ter heranca atraves do Extends
	private String esquerda;
	
	public ConcretaEsquerda() {
		super();
		this.esquerda = "Estou a esquerda";
	}

	public String getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(String esquerda) {
		this.esquerda = esquerda;
	}
	
	/* 
	 * Repare que nessa entidade nao temos o ID, pois sem
	 * problema uma vez que o ID eh gerado pela classe
	 * Pai dessa, no caso a classe abstrata
	 * @Inheritance Identifica Herenca, porem essa heranca
	 * pode ter tres estrategias para ocorrer e aqui temos um
	 * exemplo da estrategia TABLE_PER_CLASS, que significa
	 * tabela por classe, ou seja cada classe concreta ira 
	 * gerar uma tabela no banco de dados, contendo os valores
	 * dela e do Pai dela tambem, no caso aqui temos a classe
	 * esquerda e direita, ambas nessa estrategia, elas descendem
	 * da classe abstracao. Na estrategia TABLE_PER_CLASSE,
	 * sera criado N tabelas com ambas contendo os 
	 * seus respectivos valores exclusivos e os valores na classe pai.
	 * Exemplo: @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	 * Se Entidade Pai tem um atributo X, todas as entidadees que extenderem
	 * dessa Entidade Pai, teram uma tabela no banco de dados com os seus 
	 * respectivos campos e cada uma delas tambem teram os campos herdados
	 * do Pai nas suas respectivas tabelas. A tabela Pai nao existe nessa
	 * estrategia, apenas existe as entidades que correspondem a classe 
	 * concreta, ou seja esse mapeamento eh feito com base nos atributos
	 * que as classes concretas tem tanto os herdados com os nativos.
	 * */
}
