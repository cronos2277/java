import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
	@Table(name="AUXILIAR")
	public class Auxiliar {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id")
		public int codigo;
		
		@Column(name="valor")
		public String valor;
		
		@OneToOne //Aqui eh feito a anotacao 1-1, Explica nos comentarios da classe OneOne
		@Cascade(value = { CascadeType.ALL })
		@JoinColumn(name="id_onetoone") //Aqui eh definido a FK da relacao 1x1
		public OneOne oneone;
		
		@Override
		public String toString() {
			return "Auxiliar [codigo=" + codigo + ", valor=" + valor + "]";
		}
		
		
		/*
		 * Sem a anotacao cascade, na insercao
		 * a entidade OneOne deve ser instanciada, a Entidade Auxiliar tambem, apos preencher
		 * todos os dados, a classe auxiliar dever ser passada ao atributo auxiliar,
		 * uma vez que tudo esteja pronto, se faz necessario quando for rodar a transacao
		 * executar o metodo "save" ou o "saveOrUpdate" em ambas as instancias antes de comitar.	 * 
		 * A atribuicao da instancia do OneOne, eh a que faz a marcacao do campo id_auxiliar
		 * com o primary da entidade.
		 *  @Cascade(value = { CascadeType.ALL }) com a cascade voce tem a sincronia entre as
		 *  entidades, ou seja no caso de uma anotacao onetoone por exemplo, qualquer uma das
		 *  duas que voce manda salvar, ja salva a outra, voce nao precisara fazer duas operacoes
		 *  de insercoes, isso funciona tambem com exclusao e atualizacao dependendo do tipo
		 *  de cascade que voce colocar em value.
		 * */
		
	}