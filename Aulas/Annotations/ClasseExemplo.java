package annotations;

@TypeRuntime(num = 5) 
public class ClasseExemplo {
	
	@FieldRuntime(numero1 = 1)
	public int valor;
	
	@ConstrutorRuntime
	public ClasseExemplo() {
		System.out.println("Instanciado");
	}
	
	@MetodoRuntime(valor = "lklkl")
	public int metodo(@ParameterRuntime(num = 9) int parametro) {
		return parametro;
	}
}
