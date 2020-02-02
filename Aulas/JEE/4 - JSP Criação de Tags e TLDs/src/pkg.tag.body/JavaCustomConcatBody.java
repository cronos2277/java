package pkg.tag.body;
import java.io.IOException;

import javax.servlet.jsp.tagext.BodyTagSupport;

public class JavaCustomConcatBody extends BodyTagSupport {
private static final long serialVersionUID = 1L;
String concat;
public int doAfterBody(){ // processamento antes de ser enviado a página JSP. 
	
	concat = getBodyContent().getString(); //Pegar conteúdo das tags converter em String.
	
	for(int a=0;a <= 64; a++){ 
	concat = concat.replace((char) a, ' ');} //Substituição de carácter, usando a tabela ASCII.
	
	for(int a=91;a <= 96; a++){
		concat = concat.replace((char) a, ' ');} //No caso o valor de A pula os valores de ASCII correspondente as letras.
	
	for(int a=123;a <= 127; a++){
		concat = concat.replace((char) a, ' ');} // A função replace, substítui determinados valores em uma String. A String é varrida como um array, em busca desses valores.
	
	
	
	return SKIP_BODY;} //O processamento, ainda não é enviado a página JSP.
	


public int doEndTag(){
	try {
		pageContext.getOut().println(concat); //Printar o novo conteúdo da String concat.
	} catch (IOException e) {e.printStackTrace();} //A caso de um erro, dentro do IOException.
	return EVAL_PAGE; //Manda o processo para a página JSP.
	
}
	
}
//Essa função substítui qualquer caracter diferente do alfabeto, para espaço em branco.
//Como o idima é o português, isso não afeta a acentuação.
