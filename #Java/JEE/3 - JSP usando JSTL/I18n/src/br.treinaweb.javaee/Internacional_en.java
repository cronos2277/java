package br.treinaweb.javaee;
import java.util.ListResourceBundle; //Esse pacote deve ser importado para a intenacionalização.
//Aqui a classe extende de ListResourceBundle.
public class Internacional_en extends ListResourceBundle {
	//Aqui é criado uma matriz do tipo objeto, contendo os valores chaves com ponto
		// E o seu conteúdo em determinados idiomas, melhor explicado na página JSP.
	
	static final Object contents [][] = {//Uma variável estática e constante.
		{"login.apresentacao","Welcome!"},
		{"login.usuario", "User: "},
		{"login.senha", "Password: "},
		{"login.correto", "Correct Login."},
		{"login.incorreto", "Incorrect Login."}
		
	};
	@Override
	protected Object[][] getContents() {
		//O get do objeto criado acima. Repare que o método set foi omitido, isso
		//porque ele não será util.		
		return contents; //O retorno é a variável objeto criada.
	}

	
	
	
}
