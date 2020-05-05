package Heranca;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass //Essa eh a anotacao que a classe pai deve ter
public abstract class Abstrata {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int superId;
	public int getSuperId() {
		return superId;
	}
	public void setSuperId(int superId) {
		this.superId = superId;
	}
	public String getSuperValor() {
		return superValor;
	}
	public void setSuperValor(String superValor) {
		this.superValor = superValor;
	}
	private String superValor;
	protected Abstrata() {
		this.superValor = "Estou na abstracao";
	}
	
	/*
	 * Essa eh uma forma de heranca aonde uma classe pode
	 * ser uma das filhas e as filhas sao independente
	 * entre si, evitando assim o polimorfismo. Cada
	 * tabela filha dessa vai ter os seus proprios
	 * atributos, mais os atributos definidos aqui,
	 * cada um em sua tabela, essa classe nao eh 
	 * mapeada no hibernate.cfg.xml, apenas as classes
	 * concretas que vao. Esse modelo de heranca, atende
	 * a demanda Generalizacao/Especializacao, uma vez
	 * que os atributos mais genericos que todas as filhas
	 * devem ter, estao aqui e os atributos mais especificos
	 * ficam nas filhas, lembrando que essa classe nao
	 * vai virar tabela, apenas as classes filhas, sendo
	 * que as classes filhas teram os atributos que estao aqui 
	 * tambem.
	 * */
}
