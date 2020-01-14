package pkg;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.TextProvider; //Essa interface contém o método getText(). Por isso ela está sendo importada e implementada.
public class acao extends ActionSupport  implements TextProvider{	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	@Override
	public String execute() throws Exception {
		/*
		 * O método getText("String") é oriunda da interface TextProvider, do pacote: com.opensymphony.xwork2
		 * Esse método permite ler o arquivo .properties informado no "struts.xml". O seu funcionamento
		 * é muito simples, ele é um método que requer um parâmetro do tipo STring, e esse parâmetro
		 * deve ser o nome usado na chave do arquivo properties. No caso um arquivo properties tem
		 * um campo chamado chave, ao qual é o nome que se refere ao valor, e o campo valor, que é
		 * o conteúdo dessa chave.  Ao informar a chave, este método retorna o valor desta chave
		 * no arquivo properties. Lembrando que o conteúdo do arquivo propertie é sempre uma String
		 * por isso não se usa aspas lá. 
		 * */
		
		mensagem = getText("msn");		// <-- O método propriamente dito.	
		return super.execute();
	}
	public String getMensagem() {
		return mensagem;
	}
		
}
