public class TesteFloat {

  public static void main(String[] args) {
    //Obtendo o maior e o menor valor
      float maior = Float.MAX_VALUE;
      float menor = Float.MIN_VALUE;
      System.out.println("Maior valor: "+ maior);
      System.out.println("Menor valor: " + menor);

      String s = "123";
      float b = 0;
      //Convertendo de String para float
      b = Float.parseFloat(s);
      //Convertendo de float para String
      s = Float.toString(b);
  }

}
