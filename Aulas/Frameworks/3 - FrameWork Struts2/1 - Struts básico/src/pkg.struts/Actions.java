package pkg.struts;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Actions extends ActionSupport {
	private String mensagem = "Olá, hoje é dia - ";
	public String getMensagem() {
		return mensagem;
	}
	@Override
	public String execute() throws Exception {
		mensagem += new Date();
		return super.execute();
	}
/*
 *	Para que funcione corretamente, para que seja feita alguma ação no valor da variável, se faz
necessário que você chame e reescreva o método execute(). É o execute que vai fazer a ação de adi-
cionar as horas em tempo real na sua string, como visto no exemplo acima. Esse método é indispensável,
caso seja necessário fazer algum processamento dos valores contidos no atributo. Nunca esqueça dos métodos
set, caso haja entrada de dados, ou do get caso haja o resgate dos dados. Essa classe ela estende-se da
classe:  
 	"com.opensymphony.xwork2.ActionSupport".
 	Para mais informações sobre o funcionamento, consulte os comentários da página jsp, "actions.jsp"
 	localizado na pasta "pages".
 */
}
