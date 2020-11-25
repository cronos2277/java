package annotations;
public class Main {

	public static void main(String[] args) {
		Check check = new Check(ClasseExemplo.class);	
		check.anotacaoMetodo();
		check.anotacaoConstructor();
		check.anotacaoCampo();
		check.anotacaoClasse();
		check.anotacaoParametro();
	}

}
