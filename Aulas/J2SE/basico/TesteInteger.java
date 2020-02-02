public class TesteInteger {

  public static void main(String[] args) {
    //Obtendo o maior e o menor valor
    int maior = Integer.MAX_VALUE;
    int menor = Integer.MIN_VALUE;
    System.out.println("Maior valor: "+ maior);
      System.out.println("Menor valor: " + menor);
    String s = "123";
    int b = 0;
     //Convertendo de String para int
     b = Integer.parseInt(s);
     //Convertendo de int para String
     s = Integer.toString(b);
  }

}
