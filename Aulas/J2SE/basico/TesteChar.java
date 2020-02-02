public class TesteChar {

  public static void main(String[] args) {
    // Verificando se é digito ou letra
    char c ='$';
    if(Character.isDigit(c))
      System.out.println(c + " é digito:");
    if (Character.isLetter(c))
      System.out.println(c + " é letra: ");

  }

}
//a função Character.isDigit() retorna true se for um número. Qualquer outra carácter false.
//a função Character.isLetter() retorna true se for uma letra. Qualquer outra carácter false.