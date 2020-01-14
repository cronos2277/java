public class TesteMath {

  public static void main(String[] args) {
    int a = -2;
    //Obtendo o valor absoluto
    a = Math.abs(a);
    System.out.println("Valor absoluto: "+a);

    //Exponenciação
    double d = Math.pow(2,8);
    System.out.println("Potenciação: "+d);

    //Gerando números Randômicos
    for(int i = 0; i< 10;i++){
      System.out.println(" Número Randomico: "+Math.random());
    }
  }

}
