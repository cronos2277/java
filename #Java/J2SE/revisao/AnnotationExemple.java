import java.lang.annotation.*;

@anotacao(context = "Exibindo valor de anotacao")
public class AnnotationExemple{			
	public static void main(String args[]){		
		Annotation[] annotations = AnnotationExemple.class.getAnnotations();
		for(Annotation ann: annotations){
			anotacao an = (anotacao) ann;
			System.out.println(an.context());
			System.out.println(an.numberInt());
		}

	}
}

@Retention(RetentionPolicy.RUNTIME) //< - Deve estar presente.
@interface anotacao{
	public String context() default "";
	public int numberInt() default 17;
	
}

/*
 * Aqui se tem um exemplo de anotação, inicialmente deve-se colocar o
 * @ na frente do interface e importar o java.lang.annotation.*;
 * Na interface você instancia os atributos como mostrado acima:
 * public String context() default "";
 * public indica que é visível a todos.
 * O tipo com que trabalha
 * e o seu nome seguido de ().
 * Você também pode implementar um valor padrão usando o default.
 * 
 * Esse método ele analisa o arquivo.class, quando você chama uma classe
 * da seguinte forma "SuaClasse.class", na verdade você está se referindo
 * ao arquivo.class, e o método getAnnotations retorna todos os valores
 * das anotações achadas no arquivo .java acima da interface.
 * O arquivo usando o método .class ele avalia o conteúdo da classe, 
 * lembre-se disso. 
 * 
 * O método getAnnotation retorna um array de anotações, nesse caso foi
 * pego todos as anotações da classe e jogado dentro de um array. Uma
 * vez que se tem o array, roda-se o foreach e de um cast para o tipo
 * da sua anotação e uma vez feito isso você pode usar os valores.
 * 
 * O Retention é obrigatório, pois ele permite que a classe seja visível
 * em tempo de execução, lembre de usar a anotação Retention, quando for
 * trabalhar com anotação em tempo de execução.
 * */
