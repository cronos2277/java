public class TesteDouble {

  public static void main(String[] args) {
    //Obtendo o maior e o menor valor
    double maior = Double.MAX_VALUE;
    double menor = Double.MIN_VALUE;
    System.out.println("Maior valor: "+ maior);
    System.out.println("Menor valor: " + menor);

    String s = "123";
    double b = 0;
    //Convertendo de String para double
    b = Double.parseDouble(s);
    //Convertendo de double para String
    s = Double.toString(b);

  }

}
