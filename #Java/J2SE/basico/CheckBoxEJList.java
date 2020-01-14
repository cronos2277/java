import java.util.*;
import javax.swing.*;
import java.awt.*;

class principal extends JFrame implements Runnable{
	public void principal1(){
		//Array da lista.	
		String [] lista = new String [2];
		lista[0] = "Ítem lista um da lista";
		lista[1] = "Ítem lista dois da lista";
		
		//Array da Opção.
		String [] opcao = new String [2];
		opcao[0] = "Ítem opção número um da lista";
		opcao[1] = "Ítem opção número dois da lista";
		
		//JFrame Options.
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame janela = new JFrame("Janela");
		janela.setVisible(true);
		janela.setSize(600,100);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		
		//JList
		JList listad = new JList(lista);
		
		//JComboBox
		JComboBox caixa = new JComboBox(opcao);
		
		//Ajustando janela.
		JPanel panel1 = new JPanel();
		panel1.add(caixa);
		JPanel panel2 = new JPanel();
		panel2.add(listad);
		janela.getContentPane().setLayout(new GridLayout(1,1));
		janela.getContentPane().add(panel1);
		janela.getContentPane().add(panel2);
		
		}

	@Override
	public void run() {
		this.principal1();
	}
	
	}


public class CheckBoxEJList extends principal{
	public static void main(String [] args){
		principal p1 = new principal();
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p1);
		t1.start();
		t2.start();
	}
}
