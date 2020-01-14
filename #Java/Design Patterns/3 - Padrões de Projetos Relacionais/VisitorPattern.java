public class VisitorPattern{
	public static void main(String args[]){
		Element elemento = new Element();
		Visitor visitor = new Visitor();		
		elemento.setText("Hello World");
		elemento.accept(visitor.element(elemento));
	}
}


//Visitor: O visitor adiciona funcionalidades para um objeto sem alterar
//a estrutura dele.
interface AbstractVisitor{
	public Visitor element(Element element);
}

class Visitor implements AbstractVisitor{
		
	public Visitor element(Element el){
		sysout(el);
		return this;
	}
	
	private void sysout(Element el){
		System.out.println(el.getText());
	}	
}



//Element: Perece um bean, porém ele tem um método accept, que executa
//o visitor, o accept não retorna método então nada de criar instancias,
//Visitante não é residente.
interface AbstractElement{
	public void accept(Visitor visitor);
}

//O Element é um bean, com o AbstractElement implementado.
class Element implements AbstractElement{
	private String text;
//Aqui o Element assume o comportamento do Visitor. Repare que a classe
//usa a sua própria instancia como parâmetro e o método é void.
	public void accept(Visitor visitor){
		 visitor.element(this);
	}
	
	public void setText(String str){
		this.text = str;
	}
	
	public String getText(){
		return this.text;
	}
}
/*
 * No padrão visitor você adiciona funcionalidades a um objeto em um 
 * dado momento, o visitor lembra um pouco o Decorator, porém diferente
 * do dacorator você chama um método ele executa as instruções e tudo 
 * volta a ser como antes, até porque ele é um visitante e não um residente.
 * Resumindo: você tem um objeto que aceita outro como parametro, apartir
 * do momento que esse outro objeto for chamado, esse outro faz o que tem
 * que ser feito e termina a sua execução. Nesse caso nos temos um objeto
 * que se comporta como um Bean, assim como qualquer outros, porém ele
 * recebe um visitor e no momeno que esse visitor é chamado, ele imprime
 * os valores dele mesmo na tela, ou seja nesse momento ele passa a ter
 * uma funcionalidade que não é nativo dele.
 * */
