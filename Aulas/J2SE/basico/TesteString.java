public class TesteString {

  public static void main(String[] args) {
    String dominio = "www.treinaweb.com.br";
    //Obtendo a posição de um caracter ou string dentro da string
    int posicao = dominio.indexOf("treina");
    System.out.println(posicao);

    //obtendo o tamanho da string
    int tamanho = dominio.length();
    System.out.println(tamanho);

    //Substituindo caracteres na string
    String dominioAlterado = dominio.replace(".","-");
    System.out.println(dominioAlterado);

    //Obtendo uma parte da String
    String parteDominio = dominio.substring(4,12);
    System.out.println(parteDominio);

    //Obtendo uma parte da String
    String parteDominio2 = dominio.substring(4);
    System.out.println(parteDominio2);

    //Convertendo a string para maiúscula
    String dominioMaiuscula = dominio.toUpperCase();
    System.out.println(dominioMaiuscula);
  }

}
