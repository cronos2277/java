package pkg.tag.simple;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;
public class JavaSimpleTagDate extends SimpleTagSupport{

	public void doTag() throws JspException, IOException{
		PageContext page = (PageContext) getJspContext();
		JspWriter out = page.getOut();
		out.println(String.format("%s", new java.util.Date()));
	}
	
}

//Criação de uma tag simples.
//A importação da IOException é para controle de erros.
//A importação da javax.servlet.jsp.tagext.*; serve para que você possa extender a classe.
//A importação da javax.servle.jsp.*; server para que você possa fazer uso da PageContext e da JspWriter.
//A Classe extende a SimpleTagSupport, após isso existe um método com retorno vazio, chamado doTag().
//O método doTag() precisa lidar com dois catch o JspException, e o IOException.

//O objeto PageContext contém o contexto da página, ou seja. 
//Através deste objeto que se pode manipular a página.

//O método getJspContext() retorna o contexto da página. 
//Este contexto é fornecido pelo container web. Quando a tag criada é utilizada 
//em uma página JSP, o container web consegue identificar esta tag,
//e sabe qual contexto retornar no método getJspContext().
