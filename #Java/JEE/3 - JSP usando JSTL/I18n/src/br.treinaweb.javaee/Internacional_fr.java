package br.treinaweb.javaee;

import java.util.ListResourceBundle;//Esse pacote deve ser importado para a intenacionalização.

//Aqui a classe extende de ListResourceBundle.
public class Internacional_fr extends ListResourceBundle {
	//Aqui é criado uma matriz do tipo objeto, contendo os valores chaves com ponto
		// E o seu conteúdo em determinados idiomas, melhor explicado na página JSP.
  @Override
  protected Object[][] getContents() {
	//O get do objeto criado acima. Repare que o método set foi omitido, isso
		//porque ele não será util.	
	  return contents; //O retorno é a variável objeto criada.
  }

  static final Object[][] contents ={//Uma variável estática e constante.
      {"login.apresentacao","Bienvenue"},
      {"login.usuario","Utilisateur:"},
      {"login.senha","Mot de passe:"},
      {"login.correto","Ouverture correcte"},
      {"login.incorreto","Ouverture incorrecte"},
  };
}