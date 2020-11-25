package annotations;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Check {	
	private Class<?> clazz;	
	
	public Check(Class<?> clazz) {
		this.clazz = clazz;		
	}	
	
	//Metodo que vefica se tem a anotacao no metodo e o seu valor.
	public void anotacaoMetodo() {
		System.out.println();
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(methods.length+" metodo(s) tem essa anotacao de metodo");
		for(Method method:methods) {			
			System.out.printf("O metodo %s tem uma anotacao RUNTIME", method);
			System.out.println();
			System.out.printf("Possui a anotacao 'MetodoRuntime'? %b",method.getAnnotation(MetodoRuntime.class).valor());
			System.out.println();
			System.out.printf("Qual o valor do 'MetodoRuntime'? %s",method.getAnnotation(MetodoRuntime.class).valor());
		}
		System.out.println();
	}
	
	//Metodo que vefica se tem a anotacao no construtor e o seu valor.
	public void anotacaoConstructor() {
		System.out.println();
		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println(constructors.length+" construtore(s) tem essa anotacao de construtor");
		for(Constructor constructor:constructors) {			
			System.out.printf("O construtor %s tem uma anotacao RUNTIME", constructor);
			System.out.println();
			System.out.printf("Possui a construtor 'ConstructorRuntime'? %b",constructor.getAnnotation(ConstrutorRuntime.class));
			System.out.println();
			System.out.printf("Qual o valor do 'ConstructorRuntime'? %s",constructor.getAnnotation(ConstrutorRuntime.class));
		}
		System.out.println();
	}
	
	//Metodo que vefica se tem a anotacao nos campos e o seu valor.
	public void anotacaoCampo() {
		System.out.println();
		Field[] fields = clazz.getFields();
		System.out.println(fields.length+" campo(s) tem essa anotacao de atributos");
		for(Field field:fields) {
			System.out.printf("O construtor %s tem uma anotacao RUNTIME", field);
			System.out.println();
			System.out.printf("Possui a anotacao 'FieldRuntime'? %b",field.getAnnotation(FieldRuntime.class));
			System.out.println();
			System.out.printf("Qual o primeiro valor do 'FieldRuntime'? %s",field.getAnnotation(FieldRuntime.class).numero1());
			System.out.println();
			System.out.printf("Qual o segundo valor do 'FieldRuntime'? %s",field.getAnnotation(FieldRuntime.class).numero2());
		}
		System.out.println();
	}
	
	//Metodo que vefica se tem a anotacao nas classes e o seu valor.
	public void anotacaoClasse() {
		System.out.println();
		TypeRuntime[] types = clazz.getDeclaredAnnotationsByType(TypeRuntime.class);
		System.out.println(types.length+" classe(s) tem essa anotacao de classe");
		for(TypeRuntime type:types) {
			System.out.printf("Essa classe tem a %s, uma anotacao RUNTIME", TypeRuntime.class.getName());
			System.out.println();
			System.out.printf("Possui a anotacao 'TypeRuntime'? %b",type.num());
			System.out.println();
			System.out.println("Qual o valor do 'TypeRuntime'? "+type.num());						
		}		
	}
	
	//Metodo que vefica se tem a anotacao nos parametros de metodos, construtores, etc... e o seu valor.
	public void anotacaoParametro() {
		System.out.println();
		Method[] methods = clazz.getDeclaredMethods();
		Parameter[] params = methods[0].getParameters();
		System.out.printf("O metodo '%s' tem %s atributo anotado", methods[0].getName(),params.length);
		System.out.println();
		for(Parameter param:params) {
			System.out.printf("O metodo %s tem a anotacao %s.",MetodoRuntime.class.getName(),ParameterRuntime.class.getName());
			System.out.println();
			System.out.printf("O nome do parametro %s com o valor %s",param.getName(),param.getDeclaredAnnotation(ParameterRuntime.class).num());
		}
	}
}
