package pkg.tag.body;
import java.io.IOException;
import javax.servlet.jsp.tagext.*;
public class JavaMathBodyTag extends BodyTagSupport {
	String num;
	double num2;
	private static final long serialVersionUID = 1L;
	
	public int doAfterBody(){
		
		num = getBodyContent().getString(); //Pegando o valor entre tags e convertendo para String.
		
		try{ //Conversão da raiz quadrada, da String para Double
		num2 = Math.sqrt(Double.parseDouble(num));}
		catch(Exception e){num2 = 0;} //Caso tenha algum outro caractér além de números, e seja impossível extrair a sua raiz, cai no catch e o mesmo atribuí o valor para zero.
		return SKIP_BODY; //Aqui o valor processado ainda não é devolvido para a página JSP.
		
	}
	public int doEndTag(){
		
			try { //Caso caia no IOException. para usar a classe pageContext, deve-se colocar o mesmo entre um try-catch.
			pageContext.getOut().println("A raiz quadrada de: "+num+" é: "+num2);
			} catch (IOException e) {e.printStackTrace();}
		
		
		return EVAL_PAGE;
		
	}
	
	
}
