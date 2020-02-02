import java.util.ArrayList;
import javax.swing.*;
public class StrategyPattern{
	public static void main(String args[]){
//Repare que nesse padrão dois objetos difente seguem os mesmos métodos.
		Fatorial fat = new Fatorial();
		MMC mmc = new MMC();
		fat.strategy(JOptionPane.showInputDialog(null,"Informe um numero para tirar o fatorial."));
		mmc.strategy(JOptionPane.showInputDialog(null,"Informe um numero para tirar o MMC"));
		fat.result();
		mmc.result();
	}
}
//No Strategy você possui pelo menos um método em comum entre as classes,
//mas o conteúdo das classes e a funcionalidade do método pode mudar.
interface Strategy{
	public void strategy(String num);
	public void result();
}

//Veja que o Fatorial é diferente do MMC, mas possuem a mesma interface,
//e o método tem função diferente, essa é a característica do Strategy.
class Fatorial implements Strategy{
	public int fat;
	public Fatorial(){
		fat = 1;
	}
	@Override
	public void strategy(String tmp){
		try{
		int num = Integer.parseInt(tmp);		
		for(int i = num;i >= 1; i--)
			fat *= i;
		}catch(Exception e){sysout(e.toString());}
	}
	
	private void sysout(String error){//O método oriundo da interface.
		JOptionPane.showMessageDialog(null,error);
	}
	
	@Override
	public void result(){//O método oriundo da interface.
		if(this.fat != 0)
		JOptionPane.showMessageDialog(null,"O Fatorial eh: "+fat);
	}

}
//Veja que o MMC é diferente do fatorial, mas possuem a mesma interface,
//e o método tem função diferente, essa é a característica do Strategy.
class MMC implements Strategy{
	private String number;
	private ArrayList<Integer> mmc;
	public MMC(){
		mmc = new ArrayList<Integer>();
	}
	@Override
	public void strategy(String tmp){
		this.number = tmp;
		try{
			int num = Integer.parseInt(tmp);
			for(int i = 1;i <= num;i++)
				if(num % i == 0)
					mmc.add(i);
		}catch(Exception e){sysout(e.toString());}		
	}	
	
	private void sysout(String error){ //O método oriundo da interface.
		JOptionPane.showMessageDialog(null,error);
	}
	
	@Override
	public void result(){ //O método oriundo da interface.
		for(Integer nt: this.mmc)
			System.out.println(nt+" eh um multiplo de "+this.number);
	}
}
/*
 * O Strategy ele funciona de acordo com o objeto que você instancia,
 * ele lembra um pouco o Factory Method, porém diferente do Factory
 * Method que possue estrutura identica, o Strategy tem apenas um método
 * em comum com as outras classes, e de acordo com o objeto que você
 * instancia, esse método se comporta de um jeito diferente.
 * */


