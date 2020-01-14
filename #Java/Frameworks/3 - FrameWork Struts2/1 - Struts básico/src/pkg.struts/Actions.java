package pkg.struts;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Actions extends ActionSupport {
	private String mensagem = "Ol�, hoje � dia - ";
	public String getMensagem() {
		return mensagem;
	}
	@Override
	public String execute() throws Exception {
		mensagem += new Date();
		return super.execute();
	}
/*
 *	Para que funcione corretamente, para que seja feita alguma a��o no valor da vari�vel, se faz
necess�rio que voc� chame e reescreva o m�todo execute(). � o execute que vai fazer a a��o de adi-
cionar as horas em tempo real na sua string, como visto no exemplo acima. Esse m�todo � indispens�vel,
caso seja necess�rio fazer algum processamento dos valores contidos no atributo. Nunca esque�a dos m�todos
set, caso haja entrada de dados, ou do get caso haja o resgate dos dados. Essa classe ela estende-se da
classe:  
 	"com.opensymphony.xwork2.ActionSupport".
 	Para mais informa��es sobre o funcionamento, consulte os coment�rios da p�gina jsp, "actions.jsp"
 	localizado na pasta "pages".
 */
}
