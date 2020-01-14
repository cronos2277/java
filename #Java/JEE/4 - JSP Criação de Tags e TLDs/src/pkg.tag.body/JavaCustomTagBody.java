package pkg.tag.body;
import java.io.IOException;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class JavaCustomTagBody extends BodyTagSupport{
private static final long serialVersionUID = 1L; //A serialização é obrigatória ao extender a classe.
public String temp; //Variável a ser usada pela tag customizada.


public int doAfterBody() throws JspException{ //throw para JspException Obrigatório.
//Esse método é responsável pelo que acontece, 
//assim que a classe tem contato com o conteúdo.
//O método retorna um integer.	
	
	temp = getBodyContent().getString(); //Aqui a variável temp, recebe o valor entre a tag, convertido para String.
	return SKIP_BODY; //é para não processar o conteúdo do corpo da tag. Assim sendo, o seu valor
						//corre apenas dentro da classe, até encontrar uma constante Integer EVAL_PAGE;
	
}

public int doEndTag(){
	//Esse método acontece ao incerramento da tag.
	//O método retorna um integer, no caso um SKIP_BODY, para não ser processado,
	//ou um EVAL_PAGE, para devolver o processo, a página jsp.
	
	try { //IOException é obrigatório para o uso do pageContext.getOut().println();
	
		//Aqui a saída dos dados, o mesmo foi formatado para ser exibido usando tags html.
		pageContext.getOut().println("<h1 align='center'>"+temp+"</h1>");
		
	}catch(IOException e) {e.printStackTrace();}
	return EVAL_PAGE; //Constante integer. Aqui devolve o valor solicitado pelo corpo da página.
	
}


}
