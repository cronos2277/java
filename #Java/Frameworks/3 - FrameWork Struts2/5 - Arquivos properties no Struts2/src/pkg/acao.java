package pkg;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.TextProvider; //Essa interface cont�m o m�todo getText(). Por isso ela est� sendo importada e implementada.
public class acao extends ActionSupport  implements TextProvider{	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	@Override
	public String execute() throws Exception {
		/*
		 * O m�todo getText("String") � oriunda da interface TextProvider, do pacote: com.opensymphony.xwork2
		 * Esse m�todo permite ler o arquivo .properties informado no "struts.xml". O seu funcionamento
		 * � muito simples, ele � um m�todo que requer um par�metro do tipo STring, e esse par�metro
		 * deve ser o nome usado na chave do arquivo properties. No caso um arquivo properties tem
		 * um campo chamado chave, ao qual � o nome que se refere ao valor, e o campo valor, que �
		 * o conte�do dessa chave.  Ao informar a chave, este m�todo retorna o valor desta chave
		 * no arquivo properties. Lembrando que o conte�do do arquivo propertie � sempre uma String
		 * por isso n�o se usa aspas l�. 
		 * */
		
		mensagem = getText("msn");		// <-- O m�todo propriamente dito.	
		return super.execute();
	}
	public String getMensagem() {
		return mensagem;
	}
		
}
